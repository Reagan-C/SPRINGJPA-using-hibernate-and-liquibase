package com.reagan.springjpa.bootstrap;

import lombok.extern.slf4j.Slf4j;
import com.reagan.springjpa.model.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import com.reagan.springjpa.repositories.BookRepository;

@Profile({"local", "default"})
@Slf4j
@Component
public class DataInitialiser implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DataInitialiser(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        bookRepository.deleteAll();

        Book book1 = new Book("To be a man", "1122", "Uni press", null);
        Book savedBook = bookRepository.save(book1);

        Book book2 = new Book("Women", "11233", "Uni press", null);
        Book savedBook2 = bookRepository.save(book2);

        bookRepository.findAll().forEach(book -> {
            log.info("Book id: " + book.getId());
            log.info("Book title: " + book.getTitle());
        });
    }
}
