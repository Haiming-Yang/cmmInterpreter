package core;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by TangJiong on 2016/1/2.
 * 作用域基类
 */
public abstract class BaseScope implements Scope {

    Scope enclosingScope; // null if global (outermost) scope
    Map<String, Var> symbols = new LinkedHashMap<String, Var>();

    public BaseScope(Scope enclosingScope) { this.enclosingScope = enclosingScope;  }

    public Var resolve(String name) {
        Var s = symbols.get(name);
        if ( s!=null ) return s;
        // if not here, check any enclosing scope
        if ( enclosingScope != null ) return enclosingScope.resolve(name);
        return null; // not found
    }

    public void define(Var sym) {
        symbols.put(sym.name, sym);
        sym.scope = this; // track the scope in each symbol
    }

    public boolean redundant(String name){
        return symbols.get(name) != null;
    }

    public Scope getEnclosingScope() { return enclosingScope; }

    public String toString() { return getScopeName()+":"+symbols.values().toString(); }
}
