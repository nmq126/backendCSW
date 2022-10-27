package com.example.examead.controller;

import com.example.examead.entity.Product;
import com.example.examead.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping()
    public ResponseEntity findAll() {
        List<Product> list = productService.findAll();
        if (list == null || list.size() == 0){
            return new ResponseEntity(list, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity findById(@PathVariable(name = "id") Long id) {
        return new ResponseEntity(productService.findById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.POST)
    public ResponseEntity sellProduct(@PathVariable(name = "id") Long id, @RequestParam Integer quantity) {
        return new ResponseEntity(productService.sellProduct(id, quantity), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity save(@Valid @RequestBody Product product) {
        return new ResponseEntity(productService.save(product), HttpStatus.CREATED);
    }
}
