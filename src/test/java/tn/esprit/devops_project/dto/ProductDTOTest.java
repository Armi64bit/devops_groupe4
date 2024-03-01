package tn.esprit.devops_project.dto;

import org.junit.jupiter.api.Test;
import tn.esprit.devops_project.entities.ProductCategory;

import static org.junit.jupiter.api.Assertions.*;

public class ProductDTOTest {

    @Test
    void testParameterizedConstructorAndGetters() {
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
    }

    @Test
    void testSetters() {
        ProductDTO productDTO = new ProductDTO();

        Long id = 1L;
        String title = "Test Product";
        float price = 10.99f;
        int quantity = 5;
        ProductCategory category = ProductCategory.ELECTRONICS;

        productDTO.setIdProduct(id);
        productDTO.setTitle(title);
        productDTO.setPrice(price);
        productDTO.setQuantity(quantity);
        productDTO.setCategory(category);

        assertEquals(id, productDTO.getIdProduct());
        assertEquals(title, productDTO.getTitle());
        assertEquals(price, productDTO.getPrice());
        assertEquals(quantity, productDTO.getQuantity());
        assertEquals(category, productDTO.getCategory());
    }



    @Test
    void testDefaultConstructor() {
        ProductDTO productDTO = new ProductDTO();

        // Verify that the default constructor initializes fields to null or default values
        assertEquals(null, productDTO.getIdProduct());
        assertEquals(null, productDTO.getTitle());
        assertEquals(0.0f, productDTO.getPrice());
        assertEquals(0, productDTO.getQuantity());
        assertEquals(null, productDTO.getCategory());
    }
    @Test
    void testToString() {
        Long id = 1L;
        String title = "Test Product";
        float price = 10.99f;
        int quantity = 5;
        ProductCategory category = ProductCategory.ELECTRONICS;

        ProductDTO productDTO = new ProductDTO(id, title, price, quantity, category);

        String expectedString = "ProductDTO{idProduct=1, title='Test Product', price=10.99, quantity=5, category=ELECTRONICS}";
        assertEquals(expectedString, productDTO.toString());
    }

    @Test
    void testEqualsAndHashCode() {
        Long id1 = 1L;
        String title1 = "Test Product";
        float price1 = 10.99f;
        int quantity1 = 5;
        ProductCategory category1 = ProductCategory.ELECTRONICS;

        Long id2 = 1L;
        String title2 = "Test Product";
        float price2 = 10.99f;
        int quantity2 = 5;
        ProductCategory category2 = ProductCategory.ELECTRONICS;

        ProductDTO productDTO1 = new ProductDTO(id1, title1, price1, quantity1, category1);
        ProductDTO productDTO2 = new ProductDTO(id2, title2, price2, quantity2, category2);

        // Test equality
        assertTrue(productDTO1.equals(productDTO2));
        assertTrue(productDTO2.equals(productDTO1));

        // Test hash code equality
        assertEquals(productDTO1.hashCode(), productDTO2.hashCode());

        // Change one attribute and verify inequality
        productDTO2.setPrice(11.99f);
        assertFalse(productDTO1.equals(productDTO2));
        assertFalse(productDTO2.equals(productDTO1));
    }
}
