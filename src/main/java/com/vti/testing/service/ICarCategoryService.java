package com.vti.testing.service;

import com.vti.testing.entity.CarCategory;
import com.vti.testing.form.car.CreatingCarForm;
import com.vti.testing.form.car.UpdatingCarForm;
import com.vti.testing.form.carCategory.CreatingCarCategoryForm;
import com.vti.testing.form.carCategory.UpdatingCarCategoryForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICarCategoryService {
    Page<CarCategory> getAllCarCategories(Pageable pageable);
    void createCarCategory(CreatingCarCategoryForm form);
    void updateCarCategory(UpdatingCarCategoryForm form);
    void deleteCarCategory(int id);
}
