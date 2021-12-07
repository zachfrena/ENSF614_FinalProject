package Controller;

import Model.*;

import java.sql.*;
import java.util.ArrayList;

public class DBController implements DBLoginDetails {
    private Connection con;
    private ResultSet res;
    protected PreparedStatement theStatement;
    private ExistingUsersList existingUsersList;


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

    public ResultSet readAllTickets(){
        try {
            String query = "SELECT ShowingID, Username, Seat FROM TICKET";
            Statement stmt = con.createStatement();
            res = stmt.executeQuery(query);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return res;
    }

    public ResultSet readTickets(User user) {
        String username = user.getUsername();
        try {
            String query = "SELECT * FROM TICKET WHERE Username = ?";
            PreparedStatement pStat = con.prepareStatement(query);
            pStat.setString(1, username);
            res = pStat.executeQuery();

        } catch(SQLException e) {
            e.printStackTrace();
        }
        return res;

    }

    public ResultSet saveUserToDB(User user) {
        String username = user.getUsername();
        String fname = user.getFirstName();
        String lname = user.getlName();
        String theEmail = user.getEmail();
        String theCreditCard = user.getCreditNum();
        boolean isRegistered = user.isRegistered();
        int accountBalance = user.getAccountBalance();

        try {

            String query = "INSERT INTO USERS (Username, FName, LName, Email, IsRegistered, CcNum, AccountBalance) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement pStat = con.prepareStatement(query);
            pStat.setString(1, username);
            pStat.setString(2, fname);
            pStat.setString(3, lname);
            pStat.setString(4, theEmail);
            pStat.setBoolean(5, isRegistered);
            pStat.setString(6, theCreditCard);
            pStat.setInt(7, accountBalance);
            int rowCount = pStat.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public void saveTicketToDB(Ticket ticket) {
        int showingId = ticket.getShowing().getShowingID();
        String username = ticket.getUser().getUsername();
        int seatNumber = ticket.getSeatNumber();

        try {
            String query = "INSERT INTO TICKET (ShowingID, Username, Seat) VALUES (?,?,?)";
            PreparedStatement pStat = con.prepareStatement(query);
            pStat.setInt(1, showingId);
            pStat.setString(2, username);
            pStat.setInt(3, seatNumber);
            pStat.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }

    }

    public void refundTicket(Ticket ticket){
        int showingId = ticket.getShowing().getShowingID();
        int seatNumber = ticket.getSeatNumber();

        try{
            String query = "DELETE FROM TICKET WHERE ShowingID = ? AND Seat = ?";
            PreparedStatement pStat = con.prepareStatement(query);
            pStat.setInt(1, showingId);
            pStat.setInt(2, seatNumber);
            pStat.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void setToNonRegistered(User user) {
        try {
            String query = "UPDATE USERS SET IsRegistered=False WHERE Username = ?" ;
            PreparedStatement pStat = con.prepareStatement(query);
            pStat.setString(1,user.getUsername());
            pStat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void updateDataBaseBalance(User user) {
        int accountBalance = user.getAccountBalance();
        try {
            String query = "UPDATE USERS SET AccountBalance=? WHERE Username = ?" ;
            PreparedStatement pStat = con.prepareStatement(query);
            pStat.setInt(1, accountBalance);
            pStat.setString(2,user.getUsername());
            pStat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
