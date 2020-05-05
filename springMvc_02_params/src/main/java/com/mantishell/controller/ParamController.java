package com.mantishell.controller;

import com.mantishell.domain.Account;
import com.mantishell.domain.Account2;
import com.mantishell.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/param")
@SessionAttributes(value={"msg"})//把msg=张三 存入到session域对象中
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

    @RequestMapping(path = "/testRequestParam")
    public String testRequestParam(@RequestParam(value = "username", required = false)String name){
        System.out.println(name);
        return "success";
    }

    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body){
        System.out.println(body);
        return "success";
    }

    @RequestMapping("testPathVariable")
    public String testPathVariable(@PathVariable(value = "id") String id){
        System.out.println(id);
        return "success";
    }

    @RequestMapping("testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept") String header){
        System.out.println(header);
        return "success";
    }

    @RequestMapping("testCookieValue")
    public String testCookieValue(@CookieValue(value="JSESSIONID") String cookieValue){
        System.out.println(cookieValue);
        return "success";
    }

        /*@RequestMapping("/testModelAttribute")
        public String testModelAttribute(User user){
            System.out.println("然后执行testModelAttribute");
            System.out.println(user);
            return "success";
        }

        @ModelAttribute
        public User showUser(String uname){
            System.out.println("先执行showUser");
            User user = new User();
            user.setUname(uname);
            user.setBirthday(new Date());
            return user;
        }*/

        @RequestMapping("testModelAttribute")
        public String testModelAttribute(@ModelAttribute("adc") User user){
            System.out.println(user);
            return "success";
        }

        @ModelAttribute
        public void showUser(String uname, Map<String, User> map){
            User user = new User();//模拟通过用户查询数据库得到的信息
            user.setUname(uname);
            user.setBirthday(new Date());
            map.put("adc",user);
        }


        @RequestMapping("/setSessionAttributes")
        public String setSessionAttributes(Model model){
            System.out.println("testSessionAttributes");
            //底层会存储到request域对象中
            model.addAttribute("msg","张三");
            return "success";
        }

        @RequestMapping("/getSessionAttributes")
        public String getSessionAttributes(ModelMap modelMap){
            String msg = (String) modelMap.get("msg");
            System.out.println(msg);
            return "success";
        }

        @RequestMapping("/delSessionAttributes")
        public String delSessionAttributes(SessionStatus status){
            status.setComplete();
            return "success";
        }
}
