package com.project3.ACSchapter5.productapi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.project3.ACSchapter5.productapi.dto.DTOconverter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.project3.ACSchapter5.productapi.dto.ProductDTO;
import com.project3.ACSchapter5.productapi.model.Product;
import com.project3.ACSchapter5.productapi.repository.ProductRepository;

@Repository
@RequiredArgsConstructor
public class ProductService {
    private ProductRepository productRepository;
    public List<ProductDTO>getAll(){
        List<Product>products = productRepository.findAll();
        return products
                .stream()
                .map(DTOconverter::convert)
                .collect(Collectors.toList());
    }
    public List<ProductDTO>getProductByCategoryId(long categoryId){
        List<Product> products = productRepository.getProductByCategory(categoryId);
        return products
                .stream()
                .map(DTOconverter::convert)
                .collect(Collectors.toList());
    }
    public ProductDTO findByProductIdentifier(String productIdentifier){
        Product product = productRepository.findByProductIdentifier(productIdentifier);
        if(product != null){
            return DTOconverter.convert(product);
        }
        return null;
    }
    public ProductDTO save(ProductDTO productDTO){
        Product product = productRepository.save(Product.convert(productDTO));
        return DTOconverter.convert(product);
    }
    public ProductDTO delete(long productId){
        Optional<Product> product = productRepository.findById(productId);
        if(product.isPresent()){
            productRepository.delete(product.get());
        }
        return null;
    }
    public ProductDTO editProduct(long id, ProductDTO dto){
        Product product =  productRepository.findById(id).orElseThrow(()->new RuntimeException("Permission not found"));
        if(dto.getNome() != null || !dto.getNome().isEmpty()){
            product.setNome(dto.getNome());
        }
        if(dto.getPreco() != null){
            product.setPreco((dto.getPreco()));
        }
        return DTOconverter.convert(productRepository.save(product));
    }
    public Page<ProductDTO> getAllPage(Pageable page){
        Page<Product> users = productRepository.findAll(page);
        return users.map(DTOconverter::convert);
    }

}
