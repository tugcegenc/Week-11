package com.example.LibraryApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    @Column(name = "country", length = 100, nullable = false)
    private String country;

    @OneToMany(mappedBy = "author")
    private List<Book> booksList;

}