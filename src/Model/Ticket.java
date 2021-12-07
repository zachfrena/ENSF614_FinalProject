package Model;

import java.util.ArrayList;

public class Ticket {

    private Showing showing; //pass integer (showingID) into DB
    private User user; //pass String (username) into DB
    private int seatNumber;
    private int ticketId;

    public Ticket(int ticketId, Showing showing, User user, int seat){
        this.ticketId = ticketId;
        this.showing=showing;
        this.user=user;
        this.seatNumber = seat;
    }

    public void emailTicket(){
        //email ticket here
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getTicketId() { return ticketId; }

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

    public int getSeatNumber() {
        return seatNumber;
    }

    @Override
    public String toString() {
       return "Ticket ID: " + ticketId + "\nMovie: " + showing.getMovie().getTitle() + "\nSeat: " + seatNumber;
    }
}
