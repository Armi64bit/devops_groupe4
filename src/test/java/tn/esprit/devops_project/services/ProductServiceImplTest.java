package tn.esprit.devops_project.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.devops_project.entities.Product;
import tn.esprit.devops_project.entities.ProductCategory;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.repositories.ProductRepository;
import tn.esprit.devops_project.repositories.StockRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
class ProductServiceImplTest {

    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private StockRepository stockRepository;

    // Test data
    private final Long id = 1L;
    private final String title = "Test product";
    private final float price = 10.0f;
    private final int quantity = 5;
    private final ProductCategory category = ProductCategory.ELECTRONICS;
    private final Long stockId = 2L;

    @Test
    void addProduct() {
        // Create mock product and stock
        Product product = new Product();
        product.setTitle(title);
        product.setPrice(price);
        product.setQuantity(quantity);
        product.setCategory(category);

        Stock mockStock = new Stock();

        // Stubbing repository methods
        when(stockRepository.findById(stockId)).thenReturn(Optional.of(mockStock));
        when(productRepository.save(product)).thenReturn(product);

        // Call the service method
        Product savedProduct = productService.addProduct(product, stockId);

        // Verify results
        assertNotNull(savedProduct);
        assertEquals(title, savedProduct.getTitle());
        assertEquals(price, savedProduct.getPrice());
        assertEquals(quantity, savedProduct.getQuantity());
        assertEquals(category, savedProduct.getCategory());
        verify(stockRepository, times(1)).findById(stockId);
        verify(productRepository, times(1)).save(product);
    }

    @Test
    void retrieveProduct() {
        // Create mock product
        Product mockProduct = new Product();
        mockProduct.setIdProduct(id);

        // Stubbing repository methods
        when(productRepository.findById(id)).thenReturn(Optional.of(mockProduct));

        // Call the service method
        Product retrievedProduct = productService.retrieveProduct(id);

        // Verify results
        assertNotNull(retrievedProduct);
        assertEquals(id, retrievedProduct.getIdProduct());
        verify(productRepository, times(1)).findById(id);
    }

    @Test
    void retreiveAllProduct() {
        // Create mock products
        List<Product> mockProducts = new ArrayList<>();
        Product mockProduct1 = new Product();
        Product mockProduct2 = new Product();
        mockProducts.add(mockProduct1);
        mockProducts.add(mockProduct2);

        // Stubbing repository methods
        when(productRepository.findAll()).thenReturn(mockProducts);

        // Call the service method
        List<Product> retrievedProducts = productService.retreiveAllProduct();

        // Verify results
        assertNotNull(retrievedProducts);
        assertEquals(2, retrievedProducts.size());
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void retrieveProductByCategory() {
        // Create mock products
        List<Product> mockProducts = new ArrayList<>();
        Product mockProduct1 = new Product();
        Product mockProduct2 = new Product();
        mockProducts.add(mockProduct1);
        mockProducts.add(mockProduct2);

        // Stubbing repository methods
        when(productRepository.findByCategory(category)).thenReturn(mockProducts);

        // Call the service method
        List<Product> retrievedProducts = productService.retrieveProductByCategory(category);

        // Verify results
        assertNotNull(retrievedProducts);
        assertEquals(2, retrievedProducts.size());
        verify(productRepository, times(1)).findByCategory(category);
    }

    @Test
    void deleteProduct() {
        // Call the service method
        productService.deleteProduct(id);

        // Verify results
        verify(productRepository, times(1)).deleteById(id);
    }

    @Test
    void retreiveProductStock() {
        // Create mock products
        List<Product> mockProducts = new ArrayList<>();
        Product mockProduct1 = new Product();
        Product mockProduct2 = new Product();
        mockProducts.add(mockProduct1);
        mockProducts.add(mockProduct2);

        // Stubbing repository methods
        when(productRepository.findByStockIdStock(stockId)).thenReturn(mockProducts);

        // Call the service method
        List<Product> retrievedProducts = productService.retreiveProductStock(stockId);

        // Verify results
        assertNotNull(retrievedProducts);
        assertEquals(2, retrievedProducts.size());
        verify(productRepository, times(1)).findByStockIdStock(stockId);
    }
}
