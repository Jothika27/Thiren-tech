package com.thirantech.librarymanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thirantech.librarymanagementsystem.service.BookDistributorService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private BookDistributorService bookOrderService;

    @PostMapping("/order")
    public void orderBook(@RequestParam Long id) {
        bookOrderService.orderBook(id);
    }
}