package Controller;

import Model.*;

import java.sql.*;
import java.util.ArrayList;

public class DBController implements DBLoginDetails {
    private Connection con;
    private ResultSet res;
    protected PreparedStatement theStatement;
    private ExistingUsersList existingUsersList;
    private ArrayList<Movies> movies;
    private ArrayList<Showing> showings;



    public DBController() {
        establishConnection();
//
    }

    public void establishConnection() {
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            con = DriverManager.getConnection(theURL, theUserName, thePassword);
        } catch (SQLException e) {
            System.out.println("Error!");
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            con.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet readAllTables(String theTable) {
        try {
            String query = "SELECT * FROM " + theTable + ";";
            theStatement = con.prepareStatement(query);
            res = theStatement.executeQuery();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public ResultSet readMovies(int movieId) {
        try {
            String query = "SELECT * FROM MOVIE WHERE MovieID = " + movieId + ";";
            theStatement = con.prepareStatement(query);
            res = theStatement.executeQuery();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public ResultSet saveToDB(User user) {
        String username = user.getUsername();
        String fname = user.getFirstName();
        String lname = user.getlName();
        String theEmail = user.getEmail();
        boolean isRegistered = user.isRegistered();
        int accountBalance = user.getAccountBalance();

        try {

            //theStatement = con.prepareStatement(query);
            String query = "INSERT INTO USERS VALUES (" + "'" +username + "'" + ", " + "'" + fname + "'" + ", " + "'" + lname + "'" + ", "
                    + "'" + theEmail + "'" + ", " + isRegistered + ", " + accountBalance + ");";
            Statement st = con.createStatement();
            st.execute(query);
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

//    public ResultSet updateSeat(Ticket ticket) {
//        int ticketId = ticket.getTicketId();
//        int showingId = ticket.getTicketId();
//        int seat = ticket.getSeat();
//
//        try {
//            String query = "UPDATE TICKET SET Seat = " + seat + " WHERE TicketID = " + ticketId + ";";
//            theStatement = con.prepareStatement(query);
//            res = theStatement.executeQuery();
//        } catch(SQLException e) {
//            e.printStackTrace();
//        }
//        return res;
//    }

    public ResultSet setToNonRegistered(User user) {
        String username = user.getUsername();
        for (User theUser : existingUsersList.getExistingUsers()) {
            if(theUser.getUsername().contentEquals(username)) {
                try {
                    String query = "UPDATE USERS SET IsRegistered = false WHERE username = " + "'" + username +"'" + ";";
                    Statement st = con.createStatement();
                    st.execute(query);
                } catch(SQLException e) {
                    e.printStackTrace();
                }
                System.out.println(theUser.getUsername().toString() + "has been un-registered");
                return res;
            }
        }
        System.out.println("User was not found-- wasn't un-register");
        return res;
    }

    public ArrayList<Showing> readAllShowings() {
        ArrayList<Showing> showingList = new ArrayList<Showing>();
        ResultSet res = readAllTables("SHOWING");

        try {
            while(res.next()) {
                int showingId = res.getInt("ShowingID");
                int movieId  = res.getInt("MovieID");
                Date theDate = res.getDate("TheDate");
                Time showingTime = res.getTime("ShowingTime");
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
        ResultSet res = readAllTables("Movie");
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
       // System.out.println(movies);
        return movies;
    }

    public ArrayList<Movies> getMovies() {
        return movies;
    }

    public ArrayList<Showing> getShowings() {
        return showings;
    }
    //        try {
//            String query = "UPDATE USERS SET IsRegistered = false WHERE username = " + "'" + username +"'" + ";";
//            Statement st = con.createStatement();
//            st.execute(query);
//        } catch(SQLException e) {
//            e.printStackTrace();
//        }
//        return res;
//    }


    /*
           String username = theUser.getUsername();
        String query = "UPDATE USERS " +
                "SET AccountBalance = '" + amount + "' " +
                "WHERE Username = '" + username + "';";
     */

    public User searchUser(String username) {
        existingUsersList = new ExistingUsersList();
        for (User theUser : existingUsersList.getExistingUsers()) {
            if (theUser.getUsername().contentEquals(username)) {
                return theUser;
            }
        }
        return null;
    }


}
