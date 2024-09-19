package com.example.demo.services;

import com.example.demo.mapper.ProductMapper;
import com.example.demo.model.Product;
import com.example.demo.productDTO.ProductDto;
import com.example.demo.repository.ProductRepo;
import exeptions.ResurceNotFoundExeption;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceEmpl implements ProductService {

    private ProductRepo productRepo;
    @Override
    public ProductDto createProduct(ProductDto productDto) {

        Product product = ProductMapper.mappToProd(productDto);
        Product savedProd = productRepo.save(product);


        return ProductMapper.mappToProdDTO(savedProd);
    }

    @Override
    public ProductDto getProductById(Long id) {

        Product product =productRepo.findById(id).orElseThrow(()->
                new ResurceNotFoundExeption("Product is not exist with" + id));
        return ProductMapper.mappToProdDTO(product);
    }

    @Override
    public List<ProductDto> getAllProduct() {
       List<Product> prodList= productRepo.findAll();

        return prodList.stream().map((product) -> ProductMapper.mappToProdDTO(product)).collect(Collectors.toList());
    }

    @Override
    public ProductDto updateProduct(Long id, ProductDto productDto) {

       Product product = productRepo.findById(id).orElseThrow(()-> new ResurceNotFoundExeption("Product is not exist with" + id));



       product.setTitle(productDto.getTitle());
        product.setDescription(productDto.getDescription());
       product.setPrice(productDto.getPrice());
        product.setCity(productDto.getCity());

      Product updatedProd = productRepo.save(product);




        return ProductMapper.mappToProdDTO(updatedProd);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepo.findById(id).orElseThrow(()->new ResurceNotFoundExeption("Product is not exist with" + id));


        productRepo.deleteById(id);
    }
}
