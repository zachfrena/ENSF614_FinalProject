package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainApp {
    MainFrame frame;
    TicketController ticketController;
    DBController databaseController;
    SignUpController signUpController;
    MainMenuController mainMenuController;
    MovieController movieController;

    public MainApp(MainFrame frame, TicketController ticketController, DBController databaseController,
                   SignUpController signUpController, MainMenuController mainMenuController, MovieController movieController) {
        this.frame = frame;
        this.ticketController = ticketController;
        this.databaseController = databaseController;
        this.signUpController = signUpController;
        this.mainMenuController = mainMenuController;
        this.movieController = movieController;
    }

    public void buildDatabase() {
        DBController databaseController = new DBController();
        mainMenuController.getUser(databaseController.readAllTables("USERS"));
        ticketController.getShowings(databaseController.readAllTables("SHOWING"));
        ticketController.getTickets(databaseController.readAllTables("TICKET"));
        movieController.getMovies(databaseController.readAllTables("MOVIE"));
    }

    public void run() {
        buildMainFrame();
        buildTicket();
        buildSignUp();
    }

    private void buildMainFrame() {
        frame = new MainFrame();
        frame.setCard(0);
        MainMenuListener mainListener = new MainMenuListener();
        frame.getMainMenuView().addActionListener(mainListener);
        frame.getTicketViewView().addBackListener(mainListener);
        frame.getSignUpView().addBackListener(mainListener);
    }

    public void buildTicket() {
        TicketController ticketController = new TicketController();
        ticketController.setTicketView(frame.getTicketView());
        frame.setTicket(ticketController.getTicketModel());
        ticketController.setActionListener();
    }

    public void buildSignUp() {
        SignUpController signUpController = new SignUpController();
        signUpController.setSignUpView(frame.getSignUpView());
        frame.setSignUp(signUpController.getSignUpModel());
        signUpController.setActionListener();

    }

    public void buildMainMenu() {
        MainMenuController mainMenuController = new MainMenuController();
        mainMenuController.setmainMenuView(frame.getMainMenuView());
        frame.setMainMenu(mainMenuController.getMainMenuModel());
        mainMenuController.setActionListener();
    }

    class MainMenuListener() implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == frame.getMainMenuView().getBookMovieButton()) {
                frame.setCard(1);
            } else if (e.getSource() == frame.getMovieView().getViewTicketsButton()) {
                frame.setCard(2);
            } else if (e.getSource() == frame.getTicketView().get)
        }

    public static void main(String[] args) {
        TicketController ticketController = new TicketController();
        DBController databaseController = new DBController();
        SignUpController signUpController = new SignUpController();
        MainMenuController mainMenuController = new MainMenuController();
        MovieController movieController = new MovieController();
        MainApp mainApp = new MainApp(frame, ticketController, databaseController, signUpController, mainMenuController, movieController);
        mainApp.buildDatabase();
    }
}


