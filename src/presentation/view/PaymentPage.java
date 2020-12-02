package presentation.view;

import domain.model.*;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;
import java.time.LocalDate;

public class PaymentPage extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;



	/**
	 * Display register button
	 */
	private JLabel registerButton;
	/**
	 * Title Text Field
	 */
	private JLabel titleLabel;
	/**
	 * Email text field
	 */
	private JTextField emailTextField;
	/**
	 * Display text label "Email"
	 */
	private JLabel emailLabel;
	/**
	 * Display text label "CardType"
	 */
	private JLabel cardTypeLabel;
	/**
	 * cardNumberField text field
	 */
	private JTextField cardNumberTextField;
	/**
	 * Button for registered users to use their banking info
	 */
	private JLabel userStoredBankingButton;
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

		// CREATE TITLE TEXT LABEL
		titleLabel = new JLabel(
				"PAYMENT TOTAL: $" + String.format("%.2f", backend.getCurrentUser().getCart().getCartCost()));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		titleLabel.setBounds(530, 175, 300, 30);
		add(titleLabel);

		// CREATE BACK BUTTON
		backButton = new JLabel("");
		backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		/**
		 * When back button is pressed, set the view to cart page
		 */
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
		invalidCardErrorLabel.setBounds(600, 580, 254, 45);
		invalidCardErrorLabel.setHorizontalAlignment(SwingConstants.LEFT);
		invalidCardErrorLabel.setForeground(Color.RED);
		invalidCardErrorLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		invalidCardErrorLabel.setVisible(false);
		add(invalidCardErrorLabel);

		// CREATE VOUCHER ERROR TEXT LABEL
		JLabel invalidVoucherErrorLabel = new JLabel("<html>" + "The voucher was declined." + "</html>");
		invalidVoucherErrorLabel.setBounds(600, 580, 254, 45);
		invalidVoucherErrorLabel.setHorizontalAlignment(SwingConstants.LEFT);
		invalidVoucherErrorLabel.setForeground(Color.RED);
		invalidVoucherErrorLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		invalidVoucherErrorLabel.setVisible(false);
		add(invalidVoucherErrorLabel);

		// CREATE BACK BUTTON
		backButton.setBounds(30, 30, 50, 50);
		backButton.setIcon(new ImageIcon(PaymentPage.class.getResource("/backButton.png")));
		add(backButton);

		// CREATE USE ACCOUNT BANKING INFO BUTTON
		userStoredBankingButton = new JLabel("USE REGISTERED ACCOUNT BANKING INFO");
		userStoredBankingButton.setHorizontalAlignment(SwingConstants.CENTER);
		userStoredBankingButton.setForeground(Color.GRAY);
		userStoredBankingButton.setFont(new Font("Arial", Font.BOLD, 13));
		userStoredBankingButton.setBounds(520, 502, 350, 14);
		userStoredBankingButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		/**
		 * When User Stored Banking Info button is pressed, it will use the User's
		 * banking info instead
		 */
		userStoredBankingButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean cardValid;
				boolean voucherValid;
				String voucher = voucherTextField.getText();
				Voucher redeemedVoucher;
				double voucherValue = 0;
				// Validate Card info
				if (backend.getCurrentRegisteredUser() != null) {
					String name = backend.getCurrentRegisteredUser().getBankInfo().getCustomerName();
					String cardType = backend.getCurrentRegisteredUser().getBankInfo().getCardType();
					String cardNum = backend.getCurrentRegisteredUser().getBankInfo().getCardNumber();
					String cardExp = backend.getCurrentRegisteredUser().getBankInfo().getCardExpirationDate();
					String cardCCV = backend.getCurrentRegisteredUser().getBankInfo().getCardSVS();
					invalidCardErrorLabel.setVisible(false);
					invalidVoucherErrorLabel.setVisible(false);

					if (backend.getDataController().getInst().verifyCardInfo(name, cardType, cardNum, cardCCV,
							cardExp)) {
						cardValid = true;
					} else {
						cardValid = false;
					}

					if (voucher.compareTo("") != 0) {
						redeemedVoucher = backend.getDataController().redeemVoucher(voucher);
						if (redeemedVoucher == null) {
							voucherValid = false;
						} else {
							voucherValid = true;
							voucherValue = redeemedVoucher.getAmount();
						}
					} else {
						voucherValid = true;
					}

					// All information is valid
					if (voucherValid && cardValid) {
						double finalTotal = backend.getCurrentUser().getCart().getCartCost() - voucherValue;
						if (finalTotal < 0) {
							finalTotal = 0;
						}
						processPayment(frame, backend, finalTotal, backend.getCurrentRegisteredUser().getBankInfo());
					} else if (cardValid == false) {
						invalidCardErrorLabel.setVisible(true);
					} else if (voucherValid == false) {
						invalidVoucherErrorLabel.setVisible(true);
					}
				}
				frame.revalidate();
			}
		});
		if (backend.getCurrentRegisteredUser() != null) {
			userStoredBankingButton.setVisible(true);
		} else {
			userStoredBankingButton.setVisible(false);
		}
		add(userStoredBankingButton);

		// CREATE SUBMIT REGISTER BUTTON
		registerButton = new JLabel("");
		registerButton.setToolTipText("Payment");
		registerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		/**
		 * When register button is pressed, pull all payment information from text
		 * fields. Validate all user input and then switch to the home screen after
		 * confirming purchase.
		 */
		registerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String cardType = (String) cardTypeSelectComboBox.getSelectedItem();
				String cardNum = cardNumberTextField.getText();
				String cardExp = cardExpirationDateTextField.getText();
				String cardCCV = String.valueOf(cardSVSPasswordField.getPassword());
				String voucher = voucherTextField.getText();
				String name = nameTextField.getText();
				boolean voucherValid = false;
				boolean cardValid = false;
				Voucher redeemedVoucher = null;
				invalidCardErrorLabel.setVisible(false);
				invalidVoucherErrorLabel.setVisible(false);
				double voucherValue = 0;
				// ArrayList<Ticket> ticketsCreated = new ArrayList<Ticket>();

				// Validate Card info
				if (backend.getDataController().getInst().verifyCardInfo(name, cardType, cardNum, cardCCV, cardExp)) {
					cardValid = true;
				} else {
					cardValid = false;
				}
				// Validate voucher

				if (voucher.compareTo("") != 0) {
					redeemedVoucher = backend.getDataController().redeemVoucher(voucher);
					if (redeemedVoucher == null) {
						voucherValid = false;
					} else {
						voucherValid = true;
						voucherValue = redeemedVoucher.getAmount();
					}
				} else {
					voucherValid = true;
				}

				// All information is valid
				if (voucherValid && cardValid) {
					double finalTotal = backend.getCurrentUser().getCart().getCartCost() - voucherValue;
					if (finalTotal < 0) {
						finalTotal = 0;
					}
					processPayment(frame, backend, finalTotal,
							new BankingInfo(name, cardType, cardNum, cardCCV, cardExp));
				} else if (cardValid == false) {
					invalidCardErrorLabel.setVisible(true);
				} else if (voucherValid == false) {
					invalidVoucherErrorLabel.setVisible(true);
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

	public void processPayment(JFrame frame, BackEnd backend, double costAmount, BankingInfo bankingInfo) {
		// Cart c = backend.getCurrentUser().getCart();
		backend.getCurrentUser().getCart().setPayment(new Payment(costAmount, bankingInfo));
		ArrayList<Ticket> ticketList = new ArrayList<Ticket>();
		for (int i = 0; i < backend.getCurrentUser().getCart().getItems_in_cart().size(); i++) {
			Movie movie = backend.getCurrentUser().getCart().getItems_in_cart().get(i).getBookedMovie();
			Showtime showtime = backend.getCurrentUser().getCart().getItems_in_cart().get(i).getBookedTime();
			Seat seat = backend.getCurrentUser().getCart().getItems_in_cart().get(i).getBookedSeat();
			showtime.bookSeat(seat.getRow(), seat.getSeatNum());
			Ticket t = new Ticket(backend.getCurrentUser().getCart().getPayment(), movie, showtime, seat);
			ticketList.add(t);
			if(backend.getCurrentRegisteredUser() != null){
//				t.emailTicket(backend);
			}else {
//				t.emailTicket(emailTextField.getText());
			}
			backend.getDataController().addTicket(t);
		}

		//Creates Receipt
		Date nowDate = new Date(LocalDate.now().getDayOfMonth(),LocalDate.now().getMonthValue(),LocalDate.now().getYear());
		Receipt r = new Receipt(backend.getCurrentUser().getCart().getPayment(),nowDate,ticketList);
		backend.getDataController().addReceipt(r);
		

		if(backend.getCurrentRegisteredUser() != null){
			r.emailReceipt(backend, r.receiptToString());
		} 
			
		/* Add prompt to show ticket and success message */
		JOptionPane.showMessageDialog(null, r.receiptToString(),
				"Ticket Has Been Purchased", JOptionPane.INFORMATION_MESSAGE);

		backend.getCurrentUser().setCart(new Cart());
		HomePage homePanel = new HomePage(frame, backend);
		frame.setContentPane(homePanel);
		frame.revalidate();
	}
}