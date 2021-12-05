package Model;

import java.util.ArrayList;

public class Ticket {

    private Showing showing; //pass integer (showingID) into DB
    private User user; //pass String (username) into DB
    //private Seat seat;
    private ArrayList<Seat> seats;
    private int ticketId;

    public Ticket(int ticketId, Showing showing, User user, ArrayList<Seat> seat){
        this.ticketId = ticketId;
        this.showing=showing;
        this.user=user;
        this.seats=seat;
    }

    public void emailTicket(){
        //email ticket here
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getTicketId() {
        return ticketId;
    }

    public ArrayList<Seat> getSeat() {
        return seats;
    }

    public void setSeat(ArrayList<Seat> seat) {
        this.seats = seat;
    }

    public Showing getShowing() {
        return showing;
    }

    public void setShowing(Showing showing) {
        this.showing = showing;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
       return "Ticket ID: " + ticketId + "\nMovie: " + showing.getMovie().getTitle() + "\nSeat: " + seats;
    }
}

