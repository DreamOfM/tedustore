<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>我的订单 - 达内学子商城</title>
    <link href="${pageContext.request.contextPath}/css/orders.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/header.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/footer.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/personage.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/icon/css/bootstrap.min.css">
	<link href="${pageContext.request.contextPath}/css/icon/css/cropper.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/icon/css/sitelogo.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/icon/css/font-awesome.min.css">
</head>
<body>
    <div id="leftsidebar_box" class="lf">
        <div class="line"></div>
        <dl class="my_order">
            <dt >我的订单
                <img src="${pageContext.request.contextPath}/images/myOrder/myOrder1.png">
            </dt>
            <dd class="first_dd"><a href="orders.html">全部订单</a></dd>
            <dd>
                <a href="#">
                    待付款
                    <span><!--待付款数量--></span>
                </a>
            </dd>
            <dd>
                <a href="#">
                    待收货
                    <span><!--待收货数量-->1</span>
                </a>
            </dd>
            <dd>
                <a href="#">
                    待评价<span><!--待评价数量--></span>
                </a>
            </dd>
            <dd>
                <a href="#">退货退款</a>
            </dd>
        </dl>

        <dl class="footMark">
            <dt >我的优惠卷<img src="${pageContext.request.contextPath}/images/myOrder/myOrder1.png"></dt>
        </dl>

        <dl class="address">
                <dt>收货地址<img src="${pageContext.request.contextPath}/images/myOrder/myOrder1.png"></dt>
				<dd><a href="${pageContext.request.contextPath}/address/showAddress.do">地址管理</a></dd>
            </dl>
            <dl class="count_managment">
                <dt >帐号管理<img src="${pageContext.request.contextPath}/images/myOrder/myOrder1.png"></dt>
                <dd class="first_dd"><a href="personage.html">我的信息</a></dd>
                <dd><a href="personal_password.html">安全管理</a></dd>
            </dl>
    </div>
</body>
</html>