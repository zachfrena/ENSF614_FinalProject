package Controller;

import com.sun.tools.javac.Main;
import view.MainFrame;
import Model.Ticket;
import view.ProjectApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainApp {
    MainFrame frame;
    LoginController loginController;

    DBController databaseController;
    SignUpController signUpController;
    MainMenuController mainMenuController;
    //    TicketController ticketController;
//    MovieController movieController;

//    public MainApp(TicketController ticketController, DBController databaseController,
//                   SignUpController signUpController, MainMenuController mainMenuController, MovieController movieController) {
//    //    this.frame = frame;
//        this.ticketController = ticketController;
//        this.databaseController = databaseController;
//        this.signUpController = signUpController;
//        this.mainMenuController = mainMenuController;
//        this.movieController = movieController;
//    }

//    public MainApp(SignUpController signUpController, MainMenuController mainMenuController, MovieController movieController,
//                   DBController databaseController, LoginController loginController) {
//        //    this.frame = frame;
//        this.ticketController = ticketController;
//        this.databaseController = databaseController;
//        this.signUpController = signUpController;
//        this.mainMenuController = mainMenuController;
//        this.movieController = movieController;
//        this.loginController = loginController;
//        buildDatabase();
//    }

    public MainApp(){
        run();
    }

    public void run() {
        buildDatabase();
        buildMainFrame();
        buildLogin();
        buildSignUp();
        buildMainMenu();

//        buildTicket();
//        buildMovie();
//        buildSeat();
    }

    private void buildMainFrame(){
        frame = new MainFrame();
        frame.setCard(0);
        MenuListener mlistener = new MenuListener();
        frame.getLoginView().addMenuListener(mlistener);
        frame.getSignUpView().addMenuListener(mlistener);
        frame.getMainMenuView().addMenuListener(mlistener);
        frame.getTicketView().addMenuListener(mlistener);
        frame.getMovieView().addMenuListener(mlistener);
        frame.getSeatView().addMenuListener(mlistener);
    }

    private void buildDatabase(){
        databaseController = new DBController();
    }

    private void buildLogin(){
        loginController = new LoginController();
        loginController.setLoginView(frame.getLoginView());
        loginController.setActionListener();
    }

    private void buildSignUp(){
        signUpController = new SignUpController(databaseController);
        signUpController.setSignUpView(frame.getSignUpView());
        signUpController.setActionListener();
    }

    private void buildMainMenu(){
        mainMenuController = new MainMenuController();
        mainMenuController.setMainMenuView(frame.getMainMenuView());
        mainMenuController.setActionListener();
    }

    class MenuListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == frame.getLoginView().getLoginButton()) {
                if (frame.getLoginView().getStatus()) {
                    mainMenuController.setUser(loginController.getLoggedInUser());
                    mainMenuController.setIsRegistered(loginController.getLoggedInUser().isRegistered());
                    mainMenuController.displayAccountBalance();
                    mainMenuController.setGreeting();
                    frame.setCard(1);
                } else {
                    frame.getSignUpView().setUserName(frame.getLoginView().getUserName());
                    frame.setCard(2);
                }
            } else if (e.getSource() == frame.getSignUpView().getConfirmButton()) {
                mainMenuController.setUser(signUpController.getUser());
                mainMenuController.setIsRegistered(signUpController.getUser().isRegistered());
                mainMenuController.displayAccountBalance();
                mainMenuController.setGreeting();
                frame.setCard(1);
            } else if (e.getSource() == frame.getMainMenuView().getTicketButton()) {
                frame.setCard(3);
            } else if (e.getSource() == frame.getMainMenuView().getMovieButton()) {
                if (mainMenuController.checkBalance())
                    frame.setCard(4);
            } else if (e.getSource() == frame.getTicketView().getBackButton()) {
                frame.setCard(1);
            } else if (e.getSource() == frame.getMovieView().getBackButton()) {
                frame.setCard(1);
            } else if (e.getSource() == frame.getMovieView().getConfirmButton()) {
                frame.getSeatView().resetSeatSelection();
                frame.setCard(5);
            } else if (e.getSource() == frame.getSeatView().getCancelButton()) {
                frame.setCard(1);
            } else if (e.getSource() == frame.getSeatView().getConfirmButton()) {
                frame.setCard(3);
            }
        }
    }

//    public void buildDatabase() {
//        DBController databaseController = new DBController();
//      //  loginController.loadExistingUsers(databaseController.readAllTables("USERS"));
//       // movieController.getShowings(databaseController.readAllTables("SHOWING"));   // getMovies(Movie movie)
//       // ticketController.getUser(databaseController.readAllTables("USERS")); // ticketController(Ticket ticket)
//
//    }



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

//    public void buildLogin() {
////        LoginController loginController = new LoginController();
//    }
//
//    public void buildSignUp() {
//        SignUpController signUpController = new SignUpController(databaseController);
//       /* signUpController.setSignUpView(frame.getSignUpView());
//        frame.setSignUp(signUpController.getSignUpModel());
//        signUpController.setActionListener();
//
//        */
//
//    }

//    public void buildMainMenu() {
////        MainMenuController mainMenuController = new MainMenuController(User u);
//       /* mainMenuController.setmainMenuView(frame.getMainMenuView());
//        frame.setMainMenu(mainMenuController.getMainMenuModel());
//        mainMenuController.setActionListener();
//
//        */
//    }

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
        new MainApp();
//        MainFrame frame = new MainFrame();
//        DBController databaseController = new DBController();
//        LoginController loginController = new LoginController(databaseController);
//        TicketController ticketController = new TicketController(loginController.getLoggedInUser());
//        SignUpController signUpController = new SignUpController(databaseController);
//        MainMenuController mainMenuController = new MainMenuController(loginController.getLoggedInUser());
//        MovieController movieController = new MovieController();
//
//
////        MainApp mainApp = new MainApp(frame, ticketController, databaseController, signUpController, mainMenuController, movieController);
//        MainApp mainApp = new MainApp(signUpController, mainMenuController, movieController,
//                databaseController, loginController);
//        mainApp.buildDatabase();
    }
}


