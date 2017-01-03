package core;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by steveyyy on 2016/12/29.
 */
public abstract class BaseSymbolList implements SymbolList {

    SymbolList enclosingSymbolList; // null if global (outermost) symbolList
    Map<String, Symbol> symbols = new LinkedHashMap<String, Symbol>();

    public BaseSymbolList(SymbolList enclosingSymbolList) { this.enclosingSymbolList = enclosingSymbolList;  }

    public Symbol resolve(String name) {
        Symbol s = symbols.get(name);
        if ( s!=null ) return s;
        // if not here, check any enclosing symbolList
        if ( enclosingSymbolList != null ) return enclosingSymbolList.resolve(name);
        return null; // not found
    }

    public void define(Symbol sym) {
        symbols.put(sym.name, sym);
        sym.symbolList = this; // track the symbolList in each symbol
    }

    public boolean redundant(String name){
        return symbols.get(name) != null;
    }

    public SymbolList getEnclosingSymbolList() { return enclosingSymbolList; }

    public String toString() { return getScopeName()+":"+symbols.values().toString(); }
}
