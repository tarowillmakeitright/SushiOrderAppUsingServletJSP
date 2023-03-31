<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Order" %>
<%
Order order=(Order)session.getAttribute("order");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>すしアプリ</title>
</head>
<body>
<p>ご注文は「<%=order.getMsg() %>」ですね！</p>
<p>合計<%=order.getTotalCount() %>皿で<%=order.getTotalFee() %>円頂戴致します！</p>
<a href="/sushiOrder/OrderMain">戻る</a>
</body>
</html>