package database;

import java.util.ArrayList;

import domain.Announcement;
import domain.Auditorium;
import domain.Movie;
import domain.RegisteredUser;
import domain.Showtime;
import domain.Theatre;
import domain.Ticket;

public class DataController {
	private static DataController onlyInstance;

	/**
	 * Array lists of stored data
	 */
	private ArrayList<Movie> movieList;
	private ArrayList<Showtime> showtimeList;
	private ArrayList<Theatre> theatreList;
	private ArrayList<Ticket> ticketList;
	private ArrayList<RegisteredUser> userList;
	private ArrayList<Announcement> announcementList;
	private ArrayList<Auditorium> auditoriumList;

	/**
	 * Methods to create instances
	 */
	private DataController() {
		setMovieList(new ArrayList<Movie>());
		setShowtimeList(new ArrayList<Showtime>());
		setTheatreList(new ArrayList<Theatre>());
		setTicketList(new ArrayList<Ticket>());
		setUserList(new ArrayList<RegisteredUser>());
		setAnnouncementList(new ArrayList<Announcement>());
		setAuditoriumList(new ArrayList<Auditorium>());

	}

	public static DataController getOnlyInstance() {
		if (onlyInstance == null) {
			onlyInstance = new DataController();
		}
		return onlyInstance;
	}

	public static void setOnlyInstance(DataController onlyInstance) {
		DataController.onlyInstance = onlyInstance;
	}

	/**
	 * Getter for list of movies
	 * 
	 * @return arraylist of movies
	 */
	public ArrayList<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(ArrayList<Movie> movieList) {
		this.movieList = movieList;
	}

	public void addMovie(Movie movie) {
		movieList.add(movie);
	}

	public void removeMovie(Movie movie) {
		movieList.remove(movie);
	}

	public ArrayList<Showtime> getShowtimeList() {
		return showtimeList;
	}

	public void setShowtimeList(ArrayList<Showtime> showtimeList) {
		this.showtimeList = showtimeList;
	}

	public void addShowtime(Showtime showtime) {
		showtimeList.add(showtime);
	}

	public void removeShowtime(Showtime showtime) {
		showtimeList.remove(showtime);
	}

	public ArrayList<Theatre> getTheatreList() {
		return theatreList;
	}

	public void setTheatreList(ArrayList<Theatre> theatreList) {
		this.theatreList = theatreList;
	}

	public void addTheatre(Theatre theatre) {
		theatreList.add(theatre);
	}

	public void removeTheatre(Theatre theatre) {
		theatreList.remove(theatre);
	}

	public ArrayList<Ticket> getTicketList() {
		return ticketList;
	}

	public void setTicketList(ArrayList<Ticket> ticketList) {
		this.ticketList = ticketList;
	}

	public void addTicket(Ticket ticket) {
		ticketList.add(ticket);
	}

	public void removeTicket(Ticket ticket) {
		ticketList.remove(ticket);
	}

	public ArrayList<RegisteredUser> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<RegisteredUser> userList) {
		this.userList = userList;
	}

	public void addUser(RegisteredUser user) {
		userList.add(user);
	}

	public void removeUser(RegisteredUser user) {
		userList.remove(user);
	}

	public ArrayList<Announcement> getAnnouncementList() {
		return announcementList;
	}

	public void setAnnouncementList(ArrayList<Announcement> announcementList) {
		this.announcementList = announcementList;
	}

	public void addAnnouncement(Announcement announcement) {
		announcementList.add(announcement);
	}

	public void removeAnnouncement(Announcement announcement) {
		announcementList.remove(announcement);
	}
	
	private void setAuditoriumList(ArrayList<Auditorium> arrayList) {
		
	}
}
