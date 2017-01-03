
import java.util.UUID;

/**
 *
 * @author sooryaprasath
 */
class PickingResult {

    private Status status;
    private UUID transid;
    private String pid;
    private int itemscount;

    public PickingResult(Status status, UUID transactionid, String productid, int itemspicked) {
        this.status = status;
        this.transid = transactionid;
        this.pid = productid;
        this.itemscount = itemspicked;

    }

    public Status getStatus() {
        return this.status;
    }

    public UUID getTransid() {
        return this.transid;
    }

    public String getProductid() {
        return this.pid;
    }

    public int getItems() {
        return this.itemscount;
    }

}
