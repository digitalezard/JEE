<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/Front/include/header.jsp" />
<h2>Ajouter un Pays</h2>

<p>${success}</p>

<div class="form">
	<form action="${pageContext.request.contextPath}/auth/addPays" method="POST">
		<input class="inputText" placeholder="Nom" type="text" name="PaysName" required>
		<input class="addButton" type="submit" value="Ajouter">
	</form>
</div>

<c:import url="/Front/include/footer.jsp"/>