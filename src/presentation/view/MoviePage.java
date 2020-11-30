package presentation.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.MatteBorder;

import domain.model.BackEnd;
import domain.model.Movie;

public class MoviePage extends JPanel {
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

    //Current movie being selected
    private Movie currentMovie;

    public MoviePage(JFrame frame, BackEnd backend, String movie) {
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

        /*
        // CREATE SELECT MOVIE TEXT
        JLabel selectMovieLabel = new JLabel("Title: " + currentMovie.getTitle()
                                                + "\nGenre: " + currentMovie.getGenre()
                                                + "\nYear: " + currentMovie.getYear()
                                                + "\nDirector: " + currentMovie.getDirector()
                                                + "\nMovie Length: " + currentMovie.getMovieLength()
                                                + "\nRating: " + currentMovie.getRating());
        selectMovieLabel.setHorizontalAlignment(SwingConstants.LEFT);
        selectMovieLabel.setForeground(Color.WHITE);
        selectMovieLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        selectMovieLabel.setBounds(100, 200, 254, 45);
        add(selectMovieLabel);
        */

        // CREATE MOVIE DETAILS
        currentMovie = backend.getDataController().findMovie(movie);
        JLabel movieDetailsLabel = new JLabel("Please Select Movie");
        movieDetailsLabel.setHorizontalAlignment(SwingConstants.LEFT);
        movieDetailsLabel.setForeground(Color.WHITE);
        movieDetailsLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        movieDetailsLabel.setBounds(100, 140, 254, 45);
        add(movieDetailsLabel);


        // CREATE MOVIE SELECTOR
        String[] movieList = new String[backend.getDataController().getMovieList().size()];
        for(int i = 0; i < backend.getDataController().getMovieList().size(); i++){
            movieList[i] = backend.getDataController().getMovieList().get(i).getTitle();
        }
        JComboBox movieSelectComboBox = new JComboBox(movieList);
        movieSelectComboBox.setToolTipText("Select Movie");
        movieSelectComboBox.setFont(new Font("Arial", Font.PLAIN, 15));
        movieSelectComboBox.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.LIGHT_GRAY));
        movieSelectComboBox.setForeground(Color.DARK_GRAY);
        movieSelectComboBox.setBackground(Color.WHITE);
        movieSelectComboBox.setBounds(100, 180, 254, 28);
        movieSelectComboBox.setOpaque(true);
        movieSelectComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent arg0) {
                System.out.println(movieSelectComboBox.getSelectedItem());
            }
        });
        movieSelectComboBox.getSelectedItem();
        add(movieSelectComboBox);

        // CREATE WELCOME TEXT LABEL
        JLabel welcomeLabel;
        if(backend.getCurrentUser() == null){
            welcomeLabel = new JLabel("Welcome Guest");
        }else {
            welcomeLabel = new JLabel("Welcome " + backend.getCurrentUser().getF_name() + " " + backend.getCurrentUser().getL_name());
        }
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        welcomeLabel.setBounds(20, 20, 500, 20);
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
