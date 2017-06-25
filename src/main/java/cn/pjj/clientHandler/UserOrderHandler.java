package cn.pjj.clientHandler;

import cn.pjj.bean.Order;
import cn.pjj.bean.User;
import cn.pjj.service.BusinessService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2017/6/24.
 */
@Controller
@RequestMapping("/client/UserOrderHandler")
public class UserOrderHandler {

    @Resource
    private BusinessService businessService;
    @RequestMapping("/listOrder")
    public String listOrder(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            List<Order> orders = businessService.findUserOrder(user.getId());
            model.addAttribute("list", orders);
            return "client/clientListOrder";
        }else{
            model.addAttribute("message", "请先登录!");
            return "message";
        }
    }
    @RequestMapping("/detailsOrder")
    public String detailsOrder(String id,Model model) {
        Order order = businessService.findOrderById(id);
        model.addAttribute("clientorder", order);
        return "client/clientOrderDetail";
    }

}
