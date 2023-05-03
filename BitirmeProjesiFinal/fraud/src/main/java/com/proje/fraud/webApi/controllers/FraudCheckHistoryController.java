package com.proje.fraud.webApi.controllers;

import com.proje.fraud.business.abstracts.FraudCheckHistoryService;
import com.proje.fraud.business.responses.FraudCheckResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/fraud-check")
@AllArgsConstructor
public class FraudCheckHistoryController {
    private final FraudCheckHistoryService fraudCheckHistoryService;

    @GetMapping(path="{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId){
        boolean isFradudulentCustomer=fraudCheckHistoryService.isFraudulentCustomer(customerId);
        return new FraudCheckResponse(isFradudulentCustomer);

    }
}
