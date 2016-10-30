<%--
  Created by IntelliJ IDEA.
  User: younghan
  Date: 2016. 9. 22.
  Time: 오전 3:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>관리자 로그인</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="http://bootstrapk.com/favicon.ico">

    <title>아트샵</title>


    <!-- Bootstrap core CSS -->
    <link href="../../css/bootstrap.css" rel="stylesheet">


    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Custom styles for this template -->
    <link href="../../css/carousel.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row" style="margin:1%;">

    </div>
    <div class="row">
        <div class="page-header">
            <form action="/admin.login" method="post">
                <table class="table table-bordered">
                    <tr>
                        <td>
                            <label>관리자 아이디</label>
                        </td>
                        <td>
                            <div class="input-group">
                                <input type="text" class="form-control" name="id" placeholder="관리자 아이디">
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <label>비밀번호</label>
                        </td>
                        <td>
                            <div class="input-group">
                                <input type="password" class="form-control" name="password" placeholder="비밀번호">
                            </div>
                        </td>
                    </tr>
                </table>
                <button type="submit" class="btn btn-default">로그인</button>
            </form>
        </div>
    </div>

</div>

</body>
</html>
