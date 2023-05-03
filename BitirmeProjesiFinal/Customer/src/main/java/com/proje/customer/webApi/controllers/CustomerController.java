package com.proje.customer.webApi.controllers;

import com.proje.customer.business.abstracts.CustomerService;
import com.proje.customer.business.requests.CreateCustomerRequest;
import com.proje.customer.business.requests.UpdateCustomerRequest;
import com.proje.customer.business.responses.GetAllCustomersResponse;
import com.proje.customer.business.responses.GetByIdCustomerResponse;
import jakarta.ws.rs.Path;
import lombok.AllArgsConstructor;
import org.hibernate.sql.Update;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomerController {
    private CustomerService customerService;

    @GetMapping()
    public List<GetAllCustomersResponse> getAll(){
        return customerService.getAll();
    }
    @GetMapping("/{id}")
    public GetByIdCustomerResponse getById(@PathVariable int id){
        return customerService.getById(id);

    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody CreateCustomerRequest createCustomerRequest){
        this.customerService.add(createCustomerRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateCustomerRequest updateCustomerRequest){
        this.customerService.update(updateCustomerRequest);

    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.customerService.delete(id);
    }

}
