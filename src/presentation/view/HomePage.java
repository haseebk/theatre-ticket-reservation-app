package presentation.view;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
		// CREATE LOGOUT BUTTON
		logoutButton = new JLabel("");
		logoutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logoutButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginPage loginPanel = new LoginPage(frame, backend);
				frame.setContentPane(loginPanel);
				frame.revalidate();
			}
		});
		logoutButton.setBounds(30, 30, 50, 50);
		logoutButton.setIcon(new ImageIcon(HomePage.class.getResource("/backButton.png")));
		add(logoutButton);

		// CREATE CART BUTTON
		cartButton = new JLabel("");
		cartButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cartButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		cartButton.setBounds(30, 30, 50, 50);
		cartButton.setIcon(new ImageIcon(HomePage.class.getResource("/cartButton.png")));
		add(cartButton);

		// CREATE BACK BUTTON
		announcementButton = new JLabel("");
		announcementButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		announcementButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		announcementButton.setBounds(30, 30, 50, 50);
		announcementButton.setIcon(new ImageIcon(HomePage.class.getResource("/megaphoneButton.png")));
		add(announcementButton);

		// CREATE BACKGROUND VIEW
		JLabel homeBackground = new JLabel("");
		homeBackground.setBounds(-2, -1, 1366, 768);
		homeBackground.setIcon(new ImageIcon(HomePage.class.getResource("/backgroundD.png")));
		add(homeBackground);
	}
}
