package com.example.LibraryApp.dto.response.book;

import com.example.LibraryApp.entity.Author;
import com.example.LibraryApp.entity.BookBorrowing;
import com.example.LibraryApp.entity.Category;
import com.example.LibraryApp.entity.Publisher;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {

    private long id;
    private String name;
    private int publicationYear;
    private int stock;
    private long authorId;
    private long publisherId;
    private List<BookBorrowing> bookBorrowingList;
    private List<Category> categoryList;

}
