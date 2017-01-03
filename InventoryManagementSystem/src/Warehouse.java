
/**
 *
 * @author sooryaprasath
 */
public class Warehouse {

    private int warehouseId;
    private String warehouseName;

    public Warehouse(int wid, String name) {
        this.warehouseId = wid;
        this.warehouseName = name;
    }

    public String getName() {
        return this.warehouseName;
    }

    public int getId() {
        return this.warehouseId;
    }
}
