package com.jorge.curso.springboot.di.factura.springboot.difactura.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@RequestScope
// @JsonIgnoreProperties({"advisors"})
public class Invoice {

    private Client client;

    @Value("${invoice.description}")
    private String description;

    private List<Item> items;


    public Invoice(Client client, @Qualifier("itemsInvoiceOffice") List<Item> items) {
        this.client = client;
        this.items = items;
    }

    @PostConstruct
    public void init() {
        client.setName(client.getName().concat(" prueba"));
        description = description.concat(" del cliente: ").concat(client.getName()).concat(" ")
                .concat(client.getLastname());
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Invoice destroyed: ".concat(description));
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getTotal() {
        return items.stream().mapToInt(i -> i.getImporte()).sum();
    }
}
