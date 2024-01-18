package com.vti.testing.form.customerTestDriving;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateTestDrivingForm {
    private String fullName;
    private String carName;
    private String phoneNumber;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateTestDriving;

}