package lt.viko.eif.kostenko.hostelapp.model;


import javax.persistence.*;

/**
 * Represents a client entity staying at a hostel.
 * This class contains properties such as ID, name, and last name of the client.
 */
@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")

    private  int id;
    private String name;
    private String lastName;

    /**
     * Default constructor.
     */
    public Client() {
    }

    /**
     * Generates a string representation of the client.
     * @return A string containing the client's name and last name.
     */
    @Override
    public String toString() {
        return String.format("\t\tName of client: %s\n" +
                "\t\tLastname of client: %s\n" +
                "\t\t_______________\n", this.name, this.lastName);
    }

    /**
     * Parameterized constructor to initialize a client with specified attributes.
     * @param name     The first name of the client.
     * @param lastName The last name of the client.
     */
    public Client(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    /**
     * Retrieves the name of the client.
     * @return The name of the client.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the client.
     * @param name The name of the client.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the last name of the client.
     * @return The last name of the client.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the client.
     * @param lastName The last name of the client.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
