package core;

/**
 * Created by steveyyy on 2016/12/29.
 */
public class Symbol {

    String name;      // All symbols at least have a name
    Type type;
    SymbolList symbolList;      // All symbols know what symbolList contains them.
    Object value;


    public Symbol(String name) {
        this.name = name;
    }
    public Symbol(String name, Type type) {
        this(name);
        this.type = type;
    }
    public Symbol(String name, Type type, Object value){
        this(name, type);
        this.value = value;
    }

    public String getName() {
        return this.name;
    }

    public Object getValue() { return this.value; }
    public void setValue(Object value) {
        this.value = value;
    }

    public Type getType(){
        return type;
    }
    public void setType(Type _type){
        type = _type;
    }

}
