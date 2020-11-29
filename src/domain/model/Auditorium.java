package domain.model;

import domain.model.Theatre;

public class Auditorium {
    private int auditoriumID;
    private Theatre theatre;
    private int totalAvaliableSeats;
    private int num_of_rows;
    private int num_of_cols;

    private static int auditoriumCounter = 0;

    public Auditorium(Theatre t, int r, int c){
        auditoriumID = auditoriumCounter++;
        theatre = t;
        num_of_rows = r;
        num_of_cols = c;
        totalAvaliableSeats = r*c;
    }

    public int getAuditoriumID() {return this.auditoriumID;}

    public Theatre getTheatre() { return this.theatre; }
    public void setTheatre(Theatre theatre) {this.theatre = theatre;}

    public int getTotalAvaliableSeats() { return this.totalAvaliableSeats;}

    public int getNum_of_rows() {return this.num_of_rows;}

    public int getNum_of_cols() {return this.num_of_cols;}
    
}
