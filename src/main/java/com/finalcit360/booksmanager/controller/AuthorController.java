package com.finalcit360.booksmanager.controller;

import com.finalcit360.booksmanager.interfaces.AuthorRepository;
import com.finalcit360.booksmanager.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AuthorController {


    @Autowired
    AuthorRepository repository;

    @GetMapping("/authors")
    public List<Author> getAuthors() {
        System.out.println("Get all Authors...");
        List<Author> authors = new ArrayList<>();
        repository.findAll().forEach(author -> authors.add(author));
        return authors;
    }

    @GetMapping("/author/{id}")
    public Author getAuthorById(@PathVariable("id") int id) {
        System.out.println("Get Author by id...");
        List<Author> authors = repository.findById(id);
        return authors.get(0);
    }

    @PostMapping(value = "/author")
    public Author saveAuthor(@RequestBody Author author) {
        System.out.println("Saving Author...");
        author = repository.save(author);
        return author;
    }

    @PutMapping("/author/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable("id") int id, @RequestBody Author author) {
        System.out.println("Update Author with ID = " + id + "...");

        List<Author> authorList = repository.findById(id);

        if (!authorList.isEmpty()) {
            Author newAuthor = authorList.get(0);
            newAuthor.setName(author.getName());
            newAuthor.setDescription(author.getDescription());
            return new ResponseEntity<>(repository.save(newAuthor), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/author/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable("id") int id) {
        System.out.println("Delete Author...");
        repository.deleteById(id);
        return new ResponseEntity<>("Author have been deleted!", HttpStatus.OK);
    }
}
