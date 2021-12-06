package Controller;

import Model.Ticket;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainApp {
//    MainFrame frame;
    LoginController loginController;
    TicketController ticketController;
    DBController databaseController;
    SignUpController signUpController;
    MainMenuController mainMenuController;
    MovieController movieController;

//    public MainApp(TicketController ticketController, DBController databaseController,
//                   SignUpController signUpController, MainMenuController mainMenuController, MovieController movieController) {
//    //    this.frame = frame;
//        this.ticketController = ticketController;
//        this.databaseController = databaseController;
//        this.signUpController = signUpController;
//        this.mainMenuController = mainMenuController;
//        this.movieController = movieController;
//    }

    public MainApp(SignUpController signUpController, MainMenuController mainMenuController, MovieController movieController,
                   DBController databaseController, LoginController loginController) {
        //    this.frame = frame;
        this.ticketController = ticketController;
        this.databaseController = databaseController;
        this.signUpController = signUpController;
        this.mainMenuController = mainMenuController;
        this.movieController = movieController;
        this.loginController = loginController;
        buildDatabase();
    }


    public void buildDatabase() {
        DBController databaseController = new DBController();
      //  loginController.loadExistingUsers(databaseController.readAllTables("USERS"));
       // movieController.getShowings(databaseController.readAllTables("SHOWING"));   // getMovies(Movie movie)
       // ticketController.getUser(databaseController.readAllTables("USERS")); // ticketController(Ticket ticket)

    }

    public void run() {
      //  buildMainFrame();
       // buildTicket();
    }

   /* private void buildMainFrame() {
        frame = new MainFrame();
        frame.setCard(0);
        MainMenuListener mainListener = new MainMenuListener();
        frame.getMainMenuView().addActionListener(mainListener);
        frame.getTicketViewView().addBackListener(mainListener);
        frame.getSignUpView().addBackListener(mainListener);


    }
    */

////    public void buildTicket() {
////        TicketController ticketController = new TicketController();
//       /* ticketController.setTicketView(frame.getTicketView());
//        frame.setTicket(ticketController.getTicketModel());
//        ticketController.setActionListener();
//
//        */
//    }

    public void buildLogin() {
//        LoginController loginController = new LoginController();
    }

    public void buildSignUp() {
        SignUpController signUpController = new SignUpController(databaseController);
       /* signUpController.setSignUpView(frame.getSignUpView());
        frame.setSignUp(signUpController.getSignUpModel());
        signUpController.setActionListener();

        */

    }

    public void buildMainMenu() {
//        MainMenuController mainMenuController = new MainMenuController(User u);
       /* mainMenuController.setmainMenuView(frame.getMainMenuView());
        frame.setMainMenu(mainMenuController.getMainMenuModel());
        mainMenuController.setActionListener();

        */
    }

  /*  class MainMenuListener() implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == frame.getMainMenuView().getBookMovieButton()) {
                frame.setCard(1);
            } else if (e.getSource() == frame.getMovieView().getViewTicketsButton()) {
                frame.setCard(2);
            } else if (e.getSource() == frame.getTicketView().get)
        }
*/
    public static void main(String[] args) {
//        MainFrame frame = new MainFrame();
        DBController databaseController = new DBController();
        LoginController loginController = new LoginController(databaseController);
        //TicketController ticketController = new TicketController();
        SignUpController signUpController = new SignUpController(databaseController);
        MainMenuController mainMenuController = new MainMenuController(loginController.getLoggedInUser());
        MovieController movieController = new MovieController();


//        MainApp mainApp = new MainApp(frame, ticketController, databaseController, signUpController, mainMenuController, movieController);
        MainApp mainApp = new MainApp(signUpController, mainMenuController, movieController,
                databaseController, loginController);
        mainApp.buildDatabase();
    }
}


