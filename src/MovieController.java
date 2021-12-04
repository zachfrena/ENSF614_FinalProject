import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MovieController {

    private ArrayList<Showing> movieList;
    private MovieView movieView;

    public MovieController(){
        movieList = new ArrayList<Showing>();
        movieView = new movieView();
        this.movieView.addActionListener(new MovieListener());
    }

    public void populateFromDB(){

    }




    public class MovieListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

        }

    }
}
