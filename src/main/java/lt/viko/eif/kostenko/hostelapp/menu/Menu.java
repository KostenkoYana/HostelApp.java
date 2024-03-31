package lt.viko.eif.kostenko.hostelapp.menu;

import lt.viko.eif.kostenko.hostelapp.db.DBLoader;
import lt.viko.eif.kostenko.hostelapp.db.HostelData;
import lt.viko.eif.kostenko.hostelapp.model.Hostel;
import lt.viko.eif.kostenko.hostelapp.util.JaxbUtilGeneric;

import java.util.Scanner;

/**
 * Represents a menu interface for managing hostels and their data.
 * This class provides options to load hostels, print XML representations, convert XML to POJO,
 * convert XML to XSD, and quit the application.
 */
public class Menu {

    private static HostelData hostelData = new HostelData();

    /**
     * Displays the main menu and prompts the user for input.
     * @param input The Scanner object used for user input.
     * @return An integer representing the user's choice from the menu options.
     */
    public static int displayMenu(Scanner input){
        System.out.println("Make a selection ");
        System.out.println("_________________");
        System.out.printf("| 1) %20s \n", "Load hostels");
        System.out.printf("| 2) %20s \n", "Print XML");
        System.out.printf("| 3) %20s \n", "Convert XML to POJO");
        System.out.printf("| 4) %20s \n", "Convert XML to XSD");
        System.out.printf("| 5) %20s \n", "Quit");
        return input.nextInt();
    }

    /**
     * Processes the user's choice from the main menu.
     * This method continuously prompts the user for input, processes their choice,
     * and executes the corresponding functionality based on the selected option.
     * It loops until the user chooses to quit the application.
     */
    public  static void processUserChoise(){
        Scanner input = new Scanner(System.in);
        int userChoise;
        do{
            userChoise = displayMenu(input);
            switch (userChoise){
                case 1:
                    // Load hostels from the database
                    hostelData.setHostels(DBLoader.LoadHostels());
                    break;
                case 2:
                    // Print XML representations of loaded hostels
                    hostelData.getHostels().forEach(hostel -> JaxbUtilGeneric.convertToXML(hostel));
                    break;
                case 3:
                    // Convert XML to POJO and print the result
                    String xmlFile = "generated.xml";
                    Hostel hostel = JaxbUtilGeneric.convertToPOJO(xmlFile, Hostel.class);
                    System.out.println(hostel);
                    break;
                case 4:
                    // Generate XSD schema from the Hostel class
                    JaxbUtilGeneric.generateXSD(Hostel.class);
                    break;
                case 5:
                    // Quit the application
                    System.out.println("Thank you and goodbye!");
                    System.exit(0);
                    break;
                default:
            }
        }while(userChoise != 5);
    }
}
