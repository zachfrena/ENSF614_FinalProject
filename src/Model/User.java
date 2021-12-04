package Model;

public class User {
    private String username;
    private String fName;
    private String lName;
    private String email;
    private boolean isRegistered;
    private int accountBalance;

    public User(String username, String fName, String lName, String email, boolean isRegistered, int accountBalance) {
        this.username = username;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.isRegistered = isRegistered;
        this.accountBalance = accountBalance;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {return fName;}

    public String getlName() {
        return lName;
    }

    public String getEmail() {
        return email;
    }

    public boolean isRegistered() {
        return isRegistered;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void setRegistered(boolean registered) {
        isRegistered = registered;
    }
}
