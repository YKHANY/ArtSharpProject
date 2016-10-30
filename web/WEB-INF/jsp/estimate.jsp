<%--
  Created by IntelliJ IDEA.
  User: younghan
  Date: 2016. 7. 1.
  Time: 오후 5:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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

<jsp:include page="head.jsp"></jsp:include>


<div class="container">
    <div class="row" style="margin:8%;">

    </div>
    <div class="row">
        <div class="col-lg-2"></div>
        <div class="col-lg-8">
            <form action="/estimate.do" method="post" id="estimate_form" enctype="multipart/form-data">
                <table class="table table-bordered">
                    <tr>
                        <td>
                            <label>인테리어 종류</label>
                        </td>
                        <td>
                            <div class="input-group">
                                <input type="radio" name="kind" value="주거공간" aria-label="...">&nbsp
                                <label for="exampleInputEmail1">주거공간</label>
                                &nbsp&nbsp&nbsp&nbsp
                                <input type="radio" name="kind" value="상업공간" aria-label="...">&nbsp
                                <label for="exampleInputEmail1">상업공간</label>
                                &nbsp&nbsp&nbsp&nbsp
                                <input type="radio" name="kind" value="부분공사" aria-label="...">&nbsp
                                <label for="exampleInputEmail1">부분공사</label>
                                &nbsp&nbsp&nbsp&nbsp
                                <input type="radio" name="kind" value="기타공사" aria-label="...">&nbsp
                                <label for="exampleInputEmail1">기타공사</label>
                            </div><!-- /input-group -->
                            <div class="form-group"></div>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <label>의뢰인</label>
                        </td>
                        <td>
                            <div class="input-group">
                                <input type="text" class="form-control" name="username" placeholder="의뢰인 성함" value="이름없음">
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <label>비밀번호</label>
                        </td>
                        <td>
                            <div class="input-group">
                                <input type="password" class="form-control" name="password" placeholder="견적신청 비밀번호">
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <label>전화번호</label>
                        </td>
                        <td>
                            <input type="text" class="form-control" name="callNumber" placeholder="전화번호">
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <label>휴대전화</label>
                        </td>
                        <td>
                            <input type="text" class="form-control" name="phone" placeholder="휴대전화">
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <label>이메일 주소</label>
                        </td>
                        <td>
                            <input type="email" class="form-control" name="email" placeholder="이메일을 입력하세요">
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <label>인테리어 예정주소</label>
                        </td>
                        <td>
                            <div class="row">
                                <div class="col-lg-3">
                                    <input type="text" class="form-control" name="postcode" id="postcode" value="" placeholder="우편번호">
                                </div>
                                <div class="col-lg-3">
                                    <input type="button" class="form-control" value="검색" onclick="execDaumPostcode()" >
                                </div>
                            </div>
                            <input type="text" class="form-control" name="address" id="address" value="" placeholder="주소">
                            <input type="text" class="form-control" name="address2" id="address2" placeholder="상세주소">
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <label>면적</label>
                        </td>
                        <td>
                            <input type="text" class="form-control" name="area" >
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <label>예산</label>
                        </td>
                        <td>
                            <input type="text" class="form-control" name="cost" >
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <label>해당층</label>
                        </td>
                        <td>
                            <input type="text" class="form-control" name="floor" >
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <label>인테리어 예정일</label>
                        </td>
                        <td>
                            <input type="date" class="form-control" name="date" >
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <label>파일 첨부</label>
                        </td>
                        <td>
                            <input type="file" class="form-control" name="files" multiple>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <label>상담 내용</label>
                        </td>

                        <td>
                            <textarea class="form-control" name="counsel" rows="20"></textarea>
                        </td>
                    </tr>
                </table>

                <button type="submit" class="btn btn-default">상담신청</button>
            </form>

        </div>
        <div class="col-lg-2"></div>
    </div>

    <!-- FOOTER
    <footer>
        <p class="pull-right"><a href="#top">Back to top</a></p>
        <p>© 2016 ArtSharp. All right reserved. · <a href="http://bootstrapk.com/examples/carousel/#">Privacy</a> · <a href="http://bootstrapk.com/examples/carousel/#">Terms</a></p>
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
<script>
    function execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullAddr = ''; // 최종 주소 변수
                var extraAddr = ''; // 조합형 주소 변수

                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    fullAddr = data.roadAddress;

                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    fullAddr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
                if(data.userSelectedType === 'R'){
                    //법정동명이 있을 경우 추가한다.
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있을 경우 추가한다.
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById("postcode").value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById("address").value = fullAddr;

                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("address2").focus();
            }
        }).open();
    }
</script>
</body>
</html>