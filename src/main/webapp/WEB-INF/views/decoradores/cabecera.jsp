<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<meta charset="UTF-8">
<meta name="description" content="Pagina principal del proyecto cero">
<meta name="keywords" content="HTML, CSS, XML, JavaScript, JAVA, Spring, Tomcat, SQL">
<meta name="author" content="Sergio Sacristan">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

		<c:set var="contextPath" value="${request.getContextPath()}"/>
		<script src="${contextPath}js/js.js"></script>
		<link rel="stylesheet" href="${contextPath}css/css.css">
		