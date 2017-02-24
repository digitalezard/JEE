<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="count" value="1"/>
<c:import url="/Front/include/header.jsp"/>

<div id="ListeVoyage">
	<h2>Voyage par campus</h2>
	
	<c:if test="${empty tripbycampus}">
		<p> Pas de Voyages </p>
	</c:if>

<c:forEach items="${tripbycampus}" var="t">
		<div class="item${count}">
		
			<div class="label">Campus : ${t.campus.campusName}</div>
			
			<div class="separator"></div>
			
			<div class="label">Nom : ${t.name}</div>
			
			<div class="label">Contenu : ${t.content}</div>
			
			<div class="label">Depart : ${t.dateDepart}</div>
			
			<div class="label">Retour : ${t.dateRetour}</div>
			
			<c:if test="${!empty sessionScope.idbooster}">
				<form action="${pageContext.request.contextPath}/auth/addInBag" method="POST">
					<select name="campusdepart">
						<c:forEach items="${listCampus}" var="c">
								<option value="${c.campusName}">${c.campusName}</option>
						</c:forEach>
					</select>
					<input type="hidden" name="id" value="${t.idTrip}">
					<input class="addInBagButton" type="submit" value="add">
				</form>
			</c:if>
			
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
	<a class="lienRest" href="${pageContext.request.contextPath}/resources/trip/${campsearch}">telecharger au format json</a>
	</div>
	<c:import url="/Front/include/footer.jsp"/>