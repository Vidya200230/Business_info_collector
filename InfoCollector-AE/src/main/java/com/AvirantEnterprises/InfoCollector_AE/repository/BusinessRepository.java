package com.AvirantEnterprises.InfoCollector_AE.repository;

import com.AvirantEnterprises.InfoCollector_AE.model.BusinessEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessRepository extends JpaRepository<BusinessEntity, Long> {
    // You can add custom queries if needed
}
