package com.iceond.ecargo.service.impl;

import com.iceond.ecargo.entity.CategoryEntity;
import com.iceond.ecargo.repository.CategoryRepository;
import com.iceond.ecargo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

  private final CategoryRepository categoryRepository;

  @Autowired
  public CategoryServiceImpl(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  @Override
  public List<CategoryEntity> getCategoryList() {

    return categoryRepository.findAll();
  }
}
