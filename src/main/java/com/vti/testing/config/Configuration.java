package com.vti.testing.config;

import com.vti.testing.entity.CustomerReceiveAlertPrice;
import com.vti.testing.form.CustomerReceiveAlertPrice.CustomerReceiveAlertPriceCreateForm;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    public ModelMapper initModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.typeMap(CustomerReceiveAlertPriceCreateForm.class, CustomerReceiveAlertPrice.class)
                .addMappings(mapping -> mapping.skip(CustomerReceiveAlertPrice::setId));
        return modelMapper;
    }
}
