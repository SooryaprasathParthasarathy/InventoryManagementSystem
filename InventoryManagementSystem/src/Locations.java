
/**
 *
 * @author sooryaprasath
 */
public class Locations {

    private int LocationId;
    private String LocationName;

    public Locations(int id, String name) {
        this.LocationId = id;
        this.LocationName = name;
    }

    public String getName() {
        return this.LocationName;
    }
}
