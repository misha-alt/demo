package com.example.demo.controllers;

import com.example.demo.config.UserDetailsService;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.Product;
import com.example.demo.model.RolesOfUsers;
import com.example.demo.model.User;
import com.example.demo.productDTO.ProductDto;
import com.example.demo.productDTO.RolesOfUsersDto;
import com.example.demo.productDTO.UserDto;
import com.example.demo.services.ProductService;
import com.example.demo.services.RolesOfUsersService;
import com.example.demo.services.UserService;
import com.example.demo.services.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//@CrossOrigin("*")
@AllArgsConstructor
@RestController
@Transactional
@RequestMapping("/test")
public class TestController {

private ProductService productService;
@Autowired
private UserServiceImpl userService;


@Autowired
private RolesOfUsersService rolesOfUsersService;

@PostMapping
public ResponseEntity<Product> createProduct(@RequestBody Product product, Principal principal){

    User user =userService.getUserByLogin(principal.getName());
    System.out.println(principal.getName());

    //product.setUser(user);

    Product saveProd = productService.createProduct(product);

    return  new ResponseEntity<>(saveProd, HttpStatus.CREATED);
}


    //UserDto userDto =userService.getUserByLogin(principal.getName());
//   System.out.println(principal.getName());
//    userDto.getAuthority().forEach(role-> System.out.println(role.getRolename()));
//
//    Set<ProductDto> prodSet = new HashSet<>();
//    prodSet.add(productDto);
//    userDto.setProductDtos(prodSet);
//
//    productDto.setUserDto(userDto);
//    UserDto userDto1 = userService.updateUser(userDto);
//======================================================
//    userDto.getAuthority().forEach(role-> System.out.println(role.getRolename()));
//
//    List <RolesOfUsersDto> setRol = new ArrayList<>(userDto.getAuthority());
//
//    List <RolesOfUsers> listRolFromDB = rolesOfUsersService.findRoleNam(setRol.get(0).getRolename());
//
//    listRolFromDB.get(0).getUserSet().forEach(useFromrolSet-> System.out.println(useFromrolSet.getLogin()));

@GetMapping("{id}")
public ResponseEntity<Product> getProductById(@PathVariable("id") Long id){

    Product getProd = productService.getProductById(id);
    return  ResponseEntity.ok(getProd);
}
@GetMapping()
public ResponseEntity<List<Product>> getAllProd(){
List<Product> listProd = productService.getAllProduct();
    return ResponseEntity.ok(listProd);
}




//@GetMapping()
//public List<ProductDto>  tests(){
//    List<ProductDto> listProd = productService.getAllProduct();
//    return listProd;
//}


//@GetMapping()
//public String testreq(){
////    List<ProductDto> listProd = productService.getAllProduct();
//    //Product product  = new Product(1L,"Titile", "Description",12, "City");
//
//    /*for(ProductDto MyProd:listProd){
//        return  MyProd.getDescription();
//    }*/
//    UserDto userDto = userService.getUserById(1L);
//
//    StringBuilder result = new StringBuilder(userDto.getLogin()+", ");
//
//
//for (RolesOfUsers roles:userDto.getAuthority()){
//
//    result.append(roles.getRoleName()).append(",");
//}
//
//return  result.toString();
//}

@PutMapping("{id}")
public ResponseEntity<Product> updateProductDTO(@PathVariable("id") Long id, @RequestBody Product product){

    Product productUpdate = productService.updateProduct(id, product);
    return ResponseEntity.ok(productUpdate);
}
@DeleteMapping("{id}")
public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id){
    productService.deleteProduct(id);

    return ResponseEntity.ok("Product deleted successfully");
}



}
