package core;

import antlr.cmmLexer;

/**
 * Created by steveyyy on 2016/12/29.
 */
public class TokenDictionary {

    public static String getTokenType(int typeCode){

        String type = null;

        switch(typeCode){
            case cmmLexer.If:
            case cmmLexer.Else:
            case cmmLexer.While:
            case cmmLexer.Read:
            case cmmLexer.Write:
            case cmmLexer.Int:
            case cmmLexer.Real:
            case cmmLexer.Break:
                type = "keyword";
                break;
            case cmmLexer.Ident:
                type = "identifier";
                break;
            case cmmLexer.IntConstant:
                type = "int constant";
                break;
            case cmmLexer.RealConstant:
                type = "real constant";
                break;
            case cmmLexer.BooleanConstant:
                type = "boolean constant";
                break;
            case cmmLexer.MulDivMod:
            case cmmLexer.CompOp:
            case cmmLexer.AddMin:
                type = "operator";
                break;
            case cmmLexer.LBracket:
            case cmmLexer.RBracket:
            case cmmLexer.LBigBracket:
            case cmmLexer.RBigBracket:
            case cmmLexer.LMidBracket:
            case cmmLexer.RMidBracket:
                type = "bracket";
                break;
            case cmmLexer.Assign:
                type = "assign symbol";
                break;
            case cmmLexer.LineEnd:
                type = "semicolon";
                break;
            case cmmLexer.Comma:
                type = "comma";
                break;
            case cmmLexer.WS:
                type = "white space";
                break;
            case cmmLexer.SL_COMMENT:
            case cmmLexer.MUL_COMMENT:
                type = "comment";
                break;
            default:
                type = "unknown type";
                break;

        }

        return type;

    }

}
