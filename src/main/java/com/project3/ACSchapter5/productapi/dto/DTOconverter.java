package com.project3.ACSchapter5.productapi.dto;

import com.project3.ACSchapter5.productapi.dto.ProductDTO;
import com.project3.ACSchapter5.productapi.dto.CategoryDTO;
import com.project3.ACSchapter5.productapi.model.Product;
import com.project3.ACSchapter5.productapi.model.Category;

public class DTOconverter {
    public static CategoryDTO convert(Category category){
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setNome(category.getNome());
        return categoryDTO;
    }
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
