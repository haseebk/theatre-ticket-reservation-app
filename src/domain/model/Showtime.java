package domain.model;

import domain.model.Auditorium;
import domain.model.Date;
import domain.model.Movie;
import domain.model.Seat;

public class Showtime {
	private int showtimeID;
	private Date showDate;

	private int hour;
	private int minutes;
	private Auditorium auditorium;
	private int row;
	private int col;
	private Seat[][] seats;
	private int totalAvaliableSeats;
	private Movie movie;

	private static int showtimeCounter = 0;

	public Showtime(Date d, Auditorium a, Movie mov, int h, int m) {
		showtimeID = showtimeCounter++;
		showDate = d;
		auditorium = a;
		hour = h;
		minutes = m;
		movie = mov;
		row = a.getNum_of_rows();
		col = a.getNum_of_cols();
		seats = new Seat[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				seats[i][j] = new Seat(i, j);
			}
		}
		totalAvaliableSeats = row * col;
	}

	public Showtime(int day, int month, int year, Auditorium a, Movie mov, int h, int m) {
		showtimeID = showtimeCounter++;
		showDate = new Date(day, month, year);
		auditorium = a;
		movie = mov;
		hour = h;
		minutes = m;
		row = a.getNum_of_rows();
		col = a.getNum_of_cols();
		seats = new Seat[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				seats[i][j] = new Seat(i, j);
			}
		}
		totalAvaliableSeats = row * col;
	}

	// PROMISES: returns the seat avaliability, true if taken, false if empty
	// REQUIRES: the row and column of the seat
	public Boolean getSeatAvaliability(int r, int c) {
		if (r > row || c > col) {
			return false;
		}
		return seats[r][c].isSeatTaken();
	}

	// PROMISES: books the seat if it is vacant, returns true if successful.
	// returns false is unsuccessful since the seat was already taken
	// REQUIRES: the row and column of the seat
	public Boolean bookSeat(int r, int c) {
		if (seats[r][c].isSeatTaken() == false) {
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
		if (seats[r][c].isSeatTaken() == true)
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

	public int getHour() { return hour; }

	public void setHour(int hour) { this.hour = hour; }

	public int getMinutes() { return minutes; }

	public void setMinutes(int minutes) { this.minutes = minutes; }

	@Override
	public String toString() {
		return String.format(showDate.month + " " + showDate.day + ", " + showDate.year);
	}
}
