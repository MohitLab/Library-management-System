package com.library.librarymanagementsystem.Repo;

import com.library.librarymanagementsystem.Model.Ledger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LedgerRepo extends JpaRepository<Ledger, Integer> {
    Ledger findByBookID (String bookID);

    Ledger findByUserID (String userID);
}
