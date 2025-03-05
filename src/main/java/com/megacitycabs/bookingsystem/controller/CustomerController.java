package com.megacitycabs.bookingsystem.controller;

import com.megacitycabs.bookingsystem.model.Costomers;

import com.megacitycabs.bookingsystem.model.Users;
import com.megacitycabs.bookingsystem.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @PostMapping("/add")
    public ResponseEntity<Costomers> add(@RequestBody Costomers customer){
        Costomers newCustomer = customerService.createCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCustomer);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Costomers>> getAllCustomers() {
        List<Costomers> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Costomers> getCustomerById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Costomers> updateCustomer(@PathVariable Long id, @RequestBody Costomers customer) {
        return ResponseEntity.ok(customerService.updateCustomer(id, customer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
