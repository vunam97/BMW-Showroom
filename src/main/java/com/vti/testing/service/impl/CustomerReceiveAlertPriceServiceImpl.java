package com.vti.testing.service.impl;

import com.vti.testing.dto.CustomerReceiveAlertPriceDto;
import com.vti.testing.entity.Account;
import com.vti.testing.entity.Car;
import com.vti.testing.entity.CustomerReceiveAlertPrice;
import com.vti.testing.form.CustomerReceiveAlertPrice.CustomerReceiveAlertPriceCreateForm;
import com.vti.testing.form.CustomerReceiveAlertPrice.CustomerReceiveAlertPriceFilterForm;
import com.vti.testing.form.CustomerReceiveAlertPrice.CustomerReceiveAlertPriceUpdateForm;
import com.vti.testing.repository.CustomerReceiveAlertPriceRepository;
import com.vti.testing.service.ICustomerReceiveAlertPriceService;
import com.vti.testing.specification.CustomerReceiveAlertPriceSpecification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class CustomerReceiveAlertPriceServiceImpl implements ICustomerReceiveAlertPriceService {
    @Autowired
    private CustomerReceiveAlertPriceRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Page<CustomerReceiveAlertPriceDto> findAll(CustomerReceiveAlertPriceFilterForm form, Pageable pageable) {
        var spec = CustomerReceiveAlertPriceSpecification.buildSpec(form);
        return repository.findAll(spec, pageable)
                .map(customerReceiveAlertPriceDto ->
                        modelMapper.map(customerReceiveAlertPriceDto, CustomerReceiveAlertPriceDto.class));
    }

    @Override
    public CustomerReceiveAlertPriceDto create(CustomerReceiveAlertPriceCreateForm form) {
        CustomerReceiveAlertPrice customerReceiveAlertPrice = modelMapper.map(form, CustomerReceiveAlertPrice.class);
        var car = new Car();
        car.setId(form.getCarId());
        var account = new Account();
        account.setId(form.getAccountId());
        customerReceiveAlertPrice.setCar(car);
        customerReceiveAlertPrice.setAccount(account);
        var savedCustomerReceiveAlertPrice = repository.save(customerReceiveAlertPrice);
        return modelMapper.map(savedCustomerReceiveAlertPrice, CustomerReceiveAlertPriceDto.class);
    }

    @Override
    public CustomerReceiveAlertPriceDto create(CustomerReceiveAlertPriceUpdateForm form) {
        CustomerReceiveAlertPrice customerReceiveAlertPrice = modelMapper.map(form, CustomerReceiveAlertPrice.class);
        var savedCustomerReceiveAlertPrice = repository.save(customerReceiveAlertPrice);
        return modelMapper.map(savedCustomerReceiveAlertPrice, CustomerReceiveAlertPriceDto.class);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
