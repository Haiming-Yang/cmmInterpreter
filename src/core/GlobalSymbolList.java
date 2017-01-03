package core;

/**
 * Created by steveyyy on 2016/12/29.
 */
public class GlobalSymbolList extends BaseSymbolList {

    public GlobalSymbolList(SymbolList enclosingSymbolList) {
        super(enclosingSymbolList);
    }

    @Override
    public String getScopeName() {
        return "globals";
    }
}
