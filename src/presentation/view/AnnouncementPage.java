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

public class AnnouncementPage extends JPanel {

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
	private JLabel cartButton;

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

	public AnnouncementPage(JFrame frame, BackEnd backend) {
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
		ArrayList<Announcement> announcementItems = backend.getDataController().getAnnouncementList();
		JLabel[] announcementCard = new JLabel[announcementItems.size()];
		JLabel[] announcementDetails = new JLabel[announcementItems.size()];
		int j = 0;
		for (int i = 0; i < announcementItems.size(); i++) {
			if(!announcementItems.get(i).getPrivateAnnounceDate().beforeCurrentDate()){
				if(backend.getCurrentRegisteredUser() != null ||
						(backend.getCurrentGuestUser() != null && !announcementItems.get(i).getPublicAnnounceDate().beforeCurrentDate())){
					announcementDetails[i] = new JLabel("");
					announcementDetails[i].setHorizontalAlignment(SwingConstants.LEFT);
					announcementDetails[i].setText(announcementItems.get(i).toString());
					announcementDetails[i].setForeground(Color.WHITE);
					announcementDetails[i].setFont(new Font("Arial", Font.PLAIN, 20));
					announcementDetails[i].setBounds(60, 70 + (170 * j), 1000, 32);
					imagePanels.add(announcementDetails[i]);

					announcementCard[i] = new JLabel("");
					announcementCard[i].setVerticalAlignment(SwingConstants.TOP);
					announcementCard[i].setHorizontalAlignment(SwingConstants.LEFT);
					announcementCard[i].setBounds(0, 5 + (170 * j), 1285, 164);
					announcementCard[i].setIcon(new ImageIcon(HomePage.class.getResource("/ticketCard.png")));
					imagePanels.add(announcementCard[i]);
					j++;
				}

			}

		}
		add(imagePanels);
		imagePanels.setLayout(new BorderLayout(0, 0));
		imagePanels.setPreferredSize(new Dimension(1304, 1800));

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

		// CREATE CART BUTTON
		cartButton = new JLabel("");
		cartButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cartButton.setToolTipText("View Announcements");
		cartButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CartPage cartPanel = new CartPage(frame, backend);
				frame.setContentPane(cartPanel);
				frame.revalidate();
			}
		});
		cartButton.setBounds(1366 - 32 - 30, 14, 32, 32);
		cartButton.setIcon(new ImageIcon(HomePage.class.getResource("/cartButton.png")));
		add(cartButton);

		// CREATE BACKGROUND VIEW
		JLabel homeBackground = new JLabel("");
		homeBackground.setBounds(-2, -1, 1366, 768);
		homeBackground.setIcon(new ImageIcon(HomePage.class.getResource("/backgroundD.png")));
		add(homeBackground);
	}

}
