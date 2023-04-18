package com.example.products.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;


@Data
@AllArgsConstructor
@Entity
@Table(name="estimations")
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Estimation {//Оценка товара
    @Id
    @Column(name = "estimation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long estimation_id;
    private int estimation;
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
}
