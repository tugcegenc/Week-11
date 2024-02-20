package com.example.LibraryApp.service.concretes;

import com.example.LibraryApp.core.exception.NotFoundException;
import com.example.LibraryApp.core.utilies.Message;
import com.example.LibraryApp.entity.Category;
import com.example.LibraryApp.repository.CategoryRepository;
import com.example.LibraryApp.service.abstracts.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category save(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public Category get(long id) {

        return this.categoryRepository.findById(id).orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));
    }

    @Override
    public Page<Category> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.categoryRepository.findAll(pageable);
    }

    @Override
    public Category update(Category category) {
        this.get(category.getId());
        return this.categoryRepository.save(category);
    }

    @Override
    public boolean delete(long id) {
        Category category = this.get(id);
        this.categoryRepository.delete(category);
        return true;
    }

    @Override
    public List<Category> getAllById(List<Long> categoryId) {
        return this.categoryRepository.findAllById(categoryId);
    }
}
