<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="resources/css/container2.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@ include file="header.jsp" %>
<div class="container">
           <!-- <h1>MAGAZINE</h1> -->
    <h1>M<br>A<br>G<br>A<br>Z<br>I<br>N<br>E<br></h1>

    <div class="magazine">
        <h2><span>티와 일상</span></h2>
        <div class="box1">
            <ul>
                <li>
                    <a href="">
                        <img src="./img/아기.png" alt="">
                        <p>오설록 직원들이 차를 즐기는 시간</p>
                    </a>
                </li>
                <li>
                    <a href="">
                        <img src="./img/산책과 아침.png" alt="">
                        <p>오후만 있던 토요일·김종완</p>
                    </a>
                </li>
                <li>
                    <a href="">
                        <img src="./img/공예가 가족.png" alt="">
                        <p>좋지 아니한家·유어예</p>
                    </a>
                </li>
            </ul>
        </div><!--.box1-->

        <div class="box2">
            <h2><span>제주와 오설록</span></h2>
            <ul>
                <li>
                    <a href="">
                        <img src="./img/제주녹차.jpg" alt="">
                        <p>오설록 월출산차밭</p>
                    </a>
                </li>
                <li>
                    <a href="">
                        <img src="./img/운중산책.jpg" alt="">
                        <p>운중산책</p>
                    </a>
                </li>
                <li>
                    <a href="">
                        <img src="./img/일상 반사.jpg" alt="">
                        <p>일상茶반사</p>
                    </a>
                </li>
            </ul>
        </div><!--.box2-->
        
        <div class="box3">
            <h2><span>오설록 만의 디자인</span></h2>
            <ul>
                <li>
                    <a href="">
                        <div class="screen">
                            <span></span><span></span><span></span><span></span>
                            <img src="./img/장인.jpg" alt="">
                        </div>
                        <p>장인</p>
                    </a>
                </li>
                <li>
                    <a href="">
                        <div class="screen">
                            <span></span><span></span><span></span><span></span>
                            <img src="./img/녹차 빵.png" alt="">
                       
                        </div>
                        <p>Tea & Tea Food</p>    
                    </a>
                </li>
                <li>
                    <a href="">
                        <div class="screen">
                            <span></span><span></span><span></span><span></span>
                            <img src="./img/티하우스..png" alt="">
                        </div>    
                            <p>좋은 친구들</p>
                    </a>
                </li>
            </ul>
        </div><!--box3-->
    </div><!--.magazine-->

    <div class="pager">
        <a href="#"><p class="on">1</p></a>
        <a href=""><p>2</p></a>
        <a href=""><p>3</p></a>       
    </div><!--.pager-->
</div><!--.container-->
<%@ include file="footer.jsp" %>
</body>
</html>