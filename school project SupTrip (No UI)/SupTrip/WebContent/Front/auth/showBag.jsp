<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="count" value="1"/>
<c:import url="/Front/include/header.jsp"/>

<div id="ListeVoyage">
	<h2>Votre Panier</h2>
	
	<c:if test="${empty mytriplist}">
		<p> vous n'avez rien dans votre panier </p>
	</c:if>
	
	
	<c:forEach items="${mytriplist}" var="t">
		<div class="item${count}">
		
			<div class="label">Campus : ${t.campus.campusName}</div>
			
			<div class="separator"></div>
			
			<div class="label">Nom : ${t.name}</div>
			
			<div class="label">Contenu : ${t.content}</div>
			
			<div class="label">Depart : ${t.dateDepart}</div>
			
			<div class="label">Retour : ${t.dateRetour}</div>
			
			
		</div>
		<c:choose>
				<c:when test="${count < 3}">
					<c:set var="count" value="${count + 1}"/>
				</c:when>
				<c:when test="${count >= 3}">
					<c:set var="count" value="1"/>
				</c:when>
		</c:choose>
	</c:forEach>
	<c:if test="${!empty mytriplist}">
	<form action="${pageContext.request.contextPath}/auth/proceedOrder" method="POST">
			<input type="hidden" name="Order" value="Commander">
			<input class="Order"  type="submit" value="Commander">
	</form>
	</c:if>
</div>
<c:import url="/Front/include/footer.jsp"/>