package com.item.web.controller;

import com.restful.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

  @GetMapping("/hello")
  public Result demo1() {
    return Result.success("hello");
  }

  @GetMapping("/out")
  public String demo2(){
    return "out";
  }

}
