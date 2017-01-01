package core;

/**
 * Created by steveyyy on 2016/12/29.
 */
public interface Scope {

    String getScopeName();

    /** Where to look next for symbols */
    Scope getEnclosingScope();

    /** Define a symbol in the current scope */
    void define(Var sym);

    /** Determine redundant definition in same scope */
    boolean redundant(String name);

    /** Look up name in this scope or in enclosing scope if not here */
    Var resolve(String name);

}
