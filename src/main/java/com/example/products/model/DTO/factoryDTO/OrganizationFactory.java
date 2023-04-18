package com.example.products.model.DTO.factoryDTO;

import com.example.products.model.DTO.OrganizationDTO;
import com.example.products.model.Organization;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Stream;

@Component
public class OrganizationFactory {

    public OrganizationDTO fromOrganizationToDTO(Organization organization){
        return OrganizationDTO.builder()
                .id(organization.getId())
                .name(organization.getName())
                .description(organization.getDescription())
                .logo(organization.getLogo())
                .isActive(organization.isActive())
                .isDeleted(organization.isDeleted())
                .build();
    }
    public Organization fromDTOToNewOrganization(OrganizationDTO organizationDTO){
        return Organization.builder()
                .name(organizationDTO.getName())
                .description(organizationDTO.getDescription())
                .logo(organizationDTO.getLogo())
                .isActive(true)
                .isDeleted(false)
                .build();
    }

    public List<OrganizationDTO> fromOrganizationToDTOList(List<Organization> organization) {
        return  organization.stream().map(org -> fromOrganizationToDTO(org)).toList();
    }
}
