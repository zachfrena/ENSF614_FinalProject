package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProjectApp {
	MainFrame frame;
	
	public ProjectApp() {
		run();
	}
	
	
	public static void main(String[] args) {
		new ProjectApp();
	}
	
	public void run() {
		buildMainFrame();
	}
	
	private void buildMainFrame() {
		frame = new MainFrame();
		MenuListener mlistener = new MenuListener();
		frame.getLoginView().addMenuListener(mlistener);
		frame.getSignUpView().addMenuListener(mlistener);
		frame.getMainMenuView().addMenuListener(mlistener);
		frame.getTicketView().addMenuListener(mlistener);
		frame.getMovieView().addMenuListener(mlistener);
		frame.getSeatView().addMenuListener(mlistener);
	}
	
	class MenuListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == frame.getLoginView().getLoginButton()) {
				if (frame.getLoginView().getStatus()) {
					frame.setCard(1);
				} else {
					frame.getSignUpView().setUserName(frame.getLoginView().getUserName()); //FOR TESTING PURPOSES ONLY TODO
					frame.setCard(2);
				}
			} else if (e.getSource() == frame.getSignUpView().getConfirmButton()) {
				frame.setCard(1);
			} else if (e.getSource() == frame.getMainMenuView().getTicketButton()) {
				frame.setCard(3);
			} else if (e.getSource() == frame.getMainMenuView().getMovieButton()) {
				frame.setCard(4);
			} else if (e.getSource() == frame.getTicketView().getBackButton()) {
				frame.setCard(1);
			} else if (e.getSource() == frame.getMovieView().getBackButton()) {
				frame.setCard(1);
			} else if (e.getSource() == frame.getMovieView().getConfirmButton()) {
				frame.getSeatView().resetSeatSelection();
				frame.setCard(5);
			} else if (e.getSource() == frame.getSeatView().getCancelButton()) {
				frame.setCard(4); //Maybe go back to main menu instead? TODO
			} else if (e.getSource() == frame.getSeatView().getConfirmButton()) {
				frame.setCard(3);
			}
			
		}
		
	}

}
