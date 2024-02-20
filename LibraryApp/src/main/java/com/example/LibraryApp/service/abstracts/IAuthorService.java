package com.example.LibraryApp.service.abstracts;

import com.example.LibraryApp.entity.Author;
import org.springframework.data.domain.Page;

public interface IAuthorService {
    Author save(Author author);
    Author get(long id);
    Page<Author> cursor(int page, int pageSize);
    Author update(Author author);
    boolean delete(long id);
}
