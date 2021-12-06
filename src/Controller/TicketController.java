package Controller;

import Model.Movies;
import Model.Showing;
import Model.Ticket;
import Model.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.time.LocalTime;

public class TicketController {

//    private TicketView ticketView;
    private User user;
    private DBController databaseController;
    private ArrayList<Movies> movies;
    private ArrayList<Showing> showings;
    private SeatController seatController;



    public TicketController(User u){ //constructor
        databaseController = new DBController();
        this.user=u;
       /* this.ticketView.addActionListener(new TicketListener());
        */
    }
    public void selectTicket(){ //we need to pass parameters in here from GUI
        Ticket exampleTicket = new Ticket(4, new Showing(5,new Movies(1,"indiana jones"),Calendar.getInstance().getTime(), LocalTime.now(),"theatre1"),user, 4); //hard-coded ticket purchase
        this.databaseController.saveTicketToDB(exampleTicket);

//        int ticketID, Showing showing, User user, int seat;

        //need to email user the ticket

    }

    public ArrayList<Showing> readAllShowings() {
        ArrayList<Showing> showingList = new ArrayList<Showing>();
        ResultSet res = databaseController.readAllTables("SHOWING");

        try {
            while(res.next()) {
                int showingId = res.getInt("ShowingID");
                int movieId  = res.getInt("MovieID");
                Date theDate = res.getDate("TheDate");
                res.getTime("");
                LocalTime showingTime = convertLocalTime(res.getTime("ShowingTime"));
                String theatreName = res.getString("Theatre");
                movies = readAllMovies();
                Movies theMovie = movies.get(movieId - 1);
                Showing theShowing = new Showing(showingId, theMovie, theDate, showingTime, theatreName);
                showingList.add(theShowing);
            }
        } catch (SQLException e) {
                e.printStackTrace();
        }
            // System.out.println(showingList);
        return showingList;
}

    public ArrayList<Movies> readAllMovies() {
        ResultSet res = databaseController.readAllTables("Movie");
        movies = new ArrayList<Movies>();

        try {
            while(res.next()) {
                int movieId = res.getInt("MovieID");
                String title = res.getString("Title");

                Movies theMovie = new Movies(movieId, title);
                movies.add(theMovie);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movies;
    }

    public ArrayList<Movies> getMovies() {
        return movies;
    }

    public ArrayList<Showing> getShowings() {
        return showings;
    }

    public LocalTime convertLocalTime(Time time) {
        if(time != null) {
            return time.toLocalTime();
        }
        return null;
    }

    public void getRefund(int ticketID){

    }


 /*   public void displayShowings(showingList s){

    }

  */

    public void displayAccountBalance(){

    }

    public void addBalance(User u, int amount){

    }

  /*  public class TicketListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

        }

    }
*/
}
