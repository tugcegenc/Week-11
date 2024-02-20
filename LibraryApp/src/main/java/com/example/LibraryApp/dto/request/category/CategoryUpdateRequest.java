package com.example.LibraryApp.dto.request.category;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryUpdateRequest {
    @Positive(message = "ID Değeri pozitif olmalıdır.")
    private int id;
    @NotNull(message = "Kategori ismi boş veya null olamaz")
    private String name;
    private String description;
}
