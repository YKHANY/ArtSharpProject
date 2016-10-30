package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by younghan on 2016. 7. 5..
 */
@WebServlet(name = "QnAServlet", urlPatterns = {"/QnA", "/QnA/edit"})
public class QnAServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] urlArr = req.getRequestURL().toString().split("/");
        String urlPattern = urlArr[urlArr.length-1];

        RequestDispatcher rd = null;
        if(urlPattern.equals("edit")){
            rd = req.getRequestDispatcher("/WEB-INF/jsp/edit.jsp");
        }else if(urlPattern.equals("QnA")){
            rd = req.getRequestDispatcher("/WEB-INF/jsp/qna.jsp");
        }
        rd.forward(req,resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
