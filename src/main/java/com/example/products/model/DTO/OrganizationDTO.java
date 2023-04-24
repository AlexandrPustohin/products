package com.example.products.model.DTO;

import com.example.products.model.Product;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrganizationDTO {
    private Long id;
    private String name;
    private String description;
    private String logo;
    private boolean isActive;//бан
    private boolean isDeleted;//пометка на удаление

}
