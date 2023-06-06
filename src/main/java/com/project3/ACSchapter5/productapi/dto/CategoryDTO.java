package com.project3.ACSchapter5.productapi.dto;

import jakarta.validation.constraints.NotNull;

import com.project3.ACSchapter5.productapi.model.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
public class CategoryDTO {
    @NotNull
    private Long id;
    private String nome;
}
