package tn.esprit.devops_project.dto;

import org.junit.jupiter.api.Test;
import tn.esprit.devops_project.entities.ProductCategory;

import static org.junit.jupiter.api.Assertions.*;

class ProductDTOTest {

    @Test
    void testConstructorAndGettersAndSetters() {
        Long id = 1L;
        String title = "Test Product";
        float price = 10.99f;
        int quantity = 5;
        ProductCategory category = ProductCategory.ELECTRONICS;

        ProductDTO productDTO = new ProductDTO(id, title, price, quantity, category);

        assertEquals(id, productDTO.getIdProduct());
        assertEquals(title, productDTO.getTitle());
        assertEquals(price, productDTO.getPrice());
        assertEquals(quantity, productDTO.getQuantity());
        assertEquals(category, productDTO.getCategory());

        productDTO.setIdProduct(2L);
        productDTO.setTitle("Updated Title");
        productDTO.setPrice(12.99f);
        productDTO.setQuantity(10);
        productDTO.setCategory(ProductCategory.BOOKS);

        assertEquals(2L, productDTO.getIdProduct());
        assertEquals("Updated Title", productDTO.getTitle());
        assertEquals(12.99f, productDTO.getPrice());
        assertEquals(10, productDTO.getQuantity());
        assertEquals(ProductCategory.BOOKS, productDTO.getCategory());
    }

    // Additional test cases (optional)

    @Test
    void testNoArgsConstructor() {
        // Test default values or behavior of the no-argument constructor
    }

    @Test
    void testEquals() {
        // Test object equality with different scenarios
    }

    @Test
    void testHashCode() {
        // Test hashCode method behavior
    }

    @Test
    void testToString() {
        // Test the output of the toString() method
    }
}
