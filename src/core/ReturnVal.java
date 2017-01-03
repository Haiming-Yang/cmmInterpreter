package core;

/**
 * Created by steveyyy on 2016/12/29.
 */
public class ReturnVal {

    private Type type; // int or double
    private Object value;

    public ReturnVal() {
    }

    public ReturnVal(Type type, Object value) {
        this.type = type;
        this.value = value;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
