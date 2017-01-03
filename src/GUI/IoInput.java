package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import IO.ConsoleIO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		setBounds(100, 100, 400, 120);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(24, 29, 34));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIntput = new JLabel("intPut:");
		lblIntput.setFont(new Font("΢���ź�", Font.PLAIN, 17));
		lblIntput.setBounds(10, 10, 57, 30);
		lblIntput.setForeground(new Color(212, 215, 214));
		contentPane.add(lblIntput);
		
		textField = new JTextField();
		textField.setForeground(new Color(186, 190, 189));
		textField.setBackground(new Color(14,17,18));
		textField.setCaretColor(Color.WHITE);
		textField.setBorder(BorderFactory.createLineBorder(new Color(3, 3, 4),2));
		textField.setFont(new Font("����", Font.PLAIN, 16));
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
		btnNewButton.setFont(new Font("����", Font.PLAIN, 16));
		btnNewButton.setBounds(258, 52, 126, 30);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setForeground(new Color(212, 215, 214));
		btnNewButton.setBackground(new Color(31, 35, 38));
		btnNewButton.setFocusable(false);
		btnNewButton.setBorder(BorderFactory.createLineBorder(new Color(3, 3, 4),1));
		contentPane.add(btnNewButton);
	}
	
}
