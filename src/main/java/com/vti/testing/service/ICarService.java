package com.vti.testing.service;

import com.vti.testing.entity.Car;
import com.vti.testing.form.car.CarFilterForm;
import com.vti.testing.form.car.CreatingCarForm;
import com.vti.testing.form.car.UpdatingCarForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICarService {
   Page<Car> getAllCars(Pageable pageable, CarFilterForm form);
   Car getCarById(int id);
   Car createCar(CreatingCarForm form);
   Car updateCar(UpdatingCarForm form);
   void deleteCar(int id);

}
