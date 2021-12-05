package view;

public class Seat {
	private int seatNum;
	private boolean isTaken;
	
	public Seat(int num) {
		seatNum = num;
		isTaken = false;
	}
	
	public boolean isTaken() {
		return isTaken;
	}
	
	public int getSeatNumber() {
		return seatNum;
	}
	
	public void reserve() {
		isTaken = true;
	}
}
