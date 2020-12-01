package presentation.view;

import domain.model.BackEnd;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class CancelTicketPage extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Display register button
	 */
	private JLabel registerButton;
	/**
	 * Display text label "CardType"
	 */
	private JLabel cardTypeLabel;
	/**
	 * ticketCodeTextField text field
	 */
	private JTextField ticketCodeTextField ;
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

	public CancelTicketPage(JFrame frame, BackEnd backend) {

		setLayout(null);

		// CREATE BACK BUTTON
		backButton = new JLabel("");
		backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HomePage homePage = new HomePage(frame, backend);
				frame.setContentPane(homePage);
				frame.revalidate();
			}
		});

		// CREATE TICKET CODE TEXT FIELD
		ticketCodeTextField = new JTextField();
		ticketCodeTextField.setBounds(561, 350, 254, 28);
		ticketCodeTextField.setToolTipText("Enter your card number.");
		ticketCodeTextField.setFont(new Font("Arial", Font.PLAIN, 13));
		ticketCodeTextField.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.LIGHT_GRAY));
		ticketCodeTextField.setForeground(Color.DARK_GRAY);
		ticketCodeTextField.setBackground(Color.WHITE);
		ticketCodeTextField.setOpaque(true);
		ticketCodeTextField.setColumns(10);
		ticketCodeTextField.setOpaque(true);
		add(ticketCodeTextField);

		// CREATE CARDNUMBER TEXT LABEL
		cardNumberLabel = new JLabel("Ticket Code");
		cardNumberLabel.setBounds(634, 335, 108, 14);
		cardNumberLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cardNumberLabel.setForeground(Color.WHITE);
		cardNumberLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		add(cardNumberLabel);

		backButton.setBounds(30, 30, 50, 50);
		backButton.setIcon(new ImageIcon(CancelTicketPage.class.getResource("/backButton.png")));
		add(backButton);

		// CREATE SUBMIT REGISTER BUTTON
		registerButton = new JLabel("");
		registerButton.setToolTipText("Cancel Ticket");
		registerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		registerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String temp = ticketCodeTextField.getText();
				int t = backend.getDataController().checkTicket(Integer.parseInt(temp));
				if(t != -1) {
					backend.getDataController().getTicketList().get(t).getSeat().vacateSeat();
					backend.getDataController().removeTicket(backend.getDataController().getTicketList().get(t));
				}
			}
		});
		registerButton.setBounds(565, 539, 254, 50);
		registerButton.setIcon(new ImageIcon(CancelTicketPage.class.getResource("/enterButton.png")));
		add(registerButton);

		// CREATE BACKGROUND VIEW
		JLabel registerBackground = new JLabel("");
		registerBackground.setBounds(-2, -1, 1366, 768);
		registerBackground.setIcon(new ImageIcon(CancelTicketPage.class.getResource("/backgroundA.png")));
		add(registerBackground);

	}
}