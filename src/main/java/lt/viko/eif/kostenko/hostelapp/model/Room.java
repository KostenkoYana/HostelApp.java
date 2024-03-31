package lt.viko.eif.kostenko.hostelapp.model;


import javax.persistence.*;

/**
 * Represents a room entity in the hostel with properties such as ID, type of room,
 * room number, and price. Provides constructors, getters, setters, and a method to
 * generate a string representation of the room.
 */
@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")

    private int id;
    private String typeOfRoom;
    private int numberOfRoom;
    private int price;

    /**
     * Generates a string representation of the room, including its type, number, and price.
     * @return A string containing information about the room.
     */
    @Override
    public String toString() {
        return String.format("\t\tType of room: %s\n" +
                "\t\tNumber of room: %s\n" +
                "\t\tPrice: %s\n" +
                "\t\t_______________\n" , this.typeOfRoom, this.numberOfRoom, this.price);
    }

    /**
     * Default constructor.
     */
    public Room() {
    }

    /**
     * Parameterized constructor to initialize a room with a type, number, and price.
     * @param typeOfRoom   The type of the room.
     * @param numberOfRoom The number of the room.
     * @param price        The price of the room.
     */
    public Room(String typeOfRoom, int numberOfRoom, int price) {
        this.typeOfRoom = typeOfRoom;
        this.numberOfRoom = numberOfRoom;
        this.price = price;
    }

    /**
     * Getters and setters for all properties
     */
    public String getTypeOfRoom() {
        return typeOfRoom;
    }

    public void setTypeOfRoom(String name) {
        this.typeOfRoom = name;
    }

    public int getNumberOfRoom() {
        return numberOfRoom;
    }

    public void setNumberOfRoom(int credits) {
        this.numberOfRoom = credits;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}


