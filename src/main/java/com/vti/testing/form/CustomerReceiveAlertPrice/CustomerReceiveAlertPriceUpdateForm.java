package com.vti.testing.form.CustomerReceiveAlertPrice;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerReceiveAlertPriceUpdateForm {
    private int id;
    private String fullName;
    private String phoneNumber;
    private String paymentMethod;
    private String email;
    private int accountId;
    private int carId;
}
