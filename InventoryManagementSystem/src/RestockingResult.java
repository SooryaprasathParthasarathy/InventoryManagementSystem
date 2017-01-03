
import java.util.UUID;

/**
 *
 * @author sooryaprasath
 */
class RestockingResult {

    private Status status;
    private UUID transid;
    private String pid;
    private int itemscount;

    public RestockingResult(Status status, UUID transactionid, String productid, int itemsremaining) {
        this.status = status;
        this.transid = transactionid;
        this.pid = productid;
        this.itemscount = itemsremaining;

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
