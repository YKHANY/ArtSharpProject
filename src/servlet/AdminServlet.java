package servlet;

import dao.AdminDAOImpl;
import dao.DAOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by younghan on 2016. 9. 22..
 */
@WebServlet(name = "AdminServlet", urlPatterns ={"/admin", "/admin.login", "/admin.logout"})
public class AdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String[] urlArr = request.getRequestURL().toString().split("/");
        String urlPattern = urlArr[urlArr.length-1];
        RequestDispatcher rd = null;

        if(urlPattern.equals("admin.login")){
            String admin_id = request.getParameter("id");
            String password = request.getParameter("password");
            AdminDAOImpl dao = new AdminDAOImpl();
            HttpSession session = request.getSession();
            try{
                System.out.println(admin_id);
                System.out.println(password);
                String login_state = dao.select(admin_id);
                System.out.println(login_state);
                if(login_state != null && login_state.equals(password)){
                    session.setAttribute("admin_state", true);
                    rd = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
                    System.out.println("suucc");
                }else{
                    rd = request.getRequestDispatcher("/WEB-INF/jsp/admin.jsp");
                    System.out.println("fail");
                }
                rd.forward(request,response);
            }catch (DAOException e){
                System.out.println(e.getMessage());
            }

        }else if(urlPattern.equals("admin.logout")){
            HttpSession session = request.getSession();
            session.invalidate();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = null;

        HttpSession session = request.getSession();
        if(session.getAttribute("admin_state") == null){
            rd = request.getRequestDispatcher("/WEB-INF/jsp/admin.jsp");
        }else{
            rd = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
        }
        rd.forward(request,response);
    }
}
