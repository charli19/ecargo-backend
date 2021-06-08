package com.iceond.ecargo.controller;

import com.iceond.ecargo.common.URLConstant;
import com.iceond.ecargo.entity.CategoryEntity;
import com.iceond.ecargo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("CategoryController")
@RequestMapping(value = URLConstant.CATEGORIES)
@CrossOrigin(origins = "*")
public class CategoryController {

  private final CategoryService categoryService;

  @Autowired
  public CategoryController(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  //@PreAuthorize("isAuthenticated()")
  public List<CategoryEntity> getCategoryList() {

    return this.categoryService.getCategoryList();
  }
}
