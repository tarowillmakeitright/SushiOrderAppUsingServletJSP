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
<p>確認</p>
<% for(int i=0;i<order.getNames().length;i++){ %>
<%=order.getNames()[i] %>:<%=order.getCounts()[i] %>皿<br>
<%} %>
<a href="/sushiOrder/OrderMain?action=back">戻る</a>
<a href="/sushiOrder/OrderMain?action=submit">確定</a>
</body>
</html>