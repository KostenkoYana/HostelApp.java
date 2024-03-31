package lt.viko.eif.kostenko.hostelapp.db;

import lt.viko.eif.kostenko.hostelapp.model.Hostel;

import java.util.ArrayList;
import java.util.List;
/**
 * Encapsulates a collection of Hostel objects.
 * This class serves as a data holder for hostel entities, providing methods
 * to retrieve and modify the list of hostels.
 */
public class HostelData {
    private List<Hostel> hostels = new ArrayList<>();

    /**
     * Gets the list of hostel entities.
     * @return A list of Hostel objects currently held by this instance.
     */
    public List<Hostel> getHostels(){
        return hostels;
    }

    /**
     * Sets the list of hostel entities.
     * This method replaces the current list of hostels with the provided list.
     * @param hostels The new list of Hostel objects to be stored.
     */
    public void setHostels(List<Hostel> hostels) {
        this.hostels = hostels;
    }
}
