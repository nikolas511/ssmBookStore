package cn.pjj.controller;

import cn.pjj.bean.User;
import cn.pjj.service.BusinessService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/6/2.
 */
@Controller
public class UserController {
    @Resource
    private BusinessService businessService;
    @RequestMapping("/index")
    public ModelAndView hello(){
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        return model;
    }
    @RequestMapping("/hello")
    public String index(HttpServletRequest request){
        User user = businessService.queryUserById("1");
        request.setAttribute("user", user);
        return "update";
    }

    @RequestMapping("/update")
    public String update(User user){
        businessService.updateUser(user);
        return "success";
    }
}
