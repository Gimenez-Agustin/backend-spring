package com.finalcit360.booksmanager.interfaces;

import com.finalcit360.booksmanager.model.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorRepository extends CrudRepository<Author, Integer> {
	List<Author> findById(int id);
}
