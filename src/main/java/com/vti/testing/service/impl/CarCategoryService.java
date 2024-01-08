package com.vti.testing.service.impl;

import com.vti.testing.entity.CarCategory;
import com.vti.testing.form.carCategory.CreatingCarCategoryForm;
import com.vti.testing.form.carCategory.UpdatingCarCategoryForm;
import com.vti.testing.repository.ICarCategoryRepository;
import com.vti.testing.service.ICarCategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class CarCategoryService implements ICarCategoryService {

    @Autowired
    private ICarCategoryRepository carCategoryRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Page<CarCategory> getAllCarCategories(Pageable pageable) {
        return carCategoryRepository.findAll(pageable);
    }

    @Override
    public void createCarCategory(CreatingCarCategoryForm form) {
        CarCategory carCategory = modelMapper.map(form , CarCategory.class);
        carCategoryRepository.save(carCategory);
    }

    @Override
    public void updateCarCategory(UpdatingCarCategoryForm form) {
        CarCategory carCategory = modelMapper.map(form , CarCategory.class);
        carCategoryRepository.save(carCategory);
    }

    @Override
    public void deleteCarCategory(int id) {
        carCategoryRepository.deleteById(id);
    }

}
