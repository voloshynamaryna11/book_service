package com.example.book_service.mapper;

import com.example.book_service.model.Book;
import com.example.book_service.model.dto.BookDto;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    public Book mapFromBookDtoToBook(BookDto bookDto) {
        Book book = new Book(bookDto.getName(),
                bookDto.getAuthor(), bookDto.getYear(),
                bookDto.getPrice());
        return book;
    }
}
