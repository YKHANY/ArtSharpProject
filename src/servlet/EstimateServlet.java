package servlet;

import dao.DAOException;
import dao.EstimateDAO;
import dao.EstimateDAOImpl;
import model.Estimate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by younghan on 2016. 7. 5..
 */
@WebServlet(name = "EstimateServlet", urlPatterns = {"/estimate", "/estimate/edit", "/estimate.do", "/estimate.login", "/estimate/enter", "/estimate.delete"})
@MultipartConfig
public class EstimateServlet extends HttpServlet {

    private String getFilename(Part part){
        String contentDispositionHeader = part.getHeader("content-disposition");
        String[] elements = contentDispositionHeader.split(";");
        for(String element : elements)
        {
            if(element.trim().startsWith("filename")) {
                return element.substring(element.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] urlArr = request.getRequestURL().toString().split("/");
        String urlPattern = urlArr[urlArr.length-1];
        request.setCharacterEncoding("UTF-8");
        RequestDispatcher rd = null;

        if(urlPattern.equals("estimate.do")){
            String kind = request.getParameter("kind");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String callNumber = request.getParameter("callNumber");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String postcode = request.getParameter("postcode");
            String address = request.getParameter("address");
            String address2 = request.getParameter("address2");
            String area = request.getParameter("area");
            String cost = request.getParameter("cost");
            String floor = request.getParameter("floor");
            String date = request.getParameter("date");
            String counsel = request.getParameter("counsel");
            List<String> files = new ArrayList<>();

            GregorianCalendar calendar = new GregorianCalendar(Locale.KOREA);
            String defaultFilename = "" + calendar.get(Calendar.YEAR) + calendar.get(Calendar.MONTH) + calendar.get(Calendar.DAY_OF_MONTH)
                    + calendar.get(Calendar.HOUR_OF_DAY) + calendar.get(Calendar.MINUTE) + calendar.get(Calendar.MILLISECOND);

            GregorianCalendar gre = null;
            if(!date.equals("")){
                gre = toGregorianCal(date);
            }

            Collection<Part> parts = request.getParts();
            int cnt = 0;
            for(Part part : parts){
                if(part.getContentType() != null){
                    // store file part on disk
                    String fileName = getFilename(part);
                    if(fileName != null && !fileName.isEmpty()){
                        cnt++;
                        String fileType = fileName.substring(fileName.indexOf("."));
                        fileName = defaultFilename + "_" + cnt + fileType;
                        files.add(fileName);
                        part.write(getServletContext().getRealPath("/Estimate" + "/" + fileName));
                       // part.write("/Estimate/" + fileName);
                    }
                }
            }


            Estimate est = new Estimate(kind,username,password,phone,email,postcode,address,address2,area,cost,floor,gre,files,counsel);

            EstimateDAOImpl dao = new EstimateDAOImpl();
            try {
                dao.insert(est);
            } catch (DAOException e) {
                e.printStackTrace();
            }

            List<Estimate> list = null;
            dao = new EstimateDAOImpl();
            try {
                list = dao.selectAll();
            } catch (DAOException e) {
                e.printStackTrace();
            }
            request.setAttribute("estimate_list",list);
            rd = request.getRequestDispatcher("/WEB-INF/jsp/estimateMain.jsp");
            rd.forward(request,response);

        }else if(urlPattern.equals("estimate.login")){
            String estimate_code = request.getParameter("est_code");
            String password = request.getParameter("password");
            EstimateDAOImpl dao = new EstimateDAOImpl();
            try {
                Estimate estimate = dao.select(estimate_code);
                if(estimate.getPassword()!= null && estimate.getPassword().equals(password)){
                    // view 보여주면 된다.
                    System.out.println("succ");
                    request.setAttribute("kind", estimate.getKind());
                    request.setAttribute("name", estimate.getName());
                    request.setAttribute("phone", estimate.getPhone());
                    request.setAttribute("email", estimate.getEmail());
                    request.setAttribute("address", "("+estimate.getPostcode()+")" + estimate.getAddress() + " " + estimate.getAddressDetail());
                    request.setAttribute("size", estimate.getSize());
                    request.setAttribute("price", estimate.getPrice());
                    request.setAttribute("floor", estimate.getFloor());
                    request.setAttribute("date", estimate.getDate());
                    request.setAttribute("files", estimate.getFilePath());
                    request.setAttribute("councel", estimate.getText());

                    for(String tmp : estimate.getFilePath()){
                        System.out.println(tmp);
                    }
                    request.setAttribute("est_code",estimate_code);
                    rd = request.getRequestDispatcher("/WEB-INF/jsp/privateEstimate.jsp");
                    rd.forward(request,response);
                }else{
                    System.out.println("fail");
                    response.sendRedirect("/estimate");
                }
            } catch (DAOException e) {
                e.printStackTrace();
            }

        }else if(urlPattern.equals("estimate.delete")){
            String estimate_code = request.getParameter("est_code");
            System.out.println(estimate_code);
            EstimateDAOImpl dao = new EstimateDAOImpl();
            List<String> list = null;
            try {
                list = dao.select(estimate_code).getFilePath();
                dao.delete(estimate_code);
                if(list != null){
                    for(String tmp : list){
                        System.out.println(tmp);

                        File file = new File(getServletContext().getRealPath("/Estimate/"+tmp));
                        System.out.println(file.delete());
                    }
                }
            } catch (DAOException e) {
                e.printStackTrace();
            }
            response.sendRedirect("/estimate");

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] urlArr = request.getRequestURL().toString().split("/");
        String urlPattern = urlArr[urlArr.length-1];

        RequestDispatcher rd = null;

        if(urlPattern.equals("estimate")){
            List<Estimate> list = null;
            EstimateDAOImpl dao = new EstimateDAOImpl();
            try {
                list = dao.selectAll();
            } catch (DAOException e) {
                e.printStackTrace();
            }
            request.setAttribute("estimate_list",list);
            rd = request.getRequestDispatcher("/WEB-INF/jsp/estimateMain.jsp");
            rd.forward(request,response);
        }else if(urlPattern.equals("edit")){

            rd = request.getRequestDispatcher("/WEB-INF/jsp/estimate.jsp");
            rd.forward(request,response);
        }else if(urlPattern.equals("enter")){
            HttpSession session = request.getSession();
            if(session.getAttribute("admin_state")!= null && (boolean)session.getAttribute("admin_state")) {
                // 관리자 권한으로 다볼수 있다
                // 해당 페이지 셀렉 해서 보여준다.

                String estimate_code = request.getParameter("est_code");
                EstimateDAOImpl dao = new EstimateDAOImpl();
                try {
                    Estimate estimate = dao.select(estimate_code);

                    request.setAttribute("kind", estimate.getKind());
                    request.setAttribute("name", estimate.getName());
                    request.setAttribute("phone", estimate.getPhone());
                    request.setAttribute("email", estimate.getEmail());
                    request.setAttribute("address", "("+estimate.getPostcode()+")" + estimate.getAddress() + " " + estimate.getAddressDetail());
                    request.setAttribute("size", estimate.getSize());
                    request.setAttribute("price", estimate.getPrice());
                    request.setAttribute("floor", estimate.getFloor());
                    request.setAttribute("date", estimate.getDate());
                    request.setAttribute("files", estimate.getFilePath());
                    request.setAttribute("councel", estimate.getText());

                    for(String tmp : estimate.getFilePath()){
                        System.out.println(tmp);
                    }
                    request.setAttribute("est_code",estimate_code);
                    rd = request.getRequestDispatcher("/WEB-INF/jsp/privateEstimate.jsp");
                    rd.forward(request,response);

                }catch (DAOException e) {
                    e.printStackTrace();
                }
            }else{
                rd = request.getRequestDispatcher("/WEB-INF/jsp/ownerCheck.jsp");
                request.setAttribute("est_code",request.getParameter("est_code"));
                rd.forward(request,response);
            }
        }
    }

    public GregorianCalendar toGregorianCal(String date){
        GregorianCalendar ret = new GregorianCalendar();
        String[] tmp = date.split("-");
        int y, m , d;
        y = Integer.parseInt(tmp[0]);
        m = Integer.parseInt(tmp[1]);
        d = Integer.parseInt(tmp[2]);

        ret.set(y,m-1,d);
        return ret;
    }
}

