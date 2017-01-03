lexer grammar cmmLexer;

//关键字
If : 'if' ;
Else : 'else' ;
While : 'while' ;
Read : 'read' ;
Write : 'write' ;
Int : 'int' ;
Double : 'double' ;
Break : 'break' ;
BooleanConstant : 'true' | 'false' ;
// 标识符
Ident :  [a-zA-Z]|[a-zA-Z_][a-zA-Z0-9_]*[a-zA-Z0-9] ;


// 操作符
CompOp : '<=' | '>=' | '>' | '<' | '!=' | '==' | '<>' ; //比较
MulDivMod : '*' | '/' ; //一级运算 乘除
AddMin : '+' | '-' ; //二级运算 加减

// 数值常量
IntConstant : ('1'..'9')('0'..'9')*|'0'
	   | '-'('1'..'9')('0'..'9')*
       ;
DoubleConstant : (IntConstant|'-0')'.'(([0-9]+))? ; //带符号
HexIntConstant :('0x'|'0X')(('0'..'9')|('A'..'F')|('a'..'f'))+;
HexDoubleConstant : ('0x'|'0X')(('0'..'9')|('A'..'F')|('a'..'f'))+('.')((('0'..'9')|('A'..'F')|('a'..'f'))+);

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