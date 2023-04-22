package com.example.products.model.DTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductDTO {
    private Long product_id;
    private String name;
    private String description;
    private int count;
    private Long organization;

}
