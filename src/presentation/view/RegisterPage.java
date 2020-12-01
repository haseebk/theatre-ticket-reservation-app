package presentation.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import domain.model.BackEnd;

public class RegisterPage extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Username text field
	 */
	private JTextField usernameTextField;
	/**
	 * Password text field
	 */
	private JPasswordField passwordField;
	/**
	 * Display text label "Password"
	 */
	private JLabel passwordLabel;
	/**
	 * Display text label "Username"
	 */
	private JLabel usernameLabel;
	/**
	 * Display register button
	 */
	private JLabel registerButton;
	/**
	 * Confirm password text field
	 */
	private JPasswordField passwordField2;
	/**
	 * Display confirm password label
	 */
	private JLabel passwordLabel2;
	/**
	 * Display full name label
	 */
	private JLabel fullNameLabel;
	/**
	 * Fullname text field
	 */
	private JTextField fullNameTextField;
	/**
	 * Back button
	 */
	private JLabel backButton;

	public RegisterPage(JFrame frame, BackEnd backend) {

		setLayout(null);

		// CREATE BACK BUTTON
		backButton = new JLabel("");
		backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginPage loginPanel = new LoginPage(frame, backend);
				frame.setContentPane(loginPanel);
				frame.revalidate();
			}
		});
		backButton.setBounds(30, 30, 50, 50);
		backButton.setIcon(new ImageIcon(RegisterPage.class.getResource("/backButton.png")));
		add(backButton);

		// CREATE FULL NAME TEXT FIELD
		fullNameTextField = new JTextField();
		fullNameTextField.setToolTipText("Enter your full name.");
		fullNameTextField.setFont(new Font("Arial", Font.PLAIN, 13));
		fullNameTextField.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.LIGHT_GRAY));
		fullNameTextField.setForeground(Color.DARK_GRAY);
		fullNameTextField.setBackground(Color.WHITE);
		fullNameTextField.setBounds(565, 266, 254, 28);
		fullNameTextField.setOpaque(true);
		fullNameTextField.setColumns(10);
		fullNameTextField.setOpaque(true);
		add(fullNameTextField);

		// CREATE USERNAME TEXT FIELD
		usernameTextField = new JTextField();
		usernameTextField.setToolTipText("Enter your username.");
		usernameTextField.setFont(new Font("Arial", Font.PLAIN, 13));
		usernameTextField.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.LIGHT_GRAY));
		usernameTextField.setForeground(Color.DARK_GRAY);
		usernameTextField.setBackground(Color.WHITE);
		usernameTextField.setBounds(565, 340, 254, 28);
		usernameTextField.setOpaque(true);
		usernameTextField.setColumns(10);
		usernameTextField.setOpaque(true);
		add(usernameTextField);

		// CREATE PASSWORD TEXT FIELD
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Enter your password.");
		passwordField.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.LIGHT_GRAY));
		passwordField.setForeground(Color.BLACK);
		passwordField.setBounds(565, 488, 254, 28);
		add(passwordField);

		// CREATE CONFIRM PASSWORD TEXT FIELD
		passwordField2 = new JPasswordField();
		passwordField2.setToolTipText("Re-enter your password.");
		passwordField2.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.LIGHT_GRAY));
		passwordField2.setForeground(Color.BLACK);
		passwordField2.setBounds(565, 414, 254, 28);
		add(passwordField2);

		// CREATE USERNAME TEXT LABEL
		fullNameLabel = new JLabel("Full name");
		fullNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		fullNameLabel.setForeground(Color.WHITE);
		fullNameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		fullNameLabel.setBounds(653, 250, 77, 14);
		add(fullNameLabel);

		// CREATE USERNAME TEXT LABEL
		usernameLabel = new JLabel("Username");
		usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		usernameLabel.setForeground(Color.WHITE);
		usernameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		usernameLabel.setBounds(653, 324, 77, 14);
		add(usernameLabel);

		// CREATE PASSWORD TEXT LABEL
		passwordLabel = new JLabel("Password");
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLabel.setForeground(Color.WHITE);
		passwordLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		passwordLabel.setBounds(653, 398, 77, 14);
		add(passwordLabel);

		// CREATE PASSWORD TEXT LABEL
		passwordLabel2 = new JLabel("Confirm Password");
		passwordLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLabel2.setForeground(Color.WHITE);
		passwordLabel2.setFont(new Font("Arial", Font.PLAIN, 16));
		passwordLabel2.setBounds(625, 472, 134, 14);
		add(passwordLabel2);

		// CREATE USERNAME ERROR TEXT LABEL
		JLabel invalidUsernameErrorLabel = new JLabel("<html>"
				+ "The username you have entered is either too short or too long, or is already taken." + "</html>");
		invalidUsernameErrorLabel.setHorizontalAlignment(SwingConstants.LEFT);
		invalidUsernameErrorLabel.setForeground(Color.RED);
		invalidUsernameErrorLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		invalidUsernameErrorLabel.setBounds(565, 197, 254, 45);
		invalidUsernameErrorLabel.setVisible(false);
		add(invalidUsernameErrorLabel);

		// CREATE PASSWORD ERROR TEXT LABEL
		JLabel invalidPasswordErrorLabel = new JLabel(
				"<html>" + "The passwords you have entered do not match." + "</html>");
		invalidPasswordErrorLabel.setHorizontalAlignment(SwingConstants.LEFT);
		invalidPasswordErrorLabel.setForeground(Color.RED);
		invalidPasswordErrorLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		invalidPasswordErrorLabel.setBounds(565, 197, 254, 45);
		invalidPasswordErrorLabel.setVisible(false);
		add(invalidPasswordErrorLabel);

		// CREATE NAME ERROR TEXT LABEL
		JLabel invalidNameErrorLabel = new JLabel(
				"<html>" + "Please make sure you entered your first and last name." + "</html>");
		invalidNameErrorLabel.setHorizontalAlignment(SwingConstants.LEFT);
		invalidNameErrorLabel.setForeground(Color.RED);
		invalidNameErrorLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		invalidNameErrorLabel.setBounds(565, 197, 254, 45);
		invalidNameErrorLabel.setVisible(false);
		add(invalidNameErrorLabel);

		// CREATE SUBMIT REGISTER BUTTON
		registerButton = new JLabel("");
		registerButton.setToolTipText("Login");
		registerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		registerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String fullname = fullNameTextField.getText();
				String[] name = fullname.split(" ");
				String user = usernameTextField.getText();
				String pass = String.valueOf(passwordField.getPassword());
				String confirmPass = String.valueOf(passwordField2.getPassword());
				Boolean validName = true;
				Boolean samePasswords = true;
				Boolean uniqueUser = true;

				/**
				 * verify sign up details and update backend + database
				 */

				LoginPage loginPanel = new LoginPage(frame, backend);
				frame.setContentPane(loginPanel);
				frame.revalidate();

			}
		});
		registerButton.setBounds(565, 539, 254, 50);
		registerButton.setIcon(new ImageIcon(RegisterPage.class.getResource("/enterButton.png")));
		add(registerButton);

		// CREATE BACKGROUND VIEW
		JLabel registerBackground = new JLabel("");
		registerBackground.setBounds(-2, -1, 1366, 768);
		registerBackground.setIcon(new ImageIcon(RegisterPage.class.getResource("/backgroundA.png")));
		add(registerBackground);

	}

}
