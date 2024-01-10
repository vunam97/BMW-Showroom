package com.vti.testing.repository;

import com.vti.testing.entity.CustomerReceiveAlertPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CustomerReceiveAlertPriceRepository
        extends JpaRepository<CustomerReceiveAlertPrice, Integer>, JpaSpecificationExecutor<CustomerReceiveAlertPrice> {
}
