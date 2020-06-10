package com.mantishell.controller;

import com.mantishell.exception.SimpleException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testException")
    public String testException() throws SimpleException {
        System.out.println("testException执行了...");
        try{
            int a = 10/0;
        }catch (Exception e){
            e.printStackTrace();
            throw new SimpleException("出错了...");
        }
        return "success";
    }
}
