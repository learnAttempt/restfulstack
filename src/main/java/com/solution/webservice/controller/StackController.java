package com.solution.webservice.controller;

import com.solution.webservice.service.StackService;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/stack")
@RestController
@CrossOrigin
public class StackController {

  @Autowired
  StackService stackService;

  @GetMapping
  public Integer top() {
      return stackService.get();
  }


  @PostMapping(value="/{ele}")
  public Integer push(@PathVariable("ele") @NotNull Integer ele) {
     return stackService.push(ele);
  }


  @PostMapping
  public Integer pop() {
    return stackService.pop();
  }
}
