package tn.esprit.devopsproject.dto;

import lombok.Data;
import tn.esprit.devopsproject.entities.ProductCategory;

import java.util.Objects;

@Data
public class ProductDTO {
    private Long idProduct;
    private String title;
    private float price;
    private int quantity;
    private ProductCategory category;
    // You can include additional fields as needed

    // Constructors
    public ProductDTO() {
        // Default no-argument constructor
    }

    public ProductDTO(Long idProduct, String title, float price, int quantity, ProductCategory category) {
        this.idProduct = idProduct;
        this.title = title;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    // Getters and Setters
    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }
    @Override
    public String toString() {
        return "ProductDTO{" +
                "idProduct=" + idProduct +
                ", title='" + title + '\'' + // Use single quotes here
                ", price=" + price +
                ", quantity=" + quantity +
                ", category=" + category +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDTO that = (ProductDTO) o;
        return Float.compare(that.price, price) == 0 &&
                quantity == that.quantity &&
                Objects.equals(idProduct, that.idProduct) &&
                Objects.equals(title, that.title) &&
                category == that.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduct, title, price, quantity, category);
    }
}
