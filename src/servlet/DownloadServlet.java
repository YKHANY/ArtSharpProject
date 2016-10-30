package servlet;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by younghan on 2016. 7. 8..
 */
@WebServlet(name = "DownloadServlet", urlPatterns = {"/download"})
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String original_filename = request.getParameter("filename");
        String filename = "/" + original_filename;
        System.out.println(filename);
        System.out.println(original_filename);
        doDownload(request,response,filename,original_filename);

    }

    private void doDownload( HttpServletRequest req, HttpServletResponse resp, String filename, String original_filename )
            throws IOException
    {
        File file = new File(filename);
        //response.setContentType("image/png");
        String mimeType = new MimetypesFileTypeMap().getContentType(file);
        System.out.println(mimeType);
        resp.setContentType(mimeType);
        System.out.println("fileName"+file.getName());
        resp.addHeader("Content-Disposition", "attachment; filename="+file.getName());
        System.out.println(resp.getHeader("Content-Disposition"));
        byte[] buffer = new byte[1024];
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        try{
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            OutputStream os = resp.getOutputStream();
            int i = bis.read(buffer);
            while(i!= -1){
                os.write(buffer, 0, i);
                i = bis.read(buffer);
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(bis != null){
                bis.close();
            }
            if(fis != null){
                fis.close();
            }
        }
    }
}
