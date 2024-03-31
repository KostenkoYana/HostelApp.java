package lt.viko.eif.kostenko.hostelapp;
import lt.viko.eif.kostenko.hostelapp.db.DBLoader;
import lt.viko.eif.kostenko.hostelapp.menu.Menu;

/**
 * The main class of the Hostel Management Application.
 * It contains the main method to start the application.
 */
public class Main {
    public static void main(String[] args)  {

//        new DBLoader();
        Menu.processUserChoise();
    }
}