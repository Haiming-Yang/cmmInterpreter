package IO;

import core.IOInterface;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by steveyyy on 2016/12/29.
 */
public class LLVMIO implements IOInterface {

    private ArrayList<String> llvmIRList = new ArrayList<String>();
    private ArrayList<String> inputList = new ArrayList<String>();
    private int i = -1;
    public void addInputList (String i){

            inputList.add(i);

    }
    public String getInput(){
        i++;
        return inputList.get(i);

    }
    public Map<String,Integer> varMap = new LinkedHashMap<String,Integer>();
    private  int SSACode = 1;
    private boolean writeOrNot = false;
    public void  setWriteOrNot(boolean flag){
        this.writeOrNot = flag;
    }
    public boolean getWriteOrNot(){
        return  this.writeOrNot;
    }
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
