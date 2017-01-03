
import java.util.UUID;

/**
 * This is the implementation of Inventory Management System interface
 * Transaction id,Transaction status with Thread safe implementation
 * 
 * @author sooryaprasath
 */
public class InventoryManagementSystemImpl implements InventoryManagementSystem {

    @Override
    public PickingResult pickProduct(String productId, int amountToPick) {
        UUID transId = UUID.randomUUID();
        System.out.println("------------------------TRANSACTION DETAILS-------------------------");
        System.out.println("TRANSACTION ID : " + transId);
        Status stat = Status.OUTOFSTOCK;
        Product prod = MainProgram.imp.getItems().get(productId.toUpperCase());
        if (prod != null) {
            synchronized (prod) {
                if (checkandProceed(prod, amountToPick)) {
                    stat = Status.SUCCESS;
                    System.out.println(" PRODUCT PICKED UP FROM : " + prod.getWarehouse() + " AND FROM THE LOCATION : " + prod.getLocation() + " REMAINING ITEMS IN LOCATION : "
                            + prod.getQuantity());
                } else {
                    stat = Status.OUTOFSTOCK;
                }
            }
        } else {
            stat = Status.NOSUCHPRODUCT;

        }
        System.out.println("TRANSACTION STATUS : " + stat);
        System.out.println("-----------------------------------------------------------");
        System.out.println("\n");

        PickingResult pr = new PickingResult(stat, transId, productId, stat == Status.SUCCESS ? amountToPick : 0);
        return pr;

    }

    @Override
    public RestockingResult restockProduct(String productId, int amountToRestock) {

        System.out.println("------------------------TRANSACTION DETAILS-------------------------");
        UUID transid = UUID.randomUUID();
        Status stat = Status.NOSUCHPRODUCT;

        Product prod = MainProgram.imp.getItems().get(productId.toUpperCase());
        if (prod != null) {
            synchronized (prod) {
                prod.addQuantity(amountToRestock);
                stat = Status.SUCCESS;
            }
        } else {
            stat = Status.NOSUCHPRODUCT;
        }
        System.out.println("TRANSACTION ID : " + transid);
        RestockingResult res = new RestockingResult(stat, transid, productId, stat == Status.SUCCESS ? prod.getQuantity() : 0);
        System.out.println("TRANSACTION STATUS :" + stat);
        System.out.println("ITEMS REMAINING AFTER RESTOCKING :" + res.getItems());
        System.out.println("---------------------------------------");
        System.out.println("\n");
        return res;
    }

    public boolean checkandProceed(Product prod, int amountToPick) {
        int val = prod.getQuantity();
        if (val >= amountToPick) {
            prod.setQuantity(amountToPick);
            return true;
        }
        return false;
    }

}
