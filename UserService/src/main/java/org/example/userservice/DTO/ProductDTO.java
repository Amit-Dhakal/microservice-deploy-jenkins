package org.example.userservice.DTO;
import java.math.BigInteger;
public class ProductDTO {
    private int id;
    private String product_name;
    private BigInteger product_price;
    private int quantity;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getProduct_name() {
        return product_name;
    }
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }
    public BigInteger getProduct_price() {
        return product_price;
    }
    public void setProduct_price(BigInteger product_price) {
        this.product_price = product_price;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
