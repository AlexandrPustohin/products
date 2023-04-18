package com.example.products.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@Table(name="discounts")
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Discount {//Скидки
    @Id
    @Column(name = "discount_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long discount_id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    private int duration; //продолжительность в днях
    private float amount; //объем скидки (в процентах)
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;


}
