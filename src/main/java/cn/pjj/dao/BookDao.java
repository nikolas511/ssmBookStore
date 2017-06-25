package cn.pjj.dao;

import cn.pjj.bean.Book;

import java.util.List;

/**
 * Created by Administrator on 2017/6/10.
 */
public interface BookDao {

    void add(Book book);

    Book find(String id);

    List<Book> getAll();

    void update(Book book);

    void delete(String bookid);

    List<Book> getBookByCategoryId(String categoryid);
}
