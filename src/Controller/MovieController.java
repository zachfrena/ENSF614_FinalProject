package Controller;

import Model.Showing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MovieController {

    private ArrayList<Showing> movieList;
    //    private MovieView movieView;
    private Showing showing;

    public MovieController() {
        movieList = new ArrayList<Showing>();
//        movieView = new MovieView();
//        this.movieView.addActionListener(new MovieListener());
    }

//    public void getShowings(ResultSet res) {
//        try {
//            while (res.next()) {
//                populateMovies(new Showing(res.getInt("ShowingID"),
//                        res.getInt("MovieID"),
//                        res.getDate("TheDate"),
//                        res.getTime("ShowingTime"),
//                        res.getString("Theatre")));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public void populateMovies(Showing showing) {
            movieList.add(showing);
    }

  /*  public class MovieListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

        }

    }

   */
}
