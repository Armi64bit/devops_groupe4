package tn.esprit.devops_project.entities;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tn.esprit.devops_project.entities.Invoice;
import tn.esprit.devops_project.entities.InvoiceDetail;
import tn.esprit.devops_project.entities.Supplier;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

class InvoiceTest {
    private Invoice invoice;

    @BeforeEach
    void setUp() {
        invoice = new Invoice();
    }

    @Test
    void getIdInvoice() {
        Long id = 1L;
        invoice.setIdInvoice(id);
        assertEquals(id, invoice.getIdInvoice());
    }

    @Test
    void getAmountDiscount() {
        float amountDiscount = 50.0f;
        invoice.setAmountDiscount(amountDiscount);
        assertEquals(amountDiscount, invoice.getAmountDiscount(), 0.01);
    }

    @Test
    void getAmountInvoice() {
        float amountInvoice = 100.0f;
        invoice.setAmountInvoice(amountInvoice);
        assertEquals(amountInvoice, invoice.getAmountInvoice(), 0.01);
    }

    @Test
    void getDateCreationInvoice() {
        Date date = new Date();
        invoice.setDateCreationInvoice(date);
        assertEquals(date, invoice.getDateCreationInvoice());
    }

    @Test
    void getDateLastModificationInvoice() {
        Date date = new Date();
        invoice.setDateLastModificationInvoice(date);
        assertEquals(date, invoice.getDateLastModificationInvoice());
    }

    @Test
    void getArchived() {
        boolean archived = true;
        invoice.setArchived(archived);
        assertTrue(invoice.getArchived());
    }

    @Test
    void getInvoiceDetails() {
        Set<InvoiceDetail> details = new HashSet<>();
        InvoiceDetail detail = new InvoiceDetail();
        details.add(detail);
        invoice.setInvoiceDetails(details);
        assertEquals(details, invoice.getInvoiceDetails());
    }

    @Test
    void getSupplier() {
        Supplier supplier = new Supplier();
        invoice.setSupplier(supplier);
        assertEquals(supplier, invoice.getSupplier());
    }

    @Test
    void setIdInvoice() {
        Long id = 1L;
        invoice.setIdInvoice(id);
        assertEquals(id, invoice.getIdInvoice());
    }

    @Test
    void setAmountDiscount() {
        float amountDiscount = 50.0f;
        invoice.setAmountDiscount(amountDiscount);
        assertEquals(amountDiscount, invoice.getAmountDiscount(), 0.01);
    }

    @Test
    void setAmountInvoice() {
        float amountInvoice = 100.0f;
        invoice.setAmountInvoice(amountInvoice);
        assertEquals(amountInvoice, invoice.getAmountInvoice(), 0.01);
    }

    @Test
    void setDateCreationInvoice() {
        Date date = new Date();
        invoice.setDateCreationInvoice(date);
        assertEquals(date, invoice.getDateCreationInvoice());
    }

    @Test
    void setDateLastModificationInvoice() {
        Date date = new Date();
        invoice.setDateLastModificationInvoice(date);
        assertEquals(date, invoice.getDateLastModificationInvoice());
    }

    @Test
    void setArchived() {
        boolean archived = true;
        invoice.setArchived(archived);
        assertTrue(invoice.getArchived());
    }

    @Test
    void setInvoiceDetails() {
        Set<InvoiceDetail> details = new HashSet<>();
        InvoiceDetail detail = new InvoiceDetail();
        details.add(detail);
        invoice.setInvoiceDetails(details);
        assertEquals(details, invoice.getInvoiceDetails());
    }

    @Test
    void setSupplier() {
        Supplier supplier = new Supplier();
        invoice.setSupplier(supplier);
        assertEquals(supplier, invoice.getSupplier());
    }
}
