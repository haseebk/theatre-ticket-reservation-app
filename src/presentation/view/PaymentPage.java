package presentation.view;

import domain.model.BackEnd;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class PaymentPage extends JPanel {

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

	public PaymentPage(JFrame frame, BackEnd backend) {

		setLayout(null);

		// CREATE BACK BUTTON
		backButton = new JLabel("");
		backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CartPage cartPage = new CartPage(frame, backend);
				frame.setContentPane(cartPage);
				frame.revalidate();
			}
		});

		// CREATE CARDTYPE TEXT FIELD
		Vector<String> cardTypes = new Vector<String>();
		cardTypes.add("MasterCard");
		cardTypes.add("Visa");
		JComboBox cardTypeSelectComboBox = new JComboBox(cardTypes);
		cardTypeSelectComboBox.setBounds(433, 350, 118, 28);
		cardTypeSelectComboBox.setToolTipText("Select Card Type");
		cardTypeSelectComboBox.setFont(new Font("Arial", Font.PLAIN, 15));
		cardTypeSelectComboBox.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.LIGHT_GRAY));
		cardTypeSelectComboBox.setForeground(Color.DARK_GRAY);
		cardTypeSelectComboBox.setBackground(Color.WHITE);
		cardTypeSelectComboBox.setOpaque(true);
		add(cardTypeSelectComboBox);

		// CREATE CARDNUMBER TEXT FIELD
		cardNumberTextField = new JTextField();
		cardNumberTextField.setBounds(561, 350, 254, 28);
		cardNumberTextField.setToolTipText("Enter your card number.");
		cardNumberTextField.setFont(new Font("Arial", Font.PLAIN, 13));
		cardNumberTextField.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.LIGHT_GRAY));
		cardNumberTextField.setForeground(Color.DARK_GRAY);
		cardNumberTextField.setBackground(Color.WHITE);
		cardNumberTextField.setOpaque(true);
		cardNumberTextField.setColumns(10);
		cardNumberTextField.setOpaque(true);
		add(cardNumberTextField);

		// CREATE VOUCHER TEXT FIELD
		cardNumberTextField = new JTextField();
		cardNumberTextField.setBounds(561, 400, 254, 28);
		cardNumberTextField.setToolTipText("Enter your Voucher Code.");
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
		cardSVSPasswordField.setBounds(901, 350, 50, 28);
		cardSVSPasswordField.setToolTipText("Enter your card SVS.");
		cardSVSPasswordField.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.LIGHT_GRAY));
		cardSVSPasswordField.setForeground(Color.BLACK);
		add(cardSVSPasswordField);

		// CREATE CARDEXPIRATIONDATE TEXT FIELD
		cardExpirationDateTextField = new JTextField();
		cardExpirationDateTextField.setBounds(825, 350, 68, 28);
		cardExpirationDateTextField.setToolTipText("Enter your card expiration date.");
		cardExpirationDateTextField.setFont(new Font("Arial", Font.PLAIN, 13));
		cardExpirationDateTextField.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.LIGHT_GRAY));
		cardExpirationDateTextField.setForeground(Color.DARK_GRAY);
		cardExpirationDateTextField.setBackground(Color.WHITE);
		cardExpirationDateTextField.setOpaque(true);
		cardExpirationDateTextField.setColumns(10);
		cardExpirationDateTextField.setOpaque(true);
		add(cardExpirationDateTextField);

		// CREATE CARDTYPE TEXT LABEL
		cardTypeLabel = new JLabel("Type");
		cardTypeLabel.setBounds(464, 335, 57, 14);
		cardTypeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cardTypeLabel.setForeground(Color.WHITE);
		cardTypeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		add(cardTypeLabel);
		// CREATE CARDNUMBER TEXT LABEL
		cardNumberLabel = new JLabel("Card Number");
		cardNumberLabel.setBounds(634, 335, 108, 14);
		cardNumberLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cardNumberLabel.setForeground(Color.WHITE);
		cardNumberLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		add(cardNumberLabel);
		// CREATE VOUCHER CODE TEXT LABEL
		cardNumberLabel = new JLabel("Voucher Code");
		cardNumberLabel.setBounds(634, 435, 108, 14);
		cardNumberLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cardNumberLabel.setForeground(Color.WHITE);
		cardNumberLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		add(cardNumberLabel);
		// CREATE CARD SVS TEXT LABEL
		cardSVSLabel = new JLabel("CCV");
		cardSVSLabel.setBounds(901, 335, 50, 14);
		cardSVSLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cardSVSLabel.setForeground(Color.WHITE);
		cardSVSLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		add(cardSVSLabel);
		// CREATE CARDEXPIRATIONDATE TEXT LABEL
		cardExpirationDateLabel = new JLabel("EXP");
		cardExpirationDateLabel.setBounds(840, 335, 38, 14);
		cardExpirationDateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cardExpirationDateLabel.setForeground(Color.WHITE);
		cardExpirationDateLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		add(cardExpirationDateLabel);

		backButton.setBounds(30, 30, 50, 50);
		backButton.setIcon(new ImageIcon(PaymentPage.class.getResource("/backButton.png")));
		add(backButton);

		// CREATE SUBMIT REGISTER BUTTON
		registerButton = new JLabel("");
		registerButton.setToolTipText("Login");
		registerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		registerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		registerButton.setBounds(565, 539, 254, 50);
		registerButton.setIcon(new ImageIcon(PaymentPage.class.getResource("/enterButton.png")));
		add(registerButton);

		// CREATE BACKGROUND VIEW
		JLabel registerBackground = new JLabel("");
		registerBackground.setBounds(-2, -1, 1366, 768);
		registerBackground.setIcon(new ImageIcon(PaymentPage.class.getResource("/backgroundA.png")));
		add(registerBackground);

	}
}