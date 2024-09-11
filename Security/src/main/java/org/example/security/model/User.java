package org.example.security.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String email;
    private String password;
    private String address;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES", joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id"))
    List<Role> roles;
}




//many user has many roles
//many user can have many role
//custom security process
//ADMIN TABLE name,role
//USER TABLE name,role
//