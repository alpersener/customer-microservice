package com.proje.customer.dataAccess.abstracts;

import com.proje.customer.entities.concretes.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer>{


}
