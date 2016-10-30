<%--
  Created by IntelliJ IDEA.
  User: younghan
  Date: 2016. 7. 7.
  Time: 오후 5:04
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

        <div class="col-sm-6 col-md-4">
            <div class="thumbnail">
                <img src="/img/picMenu2/suwon_1.jpg" alt="...">
                <div class="caption">
                    <h3>수원 커피숍</h3>
                    <p><a href="/img/picMenu2/suwon_1.jpg" class="btn btn-default" role="button">크게 보기</a></p>
                </div>
            </div>
        </div>

        <div class="col-sm-6 col-md-4">
            <div class="thumbnail">
                <img src="/img/picMenu2/kinder_1.jpg" alt="...">
                <div class="caption">
                    <h3>시흥 정왕동 유치원증축</h3>
                    <p><a href="/img/picMenu2/kinder_1.jpg" class="btn btn-default" role="button">크게 보기</a></p>
                </div>
            </div>
        </div>

    </div>

    <jsp:include page="footer.jsp"></jsp:include>

</div> <!-- end container -->

    <!-- Bootstrap core JavaScript
================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="../../js/jquery-3.0.0.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="../../js/holder.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../js/ie10-viewport-bug-workaround.js"></script>

</div>
</body>
</html>
