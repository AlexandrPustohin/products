package com.example.products.controllers.org_controller;

import com.example.products.exceptions.organizationException.OrganizationNotFoundException;
import com.example.products.model.DTO.OrganizationDTO;
import com.example.products.services.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000" )
@RestController
@RequestMapping("/v1/org")
public class OrganizationController {

    @Autowired
    OrganizationService organizationService;

    @PostMapping("/add_edit")
    ResponseEntity<String> addOrganization(@RequestBody OrganizationDTO organizationDTO) throws OrganizationNotFoundException {
        Long organizationId = organizationService.addEditOrganization(organizationDTO);
        if (organizationId!=null){
            return ResponseEntity.ok("Save successful! Organization id: "+organizationId);
        } else {
            return ResponseEntity.ok("Edit successful! Organization id: " + organizationDTO.getId());
        }
    }

    @GetMapping("/{org_id}")
    ResponseEntity<OrganizationDTO> geOrganizationById(@PathVariable("org_id") Long organizationId){
        return ResponseEntity.ok(organizationService.getOrganizationDTO(organizationId));
    }
    @GetMapping("/all")
    public ResponseEntity<List<OrganizationDTO>> getAllOrganization(){
        return ResponseEntity.ok(organizationService.getAllOrganizations());
    }

    @GetMapping("/{id}/setban")
       public ResponseEntity<String> setBan(@PathVariable("id") Long id){
        organizationService.setActive(id, false);
        return ResponseEntity.ok("Set ban");
        }
    @GetMapping("/{id}/setnoban")
    public ResponseEntity<String> setNoBan(@PathVariable("id") Long id){
        organizationService.setActive(id, true);
        return ResponseEntity.ok("Set no ban");
    }
}
