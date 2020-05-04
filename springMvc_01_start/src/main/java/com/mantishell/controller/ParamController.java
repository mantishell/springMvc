package com.mantishell.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/param")
public class ParamController {

    @RequestMapping("/testParam")
    public String testParam(String userName){
        System.out.println("用户名" + userName);
        return "success";
    }
}
