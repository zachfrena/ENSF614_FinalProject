package Controller;

import Model.ExistingUsersList;
import Model.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {

   private User loggedInUser;

   private ExistingUsersList existingUsersList;

   //private LoginView loginView;

    public LoginController(User loggedInUser) {
        existingUsersList = new ExistingUsersList();
    }

    /*public LoginController(User loggedInUser) {
            this.loggedInUser = loggedInUser;
            //loginView = new LoginView();
        }

    */
    public void login(String username) {

        for (User theUser : existingUsersList.getExistingUsers()) {
            if(theUser.getUsername().contentEquals(username)) {
                loggedInUser = theUser;
                System.out.println(theUser.getUsername());
            }
            else {
                System.out.println("User does not exist.");
            }
        }
    }

    private boolean isLoggedIn() {
        return loggedInUser != null;
    }

    class LoginListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == loginView.getLoginButton() ||
            e.getSource() == loginView.getUserNameBox() {
                login(String username);
            }
        }

    }

}
