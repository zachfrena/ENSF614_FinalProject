package Model;

import Controller.DBController;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class Showing {

    private int showingID;
    private Date showingDate;
    private Time showingTime;
    private String theatre;
    private Movies movie;

    public Showing(int showingID, Movies movie, Date showingDate, Time showingTime, String theatre) {
        this.showingID = showingID;
        this.showingDate = showingDate;
        this.showingTime = showingTime;
        this.theatre = theatre;
        this.movie = movie;
    }

    public Movies getMovie() {
        return movie;
    }

    public Seat chooseSeat() {
        return null;
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
