package br.com.joik.ecommerce.controllers;

import br.com.joik.ecommerce.models.Product;
import br.com.joik.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    private ResponseEntity<List<Product>> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> getWithId(@PathVariable("id") Long id) {
        return productService.getWithId(id);
    }

    @PostMapping
    private ResponseEntity<?> addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PutMapping("/{id}")
    private ResponseEntity<?> changeProduct(@PathVariable("id") Long id, @RequestBody Product updatedProduct) {
        return productService.changeProduct(id, updatedProduct);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteProduct(@PathVariable("id") Long id) {
        return productService.deleteProduct(id);
    }
}
