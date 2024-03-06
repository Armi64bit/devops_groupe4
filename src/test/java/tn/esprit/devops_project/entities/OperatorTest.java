package tn.esprit.devops_project.entities;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.HashSet;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OperatorTest {

    @Mock
    private Invoice invoiceMock;

    @Test
    void initializeInvoices_ShouldInitializeInvoicesSet() {
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
