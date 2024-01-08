package com.vti.testing.service.impl;

import com.vti.testing.entity.Car;
import com.vti.testing.entity.CarCategory;
import com.vti.testing.form.car.CarFilterForm;
import com.vti.testing.form.car.CreatingCarForm;
import com.vti.testing.form.car.UpdatingCarForm;
import com.vti.testing.repository.ICarCategoryRepository;
import com.vti.testing.repository.ICarRepository;
import com.vti.testing.service.ICarService;
import com.vti.testing.specification.CarSpecification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class CarService implements ICarService {
    @Autowired
    private ICarRepository carRepository;

    @Autowired
    private ICarCategoryRepository carCategoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Page<Car> getAllCars(Pageable pageable, CarFilterForm form) {
        Specification<Car> where = CarSpecification.buildWhere(form);
        return carRepository.findAll(where, pageable);
    }

    @Override
    public void createCar(@Valid CreatingCarForm form) {
        Car car = modelMapper.map(form, Car.class);
        CarCategory carCategory = carCategoryRepository.findByName(form.getCarCategoryName());
        car.setCarCategory(carCategory);
        carRepository.save(car);
    }

    @Override
    public void updateCar(UpdatingCarForm form) {
        Car car = modelMapper.map(form, Car.class);
        CarCategory carCategory = carCategoryRepository.findByName(form.getCarCategoryName());
        car.setCarCategory(carCategory);
        carRepository.save(car);
    }

    @Override
    public void deleteCar(int id) {
        carRepository.deleteById(id);
    }
}
