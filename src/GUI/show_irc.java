package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class show_irc extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */



	/**
	 * Create the frame.
	 */
	public show_irc(	ArrayList<String> llvmIRList) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		setTitle("ircode");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 660);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);



		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBackground(new  Color(14, 17, 18));
		textPane.setForeground(new Color(186, 190, 189));
		textPane.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		textPane.setCaretColor(Color.WHITE);
		textPane.setSelectionColor(new Color(29, 91, 145));
		textPane.setSelectedTextColor(new Color(186, 190, 189));
		textPane.setBorder(BorderFactory.createEmptyBorder());
		for (String o : llvmIRList) {
			// System.out.println(o);
			Document docs = textPane.getDocument();
			try {
				docs.insertString(docs.getLength(), o + '\n', null);
			} catch (BadLocationException e) {
				e.printStackTrace();
			}
		}
		JScrollPane scrollPane = new JScrollPane(textPane);
		contentPane.add(scrollPane);


		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBorder(BorderFactory.createEmptyBorder());
		textPane_1.setForeground(Color.WHITE);
		textPane_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		textPane_1.setEditable(false);
		textPane_1.setBackground(new Color(39, 40, 34));

		JScrollPane scrollPane_1 = new JScrollPane(textPane_1);
		contentPane.add(scrollPane_1, BorderLayout.SOUTH);
		scrollPane_1.setPreferredSize(new Dimension(10,150));

		JButton btnNewButton = new JButton("save & run ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String path = "./output.ll";
				String shell = "lli "+path;
				//save .ll
				try {
					File file = new File(path);
					if(!file.exists()){
						System.out.println(path);
						file.createNewFile();
					}
					PrintStream ps = new PrintStream(new FileOutputStream(file));
					ps.println(textPane.getText());// 往文件里写入字符串
					ps.close();

				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();

				}

				//run .ll
				Process process = null;
				List<String> processList = new ArrayList<String>();
				try {
					process = Runtime.getRuntime().exec(shell);
					BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
					String line = "";
					while ((line = input.readLine()) != null) {
						processList.add(line);
					}
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

				for (String line : processList) {
					Document docs = textPane_1.getDocument();
					try {
						docs.insertString(docs.getLength(), line.toString()+"\n", null);
						System.out.println("...");
					} catch (BadLocationException e) {
						e.printStackTrace();
					}

				}
				textPane_1.revalidate();
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 16));
		scrollPane_1.setRowHeaderView(btnNewButton);



	}

}
