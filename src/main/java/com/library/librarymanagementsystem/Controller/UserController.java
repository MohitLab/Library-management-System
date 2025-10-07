package com.library.librarymanagementsystem.Controller;

import com.library.librarymanagementsystem.Model.Users;
import com.library.librarymanagementsystem.Repo.UserRepo;
import com.library.librarymanagementsystem.Service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/signUp")
    public String signUp(@RequestBody Users users){
        return userService.signUp(users);
    }

}
