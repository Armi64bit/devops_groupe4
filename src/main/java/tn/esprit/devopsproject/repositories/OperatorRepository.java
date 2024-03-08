package tn.esprit.devopsproject.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.devopsproject.entities.Operator;

public interface OperatorRepository extends CrudRepository<Operator, Long> {

}
