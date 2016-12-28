/**
 * grammar for cmm language
 * By
 * 唐炯 2013302580231,
 * 张子谦 2013302580241,
 * 易晓轩 2013302580221
 */
grammar cmm;

// ============文法定义==============================
program : (stmt)+ ; // 程序，由语句组成
stmt : var_decl |
		if_stmt |
		while_stmt |
		break_stmt |
		assign_stmt |
		read_stmt |
		write_stmt |
		stmt_block ;   //语句
stmt_block : LBigBracket (stmt)+ RBigBracket ;      //语句块
var_decl : type varlist LineEnd ;    //变量申明
type : Int | Real ; //类型
varlist : (Ident | decl_assign | array)(Comma (Ident | decl_assign | array))* ; // 变量列表
decl_assign : Ident Assign expr ; //声明同时赋值
//if_stmt : If LBracket expr RBracket (stmt | stmt_block) (Else (stmt | stmt_block))? ;
if_stmt : If LBracket expr RBracket stmt #I_S | // 拆开好实现一点
            If LBracket expr RBracket stmt_block #I_SB |
            If LBracket expr RBracket stmt Else stmt #I_S_E_S|
            If LBracket expr RBracket stmt Else stmt_block #I_S_E_SB|
            If LBracket expr RBracket stmt_block Else stmt #I_SB_E_S|
            If LBracket expr RBracket stmt_block Else stmt_block #I_SB_E_SB;
while_stmt : While LBracket expr RBracket (stmt | stmt_block) ;
break_stmt : Break LineEnd ;
read_stmt : Read LBracket (Ident | array) RBracket LineEnd ;
write_stmt : Write LBracket expr RBracket LineEnd;
assign_stmt : value Assign expr LineEnd ;
value : Ident | array | constant;
array : Ident LMidBracket (IntConstant | expr) RMidBracket ;
constant : IntConstant | RealConstant ;
expr : expr MulDivMod expr #MulDivExpr | //乘除，取模运算
        expr AddMin expr #AddMinExpr | // 加减运算，正负号
        expr CompOp expr #CompareExpr | // 比较运算
		LBracket expr RBracket #ParenthesesExpr | //括号运算
		value #ValueExpr | // 值
		AddMin expr #SignExpr ;

// ===========词素定义=================================
// 关键字(保留字)
If : 'if' ;
Else : 'else' ;
While : 'while' ;
Read : 'read' ;
Write : 'write' ;
Int : 'int' ;
Real : 'real' ;
Break : 'break' ;
// 标识符
Ident :  [a-zA-Z]([a-zA-Z] | '_' | [0-9])*;
// 常量
IntConstant : '0' | [1-9][0-9]*;  //带符号，base 10，暂未实现base 16
RealConstant : IntConstant('.'([0-9]+))? ; //带符号
BooleanConstant : 'true' | 'false' ;
// 操作符
CompOp : '<=' | '>=' | '>' | '<' | '!=' | '==' | '<>' ; //比较
MulDivMod : '*' | '/' | '%'; //一级运算 乘除取模
AddMin : '+' | '-' ; //二级运算 加减 正负号
// 括号
LBracket : '(' ;
RBracket : ')' ;
LBigBracket : '{' ;
RBigBracket : '}' ;
LMidBracket : '[' ;
RMidBracket : ']' ;
// 赋值
Assign : '=' ;
// 分号，语句结束
LineEnd : ';' ;
// 逗号，变量分隔
Comma : ',' ;
// 空格
WS : [' '\t\r\n]+ -> skip ;
// 注释
SL_COMMENT :   '//' ~[\r\n]* -> skip;
MUL_COMMENT :   '/*' .*? '*/' -> skip;