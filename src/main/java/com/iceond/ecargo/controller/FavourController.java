package com.iceond.ecargo.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.iceond.ecargo.common.URLConstant;
import com.iceond.ecargo.entity.FavourEntity;
import com.iceond.ecargo.entity.FavourEntity.Views;
import com.iceond.ecargo.entity.UserEntity;
import com.iceond.ecargo.entity.filter.FavourFilter;
import com.iceond.ecargo.entity.pagination.FavourPagination;
import com.iceond.ecargo.service.FavourService;
import com.iceond.ecargo.service.UserService;
import java.security.Principal;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController("FavourController")
@RequestMapping(value = URLConstant.FAVOURS)
@CrossOrigin(origins = "*", exposedHeaders = "Authorization")
public class FavourController {

  private final FavourService favourService;
  private final UserService userService;

  @Autowired
  public FavourController(FavourService favourService, UserService userService) {
    this.favourService = favourService;
    this.userService = userService;
  }



  @GetMapping(value="/{favourId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public FavourEntity getFavourById( @PathVariable("favourId") long favourId) {
    return this.favourService.getFavourById(favourId);
  }



  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  @JsonView(value = Views.Get.class)
  public FavourPagination getFavourList(
      @RequestParam(value = "userId", required = false) Long userId,
      @RequestParam(value = "categoryId", required = false) Long categoryId,
      @RequestParam(value = "page", required = false) Integer page,
      @RequestParam(value = "size", required = false) Integer size) {

    FavourFilter favourFilter = mapFavourFilter(page, size, userId, categoryId);

    return this.favourService.getFavourList(favourFilter);
  }

  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public void createFavour(Principal principal, @RequestBody FavourEntity favourEntity) {

    UserEntity user = this.userService.getUser(principal.getName());

    favourEntity.setUser(user);

    this.favourService.createFavour(favourEntity);
  }

  private FavourFilter mapFavourFilter(Integer page, Integer size, Long userId, Long categoryId) {

    FavourFilter favourFilter = new FavourFilter();

    Optional.ofNullable(page).ifPresent(favourFilter::setPage);
    Optional.ofNullable(size).ifPresent(favourFilter::setSize);
    Optional.ofNullable(userId).ifPresent(favourFilter::setUserId);
    Optional.ofNullable(categoryId).ifPresent(favourFilter::setCategoryId);

    return favourFilter;
  }
}
