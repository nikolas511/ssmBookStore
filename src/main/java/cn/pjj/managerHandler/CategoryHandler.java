package cn.pjj.managerHandler;

import cn.pjj.bean.Category;
import cn.pjj.service.BusinessService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * Created by Administrator on 2017/6/24.
 */
@Controller
@RequestMapping(value = "/manager/CategoryHandler")
public class CategoryHandler {
    @Resource
    private BusinessService businessService;

    @RequestMapping("/add")
    public String addCategory(Model model,Category category) {
        category.setId(UUID.randomUUID().toString());
        businessService.addCategory(category);
        model.addAttribute("message","添加成功!");
        return "Mymessage";
    }
}
