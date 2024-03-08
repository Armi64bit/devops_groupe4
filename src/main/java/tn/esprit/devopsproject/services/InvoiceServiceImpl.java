package tn.esprit.devopsproject.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.devopsproject.entities.Invoice;
import tn.esprit.devopsproject.entities.Operator;
import tn.esprit.devopsproject.entities.Supplier;
import tn.esprit.devopsproject.repositories.InvoiceDetailRepository;
import tn.esprit.devopsproject.repositories.InvoiceRepository;
import tn.esprit.devopsproject.repositories.OperatorRepository;
import tn.esprit.devopsproject.repositories.SupplierRepository;
import tn.esprit.devopsproject.services.Iservices.IInvoiceService;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class InvoiceServiceImpl implements IInvoiceService {
	private static final String INVOICE_NOT_FOUND_MESSAGE = "Invoice not found";

	final InvoiceRepository invoiceRepository;
	final OperatorRepository operatorRepository;
	final InvoiceDetailRepository invoiceDetailRepository;
	final SupplierRepository supplierRepository;
	//commentaire
	//commentaire 2 developper
	@Override
	public List<Invoice> retrieveAllInvoices() {
		return invoiceRepository.findAll();
	}
	@Override
	public void cancelInvoice(Long invoiceId) {
		// method 01
		Invoice invoice = invoiceRepository.findById(invoiceId).orElseThrow(() -> new NullPointerException(INVOICE_NOT_FOUND_MESSAGE));
		invoice.setArchived(true);
		invoiceRepository.save(invoice);
		//method 02 (Avec JPQL)
		invoiceRepository.updateInvoice(invoiceId);
	}

	@Override
	public Invoice retrieveInvoice(Long invoiceId) {

		return invoiceRepository.findById(invoiceId).orElseThrow(() -> new NullPointerException(INVOICE_NOT_FOUND_MESSAGE));
	}

	@Override
	public List<Invoice> getInvoicesBySupplier(Long idSupplier) {
		Supplier supplier = supplierRepository.findById(idSupplier).orElseThrow(() -> new NullPointerException("Supplier not found"));
		return (List<Invoice>) supplier.getInvoices();
	}

	@Override
	public void assignOperatorToInvoice(Long idOperator, Long idInvoice) {
		Invoice invoice = invoiceRepository.findById(idInvoice).orElseThrow(() -> new NullPointerException(INVOICE_NOT_FOUND_MESSAGE));
		Operator operator = operatorRepository.findById(idOperator).orElseThrow(() -> new NullPointerException("Operator not found"));
		operator.getInvoices().add(invoice);
		operatorRepository.save(operator);
	}

	@Override
	public float getTotalAmountInvoiceBetweenDates(Date startDate, Date endDate) {
		return invoiceRepository.getTotalAmountInvoiceBetweenDates(startDate, endDate);
	}


}