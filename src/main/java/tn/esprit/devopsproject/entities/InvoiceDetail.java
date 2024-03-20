package tn.esprit.devopsproject.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDetail implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idInvoiceDetail;
	int quantity;
	float price;
	@ManyToOne
	Product product;
	@ManyToOne
	@JsonIgnore
	Invoice invoice;

    public InvoiceDetail(Long id, int quantity, float price, Product product) {
		this.setIdInvoiceDetail(id);
		this.setPrice(price);
		this.setProduct(product);
		this.setQuantity(quantity);

    }

	public InvoiceDetail(int quantity, float price, Product product) {
		this.setPrice(price);
		this.setProduct(product);
		this.setQuantity(quantity);
	}
}
