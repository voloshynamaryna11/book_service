package com.example.book_service.service.impl;

import com.example.book_service.model.Book;
import com.example.book_service.repository.BookRepository;
import com.example.book_service.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book add(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Page<Book> getAll(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        return bookRepository.findAll(pageable);
    }

    @Override
    public Book get(Long id) {
        return bookRepository.findById(id).get();
    }
}
