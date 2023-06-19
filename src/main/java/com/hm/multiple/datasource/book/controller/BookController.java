package com.hm.multiple.datasource.book.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hm.multiple.datasource.book.service.BookService;
import com.hm.multiple.datasource.model.Book;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService bookService;

	@GetMapping("/getBookById/{bookId}")
	
	public Optional<Book> findBookById(@PathVariable int bookId) {
		return bookService.getBookById(bookId);
	}

	@GetMapping("/getAllBooks")
	public List<Book> allBooks() {
		return bookService.findAllBooks();
	}

	@PostMapping("/addBook")
	public Book addBook(@RequestBody Book book) {
		return bookService.addBook(book);
	}
	//feature-1
	@GetMapping("/getBook/{bookId}")
	
	public Optional<Book> findBook(@PathVariable int bookId) {
		return bookService.getBookById(bookId);
	}


	

}
