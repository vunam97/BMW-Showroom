package com.vti.testing.controller;

import com.vti.testing.dto.CustomerReceiveAlertPriceDto;
import com.vti.testing.form.customerReceiveAlertPrice.CustomerReceiveAlertPriceCreateForm;
import com.vti.testing.form.customerReceiveAlertPrice.CustomerReceiveAlertPriceFilterForm;
import com.vti.testing.form.customerReceiveAlertPrice.CustomerReceiveAlertPriceUpdateForm;
import com.vti.testing.service.ICustomerReceiveAlertPriceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CustomerReceiveAlertPriceController {
    @Autowired
    private ICustomerReceiveAlertPriceService service;

    @Autowired
    public ModelMapper modelMapper;

    @GetMapping("/customerReceiveAlertPrice")
    public Page<CustomerReceiveAlertPriceDto> findAll(CustomerReceiveAlertPriceFilterForm form, Pageable pageable) {
        return service.findAll(form, pageable);
    }

    @PostMapping("/customerReceiveAlertPrice")
    public CustomerReceiveAlertPriceDto create (@RequestBody CustomerReceiveAlertPriceCreateForm form) {
        return service.create(form);
    }

    @PutMapping("/customerReceiveAlertPrice/{id}")
    public CustomerReceiveAlertPriceDto update (@RequestBody CustomerReceiveAlertPriceUpdateForm form, @PathVariable("id") int id) {
        form.setId(id);
        return service.update(form);
    }

    @DeleteMapping("/customerReceiveAlertPrice/{id}")
    public void deleteById(@PathVariable("id") int id) {
        service.deleteById(id);
    }
}
