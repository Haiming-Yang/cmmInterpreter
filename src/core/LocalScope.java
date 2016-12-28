package core;

/**
 * Created by steveyyy on 2016/12/29.
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
