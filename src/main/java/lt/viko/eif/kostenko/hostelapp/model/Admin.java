package lt.viko.eif.kostenko.hostelapp.model;


import javax.persistence.*;

/**
 * Represents an administrator entity responsible for managing a hostel.
 * This class contains properties such as ID, name, last name, and experience level.
 */
@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String name;
    private String lastName;
    private int expirence;

    /**
     * Default constructor.
     */
    public Admin() {
    }

    /**
     * Parameterized constructor to initialize an admin with specified attributes.
     *
     * @param name       The first name of the administrator.
     * @param lastName   The last name of the administrator.
     * @param expirence The experience level of the administrator.
     */
    public Admin(String name, String lastName, int expirence) {
        this.name = name;
        this.lastName = lastName;
        this.expirence = expirence;
    }

    /**
     * Generates a string representation of the administrator.
     * @return A string containing the administrator's name, last name, and experience level.
     */
    @Override
    public String toString() {
        return String.format("\n\t\tName: %s\n" +
                "\t\tLastname: %s\n" +
                "\t\tExpirince: %s", this.name, this.lastName, this.expirence);
    }

    /**
     * Retrieves the ID of the administrator.
     * @return The ID of the administrator.
     */
    public int getId() {
        return id;
    }
    /**
     * Sets the ID of the administrator.
     * @param id The ID of the administrator.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the first name of the administrator.
     * @return The first name of the administrator.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the first name of the administrator.
     * @param name The first name of the administrator.
     */
    public void setName(String name) { this.name = name; }

    /**
     * Retrieves the last name of the administrator.
     * @return The last name of the administrator.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the administrator.
     * @param lastName The last name of the administrator.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Retrieves the experience level of the administrator.
     * @return The experience level of the administrator.
     */
    public int getExpirence() {
        return expirence;
    }

    /**
     * Sets the experience level of the administrator.
     * @param expirence The experience level of the administrator.
     */
    public void setExpirence(int expirence) {
        this.expirence = expirence;
    }
}
