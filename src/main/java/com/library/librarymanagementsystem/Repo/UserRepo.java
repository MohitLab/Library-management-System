package com.library.librarymanagementsystem.Repo;

import com.library.librarymanagementsystem.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users, Integer> {

    Users findUserByUserID(String userID);
}
