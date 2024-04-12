package tn.esprit.devopsproject.services;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import tn.esprit.devopsproject.entities.Operator;
import tn.esprit.devopsproject.repositories.OperatorRepository;
import tn.esprit.devopsproject.services.Iservices.IOperatorService;

import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OperatorServiceImpl implements IOperatorService {

	OperatorRepository operatorRepository;
	@Override
	public List<Operator> retrieveAllOperators() {
		return (List<Operator>) operatorRepository.findAll();
	}

	@Override
	public Operator addOperator(Operator operator) {
		return operatorRepository.save(operator);
	}

	@Override
	public void deleteOperator(Long id) {
		operatorRepository.deleteById(id);
		
	}

	@Override
	public Operator updateOperator(Operator operator) {
		return operatorRepository.save(operator);
	}

	@Override
	public Operator retrieveOperator(Long id) {
		return operatorRepository.findById(id).orElseThrow(() -> new NullPointerException("Operator not found"));
	}

}
