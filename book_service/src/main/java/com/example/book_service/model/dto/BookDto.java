package com.example.book_service.model.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class BookDto {
    @Size(min = 2, max = 100, message = "Название книги должно содержать не менее 2 и не более 100 символов")
    private String name;
    @Size(min = 2, max = 100, message = "Имя автора должно содержать не менее 2 и не более 100 символов")
    private String author;
    @Min(value = 1000, message = "Год должен быть не меньше 1000 г.")
    @Max(value = 2021, message = "Год должен быть не больше текущего (2021 г.)")
    private int year;
    @Min(value = 50, message = "Цена должна быть не меньше 50 грн")
    @Max(value = 10000, message = "Цена должна быть не больше 10 000 грн")
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
