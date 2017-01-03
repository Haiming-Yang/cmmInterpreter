package IO;

import GUI.IoInput;
import core.IOInterface;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class ConsoleIO implements IOInterface {
    private JTextPane textArea = null;

    public ConsoleIO(JTextPane textarea) {
        this.textArea = textarea;
    }

    @Override
    public String input() {
        System.out.print("waiting input ");
        String input = "";
        IoInput input_window = new IoInput(input);
        input_window.setVisible(true);
        // System.out.println("hello"+input);
        // System.out.println(input_window.input);
        return input_window.input;
    }

    @Override
    public void output(Object obj) {

        Document docs = textArea.getDocument();
        try {
            docs.insertString(docs.getLength(),obj.toString()+"\n", null);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
        textArea.revalidate();

    }
}
