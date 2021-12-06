package Controller;

import Model.Showing;
import view.SeatView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SeatController{
	

	private SeatView seatView;
	private Showing showing;

//SeatController takes a showing, populates the GUI, takes user-input from GUI (selected seat), then updates the showing
	
	
	public SeatController() {
		this.seatView = seatView;
		this.seatView.addActionListener(new SeatListener());
	}

	public void populateGUI(Showing showing) {
		//populate the GUI
	}
	
	public void updateSeats(int seat){
		this.showing.updateSeats(seat);//create method in Showing class
	}


	public SeatView getSeatView() {
		return seatView;
	}

	public void setSeatView(SeatView seatView) {
		this.seatView = seatView;
	}


	public class SeatListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			//do something here
		}
		}

	}

