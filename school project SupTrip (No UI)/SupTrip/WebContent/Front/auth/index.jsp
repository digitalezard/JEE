<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="count" value="1"/>
<c:import url="/Front/include/header.jsp"/>
	
	<div id="RechercheVoyage">
	
	<h2>Recherche de voyage par campus</h2>
	
	<form class="formCampus" action="${pageContext.request.contextPath}/auth/searchByCampus" method="POST">
	
	<select class="campSearchBarre" name="campussearch">
		<c:forEach items="${listCampus}" var="c">
				<option value="${c.campusName}">${c.campusName}</option>
		</c:forEach>
	</select>
	
	<input class="SearchButton" type="submit" value="Search">
	</form>
	</div>
	<br>
	<div id="ListeVoyage">
		<h2>Voyages disponibles</h2>
		
		<c:if test="${empty trip}">
			<p> Pas de Voyages </p>
		</c:if>
		<c:forEach items="${trip}" var="t">
			<div class="item${count}">
			
				<div class="label">Campus : ${t.campus.campusName}</div>
				
				<div class="separator"></div>
				
				<div class="label">Nom : ${t.name}</div>
				
				<div class="label">Contenu : ${t.content}</div>
				
				
				<div class="label">Depart : ${t.dateDepart}</div>
				
				<div class="label">Retour : ${t.dateRetour}</div>
				
				<div class="label">Campus de départ :</div>
				<c:if test="${!empty sessionScope.idbooster}">
					<form action="${pageContext.request.contextPath}/auth/addInBag" method="POST">
						<select class="campBarre" name="campusdepart">
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
	</div>
	<br>
<c:import url="/Front/include/footer.jsp"/>