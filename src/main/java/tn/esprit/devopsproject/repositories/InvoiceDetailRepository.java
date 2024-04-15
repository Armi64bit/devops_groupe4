package tn.esprit.devopsproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.devopsproject.entities.InvoiceDetail;

public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetail, Long> {

}
