package core;

import antlr.cmmParser;

/**
 * Created by TangJiong on 2015/11/30.
 * A dictionary for translating token type
 */
public class TokenDictionary {

    public static String getTokenType(int typeCode){

        String type = null;

        switch(typeCode){
            case cmmParser.If:
            case cmmParser.Else:
            case cmmParser.While:
            case cmmParser.Read:
            case cmmParser.Write:
            case cmmParser.Int:
            case cmmParser.Real:
            case cmmParser.Break:
                type = "keyword";
                break;
            case cmmParser.Ident:
                type = "identifier";
                break;
            case cmmParser.IntConstant:
                type = "int constant";
                break;
            case cmmParser.RealConstant:
                type = "real constant";
                break;
            case cmmParser.BooleanConstant:
                type = "boolean constant";
                break;
            case cmmParser.MulDivMod:
            case cmmParser.CompOp:
            case cmmParser.AddMin:
                type = "operator";
                break;
            case cmmParser.LBracket:
            case cmmParser.RBracket:
            case cmmParser.LBigBracket:
            case cmmParser.RBigBracket:
            case cmmParser.LMidBracket:
            case cmmParser.RMidBracket:
                type = "bracket";
                break;
            case cmmParser.Assign:
                type = "assign symbol";
                break;
            case cmmParser.LineEnd:
                type = "semicolon";
                break;
            case cmmParser.Comma:
                type = "comma";
                break;
            case cmmParser.WS:
                type = "white space";
                break;
            case cmmParser.SL_COMMENT:
            case cmmParser.MUL_COMMENT:
                type = "comment";
                break;
            default:
                type = "unknown type";
                break;

        }

        return type;

    }

}
