package Controller;

import Model.Ticket;
import Model.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketController {

//    private TicketView ticketView;
    private User user;
    private DBController databaseController;

    public TicketController(User u){ //constructor
        this.user=u;
       /* this.ticketView.addActionListener(new TicketListener());
        */
    }

//    public Ticket selectTicket(){
//        Ticket ticket = new Ticket(4, "kelten2", 4);
//        this.databaseController.saveTicketToDB(ticket);
//        int ticketID, Showing showing, User user, int seat
//    }




    public void getRefund(int ticketID){

    }


 /*   public void displayShowings(showingList s){

    }

  */

    public void displayAccountBalance(){

    }

    public void addBalance(User u, int amount){

    }

    public void updateSeats(){

    }


  /*  public class TicketListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

        }

    }
*/
}
