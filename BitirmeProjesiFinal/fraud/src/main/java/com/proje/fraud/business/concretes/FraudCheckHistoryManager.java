package com.proje.fraud.business.concretes;

import com.proje.fraud.business.abstracts.FraudCheckHistoryService;
import com.proje.fraud.dataAccess.abstracts.FraudCheckHistoryRepository;
import com.proje.fraud.entities.concretes.FraudCheckHistory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckHistoryManager implements FraudCheckHistoryService {
    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    @Override
    public boolean isFraudulentCustomer(Integer customerId) {
        fraudCheckHistoryRepository.save(
                FraudCheckHistory.builder()
                        .isFraudster(false)
                        .customerId(customerId)
                        .createdAt(LocalDateTime.now())
                        .build()
        );

        return false;
    }
}
