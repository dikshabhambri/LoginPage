package com.joey.mdsl.forgotpassexercise;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class NewPassPage extends JFrame {

	private JPanel contentPane;
	private JTextField passwordo;
	private JButton submitButton;
	private JLabel errorLabel;
	private File file2;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewPassPage frame = new NewPassPage();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 */
	public NewPassPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 373, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);

	
		JLabel titleLabel = new JLabel("New Password");
		titleLabel.setForeground(Color.BLACK);
		titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(73, 22, 200, 31);
		contentPane.add(titleLabel);

		passwordo = new JPasswordField();
		passwordo.setBounds(68, 152, 218, 28);
		contentPane.add(passwordo);
		passwordo.setColumns(10);

		JLabel q1Label = new JLabel("Please enter a new password.");
		q1Label.setFont(new Font("Tahoma", Font.BOLD, 14));
		q1Label.setForeground(Color.BLACK);
		q1Label.setHorizontalAlignment(SwingConstants.CENTER);
		q1Label.setBounds(53, 113, 245, 28);
		contentPane.add(q1Label);


		submitButton = new JButton("Submit");
		submitButton.setBackground(Color.WHITE);
		submitButton.setBounds(130, 247, 89, 36);
		contentPane.add(submitButton);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBounds(10, 113, 337, 2);
		contentPane.add(separator);
		
		btnNewButton = new JButton("Return to Log In");
		btnNewButton.setBounds(113, 412, 117, 36);
		btnNewButton.setVisible(false);
		contentPane.add(btnNewButton);
		

		errorLabel = new JLabel("You did not enter a valid password.");
		errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		errorLabel.setForeground(Color.RED);
		errorLabel.setBounds(29, 354, 312, 31);
		errorLabel.setVisible(false);
		contentPane.add(errorLabel);

		try {
			JLabel Background = new JLabel(new ImageIcon(ImageIO.read(new File(
					"background.jpg"))));
			Background.setBackground(Color.WHITE);
			Background.setBounds(0, 0, 357, 448);
			contentPane.add(Background);
			

		} catch (IOException e) {

		}
		
		passwordo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String password = passwordo.getText();
				if (password.equals("")) {
					errorLabel.setText("Please enter a valid password.");
					errorLabel.setBounds(35, 350, 290, 31);
					errorLabel.setVisible(true);
					return;
				} else {
					//Scanner sc = new Scanner(new File("file2"));
					errorLabel.setText("Password successfully changed.");
					passwordo.setEditable(false);
					submitButton.setEnabled(false);
					errorLabel.setForeground(Color.GREEN);
					errorLabel.setBounds(35, 350, 290, 31);
					errorLabel.setVisible(true);	
					btnNewButton.setVisible(true);
				}
				
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					new LoginPage();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		submitButton.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent ae) {
				String password = passwordo.getText();
				if (password.equals("")) {
					errorLabel.setText("Please enter a valid password.");
					errorLabel.setBounds(35, 350, 290, 31);
					errorLabel.setVisible(true);
					return;
				} else {
					
//					try {
//						if (!file2.exists()) {
//							System.out.println("We had to make a new file.");
//							file2.createNewFile();
//						}
//						FileWriter fileWriter = new FileWriter(file2, true);
//						BufferedWriter bufferedWriter = new BufferedWriter(
//								fileWriter);
//						bufferedWriter.write(password);
//						bufferedWriter.close();
					errorLabel.setText("Password successfully changed.");
					passwordo.setEditable(false);
					submitButton.setEnabled(false);
					errorLabel.setForeground(Color.GREEN);
					errorLabel.setBounds(35, 350, 290, 31);
					errorLabel.setVisible(true);	
					btnNewButton.setVisible(true);
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
//					
//						
				}
				
			}
		});

	}
}
