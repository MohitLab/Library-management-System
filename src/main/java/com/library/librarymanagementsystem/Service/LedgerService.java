package com.library.librarymanagementsystem.Service;

import com.library.librarymanagementsystem.Model.Book;
import com.library.librarymanagementsystem.Model.Ledger;
import com.library.librarymanagementsystem.Model.Users;
import com.library.librarymanagementsystem.Repo.BookRepo;
import com.library.librarymanagementsystem.Repo.LedgerRepo;
import com.library.librarymanagementsystem.Repo.UserRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class LedgerService {

    BookService bookService;
    LedgerRepo ledgerRepo;
    BookRepo bookRepo;
    UserRepo userRepo;

    //functional requirements
    // issue a book, user returns a book, fine system

    public String issueBook(String userID, String bookID){

        Boolean isBookAvailable = bookService.isBookIssued(bookID);

        if(userRepo.findUserByUserID(userID).getHasBook()){
            return "Can't Issue more then one Book";
        }

        if(!isBookAvailable){
            return "Book is not available";
        }

        String ledgerID = String.valueOf(UUID.randomUUID());

        Ledger ledger = new Ledger(ledgerID, bookID, userID, false, LocalDate.now(), LocalDate.now().plusDays(30));

        ledgerRepo.save(ledger);

        Book book = bookRepo.findAll().stream().filter(books ->
                books.getBookID().equalsIgnoreCase(bookID)).findFirst().get();

        book.setIsIssued(true);
        bookRepo.save(book);

        Users users = userRepo.findAll().stream().filter(user ->
                user.getUserID().equalsIgnoreCase(userID)).findFirst().get();

        users.setHasBook(true);
        userRepo.save(users);

        return String.format("Book by Book ID %s issue to User ID : %s", bookID, userID);
    }

    public String returnBook(String userID, String bookID, Boolean isDamaged){

        Ledger ledger = ledgerRepo.findAll().stream().
                filter(ledger1 -> ledger1.getUserID().equalsIgnoreCase(userID) &&
                        ledger1.getBookID().equalsIgnoreCase(bookID)).findFirst().get();

        if(ledger.getReturnDate().isAfter(LocalDate.now())){
            if(!isDamaged){
                return "Book is returned successfully on time";
            }
        }

        //book not return on time

        return "abc";
    }
}
