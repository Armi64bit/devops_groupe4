package tn.esprit.devops_project.entities;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashSet;
import java.util.Set;
import tn.esprit.devops_project.entities.Supplier;
import tn.esprit.devops_project.entities.SupplierCategory;
import tn.esprit.devops_project.entities.Invoice;
import tn.esprit.devops_project.entities.ActivitySector;

class SupplierTest {

    @Test
    void testGetIdSupplier() {
        Supplier supplier = new Supplier();
        Long id = 123L;
        supplier.setIdSupplier(id);
        assertEquals(id, supplier.getIdSupplier());
    }

    @Test
    void testGetCode() {
        Supplier supplier = new Supplier();
        String code = "ABC123";
        supplier.setCode(code);
        assertEquals(code, supplier.getCode());
    }

    @Test
    void testGetLabel() {
        Supplier supplier = new Supplier();
        String label = "Supplier Label";
        supplier.setLabel(label);
        assertEquals(label, supplier.getLabel());
    }

    @Test
    void testGetSupplierCategory() {
        Supplier supplier = new Supplier();
        SupplierCategory category = SupplierCategory.CONVENTIONNE;
        supplier.setSupplierCategory(category);
        assertEquals(category, supplier.getSupplierCategory());
    }

    @Test
    void testGetInvoices() {
        Supplier supplier = new Supplier();
        Set<Invoice> invoices = new HashSet<>();
        Invoice invoice = new Invoice();
        invoices.add(invoice);
        supplier.setInvoices(invoices);
        assertEquals(invoices, supplier.getInvoices());
    }

    @Test
    void testGetActivitySectors() {
        Supplier supplier = new Supplier();
        Set<ActivitySector> activitySectors = new HashSet<>();
        ActivitySector sector = new ActivitySector();
        activitySectors.add(sector);
        supplier.setActivitySectors(activitySectors);
        assertEquals(activitySectors, supplier.getActivitySectors());
    }

    @Test
    void testSetIdSupplier() {
        Supplier supplier = new Supplier();
        Long id = 123L;
        supplier.setIdSupplier(id);
        assertEquals(id, supplier.getIdSupplier());
    }

    @Test
    void testSetCode() {
        Supplier supplier = new Supplier();
        String code = "ABC123";
        supplier.setCode(code);
        assertEquals(code, supplier.getCode());
    }

    @Test
    void testSetLabel() {
        Supplier supplier = new Supplier();
        String label = "Supplier Label";
        supplier.setLabel(label);
        assertEquals(label, supplier.getLabel());
    }

    @Test
    void testSetSupplierCategory() {
        Supplier supplier = new Supplier();
        SupplierCategory category = SupplierCategory.CONVENTIONNE;
        supplier.setSupplierCategory(category);
        assertEquals(category, supplier.getSupplierCategory());
    }

    @Test
    void testSetInvoices() {
        Supplier supplier = new Supplier();
        Set<Invoice> invoices = new HashSet<>();
        Invoice invoice = new Invoice();
        invoices.add(invoice);
        supplier.setInvoices(invoices);
        assertEquals(invoices, supplier.getInvoices());
    }

    @Test
    void testSetActivitySectors() {
        Supplier supplier = new Supplier();
        Set<ActivitySector> activitySectors = new HashSet<>();
        ActivitySector sector = new ActivitySector();
        activitySectors.add(sector);
        supplier.setActivitySectors(activitySectors);
        assertEquals(activitySectors, supplier.getActivitySectors());
    }
}
