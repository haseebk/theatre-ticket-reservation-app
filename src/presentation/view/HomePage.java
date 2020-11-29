package presentation.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import domain.model.BackEnd;

public class HomePage extends JPanel {
	/**
	 * Back button
	 */
	private JLabel logoutButton;
	/**
	 * Cart button
	 */
	private JLabel cartButton;
	/**
	 * Announcement button
	 */
	private JLabel announcementButton;

	public HomePage(JFrame frame, BackEnd backend) {
		setLayout(null);
		
		// CREATE NO DATE SELECTED TEXT LABEL
		JLabel noDateSelectedLabel = new JLabel("<html>"
				+ "Please select a date."
				+ "</html>");
		noDateSelectedLabel.setHorizontalAlignment(SwingConstants.LEFT);
		noDateSelectedLabel.setForeground(Color.RED);
		noDateSelectedLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		noDateSelectedLabel.setBounds(564, 235, 254, 45);
//		noDateSelectedLabel.setVisible(false);
		add(noDateSelectedLabel);
		
		// CREATE NO MOVIE SELECTED TEXT LABEL
		JLabel noMovieSelectedLabel = new JLabel("<html>"
				+ "Please select a movie."
				+ "</html>");
		noMovieSelectedLabel.setHorizontalAlignment(SwingConstants.LEFT);
		noMovieSelectedLabel.setForeground(Color.RED);
		noMovieSelectedLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		noMovieSelectedLabel.setBounds(564, 235, 254, 45);
//		noDateSelectedLabel.setVisible(false);
		add(noMovieSelectedLabel);
		
		// CREATE LOGOUT BUTTON
		logoutButton = new JLabel("");
		logoutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logoutButton.setToolTipText("Logout");
		logoutButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginPage loginPanel = new LoginPage(frame, backend);
				frame.setContentPane(loginPanel);
				frame.revalidate();
			}
		});
		logoutButton.setBounds(30, 5, 50, 50);
		logoutButton.setIcon(new ImageIcon(HomePage.class.getResource("/backButton.png")));
		add(logoutButton);

		// CREATE CART BUTTON
		cartButton = new JLabel("");
		cartButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cartButton.setToolTipText("View Cart");
		cartButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		cartButton.setBounds(1366 - 32 - 30, 14, 32, 32);
		cartButton.setIcon(new ImageIcon(HomePage.class.getResource("/cartButton.png")));
		add(cartButton);

		// CREATE ACCOUNCEMENT BUTTON
		announcementButton = new JLabel("");
		announcementButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		announcementButton.setToolTipText("View Announcements");
		announcementButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		announcementButton.setBounds(1366 - 32 - 90, 14, 32, 32);
		announcementButton.setIcon(new ImageIcon(HomePage.class.getResource("/megaphoneButton.png")));
		add(announcementButton);

		// CREATE MOVIE CARD VIEW
		JLabel movieCard = new JLabel("");
		movieCard.setBounds(40, 132, 401, 564);
		movieCard.setIcon(new ImageIcon(HomePage.class.getResource("/movieCard.png")));
		add(movieCard);

		// CREATE AUDITORIUM CARD VIEW
		JLabel auditoriumCard = new JLabel("");
		auditoriumCard.setBounds(525, 132, 801, 564);
		auditoriumCard.setIcon(new ImageIcon(HomePage.class.getResource("/auditoriumCard.png")));
		add(auditoriumCard);

		// CREATE BACKGROUND VIEW
		JLabel homeBackground = new JLabel("");
		homeBackground.setBounds(-2, -1, 1366, 768);
		homeBackground.setIcon(new ImageIcon(HomePage.class.getResource("/backgroundD.png")));
		add(homeBackground);
	}
}
