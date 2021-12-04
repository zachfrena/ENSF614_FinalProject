package Model;

public class Ticket {

    private int ticketID;
    private Showing showing;
    private User user;

    public Ticket(int ticketID, Showing showing, User user){
        this.ticketID=ticketID;
        this.showing=showing;
        this.user=user;
    }

    public void emailTicket(){
        //email ticket here
    };

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
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
}

