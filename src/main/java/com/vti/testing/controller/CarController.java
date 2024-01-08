package com.vti.testing.controller;

import com.vti.testing.dto.CarDTO;
import com.vti.testing.entity.Car;
import com.vti.testing.form.car.CarFilterForm;
import com.vti.testing.form.car.CreatingCarForm;
import com.vti.testing.form.car.UpdatingCarForm;
import com.vti.testing.service.ICarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/cars")
public class CarController {
    @Autowired
    private ICarService carService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public Page<CarDTO> gerAllCars(Pageable pageable, CarFilterForm form){
        Page<Car> carPage = carService.getAllCars(pageable, form);
        List<Car> cars = carPage.getContent();
        List<CarDTO> carDTOS =
                cars.stream().map(car -> modelMapper.map(car, CarDTO.class))
                        .collect(Collectors.toList());
        return new PageImpl<>(carDTOS, pageable, carPage.getTotalElements());
    }

    @PostMapping ("/create")
    public ResponseEntity<String> createCar(@RequestBody CreatingCarForm form) {
        carService.createCar(form);
        return new ResponseEntity<>("Create successfully", HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCar(@PathVariable int id, @RequestBody UpdatingCarForm form) {
        form.setId(id);
        carService.updateCar(form);
        return new ResponseEntity<>("Update successfully", HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable int id) {
        carService.deleteCar(id);
        return new ResponseEntity<>("Delete successfully", HttpStatus.CREATED);
    }
}
