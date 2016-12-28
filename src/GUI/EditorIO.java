package GUI ;

import core.IOInterface;

import javax.swing.*;

/**
 * Created by TangJiong on 2016/1/4.
 * IO接口的Editor实现
 */
public class EditorIO implements IOInterface {

    private JTextArea outputArea;

    public EditorIO(JTextArea outputArea) {
        this.outputArea = outputArea;
    }

    @Override
    public String input() {
        return JOptionPane.showInputDialog(null, "Please Input Here!");
    }

    @Override
    public void output(Object out) {
        outputArea.append(out.toString()+"\n");
    }
}
