package com.joey.mdsl.forgotpassexercise;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

class LoginPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameo;
	private JButton submitButton;
	private JLabel errorLabel;
	private File file2;
	private JPasswordField passwordo;

	public LoginPage() throws IOException {

		
		super("Login Screen");
		
		setResizable(false);
		setVisible(true);
	
		file2 = new File("file2.txt");

	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 373, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		usernameo = new JTextField();
		usernameo.setBounds(105, 106, 200, 31);
		contentPane.add(usernameo);
		usernameo.setColumns(10);
		

		JLabel titleLabel = new JLabel("Login Screen");
		titleLabel.setForeground(Color.BLACK);
		titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(90, 37, 200, 31);
		contentPane.add(titleLabel);

		JLabel unameSignInLabel = new JLabel("Username");
		unameSignInLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		unameSignInLabel.setHorizontalAlignment(SwingConstants.CENTER);
		unameSignInLabel.setForeground(Color.BLACK);
		unameSignInLabel.setBounds(20, 106, 63, 31);
		contentPane.add(unameSignInLabel);


		submitButton = new JButton("Login");
		submitButton.setBackground(Color.WHITE);
		submitButton.setBounds(62, 237, 88, 39);
		contentPane.add(submitButton);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBackground(Color.WHITE);
		separator.setBounds(-19, 200, 309, 2);
		contentPane.add(separator);

		errorLabel = new JLabel("Please enter a valid username and password.");
		errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		errorLabel.setForeground(Color.RED);
		errorLabel.setBounds(34, 306, 316, 31);
		errorLabel.setVisible(false);
		contentPane.add(errorLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setBounds(20, 149, 63, 31);
		contentPane.add(lblPassword);
		
		passwordo = new JPasswordField();
		passwordo.setBounds(105, 149, 200, 27);
		contentPane.add(passwordo);
		
		JButton btnForgotPassword = new JButton("Forgot Password");
		btnForgotPassword.setBackground(Color.WHITE);
		btnForgotPassword.setBounds(206, 237, 133, 39);
		contentPane.add(btnForgotPassword);
		
		

		passwordo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String username = usernameo.getText();
				String password = passwordo.getText();
				
				if (username.equals("") && !(password.equals("password")) ) {
					errorLabel.setText("Please enter a valid username and password.");
					errorLabel.setVisible(true);
					return;
				}
				if (username.equals("Joey") && password.equals("password")) {
					dispose();
					new QuestionsPage();
				}
			}
		});
		
		usernameo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String username = usernameo.getText();
				String password = passwordo.getText();
				
				if (username.equals("") && !(password.equals("password")) ) {
					errorLabel.setText("Please enter a valid username and password.");
					errorLabel.setVisible(true);
					return;
				}
				if (username.equals("Joey")) {
					dispose();
					new QuestionsPage();
				}
			}
		});
		
		btnForgotPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String username = usernameo.getText();
				
			
				dispose();
				try {
					new ForgotPassPage();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
			}
		});


		
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String username = usernameo.getText();
				String password = passwordo.getText();
				if (username.equals("") && !(password.equals("password")) ) {
					errorLabel.setText("Please enter a valid username and password.");
					errorLabel.setVisible(true);
					return;
				}
				if (username.equals("Joey")) {
					dispose();
					try {
						new WelcomePage(username);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				Scanner s = null;
				try {
					s = new Scanner(file2);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				while (s.hasNext()) {
					String temp = s.nextLine();
					String[] userPass = temp.split(", ");
					String user = userPass[0];
					if (username.equals(user)) {
						dispose();
						new QuestionsPage();
					} else {
						errorLabel.setText("Please enter a valid username.");
						errorLabel.setVisible(true);
					}
				}

				
				
			
			}
		});

		
	}

	public static void main(String[] args) throws IOException {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
