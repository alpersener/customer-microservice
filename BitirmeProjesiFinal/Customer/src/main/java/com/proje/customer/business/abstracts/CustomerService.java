package com.proje.customer.business.abstracts;

import com.proje.customer.business.requests.CreateCustomerRequest;
import com.proje.customer.business.requests.UpdateCustomerRequest;
import com.proje.customer.business.responses.GetAllCustomersResponse;
import com.proje.customer.business.responses.GetByIdCustomerResponse;

import java.util.List;

public interface CustomerService {
    List<GetAllCustomersResponse> getAll();
    void add(CreateCustomerRequest createCustomerRequest);
    void update(UpdateCustomerRequest updateCustomerRequest);
    void delete(int id);
    GetByIdCustomerResponse getById(int id);

}
