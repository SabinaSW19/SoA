package com.ubbcluj.book2.controller;

import com.ubbcluj.book2.domain.Book;
import com.ubbcluj.book2.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class BookController {
    @Autowired
    BookService bookService;

    @RequestMapping(value="/book/{title}",method= RequestMethod.GET)
    public ResponseEntity<?> getBookByTitle(@PathVariable("title") String title) throws IOException, TimeoutException {
        System.out.println("Calling getBookByTitle" + title);
        return new ResponseEntity<>(bookService.getBookByTitle(title),HttpStatus.OK);
    }

    @RequestMapping(value="/books",method= RequestMethod.GET)
    public ResponseEntity<?> getBooks(){
        System.out.println("Calling getBooks");
        return new ResponseEntity<>(bookService.getBooks(),HttpStatus.OK);
    }

    @RequestMapping(value="/borrow/{title}",method= RequestMethod.POST)
    public ResponseEntity<?> borrowBook(@PathVariable("title")String title) throws IOException, TimeoutException {
        System.out.println("Calling borrowBook" + title);
        bookService.borrowBook(title);
        System.out.println(bookService.getBookByTitle(title).get(0).getNumberOfProducts()+ " remaining.");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
