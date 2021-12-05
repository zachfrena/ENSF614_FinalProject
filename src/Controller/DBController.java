package Controller;

import Model.User;

import java.sql.*;
import java.util.ArrayList;

public class DBController implements DBLoginDetails {
    private Connection con;
    private ResultSet res;
    protected PreparedStatement theStatement;
    private ArrayList<User> existingUsers;

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
        loadExistingUsers(databaseController.readAllTables("USERS"));
        for (User theUser : existingUsers) {
            if(theUser.getUsername().contentEquals(username)) {
                loggedInUser= theUser;
                System.out.println(theUser.getUsername().toString());
                return;
            }
        }
        System.out.println("User does not exist.");
    }
        try {
            String query = "UPDATE USERS SET IsRegistered = false WHERE username = " + "'" + username +"'" + ";";
            Statement st = con.createStatement();
            st.execute(query);
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public void loadExistingUsers(ResultSet res) {
        try {
            while(res.next()) {
                existingUsers.add(new User (
                        res.getString("Username"),
                        res.getString("FName"),
                        res.getString("LName"),
                        res.getString("Email"),
                        res.getBoolean("IsRegistered"),
                        res.getInt("AccountBalance")));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    /*
           String username = theUser.getUsername();
        String query = "UPDATE USERS " +
                "SET AccountBalance = '" + amount + "' " +
                "WHERE Username = '" + username + "';";
     */


}
