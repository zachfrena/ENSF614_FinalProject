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

    public Showing(int showingID, Movies movie, Date showingDate, LocalTime showingTime, String theatre) {
        this.showingID = showingID;
        this.showingDate = showingDate;
        this.showingTime = showingTime;
        this.theatre = theatre;
        this.movie = movie;
        allSeats = new ArrayList<Seat>();
        makeSeats();
    }

    public void makeSeats() {
        for(int i = 1; i < 20; i++) {
            allSeats.add(new Seat(i));
        }
    }

    public Movies getMovie() {
        return movie;
    }

    public void updateSeats(int seatNumber) { //takes in a seat number
        allSeats.get(seatNumber-1).setTaken(); //indexes at 0, and sets the seat in array to "isTaken = true"
}

    public int getShowingID() {
        return showingID;
    }

    public int getMovieId() {
        return movie.getMovieId();
    }

    @Override
    public String toString() {
        return "\nShowing: " + movie.getTitle() + "\nDate: " + showingDate + "\nTime: " + showingTime;
    }
}
