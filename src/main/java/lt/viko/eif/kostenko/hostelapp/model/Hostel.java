package lt.viko.eif.kostenko.hostelapp.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a hostel entity and contains properties such as its ID,
 * name, address, contacts, admin, rooms list, and client list. It also
 * provides methods for constructing string representations of its rooms and
 * clients lists, as well as constructors and getters/setters for its properties.
 * */

@XmlRootElement
@XmlType(propOrder={"id","name", "address", "contacts", "admin", "rooms", "clients"})
@Entity
@Table(name = "hostel")
public class Hostel {
    /**
     * The unique identifier for a hospital
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    private String name;
    private String address;

    @OneToOne(targetEntity = Admin.class,cascade = CascadeType.ALL)
    private Admin admin;
    @OneToOne(targetEntity = Contacts.class,cascade = CascadeType.ALL)
    private Contacts contacts;

    @OneToMany(targetEntity = Room.class,cascade=CascadeType.ALL)
    private List<Room> rooms = new ArrayList<>();

    @OneToMany(targetEntity = Client.class, cascade = CascadeType.ALL)
    private List<Client> clients = new ArrayList<>();

    /**
     * Default constructor.
     */
    public Hostel() {
    }

    /**
     * Parameterized constructor to initialize a hostel with a name and address.
     * @param name    The name of the hostel.
     * @param address The address of the hostel.
     */
    public Hostel(String name, String address) {
        this.name = name;
        this.address = address;
    }

    /**
     * Generates a string representation of the hostel, including its name, address, contacts,
     * admin, rooms list, and clients list.
     * @return A string representation of the hostel.
     */
    @Override
    public String toString() {
        return String.format("Hostel: \n" +
                        "\tName: %s\n" +
                        "\tAddress of hostel: %s\n" +
                        "\tContacts: %s\n" +
                        "\tAdmin: %s\n" +
                        "\tRooms: \n %s" +
                        "\tClients: \n%s", this.name, this.address,
                this.contacts, this.admin, constructRoomList(), constructClientList());
    }

    /**
     * Constructs a string representation of the rooms list.
     * @return A string containing information about each room in the rooms list.
     */
    private String constructRoomList(){
        String result = "";
        for (Room room : this.rooms){
            result += room;
        }
        return result;
    }

    /**
     * Constructs a string representation of the clients list.
     * @return A string containing information about each client in the clients list.
     */
    private String constructClientList(){
        String result = "";
        for (Client client : this.clients){
            result += client;
        }
        return result;
    }

    /**
     * Getters and setters for all properties
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Contacts getContacts() {
        return contacts;
    }

    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }

    public Admin getAdmin() { return admin; }

    public void setAdmin(Admin admin) { this.admin = admin; }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Client> getClients() { return clients; }

    public void setClients(List<Client> clients) { this.clients = clients; }
}