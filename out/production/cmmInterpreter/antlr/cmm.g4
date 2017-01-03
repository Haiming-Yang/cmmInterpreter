grammar cmm;
options { tokenVocab=CMMLexer; }



program : (stmt)+ ; // 程序，由语句组成
stmt :  var_decl
	 |  if_stmt
	 |  while_stmt
	 |  break_stmt
	 |  assign_stmt
	 |  read_stmt
	 |  write_stmt
	 |  stmt_block
	 ;   //语句


stmt_block : LBigBracket (stmt)* RBigBracket ;      //语句块
var_decl : type varlist LineEnd ;    //变量申明
type : Int | Double ; //类型
varlist : (Ident | decl_assign | array)(Comma (Ident | decl_assign | array))* ; // 变量列表
decl_assign : Ident Assign expr ; //声明同时赋值

if_stmt : If LBracket expr RBracket stmt #I_S
		| If LBracket expr RBracket stmt_block #I_SB
		| If LBracket expr RBracket stmt Else stmt #I_S_E_S
		| If LBracket expr RBracket stmt Else stmt_block #I_S_E_SB
        | If LBracket expr RBracket stmt_block Else stmt #I_SB_E_S
        | If LBracket expr RBracket stmt_block Else stmt_block #I_SB_E_SB
        ;
while_stmt : While LBracket expr RBracket (stmt | stmt_block) ;
break_stmt : Break LineEnd ;
read_stmt : Read LBracket (Ident | array) RBracket LineEnd ;
write_stmt : Write LBracket expr RBracket LineEnd;
assign_stmt : var Assign expr LineEnd ;
var : Ident | array ;
bool : BooleanConstant;
array : Ident LMidBracket (IntConstant | expr) RMidBracket ;
value : IntConstant | DoubleConstant | HexDoubleConstant | HexIntConstant ;
expr : expr MulDivMod expr #MulDivExpr | //乘除，取模运算
        expr AddMin expr #AddMinExpr | // 加减运算，正负号
        expr CompOp expr #CompareExpr | // 比较运算
		LBracket expr RBracket #ParenthesesExpr | //括号运算
		value #ValueExpr  | var #VarExpr | bool #BoolExpr;