package com.megacitycabs.bookingsystem.service;

import com.megacitycabs.bookingsystem.model.Costomers;
import com.megacitycabs.bookingsystem.repository.CustomerRepository;
import com.megacitycabs.bookingsystem.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Costomers createCustomer(Costomers customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Costomers getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
    }

    @Override
    public List<Costomers> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Costomers updateCustomer(Long id, Costomers customerDetails) {
        Costomers customer = getCustomerById(id);
        customer.setName(customerDetails.getName());
        customer.setAddress(customerDetails.getAddress());
        customer.setNic(customerDetails.getNic());
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
    @Override
    public Costomers getCustomerByUserId(Long userId) {
        Optional<Costomers> customer = customerRepository.findByUserId(userId);
        return customer.orElse(null);
    }
}
