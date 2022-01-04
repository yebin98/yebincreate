<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="resources/css/container1.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@ include file="header.jsp" %>
<div id="container">
           <!-- 본문1 -->
    <div class="main1">
        <div class="msImg">
            <a href="#"><img src="./img/tea_time1.jpg" alt=""></a>
        </div><!--msImg-->

        <div class="msPager">
            <ul>
                <li><a href="#">일구다<br>가꾸다</a></li>
                <li><a href="#">Since<br> 1979</a></li>
                <li><a href="#">오설록<br> 차밭</a></li>
                <li><a href="#">숫자로보는<br>오설록</a></li>
                <li class="on"><a href="#">차<br>하우스</a></li>
            </ul>
        </div>
    </div><!--.mainSlide-->

    <!-- 본문2 -->
    <section class="main2">
        <h2>차 알아보기</h2>
        <ul>
            <li class="tea1">
                <a href="#">
                    <p class="over">
                        <span>명차</span>
                    </p>
                </a>
            </li>
            <li class="tea2">
                <a href="#">
                    <p class="over">
                        <span>녹차/발효차/홍차</span>
                    </p>
                </a>
            </li>
            <li class="tea3">
                <a href="#">
                    <p class="over">
                        <span>건강차</span>
                    </p>
                </a>
            </li>
            <li class="tea4">
                <a href="#">
                    <p class="over">
                        <span>꽃/과일차</span>
                    </p>
                </a>
            </li>
        </ul>
    </section><!--.main2-->

    <section class="main3">
        <h2 class="m3_title"><a href="#">▽</a> 나만의 맞춤제품</h2>
        <div class="taste">
            <select name="kind" id="" class="t_kind">
                <option value="">종류</option>
                <option value="녹차">명차</option>
                <option value="녹차">녹차</option>
                <option value="홍차">홍차</option>
                <option value="발효차">발효차</option>
                <option value="건강차">건강차</option>
                <option value="꽃/과일차">꽃/과일차</option>
                <option value="뷰티">뷰티</option>
            </select>
            <select name="scent" id="" class="t_scent">
                <option value="">향</option>
                <option value="달달한향">달달한향</option>
                <option value="쓴향">쓴향</option>
                <option value="고소한향">고소한향</option>
                <option value="꽃향">꽃향</option>
                <option value="과일향">과일향</option>
            </select>
            <select name="product" id="" class="t_product">
                <option value="">상품타입</option>
                <option value="단품">단품</option>
                <option value="세트">세트</option>
            </select>
            <div class="checkbox">
                <div class="color">
                    <input type="checkbox" name="red" id="RED">
                    <label for="RED" class="color_red"></label>
                </div>
                <div class="color">
                    <input type="checkbox" name="orange" id="ORANGE">
                    <label for="ORANGE" class="color_orange"></label>
                </div>
                <div class="color">
                    <input type="checkbox" name="yellow" id="YELLOW">
                    <label for="YELLOW" class="color_yellow"></label>
                </div>
                <div class="color">
                    <input type="checkbox" name="green" id="GREEN">
                    <label for="GREEN" class="color_green"></label>
                </div>
                <div class="color">
                    <input type="checkbox" name="blue" id="BLUE">
                    <label for="BLUE" class="color_blue"></label>
                </div>
                <div class="color">
                    <input type="checkbox" name="purple" id="PURPLE">
                    <label for="PURPLE" class="color_purple"></label>
                </div>
            </div>
        </div><!--.taste-->

        <div class="m3_item">
            <ul>
                <li>
                    <div class="m3_item_box">
                        <p class="m3_ib_img">
                            <a href=""><img src="./img/웨딩그린티 10입(피라미드).png" alt=""></a>
                        </p>
                        <p class="m3_ib_name"><a href=""> 웨딩그린티 10입</a></p>
                        <p class="m3_ib_prise">15000원</p>
                    </div>
                    <div class="num_cart">
                        <form action="">
                            <select name="number" id="">
                                <option value="1" selected="select">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                                <option value="7">7</option>
                                <option value="8">8</option>
                                <option value="9">9</option>
                                <option value="10">10</option>
                            </select>
                            <p><input type="button" value="장바구니" id="cart"></p>
                        </form>
                    </div>
                </li>
                <li>
                    <div class="m3_item_box">
                        <p class="m3_ib_img">
                            <a href=""><img src="./img/웨딩그린티 20입(피라미드).png" alt=""></a>
                        </p>
                        <p class="m3_ib_name"><a href=""> 웨딩그린티 20입</a></p>
                        <p class="m3_ib_prise">23000원</p>
                    </div>
                    <div class="num_cart">
                        <form action="">
                            <select name="" id="">
                                <option value="1" selected="select">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                                <option value="7">7</option>
                                <option value="8">8</option>
                                <option value="9">9</option>
                                <option value="10">10</option>
                            </select>
                            <p><input type="button" value="장바구니" id="cart"></p>
                        </form>
                    </div>
                </li>
                <li>
                    <div class="m3_item_box">
                        <p class="m3_ib_img">
                            <a href=""><img src="./img/벛꽃향기가득한올레 10입(피라미드).png" alt=""></a>
                        </p>
                        <p class="m3_ib_name"><a href=""> 벛꽃향기가득한올레 10입</a></p>
                        <p class="m3_ib_prise">15000원</p>
                    </div>
                    <div class="num_cart">
                        <form action="">
                            <select name="" id="">
                                <option value="1" selected="select">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                                <option value="7">7</option>
                                <option value="8">8</option>
                                <option value="9">9</option>
                                <option value="10">10</option>
                            </select>
                            <p><input type="button" value="장바구니" id="cart"></p>
                        </form>
                    </div>
                </li>
                <li>
                    <div class="m3_item_box">
                        <p class="m3_ib_img">
                            <a href=""><img src="./img/산도롱 산딸기 10.png" alt=""></a>
                        </p>
                        <p class="m3_ib_name"><a href="">산도롱 산딸기 10입</a></p>
                        <p class="m3_ib_prise">15000원</p>
                    </div>
                    <div class="num_cart">
                        <form action="">
                            <select name="" id="">
                                <option value="1" selected="select">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                                <option value="7">7</option>
                                <option value="8">8</option>
                                <option value="9">9</option>
                                <option value="10">10</option>
                            </select>
                            <p><input type="button" value="장바구니"></p>
                        </form>
                    </div>
                </li>
            </ul>
        </div><!--item-->
        <div class="main3_a">
            <div class="main3_l">
                <a href="#">왼쪽으로 가기</a> 
            </div>
            <div class="main3_r">
                <a href="#">오른쪽으로 가기</a> 
            </div>
        </div>
    </section><!--.main3-->

    <section class="main4">
        <h2 class="m4_title"><a href="#">▽</a> 이번주 할인상품</h2>
        <div class="m4_item">
            <ul>
                <li>
                    <div class="m4_item_box">
                        <p class="m4_ib_img">
                            <a href=""><img src="./img/제주얼그레이.png" alt=""></a>
                        </p>
                        <p class="m4_ib_name"><a href=""> 제주 얼그레이 20입</a></p>
                        <p>
                            <span class="m4_ib_prise_d">7040원</span> &nbsp;
                            <span class="m4_ib_prise">8800원</span>
                        </p>
                    </div>
                    <div class="num_cart">
                        <form action="">
                            <select name="number" id="">
                                <option value="1" selected="select">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                                <option value="7">7</option>
                                <option value="8">8</option>
                                <option value="9">9</option>
                                <option value="10">10</option>
                            </select>
                            <p><input type="button" value="장바구니" id="cart"></p>
                        </form>
                    </div>
                </li>
                <li>
                    <div class="m4_item_box">
                        <p class="m4_ib_img">
                            <a href=""><img src="./img/제주화산암차.png" alt=""></a>
                        </p>
                        <p class="m4_ib_name"><a href=""> 제주화산암차 10입</a></p>
                        <p>                                    
                            <span class="m4_ib_prise_d">12000원</span> &nbsp;
                            <span class="m4_ib_prise">15000원</span>
                        </p>                             
                    </div>
                    <div class="num_cart">
                        <form action="">
                            <select name="" id="">
                                <option value="1" selected="select">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                                <option value="7">7</option>
                                <option value="8">8</option>
                                <option value="9">9</option>
                                <option value="10">10</option>
                            </select>
                            <p><input type="button" value="장바구니" id="cart"></p>
                        </form>
                    </div>
                </li>
                <li>
                    <div class="m4_item_box">
                        <p class="m4_ib_img">
                            <a href=""><img src="./img/달빛걷기.png" alt=""></a>
                        </p>
                        <p class="m4_ib_name"><a href=""> 달빛걷기 10입</a></p>
                        <p>                                    
                            <span class="m4_ib_prise_d">12000원</span> &nbsp;
                            <span class="m4_ib_prise">15000원</span>
                        </p>
                    </div>
                    <div class="num_cart">
                        <form action="">
                            <select name="" id="">
                                <option value="1" selected="select">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                                <option value="7">7</option>
                                <option value="8">8</option>
                                <option value="9">9</option>
                                <option value="10">10</option>
                            </select>
                            <p><input type="button" value="장바구니" id="cart"></p>
                        </form>
                    </div>
                </li>
                <li>
                    <div class="m4_item_box">
                        <p class="m4_ib_img">
                            <a href=""><img src="./img/삼다연.png" alt=""></a>
                        </p>
                        <p class="m4_ib_name"><a href="">삼다연 10입</a></p>
                        <p>
                            <span class="m4_ib_prise_d">12000원</span> &nbsp;
                            <span class="m4_ib_prise">15000원</span>                                   
                        </p>
                    </div>
                    <div class="num_cart">
                        <form action="">
                            <select name="" id="">
                                <option value="1" selected="select">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                                <option value="7">7</option>
                                <option value="8">8</option>
                                <option value="9">9</option>
                                <option value="10">10</option>
                            </select>
                            <p><input type="button" value="장바구니"></p>
                        </form>
                    </div>
                </li>
            </ul>
        </div><!--m4_item-->
        <div class="main4_a">
            <div class="main4_l">
                <a href="#">왼쪽으로 가기</a> 
            </div>
            <div class="main4_r">
                <a href="#">오른쪽으로 가기</a> 
            </div>
        </div>
    </section><!--.main4-->
</div><!--#container-->
<%@ include file="footer.jsp" %>
</body>
</html>