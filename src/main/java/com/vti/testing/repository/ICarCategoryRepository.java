package com.vti.testing.repository;

import com.vti.testing.entity.CarCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICarCategoryRepository extends JpaRepository<CarCategory, Integer> {

    CarCategory findByName(String carCategoryName);

    void deleteById(int id);
}
