package com.realestate.thymeleaf.RealEstate.Service;

import com.realestate.thymeleaf.RealEstate.Model.UserData;
import com.realestate.thymeleaf.RealEstate.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserData> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<UserData> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public UserData saveUser(UserData user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}