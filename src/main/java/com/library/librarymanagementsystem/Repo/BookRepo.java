package com.library.librarymanagementsystem.Repo;

import com.library.librarymanagementsystem.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Integer> {

    Book findBookByBookID(String bookID);

    void deleteBookByBookID(String bookID);
}
