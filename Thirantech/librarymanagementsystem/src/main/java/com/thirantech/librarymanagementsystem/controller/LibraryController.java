package com.thirantech.librarymanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thirantech.librarymanagementsystem.entity.Book;
import com.thirantech.librarymanagementsystem.service.BookService;

@RestController
@RequestMapping("/api/books")
public class LibraryController {

	@Autowired
	private BookService bookService;

	@PostMapping("/add")
	public Book addBook(@RequestBody Book book) {
		return bookService.addBook(book);
	}

	@GetMapping("/allBooks")
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}

	@GetMapping("/search")
	public List<Book> searchBooks(@RequestParam(required = false) String title,
			@RequestParam(required = false) String author) {
		if (title != null) {
			return bookService.searchBooksByTitle(title);
		} else if (author != null) {
			return bookService.searchBooksByAuthor(author);
		}
		return null;
	}

	@PutMapping("/checkout/{isbnId}")
	public void checkOutBook(@PathVariable Long isbnId) {
		bookService.checkOutBook(isbnId);
	}

	@PutMapping("/return/{isbnId}")
	public void returnBook(@PathVariable Long isbnId) {
		bookService.returnBook(isbnId);
	}

	@GetMapping("/fines")
	public double calculateFine(@RequestParam int overdueDays, @RequestParam double fineRate) {
		return bookService.calculateFine(overdueDays, fineRate);
	}
	
	
}
