package com.vti.testing.repository;

import com.vti.testing.dto.CustomerReceiveAlertPriceDto;
import com.vti.testing.entity.CustomerReceiveAlertPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface CustomerReceiveAlertPriceRepository
        extends JpaRepository<CustomerReceiveAlertPrice, Integer>, JpaSpecificationExecutor<CustomerReceiveAlertPrice> {
    Optional<CustomerReceiveAlertPriceDto> findById(int id);
}
