package tn.esprit.devops_project.dto;

import org.junit.jupiter.api.Test;
import tn.esprit.devops_project.entities.ProductCategory;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
