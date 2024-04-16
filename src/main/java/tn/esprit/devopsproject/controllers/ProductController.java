package tn.esprit.devopsproject.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tn.esprit.devopsproject.entities.Product;
import tn.esprit.devopsproject.entities.ProductCategory;
import tn.esprit.devopsproject.services.Iservices.IProductService;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@Slf4j

public class ProductController {

    private final IProductService productService;

    @PostMapping("/product/{idStock}")
    Product addProduct(@RequestBody Product product,@PathVariable Long idStock){
        log.warn("Adding product with ID {} to stock {}", product.getIdProduct(), idStock);

        return productService.addProduct(product,idStock);
    }

    @GetMapping("/product/{id}")
    Product retrieveProduct(@PathVariable Long id){
        log.warn("Retrieving product with ID {}", id);

        return productService.retrieveProduct(id);
    }

    @GetMapping("/product")
    List<Product> retreiveAllProduct(){
        log.warn("Retrieving all products");
        return productService.retreiveAllProduct();
    }
    @GetMapping("/product/stock/{id}")
    List<Product> retreiveProductStock(@PathVariable Long id){
        log.warn("Retrieving products for stock with ID {}", id);

        return productService.retreiveProductStock(id);
    }

    @GetMapping("/productCategoy/{category}")
    List<Product> retrieveProductByCategory(@PathVariable ProductCategory category){
        log.warn("Retrieving products by category: {}", category);

        return productService.retrieveProductByCategory(category);
    }

    @DeleteMapping("/product/{id}")

    void deleteProduct(@PathVariable Long id){
        log.warn("Deleting product with ID {}", id);

        productService.deleteProduct(id);
    }
}
