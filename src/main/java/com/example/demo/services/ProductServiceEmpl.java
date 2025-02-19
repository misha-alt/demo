package com.example.demo.services;

import com.example.demo.mapper.ProductMapper;
import com.example.demo.model.Product;
import com.example.demo.productDTO.ProductDto;
import com.example.demo.repository.ProductRepo;
import exeptions.ResurceNotFoundExeption;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class ProductServiceEmpl implements ProductService {

    private ProductRepo productRepo;
    @Override
    public Product createProduct(Product product) {


        Product savedProd = productRepo.save(product);


        return savedProd;
    }

    @Override
    public Product getProductById(Long id) {

        Product product =productRepo.findById(id).orElseThrow(()->
                new ResurceNotFoundExeption("Product is not exist with" + id));
        return product;
    }

    @Override
    public List<Product> getAllProduct() {
       List<Product> prodList= productRepo.findAll();

        return prodList;
    }

    @Override
    public Product updateProduct(Long id, Product product) {

if (productRepo.findById(id).isEmpty()){

    throw new ResurceNotFoundExeption("Product is not exist with id " + id);

}
        Product existingProduct = productRepo.findById(id).get();
        existingProduct.setTitle(product.getTitle());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setCity(product.getCity());


        Product updatedProd = productRepo.save(existingProduct);
        return updatedProd;
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepo.findById(id).orElseThrow(()->new ResurceNotFoundExeption("Product is not exist with" + id));


        productRepo.deleteById(id);
    }
}
