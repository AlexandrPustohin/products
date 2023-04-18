package com.example.products.views;


import com.example.products.model.DTO.OrganizationDTO;
import com.example.products.services.OrganizationService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

//@PWA(name = "Cool Vaadin App", shortName = "my-app")
@Route("/vaad")
public class MainView extends VerticalLayout {
    private final OrganizationService organizationService;
    final Grid<OrganizationDTO> grid;

    public MainView(OrganizationService organizationService) {
        this.organizationService = organizationService;
        this.grid = new Grid<>(OrganizationDTO.class);
        add(grid);
        listOrganization();
    }

    private void listOrganization(){
        grid.setItems(organizationService.getAllOrganizations());
    }
}
