package com.proje.customer.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCustomersResponse {
    private int id;
    private String name;
    private String eMail;
    private int phoneNumber;
}
