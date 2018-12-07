package com.finalcit360.booksmanager.controller;

import com.finalcit360.booksmanager.interfaces.BookRepository;
import com.finalcit360.booksmanager.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class BookController {


    @Autowired
    BookRepository repository;

    @GetMapping("/books")
    public List<Book> getBooks() {
        System.out.println("Get all Books...");
        List<Book> books = new ArrayList<>();
        repository.findAll().forEach(author -> books.add(author));
        return books;
    }

    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable("id") int id) {
        System.out.println("Get Book by id...");
        List <Book> books = repository.findById(id);
        return books.get(0);
    }

    @PostMapping(value = "/book")
    public Book saveBook(@RequestBody Book book) {
        System.out.println("Saving Book by id...");
        book = repository.save(book);
        return book;
    }


    @PutMapping("/book/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") int id, @RequestBody Book book) {
        System.out.println("Update book with ID = " + id + "...");

        List<Book> bookList = repository.findById(id);

        if (!bookList.isEmpty()) {
            Book newBook = bookList.get(0);
            newBook.setTitle(book.getTitle());
            newBook.setSubtitle(book.getSubtitle());
            newBook.setAuthor(book.getAuthor());
            return new ResponseEntity<>(repository.save(newBook), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") int id) {
        System.out.println("Delete Book...");
        repository.deleteById(id);
        return new ResponseEntity<>("Book have been deleted!", HttpStatus.OK);
    }
}
