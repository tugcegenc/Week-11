package com.example.LibraryApp.service.abstracts;

import com.example.LibraryApp.entity.Author;
import com.example.LibraryApp.entity.Category;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ICategoryService {
    Category save(Category category);
    Category get(long id);
    Page<Category> cursor(int page, int pageSize);
    Category update(Category category);
    boolean delete(long id);
    List<Category> getAllById(List<Long> categoryId);
}
