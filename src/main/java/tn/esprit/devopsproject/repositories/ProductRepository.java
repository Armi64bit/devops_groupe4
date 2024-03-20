package tn.esprit.devopsproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.devopsproject.entities.Product;
import tn.esprit.devopsproject.entities.ProductCategory;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategory(ProductCategory category);
    List<Product> findByStockIdStock(Long idStock);
}
