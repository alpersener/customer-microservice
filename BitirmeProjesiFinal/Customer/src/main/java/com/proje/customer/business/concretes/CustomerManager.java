package com.proje.customer.business.concretes;

import com.proje.customer.business.abstracts.CustomerService;
import com.proje.customer.business.requests.CreateCustomerRequest;
import com.proje.customer.business.requests.UpdateCustomerRequest;
import com.proje.customer.business.responses.FraudCheckResponse;
import com.proje.customer.business.responses.GetAllCustomersResponse;
import com.proje.customer.business.responses.GetByIdCustomerResponse;
import com.proje.customer.core.utilities.mappers.ModelMapperService;
import com.proje.customer.dataAccess.abstracts.CustomerRepository;
import com.proje.customer.entities.concretes.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CustomerManager implements CustomerService {
    private CustomerRepository customerRepository;
    private ModelMapperService modelMapperService;
    private RestTemplate restTemplate;


    @Override
    public List<GetAllCustomersResponse> getAll() {
        List<Customer> customers=customerRepository.findAll();
        List<GetAllCustomersResponse> customersResponse=customers.stream()
                .map(customer -> this.modelMapperService.forResponses()
                        .map(customer,GetAllCustomersResponse.class)).collect(Collectors.toList());
        return customersResponse;
    }

    @Override
    public void add(CreateCustomerRequest createCustomerRequest) {
        Customer customer=this.modelMapperService.forRequests().map(createCustomerRequest,Customer.class);
        this.customerRepository.saveAndFlush(customer);
        FraudCheckResponse fraudCheckResponse=restTemplate.getForObject("http://localhost:8081/api/fraud-check/{customerId}"
                , FraudCheckResponse.class,customer.getId());
        if(fraudCheckResponse.isFraudster())
            throw new IllegalStateException("Fraudster!");

    }

    @Override
    public void update(UpdateCustomerRequest updateCustomerRequest) {
        Customer customer=this.modelMapperService.forRequests().map(updateCustomerRequest,Customer.class);
        this.customerRepository.save(customer);

    }

    @Override
    public void delete(int id) {
        this.customerRepository.deleteById(id);

    }

    @Override
    public GetByIdCustomerResponse getById(int id) {
        Customer customer=this.customerRepository.findById(id).orElseThrow();
        GetByIdCustomerResponse response=this.modelMapperService.forResponses()
                .map(customer,GetByIdCustomerResponse.class);
        return response;
    }
}
