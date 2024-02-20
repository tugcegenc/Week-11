package com.example.LibraryApp.service.abstracts;

import com.example.LibraryApp.entity.Author;
import com.example.LibraryApp.entity.BookBorrowing;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IBookBorrowingService {
    BookBorrowing save(BookBorrowing bookBorrowing);
    BookBorrowing get(long id);
    Page<BookBorrowing> cursor(int page, int pageSize);
    BookBorrowing update(BookBorrowing bookBorrowing);
    boolean delete(long id);
    List<BookBorrowing> getAll();
}
