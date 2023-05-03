package com.proje.fraud.dataAccess.abstracts;

import com.proje.fraud.entities.concretes.FraudCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudCheckHistoryRepository extends JpaRepository<FraudCheckHistory,Integer> {
}
