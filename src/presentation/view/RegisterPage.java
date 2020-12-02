package presentation.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
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
		/**
		 * When back button is pressed, change screen to login screen
		 */
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
		fullNameTextField.setBounds(433, 307, 254, 28);
		fullNameTextField.setToolTipText("Enter your full name.");
		fullNameTextField.setFont(new Font("Arial", Font.PLAIN, 13));
		fullNameTextField.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.LIGHT_GRAY));
		fullNameTextField.setForeground(Color.DARK_GRAY);
		fullNameTextField.setBackground(Color.WHITE);
		fullNameTextField.setOpaque(true);
		fullNameTextField.setColumns(10);
		fullNameTextField.setOpaque(true);
		add(fullNameTextField);

		// CREATE USERNAME TEXT FIELD
		usernameTextField = new JTextField();
		usernameTextField.setBounds(697, 307, 254, 28);
		usernameTextField.setToolTipText("Enter your username.");
		usernameTextField.setFont(new Font("Arial", Font.PLAIN, 13));
		usernameTextField.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.LIGHT_GRAY));
		usernameTextField.setForeground(Color.DARK_GRAY);
		usernameTextField.setBackground(Color.WHITE);
		usernameTextField.setOpaque(true);
		usernameTextField.setColumns(10);
		usernameTextField.setOpaque(true);
		add(usernameTextField);

		// CREATE EMAIL TEXT FIELD
		emailTextField = new JTextField();
		emailTextField.setBounds(433, 411, 518, 28);
		emailTextField.setToolTipText("Enter your emailID.");
		emailTextField.setFont(new Font("Arial", Font.PLAIN, 13));
		emailTextField.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.LIGHT_GRAY));
		emailTextField.setForeground(Color.DARK_GRAY);
		emailTextField.setBackground(Color.WHITE);
		emailTextField.setOpaque(true);
		emailTextField.setColumns(10);
		emailTextField.setOpaque(true);
		add(emailTextField);

		// CREATE CARDTYPE TEXT FIELD
		Vector<String> cardTypes = new Vector<String>();
		cardTypes.add("MASTERCARD");
		cardTypes.add("VISA");
		JComboBox cardTypeSelectComboBox = new JComboBox(cardTypes);
		cardTypeSelectComboBox.setBounds(433, 463, 118, 28);
		cardTypeSelectComboBox.setToolTipText("Select Card Type");
		cardTypeSelectComboBox.setFont(new Font("Arial", Font.PLAIN, 15));
		cardTypeSelectComboBox.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.LIGHT_GRAY));
		cardTypeSelectComboBox.setForeground(Color.DARK_GRAY);
		cardTypeSelectComboBox.setBackground(Color.WHITE);
		cardTypeSelectComboBox.setOpaque(true);
		add(cardTypeSelectComboBox);

		// CREATE CARDNUMBER TEXT FIELD
		cardNumberTextField = new JTextField();
		cardNumberTextField.setBounds(561, 463, 254, 28);
		cardNumberTextField.setToolTipText("Enter your card number.");
		cardNumberTextField.setFont(new Font("Arial", Font.PLAIN, 13));
		cardNumberTextField.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.LIGHT_GRAY));
		cardNumberTextField.setForeground(Color.DARK_GRAY);
		cardNumberTextField.setBackground(Color.WHITE);
		cardNumberTextField.setOpaque(true);
		cardNumberTextField.setColumns(10);
		cardNumberTextField.setOpaque(true);
		add(cardNumberTextField);

		// CREATE CARDSVS TEXT FIELD
		cardSVSPasswordField = new JPasswordField();
		cardSVSPasswordField.setBounds(901, 463, 50, 28);
		cardSVSPasswordField.setToolTipText("Enter your card SVS.");
		cardSVSPasswordField.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.LIGHT_GRAY));
		cardSVSPasswordField.setForeground(Color.BLACK);
		add(cardSVSPasswordField);

		// CREATE CARDEXPIRATIONDATE TEXT FIELD
		cardExpirationDateTextField = new JTextField();
		cardExpirationDateTextField.setBounds(825, 463, 68, 28);
		cardExpirationDateTextField.setToolTipText("Enter your card expiration date.");
		cardExpirationDateTextField.setFont(new Font("Arial", Font.PLAIN, 13));
		cardExpirationDateTextField.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.LIGHT_GRAY));
		cardExpirationDateTextField.setForeground(Color.DARK_GRAY);
		cardExpirationDateTextField.setBackground(Color.WHITE);
		cardExpirationDateTextField.setOpaque(true);
		cardExpirationDateTextField.setColumns(10);
		cardExpirationDateTextField.setOpaque(true);
		add(cardExpirationDateTextField);

		// CREATE PASSWORD TEXT FIELD
		passwordField = new JPasswordField();
		passwordField.setBounds(433, 359, 254, 28);
		passwordField.setToolTipText("Enter your password.");
		passwordField.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.LIGHT_GRAY));
		passwordField.setForeground(Color.BLACK);
		add(passwordField);

		// CREATE CONFIRM PASSWORD TEXT FIELD
		passwordField2 = new JPasswordField();
		passwordField2.setBounds(697, 359, 254, 28);
		passwordField2.setToolTipText("Re-enter your password.");
		passwordField2.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.LIGHT_GRAY));
		passwordField2.setForeground(Color.BLACK);
		add(passwordField2);

		// CREATE USERNAME TEXT LABEL
		fullNameLabel = new JLabel("Full name");
		fullNameLabel.setBounds(522, 292, 77, 14);
		fullNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		fullNameLabel.setForeground(Color.WHITE);
		fullNameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		add(fullNameLabel);

		// CREATE USERNAME TEXT LABEL
		usernameLabel = new JLabel("Username");
		usernameLabel.setBounds(786, 292, 77, 14);
		usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		usernameLabel.setForeground(Color.WHITE);
		usernameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		add(usernameLabel);

		// CREATE EMAIL TEXT LABEL
		emailLabel = new JLabel("Email");
		emailLabel.setBounds(667, 397, 50, 14);
		emailLabel.setHorizontalAlignment(SwingConstants.CENTER);
		emailLabel.setForeground(Color.WHITE);
		emailLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		add(emailLabel);

		// CREATE CARDTYPE TEXT LABEL
		cardTypeLabel = new JLabel("Type");
		cardTypeLabel.setBounds(464, 449, 57, 14);
		cardTypeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cardTypeLabel.setForeground(Color.WHITE);
		cardTypeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		add(cardTypeLabel);

		// CREATE CARDNUMBER TEXT LABEL
		cardNumberLabel = new JLabel("Card Number");
		cardNumberLabel.setBounds(634, 449, 108, 14);
		cardNumberLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cardNumberLabel.setForeground(Color.WHITE);
		cardNumberLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		add(cardNumberLabel);

		// CREATE CARD SVS TEXT LABEL
		cardSVSLabel = new JLabel("CCV");
		cardSVSLabel.setBounds(901, 449, 50, 14);
		cardSVSLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cardSVSLabel.setForeground(Color.WHITE);
		cardSVSLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		add(cardSVSLabel);

		// CREATE CARDEXPIRATIONDATE TEXT LABEL
		cardExpirationDateLabel = new JLabel("EXP");
		cardExpirationDateLabel.setBounds(840, 449, 38, 14);
		cardExpirationDateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cardExpirationDateLabel.setForeground(Color.WHITE);
		cardExpirationDateLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		add(cardExpirationDateLabel);

		// CREATE PASSWORD TEXT LABEL
		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(522, 345, 77, 14);
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLabel.setForeground(Color.WHITE);
		passwordLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		add(passwordLabel);

		// CREATE PASSWORD TEXT LABEL
		passwordLabel2 = new JLabel("Confirm Password");
		passwordLabel2.setBounds(757, 345, 134, 14);
		passwordLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLabel2.setForeground(Color.WHITE);
		passwordLabel2.setFont(new Font("Arial", Font.PLAIN, 16));
		add(passwordLabel2);

		// CREATE USERNAME ERROR TEXT LABEL
		JLabel invalidUsernameErrorLabel = new JLabel("<html>"
				+ "The username you have entered is either too short or too long, or is already taken." + "</html>");
		invalidUsernameErrorLabel.setBounds(565, 236, 254, 45);
		invalidUsernameErrorLabel.setHorizontalAlignment(SwingConstants.LEFT);
		invalidUsernameErrorLabel.setForeground(Color.RED);
		invalidUsernameErrorLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		add(invalidUsernameErrorLabel);
		
		// CARD ERROR TEXT LABEL
		JLabel invalidCardErrorLabel = new JLabel("<html>"
				+ "Card information was declined by " + backend.getDataController().getInst().getName() + "." + "</html>");
		invalidCardErrorLabel.setBounds(565, 236, 254, 45);
		invalidCardErrorLabel.setHorizontalAlignment(SwingConstants.LEFT);
		invalidCardErrorLabel.setForeground(Color.RED);
		invalidCardErrorLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		invalidCardErrorLabel.setVisible(false);
		add(invalidCardErrorLabel);

		// CREATE PASSWORD ERROR TEXT LABEL
		JLabel invalidPasswordErrorLabel = new JLabel(
				"<html>" + "The passwords you have entered do not match." + "</html>");
		invalidPasswordErrorLabel.setBounds(565, 236, 254, 45);
		invalidPasswordErrorLabel.setHorizontalAlignment(SwingConstants.LEFT);
		invalidPasswordErrorLabel.setForeground(Color.RED);
		invalidPasswordErrorLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		add(invalidPasswordErrorLabel);

		// CREATE NAME ERROR TEXT LABEL
		JLabel invalidNameErrorLabel = new JLabel(
				"<html>" + "Please make sure you entered your first and last name." + "</html>");
		invalidNameErrorLabel.setBounds(565, 236, 254, 45);
		invalidNameErrorLabel.setHorizontalAlignment(SwingConstants.LEFT);
		invalidNameErrorLabel.setForeground(Color.RED);
		invalidNameErrorLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		invalidNameErrorLabel.setVisible(false);
		invalidPasswordErrorLabel.setVisible(false);
		invalidUsernameErrorLabel.setVisible(false);
		add(invalidNameErrorLabel);

		// CREATE SUBMIT REGISTER BUTTON
		registerButton = new JLabel("");
		registerButton.setToolTipText("Login");
		registerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		/**
		 * When submit register button is pressed, pull data from all text fields and
		 * verify user inputs. If all inputs are valid, then confirm registration and
		 * switch to login screen
		 */
		registerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String fullname = fullNameTextField.getText();
				String[] name = fullname.split(" ");
				String user = usernameTextField.getText();
				String pass = String.valueOf(passwordField.getPassword());
				String confirmPass = String.valueOf(passwordField2.getPassword());
				String email = emailTextField.getText();
				String cardType = (String)cardTypeSelectComboBox.getSelectedItem();
				String cardNum = cardNumberTextField.getText();
				String cardSVS = String.valueOf(cardSVSPasswordField.getPassword());
				String cardExp = cardExpirationDateTextField.getText();
	
				// Dont need these for now
				Boolean validName = true;
				Boolean samePasswords = true;
				Boolean uniqueUser = true;

				// Clear previous error messages
				invalidCardErrorLabel.setVisible(false);
				invalidNameErrorLabel.setVisible(false);
				invalidPasswordErrorLabel.setVisible(false);
				invalidUsernameErrorLabel.setVisible(false);				

				/**
				 * verify sign up details and update backend + database
				 */
				// Check if username is available
				if (!backend.checkExisting(user)) {
					if (pass.matches(confirmPass)) {
						if (name.length == 2) {							
							if(backend.getDataController().getInst().verifyCardInfo(fullname, cardType, cardNum, cardSVS, cardExp)) {
								backend.registerUser(user, pass, name[0], name[1], email, fullname, cardType, cardNum,
										cardSVS, cardExp);
								LoginPage loginPanel = new LoginPage(frame, backend);
								frame.setContentPane(loginPanel);
							}
							else {
								invalidCardErrorLabel.setVisible(true);
							}							
						} else {
							invalidNameErrorLabel.setVisible(true);
						}
					} else {
						invalidPasswordErrorLabel.setVisible(true);
					}
				} else {
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