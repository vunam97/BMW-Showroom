package com.vti.testing.controller;

import com.vti.testing.form.customerTestDriving.CreateTestDrivingForm;
import com.vti.testing.form.customerTestDriving.TestDrivingFilterForm;
import com.vti.testing.form.customerTestDriving.UpdateTestDrivingForm;
import com.vti.testing.service.ICustomerTestDrivingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/customerTestDriving")
public class CustomerTestDrivingController {

    @Autowired
    private ICustomerTestDrivingService customerTestDrivingService;


//    @GetMapping
//    public ResponseEntity<Page<CustomerTestDriving>> getAllCustomerTestDrivings(Pageable pageable,
//                                                                                @ModelAttribute TestDrivingFilterForm filterForm) {
//        Page<CustomerTestDriving> customerTestDrivings = customerTestDrivingService.getAllCustomerTestDrivings(pageable, filterForm);
//        return ResponseEntity.ok(customerTestDrivings);
//    }

    @GetMapping
    public ResponseEntity<Page<Map<String, Object>>> getAllCustomerTestDrivings(Pageable pageable,
                                                                                @ModelAttribute TestDrivingFilterForm filterForm) {
        Page<Map<String, Object>> customerTestDrivings = customerTestDrivingService.getAllCustomerTestDrivings(pageable, filterForm);
        return ResponseEntity.ok(customerTestDrivings);
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createCustomerTestDriving(@RequestBody CreateTestDrivingForm form) {
        Map<String, Object> createdCustomerTestDriving = customerTestDrivingService.createCustomerTestDriving(form);
        if (createdCustomerTestDriving != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomerTestDriving);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getCustomerTestDrivingById(@PathVariable int id) {
        Map<String, Object> customerTestDriving = customerTestDrivingService.getCustomerTestDrivingById(id);
        if (customerTestDriving != null) {
            return ResponseEntity.ok(customerTestDriving);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Map<String, Object>> updateCustomerTestDriving(@PathVariable int id, @RequestBody UpdateTestDrivingForm form) {
        Map<String, Object> updatedCustomerTestDriving = customerTestDrivingService.updateCustomerTestDriving(id, form);
        if (updatedCustomerTestDriving != null) {
            return ResponseEntity.ok(updatedCustomerTestDriving);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomerTestDriving(@PathVariable int id) {
        customerTestDrivingService.deleteCustomerTestDriving(id);
        return ResponseEntity.noContent().build();
    }
}