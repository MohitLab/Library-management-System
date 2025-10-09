package com.library.librarymanagementsystem.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Ledger{

    @Id
    private String ledgerID;

    private String bookID;

    private String userID;

    private Boolean isDamaged;

    private LocalDate issueDate;

    private LocalDate returnDate;

}
