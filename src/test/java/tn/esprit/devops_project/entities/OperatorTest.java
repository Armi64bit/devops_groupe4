package tn.esprit.devops_project.entities;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OperatorTest {

    @Test
    void initializeInvoices_WhenInvoicesIsNull_ShouldInitializeInvoices() {
        // Arrange
        Operator operator = new Operator();
        assertNull(operator.getInvoices());

        // Act
        operator.initializeInvoices();

        // Assert
        assertNotNull(operator.getInvoices());
    }

    @Test
    void initializeInvoices_WhenInvoicesIsNotNull_ShouldNotModifyInvoices() {
        // Arrange
        Set<Invoice> invoices = new HashSet<>();
        invoices.add(new Invoice());
        Operator operator = new Operator();
        operator.setInvoices(invoices);

        // Act
        operator.initializeInvoices();

        // Assert
        assertEquals(invoices, operator.getInvoices());
    }
}
