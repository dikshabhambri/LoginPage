package com.joey.mdsl.forgotpassexercise;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class UpdateQuestionsPage extends JFrame {

	private JPanel contentPane;
	private JTextField question1;
	private JButton submitButton;
	private JLabel errorLabel;
	private JTextField answer1;
	private JLabel lblAnswer;
	private JLabel lblQuestion;
	private JLabel lblAnswer_1;
	private JTextField question2;
	private JTextField answer2;
	private JLabel lblQuestion_1;
	private JLabel lblAnswer_2;
	private JTextField question3;
	private JTextField answer3;
	private JButton btnReturnToLog;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateQuestionsPage frame = new UpdateQuestionsPage("");
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
	public UpdateQuestionsPage(final String username) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 373, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);

	
		JLabel titleLabel = new JLabel("Security Questions");
		titleLabel.setForeground(Color.BLACK);
		titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(84, 11, 200, 31);
		contentPane.add(titleLabel);

		question1 = new JTextField();
		question1.setBounds(149, 87, 218, 28);
		contentPane.add(question1);
		question1.setColumns(10);

		JLabel q1Label = new JLabel("Question 1");
		q1Label.setFont(new Font("Tahoma", Font.BOLD, 14));
		q1Label.setForeground(Color.BLACK);
		q1Label.setHorizontalAlignment(SwingConstants.CENTER);
		q1Label.setBounds(0, 86, 125, 28);
		contentPane.add(q1Label);


		submitButton = new JButton("Submit");
		submitButton.setBackground(Color.WHITE);
		submitButton.setBounds(136, 353, 89, 36);
		contentPane.add(submitButton);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBounds(10, 113, 337, 2);
		contentPane.add(separator);
		
		errorLabel = new JLabel("Please fill in all questions and answers.");
		errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		errorLabel.setForeground(Color.RED);
		errorLabel.setBounds(35, 396, 312, 31);
		errorLabel.setVisible(false);
		contentPane.add(errorLabel);

		

		answer1 = new JTextField();
		answer1.setBounds(149, 127, 218, 28);
		contentPane.add(answer1);
		answer1.setColumns(10);
		
		lblAnswer = new JLabel("Answer 1");
		lblAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnswer.setForeground(Color.BLACK);
		lblAnswer.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAnswer.setBounds(0, 125, 125, 28);
		contentPane.add(lblAnswer);
		
		lblQuestion = new JLabel("Question 2");
		lblQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuestion.setForeground(Color.BLACK);
		lblQuestion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblQuestion.setBounds(0, 180, 125, 28);
		contentPane.add(lblQuestion);
		
		lblAnswer_1 = new JLabel("Answer 2");
		lblAnswer_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnswer_1.setForeground(Color.BLACK);
		lblAnswer_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAnswer_1.setBounds(0, 220, 125, 28);
		contentPane.add(lblAnswer_1);
		
		question2 = new JTextField();
		question2.setColumns(10);
		question2.setBounds(149, 181, 218, 28);
		contentPane.add(question2);
		
		answer2 = new JTextField();
		answer2.setColumns(10);
		answer2.setBounds(149, 221, 218, 28);
		contentPane.add(answer2);
		
		lblQuestion_1 = new JLabel("Question 3");
		lblQuestion_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuestion_1.setForeground(Color.BLACK);
		lblQuestion_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblQuestion_1.setBounds(0, 272, 125, 28);
		contentPane.add(lblQuestion_1);
		
		lblAnswer_2 = new JLabel("Answer 3");
		lblAnswer_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnswer_2.setForeground(Color.BLACK);
		lblAnswer_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAnswer_2.setBounds(0, 312, 125, 28);
		contentPane.add(lblAnswer_2);
		
		question3 = new JTextField();
		question3.setColumns(10);
		question3.setBounds(149, 273, 218, 28);
		contentPane.add(question3);
		
		answer3 = new JTextField();
		answer3.setColumns(10);
		answer3.setBounds(149, 313, 218, 28);
		contentPane.add(answer3);
		
		btnReturnToLog = new JButton("Return to Profile");
		btnReturnToLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					new WelcomePage(username);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnReturnToLog.setBounds(112, 427, 133, 31);
		btnReturnToLog.setVisible(false);
		contentPane.add(btnReturnToLog);
		
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String a1 = answer1.getText();
				String a2 = answer2.getText();
				String a3 = answer3.getText();
				
				if (a1.equals("") || a2.equals("") || a3.equals("")) {
					errorLabel.setText("Please fill in all questions and answers.");
					errorLabel.setVisible(true);
					return;
				} else {
					errorLabel.setText("Secuity questions set.");
					errorLabel.setVisible(true);
					btnReturnToLog.setVisible(true);
					errorLabel.setForeground(Color.GREEN);
					errorLabel.setBounds(30, 396, 312, 31);
					return;
					
				}
				
			
			}
		});

	}
}
