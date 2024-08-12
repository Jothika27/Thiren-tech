package com.thirantech.librarymanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thirantech.librarymanagementsystem.entity.Book;
import com.thirantech.librarymanagementsystem.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}
	
	public Book addBook(Book book) {
		return bookRepository.save(book);
	}
	public Optional<Book> getBookAvalilability(Long id) {
       Optional<Book> book = bookRepository.findById(id);
       return book;
    }
	
    public List<Book> searchBooksByTitle(String title) {
        return bookRepository.findByBookName(title);
    }

    public List<Book> searchBooksByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }
    
    public List<Book> searchBooksByGenre(String genre) {
        return bookRepository.findByAuthor(genre);
    }
    
    public void checkOutBook(Long id) {
        Optional<Book> bookOpt = bookRepository.findById(id);
        if (bookOpt.isPresent()) {
            Book book = bookOpt.get();
            if (book.isAvailable()) {
                book.setAvailable(false);
                bookRepository.save(book);
            }
        }
    }

    public void returnBook(Long id) {
        Optional<Book> bookOpt = bookRepository.findById(id);
        if (bookOpt.isPresent()) {
            Book book = bookOpt.get();
            if (!book.isAvailable()) {
                book.setAvailable(true);
                bookRepository.save(book);
            }
        }
    }

    public double calculateFine(int overdueDays, double fineRate) {
        return overdueDays * fineRate;
    }
  
}
