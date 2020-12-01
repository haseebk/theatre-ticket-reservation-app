package presentation.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.MatteBorder;

import domain.model.*;
import java.awt.Dimension;
import java.awt.BorderLayout;

public class CartPage extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Back button
	 */
	private JLabel backButton;
	/**
	 * Announcement button
	 */
	private JLabel announcementButton;

	/**
	 * Current movie being chosen
	 */
	private Movie currentMovie;

	/**
	 * Current theatre being chosen
	 */
	private Theatre currentTheatre;

	/**
	 * Current showtime being chosen
	 */
	private Showtime currentShowtime;

	public CartPage(JFrame frame, BackEnd backend) {
		setLayout(null);

		// CREATE WELCOME TEXT LABEL
		JLabel welcomeLabel = new JLabel("");
		if (backend.getCurrentRegisteredUser() != null) {
			welcomeLabel = new JLabel("Welcome, " + backend.getCurrentRegisteredUser().getF_name() + " "
					+ backend.getCurrentRegisteredUser().getL_name() + "!");
		} else {
			welcomeLabel = new JLabel("Welcome, Guest!");
		}
		welcomeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		welcomeLabel.setForeground(Color.WHITE);
		welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 25));
		welcomeLabel.setBounds(140, 5, 571, 50);
		add(welcomeLabel);

		// CREATE MOVIE CARD VIEW
		JPanel imagePanels = new JPanel();
		imagePanels.setBounds(20, 87, 1304, 560);

		ArrayList<Booking> cartItems = backend.getCurrentUser().getCart().getItems_in_cart();

		JLabel[] ticketCards = new JLabel[cartItems.size()];
		JLabel[] deleteTicket= new JLabel[cartItems.size()];
		JLabel[] ticketDetails = new JLabel[cartItems.size()];
		for (int i = 0; i < cartItems.size(); i++) {
			deleteTicket[i] = new JLabel("");
			deleteTicket[i].setVerticalAlignment(SwingConstants.TOP);
			deleteTicket[i].setHorizontalAlignment(SwingConstants.LEFT);
			deleteTicket[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			deleteTicket[i].setIcon(new ImageIcon(HomePage.class.getResource("/deleteButton.png")));
			deleteTicket[i].setBounds(1185, 65 + (170 * i), 32, 32);
			imagePanels.add(deleteTicket[i]);
			
			ticketDetails[i] = new JLabel("");
			ticketDetails[i].setHorizontalAlignment(SwingConstants.LEFT);
			ticketDetails[i].setText(cartItems.get(i).getBookedMovie() + "        " + cartItems.get(i).getBookedTime() + "        " + cartItems.get(i).getBookedSeat());
			ticketDetails[i].setForeground(Color.WHITE);
			ticketDetails[i].setFont(new Font("Arial", Font.PLAIN, 20));
			ticketDetails[i].setBounds(60, 70 + (170 * i), 1000, 32);
			imagePanels.add(ticketDetails[i]);
			
			ticketCards[i] = new JLabel("");
			ticketCards[i].setVerticalAlignment(SwingConstants.TOP);
			ticketCards[i].setHorizontalAlignment(SwingConstants.LEFT);
			ticketCards[i].setBounds(0, 5 + (170 * i), 1285, 164);
			ticketCards[i].setIcon(new ImageIcon(HomePage.class.getResource("/ticketCard.png")));
			imagePanels.add(ticketCards[i]);
		}
		add(imagePanels);
		imagePanels.setLayout(new BorderLayout(0, 0));
		imagePanels.setOpaque(false);

		JScrollPane scrollPane = new JScrollPane(imagePanels);

		scrollPane.setPreferredSize(new Dimension(1304, 560));
		scrollPane.setBounds(20, 87, 1304, 560);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		add(scrollPane);

		// CREATE BACK BUTTON
		backButton = new JLabel("");
		backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backButton.setToolTipText("Back");
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HomePage homePanel = new HomePage(frame, backend);
				frame.setContentPane(homePanel);
				frame.revalidate();
			}
		});
		backButton.setBounds(30, 5, 50, 50);
		backButton.setIcon(new ImageIcon(HomePage.class.getResource("/backButton.png")));
		add(backButton);

		// CREATE ACCOUNCEMENT BUTTON
		announcementButton = new JLabel("");
		announcementButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		announcementButton.setToolTipText("View Announcements");
		announcementButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Announcement");
			}
		});
		announcementButton.setBounds(1366 - 32 - 30, 14, 32, 32);
		announcementButton.setIcon(new ImageIcon(HomePage.class.getResource("/megaphoneButton.png")));
		add(announcementButton);

		// CREATE BACKGROUND VIEW
		JLabel homeBackground = new JLabel("");
		homeBackground.setBounds(-2, -1, 1366, 768);
		homeBackground.setIcon(new ImageIcon(HomePage.class.getResource("/backgroundD.png")));
		add(homeBackground);
	}
}
