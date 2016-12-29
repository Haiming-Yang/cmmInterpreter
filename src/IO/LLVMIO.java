package IO;

import core.IOInterface;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by steveyyy on 2016/12/29.
 */
public class LLVMIO implements IOInterface {

    public ArrayList<String> llvmIRList = new ArrayList<String>();
    public Map<String,Integer> varMap = new LinkedHashMap<String,Integer>();
    private  int SSACode = 1;
    public void setSSA(int a){
        SSACode = a;

    }
    public void selfAddSSA(){
        SSACode ++;

    }
    public int getSSA(){
        return  SSACode;
    }
    @Override
    public String input() {
        return null;
    }

    @Override
    public void output(Object out) {
        llvmIRList.add((String) out);

    }
    public void output(int i, String out){
        llvmIRList.add(i,out);
    }
    public  void print(IOInterface llvmIO){
        for (String o:llvmIRList
                ) {
            System.out.println(o);
        }

    }
}
