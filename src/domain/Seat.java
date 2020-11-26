package domain;

public class Seat {

    private bool seatTaken;

    public Seat(){
        seatTaken = false;
    }

    public bool getSeatTaken(){return seatTaken;}
    public void bookSeat(){seatTaken = true;}
    public void vacateSeat(){seatTaken = false;}
}
