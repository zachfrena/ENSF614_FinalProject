package Controller;

//import Model.ExistingUsersList;
import Model.ExistingUsersList;
import Model.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoginController {

    private User loggedInUser;
    private DBController databaseController;
    private ExistingUsersList existingUsersList;

//   private ExistingUsersList existingUsersList;

   //private LoginView loginView;

    public LoginController(DBController databaseController) {
        this.databaseController = databaseController;
        existingUsersList = new ExistingUsersList();
    }

    /*public LoginController(User loggedInUser) {
            this.loggedInUser = loggedInUser;
            //loginView = new LoginView();
        }

    */
    public void login(String username) { //called in view-- pass in user-entered data in textfield
//        loadExistingUsers(databaseController.readAllTables("USERS"));
        for (User theUser : existingUsersList.getExistingUsers()) { //loop through every existing user in DB
            if(theUser.getUsername().contentEquals(username)) {
                loggedInUser= theUser;
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

    public User getLoggedInUser() {
        return loggedInUser;
    }

    private boolean isLoggedIn() {
        return loggedInUser != null;
    }

   /* class LoginListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == loginView.getLoginButton() ||
            e.getSource() == loginView.getUserNameBox() {
                login(String username);
            }
        }

    }
*/
}
