package com.vti.testing.service;

import com.vti.testing.form.customerTestDriving.CreateTestDrivingForm;
import com.vti.testing.form.customerTestDriving.TestDrivingFilterForm;
import com.vti.testing.form.customerTestDriving.UpdateTestDrivingForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface ICustomerTestDrivingService {
    Map<String, Object> createCustomerTestDriving(CreateTestDrivingForm form);

    Map<String, Object> getCustomerTestDrivingById(int id);
    Page<Map<String, Object>> getAllCustomerTestDrivings(Pageable pageable, TestDrivingFilterForm filterForm);

    Map<String, Object> updateCustomerTestDriving(int id, UpdateTestDrivingForm form);

    void deleteCustomerTestDriving(int id);
}
