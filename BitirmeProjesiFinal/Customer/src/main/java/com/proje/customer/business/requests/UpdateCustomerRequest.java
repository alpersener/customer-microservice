package com.proje.customer.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCustomerRequest {
    private int id;
    private String name;
    private String eMail;
    private int phoneNumber;

}
