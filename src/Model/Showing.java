package Model;

import java.sql.Time;
import java.util.Date;

public class Showing {

    private int showingID;
    private int movieID;
    private Date showingDate;
    private Time showingTime;
    private String theatre;

    public Showing(int showingID, int movieID, Date showingDate, Time showingTime, String theatre) {
        this.showingID = showingID;
        this.movieID = movieID;
        this.showingDate = showingDate;
        this.showingTime = showingTime;
        this.theatre = theatre;
    }


    public void displaySeats(){

    }

    public void displayShowtime(){

    }
}
