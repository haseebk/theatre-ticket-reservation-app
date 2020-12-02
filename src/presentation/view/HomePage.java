package presentation.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.MatteBorder;

import java.io.Serializable;
import java.time.LocalDate;

import domain.model.*;

public class HomePage extends JPanel {

	private static final long serialVersionUID = 1L;

	// Back button
	private JLabel logoutButton;

	// Cart button
	private JLabel cartButton;

	// Announcement button
	private JLabel announcementButton;

	// PayAnnualFee button
	private JLabel annualFeeButton;

	// Label displaying No Theatre Selected
	private JLabel noTheatreSelectedLabel;

	// Label displaying No Showtime Selected
	private JLabel noShowTimeSelectedLabel;

	// Label displaying No Movie Selected
	private JLabel noMovieSelectedLabel;

	// Button to Cancel Ticket
	private JLabel cancelTicketButton;

	// Textfield for user to enter their desired row for their seat
	private JTextField rowTextField;

	// Textfield for user to enter their desired column for their seat
	private JTextField colTextField;

	// Label displaying Select Row
	private JLabel selectRowLabel;

	// Label displaying Select Column
	private JLabel selectColLabel;

	// Label displaying Invalid Seat was Selected
	private JLabel invalidSeatErrorLabel;

	// Label displaying Taken Seat was Selected
	private JLabel takenSeatErrorLabel;

	// Label displaying Selected Seat was Selected Error
	private JLabel selectedSeatErrorLabel;

	// Label displaying Selected Seat was Selected Error
	private JLabel privateMovieBookingErrorLabel;

	// Label displaying Added to Cart
	private JLabel addedToCartLabel;

	// TextArea which depicts the Graphic of Seat Avaliability, X if booked, O if
	// avaliable, - if Selected
	private JTextArea seatGraphicLabel;

	// Button that adds seat selection to Cart
	private JLabel AddToCartButton;

	// Label displaying Select Seat
	private JLabel selectSeatLabel;

	// Label displaying Select Showtime
	private JLabel selectShowtimeLabel;

	// TextArea displaying the selected Showtime details
	private JTextArea showtimeDetailsLabel;

	// ComboBox to selected desired Showtime
	private JComboBox showtimeSelectComboBox;

	// Label displaying Select Theatre
	private JLabel selectTheatreLabel;
	// TextArea displaying details of the selected Theatre

	private JTextArea theatreDetailsLabel;
	// ComboBox that select desired Theatre

	JComboBox theatreSelectComboBox;
	// Label displaying Select Movie

	private JLabel selectMovieLabel;
	// TextArea displaying selected Movie details

	private JTextArea movieDetailsLabel;
	// TextArea displaying selected Movie's Synopsis

	private JTextArea movieSynopsisLabel;
	// Label displaying the Movie's Poster

	private JLabel posterCard;
	// Combobox for selecting desired movie

	private JComboBox movieSelectComboBox;
	// Label displaying Welcome to the User

	private JLabel welcomeLabel;
	// Displays Movie Card

	private JLabel movieCard;
	// Displays Auditorium Card

	private JLabel auditoriumCard;
	// Displays the Background Graphic

	private JLabel homeBackground;

	// Current movie being chosen
	private Movie currentMovie;

	// Current theatre being chosen
	private Theatre currentTheatre;

	// Current showtime being chosen
	private Showtime currentShowtime;

	public HomePage(JFrame frame, BackEnd backend) {
		setLayout(null);

		// CREATE NO THEATRE SELECTED TEXT LABEL
		// Label displaying No Theatre Selected
		noTheatreSelectedLabel = new JLabel("<html>" + "Please select a theatre." + "</html>");
		noTheatreSelectedLabel.setHorizontalAlignment(SwingConstants.LEFT);
		noTheatreSelectedLabel.setForeground(Color.RED);
		noTheatreSelectedLabel.setFont(new Font("HelveticaNeue", Font.PLAIN, 15));
		noTheatreSelectedLabel.setBounds(840, 392, 170, 45);
		noTheatreSelectedLabel.setVisible(false);
		add(noTheatreSelectedLabel);

		// CREATE NO SHOWTIME SELECTED TEXT LABEL
		// Label displaying No Showtime Selected
		noShowTimeSelectedLabel = new JLabel("<html>" + "Please select a show time." + "</html>");
		noShowTimeSelectedLabel.setHorizontalAlignment(SwingConstants.LEFT);
		noShowTimeSelectedLabel.setForeground(Color.RED);
		noShowTimeSelectedLabel.setFont(new Font("HelveticaNeue", Font.PLAIN, 15));
		noShowTimeSelectedLabel.setBounds(829, 392, 192, 45);
		noShowTimeSelectedLabel.setVisible(false);
		add(noShowTimeSelectedLabel);

		// CREATE NO MOVIE SELECTED TEXT LABEL
		// Label displaying No Movie Selected
		noMovieSelectedLabel = new JLabel("<html>" + "Please select a movie." + "</html>");
		noMovieSelectedLabel.setHorizontalAlignment(SwingConstants.LEFT);
		noMovieSelectedLabel.setForeground(Color.RED);
		noMovieSelectedLabel.setFont(new Font("HelveticaNeue", Font.PLAIN, 15));
		noMovieSelectedLabel.setBounds(156, 392, 168, 45);
		noMovieSelectedLabel.setVisible(false);
		add(noMovieSelectedLabel);

		// =========================================
		// SELECT SEAT
		// =========================================

		// CREATE ROW TEXT FIELD
		// Textfield for user to enter their desired row for their seat
		rowTextField = new JTextField();
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
		// Textfield for user to enter their desired column for their seat
		colTextField = new JTextField();
		colTextField.setToolTipText("Enter Seat Number");
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
		// Label displaying Select Row
		selectRowLabel = new JLabel("Select Row: ");
		selectRowLabel.setHorizontalAlignment(SwingConstants.LEFT);
		selectRowLabel.setForeground(Color.WHITE);
		selectRowLabel.setFont(new Font("HelveticaNeue", Font.PLAIN, 15));
		selectRowLabel.setBounds(1100, 280, 200, 45);
		selectRowLabel.setVisible(false);
		add(selectRowLabel);

		// CREATE SELECT COLUMN TEXT
		// Label displaying Select Column
		selectColLabel = new JLabel("Select Seat Number: ");
		selectColLabel.setHorizontalAlignment(SwingConstants.LEFT);
		selectColLabel.setForeground(Color.WHITE);
		selectColLabel.setFont(new Font("HelveticaNeue", Font.PLAIN, 15));
		selectColLabel.setBounds(1100, 340, 200, 45);
		selectColLabel.setVisible(false);
		add(selectColLabel);

		// CREATE INVALID SEAT ERROR TEXT LABEL
		// Label displaying Invalid Seat was Selected Error
		invalidSeatErrorLabel = new JLabel("<html>" + "Invalid Row or Seat Number was Selected" + "</html>");
		invalidSeatErrorLabel.setHorizontalAlignment(SwingConstants.LEFT);
		invalidSeatErrorLabel.setForeground(Color.RED);
		invalidSeatErrorLabel.setFont(new Font("HelveticaNeue", Font.PLAIN, 15));
		invalidSeatErrorLabel.setBounds(1100, 500, 192, 45);
		invalidSeatErrorLabel.setVisible(false);
		add(invalidSeatErrorLabel);

		// CREATE TAKEN SEAT ERROR TEXT LABEL
		// Label displaying Taken Seat was Selected Error
		takenSeatErrorLabel = new JLabel("<html>" + "The Seat Selected is already Booked" + "</html>");
		takenSeatErrorLabel.setHorizontalAlignment(SwingConstants.LEFT);
		takenSeatErrorLabel.setForeground(Color.RED);
		takenSeatErrorLabel.setFont(new Font("HelveticaNeue", Font.PLAIN, 15));
		takenSeatErrorLabel.setBounds(1100, 500, 192, 45);
		takenSeatErrorLabel.setVisible(false);
		add(takenSeatErrorLabel);

		// CREATE TAKEN SEAT ERROR TEXT LABEL
		// Label displaying Selected Seat was Selected Error
		selectedSeatErrorLabel = new JLabel("<html>" + "The Seat Selected is already Selected" + "</html>");
		selectedSeatErrorLabel.setHorizontalAlignment(SwingConstants.LEFT);
		selectedSeatErrorLabel.setForeground(Color.RED);
		selectedSeatErrorLabel.setFont(new Font("HelveticaNeue", Font.PLAIN, 15));
		selectedSeatErrorLabel.setBounds(1100, 500, 192, 45);
		selectedSeatErrorLabel.setVisible(false);
		add(selectedSeatErrorLabel);

		// CREATE TAKEN SEAT ERROR TEXT LABEL
		// Label displaying Selected Seat was Selected Error
		privateMovieBookingErrorLabel = new JLabel("<html>"
				+ "The Current Private Movie Listing Has Hit the Maximum Number of Booking for the Private Announcement"
				+ "</html>");
		privateMovieBookingErrorLabel.setHorizontalAlignment(SwingConstants.LEFT);
		privateMovieBookingErrorLabel.setForeground(Color.RED);
		privateMovieBookingErrorLabel.setFont(new Font("HelveticaNeue", Font.PLAIN, 15));
		privateMovieBookingErrorLabel.setBounds(1100, 500, 192, 100);
		privateMovieBookingErrorLabel.setVisible(false);
		add(privateMovieBookingErrorLabel);

		// CREATE ADDED TO CART TEXT LABEL
		// Label displaying Added to Cart
		addedToCartLabel = new JLabel("<html>" + "Added To Cart" + "</html>");
		addedToCartLabel.setHorizontalAlignment(SwingConstants.LEFT);
		addedToCartLabel.setForeground(Color.RED);
		addedToCartLabel.setFont(new Font("HelveticaNeue", Font.PLAIN, 15));
		addedToCartLabel.setBounds(1100, 500, 192, 45);
		addedToCartLabel.setVisible(false);
		add(addedToCartLabel);

		// CREATE ADD TO CART BUTTON
		// Button that adds seat selection to Cart
		seatGraphicLabel = new JTextArea("");
		AddToCartButton = new JLabel("Add To Cart");
		AddToCartButton.setToolTipText("Add To Cart");
		AddToCartButton.setForeground(Color.WHITE);
		AddToCartButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		/**
		 * When add to cart button is pressed, pull all information from fields and
		 * verify if user input was valid. If valid and unique inputs, add the selected
		 * showtime combo to user cart.
		 */
		AddToCartButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if ((backend.getCurrentUser().getUserType().compareTo("Registered") == 0
						&& backend.getCurrentRegisteredUser().isFeePayed()) || backend.getCurrentUser().getUserType().compareTo("Guest") == 0) {
					try {
						// Get user entered row and column
						int userRow = Integer.parseInt(rowTextField.getText());
						int userCol = Integer.parseInt(colTextField.getText());

						invalidSeatErrorLabel.setVisible(false);
						takenSeatErrorLabel.setVisible(false);
						addedToCartLabel.setVisible(false);
						selectedSeatErrorLabel.setVisible(false);
						privateMovieBookingErrorLabel.setVisible(false);
						// If user entered a valid row and column
						if (userRow < currentShowtime.getRow() && userCol < currentShowtime.getCol()) {
							boolean available = currentShowtime.getSeatAvaliability(userRow, userCol);
							if (available == false) {
								boolean selectFlag = false;
								// If already selected
								for (int k = 0; k < backend.getCurrentUser().getCart().getItems_in_cart().size(); k++) {
									if (backend.getCurrentUser().getCart().getItems_in_cart().get(k).getBookedSeat()
											.getRow() == userRow
											&& backend.getCurrentUser().getCart().getItems_in_cart().get(k)
													.getBookedSeat().getSeatNum() == userCol
											&& backend.getCurrentUser().getCart().getItems_in_cart().get(k)
													.getBookedTime()
													.getShowtimeID() == currentShowtime.getShowtimeID()) {
										selectedSeatErrorLabel.setVisible(true);
										selectFlag = true;
									}
								}
								if (!selectFlag) {
									if (currentShowtime.getMovie().getMovieAnnouncement().isPrivateOnly()) {
										int numSelectedSeats = 0;
										for (int i = 0; i < backend.getCurrentUser().getCart().getItems_in_cart()
												.size(); i++) {
											if (currentMovie.getTitle().compareTo(backend.getCurrentUser().getCart()
													.getItems_in_cart().get(i).getBookedMovie().getTitle()) == 0) {
												numSelectedSeats++;
											}
										}
										if ((currentShowtime.getTotalAvaliableSeats()
												- (numSelectedSeats + 1) > (currentShowtime.getRow()
														* currentShowtime.getCol() * 0.9))) {
											backend.getCurrentUser().getCart().addToCart(new Booking(currentMovie,
													currentShowtime, currentShowtime.getSeats()[userRow][userCol]));
											addedToCartLabel.setVisible(true);
											createSeatGraphic(frame, backend);
										} else {
											privateMovieBookingErrorLabel.setVisible(true);
										}
									} else {
										backend.getCurrentUser().getCart().addToCart(new Booking(currentMovie,
												currentShowtime, currentShowtime.getSeats()[userRow][userCol]));
										addedToCartLabel.setVisible(true);
										createSeatGraphic(frame, backend);
									}
								}
							} else {
								// Seat already taken
								takenSeatErrorLabel.setVisible(true);
							}
						} else {
							// Invalid row or column
							invalidSeatErrorLabel.setVisible(true);
						}
						frame.revalidate();
					} catch (NumberFormatException f) {
						System.out.println(f);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Annual Fee needs to be payed to continue.",
							(String) "Annual Fee Payment", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		AddToCartButton.setBounds(1050, 425, 254, 50);
		AddToCartButton.setVisible(false);
		AddToCartButton.setIcon(new ImageIcon(LoginPage.class.getResource("/addToCartButton.png")));
		add(AddToCartButton);

		// Only allow registered users to add movies to cart if they have payed the
		// annual fee

		// CREATE ADDED TO CART TEXT LABEL
		// Label displaying Added to Cart
		addedToCartLabel = new JLabel("<html>" + "Added To Cart" + "</html>");
		addedToCartLabel.setHorizontalAlignment(SwingConstants.LEFT);
		addedToCartLabel.setForeground(Color.RED);
		addedToCartLabel.setFont(new Font("HelveticaNeue", Font.PLAIN, 15));
		addedToCartLabel.setBounds(1100, 500, 192, 45);
		addedToCartLabel.setVisible(false);
		add(addedToCartLabel);
		
		// CREATE SELECT SEAT TEXT
		// Label displaying Select Seat
		selectSeatLabel = new JLabel("Please Enter Seat");
		selectSeatLabel.setHorizontalAlignment(SwingConstants.LEFT);
		selectSeatLabel.setForeground(Color.WHITE);
		selectSeatLabel.setFont(new Font("HelveticaNeue", Font.PLAIN, 15));
		selectSeatLabel.setBounds(600, 280, 254, 45);
		selectSeatLabel.setVisible(false);
		add(selectSeatLabel);

		// CREATE SEAT GRAPHIC DETAILS TEXT
		// TextArea which depicts the Graphic of Seat Avaliability, X if booked, O if
		// avaliable, - if Selected
		seatGraphicLabel.setForeground(Color.WHITE);
		seatGraphicLabel.setFont(new Font("Courier New", Font.PLAIN, 15));
		seatGraphicLabel.setBounds(600, 310, 500, 500);
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
		// Label displaying Select Showtime
		selectShowtimeLabel = new JLabel("Show Time");
		selectShowtimeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		selectShowtimeLabel.setForeground(Color.WHITE);
		selectShowtimeLabel.setFont(new Font("HelveticaNeue", Font.PLAIN, 15));
		selectShowtimeLabel.setBounds(900, 140, 254, 45);
		selectShowtimeLabel.setVisible(false);
		add(selectShowtimeLabel);

		// CREATE SHOWTIME DETAILS TEXT
		// TextArea displaying the selected Showtime details
		showtimeDetailsLabel = new JTextArea("");
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
		// ComboBox to select desired Showtime
		showtimeSelectComboBox = new JComboBox(new String[0]);
		showtimeSelectComboBox.setToolTipText("Select Date");
		showtimeSelectComboBox.setFont(new Font("HelveticaNeue", Font.PLAIN, 15));
		showtimeSelectComboBox.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.LIGHT_GRAY));
		showtimeSelectComboBox.setForeground(Color.DARK_GRAY);
		showtimeSelectComboBox.setBackground(Color.WHITE);
		showtimeSelectComboBox.setBounds(900, 180, 200, 28);
		showtimeSelectComboBox.setOpaque(true);
		showtimeSelectComboBox.setVisible(false);
		/**
		 * From the dropdown menu, save what the user has selected and update the screen
		 * accordingly
		 */
		showtimeSelectComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String tempString = (String) showtimeSelectComboBox.getSelectedItem();
				noShowTimeSelectedLabel.setVisible(false);
				invalidSeatErrorLabel.setVisible(false);
				takenSeatErrorLabel.setVisible(false);
				addedToCartLabel.setVisible(false);
				selectedSeatErrorLabel.setVisible(false);
				privateMovieBookingErrorLabel.setVisible(false);
				if (tempString != null) {
					String[] tempStringArray = tempString.split("/");
					Date tempDate = new Date(Integer.parseInt(tempStringArray[0]), Integer.parseInt(tempStringArray[1]),
							Integer.parseInt(tempStringArray[2]));
					currentShowtime = backend.getDataController().findShowtime(currentMovie, currentTheatre, tempDate);
					if (currentShowtime != null) {
						showtimeDetailsLabel
								.setText("Time: " + currentShowtime.getHour() + ":" + currentShowtime.getMinutes()
										+ "\nAuditorium: " + currentShowtime.getAuditorium().getAuditoriumID()
										+ "\nNumber of Avaliable Seats: " + currentShowtime.getTotalAvaliableSeats());

						showtimeDetailsLabel.setVisible(true);
						rowTextField.setVisible(true);
						colTextField.setVisible(true);
						selectRowLabel.setVisible(true);
						selectColLabel.setVisible(true);
						AddToCartButton.setVisible(true);

						createSeatGraphic(frame, backend);
						selectSeatLabel.setVisible(true);
					} else {
						showtimeDetailsLabel.setVisible(false);
					}
				} else {
					showtimeDetailsLabel.setVisible(false);
				}
			}
		});
		add(showtimeSelectComboBox);

		// ==========================================
		// SELECT THEATRE
		// ==========================================

		// CREATE SELECT THEATRE TEXT
		// Label displaying Select Theatre
		selectTheatreLabel = new JLabel("Theatre");
		selectTheatreLabel.setHorizontalAlignment(SwingConstants.LEFT);
		selectTheatreLabel.setForeground(Color.WHITE);
		selectTheatreLabel.setFont(new Font("HelveticaNeue", Font.PLAIN, 15));
		selectTheatreLabel.setBounds(600, 140, 254, 45);
		selectTheatreLabel.setVisible(false);
		add(selectTheatreLabel);

		// CREATE THEATRE DETAILS TEXT
		// TextArea displaying details of the selected Theatre
		theatreDetailsLabel = new JTextArea("");
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
		// ComboBox that select desired Theatre
		theatreSelectComboBox = new JComboBox(new String[0]);
		theatreSelectComboBox.setToolTipText("Select Theatre");
		theatreSelectComboBox.setFont(new Font("HelveticaNeue", Font.PLAIN, 15));
		theatreSelectComboBox.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.LIGHT_GRAY));
		theatreSelectComboBox.setForeground(Color.DARK_GRAY);
		theatreSelectComboBox.setBackground(Color.WHITE);
		theatreSelectComboBox.setBounds(600, 180, 200, 28);
		theatreSelectComboBox.setOpaque(true);
		theatreSelectComboBox.setVisible(false);
		/**
		 * From the dropdown menu, save what the user has selected and update the screen
		 * accordingly
		 */
		theatreSelectComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				currentTheatre = backend.getDataController()
						.findTheatre((String) theatreSelectComboBox.getSelectedItem());
				noTheatreSelectedLabel.setVisible(false);
				if (currentTheatre != null) {
					theatreDetailsLabel.setText("Name: " + currentTheatre.getT_name() + "\nAddress: "
							+ currentTheatre.getAddress() + "\nPhone: " + currentTheatre.getPhoneNumber());
					currentTheatre = backend.getDataController()
							.findTheatre((String) theatreSelectComboBox.getSelectedItem());
					currentShowtime = null;
					if (currentTheatre != null) {
						theatreDetailsLabel.setText("Name: " + currentTheatre.getT_name() + "\nAddress: "
								+ currentTheatre.getAddress() + "\nPhone: " + currentTheatre.getPhoneNumber());
						theatreDetailsLabel.setVisible(true);

						DefaultComboBoxModel model2 = (DefaultComboBoxModel) showtimeSelectComboBox.getModel();
						model2.removeAllElements();
						ArrayList<Showtime> showtimeList = backend.getDataController().findAllShowtime(currentMovie,
								currentTheatre);
						for (int i = 0; i < showtimeList.size(); i++) {
							model2.addElement(showtimeList.get(i).getShowDate().toString());
						}
						showtimeSelectComboBox.setModel(model2);
						showtimeSelectComboBox.setVisible(true);
						// noShowTimeSelectedLabel.setVisible(true);
						selectShowtimeLabel.setVisible(true);
					} else {
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
		// Label displaying Select Movie
		selectMovieLabel = new JLabel("Movie");
		selectMovieLabel.setHorizontalAlignment(SwingConstants.LEFT);
		selectMovieLabel.setForeground(Color.WHITE);
		selectMovieLabel.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		selectMovieLabel.setBounds(85, 140, 67, 32);
		add(selectMovieLabel);

		// CREATE MOVIE DETAILS TEXT
		// TextArea displaying selected Movie details
		movieDetailsLabel = new JTextArea("");
		movieDetailsLabel.setForeground(Color.WHITE);
		movieDetailsLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		movieDetailsLabel.setBounds(273, 233, 123, 268);
		movieDetailsLabel.setVisible(false);
		movieDetailsLabel.setLineWrap(true);
		movieDetailsLabel.setWrapStyleWord(true);
		movieDetailsLabel.setOpaque(false);
		movieDetailsLabel.setEditable(false);
		add(movieDetailsLabel);

		// CREATE MOVIE SYNOPSIS TEXT
		// TextArea displaying selected Movie's Synopsis
		movieSynopsisLabel = new JTextArea("");
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
		// Label displaying the Movie's Poster
		posterCard = new JLabel("");
		posterCard.setBounds(85, 235, 182, 268);
		posterCard.setVisible(true);
		add(posterCard);

		// CREATE MOVIE SELECTOR
		// Combobox for selecting desired movie
		Vector<String> movieList = new Vector<String>();
		for (int i = 0; i < backend.getDataController().getMovieList().size(); i++) {
			if (backend.getCurrentRegisteredUser() != null) {
				if (!backend.getDataController().getMovieList().get(i).getMovieAnnouncement().getPrivateAnnounceDate()
						.beforeCurrentDate())
					movieList.add(backend.getDataController().getMovieList().get(i).getTitle());
			} else {
				if (!backend.getDataController().getMovieList().get(i).getMovieAnnouncement().getPublicAnnounceDate()
						.beforeCurrentDate())
					movieList.add(backend.getDataController().getMovieList().get(i).getTitle());
			}
		}
		movieSelectComboBox = new JComboBox(movieList);
		movieSelectComboBox.setToolTipText("Select Movie");
		movieSelectComboBox.setFont(new Font("HelveticaNeue", Font.PLAIN, 15));
		movieSelectComboBox.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.LIGHT_GRAY));
		movieSelectComboBox.setForeground(Color.DARK_GRAY);
		movieSelectComboBox.setBackground(Color.WHITE);
		movieSelectComboBox.setBounds(85, 180, 311, 28);
		movieSelectComboBox.setOpaque(true);
		/**
		 * From the dropdown menu, save what the user has selected and update the screen
		 * accordingly
		 */
		movieSelectComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String temp = (String) movieSelectComboBox.getSelectedItem();

				currentMovie = backend.getDataController().findMovie(temp);
				currentTheatre = null;
				currentShowtime = null;

				movieDetailsLabel.setText(currentMovie.getTitle() + "\n\nGenre: " + currentMovie.getGenre()
						+ "\n\nYear: " + currentMovie.getYear() + "\n\nDirector: " + currentMovie.getDirector()
						+ "\n\nMovie Length: " + currentMovie.getMovieLength() + " mins\n\nRating: "
						+ currentMovie.getRating());

				posterCard.setIcon(new ImageIcon(HomePage.class.getResource("/" + currentMovie.getPoster() + ".jpg")));

				movieDetailsLabel.setVisible(true);
				selectTheatreLabel.setVisible(true);
				noTheatreSelectedLabel.setVisible(true);
				posterCard.setVisible(true);
				movieSynopsisLabel.setVisible(true);

				DefaultComboBoxModel model = (DefaultComboBoxModel) theatreSelectComboBox.getModel();
				model.removeAllElements();
				ArrayList<Theatre> theatreList = backend.getDataController().findTheatresPlayingMovie(currentMovie);
				for (int i = 0; i < theatreList.size(); i++) {
					model.addElement(theatreList.get(i).getT_name());
				}
				theatreSelectComboBox.setModel(model);
				theatreSelectComboBox.setVisible(true);
				frame.revalidate();
			}
		});
		add(movieSelectComboBox);

		// =======================================
		// MENU BUTTONS AND LABELS
		// =======================================

		// CREATE WELCOME TEXT LABEL
		// Label displaying Welcome to the User
		welcomeLabel = new JLabel("");
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

		// CREATE CANCEL TICKET BUTTON
		// Button to Cancel Ticket
		cancelTicketButton = new JLabel("Cancel Ticket");
		cancelTicketButton.setToolTipText("Cancel Ticket");
		cancelTicketButton.setForeground(Color.WHITE);
		cancelTicketButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		/**
		 * When cancel ticket button is pressed, change the view to cancel ticket page
		 */
		cancelTicketButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CancelTicketPage cancelTicketPage = new CancelTicketPage(frame, backend);
				frame.setContentPane(cancelTicketPage);
				frame.revalidate();

			}
		});
		cancelTicketButton.setBounds(1366 - 32 - 90 - 60, 14, 32, 32);
		cancelTicketButton.setVisible(true);
		cancelTicketButton.setIcon(new ImageIcon(LoginPage.class.getResource("/refundButton.png")));
		add(cancelTicketButton);

		// CREATE LOGOUT BUTTON
		// Button to Logout the User
		logoutButton = new JLabel("");
		logoutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logoutButton.setToolTipText("Logout");
		/**
		 * When the logout button is pressed, sign the user out and change the view to
		 * the login page
		 */
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

		// CREATE ANNUALFEE BUTTON
		// Button to pay annual fee for registered users
		if (backend.getCurrentUser().getUserType().compareTo("Registered") == 0) {
			annualFeeButton = new JLabel("");
			annualFeeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			annualFeeButton.setToolTipText("Pay Annual Fee");
			/**
			 * When the annualFee button is pressed, process payment
			 */
			annualFeeButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {

					// Check if annual fee hasn't been payed
					if (!backend.getCurrentRegisteredUser().getAdminFeeDate().beforeCurrentDate()) {
						// Verify card to process payment
						String name = backend.getCurrentRegisteredUser().getF_name() + " "
								+ backend.getCurrentRegisteredUser().getL_name();
						String ct = backend.getCurrentRegisteredUser().getBankInfo().getCardType();
						String cn = backend.getCurrentRegisteredUser().getBankInfo().getCardNumber();
						String cvs = backend.getCurrentRegisteredUser().getBankInfo().getCardSVS();
						String exp = backend.getCurrentRegisteredUser().getBankInfo().getCardExpirationDate()
								.toString();
						if (backend.getDataController().getInst().verifyCardInfo(name, ct, cn, cvs, exp)) {
							JOptionPane.showMessageDialog(null,
									"Annual Fee has been successfully payed. Purchase Cost: $20",
									(String) "Annual Fee Payment", JOptionPane.INFORMATION_MESSAGE);
							LocalDate today = LocalDate.now();
							Date date = new Date(today.getDayOfMonth(),today.getMonthValue(),today.getYear() + 1);
							backend.getCurrentRegisteredUser().setAdminFeeDate(date);
						} else {
							JOptionPane.showMessageDialog(null, "Annual Fee payment was unsuccessful.",
									(String) "Annual Fee Payment", JOptionPane.INFORMATION_MESSAGE);
						}
						// HomePage homePanel = new HomePage(frame, backend);
						// frame.setContentPane(homePanel);
					} else {
						JOptionPane.showMessageDialog(null, "Annual Fee has been already payed.",
								(String) "Annual Fee Payment", JOptionPane.INFORMATION_MESSAGE);
					}

					frame.revalidate();
				}
			});
			annualFeeButton.setBounds(1366 - 32 - 210, 14, 32, 32);
			annualFeeButton.setIcon(new ImageIcon(HomePage.class.getResource("/membershipButton.png")));
			add(annualFeeButton);
		}

		// CREATE CART BUTTON
		// Button to view current cart
		cartButton = new JLabel("");
		cartButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cartButton.setToolTipText("View Cart");
		/**
		 * When the cart button is pressed, change the view to the cart page
		 */
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

		// CREATE ACCOUNCEMENT BUTTON
		// Button to view current Announcements
		announcementButton = new JLabel("");
		announcementButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		announcementButton.setToolTipText("View Announcements");
		announcementButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AnnouncementPage announcementPanel = new AnnouncementPage(frame, backend);
				frame.setContentPane(announcementPanel);
				frame.revalidate();
			}
		});
		announcementButton.setBounds(1366 - 32 - 90, 14, 32, 32);
		announcementButton.setIcon(new ImageIcon(HomePage.class.getResource("/megaphoneButton.png")));
		add(announcementButton);

		// CREATE MOVIE CARD VIEW
		// Displays Movie Card
		movieCard = new JLabel("");
		movieCard.setBounds(40, 132, 401, 564);
		movieCard.setIcon(new ImageIcon(HomePage.class.getResource("/movieCard.png")));
		add(movieCard);

		// CREATE AUDITORIUM CARD VIEW
		// Displays Auditorium Card
		auditoriumCard = new JLabel("");
		auditoriumCard.setBounds(525, 132, 801, 564);
		auditoriumCard.setIcon(new ImageIcon(HomePage.class.getResource("/auditoriumCard.png")));
		add(auditoriumCard);

		// CREATE BACKGROUND VIEW
		// Displays the Background Graphic
		homeBackground = new JLabel("");
		homeBackground.setBounds(-2, -1, 1366, 768);
		homeBackground.setIcon(new ImageIcon(HomePage.class.getResource("/backgroundD.png")));
		add(homeBackground);
	}

	public void createSeatGraphic(JFrame frame, BackEnd backend) {
		String tempGraphic = "";
		for (int i = 0; i < currentShowtime.getRow(); i++) {
			if (i == 0) {
				tempGraphic += "     ";
				for (int j = 0; j < currentShowtime.getCol(); j++) {
					tempGraphic += j + "  ";
				}
				tempGraphic += "Seat Num";
				tempGraphic += "\n   --";
				for (int j = 0; j < currentShowtime.getCol(); j++) {
					tempGraphic += "---";
				}
				tempGraphic += "\n";
			}
			for (int j = 0; j < currentShowtime.getCol(); j++) {
				if (j == 0) {
					tempGraphic += i + "  | ";
				}
				if (currentShowtime.getSeatAvaliability(i, j) == true) {
					tempGraphic += "X  ";
				} else if (backend.getCurrentUser() != null) {
					boolean tempFlag = false;
					for (int k = 0; k < backend.getCurrentUser().getCart().getItems_in_cart().size(); k++) {
						if (backend.getCurrentUser().getCart().getItems_in_cart().get(k).getBookedSeat().getRow() == i
								&& backend.getCurrentUser().getCart().getItems_in_cart().get(k).getBookedSeat()
										.getSeatNum() == j
								&& backend.getCurrentUser().getCart().getItems_in_cart().get(k).getBookedTime()
										.getShowtimeID() == currentShowtime.getShowtimeID()) {
							tempGraphic += "-  ";
							tempFlag = true;
						}
					}
					if (tempFlag == false) {
						tempGraphic += "O  ";
					}
				} else {
					tempGraphic += "O  ";
				}
			}
			tempGraphic += "\n";
		}
		tempGraphic += "Row\nO = Avaliable, X = Booked, - = Selected";
		seatGraphicLabel.setText(tempGraphic);
		seatGraphicLabel.setVisible(true);
	}
}
