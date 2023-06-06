package com.project3.ACSchapter5.productapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import com.project3.ACSchapter5.productapi.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class ProductDTO {
    @NotBlank
    private String productIdentifier;
    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;
    @NotNull
    private Float preco;
    private CategoryDTO category;

    public static ProductDTO convert(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setNome(product.getNome());
        productDTO.setPreco(product.getPreco());
        productDTO.setDescricao(productDTO.getDescricao());
        productDTO.setProductIdentifier(productDTO.getProductIdentifier());
        if(product.getCategory() != null){
            productDTO.setCategory(DTOconverter.convert(product.getCategory()));
        }
        return productDTO;
    }
}
