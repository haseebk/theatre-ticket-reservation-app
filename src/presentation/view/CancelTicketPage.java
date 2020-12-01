package presentation.view;

import domain.model.BackEnd;
import domain.model.Voucher;

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
	 * Display text label on Successful Cancel
	 */
	private JLabel cancelSuccessLabel;
	/**
	 * Display text label on Error Cancel
	 */
	private JLabel cancelErrorLabel;
	/**
	 * ticketCodeTextField text field
	 */
	private JTextField ticketCodeTextField ;
	/**
	 * Display text label "cardNumberField"
	 */
	private JLabel cardNumberLabel;
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

		// CREATE CANCEL SUCCESS LABEL
		cancelSuccessLabel = new JLabel("<html>"
				+ "Successfully cancelled the ticket"
				+ "</html>");
		cancelSuccessLabel.setHorizontalAlignment(SwingConstants.LEFT);
		cancelSuccessLabel.setForeground(Color.RED);
		cancelSuccessLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		cancelSuccessLabel.setBounds(564, 235, 254, 45);
		cancelSuccessLabel.setVisible(false);
		add(cancelSuccessLabel);

		// CREATE CANCEL ERROR LABEL
		cancelErrorLabel = new JLabel("<html>"
				+ "Could not find the ticket"
				+ "</html>");
		cancelErrorLabel.setHorizontalAlignment(SwingConstants.LEFT);
		cancelErrorLabel.setForeground(Color.RED);
		cancelErrorLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		cancelErrorLabel.setBounds(564, 235, 254, 45);
		cancelErrorLabel.setVisible(false);
		add(cancelErrorLabel);

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
				cancelSuccessLabel.setVisible(false);
				cancelErrorLabel.setVisible(false);
				int t = backend.getDataController().checkTicket(Integer.parseInt(temp));
				if(t != -1) {
					if(backend.getCurrentGuestUser() != null){
						Voucher newVoucher = new Voucher(backend.getDataController().getTicketList().get(t).getPayment().getAmount()*0.85);
						backend.getDataController().addVoucher(newVoucher);
						JOptionPane.showMessageDialog(frame,"Here is your voucher code: " + newVoucher.getVoucherCode() + " redeemable for $" + newVoucher.getAmount());
					}
					backend.getDataController().getTicketList().get(t).getSeat().vacateSeat();
					backend.getDataController().removeTicket(backend.getDataController().getTicketList().get(t));
					cancelSuccessLabel.setVisible(true);
				}else{
					cancelErrorLabel.setVisible(true);
				}
				frame.validate();
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