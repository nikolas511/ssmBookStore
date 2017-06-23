package cn.pjj.dao;

import cn.pjj.bean.Category;

import java.util.List;

/**
 * Created by Administrator on 2017/6/22.
 */
public interface CategoryDao {
    void add(Category category);

    void update(Category category);

    void delete(String id);

    Category findCategoryById(String id);

    List<Category> getAll();
}
