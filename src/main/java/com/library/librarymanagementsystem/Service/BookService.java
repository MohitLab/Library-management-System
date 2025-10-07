package com.library.librarymanagementsystem.Service;

import com.library.librarymanagementsystem.Model.Book;
import com.library.librarymanagementsystem.Repo.BookRepo;
import org.hibernate.jdbc.Expectation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookService {

    BookRepo bookRepo;

    public BookService(BookRepo bookRepo){
        this.bookRepo = bookRepo;
    }

    //functional requirements
    // add or delete book, get list of all the books, get list by category,
    // get book by book id, get book list by author

    public String addBook(Book book){
        boolean exists = bookRepo.findAll().stream()
                .anyMatch(existingBook ->
                existingBook.getBookName().equalsIgnoreCase(book.getBookName()) ||
                        existingBook.getAuthor().equals(book.getAuthor())
        );

        if(exists){
            return "Book already present!";
        }
        String bookID = String.valueOf(UUID.randomUUID());
        book.setBookID(bookID);

        bookRepo.save(book);
        return "Book has been added successfully!";
    }

    public String deleteBook(String bookID){
        boolean exists = bookRepo.findAll().stream()
                .anyMatch(existingBook ->
                        existingBook.getBookID().equalsIgnoreCase(bookID)
                );
        if(!exists){
            return "Cannot delete, Book does not exist";
        }
        else{
            bookRepo.deleteBookByBookID(bookID);
            return "Book deleted successfully!";
        }
    }

    public List<Book> findBookByCategory(String category){
        List<Book> bookList = bookRepo.findAll().stream().
                filter(existingBook -> existingBook.getCategory().equalsIgnoreCase(category))
                .toList();

        return bookList;
    }

    public List<Book>  findBookByAuthor(String author){
        List<Book> bookList = bookRepo.findAll().stream().
                filter(existingBook -> existingBook.getAuthor().equalsIgnoreCase(author))
                .toList();

        return bookList;
    }

    public String findBookByBookID(String bookID){
        Optional<Book> book = bookRepo.findAll().stream()
                .filter(existingBook ->
                        existingBook.getBookID().equalsIgnoreCase(bookID)
                ).findFirst();

        if(book.isEmpty()){
            return "Book does not exist";
        }
        else{
            bookRepo.findBookByBookID(bookID);
            return "Book exists, The name of the Book is : " + book.get().getBookName();
        }
    }

}
