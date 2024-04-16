package tn.esprit.devopsproject.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.devopsproject.entities.Operator;
import tn.esprit.devopsproject.services.Iservices.IOperatorService;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class OperatorController {

	IOperatorService operatorService;
	
	@GetMapping("/operator")
	public List<Operator> getOperators() {
		return operatorService.retrieveAllOperators();
	}

	@GetMapping("/operator/{operatorId}")
	public Operator retrieveoperator(@PathVariable Long operatorId) {
		return operatorService.retrieveOperator(operatorId);
	}

	@PostMapping("/operator")
	public Operator addOperator(@RequestBody Operator operator) {
		return operatorService.addOperator(operator);
	}

	@DeleteMapping("/operatot/{operatorId}")
	public void removeOperator(@PathVariable Long operatorId) {
		operatorService.deleteOperator(operatorId);
	}

	@PutMapping("/operator")
	public Operator modifyOperateur(@RequestBody Operator operator) {
		return operatorService.updateOperator(operator);
	}

	
}
