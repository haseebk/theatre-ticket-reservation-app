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

	/**
	 * Return only instance of data controller. if no instance exists, create one
	 * then return it
	 * 
	 * @return instance of data controller
	 */
	public static DataController getOnlyInstance() {
		if (onlyInstance == null) {
			onlyInstance = new DataController();
		}
		return onlyInstance;
	}

	/**
	 * Setter for only instance of data controller
	 * 
	 * @param onlyInstance
	 */
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

	/**
	 * Setter for list of movies
	 * 
	 * @param movieList arraylist of movies
	 */
	public void setMovieList(ArrayList<Movie> movieList) {
		this.movieList = movieList;
	}

	/**
	 * Add movie to list of movies
	 * 
	 * @param movie movie to be added
	 */
	public void addMovie(Movie movie) {
		movieList.add(movie);
	}

	/**
	 * Remove movie from list of movies
	 * 
	 * @param movie movie to be removed
	 */
	public void removeMovie(Movie movie) {
		movieList.remove(movie);
	}

	/**
	 * Getter for list of show times
	 * 
	 * @return arraylist of show times
	 */
	public ArrayList<Showtime> getShowtimeList() {
		return showtimeList;
	}

	/**
	 * Setter for list of show times
	 * 
	 * @param showtimeList arraylist of show times
	 */
	public void setShowtimeList(ArrayList<Showtime> showtimeList) {
		this.showtimeList = showtimeList;
	}

	/**
	 * Add show time to list of show times
	 * 
	 * @param showtime show time to be added
	 */
	public void addShowtime(Showtime showtime) {
		showtimeList.add(showtime);
	}

	/**
	 * Remove show time from list of show times
	 * 
	 * @param showtime show time to be removed
	 */
	public void removeShowtime(Showtime showtime) {
		showtimeList.remove(showtime);
	}

	/**
	 * Getter for list of theaters
	 * 
	 * @return arraylist of theaters
	 */
	public ArrayList<Theatre> getTheatreList() {
		return theatreList;
	}
	
	/**
	 * Setter for list of theatres
	 * @param theatreList arraylist of theatres
	 */
	public void setTheatreList(ArrayList<Theatre> theatreList) {
		this.theatreList = theatreList;
	}
	
	/**
	 * Add theatre to list of theatres
	 * @param theatre theatre to be added
	 */
	public void addTheatre(Theatre theatre) {
		theatreList.add(theatre);
	}
	
	/**
	 * Remove theatre from list of theatres
	 * @param theatre theatre to be removed
	 */
	public void removeTheatre(Theatre theatre) {
		theatreList.remove(theatre);
	}
	
	/**
	 * Getter for list of tickets
	 * @return arraylist of tickets
	 */
	public ArrayList<Ticket> getTicketList() {
		return ticketList;
	}
	
	/**
	 * Setter for list of tickets
	 * @param ticketList arraylist of tickets
	 */
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

	public ArrayList<Auditorium> getAuditoriumList() {
		return auditoriumList;
	}

	public void setAuditoriumList(ArrayList<Auditorium> auditoriumList) {
		this.auditoriumList = auditoriumList;
	}

	public void addAuditorium(Auditorium auditorium) {
		auditoriumList.add(auditorium);
	}

	public void removeAuditorium(Auditorium auditorium) {
		auditoriumList.remove(auditorium);
	}

}
