package database;

import java.util.ArrayList;
import java.util.Vector;

import domain.model.*;

public class DataController {
	private static DataController onlyInstance;

	/**
	 * Array lists of stored data
	 */
	private ArrayList<Movie> movieList;
	private ArrayList<Showtime> showtimeList;
	private ArrayList<Theatre> theatreList;
	private ArrayList<BankingInfo> bankList;
	private ArrayList<Ticket> ticketList;
	private ArrayList<RegisteredUser> userList;
	private ArrayList<Announcement> announcementList;
	private ArrayList<Auditorium> auditoriumList;
	private ArrayList<Voucher> voucherList;
	private ArrayList<Payment> paymentList;
	private ArrayList<Receipt> receiptList;
	private FinancialInstitution inst;

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
		setVoucherList(new ArrayList<Voucher>());
		setBankList(new ArrayList<BankingInfo>());
		setPaymentList(new ArrayList<Payment>());
		setReceiptList(new ArrayList<Receipt>());
		inst = new FinancialInstitution("");
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
	 * Finds the movie with the desired title
	 * 
	 * @param title Title of desired movie
	 * @return Returns the movie if found, null if not found
	 */
	public Movie findMovie(String title) {
		if (title == null) {
			return null;
		}
		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i).getTitle().compareTo(title) == 0) {
				return movieList.get(i);
			}
		}
		return null;
	}

	/**
	 * Finds the theatre with the desired name
	 * 
	 * @param name Name of desired theatre
	 * @return Returns the theatre if found, null if not found
	 */
	public Theatre findTheatre(String name) {
		if (name == null) {
			return null;
		}
		for (int i = 0; i < theatreList.size(); i++) {
			if (theatreList.get(i).getT_name().compareTo(name) == 0) {
				return theatreList.get(i);
			}
		}
		return null;
	}

	/**
	 * Finds the all showtimes with playing the movies and the specific theatre
	 * 
	 * @param searchMovie   desired movie
	 * @param searchTheatre desired theatre
	 * @return List of all showtimes playing the movie at the theatre
	 */
	public ArrayList<Showtime> findAllShowtime(Movie searchMovie, Theatre searchTheatre) {
		if (searchTheatre == null || searchMovie == null) {
			return null;
		}
		ArrayList<Showtime> tempShowtime = new ArrayList<>();
		for (int i = 0; i < showtimeList.size(); i++) {
			if (showtimeList.get(i).getMovie() == searchMovie
					&& showtimeList.get(i).getAuditorium().getTheatre() == searchTheatre) {
				tempShowtime.add(showtimeList.get(i));
			}
		}
		return tempShowtime;
	}

	/**
	 * Finds the specific with playing the movies and the specific theatre on the
	 * specific date
	 * 
	 * @param searchMovie   desired movie
	 * @param searchTheatre desired theatre
	 * @param date          desired date
	 * @return List of all showtimes playing the movie at the theatre
	 */
	public Showtime findShowtime(Movie searchMovie, Theatre searchTheatre, Date date) {
		if (searchTheatre == null || searchMovie == null) {
			return null;
		}
		ArrayList<Showtime> tempShowtime = new ArrayList<>();
		for (int i = 0; i < showtimeList.size(); i++) {
			if (showtimeList.get(i).getMovie() == searchMovie
					&& showtimeList.get(i).getAuditorium().getTheatre() == searchTheatre
					&& showtimeList.get(i).getShowDate().toString().compareTo(date.toString()) == 0) {
				return showtimeList.get(i);
			}
		}
		return null;
	}

	/**
	 * Finds the theatres are currently playing this movie
	 * 
	 * @param searchMovie movie we are searching which theatres are currently
	 *                    playing
	 * @return all the theatres playing the movie
	 */
	public ArrayList<Theatre> findTheatresPlayingMovie(Movie searchMovie) {
		if (searchMovie == null) {
			return null;
		}
		ArrayList<Theatre> searchList = new ArrayList<Theatre>();
		for (int i = 0; i < showtimeList.size(); i++) {
			if (showtimeList.get(i).getMovie() == searchMovie) {
				if (!searchList.contains(showtimeList.get(i).getAuditorium().getTheatre())) {
					searchList.add(showtimeList.get(i).getAuditorium().getTheatre());
				}
			}
		}
		return searchList;
	}

	/**
	 * Search movie based on ID
	 * @param id search ID
	 * @return returns the movie if found, null if not
	 */
	public Movie searchMovie(int id){
		for(int i = 0; i < getMovieList().size(); i++){
			if(id == getMovieList().get(i).getMovieID()){
				return getMovieList().get(i);
			}
		}
		return null;
	}

	/**
	 * Search theatre based on ID
	 * @param id search ID
	 * @return returns the theatre if found, null if not
	 */
	public Theatre searchTheatre(int id){
		for(int i = 0; i < getTheatreList().size(); i++){
			if(id == getTheatreList().get(i).getTheatreID()){
				return getTheatreList().get(i);
			}
		}
		return null;
	}

	/**
	 * Search auditorium based on ID
	 * @param id search ID
	 * @return returns the auditorium if found, null if not
	 */
	public Auditorium searchAuditorium(int id){
		for(int i = 0; i < getAuditoriumList().size(); i++){
			if(id == getAuditoriumList().get(i).getAuditoriumID()){
				return getAuditoriumList().get(i);
			}
		}
		return null;
	}

	/**
	 * Search bankingInfo based on ID
	 * @param id search ID
	 * @return returns the bankingInfo if found, null if not
	 */
	public BankingInfo searchBankingInfo(int id){
		for(int i = 0; i < getBankList().size(); i++){
			if(id == getBankList().get(i).getBankID()){
				return getBankList().get(i);
			}
		}
		return null;
	}

	/**
	 * Search payment based on ID
	 * @param id search ID
	 * @return returns the payment if found, null if not
	 */
	public Payment searchPaymentInfo(int id){
		for(int i = 0; i < getPaymentList().size(); i++){
			if(id == getPaymentList().get(i).getPaymentID()){
				return getPaymentList().get(i);
			}
		}
		return null;
	}

	/**
	 * Search Showtime based on ID
	 * @param id search ID
	 * @return returns the Showtime if found, null if not
	 */
	public Showtime searchShowtimeInfo(int id){
		for(int i = 0; i < getShowtimeList().size(); i++){
			if(id == getShowtimeList().get(i).getShowtimeID()){
				return getShowtimeList().get(i);
			}
		}
		return null;
	}

	/**
	 * Search Showtime based on ID
	 * @param id search ID
	 * @return returns the Showtime if found, null if not
	 */
	public Receipt searchReceipt(int id){
		for(int i = 0; i < getReceiptList().size(); i++){
			if(id == getReceiptList().get(i).getReceiptID()){
				return getReceiptList().get(i);
			}
		}
		return null;
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
	 * 
	 * @param theatreList arraylist of theatres
	 */
	public void setTheatreList(ArrayList<Theatre> theatreList) {
		this.theatreList = theatreList;
	}

	/**
	 * Add theatre to list of theatres
	 * 
	 * @param theatre theatre to be added
	 */
	public void addTheatre(Theatre theatre) {
		theatreList.add(theatre);
	}

	/**
	 * Remove theatre from list of theatres
	 * 
	 * @param theatre theatre to be removed
	 */
	public void removeTheatre(Theatre theatre) {
		theatreList.remove(theatre);
	}

	/**
	 * Getter for list of tickets
	 * 
	 * @return arraylist of tickets
	 */
	public ArrayList<Ticket> getTicketList() {
		return ticketList;
	}

	/**
	 * Setter for list of tickets
	 * 
	 * @param ticketList arraylist of tickets
	 */
	public void setTicketList(ArrayList<Ticket> ticketList) {
		this.ticketList = ticketList;
	}

	/**
	 * Add ticket to list of tickets
	 * 
	 * @param ticket ticket to be added
	 */
	public void addTicket(Ticket ticket) {
		ticketList.add(ticket);
	}

	/**
	 * Remove ticket from list of tickets
	 * 
	 * @param ticket ticket to be removed
	 */
	public void removeTicket(Ticket ticket) {
		ticketList.remove(ticket);
	}

	/**
	 * Getter for list of users
	 * 
	 * @return arraylist of users
	 */
	public ArrayList<RegisteredUser> getUserList() {
		return userList;
	}

	/**
	 * Setter for list of users
	 * 
	 * @param userList arraylist of users
	 */
	public void setUserList(ArrayList<RegisteredUser> userList) {
		this.userList = userList;
	}

	/**
	 * Add user to list of users
	 * 
	 * @param user user to be added
	 */
	public void addUser(RegisteredUser user) {
		userList.add(user);
	}

	/**
	 * Remove user from list of users
	 * 
	 * @param user user to be removed
	 */
	public void removeUser(RegisteredUser user) {
		userList.remove(user);
	}

	/**
	 * Getter for list of announcements
	 * 
	 * @return list of announcements
	 */
	public ArrayList<Announcement> getAnnouncementList() {
		return announcementList;
	}

	/**
	 * 
	 * @param announcementList
	 */
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
	
	public void addVoucher(Voucher voucher) {
		voucherList.add(voucher);
	}
	
	public ArrayList<Voucher> getVoucherList() {
		return voucherList;
	}
	
	public void setVoucherList(ArrayList<Voucher> voucherList) {
		this.voucherList = voucherList;
	}
	
	public void removeVoucher(Voucher voucher) {
		voucherList.remove(voucher);
	}

	public ArrayList<BankingInfo> getBankList() { return bankList; }

	public void setBankList(ArrayList<BankingInfo> bankList) { this.bankList = bankList; }

	public void addBankingInfo(BankingInfo b) { this.bankList.add(b); }

	public void setPaymentList(ArrayList<Payment> paymentList) { this.paymentList = paymentList; }

	public ArrayList<Payment> getPaymentList() { return paymentList; }

	public void addPayment(Payment p) { this.paymentList.add(p); }

	public ArrayList<Receipt> getReceiptList() { return receiptList; }

	public void setReceiptList(ArrayList<Receipt> receiptList) { this.receiptList = receiptList; }

	public void addReceipt(Receipt receiptList) { this.receiptList.add(receiptList); }

	public void removeReceipt(Receipt receiptList) { this.receiptList.remove(receiptList); }


	public int checkTicket(int id) {

		for(int i = 0; i < ticketList.size(); i++) {
			if(ticketList.get(i).getTicketID() == id) {
				if(ticketList.get(i).getShowtime().getShowDate().beforeCurrentDate() && !ticketList.get(i).getShowtime().is72HoursBefore()){
					return -2;
				}else if(ticketList.get(i).getShowtime().getShowDate().beforeCurrentDate()){
					return i;
				}else{
					return -3;
				}
			}
		}

		return -1;
	}

	public Voucher redeemVoucher(String voucherCode){
		for (int i = 0; i < getVoucherList().size(); i++) {
			if (voucherCode.compareTo(getVoucherList().get(i).getVoucherCode()) == 0) {
				if (!getVoucherList().get(i).isUsed()) {
					getVoucherList().get(i).setUsed(true);
					return getVoucherList().get(i);
				} else {
					return null;
				}
			}
		}
		return null;
	}

	public FinancialInstitution getInst() {
		return inst;
	}

	public void setInst(FinancialInstitution inst) {
		this.inst = inst;
	}

}
