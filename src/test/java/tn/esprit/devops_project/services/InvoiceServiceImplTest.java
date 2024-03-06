package tn.esprit.devops_project.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.devops_project.entities.Invoice;
import tn.esprit.devops_project.entities.Operator;
import tn.esprit.devops_project.entities.Supplier;
import tn.esprit.devops_project.repositories.InvoiceDetailRepository;
import tn.esprit.devops_project.repositories.InvoiceRepository;
import tn.esprit.devops_project.repositories.OperatorRepository;
import tn.esprit.devops_project.repositories.SupplierRepository;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class InvoiceServiceImplTest {

    @Mock
    InvoiceRepository invoiceRepository;

    @Mock
    OperatorRepository operatorRepository;

    @Mock
    InvoiceDetailRepository invoiceDetailRepository;

    @Mock
    SupplierRepository supplierRepository;

    @InjectMocks
    InvoiceServiceImpl invoiceService;

    @Test
    void retrieveAllInvoices_shouldReturnListOfInvoices() {
        // Arrange
        List<Invoice> expectedInvoices = Arrays.asList(new Invoice(), new Invoice());
        when(invoiceRepository.findAll()).thenReturn(expectedInvoices);

        // Act
        List<Invoice> actualInvoices = invoiceService.retrieveAllInvoices();

        // Assert
        assertEquals(expectedInvoices.size(), actualInvoices.size());
        assertEquals(expectedInvoices, actualInvoices);
    }

    @Test
    void cancelInvoice_shouldCancelInvoice() {
        // Arrange
        Long invoiceId = 1L;
        Invoice invoice = new Invoice();
        when(invoiceRepository.findById(invoiceId)).thenReturn(Optional.of(invoice));

        // Act
        invoiceService.cancelInvoice(invoiceId);

        // Assert
        assertTrue(invoice.getArchived());
        verify(invoiceRepository, times(1)).save(invoice);
    }

    @Test
    void retrieveInvoice_shouldReturnInvoice() {
        // Arrange
        Long invoiceId = 1L;
        Invoice expectedInvoice = new Invoice();
        when(invoiceRepository.findById(invoiceId)).thenReturn(Optional.of(expectedInvoice));

        // Act
        Invoice actualInvoice = invoiceService.retrieveInvoice(invoiceId);

        // Assert
        assertNotNull(actualInvoice);
        assertEquals(expectedInvoice, actualInvoice);
    }

    @Test
    void getInvoicesBySupplier_shouldReturnListOfInvoices() {
        // Arrange
        Long supplierId = 1L;
        Supplier supplier = new Supplier();
        supplier.setIdSupplier(supplierId);
        List<Invoice> expectedInvoices = Arrays.asList(new Invoice(), new Invoice());
        when(supplierRepository.findById(supplierId)).thenReturn(Optional.of(supplier));
        when(supplier.getInvoices()).thenReturn((Set<Invoice>) expectedInvoices);

        // Act
        List<Invoice> actualInvoices = invoiceService.getInvoicesBySupplier(supplierId);

        // Assert
        assertEquals(expectedInvoices.size(), actualInvoices.size());
        assertEquals(expectedInvoices, actualInvoices);
    }

    @Test
    void assignOperatorToInvoice_shouldAssignOperatorToInvoice() {
        // Arrange
        Long operatorId = 1L;
        Long invoiceId = 1L;
        Operator operator = new Operator();
        operator.setIdOperateur(operatorId);
        Invoice invoice = new Invoice();
        invoice.setIdInvoice(invoiceId);
        when(operatorRepository.findById(operatorId)).thenReturn(Optional.of(operator));
        when(invoiceRepository.findById(invoiceId)).thenReturn(Optional.of(invoice));

        // Act
        invoiceService.assignOperatorToInvoice(operatorId, invoiceId);

        // Assert
        assertTrue(operator.getInvoices().contains(invoice));
        verify(operatorRepository, times(1)).save(operator);
    }

    @Test
    void getTotalAmountInvoiceBetweenDates_shouldReturnTotalAmount() {
        // Arrange
        Date startDate = new Date();
        Date endDate = new Date();
        float expectedTotalAmount = 1000.0f;
        when(invoiceRepository.getTotalAmountInvoiceBetweenDates(startDate, endDate)).thenReturn(expectedTotalAmount);

        // Act
        float actualTotalAmount = invoiceService.getTotalAmountInvoiceBetweenDates(startDate, endDate);

        // Assert
        assertEquals(expectedTotalAmount, actualTotalAmount);
    }
}
