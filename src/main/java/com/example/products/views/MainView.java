package com.example.products.views;


import com.example.products.model.DTO.OrganizationDTO;
import com.example.products.services.OrganizationService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("/vaad")
public class MainView extends VerticalLayout {
    private final OrganizationService organizationService;
    Grid<OrganizationDTO> grid = new Grid<>(OrganizationDTO.class, false);;

    public MainView(OrganizationService organizationService) {
        this.organizationService = organizationService;
        addClassName("list-view");
        setSizeFull();
        configureGrid();
        listOrganization();
        add(grid);
    }

    private void listOrganization(){
        grid.setItems(organizationService.getAllOrganizations());
    }

    private void configureGrid() {
        grid.addClassNames("contact-grid");
        grid.setSizeFull();
        grid.addColumn(OrganizationDTO::getName).setHeader("Наименование");
        grid.addColumn(OrganizationDTO::getDescription).setHeader("Описание");
        grid.addColumn(OrganizationDTO::getLogo).setHeader("Логотип");

        grid.getColumns().forEach(col -> col.setAutoWidth(true));
    }
}
