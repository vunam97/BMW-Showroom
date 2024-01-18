package com.vti.testing.service.impl;

import com.vti.testing.entity.Car;
import com.vti.testing.entity.CustomerTestDriving;
import com.vti.testing.form.customerTestDriving.CreateTestDrivingForm;
import com.vti.testing.form.customerTestDriving.TestDrivingFilterForm;
import com.vti.testing.form.customerTestDriving.UpdateTestDrivingForm;
import com.vti.testing.repository.CustomerTestDrivingRepository;
import com.vti.testing.repository.ICarRepository;
import com.vti.testing.service.ICustomerTestDrivingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class CustomerTestDrivingServiceImpl implements ICustomerTestDrivingService {
    @Autowired
    private CustomerTestDrivingRepository customerTestDrivingRepository;

    @Autowired
    private ICarRepository carRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public Page<Map<String, Object>> getAllCustomerTestDrivings(Pageable pageable, TestDrivingFilterForm filterForm) {
        Page<CustomerTestDriving> result;
        if (filterForm != null) {
            if (filterForm.getSearch() != null && !filterForm.getSearch().isEmpty()) {
                result = customerTestDrivingRepository.findByFullNameContainingIgnoreCaseOrPhoneNumberContaining(filterForm.getSearch(), filterForm.getSearch(), pageable);
            } else {
                result = customerTestDrivingRepository.findAll(pageable);
            }
        } else {
            result = customerTestDrivingRepository.findAll(pageable);
        }

        return result.map(this::mapToResponse);
    }


    //    @Override
//    public CustomerTestDriving getCustomerTestDrivingById(int id) {
//        Optional<CustomerTestDriving> optionalCustomerTestDriving = customerTestDrivingRepository.findById(id);
//        return optionalCustomerTestDriving.orElse(null);
//    }
    @Override
    public Map<String, Object> getCustomerTestDrivingById(int id) {
        Optional<CustomerTestDriving> optionalCustomerTestDriving = customerTestDrivingRepository.findById(id);

        if (optionalCustomerTestDriving.isPresent()) {
            CustomerTestDriving customerTestDriving = optionalCustomerTestDriving.get();
            return mapToResponse(customerTestDriving);
        } else {
            return null;
        }
    }


    @Override
    public Map<String, Object> createCustomerTestDriving(CreateTestDrivingForm form) {
        Optional<Car> optionalCar = carRepository.findByName(form.getCarName());
        if (optionalCar.isPresent()) {
            Car car = optionalCar.get();

            CustomerTestDriving customerTestDriving = new CustomerTestDriving();
            customerTestDriving.setFullName(form.getFullName());
            customerTestDriving.setPhoneNumber(form.getPhoneNumber());
            customerTestDriving.setDateTestDriving(form.getDateTestDriving());
            customerTestDriving.setCar(car);

            CustomerTestDriving createdEntity = customerTestDrivingRepository.save(customerTestDriving);
            return mapToResponse(createdEntity); // Return the mapped response
        } else {
            return null;
        }
    }

    @Override
    public Map<String, Object> updateCustomerTestDriving(int id, UpdateTestDrivingForm form) {
        Optional<CustomerTestDriving> optionalEntity = customerTestDrivingRepository.findById(id);

        if (optionalEntity.isPresent()) {
            CustomerTestDriving existingEntity = optionalEntity.get();

            existingEntity.setFullName(form.getFullName());
            existingEntity.setPhoneNumber(form.getPhoneNumber());
            existingEntity.setDateTestDriving(form.getDateTestDriving());

            Optional<Car> optionalCar = carRepository.findByName(form.getCarName());
            if (optionalCar.isPresent()) {
                Car car = optionalCar.get();
                existingEntity.setCar(car);

                CustomerTestDriving updatedEntity = customerTestDrivingRepository.save(existingEntity);
                return mapToResponse(updatedEntity); // Return the mapped response
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    //    private Map<String, Object> mapToResponse(CustomerTestDriving customerTestDriving) {
//        Map<String, Object> response = new HashMap<>();
//        response.put("id", customerTestDriving.getId());
//        response.put("fullName", customerTestDriving.getFullName());
//        response.put("phoneNumber", customerTestDriving.getPhoneNumber());
//        response.put("dateTestDriving", customerTestDriving.getDateTestDriving());
//        response.put("carName", mapCarToResponse(customerTestDriving.getCar()));
//        return response;
//    }
//
//    private Map<String, Object> mapCarToResponse(Car car) {
//        Map<String, Object> carResponse = new HashMap<>();
//        carResponse.put("name", car.getName());
//        return carResponse;
//    }
    private Map<String, Object> mapToResponse(CustomerTestDriving customerTestDriving) {
        Map<String, Object> response = new HashMap<>();
        response.put("id", customerTestDriving.getId());
        response.put("fullName", customerTestDriving.getFullName());
        response.put("phoneNumber", customerTestDriving.getPhoneNumber());
        response.put("dateTestDriving", customerTestDriving.getDateTestDriving());
        response.put("carName", customerTestDriving.getCar().getName()); // Thêm carName vào response
        return response;
    }

    private Map<String, Object> mapCarToResponse(Car car) {
        Map<String, Object> carResponse = new HashMap<>();
        carResponse.put("name", car.getName());
        return carResponse;
    }


    @Override
    public void deleteCustomerTestDriving(int id) {
        customerTestDrivingRepository.deleteById(id);
    }
}
