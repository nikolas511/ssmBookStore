package cn.pjj.clientHandler;

import cn.pjj.bean.User;
import cn.pjj.service.BusinessService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
@RequestMapping("/UserHandler")
public class UserHandler {
    @Resource
    private BusinessService businessService;
    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if(user==null) {
            user = businessService.login(username, password);
            if (user == null) {
                model.addAttribute("message", "请输入正确的用户名和密码登录");
                return "message";
            } else {
                session.setAttribute("user", user);
            }
        }else{
            model.addAttribute("message", "您已经登录,请勿重复登录!");
            return "message";
        }
        return "index";
    }
    @RequestMapping("/quit")
    public String quit(HttpSession session) {
        session.removeAttribute("user");
        return "index";
    }
    @RequestMapping("/register")
    public String register(User user,Model model) {
        user.setId(UUID.randomUUID().toString());
        businessService.addUser(user);
        model.addAttribute("message", "注册成功!");
        return "message";
    }
    @RequestMapping("/update")
    public String update(User user,Model model) {
        businessService.updateUser(user);
        model.addAttribute("message", "更新成功!");
        return "message";

    }
    @RequestMapping("/updateUI")
    public String updateUI(String id,Model model) {
        User user = businessService.queryUserById(id);
        model.addAttribute("user",user);
        return "client/updateUser";
    }
}
