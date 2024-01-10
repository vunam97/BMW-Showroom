package com.vti.testing.service;

import com.vti.testing.dto.CustomerReceiveAlertPriceDto;
import com.vti.testing.form.CustomerReceiveAlertPrice.CustomerReceiveAlertPriceCreateForm;
import com.vti.testing.form.CustomerReceiveAlertPrice.CustomerReceiveAlertPriceFilterForm;
import com.vti.testing.form.CustomerReceiveAlertPrice.CustomerReceiveAlertPriceUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerReceiveAlertPriceService {
    Page<CustomerReceiveAlertPriceDto> findAll(CustomerReceiveAlertPriceFilterForm form, Pageable pageable);

    CustomerReceiveAlertPriceDto create (CustomerReceiveAlertPriceCreateForm form);

    CustomerReceiveAlertPriceDto create (CustomerReceiveAlertPriceUpdateForm form);

    void deleteById(int id);
}
