package GUI;

import javax.swing.JTextPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class LineNumListen implements DocumentListener{
	private  JTextPane lines = null;
	private  JTextPane editor = null;


	public LineNumListen(JTextPane lines,JTextPane editor){
		this.lines = lines;
		this.editor = editor;
	}
	@Override
	public void changedUpdate(DocumentEvent arg0) {
		// TODO 自动生成的方法存根
		String linesnumber="1";
		for(int i = 1;i <= editor.getDocument().getDefaultRootElement().getElementCount();i++){
			if(i != 1)linesnumber += ("\n"+i);
			//System.out.println(i);
		}
		lines.setText(linesnumber);

	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		// TODO 自动生成的方法存根

	}

}
