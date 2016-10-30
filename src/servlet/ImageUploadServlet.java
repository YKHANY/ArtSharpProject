package servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.output.DeferredFileOutputStream;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by younghan on 2016. 7. 6..
 */
@WebServlet(name = "ImageUploadServlet", urlPatterns ={"/ImageUpload.do"})
public class ImageUploadServlet extends HttpServlet {



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            upload(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }catch(Exception ee)
        {
            ee.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }

    public void upload(HttpServletRequest req) throws ServletException, IOException, FileUploadException, Exception{

        System.out.println("!!!!!!!!!<><><><><><><   ");

        boolean isMultipart = ServletFileUpload.isMultipartContent(req); // multipart로 전송되었는가를 체크
        if (isMultipart) {                                                // multipart로 전송 되었을 경우
            File temporaryDir = new File("~/ImageTemp/");//업로드 된 파일의 임시 저장 폴더를 설정
            String realDir = req.getServletContext().getRealPath("/img/upload/");
            System.out.println(realDir);
            //tmp의 폴더의 전송된 파일을 upload 폴더로 카피 한다.
            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(1 * 1024 * 1024);                                                      //1메가가 넘지 않으면 메모리에서 바로 사용
            factory.setRepository(temporaryDir);                                                               //1메가 이상이면 temporaryDir 경로 폴더로 이동
            //실제 구현단계 아님 설정단계였음
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setSizeMax(10 * 1024 * 1024);                                                             //최대 파일 크기(10M)
            List<FileItem> items = new ArrayList<>();//실제 업로드 부분(이부분에서 파일이 생성된다)
            List li = upload.parseRequest(req);
            for(int i=0; i<li.size(); i++){
                FileItem item = (FileItem)li.get(i);
                items.add(item);
            }

            Iterator iter=items.iterator();                                                                            //Iterator 사용
            while(iter.hasNext()){
                FileItem fileItem = (FileItem) iter.next();                                                            //파일을 가져온다

                if(fileItem.isFormField()){                                                                               //업로드도니 파일이 text형태인지 다른 형태인지 체크
                    // text형태면 if문에 걸림
                    //out.println("폼 파라미터: "+ fileItem.getFieldName()+"="+fileItem.getString("euc-kr")+"<br>");
                }else{                                                                                                         //파일이면 이부분의 루틴을 탄다
                    if(fileItem.getSize()>0){                                                                                 //파일이 업로드 되었나 안되었나 체크 size>0이면 업로드 성공
                        String fieldName=fileItem.getFieldName();
                        String fileName=fileItem.getName();
                        String contentType=fileItem.getContentType();
                        boolean isInMemory=fileItem.isInMemory();
                        long sizeInBytes=fileItem.getSize();
                        System.out.println("파일 [fieldName] : "+ fieldName +"<br/>");
                        System.out.println("파일 [fileName] : "+ fileName +"<br/>");
                        System.out.println("파일 [contentType] : "+ contentType +"<br/>");
                        System.out.println("파일 [isInMemory] : "+ isInMemory +"<br/>");
                        System.out.println("파일 [sizeInBytes] : "+ sizeInBytes +"<br/>");

                        try{
                            File uploadedFile=new File(realDir,fileName);                                                   //실제 디렉토리에 fileName으로 카피 된다.
                            fileItem.write(uploadedFile);
                            fileItem.delete();                                                                                            //카피 완료후 temp폴더의 temp파일을 제거
                        }catch(IOException ex) {}
                    }
                }
            }
        }else{
            System.out.println("인코딩 타입이 multipart/form-data 가 아님.");
        }

    }


}
