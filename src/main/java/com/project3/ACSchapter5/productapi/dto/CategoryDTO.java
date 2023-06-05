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

    public static CategoryDTO convert(Category category){
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setNome(category.getNome());
        return categoryDTO;
    }
}
