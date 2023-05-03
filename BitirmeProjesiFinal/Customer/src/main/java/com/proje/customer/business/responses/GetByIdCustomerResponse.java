package com.proje.customer.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor

public class GetByIdCustomerResponse {
    private int id;
    private String name;
    private String eMail;
}
