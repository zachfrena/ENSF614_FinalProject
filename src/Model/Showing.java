package Model;

import Controller.DBController;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

public class Showing {

    private int showingID;
    private Date showingDate;
    private LocalTime showingTime;
    private String theatre;
    private Movies movie;
    private ArrayList<Seat> allSeats;
    private int registeredSeats;

    public Showing(int showingID, Movies movie, Date showingDate, LocalTime showingTime, String theatre) {
        this.showingID = showingID;
        this.showingDate = showingDate;
        this.showingTime = showingTime;
        this.theatre = theatre;
        this.movie = movie;
        allSeats = new ArrayList<Seat>();
        makeSeats();
        registeredSeats = 0;
    }

    public void makeSeats() {
        for(int i = 0; i < 20; i++) {
            allSeats.add(new Seat(i));
        }
    }

    public int getRegisteredSeats(){
        return registeredSeats;
    }

    public void incrementRegisteredSeats(){
        registeredSeats += 1;
    }
    
    public void decrementRegisteredSeats() {
    	registeredSeats -=1;
    }

    public Date getDate(){
        return showingDate;
    }

    public Movies getMovie() {
        return movie;
    }

    public void updateSeats(int seatNumber) { //takes in a seat number
        allSeats.get(seatNumber).setTaken(); //indexes at 0, and sets the seat in array to "isTaken = true"
    }

    public ArrayList<Seat> getAllSeats(){
        return allSeats;
    }

    public int getShowingID() {
        return showingID;
    }

    public int getMovieId() {
        return movie.getMovieId();
    }

    public LocalTime getTime() {
        return showingTime;
    }

    public String getTheatre(){
        return theatre;
    }

    @Override
    public String toString() {
        return "\nShowing: " + movie.getTitle() + "\nDate: " + showingDate + "\nTime: " + showingTime;
    }

}
