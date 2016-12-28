package core;

/**
 * Created by TangJiong on 2016/1/2.
 * 局部作用域
 */
public class LocalScope extends BaseScope {

    public LocalScope(Scope enclosingScope) {
        super(enclosingScope);
    }

    @Override
    public String getScopeName() {
        return "locals";
    }
}
