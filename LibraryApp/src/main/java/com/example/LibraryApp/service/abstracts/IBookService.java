package com.example.LibraryApp.service.abstracts;

import com.example.LibraryApp.entity.Author;
import com.example.LibraryApp.entity.Book;
import org.springframework.data.domain.Page;

public interface IBookService {
    Book save(Book book);
    Book get(long id);
    Page<Book> cursor(int page, int pageSize);
    Book update(Book book);
    boolean delete(long id);
}
