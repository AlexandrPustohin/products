package com.example.products.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@Table(name="products")
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;
    private String name;
    private String description;
    private int count; //количество

    @ManyToOne(fetch = FetchType.LAZY)
    private Organization organization;

    @OneToMany(mappedBy = "price_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Price> prices; //цены

    @OneToMany(mappedBy = "specification_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Specification> specifications; //характеристики

    @OneToMany(mappedBy = "estimation_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Estimation> estimations;//оценки

    @OneToMany(mappedBy = "comment_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments; //комментарии

    @OneToMany(mappedBy = "discount_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Discount> discounts; //скидки

    @OneToMany(mappedBy = "key_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<KeyWord> keyWords; //ключевые слова

}
