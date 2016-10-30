<%--
  Created by IntelliJ IDEA.
  User: younghan
  Date: 2016. 7. 5.
  Time: 오후 2:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="../../ckeditor/ckeditor.js"></script>
</head>
<body>

<jsp:include page="head.jsp"></jsp:include>


<div class="container">
    <div class="row" style="margin:8%;">

    </div>
    <div class="row">
        <div class="col-lg-2"></div>
        <div class="col-lg-9">
            <form action="" method="post">
                <table class="table table-bordered table-responsive">
                    <tr>
                        <td>
                            <label>제목</label>
                        </td>
                        <td>
                            <input type="text" class="form-control" placeholder="제목" aria-describedby="sizing-addon1" maxlength="15">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>작성자</label>
                        </td>
                        <td>
                            <input type="text" class="form-control" placeholder="작성자" aria-describedby="sizing-addon2">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>비밀번호</label>
                        </td>
                        <td>
                            <input type="password" class="form-control" placeholder="비밀번호" aria-describedby="sizing-addon3">
                        </td>
                    </tr>
                </table>

                <textarea name="editor1" id="editor1" rows="10" cols="80">
                </textarea>
                <script>
                    // Replace the <textarea id="editor1"> with a CKEditor
                    // instance, using default configuration.
                    CKEDITOR.replace( 'editor1',{
                        'filebrowserUploadUrl':'/ckeditor/upload.jsp?'
                        +'realUrl=../../img/upload/'
                        +'&realDir=/img/upload'

                    });
                </script>
                <br/>
                <a type="button" class="btn btn-primary" role="button">등록</a>
            </form>
        </div>
    </div>

    <!-- FOOTER
    <footer>
        <p class="pull-right"><a href="#top">Back to top</a></p>
        <p>© 2016 ArtSharp. All right reserved. · <a href="#">Privacy</a> · <a href="#">Terms</a></p>
    </footer>
    -->
    <jsp:include page="footer.jsp"></jsp:include>


</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="../../js/jquery-3.0.0.min.js"></script>
<script src="../../js/bootstrap.min.js"></script>
<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
<script src="../../js/holder.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../../js/ie10-viewport-bug-workaround.js"></script>



</body>
</html>
