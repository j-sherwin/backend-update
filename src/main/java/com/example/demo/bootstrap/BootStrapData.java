package com.example.demo.bootstrap;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.DivisionRepository;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (customerRepository.count() == 1) {
            Division d1 = divisionRepository.findById(10L).orElse(null);
            Division d2 = divisionRepository.findById(24L).orElse(null);
            Division d3 = divisionRepository.findById(32L).orElse(null);
            Division d4 = divisionRepository.findById(67L).orElse(null);
            Division d5 = divisionRepository.findById(65L).orElse(null);

            Customer customer1 = new Customer("Jason", "Bourne", "1244 Test St", "37449", "(548)892-2233", d1);
            customerRepository.save(customer1);

            Customer customer2 = new Customer("Fred", "Flinstone", "201 Cobblestone Lane", "03229", "(222)555-4222", d2);
            customerRepository.save(customer2);

            Customer customer3 = new Customer("Susan", "Doe", "991 Market Ave", "83751", "(123)456-2888", d3);
            customerRepository.save(customer3);

            Customer customer4 = new Customer("AJ", "Smith", "8822 Carolina St", "19228", "(448)321-4001", d4);
            customerRepository.save(customer4);

            Customer customer5 = new Customer("Linda", "Myers", "131 Boneyard Ct", "93399", "(944)927-6399", d5);
            customerRepository.save(customer5);
        }

    }
}
