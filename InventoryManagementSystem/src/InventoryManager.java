
import java.util.Hashtable;

/**
 *A class to create defaults data structures
 * @author sooryaprasath
 */
public class InventoryManager {

    public Hashtable<String, Product> products;
    public Hashtable<String, Levels> levels;
    public Hashtable<String, Locations> locations;
    public Hashtable<String, Warehouse> warehouse;

    public InventoryManager() {
        this.products = new Hashtable<String, Product>();
        this.levels = new Hashtable<String, Levels>();
        this.locations = new Hashtable<String, Locations>();
        this.warehouse = new Hashtable<String, Warehouse>();
    }

    public void Addproducts(Product prod) {
        products.put(prod.productName, prod);
    }

    public void Addblocks(Levels Loc) {
        levels.put(Loc.levelName, Loc);
    }

    public Hashtable<String, Product> getItems() {
        return this.products;
    }

    public Hashtable<String, Locations> getLocation() {
        return this.locations;
    }

    public Hashtable<String, Warehouse> getWareHouse() {
        return this.warehouse;
    }

}
