package com.example.products.services;

import com.example.products.exceptions.organizationException.OrganizationNotFoundException;
import com.example.products.model.DTO.OrganizationDTO;
import com.example.products.model.Organization;

import java.util.List;

public interface OrganizationService {
    Long addEditOrganization(OrganizationDTO organizationDTO) throws OrganizationNotFoundException;
    List<OrganizationDTO> getAllOrganizations();
    OrganizationDTO getOrganizationDTO(Long id);
    Organization    getOrganization(Long id) throws OrganizationNotFoundException;
    OrganizationDTO getOrganizationDTO(String name);
    boolean isActive(Long organizationId);
    boolean isActive(String name);
    void setActive(Long organizationId, boolean value);

}
