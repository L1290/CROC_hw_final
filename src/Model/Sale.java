package Model;
import java.util.Date;
public class Sale {
    private int saleId;
    private int sellerId;
    private int productId;
    private int amount;
    private Date saleDate;

    public Sale() {
        this.saleId = -1;
        this.sellerId = -1;
        this.productId = -1;
        this.amount = -1;
        this.saleDate = null;
    }
    public Sale(int saleId, int sellerId, int productId, int amount, Date saleDate) {
        this.saleId = saleId;
        this.sellerId = sellerId;
        this.productId = productId;
        this.amount = amount;
        this.saleDate = saleDate;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "saleId=" + saleId +
                ", sellerId=" + sellerId +
                ", productId=" + productId +
                ", amount=" + amount +
                ", saleDate=" + saleDate +
                '}';
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public int getSaleId() {
        return saleId;
    }

    public int getSellerId() {
        return sellerId;
    }

    public int getProductId() {
        return productId;
    }

    public int getAmount() {
        return amount;
    }

    public Date getSaleDate() {
        return saleDate;
    }
}
