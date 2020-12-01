package domain.model;

public class Ticket {
	private int ticketID;
	private Payment payment;
	private Movie the_movie;
	private Showtime showtime;
	private Seat seat;
	
	private static int ticketCounter = 0;

	public Ticket(Payment p, Movie m, Showtime s, Seat s1) {
		ticketID = ticketCounter++;
		payment = p;
		the_movie = m;
		showtime = s;
		seat = s1;
	}

	// This method sends the voucher code to the
	// email id in the argument
	public void emailTicket(String email) {
		// Needs to be implemented still
	}

	// Getters and Setters
	public int getTicketID() {
		return ticketID;
	}

	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Movie getThe_movie() {
		return the_movie;
	}

	public void setThe_movie(Movie the_movie) {
		this.the_movie = the_movie;
	}

	public Showtime getShowtime() {
		return showtime;
	}

	public void setShowtime(Showtime showtime) {
		this.showtime = showtime;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

}
