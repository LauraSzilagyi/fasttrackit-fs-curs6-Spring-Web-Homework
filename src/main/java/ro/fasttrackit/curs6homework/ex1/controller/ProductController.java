package ro.fasttrackit.curs6homework.ex1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.curs6homework.ex1.model.ProductModel;
import ro.fasttrackit.curs6homework.ex1.service.ProductService;
import ro.fasttrackit.curs6homework.ex1.entity.Product;
import ro.fasttrackit.curs6homework.ex1.exception.ProductNotFoundException;

import java.util.List;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @GetMapping
    List<Product> getAll(@RequestParam(required = false) String category,
                         @RequestParam(required = false) Double maxPrice){
        return service.getAll(category, maxPrice);
    }

    @GetMapping("{id}")
    Product getProductById(@PathVariable int id){
        return service.getProduct(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with id %s doesn't exist".formatted(id)));
    }

    @PostMapping
    Product addProduct(@RequestBody ProductModel product){
        return service.addProduct(product);
    }

    @DeleteMapping("{id}")
    Product deleteProduct(@PathVariable int id){
        return service.deleteProduct(id)
                .orElse(null);
    }
}
