//package Model;
//
//import Controller.DBController;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//public class ExistingUsersList {
//    private ArrayList<User> existingUsers;
//
//    public ExistingUsersList() {
//        existingUsers = new ArrayList<User>();
//        loadExistingUsers(databaseController.readAllTables("USERS"));
//    }
//
//    public void loadExistingUsers(ResultSet res) {
//        try {
//            while(res.next()) {
//                existingUsers.add(new User (
//                res.getString("Username"),
//                res.getString("FName"),
//                res.getString("LName"),
//                res.getString("Email"),
//                res.getBoolean("IsRegistered"),
//                res.getInt("AccountBalance")));
//            }
//        } catch(SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public ArrayList<User> getExistingUsers() {
//        return existingUsers;
//    }
//
//}
