package Controller;

import Model.Showing;
import Model.Ticket;
import Model.User;
import Controller.DBController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.*;
import java.util.Date;

public class MainMenuController {
    private User user;
    private Showing showing;
    private Ticket ticket;
//    private LoginController loginController;
    //private MainMenuView mainMenuView;

    public MainMenuController(User user){
     //   this.loginController = new LoginController();
        this.user = user;
    }

    public boolean checkBalance(User theUser) {
        int currentBalance = theUser.getAccountBalance();
        return currentBalance >= 20;
    }

    public void addBalance(User theUser, int amount) {
        //JOptionPane.showMessageDialog(null, "$" + amount + " has been  added to your balance.");
        System.out.println("test " + theUser);

        theUser.setAccountBalance(amount);
    }

    public void displayAccountBalance() {
        /*JOptionPane.showMessageDialog(null, "$" +
                user.getAccountBalance());

         */
        System.out.println(user.getUsername() + " Account balance: " + user.getAccountBalance());
    }

//    public void getUser(ResultSet res) {
//        try {
//            while(res.next()) {
//                setUser(new User(res.getString("Username"),
//                res.getString("FName"),
//                res.getString("LName"),
//                res.getString("Email"),
//                res.getBoolean("IsRegistered"),
//                res.getInt("AccountBalance")));
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void setUser(User user){
//        this.user = user;
//    }




    public void getTickets(ResultSet res){

    }

    public void getMovies(ResultSet res){

    }

    public void cancelRegistration(User user) {
        user.setRegistered(false);
        System.out.println("Registration cancelled:" + user.getUsername() + " " + user.isRegistered());
    }

}
