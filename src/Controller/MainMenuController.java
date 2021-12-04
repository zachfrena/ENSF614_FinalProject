package Controller;

import Model.User;
import Controller.DBController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class MainMenuController {
    private User user;
    //private MainMenuView mainMenuView;

    public boolean checkBalance(User theUser) {
        int currentBalance = theUser.getAccountBalance();
        return currentBalance >= 20;
    }

    public void addBalance(User theUser, int amount) {
        //JOptionPane.showMessageDialog(null, "$" + amount + " has been  added to your balance.");
        theUser.setAccountBalance(amount);
    }

    public void displayAccountBalance() {
        /*JOptionPane.showMessageDialog(null, "$" +
                user.getAccountBalance());

         */
        System.out.println(user.getUsername() + " Account balance: " + user.getAccountBalance());
    }

    public void cancelRegistration(User user) {
        user.setRegistered(false);
        System.out.println("Registration cancelled:" + user.getUsername() + " " + user.isRegistered());
    }

}
