package tn.esprit.devops_project.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.devops_project.entities.Product;
import tn.esprit.devops_project.entities.ProductCategory;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.repositories.ProductRepository;
import tn.esprit.devops_project.repositories.StockRepository;
import tn.esprit.devops_project.services.ProductServiceImpl;
import tn.esprit.devops_project.services.StockServiceImpl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private StockRepository stockRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    public void testAddProduct() {
        // Given
        Product product = new Product();
        product.setIdProduct(1L);
        when(stockRepository.findById(any())).thenReturn(Optional.of(new Stock()));
        when(productRepository.save(any())).thenReturn(product);

        // When
        Product savedProduct = productService.addProduct(new Product(), 1L);

        // Then
        assertEquals(1L, savedProduct.getIdProduct());
        verify(stockRepository, times(1)).findById(any());
        verify(productRepository, times(1)).save(any());
    }

    // Ajoutez ici vos autres méthodes de test pour ProductService en utilisant des comportements simulés pour les dépendances
}

