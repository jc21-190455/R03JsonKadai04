<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	int point = (int)request.getAttribute("point");
%>

{"POINT":<%=point %>}