package net.ali.account_service.clients;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import net.ali.account_service.models.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @CircuitBreaker(name = "customerService", fallbackMethod = "getDefaultCustomer")
    @GetMapping("/customers/{id}")
    Customer findCustomerById(@PathVariable Long id);

    @CircuitBreaker(name = "customerService", fallbackMethod = "getDefaultCustomers")
    @GetMapping("/customers")
    List<Customer> allCustomers();

    default Customer getDefaultCustomer(Long id, Exception exception) {
        return new Customer(id, "Customer not available", "Customer not available", "Customer not available");
    }
    default List<Customer> getDefaultCustomers(Exception exception) {
        return List.of(new Customer(0L, "Customer not available", "Customer not available", "Customer not available"));
    }
}
