package com.jorge.curso.springboot.di.factura.springboot.difactura.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jorge.curso.springboot.di.factura.springboot.difactura.models.Client;
import com.jorge.curso.springboot.di.factura.springboot.difactura.models.Invoice;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    private Invoice invoice;

    public InvoiceController(Invoice invoice) {
        this.invoice = invoice;
    }

    @RequestMapping(path = "/show", method = RequestMethod.GET)
    public Invoice show() {
        Client client = new Client();
        client.setName(invoice.getClient().getName());
        client.setLastname(invoice.getClient().getLastname());
        Invoice i = new Invoice(client, invoice.getItems());
        i.setDescription(invoice.getDescription());
        return i;
    }
}
