package domain.model;

public class Seat {
	private boolean seatTaken;

	public Seat() {
		seatTaken = false;
	}

	// This method shows the seat selection?
	public void showSeatSelection() {
		// To be implemented
	}

	// Getters and Setters

	//Returns true if the seat was vacant, and was successfully able to book the seat
	//Returns false of the seat was already taken
	public void bookSeat(){
		seatTaken = true;
	}

	public void vacateSeat(){
		seatTaken = false;
	}

	public boolean isSeatTaken() {
		return seatTaken;
	}

	public void setSeatTaken(boolean seatTaken) {
		this.seatTaken = seatTaken;
	}
}
