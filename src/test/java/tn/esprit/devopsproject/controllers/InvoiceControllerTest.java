package tn.esprit.devopsproject.controllers;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.devopsproject.entities.Invoice;
import tn.esprit.devopsproject.services.Iservices.IInvoiceService;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class InvoiceControllerTest {

    @Mock
    private IInvoiceService invoiceService;

    @InjectMocks
    private InvoiceController invoiceController;

    public InvoiceControllerTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getInvoices() {
        // Mocking behavior
        when(invoiceService.retrieveAllInvoices()).thenReturn(Collections.singletonList(new Invoice()));

        // Method invocation
        List<Invoice> invoices = invoiceController.getInvoices();

        // Assertions
        assertEquals(1, invoices.size());
        verify(invoiceService, times(1)).retrieveAllInvoices();
    }

    @Test
    void retrieveInvoice() {
        Long invoiceId = 1L;
        Invoice invoice = new Invoice(invoiceId);
        when(invoiceService.retrieveInvoice(invoiceId)).thenReturn(invoice);

        Invoice retrievedInvoice = invoiceController.retrieveInvoice(invoiceId);

        assertEquals(invoice, retrievedInvoice);
        verify(invoiceService, times(1)).retrieveInvoice(invoiceId);
    }

    @Test
    void cancelInvoice() {
        Long invoiceId = 1L;
        invoiceController.cancelInvoice(invoiceId);
        verify(invoiceService, times(1)).cancelInvoice(invoiceId);
    }

    @Test
    void getInvoicesBySupplier() {
        Long supplierId = 1L;
        when(invoiceService.getInvoicesBySupplier(supplierId)).thenReturn(Collections.emptyList());

        List<Invoice> invoices = invoiceController.getInvoicesBySupplier(supplierId);

        assertEquals(0, invoices.size());
        verify(invoiceService, times(1)).getInvoicesBySupplier(supplierId);
    }

    @Test
    void assignOperatorToInvoice() {
        Long idOperator = 1L;
        Long idInvoice = 1L;
        invoiceController.assignOperatorToInvoice(idOperator, idInvoice);
        verify(invoiceService, times(1)).assignOperatorToInvoice(idOperator, idInvoice);
    }

    @Test
    void getTotalAmountInvoiceBetweenDates() {
        Date startDate = new Date();
        Date endDate = new Date();
        when(invoiceService.getTotalAmountInvoiceBetweenDates(startDate, endDate)).thenReturn(100.0f);

        float totalAmount = invoiceController.getTotalAmountInvoiceBetweenDates(startDate, endDate);

        assertEquals(100.0f, totalAmount, 0.01);
        verify(invoiceService, times(1)).getTotalAmountInvoiceBetweenDates(startDate, endDate);
    }
}
