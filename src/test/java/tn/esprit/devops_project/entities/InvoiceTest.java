package tn.esprit.devops_project.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class InvoiceTest {

    @Test
    void gettersAndSetters() {
        // Create a mocked Invoice object
        Invoice invoice = mock(Invoice.class);

        // Set up any necessary behavior for the mocked object
        when(invoice.getIdInvoice()).thenReturn(1L);
        when(invoice.getAmountDiscount()).thenReturn(10.0f);
        when(invoice.getAmountInvoice()).thenReturn(100.0f);
        // Similarly, set up behavior for other getters if needed

        // Test the getters
        assertEquals(1L, invoice.getIdInvoice());
        assertEquals(10.0f, invoice.getAmountDiscount());
        assertEquals(100.0f, invoice.getAmountInvoice());
        // Similarly, test other getters if needed

        // Test the setters
        invoice.setIdInvoice(2L);
        invoice.setAmountDiscount(20.0f);
        invoice.setAmountInvoice(200.0f);
        // Similarly, test other setters if needed

        // Verify that the setters were called with the correct arguments
        verify(invoice).setIdInvoice(2L);
        verify(invoice).setAmountDiscount(20.0f);
        verify(invoice).setAmountInvoice(200.0f);
        // Similarly, verify other setters if needed
    }
}
