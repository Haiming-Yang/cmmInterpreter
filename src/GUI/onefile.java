package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.*;

public class onefile {
	public String filename;
	public String code="";
	public String path = null;
	private JTextPane editorPane = new JTextPane();
	private JScrollPane scroll = new JScrollPane(this.editorPane);
	private JTextPane lines = new JTextPane();
	private JScrollPane scroll2 = new JScrollPane(this.lines);
	private JFrame Jrame_to_set = null;


	onefile(JFrame frame,String filename){
		this.Jrame_to_set = frame;
		this.filename = filename;
	}

	onefile(JFrame frame,String filename,String code){
		this.Jrame_to_set = frame;
		this.filename = filename;
		this.code = code;
	}

	public void init_gui(){
		editorPane.setBackground(new  Color(14, 17, 18));
		editorPane.setForeground(new Color(186, 190, 189));
		editorPane.getDocument().addDocumentListener(new SyntaxHL(editorPane));
		editorPane.getDocument().addDocumentListener(new LineNumListen(lines, editorPane));
		editorPane.setText(code);
		editorPane.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		editorPane.setCaretColor(Color.WHITE);
		editorPane.setSelectionColor(new Color(29, 91, 145));
		editorPane.setSelectedTextColor(new Color(186, 190, 189));
		Jrame_to_set.getContentPane().add(scroll);
		lines.setBackground(new Color(8, 10, 12));
		lines.setForeground(new Color(81, 154, 186));
		lines.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lines.setEditable(false);
		lines.setEnabled(false);
		String linesnumber="";
		for(int i = 1;i <= editorPane.getDocument().getDefaultRootElement().getElementCount();i++){
			linesnumber += (" "+i+" "+"\n");
			//System.out.println(i);
		}
		lines.setText(linesnumber);
		scroll.getVerticalScrollBar().addAdjustmentListener(new LineNumberScrollListener(scroll2));
		EmptyBorder emptyBorder = (EmptyBorder)BorderFactory.createEmptyBorder();
		scroll.setBorder(emptyBorder);
		scroll2.setBorder(emptyBorder);;
		scroll2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		scroll2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.Jrame_to_set.getContentPane().add(scroll2, BorderLayout.WEST);


	}

	public void setVisible(){
		scroll.setVisible(true);
		scroll2.setVisible(true);
	}

	public void setUnVisable(){
		scroll.setVisible(false);
		scroll2.setVisible(false);


	}

	public void revalidate(){
		scroll.revalidate();
		scroll2.revalidate();
	}

	/*
	 * sava other place
	 */
	public boolean save(String path) {
		if(path == null){
			return false;
		}
		try {
			File file = new File(path);
			if(!file.exists()){
				System.out.println(path);
				file.createNewFile();
			}
			PrintStream ps = new PrintStream(new FileOutputStream(file));
			ps.println(editorPane.getText());// 往文件里写入字符串
			ps.close();
			return true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return false;
		}
	}

	public String getcode(){
		return this.editorPane.getText();
	}

	public void setUnedit(){
		this.editorPane.setEnabled(false);
	}

	public void setEnedit(){
		this.editorPane.setEnabled(true);
	}
}
