package com.reagan.springjpa;

import com.reagan.springjpa.model.Book;
import com.reagan.springjpa.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ComponentScan(basePackages = "com.reagan.springjpa")
@DataJpaTest
public class SpringSpliceTest {

   @Autowired
   BookRepository bookRepository;

   @Test
   void testRepository() {
      long countBefore = bookRepository.count();

      bookRepository.save(new Book("My aim", "1221", "Havard", null));

      long countAfter = bookRepository.count();

      assertThat(countBefore).isLessThan(countAfter);
   }
}
