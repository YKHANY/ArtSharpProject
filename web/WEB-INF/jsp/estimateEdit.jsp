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
