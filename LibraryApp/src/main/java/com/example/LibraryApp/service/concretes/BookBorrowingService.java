package com.example.LibraryApp.service.concretes;

import com.example.LibraryApp.core.exception.NotFoundException;
import com.example.LibraryApp.core.utilies.Message;
import com.example.LibraryApp.entity.Author;
import com.example.LibraryApp.entity.BookBorrowing;
import com.example.LibraryApp.entity.Category;
import com.example.LibraryApp.repository.BookBorrowingRepository;
import com.example.LibraryApp.service.abstracts.IBookBorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookBorrowingService implements IBookBorrowingService {

    @Autowired
    private BookBorrowingRepository bookBorrowingRepository;

    @Override
    public BookBorrowing save(BookBorrowing bookBorrowing) {
        return this.bookBorrowingRepository.save(bookBorrowing);
    }

    @Override
    public BookBorrowing get(long id) {
        return this.bookBorrowingRepository.findById(id).orElseThrow(()-> new NotFoundException(Message.NOT_FOUND));
    }

    @Override
    public Page<BookBorrowing> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.bookBorrowingRepository.findAll(pageable);
    }

    @Override
    public BookBorrowing update(BookBorrowing bookBorrowing) {
        this.get(bookBorrowing.getId());
        return this.bookBorrowingRepository.save(bookBorrowing);    }

    @Override
    public boolean delete(long id) {
        BookBorrowing bookBorrowing = this.get(id);
        this.bookBorrowingRepository.delete(bookBorrowing);
        return true;
    }

    @Override
    public List<BookBorrowing> getAll() {
        return this.bookBorrowingRepository.findAll();
    }
}
