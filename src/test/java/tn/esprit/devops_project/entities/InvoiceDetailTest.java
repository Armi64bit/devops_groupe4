package tn.esprit.devops_project.entities;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import tn.esprit.devops_project.entities.InvoiceDetail;
import tn.esprit.devops_project.entities.Invoice;
import tn.esprit.devops_project.entities.Product;

class InvoiceDetailTest {
    @Test
    void testDefaultConstructor() {
        InvoiceDetail invoiceDetail = new InvoiceDetail();
        assertNotNull(invoiceDetail);
    }

    @Test
    void testAllArgsConstructor() {
        Long id = 1L;
        int quantity = 5;
        float price = 100.0f;
        Product product = new Product();
        InvoiceDetail invoiceDetail = new InvoiceDetail(id, quantity, price, product);

        assertEquals(id, invoiceDetail.getIdInvoiceDetail());
        assertEquals(quantity, invoiceDetail.getQuantity());
        assertEquals(price, invoiceDetail.getPrice());
        assertEquals(product, invoiceDetail.getProduct());
    }

    @Test
    void testConstructorWithoutIdInvoiceDetail() {
        int quantity = 5;
        float price = 100.0f;
        Product product = new Product();
        InvoiceDetail invoiceDetail = new InvoiceDetail(quantity, price, product);

        assertEquals(quantity, invoiceDetail.getQuantity());
        assertEquals(price, invoiceDetail.getPrice());
        assertEquals(product, invoiceDetail.getProduct());
    }
    @Test
    void testGetIdInvoiceDetail() {
        InvoiceDetail invoiceDetail = new InvoiceDetail();
        Long id = 123L;
        invoiceDetail.setIdInvoiceDetail(id);
        assertEquals(id, invoiceDetail.getIdInvoiceDetail());
    }

    @Test
    void testGetQuantity() {
        InvoiceDetail invoiceDetail = new InvoiceDetail();
        int quantity = 5;
        invoiceDetail.setQuantity(quantity);
        assertEquals(quantity, invoiceDetail.getQuantity());
    }

    @Test
    void testGetPrice() {
        InvoiceDetail invoiceDetail = new InvoiceDetail();
        float price = 10.5f;
        invoiceDetail.setPrice(price);
        assertEquals(price, invoiceDetail.getPrice());
    }

    @Test
    void testGetProduct() {
        InvoiceDetail invoiceDetail = new InvoiceDetail();
        Product product = new Product();
        invoiceDetail.setProduct(product);
        assertEquals(product, invoiceDetail.getProduct());
    }

    @Test
    void testGetInvoice() {
        InvoiceDetail invoiceDetail = new InvoiceDetail();
        Invoice invoice = new Invoice();
        invoiceDetail.setInvoice(invoice);
        assertEquals(invoice, invoiceDetail.getInvoice());
    }

    @Test
    void testSetIdInvoiceDetail() {
        InvoiceDetail invoiceDetail = new InvoiceDetail();
        Long id = 123L;
        invoiceDetail.setIdInvoiceDetail(id);
        assertEquals(id, invoiceDetail.getIdInvoiceDetail());
    }

    @Test
    void testSetQuantity() {
        InvoiceDetail invoiceDetail = new InvoiceDetail();
        int quantity = 5;
        invoiceDetail.setQuantity(quantity);
        assertEquals(quantity, invoiceDetail.getQuantity());
    }

    @Test
    void testSetPrice() {
        InvoiceDetail invoiceDetail = new InvoiceDetail();
        float price = 10.5f;
        invoiceDetail.setPrice(price);
        assertEquals(price, invoiceDetail.getPrice());
    }

    @Test
    void testSetProduct() {
        InvoiceDetail invoiceDetail = new InvoiceDetail();
        Product product = new Product();
        invoiceDetail.setProduct(product);
        assertEquals(product, invoiceDetail.getProduct());
    }

    @Test
    void testSetInvoice() {
        InvoiceDetail invoiceDetail = new InvoiceDetail();
        Invoice invoice = new Invoice();
        invoiceDetail.setInvoice(invoice);
        assertEquals(invoice, invoiceDetail.getInvoice());
    }
}
