package com.mantishell.controller;

import com.mantishell.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/testString")
    public String testString(Model model){

        User user = new User();
        user.setUsername("张三");
        user.setPassword("123456");

        model.addAttribute("user", user);
        return "success";
    }

    @RequestMapping("/initAdd")
    public void initAdd(HttpServletRequest request, HttpServletResponse response) throws Exception{
        //请求转发
        //request.getRequestDispatcher("/WEB-INF/pages/add.jsp").forward(request, response);
        //重定向
        //response.sendRedirect(request.getContextPath() + "/add2.jsp");

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        //直接响应数据
        response.getWriter().print("你好");
        return;
    }
    @RequestMapping("/findAll")
    public ModelAndView findAll() throws Exception{
        ModelAndView mv = new ModelAndView();
        //跳转到list.jsp页面
        mv.setViewName("list");

        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setUsername("张三");
        user1.setPassword("123456");

        User user2 = new User();
        user2.setUsername("李四");
        user2.setPassword("1111");
        users.add(user1);
        users.add(user2);

        //添加对象
        mv.addObject("users", users);
        return mv;
    }

    /**
     * springmvc转发
     * 使用forward关键字进行请求转发
     * forward：转发的jsp路径，不走视图解析器，需要编写完整的路径
     * @return
     * @throws Exception
     */
    @RequestMapping("/delete")
    public String delete() throws Exception{
        return "forward:/user/findAll";
    }

    /**
     * springmvc的重定向
     * @return
     * @throws Exception
     */
    @RequestMapping("/count")
    public String count() throws  Exception{
        return "redirect:/user/findAll";
    }

    @RequestMapping("/testJson")
    public void testJson(@RequestBody String body){
        System.out.println(body);
    }
}
