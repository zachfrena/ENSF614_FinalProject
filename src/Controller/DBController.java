package Controller;

import Model.User;

import java.sql.*;

public class DBController implements DBLoginDetails {
    private Connection con;
    private ResultSet res;
    protected PreparedStatement theStatement;

    public DBController() {
        establishConnection();
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

    public ResultSet saveToDB(User user) {
        String username = user.getUsername();
        String fname = user.getFirstName();
        String lname = user.getlName();
        String email = user.getEmail();
        boolean isRegistered = user.isRegistered();
        int accountBalance = user.getAccountBalance();

        try {
            String query = "INSERT INTO USERS VALUES (" + username + ", " + fname + ", " + lname + ", "
            + email + ", " + isRegistered + ", " + accountBalance + ");";
            theStatement = con.prepareStatement(query);
            res = theStatement.executeQuery();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public ResultSet updateSeat(Ticket ticket) {
        int ticketId = ticket.getTicketId();
        int showingId = ticket.getTicketId();
        int seat = ticket.getSeat();

        try {
            String query = "UPDATE TICKET SET Seat = " + seat + " WHERE TicketID = " + ticketId + ";";
            theStatement = con.prepareStatement(query);
            res = theStatement.executeQuery();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public ResultSet setToNonRegistered(User user) {
        String username = user.getUsername();
        try {
            String query = "UPDATE USERS SET IsRegistered = 1 WHERE username = " + username + ";";
            theStatement = con.prepareStatement(query);
            res = theStatement.executeQuery();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    /*
           String username = theUser.getUsername();
        String query = "UPDATE USERS " +
                "SET AccountBalance = '" + amount + "' " +
                "WHERE Username = '" + username + "';";
     */


}
