package core;

/**
 * Created by steveyyy on 2016/12/29.
 */
public class LocalSymbolList extends BaseSymbolList {


        public LocalSymbolList(SymbolList enclosingSymbolList) {
            super(enclosingSymbolList);
        }

        @Override
        public String getScopeName() {
            return "locals";
        }



}
