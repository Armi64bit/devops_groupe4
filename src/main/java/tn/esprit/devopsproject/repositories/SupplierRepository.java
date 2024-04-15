package tn.esprit.devopsproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.devopsproject.entities.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

}
