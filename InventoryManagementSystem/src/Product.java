

/**
 *
 * @author sooryaprasath
 */
public class Product {
    public int productId;
    public String productName;
    public volatile int quantity;
    public String levelName;
    private String locationName;
    private String warehouseName;
    
    public Product(int id,String name,int quantity,Levels block,Locations loc,Warehouse war){
        this.productId = id ;
        this.productName = name; 
        this.quantity = quantity;
        this.levelName = block.levelName;
        this.locationName = loc.getName();
        this.warehouseName = war.getName();
    }
    
    public String getName(){
        return this.productName;
    }
    
    public int getId(){
        return this.productId;
    }
    
    public int getQuantity(){
        return this.quantity;
    }
    public String getLevel(){
        return this.levelName;
    }
    public String getWarehouse(){
        return this.warehouseName;
    }
    public String getLocation(){
        return this.locationName;
    }
    
    public void setQuantity(int quant){
        this.quantity -= quant;
    }
    
    public void addQuantity(int re){
        this.quantity += re;
    }
}
