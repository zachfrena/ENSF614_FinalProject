package Controller;

import Model.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpController{
	
//	SignUpView signUpView;
	private DBController databaseController;
	public SignUpController(DBController databaseController) {
		this.databaseController = databaseController;
	}
//	public SignUpController(SignUpView signUpView, DBController databaseController) {
//		this.signUpView = signUpView;
//		this.databaseController = databaseController;
//		this.signUpView.addActionListener(new SignUpListener());
//	}
	
	public void createUser() {
//		User user = new User(signUpView.fName.getText(), signUpView.lName.getText(), signUpView.email.getText(),
//				signUpView.registered.contains(null));
		User user = new User("z9","zach", "frena", "hello@gmail.com", false, 0);
		this.databaseController.saveToDB(user);
//		LoginController loginController = new LoginController();
//		loginController.loadExistingUsers();
	}
	
	public void payAnnualFee() {
		
	}

//	public SignUpView getSignUpView() {
//		return signUpView;
//	}
//
//	public void setSignUpView(SignUpView signUpView) {
//		this.signUpView = signUpView;
//	}


/*	public class SignUpListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

		}
	}

 */
}
