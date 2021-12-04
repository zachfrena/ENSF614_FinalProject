import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpController{
	
	SignUpView signUpView;
	DatabaseController databaseController;

	public SignUpController(SignUpView signUpView, DatabaseController databaseController) {
		this.signUpView = signUpView;
		this.databaseController = databaseController;
		this.signUpView.addActionListener(new SignUpListener());
	}
	
	public void createUser() {
		User user = new User(signUpView.fName.getText(), signUpView.lName.getText(), signUpView.email.getText(),
				signUpView.registered.contains(null));
		
//		databaseController.saveToDB(user);
	}
	
	public void payAnnualFee() {
		
	}

	public SignUpView getSignUpView() {
		return signUpView;
	}

	public void setSignUpView(SignUpView signUpView) {
		this.signUpView = signUpView;
	}


	public class SignUpListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

		}
	}
}
