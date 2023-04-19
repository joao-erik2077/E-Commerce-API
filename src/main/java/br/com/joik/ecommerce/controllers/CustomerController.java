package br.com.joik.ecommerce.controllers;

import br.com.joik.ecommerce.models.Customer;
import br.com.joik.ecommerce.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/all")
    private ResponseEntity<List<Customer>> getAll() {
        return customerService.getAll();
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> getWithId(@PathVariable("id") Long id) {
        return customerService.getWithId(id);
    }

    @PostMapping
    private ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }
}
