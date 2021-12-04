import java.util.ArrayList;

public class User {
	
	String firstName, lastName, email;
	boolean isRegistered;
	ArrayList<Ticket> ticketList;
	int accountBalance;

	public User(String firstName, String lastName, String email, boolean isRegistered) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.isRegistered = isRegistered;
	}

	public User(String firstName, String lastName, String email, boolean isRegistered, ArrayList<Ticket> ticketList,
			int accountBalance) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.isRegistered = isRegistered;
		this.ticketList = ticketList;
		this.accountBalance = accountBalance;
	}



	public void setRegisteration(boolean status) {
		
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public boolean isRegistered() {
		return isRegistered;
	}



	public void setRegistered(boolean isRegistered) {
		this.isRegistered = isRegistered;
	}



	public ArrayList<Ticket> getTicketList() {
		return ticketList;
	}



	public void setTicketList(ArrayList<Ticket> ticketList) {
		this.ticketList = ticketList;
	}



	public int getAccountBalance() {
		return accountBalance;
	}



	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}

}
