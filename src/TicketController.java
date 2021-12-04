import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicketController {

    private TicketView ticketView;
    private User user;

    public TicketController(User u){
        this.user=u;
        this.ticketView.addActionListener(new TicketListener());
    }

    public Ticket selectTicket(){

    }

    public void getRefund(int ticketID){

    }

    public displayShowings(showingList s){

    }

    public void displayAccountBalance(){

    }

    public void addBalance(User u, int amount){

    }

    public void updateSeats(){

    }


    public class TicketListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

        }

    }

}
