package com.aaronthompson.service;

import com.aaronthompson.model.Invoice;
import com.aaronthompson.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class InvoiceService {
    private final UserService userService;

    List<Invoice> invoices = new CopyOnWriteArrayList<>();

    public InvoiceService(UserService userService) {
        this.userService = userService;
    }

    public List<Invoice> findAll() {
        return invoices;
    }

    public Invoice create(String userId, Integer amount) {
        User user = userService.findById(userId);
        if (user == null) {
            throw new IllegalStateException();
        }

        // TODO real PDF creation on network server
        Invoice invoice = new Invoice(userId, "http://www.africau.edu/images/default/sample.pdf", amount);
        invoices.add(invoice);
        return invoice;
    }
}
