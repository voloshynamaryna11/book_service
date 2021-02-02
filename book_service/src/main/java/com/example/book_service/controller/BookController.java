package com.example.book_service.controller;

import com.example.book_service.mapper.BookMapper;
import com.example.book_service.model.Book;
import com.example.book_service.model.dto.BookDto;
import com.example.book_service.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    private BookService bookService;
    private BookMapper bookMapper;

    public BookController(BookService bookService, BookMapper bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @GetMapping("/all/get/{pageNumber}")
    public String getAllBooks(Model model, @PathVariable(value = "pageNumber") int pageNumber) {
        int pageSize = 10;
        Page<Book> page = bookService.getAll(pageNumber, pageSize);
        List<Book> bookList = page.getContent();
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalElements", page.getTotalElements());
        model.addAttribute("books", bookList);
        return "allBooks";
    }

    @GetMapping("/inject")
    public String injectData() {
        System.out.println("vb");
        Book book1 = new Book("Sapiens. A Brief History of Humankind",
                "Yuval Noah Harari", 2015, 396);
        bookService.add(book1);
        Book book2 = new Book("Idiot", "Fyodor Dostoevsky",
                2017, 258);
        bookService.add(book2);
        Book book3 = new Book("Thus Spoke Zarathustra",
                "Friedrich Nietzsche", 2008, 350);
        bookService.add(book3);
        Book book4 = new Book("Three Comrades",
                "Erich Maria Remarque", 1937, 1500);
        bookService.add(book4);
        Book book5 = new Book("War and Peace",
                "Leo Tolstoy", 2003, 500);
        bookService.add(book5);
        Book book6 = new Book("Critique of Pure Reason",
                "Immanuel Kant", 1990, 290);
        bookService.add(book6);
        Book book7 = new Book("Divine Comedy",
                "Dante Alighieri", 2006, 750);
        bookService.add(book7);
        Book book8 = new Book("Alonso Quijano",
                "Miguel de Cervantes", 1984, 190);
        bookService.add(book8);
        Book book9 = new Book("Faust",
                "Johann Wolfgang von Goethe", 1991, 345);
        bookService.add(book9);
        Book book10 = new Book("Ward No. 6",
                "Anton Chekhov", 2019, 310);
        bookService.add(book10);
        Book book11 = new Book("Eneyida",
                "Ivan Kotlyarevsky", 2020, 400);
        bookService.add(book11);
        Book book12 = new Book("Introduction to psychoanalysis",
                "Sigmund Freud", 2002, 650);
        bookService.add(book12);
        return "redirect:/book/all/get/1";
    }

    @GetMapping("/add")
    public String showForm(Model model) {
        BookDto bookDto = new BookDto();
        model.addAttribute("book", bookDto);
        return "newBook";
    }

    @PostMapping("/save")
    public String saveData(@Valid @ModelAttribute("book") BookDto bookDto, BindingResult bindingResult, ModelMap modelMap, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("successMessage", "Введите корректные данные");
            modelMap.addAttribute("bindingResult", bindingResult);
            return "newBook";
        } else {
            bookService.add(bookMapper.mapFromBookDtoToBook(bookDto));
            return "redirect:/book/add?success";
        }
    }
}
