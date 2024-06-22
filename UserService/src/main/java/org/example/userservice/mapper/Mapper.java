package org.example.userservice.mapper;

import org.example.userservice.DTO.UserDTO;
import org.example.userservice.model.User;
public class Mapper {
    public UserDTO entityToDTO(User user){
        UserDTO userDTO=new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setAddress(user.getAddress());
        userDTO.setPhone(user.getPhone());
        return userDTO;
    }
    public User dtoToEntity(UserDTO userDTO){
        User user=new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setAddress(userDTO.getAddress());
        user.setPhone(userDTO.getPhone());
        user.setEmail(userDTO.getPhone());
        return user;
    }
}
