package practice;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author 35536
 * @description: TODO
 * @date 2024/9/28 16:08
 */
@WebServlet("/verifyCode")
public class VerifyCode extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int width=160;
        int height=45;
        //创建图像
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setColor(Color.pink);//设置矩形背景色
        g.fillRect(0, 0, width, height);
        String str="1234567809ADGFGHJ";
        //生成随机角标
        Random random=new Random();
        for(int i=0;i<=5;i++){
            int index=random.nextInt(str.length());
            char c=str.charAt(index);
            Color color=new Color(random.nextInt(250),random.nextInt(250),random.nextInt(250));
            g.setColor(color);
            g.drawString(String.valueOf(c),width/5*i,height/2);
        }
        //添加噪点
        Random random1 = new Random();
        for (int i = 0; i <40 ; i++) {
            int x = random1.nextInt(width);
            int y = random1.nextInt(height);
            g.setColor(Color.yellow );
            g.drawRect(x, y, 1, 1);
        }
        //设置干扰线
        for(int i=0;i<=10;i++){
            int x1= random.nextInt(width);
            int x2= random.nextInt(width);
            int y1= random.nextInt(height);
            int y2= random.nextInt(height);
            Color color = new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256));
            g.setColor(color.BLUE);//设置干扰线颜色
            g.drawLine(x1,y1,x1,y2);
        }
        ImageIO.write(image,"jpg",resp.getOutputStream());
    }
}
