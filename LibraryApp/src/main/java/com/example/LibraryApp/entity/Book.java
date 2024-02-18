package com.example.LibraryApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "publication_year", nullable = false)
    private int publicationYear;

    @Column(name = "stock", nullable = false)
    private int stock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_author_id", referencedColumnName = "author_id")
    private Author author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_publisher_id", referencedColumnName = "publisher_id")
    private Publisher publisher;

    @OneToMany(mappedBy = "book")
    private List<BookBorrowing> bookBorrowingList;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "book2cat",
            joinColumns = {@JoinColumn(name = "book2cat_book_id")}, inverseJoinColumns = {@JoinColumn(name = "book2cat_category_id")}
    )
    private List<Category> categoryList;

}
