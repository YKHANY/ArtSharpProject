package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by younghan on 2016. 7. 7..
 */
@WebServlet(name = "PicMenuServlet", urlPatterns = {"/picMenu1", "/picMenu2", "/picMenu3"})
public class PicMenuServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String[] urlArr = request.getRequestURL().toString().split("/");
        String urlPattern = urlArr[urlArr.length-1];

        RequestDispatcher rd = null;
        if(urlPattern.equals("picMenu1")){
            rd = request.getRequestDispatcher("/WEB-INF/jsp/picmenu1.jsp");
        }else if(urlPattern.equals("picMenu2")){
            rd = request.getRequestDispatcher("/WEB-INF/jsp/picmenu2.jsp");
        }else if(urlPattern.equals("picMenu3")){
            rd = request.getRequestDispatcher("/WEB-INF/jsp/picmenu3.jsp");
        }

        rd.forward(request,response);
    }
}
