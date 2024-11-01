package top.soft.bookonline.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import top.soft.bookonline.entity.Book;
import top.soft.bookonline.service.BookService;
import top.soft.bookonline.service.impl.BookServiceImpl;


import java.io.IOException;
import java.util.List;

/**
 * @author 35536
 * @description: TODO
 * @date 2024/10/26 14:52
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookService bookService=new BookServiceImpl();
        //查询图书列表
        List<Book> books=bookService.getBooks();
        //存到attribute域中
        req.setAttribute("bookList", books);
        //跳转到首页
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
