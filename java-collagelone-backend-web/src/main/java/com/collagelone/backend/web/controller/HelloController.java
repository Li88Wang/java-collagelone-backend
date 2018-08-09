package com.collagelone.backend.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController extends BaseController{
  @RequestMapping("/hello")
  public String hello(){
    System.out.print(1/0);
    return "screen/backend/index";
  }
  @RequestMapping("/helloAjax")
  @ResponseBody
  public String helloAjax(){
    return "小测试一把";
  }
}
