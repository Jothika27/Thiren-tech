package com.thirantech.librarymanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String bookName;
	    private String author;
	    private String genre;
	    private boolean isAvailable = true;
	    
		public Book() {
			super();
		}
		public Book(Long id, String bookName, String author, String genre, boolean isAvailable) {
			super();
			this.id = id;
			this.bookName = bookName;
			this.author = author;
			this.genre = genre;
			this.isAvailable = isAvailable;
		}
		public Book(Long id, String bookName, String author, String genre) {
			this.id = id;
			this.bookName = bookName;
			this.author = author;
			this.genre = genre;
		}
		@JsonProperty("id")
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getBookName() {
			return bookName;
		}
		public void setBookName(String bookName) {
			this.bookName = bookName;
		}
		 @JsonProperty("author")
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		 @JsonProperty("genre")
		public String getGenre() {
			return genre;
		}
		public void setGenre(String genre) {
			this.genre = genre;
		}
		
		public boolean isAvailable() {
			return isAvailable;
		}
		public void setAvailable(boolean isAvailable) {
			this.isAvailable = isAvailable;
		}
		@Override
		public String toString() {
			return "Book [id=" + id + ", bookName=" + bookName + ", author=" + author
					+ ", genre=" + genre + ", isAvailable=" + isAvailable + "]";
		}
	    
}
