# InventoryManagementSystem

This implementation of the system keeps track of products in the inventory and perrform picking up of stocks,restocking of items and displaying the items left in the warehouse.

Assumptions : 
There is a warehouse that has multiple locations and each location can have multiple level and each product will be stored in only one named location in the warehouse.

A thread safe implemetation not just the method but the product item.

For example : A person requesting itemA need not wait for the person requesting itemB but if both the people requesting same product then threading concept of wait comes into picture thereby making the system efficient.

Interface : 
/**
 *
 * @author sooryaprasath
 */

public interface InventoryManagementSystem {

    PickingResult pickProduct(String productId, int amountToPick);

    RestockingResult restockProduct(String productId, int amountToRestock);

}


Class that implements this interface InventoryManagementSystemImpl .
