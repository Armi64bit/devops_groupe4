package tn.esprit.devops_project.dto;

import org.junit.jupiter.api.Test;
import tn.esprit.devops_project.entities.ProductCategory;

import static org.junit.jupiter.api.Assertions.*;

class ProductDTOTest {

    @Test
    void getIdProduct() {
        ProductDTO productDTO = new ProductDTO();
        assertNull(productDTO.getIdProduct());
    }

    @Test
    void setIdProduct() {
        ProductDTO productDTO = new ProductDTO();
        Long idProduct = 1L;
        productDTO.setIdProduct(idProduct);
        assertEquals(idProduct, productDTO.getIdProduct());
    }

    @Test
    void getTitle() {
        ProductDTO productDTO = new ProductDTO();
        assertNull(productDTO.getTitle());
    }

    @Test
    void setTitle() {
        ProductDTO productDTO = new ProductDTO();
        String title = "Test Title";
        productDTO.setTitle(title);
        assertEquals(title, productDTO.getTitle());
    }

    @Test
    void getPrice() {
        ProductDTO productDTO = new ProductDTO();
        assertEquals(0.0f, productDTO.getPrice());
    }

    @Test
    void setPrice() {
        ProductDTO productDTO = new ProductDTO();
        float price = 10.5f;
        productDTO.setPrice(price);
        assertEquals(price, productDTO.getPrice());
    }

    @Test
    void getQuantity() {
        ProductDTO productDTO = new ProductDTO();
        assertEquals(0, productDTO.getQuantity());
    }

    @Test
    void setQuantity() {
        ProductDTO productDTO = new ProductDTO();
        int quantity = 5;
        productDTO.setQuantity(quantity);
        assertEquals(quantity, productDTO.getQuantity());
    }

    @Test
    void getCategory() {
        ProductDTO productDTO = new ProductDTO();
        assertNull(productDTO.getCategory());
    }

    @Test
    void setCategory() {
        ProductDTO productDTO = new ProductDTO();
        ProductCategory category = ProductCategory.ELECTRONICS;
        productDTO.setCategory(category);
        assertEquals(category, productDTO.getCategory());
    }

    @Test
    void testToString() {
        Long id = 1L;
        String title = "Test Product";
        float price = 10.5f;
        int quantity = 5;
        ProductCategory category = ProductCategory.ELECTRONICS;

        ProductDTO productDTO = new ProductDTO(id, title, price, quantity, category);
        String expectedToString = "ProductDTO{idProduct=1, title='Test Product', price=10.5, quantity=5, category=ELECTRONICS}";

        assertEquals(expectedToString, productDTO.toString());
    }

    @Test
    void testEquals() {
        // Create two ProductDTO objects with the same attributes
        ProductDTO productDTO1 = new ProductDTO(1L, "Test Product", 10.5f, 5, ProductCategory.ELECTRONICS);
        ProductDTO productDTO2 = new ProductDTO(1L, "Test Product", 10.5f, 5, ProductCategory.ELECTRONICS);

        // Create a ProductDTO object with different attributes
        ProductDTO productDTO3 = new ProductDTO(2L, "Test Product 2", 20.0f, 10, ProductCategory.CLOTHING);

        // Test for equality between productDTO1 and productDTO2
        assertEquals(productDTO1, productDTO2);

        // Test for inequality between productDTO1 and productDTO3
        assertNotEquals(productDTO1, productDTO3);

        // Test for null comparison
        assertNotEquals(null, productDTO1);

        // Test for comparison with a different class
        assertNotEquals("Test", productDTO1);

        // Test for comparison with different title
        ProductDTO productDTO4 = new ProductDTO(1L, "Test Product", 10.5f, 5, ProductCategory.ELECTRONICS);
        ProductDTO productDTO5 = new ProductDTO(1L, "Different Product", 10.5f, 5, ProductCategory.ELECTRONICS);
        assertFalse(productDTO4.equals(productDTO5));

        // Test for comparison with different category
        ProductDTO productDTO6 = new ProductDTO(1L, "Test Product", 10.5f, 5, ProductCategory.ELECTRONICS);
        ProductDTO productDTO7 = new ProductDTO(1L, "Test Product", 10.5f, 5, ProductCategory.CLOTHING);
        assertFalse(productDTO6.equals(productDTO7));
    }


    @Test
    void testHashCode() {
        ProductDTO productDTO1 = new ProductDTO(1L, "Test Product", 10.5f, 5, ProductCategory.ELECTRONICS);
        ProductDTO productDTO2 = new ProductDTO(1L, "Test Product", 10.5f, 5, ProductCategory.ELECTRONICS);
        ProductDTO productDTO3 = new ProductDTO(2L, "Test Product 2", 20.0f, 10, ProductCategory.CLOTHING);

        assertEquals(productDTO1.hashCode(), productDTO2.hashCode());
        assertNotEquals(productDTO1.hashCode(), productDTO3.hashCode());
    }
}
