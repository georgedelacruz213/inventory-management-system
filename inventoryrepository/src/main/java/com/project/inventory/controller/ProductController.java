package com.project.inventory.controller;

import com.project.inventory.dto.ProductDto;
import com.project.inventory.model.response.ProductResponse;
import com.project.inventory.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/inventory/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping(path = "/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable String id){
        ProductDto productDto = productService.getProductById(id);

       ProductResponse productResponse = modelMapper.map(productDto,ProductResponse.class);

        return ResponseEntity.ok(productResponse);
    }

    @GetMapping(path = "/{name}")
    public ResponseEntity<ProductResponse> getProductByname(@PathVariable String name){
        ProductDto productDto = productService.getProductByName(name);

        ProductResponse productResponse = modelMapper.map(productDto,ProductResponse.class);

        return ResponseEntity.ok(productResponse);
    }

    @PostMapping("/save")
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductDto productDto){
        ProductDto createdProduct = productService.createProduct(productDto);

        ProductResponse productResponse = modelMapper.map(createdProduct,ProductResponse.class);

        return ResponseEntity.ok(productResponse);
    }

    @PutMapping("/update")
    public ResponseEntity<ProductResponse> updateProduct(@RequestBody ProductDto productRequestModel){
        ProductDto productDto = modelMapper.map(productRequestModel,ProductDto.class);

        ProductDto updatedProduct = productService.updateProduct(productDto);

        ProductResponse productResponse = modelMapper.map(updatedProduct,ProductResponse.class);

        return ResponseEntity.ok(productResponse);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteProduct(@PathVariable String id){
        productService.deleteProduct(id);

        return id;
    }
}
