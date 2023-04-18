package com.example.products.services;

import com.example.products.model.DTO.OrganizationDTO;

import java.util.List;

public interface OrganizationService {
    void saveOrganization(OrganizationDTO organizationDTO);
    List<OrganizationDTO> getAllOrganizations();
    OrganizationDTO getOrganisation(Long id);
    OrganizationDTO getOrganisation(String name);
    boolean isActive(Long organizationId);
    boolean isActive(String name);
    void setActive(Long organizationId, boolean value);

}
