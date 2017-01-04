package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IoInput extends  JDialog {

	private JPanel contentPane;
	private JTextField textField;
	public String input=null;

	/**
	 * Create the frame.
	 */
	public IoInput(String inputs ) {
		this.input = inputs;
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setAlwaysOnTop(true);
		this.setModal(true);
		setTitle("Input window");
		setResizable(false);
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
		setBounds(100, 100, 400, 120);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(24, 29, 34));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblIntput = new JLabel("intPut:");
		lblIntput.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		lblIntput.setBounds(10, 10, 57, 30);
		lblIntput.setForeground(new Color(212, 215, 214));
		contentPane.add(lblIntput);

		textField = new JTextField();
		textField.setForeground(new Color(186, 190, 189));
		textField.setBackground(new Color(14,17,18));
		textField.setCaretColor(Color.WHITE);
		textField.setBorder(BorderFactory.createLineBorder(new Color(3, 3, 4),2));
		textField.setFont(new Font("宋体", Font.PLAIN, 16));
		textField.setBounds(77, 12, 309, 30);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("OK");
		btnNewButton.setIcon(null);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				input =  textField.getText();
				dispose();
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 16));
		btnNewButton.setBounds(258, 52, 126, 30);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setForeground(new Color(212, 215, 214));
		btnNewButton.setBackground(new Color(31, 35, 38));
		btnNewButton.setFocusable(false);
		btnNewButton.setBorder(BorderFactory.createLineBorder(new Color(3, 3, 4),1));
		contentPane.add(btnNewButton);
	}

}
