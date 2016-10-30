<%--
  Created by IntelliJ IDEA.
  User: younghan
  Date: 2016. 7. 5.
  Time: 오후 2:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>

<jsp:include page="head.jsp"></jsp:include>

<div class="container">
    <div class="row" style="margin:8%;">

    </div>
    <div class="row">
        <div class="col-lg-2"></div>
        <div class="col-lg-8"></div>

            <table class="table table-responsive">
                <tr>
                    <td>번호</td>
                    <td>제목</td>
                    <td>작성자</td>
                    <td>작성 일자</td>
                    <td>조회수</td>
                </tr>
                <tr>
                    <td>1</td>
                    <td><a href="">문의 합니다.</a></td>
                    <td>김상태</td>
                    <td>2016-7-4</td>
                    <td>1</td>
                </tr>

            </table>


    </div>
    <div class="row">
        <a type="button" class="btn btn-primary" href="/QnA/edit" role="button">글쓰기</a>

    </div>

    <!-- FOOTER
    <footer>
        <p class="pull-right"><a href="http://bootstrapk.com/examples/carousel/#">Back to top</a></p>
        <p>© 2014 Company, Inc. · <a href="http://bootstrapk.com/examples/carousel/#">Privacy</a> · <a href="http://bootstrapk.com/examples/carousel/#">Terms</a></p>
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

<!-- daum postcode api CDN -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

</body>
</html>
