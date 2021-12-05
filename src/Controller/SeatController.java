package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SeatController{
	
	private ArrayList<String> availableSeats;
	/*private SeatView seatView;

	 */
	
	
	public SeatController(ArrayList<String> availableSeats) {
		this.availableSeats = availableSeats;
		/* this.seatView = seatView;
		this.seatView.addActionListener(new SeatListener());

	 */
	}

	public void chooseSeat() {
		
	}
	
	private void checkOut() {
		
	}

	public ArrayList<String> getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(ArrayList<String> availableSeats) {
		this.availableSeats = availableSeats;
	}

/*	public SeatView getSeatView() {
		return seatView;
	}

	public void setSeatView(SeatView seatView) {
		this.seatView = seatView;
	}


 */

/*	public class SeatListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			chooseSeat();
		}
*/
	}

