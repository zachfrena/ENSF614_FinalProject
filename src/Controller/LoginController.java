package Controller;

//import Model.ExistingUsersList;
import Model.ExistingUsersList;
import Model.User;
import view.LoginView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoginController {

    private User loggedInUser;
//    private DBController databaseController;
    private ExistingUsersList existingUsersList;
    private LoginView loginView;

//    public LoginController(DBController databaseController) {
//        this.databaseController = databaseController;
//        existingUsersList = new ExistingUsersList();
//    }
    public LoginController(){
        existingUsersList = new ExistingUsersList();
    }

    public void setLoginView(LoginView loginView) {
        this.loginView = loginView;
    }

    public void login(String username) {
        for (User theUser : existingUsersList.getExistingUsers()) { //loop through every existing user in DB
            if(theUser.getUsername().contentEquals(username)) {
                loggedInUser= theUser;
                loginView.setStatus(true);
                System.out.println(theUser.getUsername().toString());
                return;
            }
        }
        System.out.println("User does not exist.");
    }

//    public void loadExistingUsers(ResultSet res) {
//        try {
//            while(res.next()) {
//                existingUsersList.add(new User (
//                        res.getString("Username"),
//                        res.getString("FName"),
//                        res.getString("LName"),
//                        res.getString("Email"),
//                        res.getBoolean("IsRegistered"),
//                        res.getInt("AccountBalance")));
//            }
//        } catch(SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public void setActionListener() {
        loginView.addActionListener(new LoginListener());
    }
    public User getLoggedInUser() { return loggedInUser; }

//    private boolean isLoggedIn() {
//        return loggedInUser != null;
//    }

   class LoginListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == loginView.getLoginButton()){
                login(loginView.getUserName());
            }
        }
    }

}
