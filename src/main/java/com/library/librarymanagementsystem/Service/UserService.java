package com.library.librarymanagementsystem.Service;

import com.library.librarymanagementsystem.Model.Users;
import com.library.librarymanagementsystem.Repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    UserRepo userRepo;

    //functional requirements
    // required multiple endpoints(signup, users(for admin), users/id

    public UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    public String signUp(Users users){
        boolean userExists = userRepo.findAll().stream()
                .anyMatch(existingUsers ->
                        existingUsers.getEmail().equalsIgnoreCase(users.getEmail()) ||
                                existingUsers.getPhoneNumber().equals(users.getPhoneNumber())
                );

        if (userExists) {
            return "User already exists!";
        }
        String userID = String.valueOf(UUID.randomUUID());
        users.setUserID(userID);
        userRepo.save(users);
        return "You are registered successfully!, Your UserID is : " + userID;
    }
}
