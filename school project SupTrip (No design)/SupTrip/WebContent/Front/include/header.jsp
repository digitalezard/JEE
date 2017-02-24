<%@ page language="java" contentType="text/html; charset=UTF8" pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
		<title>SupTrip</title>
	
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/Front/css/style.css"/>
	</head>
	<body>
	<p class="logo">
	<img src="${pageContext.request.contextPath}/Front/img/SupTriplogo.jpg" alt="logo">
	</p>
	<div class="header">
		<c:choose>
			<c:when test="${empty sessionScope.idbooster}">
				<div class = "onglets">
				<a class="lienPage" href="${pageContext.request.contextPath}/register">REGISTER</a>
				<a class="lienPage" href="${pageContext.request.contextPath}/login">LOGIN</a>
				</div>
			</c:when>
			<c:otherwise>
				<div class = "onglets">
				<a class="lienPage" href="${pageContext.request.contextPath}/">HOME</a>
				<a class="lienPage" href="${pageContext.request.contextPath}/logout">LOGOUT</a>
				<a class="lienPage" href="${pageContext.request.contextPath}/auth/viewProfil">PROFIL</a>
				<a class="lienPage" href="${pageContext.request.contextPath}/auth/showBag">PANIER</a>
				<a class="lienPage" href="${pageContext.request.contextPath}/auth/showTrip">LISTE DES VOYAGES PAR CAMPUS</a>
				</div>
			</c:otherwise>
		</c:choose>
		
		<c:if test="${!empty sessionScope.root}">
		<div class = "onglets">
			<a class="lienPage" href="${pageContext.request.contextPath}/auth/addPays">AJOUTER PAYS</a>
			<a class="lienPage" href="${pageContext.request.contextPath}/auth/addCampus">AJOUTER CAMPUS</a>
			<a class="lienPage" href="${pageContext.request.contextPath}/auth/addTrip">AJOUTER VOYAGE</a>
			</div>
		</c:if>	
	</div>
	