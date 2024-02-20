package com.example.LibraryApp.service.concretes;

import com.example.LibraryApp.core.exception.NotFoundException;
import com.example.LibraryApp.core.utilies.Message;
import com.example.LibraryApp.entity.Book;
import com.example.LibraryApp.entity.Publisher;
import com.example.LibraryApp.repository.BookRepository;
import com.example.LibraryApp.repository.PublisherRepository;
import com.example.LibraryApp.service.abstracts.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IBookService {

    @Autowired
    private BookRepository bookRepository;
    @Override
    public Book save(Book book) {
        return this.bookRepository.save(book);
    }

    @Override
    public Book get(long id) {
        return this.bookRepository.findById(id).orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));
    }

    @Override
    public Page<Book> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.bookRepository.findAll(pageable);
    }

    @Override
    public Book update(Book book) {
        this.get(book.getId());
        return this.bookRepository.save(book);
    }

    @Override
    public boolean delete(long id) {
        Book book = this.get(id);
        this.bookRepository.delete(book);

        return true;
    }
}
