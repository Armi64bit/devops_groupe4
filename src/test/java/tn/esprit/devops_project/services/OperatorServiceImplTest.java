package tn.esprit.devops_project.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.devops_project.entities.Operator;
import tn.esprit.devops_project.repositories.OperatorRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)

class OperatorServiceImplTest {

    @Mock
    private OperatorRepository operatorRepository;

    @InjectMocks
    private OperatorServiceImpl operatorService;

    @Test
    void retrieveAllOperators() {
        // Mocking the behavior of the repository
        when(operatorRepository.findAll()).thenReturn(Arrays.asList(new Operator(), new Operator()));

        // Calling the service method
        List<Operator> operators = operatorService.retrieveAllOperators();

        // Asserting the result
        assertEquals(2, operators.size());
    }

    @Test
    void addOperator() {
        // Creating a mock Operator
        Operator operatorToAdd = new Operator();
        operatorToAdd.setFname("John");

        // Mocking the behavior of the repository
        when(operatorRepository.save(any(Operator.class))).thenReturn(operatorToAdd);

        // Calling the service method
        Operator addedOperator = operatorService.addOperator(operatorToAdd);

        // Asserting the result
        assertEquals("John", addedOperator.getFname());
    }

    @Test
    void deleteOperator() {
        // Mocking the behavior of the repository
        doNothing().when(operatorRepository).deleteById(1L);

        // Calling the service method
        operatorService.deleteOperator(1L);

        // Verifying that the repository method was called with the correct argument
        verify(operatorRepository, times(1)).deleteById(1L);
    }

    @Test
    void updateOperator() {
        // Creating a mock Operator
        Operator operatorToUpdate = new Operator();
        operatorToUpdate.setIdOperateur(1L);
        operatorToUpdate.setFname("UpdatedName");

        // Mocking the behavior of the repository
        when(operatorRepository.save(any(Operator.class))).thenReturn(operatorToUpdate);

        // Calling the service method
        Operator updatedOperator = operatorService.updateOperator(operatorToUpdate);

        // Asserting the result
        assertEquals("UpdatedName", updatedOperator.getFname());
    }

    @Test
    void retrieveOperator() {
        // Creating a mock Operator
        Operator mockOperator = new Operator();
        mockOperator.setIdOperateur(1L);
        mockOperator.setFname("John");

        // Mocking the behavior of the repository
        when(operatorRepository.findById(1L)).thenReturn(Optional.of(mockOperator));

        // Calling the service method
        Operator retrievedOperator = operatorService.retrieveOperator(1L);

        // Asserting the result
        assertNotNull(retrievedOperator);
        assertEquals("John", retrievedOperator.getFname());
    }
}
