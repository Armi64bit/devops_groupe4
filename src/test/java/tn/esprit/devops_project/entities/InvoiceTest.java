package tn.esprit.devops_project.entities;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.devops_project.entities.Invoice;
import tn.esprit.devops_project.entities.InvoiceDetail;
import tn.esprit.devops_project.entities.Supplier;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

class InvoiceTest {

    @InjectMocks
    private Invoice invoice;

    @Mock
    private Supplier supplier;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetIdInvoice() {
        Long id = 1L;
        invoice.setIdInvoice(id);
        assertEquals(id, invoice.getIdInvoice());
    }

    @Test
    void testGetAmountDiscount() {
        float amountDiscount = 50.0f;
        invoice.setAmountDiscount(amountDiscount);
        assertEquals(amountDiscount, invoice.getAmountDiscount(), 0.01);
    }

    @Test
    void testGetAmountInvoice() {
        float amountInvoice = 100.0f;
        invoice.setAmountInvoice(amountInvoice);
        assertEquals(amountInvoice, invoice.getAmountInvoice(), 0.01);
    }

    @Test
    void testGetDateCreationInvoice() {
        Date date = new Date();
        invoice.setDateCreationInvoice(date);
        assertEquals(date, invoice.getDateCreationInvoice());
    }

    @Test
    void testGetDateLastModificationInvoice() {
        Date date = new Date();
        invoice.setDateLastModificationInvoice(date);
        assertEquals(date, invoice.getDateLastModificationInvoice());
    }

    @Test
    void testGetArchived() {
        boolean archived = true;
        invoice.setArchived(archived);
        assertTrue(invoice.getArchived());
    }

    @Test
    void testGetInvoiceDetails() {
        Set<InvoiceDetail> details = new HashSet<>();
        InvoiceDetail detail = new InvoiceDetail();
        details.add(detail);
        invoice.setInvoiceDetails(details);
        assertEquals(details, invoice.getInvoiceDetails());
    }

    @Test
    void testGetSupplier() {
        invoice.setSupplier(supplier);
        assertEquals(supplier, invoice.getSupplier());
    }

    @Test
    void testSetIdInvoice() {
        Long id = 1L;
        invoice.setIdInvoice(id);
        assertEquals(id, invoice.getIdInvoice());
    }

    @Test
    void testSetAmountDiscount() {
        float amountDiscount = 50.0f;
        invoice.setAmountDiscount(amountDiscount);
        assertEquals(amountDiscount, invoice.getAmountDiscount(), 0.01);
    }

    @Test
    void testSetAmountInvoice() {
        float amountInvoice = 100.0f;
        invoice.setAmountInvoice(amountInvoice);
        assertEquals(amountInvoice, invoice.getAmountInvoice(), 0.01);
    }

    @Test
    void testSetDateCreationInvoice() {
        Date date = new Date();
        invoice.setDateCreationInvoice(date);
        assertEquals(date, invoice.getDateCreationInvoice());
    }

    @Test
    void testSetDateLastModificationInvoice() {
        Date date = new Date();
        invoice.setDateLastModificationInvoice(date);
        assertEquals(date, invoice.getDateLastModificationInvoice());
    }

    @Test
    void testSetArchived() {
        boolean archived = true;
        invoice.setArchived(archived);
        assertTrue(invoice.getArchived());
    }

    @Test
    void testSetInvoiceDetails() {
        Set<InvoiceDetail> details = new HashSet<>();
        InvoiceDetail detail = new InvoiceDetail();
        details.add(detail);
        invoice.setInvoiceDetails(details);
        assertEquals(details, invoice.getInvoiceDetails());
    }

    @Test
    void testSetSupplier() {
        invoice.setSupplier(supplier);
        assertEquals(supplier, invoice.getSupplier());
    }
}
