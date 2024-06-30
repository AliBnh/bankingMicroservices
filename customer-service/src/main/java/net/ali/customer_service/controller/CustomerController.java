package net.ali.customer_service.controller;

import lombok.AllArgsConstructor;
import net.ali.customer_service.entities.Customer;
import net.ali.customer_service.repositories.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }
    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        return customerRepository.findById(id).get();
    }
    @PostMapping("/customers")
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }
    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }




}
