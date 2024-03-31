package lt.viko.eif.kostenko.hostelapp.db;

import lt.viko.eif.kostenko.hostelapp.model.*;
import lt.viko.eif.kostenko.hostelapp.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;
/**
 * A utility class responsible for loading hostel data into the database.
 * It utilizes Hibernate for Object-Relational Mapping to facilitate
 * interaction with the database and retrieval of Hostel entities.
 */
public class DBLoader {
    /**
     * Static block to initialize and save hostel data into the database.
     * This block creates two hostel objects with their associated rooms, clients,
     * contacts, and admins. It then saves these hostels into the database using Hibernate transactions.
     */
    static {

        Hostel hostel1 = new Hostel("Vilnius hostel","Main St, 11");
        Contacts contacts1 = new Contacts("vilhostel@gmail.com","+1234567890");
        Admin admin1 = new Admin("John", "Doe", 3);
        hostel1.setContacts(contacts1);
        hostel1.setAdmin(admin1);
        Room room1 = new Room("Dormitory", 1, 100);
        Room room2 = new Room("Single", 2, 400);
        Room room3 = new Room("Double", 3, 300);
        Room room4 = new Room("Suite", 4, 500);
        Room room5 = new Room("Dormitory", 5, 150);
        hostel1.getRooms().add(room1);
        hostel1.getRooms().add(room2);
        hostel1.getRooms().add(room3);
        hostel1.getRooms().add(room4);
        hostel1.getRooms().add(room5);
        Client client1 = new Client("Yana", "Kostenko");
        Client client2 = new Client("Lisa", "Bloom");
        Client client3 = new Client("Mike", "Scott");
        Client client4 = new Client("Pam", "Martinez");
        Client client5 = new Client("Kyley", "Taylor");
        Client client6 = new Client("Bob", "Rodriguez");
        hostel1.getClients().add(client1);
        hostel1.getClients().add(client2);
        hostel1.getClients().add(client3);
        hostel1.getClients().add(client4);
        hostel1.getClients().add(client5);
        hostel1.getClients().add(client6);

        Hostel hostel2 = new Hostel("Kyiv hostel","Birch St, 43");
        Contacts contacts2 = new Contacts("kyivhostel@gmail.com","+2345678901");
        Admin admin2 = new Admin("Olha", "Kovalenko", 8);
        hostel2.setContacts(contacts2);
        hostel2.setAdmin(admin2);
        Room room6 = new Room("Dormitory", 1, 200);
        Room room7 = new Room("Double", 2, 500);
        Room room8 = new Room("Double", 3, 600);
        Room room9 = new Room("Dormitory", 4, 300);
        hostel2.getRooms().add(room6);
        hostel2.getRooms().add(room7);
        hostel2.getRooms().add(room8);
        hostel2.getRooms().add(room9);
        Client client7 = new Client("Mykola", "Radko");
        Client client8 = new Client("Petro", "Kyrylenko");
        Client client9 = new Client("Kateryna", "Sokolova");
        Client client10 = new Client("Alina", "Turchin");
        Client client11 = new Client("Dmytro", "Krasko");
        hostel2.getClients().add(client7);
        hostel2.getClients().add(client8);
        hostel2.getClients().add(client9);
        hostel2.getClients().add(client10);
        hostel2.getClients().add(client11);

//        System.out.println(hostel1);
//        System.out.println(hostel2);

        /**
         * Transaction process.
         * Rollback the transaction in case of an exception.
         */
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = (Transaction) session.beginTransaction();
            session.save(hostel1);
            session.save(hostel2);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    /**
     * Loads all Hostel entities from the database.
     * This method establishes a session with the database using Hibernate.
     */
    public static List<Hostel> LoadHostels(){
        List<Hostel> result = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            result = session.createQuery("from Hostel", Hostel.class).list();
            result.forEach((host -> System.out.println(host)));
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
