package cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author 35536
 * @description: TODO
 * @date 2024/10/19 14:02
 */
@WebServlet("/cookieDemo02")
public class cookieDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        for(Cookie cookie : cookies){
            String name=cookie.getName();
            if("username".equals(name)){
                System.out.println("value的结果"+cookie.getValue());
                break;
            }
        }
    }
}
