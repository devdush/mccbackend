package com.megacitycabs.bookingsystem.service;

import com.megacitycabs.bookingsystem.model.Costomers;

import java.util.List;

public interface CustomerService {
    Costomers createCustomer(Costomers customer);
    Costomers getCustomerById(Long id);
    List<Costomers> getAllCustomers();
    Costomers updateCustomer(Long id, Costomers customer);
    void deleteCustomer(Long id);
    Costomers getCustomerByUserId(Long userId);
}
