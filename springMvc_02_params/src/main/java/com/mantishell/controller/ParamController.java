package com.mantishell.controller;

import com.mantishell.domain.Account;
import com.mantishell.domain.Account2;
import com.mantishell.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/param")
public class ParamController {

    @RequestMapping("/testParam")
    public String testParam(String username, String password){
        System.out.println("用户名："+username+"，密码："+password);
        return "success";
    }

        /**
         * 请求参数绑定把数据封装到JavaBean的类中
         * @param account
         */
        @RequestMapping("/saveAccount")
        public void saveAccount(Account account){
            System.out.println(account);
        }

    @RequestMapping("/saveAccount2")
    public void saveAccount2(Account2 account){
        System.out.println(account);
    }

    @RequestMapping("/saveUser")
    public void saveUser(User user){
        System.out.println(user);
    }

    public void testServlet(HttpServletRequest request, HttpServletResponse response){
        System.out.println(request);
        HttpSession session = request.getSession();
        System.out.println(session);
        ServletContext servletContext = session.getServletContext();
        System.out.println(servletContext);
        System.out.println(response);
    }
}
