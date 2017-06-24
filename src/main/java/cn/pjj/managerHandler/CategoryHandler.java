package cn.pjj.managerHandler;

import cn.pjj.bean.Category;
import cn.pjj.service.BusinessService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;
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
    @RequestMapping("/getAllCategory")
    public String getAll(Model model) {
        List<Category> categories = businessService.getAllCategory();
        model.addAttribute("categories",categories);
        return "manager/listCategory";
    }
    @RequestMapping("/updateCategory")
    public String update(Model model,Category category) {
        businessService.updateCategory(category);
        model.addAttribute("message","更新成功!");
        return "Mymessage";
    }
    @RequestMapping("/deleteCategory")
    public String delete(Model model,String id) {
        businessService.deleteCategory(id);
        model.addAttribute("message","删除成功!");
        return "Mymessage";
    }

    @RequestMapping("/updateCategoryUI")
    public String updateUI(String id,Model model) {
        Category category = businessService.findCategoryById(id);
        model.addAttribute("category",category);
        return "manager/updateCategoryForm";
    }
}
