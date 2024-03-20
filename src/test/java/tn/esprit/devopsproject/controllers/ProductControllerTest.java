package tn.esprit.devopsproject.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.devopsproject.entities.Product;
import tn.esprit.devopsproject.entities.ProductCategory;
import tn.esprit.devopsproject.services.Iservices.IProductService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ProductControllerTest {

    @Mock
    IProductService productService;

    @InjectMocks
    ProductController productController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void addProduct() {
        Product product = new Product();
        when(productService.addProduct(product, 1L)).thenReturn(product);

        Product result = productController.addProduct(product, 1L);

        assertEquals(product, result);
        verify(productService, times(1)).addProduct(product, 1L);
    }

    @Test
    void retrieveProduct() {
        Product product = new Product();
        when(productService.retrieveProduct(1L)).thenReturn(product);

        Product result = productController.retrieveProduct(1L);

        assertEquals(product, result);
        verify(productService, times(1)).retrieveProduct(1L);
    }

    @Test
    void retrieveAllProduct() {
        List<Product> productList = new ArrayList<>();
        when(productService.retreiveAllProduct()).thenReturn(productList);

        List<Product> result = productController.retreiveAllProduct();

        assertEquals(productList, result);
        verify(productService, times(1)).retreiveAllProduct();
    }

    @Test
    void retrieveProductStock() {
        List<Product> productList = new ArrayList<>();
        when(productService.retreiveProductStock(1L)).thenReturn(productList);

        List<Product> result = productController.retreiveProductStock(1L);

        assertEquals(productList, result);
        verify(productService, times(1)).retreiveProductStock(1L);
    }

    @Test
    void retrieveProductByCategory() {
        List<Product> productList = new ArrayList<>();
        when(productService.retrieveProductByCategory(ProductCategory.ELECTRONICS)).thenReturn(productList);

        List<Product> result = productController.retrieveProductByCategory(ProductCategory.ELECTRONICS);

        assertEquals(productList, result);
        verify(productService, times(1)).retrieveProductByCategory(ProductCategory.ELECTRONICS);
    }

    @Test
    void deleteProduct() {
        doNothing().when(productService).deleteProduct(1L);

        productController.deleteProduct(1L);

        verify(productService, times(1)).deleteProduct(1L);
    }
}
