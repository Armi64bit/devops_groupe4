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
        assertNotEquals(product1, null);
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
        ProductDTO productDTO = new ProductDTO(4L, "Test Product", 19.99f, 25, ProductCategory.CLOTHING);
        String expected = "ProductDTO{idProduct=4, title='Test Product', price=19.99, quantity=25, category=CLOTHING}";
        assertEquals(expected, productDTO.toString());
    }
}
