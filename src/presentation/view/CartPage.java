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
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 87, 1285, 560);

		ArrayList<Booking> cartItems = backend.getCurrentUser().getCart().getItems_in_cart();

		JLabel[] ticketCards = new JLabel[cartItems.size()];
		JLabel[] movieDetails = new JLabel[cartItems.size()];
		for (int i = 0; i < cartItems.size(); i++) {
			ticketCards[i] = new JLabel("");
			ticketCards[i].setVerticalAlignment(SwingConstants.TOP);
			ticketCards[i].setHorizontalAlignment(SwingConstants.LEFT);
			ticketCards[i].setBounds(39, 100 + (170 * i), 1285, 164);
			ticketCards[i].setIcon(new ImageIcon(HomePage.class.getResource("/ticketCard.png")));
			scrollPane.add(ticketCards[i]);

			movieDetails[i] = new JLabel("");
			movieDetails[i].setVerticalAlignment(SwingConstants.TOP);
			movieDetails[i].setHorizontalAlignment(SwingConstants.LEFT);
			movieDetails[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			movieDetails[i].setIcon(new ImageIcon(HomePage.class.getResource("/deleteButton.png")));
			movieDetails[i].setBounds(39, 100 + (170 * i), 1285, 164);
			scrollPane.add(movieDetails[i]);

		}

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

		// CREATE MOVIE CARD VIEW
		JLabel ticketCard = new JLabel("");
		ticketCard.setVerticalAlignment(SwingConstants.TOP);
		ticketCard.setHorizontalAlignment(SwingConstants.LEFT);
		ticketCard.setBounds(39, 100, 1285, 164);
		ticketCard.setIcon(new ImageIcon(HomePage.class.getResource("/ticketCard.png")));
		scrollPane.add(ticketCard);

		// CREATE BACKGROUND VIEW
		JLabel homeBackground = new JLabel("");
		homeBackground.setBounds(-2, -1, 1366, 768);
		homeBackground.setIcon(new ImageIcon(HomePage.class.getResource("/backgroundD.png")));
		add(homeBackground);

		add(scrollPane);
	}
}
