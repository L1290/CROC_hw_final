package Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Seller {
    private int sellerId;
    private String sellerLastName;
    private String sellerFirstName;

    public Seller(){
        this.sellerId = -1;
        this.sellerLastName = null;
        this.sellerFirstName = null;
    }

    public Seller(int sellerId, String sellerLastName, String sellerFirstName) {
        this.sellerId = sellerId;
        this.sellerLastName = sellerLastName;
        this.sellerFirstName = sellerFirstName;
    }
    @JsonProperty
    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public void setSellerLastName(String sellerLastName) {
        this.sellerLastName = sellerLastName;
    }

    public void setSellerFirstName(String sellerFirstName) {
        this.sellerFirstName = sellerFirstName;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "sellerId=" + sellerId +
                ", sellerLastName='" + sellerLastName + '\'' +
                ", sellerFirstName='" + sellerFirstName + '\'' +
                '}';
    }
    @JsonIgnore
    public int getSellerId() {
        return sellerId;
    }

    public String getSellerLastName() {
        return sellerLastName;
    }

    public String getSellerFirstName() {
        return sellerFirstName;
    }
    /*public static Seller getBySellerId(List<Seller> sellerList, Integer id) {
        for(Seller s: sellerList){
            if(s.getSellerId() == id){
                return s;
            }
        }
        return new Seller();
    }*/

    /**
     * Ищет продавца по его id
     * @param sellerList список всех продавцов
     * @param id id продавца
     * @return продавец
     */
    public static Seller getBySellerId(List<Seller> sellerList, Integer id) {
        return sellerList.stream().filter(x -> id.equals(x.getSellerId())).findAny().orElse(new Seller());
    }
}
