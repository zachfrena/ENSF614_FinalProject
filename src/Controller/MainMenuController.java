package Controller;

import Model.Showing;
import Model.Ticket;
import Model.User;
import view.MainMenuView;
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
    private MainMenuView mainMenuView;



    public void setActionListener(){
        mainMenuView.addActionListener(new MainMenuListener());
    }

    public void setMainMenuView(MainMenuView mainMenuView) {
        this.mainMenuView = mainMenuView;
    }

    public void setIsRegistered(boolean isRegistered){
        mainMenuView.setIsRegistered(isRegistered);
    }

    public void setUser(User user){
        this.user = user;
        mainMenuView.setUser(user);
    }

    public void setGreeting(){
        mainMenuView.setGreeting();
    }

    public boolean checkBalance() {
        int currentBalance = user.getAccountBalance();
        return (currentBalance >= 20);
    }

    public void addBalance(int amount) {
        user.updateAccountBalance(amount);
        displayAccountBalance();
    }

    public void displayAccountBalance(){
        mainMenuView.setBalance(user.getAccountBalance());
    }


    public void cancelRegistration() {
        user.setRegistered(false);
        mainMenuView.setIsRegistered(user.isRegistered());
        System.out.println("Registration cancelled:" + user.getUsername() + " " + user.isRegistered());
    }

    class MainMenuListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == mainMenuView.getAddButton()){
                addBalance(mainMenuView.getAmount());
            } else if (e.getSource() == mainMenuView.getUnregisterButton()){
                cancelRegistration();
            }
        }
    }

}
