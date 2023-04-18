package com.example.products.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;


@Data
@AllArgsConstructor
@Entity
@Table(name="prices")
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Price {
    @Id
    @Column(name = "price_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long price_id;
    private Float price;
    @Column(name = "price_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfPrice;
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
}
