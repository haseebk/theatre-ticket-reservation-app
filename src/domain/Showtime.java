package domain;

import domain.Date;
import domain.Auditorium;
import domain.Movie;
import domain.Seat;

public class Showtime {
	private int showtimeID;
	private Date showDate;
	private Auditorium auditorium;
	private int row;
	private int col;
	private Seat[][] seats;
	private int totalAvaliableSeats;
	private Movie movie;

	private static int showtimeCounter = 0;

	public Showtime(Date d, Auditorium a, Movie m) {
		showtimeID = showtimeCounter++;
		showDate = d;
		auditorium = a;
		movie = m;
		row = a.getNum_of_rows();
		col = a.getNum_of_cols();
		seats = Seat()[row][col];
		totalAvaliableSeats = row * col;
	}

	public Showtime(int day, String month, int year, Auditorium a, Movie m) {
		showtimeID = showtimeCounter++;
		showDate = new Date(day, month, year);
		auditorium = a;
		movie = m;
		row = a.getNum_of_rows();
		col = a.getNum_of_cols();
		seats = Seat()[row][col];
		totalAvaliableSeats = row * col;
	}

	// PROMISES: returns the seat avaliability
	// REQUIRES: the row and column of the seat
	public bool getSeatAvaliability(int r, int c) {
		return seats[r][c].getSeatTaken();
	}

	// PROMISES: books the seat if it is vacant, returns true if successful.
	// returns false is unsuccessful since the seat was already taken
	// REQUIRES: the row and column of the seat
	public bool bookSeat(int r, int c) {
		if (seats[r][c].getSeatTaken() == false) {
			seats[r][c].bookSeat();
			totalAvaliableSeats--;
			return true;
		} else {
			return false;
		}
	}

	// PROMISES: vacates the specific seat
	// REQUIRES: the row and column of the seat
	public void vacantSeat(int r, int c) {
		if (seats[r][c].getSeatTaken() == true)
			totalAvaliableSeats++;
		seats[r][c].vacateSeat();
	}

	public int getShowtimeID() {
		return showtimeID;
	}

	public Date getShowDate() {
		return showDate;
	}

	public void setShowDate(Date d) {
		showDate = d;
	}

	public Auditorium getAuditorium() {
		return auditorium;
	}

	public void setAuditorium(Auditorium a) {
		auditorium = a;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie m) {
		movie = m;
	}

	public int getRow() {
		return this.row;
	}

	public int getCol() {
		return this.col;
	}

	public Seat[][] getSeats() {
		return this.seats;
	}

	public int getTotalAvaliableSeats() {
		return this.totalAvaliableSeats;
	}
}
