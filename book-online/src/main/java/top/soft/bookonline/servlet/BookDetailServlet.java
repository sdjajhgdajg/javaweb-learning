package top.soft.bookonline.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import top.soft.bookonline.entity.Book;
import top.soft.bookonline.service.BookService;
import top.soft.bookonline.service.impl.BookServiceImpl;

import java.io.IOException;

/**
 * @author 35536
 * @description: TODO
 * @date 2024/10/26 16:06
 */
@WebServlet(urlPatterns = "/detail/*")
public class BookDetailServlet extends HttpServlet {
    private BookService bookService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestPath=req.getRequestURI().trim();
        int position=requestPath.lastIndexOf("/");
        String id=requestPath.substring(position+1);
        Book book=bookService.getBookById(Integer.parseInt(id));
        req.setAttribute("book", book);
        req.getRequestDispatcher("/book_detail.jsp").forward(req,resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        bookService=new BookServiceImpl();
    }
}