package com.library.librarymanagementsystem.Controller;

import com.library.librarymanagementsystem.Model.Book;
import com.library.librarymanagementsystem.Service.BookService;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class BookController {

    BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @PostMapping("/book/add")
    public String addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @Transactional
    @DeleteMapping("/book/delete/{bookID}")
    public String deleteBook(@PathVariable String bookID){
        return bookService.deleteBook(bookID);
    }

    @GetMapping("/book/category/{category}")
    public List<Book> getByCategory(@PathVariable String category){
        return bookService.findBookByCategory(category);
    }

    @GetMapping("/book/author/{author}")
    public List<Book> getByAuthor(@PathVariable String author){
        return bookService.findBookByAuthor(author);
    }

    @GetMapping("/book/{bookID}")
    public String getByID(@PathVariable String bookID){
        return bookService.findBookByBookID(bookID);
    }

}
