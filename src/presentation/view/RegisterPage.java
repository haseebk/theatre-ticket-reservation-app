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
	 * Email text field
	 */
	private JTextField emailTextField;
	/**
	 * Display text label "Email"
	 */
	private JLabel emailLabel;
	/**
	 * CardType text field
	 */
	private JTextField cardTypeTextField;
	/**
	 * Display text label "CardType"
	 */
	private JLabel cardTypeLabel;
	/**
	 * cardNumberField text field
	 */
	private JTextField cardNumberTextField;
	/**
	 * Display text label "cardNumberField"
	 */
	private JLabel cardNumberLabel;
	/**
	 * cardSVS password field
	 */
	private JPasswordField cardSVSPasswordField;
	/**
	 * Display text label "cardSVSField"
	 */
	private JLabel cardSVSLabel;
	/**
	 * cardExpirationDate text field
	 */
	private JTextField cardExpirationDateTextField;
	/**
	 * Display text label "cardExpirationDate"
	 */
	private JLabel cardExpirationDateLabel;
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
		
		// CREATE EMAIL TEXT FIELD
		emailTextField = new JTextField();
		emailTextField.setToolTipText("Enter your emailID.");
		emailTextField.setFont(new Font("Arial", Font.PLAIN, 13));
		emailTextField.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.LIGHT_GRAY));
		emailTextField.setForeground(Color.DARK_GRAY);
		emailTextField.setBackground(Color.WHITE);
		emailTextField.setBounds(565, 340, 254, 28);
		emailTextField.setOpaque(true);
		emailTextField.setColumns(10);
		emailTextField.setOpaque(true);
		add(emailTextField);
		
		// CREATE CARDTYPE TEXT FIELD
		cardTypeTextField = new JTextField();
		cardTypeTextField.setToolTipText("Enter your card type.");
		cardTypeTextField.setFont(new Font("Arial", Font.PLAIN, 13));
		cardTypeTextField.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.LIGHT_GRAY));
		cardTypeTextField.setForeground(Color.DARK_GRAY);
		cardTypeTextField.setBackground(Color.WHITE);
		cardTypeTextField.setBounds(565, 340, 254, 28);
		cardTypeTextField.setOpaque(true);
		cardTypeTextField.setColumns(10);
		cardTypeTextField.setOpaque(true);
		add(usernameTextField);
		
		// CREATE CARDNUMBER TEXT FIELD
		cardNumberTextField = new JTextField();
		cardNumberTextField.setToolTipText("Enter your card number.");
		cardNumberTextField.setFont(new Font("Arial", Font.PLAIN, 13));
		cardNumberTextField.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.LIGHT_GRAY));
		cardNumberTextField.setForeground(Color.DARK_GRAY);
		cardNumberTextField.setBackground(Color.WHITE);
		cardNumberTextField.setBounds(565, 340, 254, 28);
		cardNumberTextField.setOpaque(true);
		cardNumberTextField.setColumns(10);
		cardNumberTextField.setOpaque(true);
		add(cardNumberTextField);
		
		// CREATE CARDSVS TEXT FIELD
		cardSVSPasswordField = new JPasswordField();
		cardSVSPasswordField.setToolTipText("Enter your card SVS.");
		cardSVSPasswordField.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.LIGHT_GRAY));
		cardSVSPasswordField.setForeground(Color.BLACK);
		cardSVSPasswordField.setBounds(565, 488, 254, 28);
		add(cardSVSPasswordField);
		
		// CREATE CARDEXPIRATIONDATE TEXT FIELD
		cardExpirationDateTextField = new JTextField();
		cardExpirationDateTextField.setToolTipText("Enter your card expiration date.");
		cardExpirationDateTextField.setFont(new Font("Arial", Font.PLAIN, 13));
		cardExpirationDateTextField.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.LIGHT_GRAY));
		cardExpirationDateTextField.setForeground(Color.DARK_GRAY);
		cardExpirationDateTextField.setBackground(Color.WHITE);
		cardExpirationDateTextField.setBounds(565, 340, 254, 28);
		cardExpirationDateTextField.setOpaque(true);
		cardExpirationDateTextField.setColumns(10);
		cardExpirationDateTextField.setOpaque(true);
		add(cardExpirationDateTextField);

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
		
		// CREATE EMAIL TEXT LABEL
		emailLabel = new JLabel("Email");
		emailLabel.setHorizontalAlignment(SwingConstants.CENTER);
		emailLabel.setForeground(Color.WHITE);
		emailLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		emailLabel.setBounds(653, 324, 77, 14); // edit location
		add(emailLabel);
		
		// CREATE CARDTYPE TEXT LABEL -------------------------------- implement as a dropdown menu?
		cardTypeLabel = new JLabel("CardType");
		cardTypeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cardTypeLabel.setForeground(Color.WHITE);
		cardTypeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		cardTypeLabel.setBounds(653, 324, 77, 14);
		add(cardTypeLabel);
		
		// CREATE CARDNUMBER TEXT LABEL 
		cardNumberLabel = new JLabel("CardNumber");
		cardNumberLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cardNumberLabel.setForeground(Color.WHITE);
		cardNumberLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		cardNumberLabel.setBounds(653, 324, 77, 14);
		add(cardNumberLabel);
		
		// CREATE CARDSVS TEXT LABEL 
		cardSVSLabel = new JLabel("CardSVS");
		cardSVSLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cardSVSLabel.setForeground(Color.WHITE);
		cardSVSLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		cardSVSLabel.setBounds(653, 324, 77, 14);
		add(cardSVSLabel);
		
		// CREATE CARDEXPIRATIONDATE TEXT LABEL 
		cardExpirationDateLabel = new JLabel("CardExpirationDate");
		cardExpirationDateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cardExpirationDateLabel.setForeground(Color.WHITE);
		cardExpirationDateLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		cardExpirationDateLabel.setBounds(653, 324, 77, 14);
		add(cardExpirationDateLabel);
		
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
				String email = "";
				Boolean validName = true;
				Boolean samePasswords = true;
				Boolean uniqueUser = true;
				
				// Clear previous error messages
				invalidNameErrorLabel.setVisible(false);
				invalidPasswordErrorLabel.setVisible(false);
				invalidUsernameErrorLabel.setVisible(false);
				
				/**
				 * verify sign up details and update backend + database
				 */
				// Check if username is available
				if(!backend.checkExisting(user)) {
					if(pass.matches(confirmPass)) {
						if(name.length == 2) {
							backend.registerUser(user, pass, name[0], name[1], email);
							LoginPage loginPanel = new LoginPage(frame, backend);
							frame.setContentPane(loginPanel);
						}
						else {
							invalidNameErrorLabel.setVisible(true);
						}
					}
					else {
						invalidPasswordErrorLabel.setVisible(true);
					}
				}else{
					invalidUsernameErrorLabel.setVisible(true);
				}				
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
