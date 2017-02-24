<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="count" value="1"/>
<c:import url="/Front/include/header.jsp"/>

<div id="ListeVoyage">
	<h2>Votre commande</h2>
	
	<c:if test="${empty Order}">
		<p> Pas de Voyages </p>
	</c:if>
	
	
	<c:forEach items="${Order}" var="o">
		<div class="item${count}">
		
			<div class="label">Campus : ${o.trip.campus.campusName}</div>
			
			<div class="separator"></div>
			
			<div class="label">Nom : ${o.trip.name}</div>
			
			<div class="label">Contenu : ${o.trip.content}</div>
			
			<div class="label">Campus de départ: ${o.campusDepart}</div>
			
			<div class="label">Depart : ${o.trip.dateDepart}</div>
			
			<div class="label">Retour : ${o.trip.dateRetour}</div>
			
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
<c:import url="/Front/include/footer.jsp"/>