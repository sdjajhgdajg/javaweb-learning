package top.soft.bookonline.dao;


import top.soft.bookonline.entity.Book;

import java.util.List;

public interface BookDao {
    List<Book> selectAll();

    /**
     *
     * 查询图书列表
     * @return
     */
    Book getBookById(int id);
    /**
     * 根据id查询图书列表
     */
}
