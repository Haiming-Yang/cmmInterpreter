package GUI;

import IO.ConsoleIO;
import IO.LLVMIO;
import core.Interpreter;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

/*
 *  jammie luo
 *  
 */

public class MainGui {

	private JFrame frmKtom;
	private JToolBar toolBar;
	private ArrayList<onefile> files = null;
	private ArrayList<JButton> map_of_tabs = null;
	private onefile carefile = null;
	private JTextPane textArea = null;
	ConsoleIO lexIO = null;
	ConsoleIO consoleIO = null;
	 LLVMIO llvmIO = null;
	// 放置每一个文件对象的容器

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					MainGui window = new MainGui();

						window.frmKtom.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainGui() {
		initialize();
		// 初始化IO

		// String code="";
		// Compiler test = new Compiler(code,lexIO,consoleIO,llvmIO);
		// test.run();
		// llvmIO.print(llvmIO);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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
		frmKtom = new JFrame();
		frmKtom.setResizable(false);
		frmKtom.getContentPane().setBackground(SystemColor.windowBorder);
		frmKtom.getContentPane().setLayout(new BorderLayout(0, 0));
		frmKtom.getContentPane().setBackground(new Color(14 , 17, 18));
		toolBar = new JToolBar();
		toolBar.setRollover(true);
		toolBar.setFloatable(false);
		toolBar.setBorderPainted(false);
		toolBar.setBackground(new Color(24, 29, 34));
		toolBar.setPreferredSize(new Dimension(300, 45));


		frmKtom.getContentPane().add(toolBar, BorderLayout.NORTH);

		textArea = new JTextPane();
		JScrollPane scrollio = new JScrollPane(textArea);
		ConsoleIO lexIO = new ConsoleIO(textArea);
		ConsoleIO consoleIO = new ConsoleIO(textArea);

		textArea.setForeground(Color.WHITE);
		textArea.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		textArea.setEditable(false);
		textArea.setBackground(new Color(39, 40, 34));
		textArea.setPreferredSize(new Dimension(300, 200));
		scrollio.setBorder(BorderFactory.createEmptyBorder());
		scrollio.setPreferredSize(new Dimension(300, 200));
		frmKtom.getContentPane().add(scrollio, BorderLayout.SOUTH);

		// 菜单栏代码
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(UIManager.getColor("TextPane.disabledBackground"));
		menuBar.setBorderPainted(false);
		frmKtom.setJMenuBar(menuBar);

		JMenu menu = new JMenu("\u6587\u4EF6");
		menuBar.add(menu);

		// begin
		JMenuItem menuItem = new JMenuItem("\u6253\u5F00");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// open action listener
				JFileChooser jfc = new JFileChooser();
				jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				jfc.showDialog(new JLabel(), "选择txt文件");
				if (jfc.getSelectedFile() != null) {

					File file = jfc.getSelectedFile();
					byte[] bytes;
					String source = "";
					try {
						bytes = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
						source = new String(bytes);
					} catch (IOException e) {
						e.printStackTrace();
					}

					if (!files.isEmpty()) {
						Iterator<onefile> iterator = files.iterator();
						while (iterator.hasNext()) {
							iterator.next().setUnVisable();
						}
					}
					onefile onefile = new onefile(frmKtom, jfc.getSelectedFile().getName(), source);
					onefile.path =file.getAbsolutePath();
					files.add(onefile);
					onefile.init_gui();
					JButton button = new JButton(onefile.filename);
					button.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							clicktap(button, files.indexOf(onefile));
						}
					});
					Dimension btnsize = new Dimension(100, 45);
					button.setPreferredSize(btnsize);
					button.setMaximumSize(btnsize);
					button.setMinimumSize(btnsize);
					button.setForeground(new  Color(186, 190, 189));
					button.setBackground(new Color(17, 18, 19));
					Border border_bottom = BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(81, 154, 186));
					Border border_right = BorderFactory.createMatteBorder(0, 0, 0,2, new Color(19, 21, 23));
					Border mixborder = BorderFactory.createCompoundBorder(border_bottom, border_right);
					button.setBorder(mixborder);
					map_of_tabs.add(button);
					toolBar.add(button);
					frmKtom.getContentPane().revalidate();
					if(carefile==null) {
						carefile=onefile;
					}
					else{
						clicktap(button, files.indexOf(onefile));
					}

				}
			}
		});

		JMenuItem menuItem_1 = new JMenuItem("\u4FDD\u5B58");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(carefile.save(carefile.path)){
					JOptionPane.showMessageDialog(frmKtom, "save success");
				}else{
					JOptionPane.showMessageDialog(frmKtom, "save fail,初次保存请使用另存为");
				}

				// save
			}
		});
		JMenuItem menuItem_2 = new JMenuItem("\u53E6\u5B58\u4E3A");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// sava other
				//select window
				JFileChooser jfc = new JFileChooser();
				jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				jfc.showDialog(new JLabel(), "选择文件夹");
				if (jfc.getSelectedFile() != null) {
					//System.out.println(jfc.getSelectedFile().getAbsolutePath());
					String pathtosave =jfc.getSelectedFile().getAbsolutePath();
					carefile.save(pathtosave+"\\"+carefile.filename);
				}
			}
		});
		JMenuItem menuItem_3 = new JMenuItem("\u65B0\u5EFA");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// create action listener
				if (!files.isEmpty()) {

					Iterator<onefile> iterator = files.iterator();
					while (iterator.hasNext()) {
						iterator.next().setUnVisable();
					}
				}
				onefile file = new onefile(frmKtom, "new file.cmm");
				files.add(file);
				file.init_gui();


				JButton button = new JButton(file.filename);

				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						clicktap(button, files.indexOf(file));
					}
				});
				Dimension btnsize = new Dimension(100, 45);
				button.setPreferredSize(btnsize);
				button.setMaximumSize(btnsize);
				button.setMinimumSize(btnsize);
				button.setForeground(new  Color(186, 190, 189));
				button.setBackground(new Color(17, 18, 19));
				Border border_bottom = BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(81, 154, 186));
				Border border_right = BorderFactory.createMatteBorder(0, 0, 0,2, new Color(19, 21, 23));
				Border mixborder = BorderFactory.createCompoundBorder(border_bottom, border_right);
				button.setBorder(mixborder);
				map_of_tabs.add(button);
				toolBar.add(button);
				frmKtom.getContentPane().revalidate();
				if(carefile==null) {
					carefile=file;
				}
				else{
					clicktap(button, files.indexOf(file));
				}

			}
		});
		menu.add(menuItem_3);
		menu.add(menuItem);
		JMenuItem menuItem_4 = new JMenuItem("\u5173\u95ED");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// close action listner
				carefile.setUnVisable();
				int filenumber = files.indexOf(carefile);
				map_of_tabs.get(filenumber).setVisible(false);
				files.remove(carefile);
				map_of_tabs.remove(filenumber);
				if (!files.isEmpty()) {
					onefile temp = files.iterator().next();
					temp.setVisible();
					carefile = temp;
				}
				toolBar.revalidate();
			}
		});
		menu.add(menuItem_4);
		JMenuItem menuItem_5 = new JMenuItem("\u5168\u90E8\u5173\u95ED");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// close all listner
				carefile.setUnVisable();
				Iterator<JButton> iterator = map_of_tabs.iterator();
				while (iterator.hasNext()) {
					iterator.next().setVisible(false);
				}

				files.clear();
				map_of_tabs.clear();
				carefile = null;
				// if(files.isEmpty() && map_of_tabs.isEmpty()){
				// System.out.println("all close");
				// }

			}
		});
		menu.add(menuItem_5);
		menu.add(menuItem_1);
		menu.add(menuItem_2);
		// end

		JMenu menu_1 = new JMenu("\u8FD0\u884C");
		menuBar.add(menu_1);
		JMenuItem menuItem_6 = new JMenuItem("\u8FD0\u884C");
		JMenuItem menuItem_7 = new JMenuItem("\u505C\u6B62");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText("");
				carefile.setUnedit();
				menuItem_6.setEnabled(false);
				menuItem_7.setEnabled(true);
				//run create ir code
				//Compiler test = new Compiler(carefile.getcode(),lexIO,consoleIO,llvmIO);
				//test.run();
				// llvmIO.print(llvmIO);
//				consoleIO.output("hi");
//				llvmIO.output("llvm");
//				llvmIO.print(llvmIO);
//				consoleIO.input();
				LLVMIO llvmIO = new LLVMIO();
				Interpreter test = new Interpreter(carefile.getcode(),lexIO,consoleIO,llvmIO);
				test.run();
				menuItem_6.setEnabled(true);
				menuItem_7.setEnabled(false);
				carefile.setEnedit();
				llvmIO.print(llvmIO);
			}
		});
		menu_1.add(menuItem_6);


		menuItem_7.setEnabled(false);
		menu_1.add(menuItem_7);
		JMenu menu_2 = new JMenu("\u5E2E\u52A9");
		menuBar.add(menu_2);
		JMenuItem menuItem_8 = new JMenuItem("\u5173\u4E8E");
		menu_2.add(menuItem_8);
		menuItem_8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frmKtom,"Kitom\nPowerd by Jammie Luo and Steve Yang.");
			}
		});
		frmKtom.setTitle("Kitom");
		frmKtom.setBounds(100, 100, 1024, 768);
		frmKtom.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 装载文件窗口对象
		files = new ArrayList<onefile>();
		if (files.size() == 0) {
			onefile file0 = new onefile(frmKtom, "new file.cmm");
			carefile = file0;
			files.add(file0);
		}

		// 显示窗口
		files.get(0).init_gui();
		// 显示标签页栏
		JButton button1 = new JButton(files.get(0).filename);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clicktap(button1, 0);
			}
		});
		button1.setForeground(new  Color(186, 190, 189));
		button1.setBackground(new Color(17, 18, 19));
		button1.setSize(100, 45);
		Dimension btnsize = new Dimension(100, 45);
		button1.setPreferredSize(btnsize);
		button1.setMaximumSize(btnsize);
		button1.setMinimumSize(btnsize);
		Border border_bottom = BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(81, 154, 186));
		Border border_right = BorderFactory.createMatteBorder(0, 0, 0,2, new Color(19, 21, 23));
		Border mixborder = BorderFactory.createCompoundBorder(border_bottom, border_right);
		button1.setBorder(mixborder);
		button1.setFocusable(false);
		map_of_tabs = new ArrayList<JButton>();
		map_of_tabs.add(button1);
		toolBar.add(button1);
	}

	private void clicktap(JButton button_click, int number_file_click) {
		// System.out.println(files.indexOf(carefile));
		if (number_file_click != files.indexOf(carefile)) {
			//edit window 
			carefile.setUnVisable();
			files.get(number_file_click).setVisible();
			int oldcarefile = files.indexOf(carefile);
			carefile = files.get(number_file_click);
			files.get(number_file_click).revalidate();
			frmKtom.getContentPane().revalidate();
			//button change
			JButton oldcare = map_of_tabs.get(oldcarefile);
			Border border_right = BorderFactory.createMatteBorder(0, 0, 0,2, new Color(19, 21, 23));
			oldcare.setBorder(border_right);
			oldcare.setBackground(new Color(31, 35, 38));
			Border border_bottom = BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(81, 154, 186));
			Border mixborder = BorderFactory.createCompoundBorder(border_bottom, border_right);
			button_click.setBorder(mixborder);
			button_click.setBackground(new Color(17, 18, 19));
			button_click.revalidate();
			oldcare.revalidate();
			toolBar.revalidate();
		}
	}

}
