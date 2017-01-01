package core;

import IO.ConsoleIO;
import  IO.LLVMIO;
import antlr.cmmLexer;
import antlr.cmmParser;
import org.antlr.v4.gui.Trees;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Created by steveyyy on 2016/12/29.
 */
public class Compiler {

    private boolean showLexerResult = true;
    private boolean showAST = false;
    private String source;
    private IOInterface lexIo;
    private IOInterface consoleIo;
    private  LLVMIO llvmIO;

    public Compiler(String source, IOInterface lexIo, IOInterface consoleIo,LLVMIO llvmIO){
        this.source = source;
        this.lexIo = lexIo;
        this.consoleIo = consoleIo;
        this.llvmIO = llvmIO;

    }

    public void run(){

        try{

            consoleIo.output("====== compiler starting... ======");

            cmmLexer lexer = new cmmLexer(new ANTLRInputStream(source));

            // ===================== 词法分析 =======================
            if(showLexerResult){
                lexIo.output("====== lexer analysis result: ======");
                lexIo.output("Token\tLine\tType");
                ArrayList<Token> tokenList = (ArrayList<Token>) lexer.getAllTokens();
                for(Token token : tokenList){
                //通过类型字典以及getType返回的数字得到具体类型。
                    lexIo.output(token.getText() + "\t" + token.getLine()
                            + "\t" + TokenDictionary.getTokenType(token.getType()));

                }
                //Reset the stream so that it's in the same state it was when the object was created
                lexer.reset();
            }

            // =================== 语法分析 =======================
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            cmmParser parser = new cmmParser(tokenStream);
            ParseTree parseTree = parser.program();
            if(showAST){
                consoleIo.output("====== show tree ======");
                Trees.inspect(parseTree, parser);
            }
            ParseTreeWalker walker = new ParseTreeWalker();

            // 定义阶段，语法分析，将变量放入符号表
            DefPhaseListener defPhaseListener = new DefPhaseListener(consoleIo,llvmIO);
            walker.walk(defPhaseListener, parseTree);

            // 引用计算阶段改为visitor的方式
            RefPhaseVisitor refPhaseVisitor = new RefPhaseVisitor(defPhaseListener.globals,
                    defPhaseListener.scopes,
                    consoleIo,llvmIO);
            refPhaseVisitor.visit(parseTree);
           // refPhaseVisitor.
            parser.reset();
            //=================LLVM IR生成======================
                LLVMVisitor llvmVisitor = new LLVMVisitor(defPhaseListener.globals,
                        defPhaseListener.scopes,
                        consoleIo,llvmIO);
            llvmVisitor.visit(parseTree);
        }catch (Exception e){
            consoleIo.output(e.getMessage());
            if(Constant.LLVM){
                e.printStackTrace();
            }
        }


    }

    public void setShowLexerResult(boolean showLexerResult) {
        this.showLexerResult = showLexerResult;
    }
    public void setShowAST(boolean showAST) {
        this.showAST = showAST;
    }
   //主函数
    public static void main(String[] args) throws IOException {

        byte[] bytes = Files.readAllBytes(Paths.get("./test.cmm"));
        String source = new String(bytes);
        System.out.println(source);


        ConsoleIO lexIO = new ConsoleIO();
        ConsoleIO consoleIO = new ConsoleIO();
        LLVMIO llvmIO = new LLVMIO();
        Compiler test = new Compiler(source,lexIO,consoleIO,llvmIO);
        test.run();
        llvmIO.print(llvmIO);


    }


}
