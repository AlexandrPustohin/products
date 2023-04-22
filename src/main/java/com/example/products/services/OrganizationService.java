package com.example.products.services;

import com.example.products.model.DTO.OrganizationDTO;
import com.example.products.model.Organization;

import java.util.List;

public interface OrganizationService {
    void saveOrganization(OrganizationDTO organizationDTO);
    List<OrganizationDTO> getAllOrganizations();
    OrganizationDTO getOrganizationDTO(Long id);
    Organization    getOrganization(Long id);
    OrganizationDTO getOrganizationDTO(String name);
    boolean isActive(Long organizationId);
    boolean isActive(String name);
    void setActive(Long organizationId, boolean value);
    void addOrganisation(OrganizationDTO organizationDTO);
}
