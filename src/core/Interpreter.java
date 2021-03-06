package core;

import IO.LLVMIO;
import antlr.cmmLexer;
import antlr.cmmParser;
import org.antlr.v4.gui.Trees;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.ArrayList;

/**
 * Created by steveyyy on 2016/12/29.
 */
public class Interpreter {

    private boolean showLexerResult = true;
    private boolean showAST = false;
    private String source;
    private IOInterface lexIo;
    private IOInterface consoleIo;
    private  LLVMIO llvmIO;

    public Interpreter(String source, IOInterface lexIo, IOInterface consoleIo, LLVMIO llvmIO){
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
            DefListener defListener = new DefListener(consoleIo,llvmIO);
            walker.walk(defListener, parseTree);

            // 引用计算阶段改为visitor的方式
            RuntimeVisitor RuntimeVisitor = new RuntimeVisitor(defListener.globals,
                    defListener.symbolList,
                    consoleIo,llvmIO);
            RuntimeVisitor.visit(parseTree);
           // RuntimeVisitor.
            parser.reset();
            //=================LLVM IR生成======================
            if(defListener.defSucOrNot&&RuntimeVisitor.runSucOrNot) {
                DefListener llvmListener = new DefListener(consoleIo, llvmIO);
                walker.walk(llvmListener, parseTree);
                LLVMVisitor llvmVisitor = new LLVMVisitor(llvmListener.globals,
                        llvmListener.symbolList,
                        consoleIo, llvmIO);
                llvmVisitor.visit(parseTree);
            }
            else {
                consoleIo.output("ERROR OCCOURED, LLVM IRCODE WILL NOT GENERATE.");
            }


        }catch (Exception e){
            consoleIo.output(e.getMessage());

                e.printStackTrace();

        }


    }

    public void setShowLexerResult(boolean showLexerResult) {
        this.showLexerResult = showLexerResult;
    }
    public void setShowAST(boolean showAST) {
        this.showAST = showAST;
    }
//   //主函数
//    public static void main(String[] args) throws IOException {
//
//        byte[] bytes = Files.readAllBytes(Paths.get("./test.cmm"));
//        String source = new String(bytes);
//        System.out.println(source);
//
//
//        ConsoleIO lexIO = new ConsoleIO();
//        ConsoleIO consoleIO = new ConsoleIO();
//        LLVMIO llvmIO = new LLVMIO();
//        Interpreter test = new Interpreter(source,lexIO,consoleIO,llvmIO);
//        test.run();
//        llvmIO.print(llvmIO);
//
//
//    }


}
