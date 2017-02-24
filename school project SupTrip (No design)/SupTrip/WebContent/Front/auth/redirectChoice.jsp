<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/Front/include/header.jsp"/>

<div class = "redirectchoicepage">
<h2>Que voulez vous faire?</h2>

			<c:if test="${!empty sessionScope.idbooster}">
				<form action="${pageContext.request.contextPath}/auth/redirectChoice" method="POST">
					<input type="hidden" name="choice" value="panier">
					<input class="RedirectChoice"  type="submit" value="panier">
				</form>
				<a class="lienredirectchoice" href="${pageContext.request.contextPath}/auth/showTrip">Continuer mon Shopping</a>
			</c:if>
			<br>
</div>
<c:import url="/Front/include/footer.jsp"/>