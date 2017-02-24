<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/Front/include/header.jsp"/>

<h2>Ajouter un voyage</h2>

<c:choose>
	<c:when test="${empty campus}">
		<div>Vous ne pouvez pas encore ajouter de voyage car aucun campus n'est disponible. </div>	
		<a href="${pageContext.request.contextPath}/addCampus">Ajouter un Campus</a>
	</c:when>

	<c:otherwise>
	<div class="form">
		<form action="${pageContext.request.contextPath}/auth/addTrip" method="POST">
			<div>Campus</div>
			<select name="campusId">
				<c:forEach items="${campus}" var="c">
					<option value="${c.idCampus}">${c.campusName}</option>
				</c:forEach>
			</select>
			<input class="inputText" placeholder="Depart" type="text" name="DateDepart" required>
			<input class="inputText" placeholder="Retour" type="text" name="DateRetour" required>
			<input class="inputText" placeholder="Nom" type="text" name="tripName" required>
			<input class="inputText" placeholder="Content" type="text" name="tripContent" required>
			<input class="addButton" type="submit" value="Ajouter">
		</form>
	</div>
</c:otherwise>
</c:choose>

<c:import url="/Front/include/footer.jsp"/>