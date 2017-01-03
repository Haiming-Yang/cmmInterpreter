package core;

/**
 * Created by steveyyy on 2016/12/29.
 */
public interface SymbolList {

    String getScopeName();

    /** Where to look next for symbols */
    SymbolList getEnclosingSymbolList();

    /** Define a symbol in the current symbolList */
    void define(Symbol sym);

    /** Determine redundant definition in same symbolList */
    boolean redundant(String name);

    /** Look up name in this symbolList or in enclosing symbolList if not here */
    Symbol resolve(String name);

}
