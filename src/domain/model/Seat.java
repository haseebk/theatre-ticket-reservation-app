package domain.model;

public class Seat {
	private int row;
	private int seatNum;
	private boolean seatTaken;

	public Seat(int row, int seatNum) {
		this.row = row;
		this.seatNum = seatNum;
		seatTaken = false;
	}

	// This method shows the seat selection?
	public void showSeatSelection() {
		// To be implemented
	}

	public void bookSeat() {
		seatTaken = true;
	}

	public void vacateSeat() {
		seatTaken = false;
	}

	// Getters and Setters
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}

	public boolean isSeatTaken() {
		return seatTaken;
	}

	public void setSeatTaken(boolean seatTaken) {
		this.seatTaken = seatTaken;
	}

	@Override
	public String toString() {
<<<<<<< HEAD
		return String.format("Row: " + row + " Seat: " + seatNum);
=======
		return String.format("C" + seatNum + "R" + row);
>>>>>>> 1ea21d7878daeedbfd7d436f93d9e56a8138bceb
	}
}
