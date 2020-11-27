package domain;

public class Seat {

    private boolean seatTaken;

    public Seat(){
        seatTaken = false;
    }

    public boolean isSeatTaken(){return seatTaken;}
    public void bookSeat(){seatTaken = true;}
    public void vacateSeat(){seatTaken = false;}
}
