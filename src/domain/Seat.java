package domain;

public class Seat {
	private int row;
	private int seatNum;
	private boolean seatTaken;

	public Seat() {
	}

	// This method shows the seat selection?
	public void showSeatSelection() {
		// To be implemented
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
}
