package tn.esprit.devopsproject.entities;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class StockTest {

    @Test
    void getIdStock() {
        // Given
        long id = 1;
        Stock stock = new Stock(id);

        // Then
        assertEquals(id, stock.getIdStock());
    }

    @Test
    void getTitle() {
        // Given
        String title = "Test Stock";
        Stock stock = new Stock();
        stock.setTitle(title);

        // Then
        assertEquals(title, stock.getTitle());
    }



    @Test
    void setIdStock() {
        // Given
        long id = 1;
        Stock stock = new Stock();

        // When
        stock.setIdStock(id);

        // Then
        assertEquals(id, stock.getIdStock());
    }

    @Test
    void setTitle() {
        // Given
        String title = "Test Stock";
        Stock stock = new Stock();

        // When
        stock.setTitle(title);

        // Then
        assertEquals(title, stock.getTitle());
    }

    @Test
    void getProducts() {
        // Given
        Product product1 = new Product();
        Product product2 = new Product();

        Set<Product> products = new HashSet<>();
        products.add(product1);
        products.add(product2);

        Stock stock = new Stock();
        stock.setProducts(products);

        // Then
        assertEquals(products, stock.getProducts());
    }

    @Test
    void setProducts() {
        // Given
        Product product1 = new Product();
        Product product2 = new Product();

        Set<Product> products = new HashSet<>();
        products.add(product1);
        products.add(product2);

        Stock stock = new Stock();

        // When
        stock.setProducts(products);

        // Then
        assertEquals(products, stock.getProducts());
    }
}
