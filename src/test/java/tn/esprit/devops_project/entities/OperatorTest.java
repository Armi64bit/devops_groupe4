package tn.esprit.devops_project.entities;

import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

class OperatorTest {

    @Test
    void initializeInvoices() {
        // Arrange
        Operator operator = new Operator();

        // Act
        operator.initializeInvoices();

        // Assert
        assertNotNull(operator.getInvoices());
        assertTrue(operator.getInvoices().isEmpty());
    }

    // Add tests for other methods and constructors of the Operator class if needed
}
