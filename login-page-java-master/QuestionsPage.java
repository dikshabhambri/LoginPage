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

public class QuestionsPage extends JFrame {

	private JPanel contentPane;
	private JTextField answer1;
	private JTextField answer2;
	private JTextField answer3;
	private JButton submitButton;
	private JLabel errorLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuestionsPage frame = new QuestionsPage();
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
	public QuestionsPage() {
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

		answer1 = new JTextField();
		answer1.setBounds(77, 81, 218, 28);
		contentPane.add(answer1);
		answer1.setColumns(10);

		answer2 = new JTextField();
		answer2.setBounds(77, 188, 218, 28);
		contentPane.add(answer2);
		answer2.setColumns(10);
		
		answer3 = new JTextField();
		answer3.setBounds(77, 268, 218, 28);
		contentPane.add(answer3);
		answer3.setColumns(10);

		JLabel q1Label = new JLabel("What is the name of your first pet?");
		q1Label.setFont(new Font("Tahoma", Font.BOLD, 14));
		q1Label.setForeground(Color.BLACK);
		q1Label.setHorizontalAlignment(SwingConstants.CENTER);
		q1Label.setBounds(64, 41, 245, 28);
		contentPane.add(q1Label);

		JLabel q2Label = new JLabel("Where were you born?");
		q2Label.setFont(new Font("Tahoma", Font.BOLD, 14));
		q2Label.setForeground(Color.BLACK);
		q2Label.setHorizontalAlignment(SwingConstants.CENTER);
		q2Label.setBounds(64, 134, 245, 28);
		contentPane.add(q2Label);
		
		JLabel q3Label = new JLabel("What is your favorite sports team?");
		q3Label.setFont(new Font("Tahoma", Font.BOLD, 14));
		q3Label.setForeground(Color.BLACK);
		q3Label.setHorizontalAlignment(SwingConstants.CENTER);
		q3Label.setBounds(64, 228, 245, 28);
		contentPane.add(q3Label);


		submitButton = new JButton("Submit");
		submitButton.setBackground(Color.WHITE);
		submitButton.setBounds(136, 353, 89, 36);
		contentPane.add(submitButton);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBounds(10, 113, 337, 2);
		contentPane.add(separator);
		
		errorLabel = new JLabel("One or more of your answers are incorrect.");
		errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		errorLabel.setForeground(Color.RED);
		errorLabel.setBounds(35, 406, 312, 31);
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
		
		answer3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String a1 = answer1.getText();
				String a2 = answer2.getText();
				String a3 = answer3.getText();
				
				if (!a1.equals("Fluffy") || !a2.equals("San Diego") || !a3.equals("Chargers")) {
					errorLabel.setText("One or more of your answers are incorrect.");
					errorLabel.setVisible(true);
					return;
				} else {
					dispose();
					new NewPassPage();
					
				}
			}
		});
		
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String a1 = answer1.getText();
				String a2 = answer2.getText();
				String a3 = answer3.getText();
				
				if (!a1.equals("Fluffy") || !a2.equals("San Diego") || !a3.equals("Chargers")) {
					errorLabel.setText("One or more of your answers are incorrect.");
					errorLabel.setVisible(true);
					return;
				} else {
					dispose();
					new NewPassPage();
					
				}
				
			
			}
		});

	}
}
