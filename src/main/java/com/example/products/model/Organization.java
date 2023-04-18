package com.example.products.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Data
@AllArgsConstructor
@Entity
@Table(name="organizations")
@NoArgsConstructor
@Getter
@Setter
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Organization {
    @Id
    @Column(name = "org_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String logo;
    @Column(name = "is_active")
    private boolean isActive;//бан
    @Column(name = "is_deleted")
    private boolean isDeleted;//пометка на удаление

    @OneToMany(mappedBy = "product_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products;

    public void addProducts(Product product) {
        products.add(product);
        product.setOrganization(this);
    }

    public void removeProduct(Product product) {
        products.remove(product);
        product.setOrganization(null);
    }


}
