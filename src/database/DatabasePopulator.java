package database;

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
		/**
		 * insert movie additions here
		 */
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
