package database;

import domain.Movie;

public class DatabasePopulator {
	DataController dbController;
	
	private DatabasePopulator() {
		dbController = DataController.getOnlyInstance();
	}
	
	public void loadDatabase() {
		loadMovies();
		loadShowtimes();
		loadTheatres();
		loadTickets();
		loadUsers();
		loadAnnouncements();
	}
	
	public void loadMovies() {
		Movie spiderverse = new Movie("Spider-Man: Into the Spider-Verse","Action", 2018, "Peter Ramsey", 116, 8.4);
		Movie getout = new Movie("Get Out","Thriller", 2017, "Peter Ramsey", 104, 7.7);
		Movie hereditary = new Movie("Hereditary","Horror", 2018, "Ari Aster", 127, 7.3);
		Movie paddington = new Movie("Paddington 2","Adventure", 2017, "Paul King", 104, 7.8);

		dbController.addMovie(spiderverse);
		dbController.addMovie(getout);
		dbController.addMovie(hereditary);
		dbController.addMovie(paddington);
	}
	
	public void loadShowtimes() {
		/**
		 * insert showtime additions here
		 */
	}
	
	public void loadTheatres() {
		/**
		 * insert theatre additions here
		 */
	}
	
	public void loadTickets() {
		/**
		 * insert ticket additions here
		 */
	}
	
	public void loadUsers() {
		/**
		 * insert user additions here
		 */
	}
	
	public void loadAnnouncements() {
		
	}
}
