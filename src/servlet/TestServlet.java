package servlet;

import dao.BaseDAO;
import dao.DAOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.annotation.*;
/**
 * Created by younghan on 2016. 6. 20..
 */

@WebServlet(name="MyServlet", urlPatterns = {""})
public class TestServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
        rd.forward(request,response);
    }

    @Override
    public void destroy() {

    }
}
