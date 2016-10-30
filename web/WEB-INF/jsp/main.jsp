<%--
  Created by IntelliJ IDEA.
  User: younghan
  Date: 2016. 7. 1.
  Time: 오후 1:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!-- saved from url=(0041)http://bootstrapk.com/examples/carousel/# -->
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="/img/artsharpicon.ico">

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



<!-- Carousel
================================================== -->
<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1" class=""></li>
        <li data-target="#myCarousel" data-slide-to="2" class=""></li>
    </ol>
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <img class="first-slide" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="First slide">
            <div class="container">
                <div class="carousel-caption">
                    <!-- <img class="customSlide first-slide" src="/img/slide/slide1.jpg" alt="First slide" > -->
                    <h1>시공문의</h1>
                    <p>문의전화 TEL. 010-2435-2860</p>
                    <p>[친절상담 완벽시공 아트샵]</p>
                    <p><a class="btn btn-lg btn-primary" href='tel:010-2435-2860' role="button">전화 상담</a></p>

                </div>
            </div>
        </div>
        <div class="item">
            <img class="second-slide" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Second slide">
            <div class="container">
                <div class="carousel-caption">
                    <img class="customSlide second-slide" src="/img/slide/doonsan_1.jpg" alt="Second slide" >
                    <!--
                    <h1>Another example headline.</h1>
                    <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                    <p><a class="btn btn-lg btn-primary" href="http://bootstrapk.com/examples/carousel/#" role="button">Learn more</a></p>
                    -->
                </div>
            </div>
        </div>
        <div class="item">
            <img class="third-slide" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Third slide">
            <div class="container">
                <div class="carousel-caption">
                    <img class="customSlide third-slide" src="/img/slide/dangsandongiclass_1.jpg" alt="Third slide" >
                    <!--
                    <h1>One more for good measure.</h1>
                    <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                    <p><a class="btn btn-lg btn-primary" href="http://bootstrapk.com/examples/carousel/#" role="button">Browse gallery</a></p>
                    -->
                </div>
            </div>
        </div>
    </div>
    <a class="left carousel-control" href="/#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="/#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div><!-- /.carousel -->


<!-- Marketing messaging and featurettes
================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container marketing">

    <!-- Three columns of text below the carousel -->
    <div class="row">
        <div class="col-lg-4">
            <img class="img-circle" src="/img/circle/circle1.jpg" alt="circle1 image" width="200" height="200">
            <h2>주거공간</h2>
            <p>당신의 편안한 주거공간</p>
            <p><a class="btn btn-default" href="/picMenu1" role="button">View details »</a></p>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
            <img class="img-circle" src="/img/circle/circle2.jpg" alt="circle2 image" width="200" height="200">
            <h2>상업공간</h2>
            <p>아트샵만의 특별한 상업공간</p>
            <p><a class="btn btn-default" href="/picMenu2" role="button">View details »</a></p>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
            <img class="img-circle" src="/img/circle/circle3.jpg" alt="circle3 image" width="200" height="200">
            <h2>기타공간</h2>
            <p>실용적이고 편안한 기타공간</p>
            <p><a class="btn btn-default" href="/picMenu3" role="button">View details »</a></p>
        </div><!-- /.col-lg-4 -->
    </div><!-- /.row -->


    <!-- START THE FEATURETTES -->

    <hr class="featurette-divider">

    <div class="row featurette">
        <div class="col-md-7">
            <h2 class="featurette-heading">유치원 <span class="text-muted"> 증축 공사 </span></h2>
            <p class="lead">시흥시 정왕동 유치원 증축공사</p>
        </div>
        <div class="col-md-5">
            <img class="featurette-image img-responsive center-block" alt="500x500" src="/img/main/main1.jpg" data-holder-rendered="true">
        </div>
    </div>

    <hr class="featurette-divider">

    <div class="row featurette">
        <div class="col-md-7 col-md-push-5">
            <h2 class="featurette-heading">아파트 <span class="text-muted"> 발코니</span></h2>
            <p class="lead">고척동 서울가든아파트</p>
        </div>
        <div class="col-md-5 col-md-pull-7">
            <img class="featurette-image img-responsive center-block" alt="500x500" src="/img/main/main2.jpg" data-holder-rendered="true">
        </div>
    </div>

    <hr class="featurette-divider">

    <div class="row featurette">
        <div class="col-md-7">
            <h2 class="featurette-heading">화장실 <span class="text-muted"> 인테리어</span></h2>
            <p class="lead">오류동 금강아파트</p>
        </div>
        <div class="col-md-5">
            <img class="featurette-image img-responsive center-block" alt="500x500" src="/img/main/main3.jpg" data-holder-rendered="true">
        </div>
    </div>

    <hr class="featurette-divider">

    <!-- /END THE FEATURETTES -->

</div><!-- /.container -->

<div class="container">

    <jsp:include page="footer.jsp"></jsp:include>
    <!-- FOOTER
<footer>
    <p class="pull-right"><a href="#top">Back to top</a></p>

    <div class="row">
        <div class="col-lg-2">
            <img src="/img/artsharp_logo_gray.png" width="100%"/>
        </div>

        <div class="col_lg-8">
            아트샵인테리어 | 대표: 김상태 | TEL. 010-2435-2860 | 010-3261-5452 | 02-2625-3385
            <br>| 서울지사 | 서울특별시 구로구 오리로 13길105 우창굿모닝 204호
            <br>| 천안지사 | 충청남도 천안시 동남구 원성동 554-15
            <br>© 2016 ArtSharp. All right reserved. ·
            <a href="#">Privacy</a> · <a href="">Terms</a> · <a href="/admin">관리자</a>
        </div>
    </div>
</footer>
-->
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


<svg xmlns="http://www.w3.org/2000/svg" width="500" height="500" viewBox="0 0 500 500" preserveAspectRatio="none" style="visibility: hidden; position: absolute; top: -100%; left: -100%;"><defs></defs><text x="0" y="23" style="font-weight:bold;font-size:23pt;font-family:Arial, Helvetica, Open Sans, sans-serif;dominant-baseline:middle">500x500</text></svg>
</body>
</html>
