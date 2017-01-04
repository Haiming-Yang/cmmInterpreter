package IO;

import GUI.show_irc;
import core.IOInterface;

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by steveyyy on 2016/12/29.
 */
public class LLVMIO implements IOInterface {
    private JTextPane textArea = null;
    public ArrayList<String> llvmIRList = new ArrayList<String>();
    private ArrayList<String> inputList = new ArrayList<String>();
    public Map<String, Integer> varMap = new LinkedHashMap<String, Integer>();
    private int SSACode = 1;
    private int inputIndex = -1;
    private boolean writeOrNot = false;
    private boolean everWriteInt = false;
    private boolean everWriteDouble = false;

    public void setEverWriteInt() {
        this.everWriteInt = true;
    };

    public boolean getEverWriteInt() {
        return this.everWriteInt;
    };

    public void setEverWriteDouble() {
        this.everWriteDouble = true;
    };

    public boolean getEverWriteDouble() {
        return this.everWriteDouble;
    };

    public void setWriteOrNot(boolean flag) {
        this.writeOrNot = flag;
    }

    public boolean getWriteOrNot() {
        return this.writeOrNot;
    }

    private boolean intOrNot = false;

    public void setIntOrNot() {
        this.intOrNot = true;
    }

    public boolean getIntOrNot() {
        return this.intOrNot;
    }

    private boolean doubleOrNot = false;

    public void setDoubleOrNot() {
        this.doubleOrNot = true;
    }

    public boolean getDoubleOrNot() {
        return this.doubleOrNot;
    }

    public void addInputList(String i) {

        inputList.add(i);

    }

    public String getInput() {
        inputIndex++;
        return inputList.get(inputIndex);

    }


    public void setSSA(int a) {
        SSACode = a;

    }

    public void selfAddSSA() {
        SSACode++;

    }

    public int getSSA() {
        return SSACode;
    }

    @Override
    public String input() {
        return null;
    }

    @Override
    public void output(Object out) {
        llvmIRList.add((String) out);

    }

    public void output(int i, String out) {
        llvmIRList.add(i, out);
    }

    public void print(IOInterface llvmIO) {


        if(llvmIRList.size()>0) {
            show_irc showcode = new show_irc(llvmIRList);
            showcode.setVisible(true);
        }

    }
}
