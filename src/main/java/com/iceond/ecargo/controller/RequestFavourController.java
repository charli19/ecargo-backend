package com.iceond.ecargo.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.iceond.ecargo.common.URLConstant;
import com.iceond.ecargo.entity.RequestFavourEntity.Views;
import com.iceond.ecargo.entity.RequestFavourEntity;
import com.iceond.ecargo.entity.UserEntity;
import com.iceond.ecargo.entity.filter.RequestFavourFilter;
import com.iceond.ecargo.entity.pagination.RequestFavourPagination;
import com.iceond.ecargo.service.RequestFavourService;
import com.iceond.ecargo.service.UserService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;



import java.security.Principal;

@RestController("RequestFavourController")
@RequestMapping(value = URLConstant.REQUEST_FAVOURS)
@CrossOrigin(origins = "*", exposedHeaders = "Authorization")
public class RequestFavourController {

  private RequestFavourService requestFavourService;
  private final UserService userService;

  @Autowired
  public RequestFavourController(RequestFavourService requestFavourService, UserService userService) {
    this.requestFavourService = requestFavourService;
    this.userService = userService;
  }


  @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
  public void createRequestFavour(Principal principal, @RequestBody RequestFavourEntity requestFavourEntity) {

    UserEntity user = this.userService.getUser(principal.getName());

    requestFavourEntity.setWorker(user);

    this.requestFavourService.createRequestFavour(requestFavourEntity);
  }


  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  @JsonView(value = Views.Get.class)
  public RequestFavourPagination getRequestFavourList(
      @RequestParam(value = "page", required = false) Integer page,
      @RequestParam(value = "size", required = false) Integer size,
      @RequestParam(value = "favourId", required = false) Long favourId) {

    RequestFavourFilter requestFavourFilter = mapRequestFavourFilter(page, size, favourId);

    return this.requestFavourService.getRequestFavourList(requestFavourFilter);
  }


  @DeleteMapping(value="/{requestFavourId}", produces = MediaType.APPLICATION_JSON_VALUE)
  //@PreAuthorize("hasAuthority('user')")
  public void deleteRequestFavour(@PathVariable("requestFavourId") long requestFavourId) {
    this.requestFavourService.deleteRequestFavour(requestFavourId);
  }

  private RequestFavourFilter mapRequestFavourFilter(Integer page, Integer size, Long favourId) {

    RequestFavourFilter requestFavourFilter = new RequestFavourFilter();

    Optional.ofNullable(page).ifPresent(requestFavourFilter::setPage);
    Optional.ofNullable(size).ifPresent(requestFavourFilter::setSize);
    Optional.ofNullable(favourId).ifPresent(requestFavourFilter::setFavourId);

    return requestFavourFilter;
  }


}
