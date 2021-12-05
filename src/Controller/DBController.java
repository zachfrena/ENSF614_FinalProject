package Controller;

import Model.ExistingUsersList;
import Model.User;

import java.sql.*;
import java.util.ArrayList;

public class DBController implements DBLoginDetails {
    private Connection con;
    private ResultSet res;
    protected PreparedStatement theStatement;
    private ExistingUsersList existingUsersList;

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

    public ResultSet saveTicketToDB(Ticket ticket) {
        String ticketId = ticket.getTicketID();
        String fname = user.getFirstName();
        String lname = user.getlName();
        String theEmail = user.getEmail();
        boolean isRegistered = user.isRegistered();
        int accountBalance = user.getAccountBalance();

        try {

            //theStatement = con.prepareStatement(query);
            String query = "INSERT INTO TICKET VALUES (" + "'" +username + "'" + ", " + "'" + fname + "'" + ", " + "'" + lname + "'" + ", "
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
