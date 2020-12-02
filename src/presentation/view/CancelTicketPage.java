package presentation.view;

import domain.model.*;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.ArrayList;
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
	 * Display text label on Too Late to Cancel
	 */
	private JLabel cancelTooLateLabel;
	/**
	 * Display text label on Ticket Used
	 */
	private JLabel cancelTicketUsedLabel;
	/**
	 * ticketCodeTextField text field
	 */
	private JTextField ticketCodeTextField;
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
		/**
		 * When the back button is pressed, change the view to the home page
		 */
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
		ticketCodeTextField.setBounds(554, 350, 254, 28);
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
		cancelSuccessLabel = new JLabel("<html>" + "Successfully cancelled the ticket" + "</html>");
		cancelSuccessLabel.setHorizontalAlignment(SwingConstants.LEFT);
		cancelSuccessLabel.setForeground(Color.RED);
		cancelSuccessLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		cancelSuccessLabel.setBounds(581, 235, 196, 45);
		cancelSuccessLabel.setVisible(false);
		add(cancelSuccessLabel);

		// CREATE UNDER 72 HOURS LABEL
		cancelTooLateLabel = new JLabel("<html>" + "It is under 72 Hours before the Showtime, cannot cancel" + "</html>");
		cancelTooLateLabel.setHorizontalAlignment(SwingConstants.LEFT);
		cancelTooLateLabel.setForeground(Color.RED);
		cancelTooLateLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		cancelTooLateLabel.setBounds(581, 235, 196, 45);
		cancelTooLateLabel.setVisible(false);
		add(cancelTooLateLabel);

		// CREATE UNDER 72 HOURS LABEL
		cancelTicketUsedLabel = new JLabel("<html>" + "The ticket has already been used" + "</html>");
		cancelTicketUsedLabel.setHorizontalAlignment(SwingConstants.LEFT);
		cancelTicketUsedLabel.setForeground(Color.RED);
		cancelTicketUsedLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		cancelTicketUsedLabel.setBounds(581, 235, 196, 45);
		cancelTicketUsedLabel.setVisible(false);
		add(cancelTicketUsedLabel);

		// CREATE CANCEL ERROR LABEL
		cancelErrorLabel = new JLabel("<html>" + "Could not find the ticket" + "</html>");
		cancelErrorLabel.setHorizontalAlignment(SwingConstants.LEFT);
		cancelErrorLabel.setForeground(Color.RED);
		cancelErrorLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		cancelErrorLabel.setBounds(611, 235, 137, 45);
		cancelErrorLabel.setVisible(false);
		add(cancelErrorLabel);

		// CREATE CARDNUMBER TEXT LABEL
		cardNumberLabel = new JLabel("Ticket Code");
		cardNumberLabel.setBounds(627, 335, 108, 14);
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
		/**
		 * When the cancel ticket button is pressed, verify the user code and find a
		 * matching ticket to cancel. If a ticket is found, then cancel and provide the
		 * user with a voucher. If no ticket is found, accordingly output an error
		 * message.
		 */
		registerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String temp = ticketCodeTextField.getText();
				cancelSuccessLabel.setVisible(false);
				cancelErrorLabel.setVisible(false);
				cancelTooLateLabel.setVisible(false);
				cancelTicketUsedLabel.setVisible(false);
				int t = backend.getDataController().checkTicket(Integer.parseInt(temp));
				if (t == -2){
					//Showtime is under 72 hours away
					cancelTooLateLabel.setVisible(true);
				} else if (t == -3) {
					//Showtime has already passed
					cancelTicketUsedLabel.setVisible(true);
				} else if (t != -1) {
					if (backend.getCurrentGuestUser() != null) {
						Voucher newVoucher = new Voucher(
								backend.getDataController().getTicketList().get(t).getPayment().getAmount() * 0.85);
						backend.getDataController().addVoucher(newVoucher);
						JOptionPane.showMessageDialog(frame, "Here is your voucher code: " + newVoucher.getVoucherCode()
								+ " redeemable for $" + newVoucher.getAmount());
					}else{
						Ticket tempTicket = null;
						for(int i = 0; i < backend.getDataController().getTicketList().size(); i++){
							if(backend.getDataController().getTicketList().get(i).getTicketID() == Integer.parseInt(temp)){
								tempTicket = backend.getDataController().getTicketList().get(i);
							}
						}
						Payment tempPayment = new Payment(tempTicket.getPayment().getAmount() * (-1),backend.getCurrentRegisteredUser().getBankInfo());
						LocalDate today = LocalDate.now();
						Date todayDay = new Date(today.getDayOfMonth(),today.getMonthValue(),today.getYear());
						ArrayList<Ticket> tempTicketList = new ArrayList<Ticket>();
						tempTicketList.add(tempTicket);
						Receipt refundReceipt = new Receipt(tempPayment,todayDay,tempTicketList);
						refundReceipt.emailReceipt(backend, refundReceipt.receiptToString());
						backend.getDataController().addReceipt(refundReceipt);
						backend.getDataController().addPayment(tempPayment);
					}
					backend.getDataController().getTicketList().get(t).getSeat().vacateSeat();
					Ticket tempTicket = backend.getDataController().getTicketList().get(t);
					tempTicket.getShowtime().vacantSeat(tempTicket.getSeat().getRow(),tempTicket.getSeat().getSeatNum());
					tempTicket.getShowtime().setTotalAvaliableSeats(tempTicket.getShowtime().getTotalAvaliableSeats() + 1);
					backend.getDataController().removeReceipt(tempTicket.getReceipt());
					backend.getDataController().removeTicket(tempTicket);
					cancelSuccessLabel.setVisible(true);
				} else {
					//Couldn't find ticket
					cancelErrorLabel.setVisible(true);
				}
				frame.validate();
			}
		});
		registerButton.setBounds(554, 420, 254, 50);
		registerButton.setIcon(new ImageIcon(CancelTicketPage.class.getResource("/enterButton.png")));
		add(registerButton);

		// CREATE BACKGROUND VIEW
		JLabel registerBackground = new JLabel("");
		registerBackground.setBounds(-2, -1, 1366, 768);
		registerBackground.setIcon(new ImageIcon(CancelTicketPage.class.getResource("/backgroundA.png")));
		add(registerBackground);

	}
}