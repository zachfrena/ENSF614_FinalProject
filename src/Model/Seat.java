package Model;

public class Seat {

    private int seatNumber;
    private boolean isTaken = false;

    public Seat(int seatNumber) {
        setSeatNumber(seatNumber);
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken() {
        isTaken = true;
    }


    public void setSeatNotTaken() {
        isTaken = false;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Override
    public String toString() {
        return "Seat number: " + getSeatNumber();
    }
}
