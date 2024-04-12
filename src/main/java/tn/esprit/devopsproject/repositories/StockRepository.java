package tn.esprit.devopsproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.devopsproject.entities.Stock;


public interface StockRepository extends JpaRepository<Stock, Long> {}

