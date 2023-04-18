package com.example.products.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@Entity
@Table(name="specifications")
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Specification {//Характеристика товара
    @Id
    @Column(name = "specification_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long specification_id;
    private String type;//тип характеристики (цвет, размер...)
    private String description;//описание характеристики
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
}
