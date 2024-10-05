package com.example.demo.controllers;

import com.example.demo.mapper.ProductMapper;
import com.example.demo.model.Product;
import com.example.demo.model.RolesOfUsers;
import com.example.demo.model.User;
import com.example.demo.productDTO.ProductDto;
import com.example.demo.productDTO.UserDto;
import com.example.demo.services.ProductService;
import com.example.demo.services.UserService;
import com.example.demo.services.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/test")
public class TestController {

private ProductService productService;
@Autowired
private UserServiceImpl userService;

@PostMapping
public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
    ProductDto saveProd = productService.createProduct(productDto);
    return  new ResponseEntity<>(saveProd, HttpStatus.CREATED);
}

@GetMapping("{id}")
public ResponseEntity<ProductDto> getProductById(@PathVariable("id") Long id){
    ProductDto getProd = productService.getProductById(id);
    return  ResponseEntity.ok(getProd);
}
//@GetMapping()
//public ResponseEntity<List<ProductDto>> getAllProd(){
//List<ProductDto> listProd = productService.getAllProduct();
//    return ResponseEntity.ok(listProd);
//}
@GetMapping()
public String testreq(){
//    List<ProductDto> listProd = productService.getAllProduct();
    //Product product  = new Product(1L,"Titile", "Description",12, "City");

    /*for(ProductDto MyProd:listProd){
        return  MyProd.getDescription();
    }*/
    UserDto userDto = userService.getUserById(1L);

    StringBuilder result = new StringBuilder(userDto.getLogin()+", ");


for (RolesOfUsers roles:userDto.getAuthority()){

    result.append(roles.getRole_name()).append(",");
}

return  result.toString();
}

@PutMapping("{id}")
public ResponseEntity<ProductDto> updateProductDTO(@PathVariable("id") Long id, @RequestBody ProductDto productDto){

    ProductDto productDtoUpdate = productService.updateProduct(id, productDto);
    return ResponseEntity.ok(productDtoUpdate);
}
@DeleteMapping("{id}")
public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id){
    productService.deleteProduct(id);

    return ResponseEntity.ok("Product deleted successfully");
}

}
