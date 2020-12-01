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

public class HomePage extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

	public HomePage(JFrame frame, BackEnd backend) {
		setLayout(null);

		// CREATE NO THEATRE SELECTED TEXT LABEL
		JLabel noTheatreSelectedLabel = new JLabel("<html>" + "Please select a theatre." + "</html>");
		noTheatreSelectedLabel.setHorizontalAlignment(SwingConstants.LEFT);
		noTheatreSelectedLabel.setForeground(Color.RED);
		noTheatreSelectedLabel.setFont(new Font("HelveticaNeue", Font.PLAIN, 15));
		noTheatreSelectedLabel.setBounds(840, 392, 170, 45);
		noTheatreSelectedLabel.setVisible(false);
		add(noTheatreSelectedLabel);

		// CREATE NO SHOWTIME SELECTED TEXT LABEL
		JLabel noShowTimeSelectedLabel = new JLabel("<html>" + "Please select a show time." + "</html>");
		noShowTimeSelectedLabel.setHorizontalAlignment(SwingConstants.LEFT);
		noShowTimeSelectedLabel.setForeground(Color.RED);
		noShowTimeSelectedLabel.setFont(new Font("HelveticaNeue", Font.PLAIN, 15));
		noShowTimeSelectedLabel.setBounds(829, 392, 192, 45);
		noShowTimeSelectedLabel.setVisible(false);
		add(noShowTimeSelectedLabel);

		// CREATE NO MOVIE SELECTED TEXT LABEL
		JLabel noMovieSelectedLabel = new JLabel("<html>" + "Please select a movie." + "</html>");
		noMovieSelectedLabel.setHorizontalAlignment(SwingConstants.LEFT);
		noMovieSelectedLabel.setForeground(Color.RED);
		noMovieSelectedLabel.setFont(new Font("HelveticaNeue", Font.PLAIN, 15));
		noMovieSelectedLabel.setBounds(156, 392, 168, 45); //
		noMovieSelectedLabel.setVisible(true);
		add(noMovieSelectedLabel);

		// =========================================
		// SELECT SEAT
		// =========================================

		// CREATE ROW TEXT FIELD
		JTextField rowTextField = new JTextField();
		rowTextField.setToolTipText("Enter row");
		rowTextField.setFont(new Font("HelveticaNeue", Font.PLAIN, 15));
		rowTextField.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.LIGHT_GRAY));
		rowTextField.setForeground(Color.DARK_GRAY);
		rowTextField.setBackground(Color.WHITE);
		rowTextField.setBounds(1100, 320, 50, 28);
		rowTextField.setOpaque(true);
		rowTextField.setColumns(10);
		rowTextField.setVisible(false);
		add(rowTextField);

		// CREATE COLUMN TEXT FIELD
		JTextField colTextField = new JTextField();
		colTextField.setToolTipText("Enter column");
		colTextField.setFont(new Font("HelveticaNeue", Font.PLAIN, 15));
		colTextField.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.LIGHT_GRAY));
		colTextField.setForeground(Color.DARK_GRAY);
		colTextField.setBackground(Color.WHITE);
		colTextField.setBounds(1100, 380, 50, 28);
		colTextField.setOpaque(true);
		colTextField.setColumns(10);
		colTextField.setVisible(false);
		add(colTextField);

		// CREATE SELECT ROW TEXT
		JLabel selectRowLabel = new JLabel("Select Row: ");
		selectRowLabel.setHorizontalAlignment(SwingConstants.LEFT);
		selectRowLabel.setForeground(Color.WHITE);
		selectRowLabel.setFont(new Font("HelveticaNeue", Font.PLAIN, 15));
		selectRowLabel.setBounds(1100, 280, 200, 45);
		selectRowLabel.setVisible(false);
		add(selectRowLabel);

		// CREATE SELECT COLUMN TEXT
		JLabel selectColLabel = new JLabel("Select Column: ");
		selectColLabel.setHorizontalAlignment(SwingConstants.LEFT);
		selectColLabel.setForeground(Color.WHITE);
		selectColLabel.setFont(new Font("HelveticaNeue", Font.PLAIN, 15));
		selectColLabel.setBounds(1100, 340, 200, 45);
		selectColLabel.setVisible(false);
		add(selectColLabel);

		// CREATE ADD TO CART BUTTON
		JTextArea seatGraphicLabel = new JTextArea("");
		JLabel AddToCartButton = new JLabel("Add To Cart");
		AddToCartButton.setToolTipText("Add To Cart");
		AddToCartButton.setForeground(Color.WHITE);
		AddToCartButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		AddToCartButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int tempRow = Integer.parseInt(rowTextField.getText());
					int tempCol = Integer.parseInt(colTextField.getText());
					if (tempRow < currentShowtime.getRow() && tempCol < currentShowtime.getCol()) {
						boolean booking = backend.getDataController().getShowtimeList()
								.get(currentShowtime.getShowtimeID()).bookSeat(tempRow, tempCol);
						if (booking == true) {
							System.out.println("Added ticket To Cart for:\nMovie: " + currentMovie.getTitle()
									+ "\nTheatre: " + currentTheatre.getT_name() + "\nDate: "
									+ currentShowtime.getShowDate().getDate() + "\nSeat Row: " + tempRow
									+ ", Seat Column: " + tempCol);
							currentShowtime = backend.getDataController().getShowtimeList()
									.get(currentShowtime.getShowtimeID());

							String tempGraphic = "";
							for (int i = 0; i < currentShowtime.getRow(); i++) {
								for (int j = 0; j < currentShowtime.getCol(); j++) {
									if (currentShowtime.getSeatAvaliability(i, j) == true) {
										tempGraphic += "X   ";
									} else {
										tempGraphic += "O   ";
									}
								}
								tempGraphic += "\n";
							}
							seatGraphicLabel.setText(tempGraphic);
							seatGraphicLabel.setVisible(true);
						} else {
							System.out.println("Seat already taken");
						}
					} else {
						System.out.println("Invalid row or column value");
					}
					frame.revalidate();
				} catch (NumberFormatException f) {
					System.out.println(f);
				}
			}
		});
		AddToCartButton.setBounds(797, 625, 254, 50);
		AddToCartButton.setVisible(false);
		AddToCartButton.setIcon(new ImageIcon(LoginPage.class.getResource("/enterButton.png")));
		add(AddToCartButton);

		// ==========================================
		// SELECT SHOWTIME
		// ==========================================

		// CREATE SELECT SEAT TEXT
		JLabel selectSeatLabel = new JLabel("Seat");
		selectSeatLabel.setHorizontalAlignment(SwingConstants.LEFT);
		selectSeatLabel.setForeground(Color.WHITE);
		selectSeatLabel.setFont(new Font("HelveticaNeue", Font.PLAIN, 15));
		selectSeatLabel.setBounds(600, 280, 254, 45);
		selectSeatLabel.setVisible(false);
		add(selectSeatLabel);

		// CREATE SHOWTIME DETAILS TEXT
		seatGraphicLabel.setForeground(Color.WHITE);
		seatGraphicLabel.setFont(new Font("HelveticaNeue", Font.PLAIN, 15));
		seatGraphicLabel.setBounds(600, 310, 254, 254);
		seatGraphicLabel.setVisible(false);
		seatGraphicLabel.setLineWrap(true);
		seatGraphicLabel.setWrapStyleWord(true);
		seatGraphicLabel.setOpaque(false);
		seatGraphicLabel.setEditable(false);
		add(seatGraphicLabel);

		// ==========================================
		// SELECT SHOWTIME
		// ==========================================

		// CREATE SELECT SHOWTIME TEXT
		JLabel selectShowtimeLabel = new JLabel("Show Time");
		selectShowtimeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		selectShowtimeLabel.setForeground(Color.WHITE);
		selectShowtimeLabel.setFont(new Font("HelveticaNeue", Font.PLAIN, 15));
		selectShowtimeLabel.setBounds(900, 140, 254, 45);
		selectShowtimeLabel.setVisible(false);
		add(selectShowtimeLabel);

		// CREATE SHOWTIME DETAILS TEXT
		JTextArea showtimeDetailsLabel = new JTextArea("");
		showtimeDetailsLabel.setForeground(Color.WHITE);
		showtimeDetailsLabel.setFont(new Font("HelveticaNeue", Font.PLAIN, 15));
		showtimeDetailsLabel.setBounds(900, 215, 254, 100);
		showtimeDetailsLabel.setVisible(false);
		showtimeDetailsLabel.setLineWrap(true);
		showtimeDetailsLabel.setWrapStyleWord(true);
		showtimeDetailsLabel.setOpaque(false);
		showtimeDetailsLabel.setEditable(false);
		add(showtimeDetailsLabel);

		// CREATE SHOWTIME SELECTOR
		JComboBox showtimeSelectComboBox = new JComboBox(new String[0]);
		showtimeSelectComboBox.setToolTipText("Select Date");
		showtimeSelectComboBox.setFont(new Font("HelveticaNeue", Font.PLAIN, 15));
		showtimeSelectComboBox.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.LIGHT_GRAY));
		showtimeSelectComboBox.setForeground(Color.DARK_GRAY);
		showtimeSelectComboBox.setBackground(Color.WHITE);
		showtimeSelectComboBox.setBounds(900, 180, 200, 28);
		showtimeSelectComboBox.setOpaque(true);
		showtimeSelectComboBox.setVisible(false);
		showtimeSelectComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Date Combo Box Pressed: " + showtimeSelectComboBox.getSelectedItem());
				String tempString = (String) showtimeSelectComboBox.getSelectedItem();
				noShowTimeSelectedLabel.setVisible(false);
				if (tempString != null) {
					String[] tempStringArray = tempString.split("/");
					Date tempDate = new Date(Integer.parseInt(tempStringArray[1]), tempStringArray[0],
							Integer.parseInt(tempStringArray[2]));
					currentShowtime = backend.getDataController().findShowtime(currentMovie, currentTheatre, tempDate);
					if (currentShowtime != null) {
						System.out.println("Showtime found");
						showtimeDetailsLabel.setText("Auditorium: " + currentShowtime.getAuditorium().getAuditoriumID()
								+ "\nNumber of Avaliable Seats: " + currentShowtime.getTotalAvaliableSeats());
						showtimeDetailsLabel.setVisible(true);
						rowTextField.setVisible(true);
						colTextField.setVisible(true);
						selectRowLabel.setVisible(true);
						selectColLabel.setVisible(true);
						AddToCartButton.setVisible(true);

						String tempGraphic = "";
						for (int i = 0; i < currentShowtime.getRow(); i++) {
							for (int j = 0; j < currentShowtime.getCol(); j++) {
								if (currentShowtime.getSeatAvaliability(i, j) == true) {
									tempGraphic += "X   ";
								} else {
									tempGraphic += "O   ";
								}
							}
							tempGraphic += "\n";
						}
						seatGraphicLabel.setText(tempGraphic);
						seatGraphicLabel.setVisible(true);
						selectSeatLabel.setVisible(true);
					} else {
						System.out.println("No showtime found");
						showtimeDetailsLabel.setVisible(false);
					}
				} else {
					System.out.println("No showtime found");
					showtimeDetailsLabel.setVisible(false);
				}
			}
		});
		add(showtimeSelectComboBox);

		// ==========================================
		// SELECT THEATRE
		// ==========================================

		// CREATE SELECT THEATRE TEXT
		JLabel selectTheatreLabel = new JLabel("Theatre");
		selectTheatreLabel.setHorizontalAlignment(SwingConstants.LEFT);
		selectTheatreLabel.setForeground(Color.WHITE);
		selectTheatreLabel.setFont(new Font("HelveticaNeue", Font.PLAIN, 15));
		selectTheatreLabel.setBounds(600, 140, 254, 45);
		selectTheatreLabel.setVisible(false);
		add(selectTheatreLabel);

		// CREATE THEATRE DETAILS TEXT
		JTextArea theatreDetailsLabel = new JTextArea("");
		theatreDetailsLabel.setForeground(Color.WHITE);
		theatreDetailsLabel.setFont(new Font("HelveticaNeue", Font.PLAIN, 15));
		theatreDetailsLabel.setBounds(600, 215, 254, 100);
		theatreDetailsLabel.setVisible(false);
		theatreDetailsLabel.setLineWrap(true);
		theatreDetailsLabel.setWrapStyleWord(true);
		theatreDetailsLabel.setOpaque(false);
		theatreDetailsLabel.setEditable(false);
		add(theatreDetailsLabel);

		// CREATE THEATRE SELECTOR
		JComboBox theatreSelectComboBox = new JComboBox(new String[0]);
		theatreSelectComboBox.setToolTipText("Select Theatre");
		theatreSelectComboBox.setFont(new Font("HelveticaNeue", Font.PLAIN, 15));
		theatreSelectComboBox.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.LIGHT_GRAY));
		theatreSelectComboBox.setForeground(Color.DARK_GRAY);
		theatreSelectComboBox.setBackground(Color.WHITE);
		theatreSelectComboBox.setBounds(600, 180, 200, 28);
		theatreSelectComboBox.setOpaque(true);
		theatreSelectComboBox.setVisible(false);
		theatreSelectComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Theatre Combo Box Pressed: " + theatreSelectComboBox.getSelectedItem());
				currentTheatre = backend.getDataController()
						.findTheatre((String) theatreSelectComboBox.getSelectedItem());
				noTheatreSelectedLabel.setVisible(false);
				if (currentTheatre != null) {
					theatreDetailsLabel.setText("Name: " + currentTheatre.getT_name() + "\nAddress: "
							+ currentTheatre.getAddress() + "\nPhone: " + currentTheatre.getPhoneNumber());
					currentTheatre = backend.getDataController()
							.findTheatre((String) theatreSelectComboBox.getSelectedItem());
					if (currentTheatre != null) {
						theatreDetailsLabel.setText("Name: " + currentTheatre.getT_name() + "\nAddress: "
								+ currentTheatre.getAddress() + "\nPhone: " + currentTheatre.getPhoneNumber());
						theatreDetailsLabel.setVisible(true);

						DefaultComboBoxModel model2 = (DefaultComboBoxModel) showtimeSelectComboBox.getModel();
						model2.removeAllElements();
						ArrayList<Showtime> showtimeList = backend.getDataController().findAllShowtime(currentMovie,
								currentTheatre);
						for (int i = 0; i < showtimeList.size(); i++) {
							System.out.println(showtimeList.get(i).getShowDate().getDate());
							model2.addElement(showtimeList.get(i).getShowDate().getDate());
						}
						showtimeSelectComboBox.setModel(model2);
						showtimeSelectComboBox.setVisible(true);
						noShowTimeSelectedLabel.setVisible(true);
						selectShowtimeLabel.setVisible(true);
					} else {
						System.out.println("No theatre found");
						theatreDetailsLabel.setVisible(false);
					}
				}
			}
		});
		add(theatreSelectComboBox);

		// ==========================================
		// SELECT MOVIE
		// ==========================================

		// CREATE SELECT MOVIE TEXT
		JLabel selectMovieLabel = new JLabel("Movie");
		selectMovieLabel.setHorizontalAlignment(SwingConstants.LEFT);
		selectMovieLabel.setForeground(Color.WHITE);
		selectMovieLabel.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		selectMovieLabel.setBounds(85, 140, 67, 32);
		add(selectMovieLabel);

		// CREATE MOVIE DETAILS TEXT
		JTextArea movieDetailsLabel = new JTextArea("");
		movieDetailsLabel.setForeground(Color.WHITE);
		movieDetailsLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		movieDetailsLabel.setBounds(273, 233, 123, 268);
		movieDetailsLabel.setVisible(false);
		movieDetailsLabel.setLineWrap(true);
		movieDetailsLabel.setWrapStyleWord(true);
		movieDetailsLabel.setOpaque(false);
		movieDetailsLabel.setEditable(false);
		add(movieDetailsLabel);

		JTextArea movieSynopsisLabel = new JTextArea("");
		movieSynopsisLabel.setForeground(Color.WHITE);
		movieSynopsisLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		movieSynopsisLabel.setBounds(85, 525, 311, 134);
		movieSynopsisLabel.setVisible(false);
		movieSynopsisLabel.setLineWrap(true);
		movieSynopsisLabel.setWrapStyleWord(true);
		movieSynopsisLabel.setOpaque(false);
		movieSynopsisLabel.setEditable(false);
		add(movieSynopsisLabel);

		// CREATE POSTER CARD VIEW
		JLabel posterCard = new JLabel("");
		posterCard.setBounds(85, 235, 182, 268);
		posterCard.setVisible(true);
		add(posterCard);

		// CREATE MOVIE SELECTOR
		Vector<String> movieList = new Vector<String>();
		for (int i = 0; i < backend.getDataController().getMovieList().size(); i++) {
			movieList.add(backend.getDataController().getMovieList().get(i).getTitle());
		}
		JComboBox movieSelectComboBox = new JComboBox(movieList);
		movieSelectComboBox.setToolTipText("Select Movie");
		movieSelectComboBox.setFont(new Font("HelveticaNeue", Font.PLAIN, 15));
		movieSelectComboBox.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.LIGHT_GRAY));
		movieSelectComboBox.setForeground(Color.DARK_GRAY);
		movieSelectComboBox.setBackground(Color.WHITE);
		movieSelectComboBox.setBounds(85, 180, 311, 28);
		movieSelectComboBox.setOpaque(true);
		movieSelectComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Movie Combo Box Pressed: " + movieSelectComboBox.getSelectedItem());
				String temp = (String) movieSelectComboBox.getSelectedItem();

				currentMovie = backend.getDataController().findMovie(temp);
				currentTheatre = null;

				movieDetailsLabel.setText(currentMovie.getTitle() + "\n\nGenre: " + currentMovie.getGenre()
						+ "\n\nYear: " + currentMovie.getYear() + "\n\nDirector: " + currentMovie.getDirector()
						+ "\n\nMovie Length: " + currentMovie.getMovieLength() + " mins\n\nRating: "
						+ currentMovie.getRating());

				posterCard.setIcon(new ImageIcon(HomePage.class.getResource("/" + currentMovie.getPoster() + ".jpg")));

				movieDetailsLabel.setVisible(true);
				selectTheatreLabel.setVisible(true);
				theatreDetailsLabel.setVisible(false);
				showtimeSelectComboBox.setVisible(false);
				selectShowtimeLabel.setVisible(false);
				noMovieSelectedLabel.setVisible(false);
				noTheatreSelectedLabel.setVisible(true);
				posterCard.setVisible(true);

				DefaultComboBoxModel model = (DefaultComboBoxModel) theatreSelectComboBox.getModel();
				model.removeAllElements();
				ArrayList<Theatre> theatreList = backend.getDataController().findTheatresPlayingMovie(currentMovie);
				for (int i = 0; i < theatreList.size(); i++) {
					System.out.println(theatreList.get(i).getT_name());
					model.addElement(theatreList.get(i).getT_name());
				}
				theatreSelectComboBox.setModel(model);
				theatreSelectComboBox.setVisible(true);
				frame.revalidate();
			}
		});
		add(movieSelectComboBox);

		// CREATE WELCOME TEXT LABEL
		JLabel welcomeLabel = new JLabel("");
		if (backend.getCurrentUser() == null) {
			welcomeLabel = new JLabel("Welcome, Guest!");
		} else {
			welcomeLabel = new JLabel("Welcome, " + backend.getCurrentUser().getF_name() + " "
					+ backend.getCurrentUser().getL_name() + "!");
		}
		welcomeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		welcomeLabel.setForeground(Color.WHITE);
		welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 25));
		welcomeLabel.setBounds(140, 5, 571, 50);
		add(welcomeLabel);

		// CREATE LOGOUT BUTTON
		logoutButton = new JLabel("");
		logoutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logoutButton.setToolTipText("Logout");
		logoutButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				backend.userLogout();
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
				System.out.println("View Cart");
				CartPage cartPanel = new CartPage(frame, backend);
				frame.setContentPane(cartPanel);
				frame.revalidate();
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
				System.out.println("Announcement");
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
