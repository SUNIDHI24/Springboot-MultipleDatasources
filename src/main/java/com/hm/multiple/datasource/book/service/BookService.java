package com.hm.multiple.datasource.book.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.hm.multiple.datasource.book.repository.BookRepository;
import com.hm.multiple.datasource.model.Book;

import jakarta.transaction.Transactional;

@Service
@EnableTransactionManagement
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;

	public Optional<Book> getBookById(int id) {
		return bookRepository.findById(id);
	}

	public List<Book> findAllBooks() {
		return bookRepository.findAll();
	}

	@Transactional
	public Book addBook(Book book) {
		return bookRepository.save(book);
	}

}
