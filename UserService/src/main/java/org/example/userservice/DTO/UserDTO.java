package org.example.userservice.DTO;

import java.util.ArrayList;

public class UserDTO {
    private int id;
    private String name;
    private String address;
    private String email;
    private String phone;
    private ArrayList<RatingDTO> ratingList;
    public ArrayList<RatingDTO> getRatingList() {
        return ratingList;
    }
    public void setRatingList(ArrayList<RatingDTO> ratingList) {
        this.ratingList = ratingList;
    }
    private ArrayList<ProductDTO> productList;
    public ArrayList<ProductDTO> getProductList() {
        return productList;
    }
    public void setProductList(ArrayList<ProductDTO> productList) {
        this.productList = productList;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
