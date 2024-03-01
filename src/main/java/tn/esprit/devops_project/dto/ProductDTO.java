package tn.esprit.devops_project.dto;

import lombok.Data;
import tn.esprit.devops_project.entities.ProductCategory;

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
}
