package tn.esprit.devops_project.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceImplTest {

    @Test
    void addProduct() {
        // Given
        ProductRepository productRepository = mock(ProductRepository.class);
        ProductServiceImpl productService = new ProductServiceImpl(productRepository);
        Product productToAdd = new Product("123", "Test Product", "Test Category", 10.0, 100);

        // When
        productService.addProduct(productToAdd);

        // Then
        verify(productRepository, times(1)).save(productToAdd);
    }

    @Test
    void retrieveProduct() {
        // Implement your test for retrieving a product
    }

    @Test
    void retreiveAllProduct() {
        // Implement your test for retrieving all products
    }

    @Test
    void retrieveProductByCategory() {
        // Implement your test for retrieving products by category
    }

    @Test
    void deleteProduct() {
        // Implement your test for deleting a product
    }

    @Test
    void retrieveProductStock() {
        // Implement your test for retrieving product stock
    }
}
