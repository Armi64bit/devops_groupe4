package tn.esprit.devops_project.dto;

import org.junit.jupiter.api.Test;
import tn.esprit.devops_project.entities.ProductCategory;

import static org.junit.jupiter.api.Assertions.*;

class ProductDTOTest {
    @Test
    void testSetters() {
        // Given
        ProductDTO productDTO = new ProductDTO();

        // When
        Long idProduct = 1L;
        String title = "Test Product";
        float price = 10.0f;
        int quantity = 5;
        ProductCategory category = ProductCategory.ELECTRONICS;

        productDTO.setIdProduct(idProduct);
        productDTO.setTitle(title);
        productDTO.setPrice(price);
        productDTO.setQuantity(quantity);
        productDTO.setCategory(category);

        // Then
        assertEquals(idProduct, productDTO.getIdProduct());
        assertEquals(title, productDTO.getTitle());
        assertEquals(price, productDTO.getPrice());
        assertEquals(quantity, productDTO.getQuantity());
        assertEquals(category, productDTO.getCategory());
    }
    @Test
    void testConstructorAndGetters() {
        // Given
        Long idProduct = 1L;
        String title = "Test Product";
        float price = 10.0f;
        int quantity = 5;
        ProductCategory category = ProductCategory.ELECTRONICS;

        // When
        ProductDTO productDTO = new ProductDTO(idProduct, title, price, quantity, category);

        // Then
        assertEquals(idProduct, productDTO.getIdProduct());
        assertEquals(title, productDTO.getTitle());
        assertEquals(price, productDTO.getPrice());
        assertEquals(quantity, productDTO.getQuantity());
        assertEquals(category, productDTO.getCategory());
    }

    // Additional test cases (optional)

    @Test
    void testNoArgsConstructor() {
        ProductDTO productDTO = new ProductDTO();

        // Assert default values (replace with actual defaults if different)
        assertNull(productDTO.getIdProduct());
        assertNull(productDTO.getTitle());
        assertEquals(0.0f, productDTO.getPrice());
        assertEquals(0, productDTO.getQuantity());
        assertNull(productDTO.getCategory());
    }

    @Test
    void testEquals() {
        ProductDTO product1 = new ProductDTO(1L, "Product 1", 12.50f, 10, ProductCategory.ELECTRONICS);
        ProductDTO product2 = new ProductDTO(1L, "Product 1", 12.50f, 10, ProductCategory.ELECTRONICS);
        ProductDTO product3 = new ProductDTO(2L, "Product 2", 9.99f, 5, ProductCategory.BOOKS);

        assertEquals(product1, product2);
        assertNotEquals(product1, product3);
        assertNotEquals(null,product1);
        assertNotEquals(product1, new Object());
    }
    @Test
    void testHashCode() {
        ProductDTO product1 = new ProductDTO(1L, "Product 1", 12.50f, 10, ProductCategory.ELECTRONICS);
        ProductDTO product2 = new ProductDTO(1L, "Product 1", 12.50f, 10, ProductCategory.ELECTRONICS);
        ProductDTO product3 = new ProductDTO(2L, "Product 2", 9.99f, 5, ProductCategory.BOOKS);

        assertEquals(product1.hashCode(), product2.hashCode());
        assertNotEquals(product1.hashCode(), product3.hashCode());
    }

    @Test
    void testToString() {
        // Given
        Long idProduct = 1L;
        String title = "Test Product";
        float price = 10.0f;
        int quantity = 5;
        ProductCategory category = ProductCategory.ELECTRONICS;

        ProductDTO productDTO = new ProductDTO(idProduct, title, price, quantity, category);

        // When
        String expectedToString = "ProductDTO{" +
                "idProduct=" + idProduct +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", category=" + category +
                '}';

        // Then
        assertEquals(expectedToString, productDTO.toString());
    }
}
