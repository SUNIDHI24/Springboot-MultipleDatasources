package com.hm.multiple.datasource.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hm.multiple.datasource.model.Book;

public interface BookRepository  extends JpaRepository<Book, Integer> {

}
