package core;

/**
 * Created by steveyyy on 2016/12/29.
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
