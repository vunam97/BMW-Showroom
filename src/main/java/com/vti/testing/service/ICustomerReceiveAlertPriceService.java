package com.vti.testing.service;

import com.vti.testing.dto.CustomerReceiveAlertPriceDto;
import com.vti.testing.form.customerReceiveAlertPrice.CustomerReceiveAlertPriceCreateForm;
import com.vti.testing.form.customerReceiveAlertPrice.CustomerReceiveAlertPriceFilterForm;
import com.vti.testing.form.customerReceiveAlertPrice.CustomerReceiveAlertPriceUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerReceiveAlertPriceService {
    Page<CustomerReceiveAlertPriceDto> findAll(CustomerReceiveAlertPriceFilterForm form, Pageable pageable);

    CustomerReceiveAlertPriceDto create (CustomerReceiveAlertPriceCreateForm form);

    CustomerReceiveAlertPriceDto update (CustomerReceiveAlertPriceUpdateForm form);

    void deleteById(int id);
}
