package com.reagan.springjpa.repositories;

import com.reagan.springjpa.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
