package cn.pjj.clientHandler;

import cn.pjj.bean.Book;
import cn.pjj.bean.Cart;
import cn.pjj.bean.User;
import cn.pjj.service.BusinessService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/client/BuyHandler")
public class BuyHandler {
    @Resource
    private BusinessService businessService;
    @RequestMapping("/buyCart")
    public String buy(String id, HttpSession session){
        Book book = businessService.queryBookById(id);
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart",cart);
        }
        cart.add(book);
        return "client/listcart";
    }
    @RequestMapping("/delete")
    public String delete(HttpSession session, Model model) {
        session.removeAttribute("cart");
        model.addAttribute("message", "删除成功!");
        return "message";
    }

    @RequestMapping("/order")
    public String order(HttpSession session,Model model) {
        Cart cart = (Cart) session.getAttribute("cart");
        User user = (User) session.getAttribute("user");
        if(user!=null){
            businessService.addOrder(cart,user);
            session.removeAttribute("cart");
            model.addAttribute("message", "订单下发成功,请等待发货(暂时缺少支付环节)");
        }else{
            model.addAttribute("message", "请先登录!");
        }
        return "message";
    }
}
