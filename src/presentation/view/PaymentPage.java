package presentation.view;

import domain.model.BackEnd;
import domain.model.BankingInfo;
import domain.model.Movie;
import domain.model.Payment;
import domain.model.Seat;
import domain.model.Showtime;
import domain.model.Ticket;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
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
	 * voucherTextField text field
	 */
	private JTextField voucherTextField;
	/**
	 * Display text label "voucherTextField"
	 */
	private JLabel voucherLabel;
	/**
	 * nameTextField text field
	 */
	private JTextField nameTextField;
	/**
	 * Display text label "nameTextField"
	 */
	private JLabel nameLabel;
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
		cardTypes.add("MASTERCARD");
		cardTypes.add("VISA");
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
		voucherTextField = new JTextField();
		voucherTextField.setBounds(561, 400, 254, 28);
		voucherTextField.setToolTipText("Enter your Voucher Code.");
		voucherTextField.setFont(new Font("Arial", Font.PLAIN, 13));
		voucherTextField.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.LIGHT_GRAY));
		voucherTextField.setForeground(Color.DARK_GRAY);
		voucherTextField.setBackground(Color.WHITE);
		voucherTextField.setOpaque(true);
		voucherTextField.setColumns(10);
		voucherTextField.setOpaque(true);
		add(voucherTextField);

		// CREATE NAME TEXT FIELD
		nameTextField = new JTextField();
		nameTextField.setBounds(561, 295, 254, 28);
		nameTextField.setToolTipText("Enter your Fullname.");
		nameTextField.setFont(new Font("Arial", Font.PLAIN, 13));
		nameTextField.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.LIGHT_GRAY));
		nameTextField.setForeground(Color.DARK_GRAY);
		nameTextField.setBackground(Color.WHITE);
		nameTextField.setOpaque(true);
		nameTextField.setColumns(10);
		nameTextField.setOpaque(true);
		add(nameTextField);
		
		// CREATE EMAIL TEXT FIELD
		emailTextField = new JTextField();
		emailTextField.setBounds(561, 235, 254, 28);
		emailTextField.setToolTipText("Enter your emailID.");
		emailTextField.setFont(new Font("Arial", Font.PLAIN, 13));
		emailTextField.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.LIGHT_GRAY));
		emailTextField.setForeground(Color.DARK_GRAY);
		emailTextField.setBackground(Color.WHITE);
		emailTextField.setOpaque(true);
		emailTextField.setColumns(10);
		emailTextField.setOpaque(true);
		add(emailTextField);
		
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
		voucherLabel = new JLabel("Voucher Code");
		voucherLabel.setBounds(634, 435, 108, 14);
		voucherLabel.setHorizontalAlignment(SwingConstants.CENTER);
		voucherLabel.setForeground(Color.WHITE);
		voucherLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		add(voucherLabel);
		// CREATE CustomerName CODE TEXT LABEL
		nameLabel = new JLabel("Full Name");
		nameLabel.setBounds(634, 280, 108, 14);
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		add(nameLabel);
		// CREATE email CODE TEXT LABEL
		emailLabel = new JLabel("Email ID");
		emailLabel.setBounds(634, 220, 108, 14);
		emailLabel.setHorizontalAlignment(SwingConstants.CENTER);
		emailLabel.setForeground(Color.WHITE);
		emailLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		add(emailLabel);
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
		// CREATE CARD ERROR TEXT LABEL
		JLabel invalidCardErrorLabel = new JLabel("<html>" + "The card was declined." + "</html>");
		invalidCardErrorLabel.setBounds(565, 236, 254, 45);
		invalidCardErrorLabel.setHorizontalAlignment(SwingConstants.LEFT);
		invalidCardErrorLabel.setForeground(Color.RED);
		invalidCardErrorLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		add(invalidCardErrorLabel);		
		// CREATE VOUCHER ERROR TEXT LABEL
		JLabel invalidVoucherErrorLabel = new JLabel("<html>" + "The voucher was declined." + "</html>");
		invalidVoucherErrorLabel.setBounds(565, 236, 254, 45);
		invalidVoucherErrorLabel.setHorizontalAlignment(SwingConstants.LEFT);
		invalidVoucherErrorLabel.setForeground(Color.RED);
		invalidVoucherErrorLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		add(invalidVoucherErrorLabel);
		backButton.setBounds(30, 30, 50, 50);
		backButton.setIcon(new ImageIcon(PaymentPage.class.getResource("/backButton.png")));
		add(backButton);

		// CREATE SUBMIT REGISTER BUTTON
		registerButton = new JLabel("");
		registerButton.setToolTipText("Payment");
		registerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		registerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Payment Clicked");
				String cardType = (String)cardTypeSelectComboBox.getSelectedItem();
				String cardNum = cardNumberTextField.getText();
				String cardExp = cardExpirationDateTextField.getText();
				String cardCCV = String.valueOf(cardSVSPasswordField.getPassword());
				String voucher = voucherTextField.getText();
				String name = nameTextField.getText();
				String email = emailTextField.getText();
				boolean voucherValid = false;
				boolean cardValid = false;
				invalidCardErrorLabel.setVisible(false);
				invalidVoucherErrorLabel.setVisible(false);
				//ArrayList<Ticket> ticketsCreated = new ArrayList<Ticket>();
				System.out.println(name + " " + cardType + " " + cardCCV + " " + cardNum + " " + cardExp);
				// Validate Card info
				if(backend.getDataController().getInst().verifyCardInfo(name, cardType, cardNum, cardCCV, cardExp)) {
					cardValid = true;
					System.out.println("valid card");
				}
				else {
					cardValid = false;
					invalidCardErrorLabel.setVisible(true);
					System.out.println("invalid card");
				}
				// Validate voucher
				if(voucher != "") {
					for(int i=0; i<backend.getDataController().getVoucherList().size(); i++) {
						if(voucher == backend.getDataController().getVoucherList().get(i).getVoucherCode()) {
							if(!backend.getDataController().getVoucherList().get(i).isUsed()) {
								voucherValid = true;
								System.out.println("valid voucher");
								backend.getCurrentUser().getCart().setCartCost((float)(backend.getCurrentUser().getCart().getCartCost() - backend.getDataController().getVoucherList().get(i).getAmount()));
								break;
							}
							else {
								voucherValid = false;
								invalidVoucherErrorLabel.setVisible(true);
								System.out.println("invalid voucher");
							}
						}
					}
				}
				else {
					System.out.println("valid voucher");
					voucherValid = true;
				}
				
				// All information is valid
				if(voucherValid && cardValid) {
					System.out.println("valid details");
					//Cart c = backend.getCurrentUser().getCart();
					backend.getCurrentUser().getCart().setPayment(new Payment(backend.getCurrentUser().getCart().getPayment().getAmount(), new BankingInfo(name, cardType, cardNum, cardCCV, cardExp)));
					for(int i=0; i<backend.getCurrentUser().getCart().getItems_in_cart().size(); i++) {
						Movie movie = backend.getCurrentUser().getCart().getItems_in_cart().get(i).getBookedMovie();
						Showtime showtime = backend.getCurrentUser().getCart().getItems_in_cart().get(i).getBookedTime();
						Seat seat = backend.getCurrentUser().getCart().getItems_in_cart().get(i).getBookedSeat();
						Ticket t = new Ticket(backend.getCurrentUser().getCart().getPayment(), movie, showtime, seat);
						//ticketsCreated.add(t);
						//t.emailTicket(email);
						backend.getDataController().addTicket(t);
						System.out.println("entered payment");
					}						
					/* Add prompt to show ticket and success message*/
					
					HomePage homePanel = new HomePage(frame, backend);
					frame.setContentPane(homePanel);
				}
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