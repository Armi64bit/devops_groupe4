package tn.esprit.devopsproject.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.devopsproject.entities.Product;
import tn.esprit.devopsproject.entities.ProductCategory;
import tn.esprit.devopsproject.services.Iservices.IProductService;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class ProductController {

    private final IProductService productService;

    @PostMapping("/product/{idStock}")
    Product addProduct(@RequestBody Product product,@PathVariable Long idStock){
        return productService.addProduct(product,idStock);
    }

    @GetMapping("/product/{id}")
    Product retrieveProduct(@PathVariable Long id){
        return productService.retrieveProduct(id);
    }

    @GetMapping("/product")
    List<Product> retreiveAllProduct(){
        return productService.retreiveAllProduct();
    }
    @GetMapping("/product/stock/{id}")
    List<Product> retreiveProductStock(@PathVariable Long id){
        return productService.retreiveProductStock(id);
    }

    @GetMapping("/productCategoy/{category}")
    List<Product> retrieveProductByCategory(@PathVariable ProductCategory category){
        return productService.retrieveProductByCategory(category);
    }

    @DeleteMapping("/product/{id}")
    void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }
}
