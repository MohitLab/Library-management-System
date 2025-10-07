package com.library.librarymanagementsystem.Model;

//Book service :
//1.) Book ID
//2.) Book name
//3.) Book category
//4.) Book Image
//5.) Book Rating
//6.) Book price

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Book{

    @Id
    private String bookID;

    private String bookName;

    private String author;

    private String category;

    private Float rating;

    private Integer bookPrice;
}
