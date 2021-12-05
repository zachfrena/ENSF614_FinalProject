package Model;

import Controller.DBController;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class Showing {

    private int showingID;
    private int movieID;
    private String movieName;
    private Date showingDate;
    private Time showingTime;
    private String theatre;
    private ArrayList<Seat> seats;

    public Showing(int showingID, int movieID, Date showingDate, Time showingTime, String theatre, ArrayList<Seat> seats) {
        this.showingID = showingID;
        this.movieID = movieID;
        this.showingDate = showingDate;
        this.showingTime = showingTime;
        this.theatre = theatre;
        this.seats = seats;
    }

    public String getMovieName(int movieID) {
        return movieName;
       // DBController db = new DBController();
        //return db.readMovies(movieID);
    }


    public void displaySeats(){

    }

    public void displayShowtime(){

    }

    public void setSeat(ArrayList<Seat> seat) {
        this.seats = seat;
    }
}
