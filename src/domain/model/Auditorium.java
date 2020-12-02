package domain.model;

public class Auditorium {
	private int auditoriumID;
	private int totalAvaliableSeats;
	private int num_of_rows;
	private int num_of_cols;

	private Theatre theatre;

	private static int auditoriumCounter = 3000;

	public Auditorium(int aID, int r, int c, Theatre theatre) {
		auditoriumID = aID;
		if(aID > auditoriumCounter){
			auditoriumCounter = aID+1;
		}else {
			auditoriumCounter++;
		}
		num_of_rows = r;
		num_of_cols = c;
		totalAvaliableSeats = r * c;
		this.theatre = theatre;
		auditoriumCounter++;
	}

	public Auditorium(int r, int c, Theatre theatre) {
		auditoriumID = auditoriumCounter++;
		num_of_rows = r;
		num_of_cols = c;
		totalAvaliableSeats = r * c;
		this.theatre = theatre;
	}

	public int getAuditoriumID() {
		return this.auditoriumID;
	}

	public int getTotalAvaliableSeats() {
		return this.totalAvaliableSeats;
	}

	public int getNum_of_rows() {
		return this.num_of_rows;
	}

	public int getNum_of_cols() {
		return this.num_of_cols;
	}

	public Theatre getTheatre() {
		return theatre;
	}

	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}

}
