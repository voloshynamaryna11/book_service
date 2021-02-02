package com.example.book_service.service;

import com.example.book_service.model.Book;
import org.springframework.data.domain.Page;

public interface BookService {
    Book add(Book book);

    Page<Book> getAll(int pageNumber, int pageSize);

    Book get(Long id);
}
