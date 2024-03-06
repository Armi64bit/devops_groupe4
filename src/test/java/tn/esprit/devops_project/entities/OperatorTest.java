package tn.esprit.devops_project.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.HashSet;
import java.util.Set;

class OperatorTest {

    @Test
    void initializeInvoices_ShouldInitializeInvoicesSetIfNull() {
        // Arrange
        Operator operator = new Operator();

        // Act
        operator.initializeInvoices();

        // Assert
        assertNotNull(operator.getInvoices());
        assertTrue(operator.getInvoices().isEmpty());
    }
}
