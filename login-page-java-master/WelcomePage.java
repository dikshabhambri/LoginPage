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

class WelcomePage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton submitButton;
	private File file2;

	public WelcomePage(final String username) throws IOException {

	
		super("Welcome Page");
		setResizable(false);
		setVisible(true);
	
		file2 = new File("file2.txt");

	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 373, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		

		JLabel titleLabel = new JLabel("Welcome!, "+ username);
		titleLabel.setForeground(Color.BLACK);
		titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(90, 37, 200, 31);
		contentPane.add(titleLabel);

		JLabel unameSignInLabel = new JLabel("Edit your profile.");
		unameSignInLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		unameSignInLabel.setHorizontalAlignment(SwingConstants.CENTER);
		unameSignInLabel.setForeground(Color.BLACK);
		unameSignInLabel.setBounds(90, 126, 200, 31);
		contentPane.add(unameSignInLabel);


		submitButton = new JButton("Set Security Questions");
		submitButton.setBackground(Color.WHITE);
		submitButton.setBounds(114, 231, 160, 39);
		contentPane.add(submitButton);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBackground(Color.WHITE);
		separator.setBounds(-19, 200, 309, 2);
		contentPane.add(separator);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(133, 356, 117, 29);
		contentPane.add(btnLogOut);
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				dispose();
				try {
					new LoginPage();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});


		
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				dispose();
				new UpdateQuestionsPage(username);
				
//				if (username.equals("")) {
//					errorLabel.setText("Please enter a valid username.");
//					errorLabel.setVisible(true);
//					return;
//				}
//				if (username.equals("Joey")) {
//					dispose();
//					new QuestionsPage();
//				}
//
//				Scanner s = null;
//				try {
//					s = new Scanner(file2);
//				} catch (FileNotFoundException e) {
//					e.printStackTrace();
//				}
//				while (s.hasNext()) {
//					String temp = s.nextLine();
//					String[] userPass = temp.split(", ");
//					String user = userPass[0];
//					if (username.equals(user)) {
//						dispose();
//						new UpdateQuestionsPage();
//					} else {
//					
//					}
//				}

				
				
			
			}
		});

		
	}

	public static void main(String[] args) throws IOException {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomePage frame = new WelcomePage("");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
