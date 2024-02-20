package com.example.LibraryApp.dto.request.category;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CategorySaveRequest {

    private String name;
    private String description;

}
