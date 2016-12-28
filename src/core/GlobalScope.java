package core;

/**
 * Created by TangJiong on 2016/1/2.
 * 全局作用域
 */
public class GlobalScope extends BaseScope {

    public GlobalScope(Scope enclosingScope) {
        super(enclosingScope);
    }

    @Override
    public String getScopeName() {
        return "globals";
    }
}
