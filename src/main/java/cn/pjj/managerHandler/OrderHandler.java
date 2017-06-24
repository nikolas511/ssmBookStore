package cn.pjj.managerHandler;

import cn.pjj.bean.Order;
import cn.pjj.service.BusinessService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/6/24.
 */
@Controller
@RequestMapping("/manager/OrderHandler")
public class OrderHandler {
    @Resource
    private BusinessService businessService;
    @RequestMapping("/getAll")
    public String getAll(String state, Model model) {
        List<Order> orders;
        if (state.equals("false")){
            orders = businessService.getAllOrder(false);
        }else{
            orders = businessService.getAllOrder(true);
        }
        model.addAttribute("list",orders);
        return "manager/listOrder";
    }
    @RequestMapping("/detailsOrder")
    public String detailsOrder(String id,Model model) {
        Order order = businessService.findOrderById(id);
        model.addAttribute("order", order);
        return "manager/detailsOrder";
    }

    @RequestMapping("/updateState")
    public String updateState(String id,Model model) {
        businessService.updateOrder(id,true);
        model.addAttribute("message", "发货成功!");
        return "Mymessage";
    }
    @RequestMapping("/deleteOrder")
    public String deleteOrder(String id, Model model) {
        businessService.deleteOrder(id);
        model.addAttribute("message", "删除成功!");
        return "Mymessage";
    }
}
