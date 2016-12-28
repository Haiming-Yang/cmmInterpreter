package core;

/**
 * Created by TangJiong on 2016/1/2.
 * 作用域接口
 */
public interface Scope {

    String getScopeName();

    /** Where to look next for symbols */
    Scope getEnclosingScope();

    /** Define a symbol in the current scope */
    void define(Symbol sym);

    /** Determine redundant definition in same scope */
    boolean redundant(String name);

    /** Look up name in this scope or in enclosing scope if not here */
    Symbol resolve(String name);

}
