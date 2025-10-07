package com.library.librarymanagementsystem.Controller;

import com.library.librarymanagementsystem.Model.Users;
import com.library.librarymanagementsystem.Repo.UserRepo;
import com.library.librarymanagementsystem.Service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserRepo userRepo;
    UserService userService;

    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @PostMapping("/signUp")
    public String signUp(@RequestBody Users users){
        return userService.signUp(users);
    }

}
