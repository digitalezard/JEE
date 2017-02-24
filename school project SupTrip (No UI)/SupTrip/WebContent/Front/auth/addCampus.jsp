<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/Front/include/header.jsp"/>

<h2>Ajouter un Campus</h2>

<c:choose>
	<c:when test="${empty pays}">
		<div>Vous ne pouvez pas encore ajouter de campus car aucun pays n'est disponible. </div>	
		<a href="${pageContext.request.contextPath}/addPays">Ajouter un Pays</a>
	</c:when>

<c:otherwise>
	<div class="form">
		<form action="${pageContext.request.contextPath}/auth/addCampus" method="POST">
			<div>Pays</div>
			<select name="paysId">
				<c:forEach items="${pays}" var="p">
					<option value="${p.idPays}">${p.countryName}</option>
				</c:forEach>
			</select>
			<input class="inputText" placeholder="Nom" type="text" name="campusName" required>
			<input class="addButton" type="submit" value="Ajouter">
		</form>
	</div>
</c:otherwise>
</c:choose>

<c:import url="/Front/include/footer.jsp"/>