<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/Front/include/header.jsp"/>
	
	<div class="Profil">
	<h2>Profil</h2>
	
	<c:if test="${empty student}">
		<p> Pas d'étudiant séléctionné</p>
	</c:if>
	
	
	
		
		
			<div class="label">idBooster : ${student.idBooster}</div>
			
			<div class="label">Campus : ${student.campus.campusName}</div>
			
			<div class="separator"></div>
			
			<div class="label">prénom : ${student.firstName}</div>
			
			<div class="label">Nom : ${student.lastName}</div>	
			
			<div class="label">Mail : ${student.mail}</div>
			
			<form action="${pageContext.request.contextPath}/auth/viewProfil" method="POST">
				<input type="hidden" name="setProfil" value="set">
				<input class="SetProfilBoutton" type="submit" value="Set Profil">
			</form>
			
			<c:if test="${!empty sessionScope.setprofil}">
				<form class="formsetprofil"action="${pageContext.request.contextPath}/auth/setProfil" method="POST">
					<select name="campusId">
						<c:forEach items="${listCampus}" var="c">
							<option value="${c.idCampus}">${c.campusName}</option>
						</c:forEach>
					</select>
					<input class="inputText" type="text" name="firstname" placeholder="First Name"><c:if test="${!empty fnErr}">
																					<div>${fnErr}</div>	
																				 </c:if>
					<input class="inputText" type="text" name="lastname" placeholder="lastName"><c:if test="${!empty lnErr}">
																					<div>${lnErr}</div>	
																			  </c:if>
					<input class="inputText" type="text" name="mail" placeholder="Mail"><c:if test="${!empty MailErr}">
																			<div>${MailErr}</div>	
																	  </c:if>
					<input class="inputText" type="text" name="password" placeholder="Password">
					<input class="addInBagButton" type="submit" value="set">
				</form>
			</c:if>
			
		</div>
		<br>
	
<c:import url="/Front/include/footer.jsp"/>