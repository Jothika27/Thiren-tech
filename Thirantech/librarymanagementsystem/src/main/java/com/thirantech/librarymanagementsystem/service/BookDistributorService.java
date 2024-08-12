package com.thirantech.librarymanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.thirantech.librarymanagementsystem.entity.Book;

@Service
public class BookDistributorService {

    private static final String API_URL = "http://localhost:8080/api/books";
    @Autowired
    private RestTemplate restTemplate;

    public Book orderBook(Long id) {
        ResponseEntity<Book> response = restTemplate.postForEntity(API_URL + "/checkout", id, Book.class);
        return response.getBody();
    }
}
