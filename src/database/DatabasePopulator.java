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
		
	}
	
	public void loadShowtimes() {
		
	}
	
	public void loadTheatres() {
		
	}
	
	public void loadTickets() {
		
	}
	
	public void loadUsers() {
		
	}
	
	public void loadAnnouncements() {
		
	}
}
