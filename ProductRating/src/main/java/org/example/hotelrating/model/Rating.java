package org.example.hotelrating.model;
import jakarta.persistence.*;

@Entity
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int pr_id;
    private String product_name;
    private int rating;
    public int getPr_id() {
        return pr_id;
    }
    public void setPr_id(int pr_id) {
        this.pr_id = pr_id;
    }
    public String getProduct_name() {
        return product_name;
    }
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
}


//one to many
//many to one
