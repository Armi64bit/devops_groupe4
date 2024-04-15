package tn.esprit.devopsproject.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {

    Product product;

    @BeforeEach
    void setUp() {
        product = new Product();
    }

    @Test
    void testIdProduct() {
        product.setIdProduct(1L);
        assertEquals(1L, product.getIdProduct());
    }

    @Test
    void testTitle() {
        product.setTitle("Test Product");
        assertEquals("Test Product", product.getTitle());
    }

    @Test
    void testPrice() {
        product.setPrice(10.5f);
        assertEquals(10.5f, product.getPrice());
    }

    @Test
    void testQuantity() {
        product.setQuantity(5);
        assertEquals(5, product.getQuantity());
    }

    @Test
    void testCategory() {
        product.setCategory(ProductCategory.ELECTRONICS);
        assertEquals(ProductCategory.ELECTRONICS, product.getCategory());
    }

    @Test
    void testStock() {
        Stock stock = new Stock();
        product.setStock(stock);
        assertEquals(stock, product.getStock());
    }
}
