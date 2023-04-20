package br.com.joik.ecommerce.services;

import br.com.joik.ecommerce.models.Customer;
import br.com.joik.ecommerce.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public ResponseEntity<List<Customer>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(customerRepository.findAll());
    }

    public ResponseEntity<?> getWithId(Long id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if (customerOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(customerOptional.get());
    }

    public ResponseEntity<?> addCustomer(Customer customer) {
        customer.setPassword(customer.generatePasswordHash(customer.getPassword()));
        Customer savedCustomer = customerRepository.save(customer);
        return ResponseEntity.ok("Customer added");
    }
}
