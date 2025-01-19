package com.app.store.configuration.data;

import com.app.store.configuration.security.entity.User;
import com.app.store.configuration.security.repository.UserRepository;
import com.app.store.entity.Customer;
import com.app.store.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Data creator
 * Create test data in the database. This class is not necessary in real development and production environments
 */
@Component
@Slf4j
public class DataInitializer implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    private final UserRepository userRepository;

    public DataInitializer(CustomerRepository customerRepository, UserRepository userRepository) {
        this.customerRepository = customerRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        /**
         * Customer test data
         */
        this.customerRepository.save(Customer.builder()
                .fullName("John Doe")
                .email("john@example.com")
                .address("USA")
                .build());
        this.customerRepository.save(Customer.builder()
                .fullName("Jane Smith")
                .email("jane@example.com")
                .address("MEXICO")
                .build());
        this.customerRepository.save(Customer.builder()
                .fullName("Carlos Martinez")
                .email("carlos@example.com")
                .address("EL SALVADOR")
                .build());
        log.info("Run: Insert 3 customers");
        /**
         * User test data
         */
        User testUser = new User();
        testUser.setFullName("Carlos Martinez");
        testUser.setEmail("carlos@test.com");
        testUser.setPassword("12345");
        //this.userRepository.save(testUser);
        log.info("Run: Insert 1 user");
    }

}
