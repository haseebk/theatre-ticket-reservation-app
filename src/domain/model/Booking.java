package domain.model;

public class Booking {
	/**
	 * The movie that's being booked
	 */
	private Movie bookedMovie;
	/**
	 * The show time that's being booked
	 */
	private Showtime bookedTime;
	/**
	 * The seat that's being booked
	 */
	private Seat bookedSeat;
	/**
	 * Booking ID
	 */
	private int bookingID;

	private static int bookingCounter = 0;

	// Constructors
	public Booking() {
		bookedMovie = null;
		bookedTime = null;
		bookedSeat = null;
		bookingID = -1;

	}

	public Booking(Movie m, Showtime t, Seat s) {
		bookedMovie = m;
		bookedTime = t;
		bookedSeat = s;
		bookingID = bookingCounter++;
	}

	// Getters and Setters
	public Seat getBookedSeat() {
		return bookedSeat;
	}

	public void setBookedSeat(Seat bookedSeat) {
		this.bookedSeat = bookedSeat;
	}

	public Showtime getBookedTime() {
		return bookedTime;
	}

	public void setBookedTime(Showtime bookedTime) {
		this.bookedTime = bookedTime;
	}

	public Movie getBookedMovie() {
		return bookedMovie;
	}

	public void setBookedMovie(Movie bookedMovie) {
		this.bookedMovie = bookedMovie;
	}

	public int getBookingID() {
		return bookingID;
	}

	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}

}
