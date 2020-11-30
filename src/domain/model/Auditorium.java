package domain.model;

public class Auditorium {
    private int auditoriumID;
    private int totalAvaliableSeats;
    private int num_of_rows;
    private int num_of_cols;

    private Theatre theatre;

    private static int auditoriumCounter = 0;

    public Auditorium(int r, int c){
        auditoriumID = auditoriumCounter++;
        num_of_rows = r;
        num_of_cols = c;
        totalAvaliableSeats = r*c;
        theatre = null;
    }

    public int getAuditoriumID() {return this.auditoriumID;}

    public int getTotalAvaliableSeats() { return this.totalAvaliableSeats;}

    public int getNum_of_rows() {return this.num_of_rows;}

    public int getNum_of_cols() {return this.num_of_cols;}

    public Theatre getTheatre() { return theatre; }

    public void setTheatre(Theatre theatre) { this.theatre = theatre; }
    
}
