package com.example.products.services.impl;

import com.example.products.model.DTO.OrganizationDTO;
import com.example.products.model.DTO.factoryDTO.OrganizationDTOFactory;
import com.example.products.model.Organization;
import com.example.products.repository.OrganizationRepository;
import com.example.products.services.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    OrganizationRepository organizationRepository;
    @Autowired
    OrganizationDTOFactory organizationDTOFactory;

    @Override
    public void saveOrganization(OrganizationDTO organizationDTO){
        if(organizationDTO.getId()==null){
            addOrganisation(organizationDTO);
        }
    }

    @Override
    public List<OrganizationDTO> getAllOrganizations() {
        List<Organization> organizations = organizationRepository.findAll();
        return  organizationDTOFactory.fromOrganizationToDTOList(organizations);
    }

    @Override
    public void addOrganisation(OrganizationDTO organizationDTO) {
        organizationRepository.save(organizationDTOFactory.fromDTOToNewOrganization(organizationDTO));
    }



    @Override
    public OrganizationDTO getOrganizationDTO(Long organizationId) {
        Optional<Organization> organization = organizationRepository.findById(organizationId);
        OrganizationDTO organizationDTO = null;
        if(organization.isPresent()){
            organizationDTO = organizationDTOFactory.fromOrganizationToDTO(organization.get());
        }
        return organizationDTO;
    }

    @Override
    public Organization getOrganization(Long organizationId){
        Optional<Organization> organization = organizationRepository.findById(organizationId);
        if(organization.isPresent()){
           return organization.get();
        }
        return null;
    }

    @Override
    public OrganizationDTO getOrganizationDTO(String name) {
        Optional<Organization> organization = Optional.ofNullable(organizationRepository.findByName(name));
        OrganizationDTO organizationDTO = null;
        if(organization.isPresent()){
            organizationDTO = organizationDTOFactory.fromOrganizationToDTO(organization.get());
        }
        return organizationDTO;
    }

    @Override
    public boolean isActive(Long organizationId) {
        Optional<Organization> organization = organizationRepository.findById(organizationId);
        OrganizationDTO organizationDTO = null;
        if(organization.isPresent()){
            organizationDTO = organizationDTOFactory.fromOrganizationToDTO(organization.get());
        } else {
            return false; //TODO добавить исключение
        }
        return organizationDTO.isActive();
    }

    @Override
    public boolean isActive(String name) {
        Optional<Organization> organization = Optional.ofNullable(organizationRepository.findByName(name));
        OrganizationDTO organizationDTO = null;
        if(organization.isPresent()){
            organizationDTO = organizationDTOFactory.fromOrganizationToDTO(organization.get());
        } else {
            return false;//TODO добавить исключение
        }
        return organizationDTO.isActive();
    }


    @Override
    public void setActive(Long organizationId, boolean value) {
        Optional<Organization> organizationOptional = organizationRepository.findById(organizationId);
        if(organizationOptional.isPresent()){
           int c = organizationRepository.setIsActive(organizationId, value);
        } else {
             //TODO добавить исключение
        }

    }


}
