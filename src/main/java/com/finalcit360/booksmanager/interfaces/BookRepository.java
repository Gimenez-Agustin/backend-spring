package com.finalcit360.booksmanager.interfaces;

import com.finalcit360.booksmanager.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Integer> {
	List<Book> findById(int id);
}
