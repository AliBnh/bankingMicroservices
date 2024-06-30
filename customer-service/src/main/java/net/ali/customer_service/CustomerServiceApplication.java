package net.ali.customer_service;

import net.ali.customer_service.config.GlobalConfig;
import net.ali.customer_service.entities.Customer;
import net.ali.customer_service.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

	@Autowired
	private CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			List<Customer> customerList = List.of(
					Customer.builder()
							.firstName("Ali")
							.lastName("Khan")
							.email("test@mail.com")
							.build(),
					Customer.builder()
							.firstName("Ali")
							.lastName("Khan")
							.email("test@mail.com")
							.build()
			);
			customerRepository.saveAll(customerList);
		};
	}
}
