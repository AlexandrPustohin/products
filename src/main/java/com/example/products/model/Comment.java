package com.example.products.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;


import java.util.Date;

@Data
@AllArgsConstructor
@Entity
@Table(name="comments")
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Comment {
    @Id
    @Column(name = "comment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comment_id;
    private String comment;
    @Column(name = "customer_name")
    private String customerName;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private Date created;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

}
