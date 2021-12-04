import Controller.DBController;
import Controller.LoginController;
import Controller.MainMenuController;

public class Test {

    public static void main(String[] args){
        System.out.println("test for final project");
        DBController dbController = new DBController();
        LoginController loginController = new LoginController();
        MainMenuController mainMenuController = new MainMenuController();

        loginController.login("dunefansdf");


    }

}
