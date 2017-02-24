<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/Front/include/header.jsp"/>

<h2>Register</h2>
<c:choose>
	<c:when test="${empty campus}">
		<div>Vous ne pouvez pas encore vous enregistrer car aucun campus n'est disponible.</div>	
	</c:when>

	<c:otherwise>
	
	<div class = "Register">
		<form  class="formRegister" action="${pageContext.request.contextPath}/register" method="POST">
		
			<div class="chmpregister">Campus
			<select class="campBarreregister" name="campusId">
				<c:forEach items="${campus}" var="c">
					<option value="${c.idCampus}">${c.campusName}</option>
				</c:forEach>
			</select>
			</div>
			
			<div class="chmpregister">IdBooster
			<input class="inputTextregister1" placeholder="idBooster" type="text" name="idBooster" required><c:if test="${!empty IdControle}">
																										<div>${IdControle}</div>	
																					   </c:if>
			</div>
			<div class="chmpregister">First Name	
			<input class="inputTextregister" placeholder="firstName" type="text" name="firstName" required><c:if test="${!empty fnErr}">
																										<div>${fnErr}</div>	
																								   </c:if>
			</div>																					   
			<div class="chmpregister">Last  Name
			<input class="inputTextregister" placeholder="lastName" type="text" name="lastName" required><c:if test="${!empty lnErr}">
																									<div>${lnErr}</div>	
																								 </c:if>
			</div>	
			<div class="chmpregister">E-Mail
			<input class="inputTextregister2" placeholder="Mail" type="text" name="Mail" required><c:if test="${!empty MailErr}">
																								<div>${MailErr}</div>	
																							 </c:if>
			</div>
			<div class="chmpregister">Password
			<input class="inputTextregister3" placeholder="Mdp" type="text" name="Mdp" required>
			<input class="addButton" type="submit" value="Ajouter">
			</div>
		</form>
	</div>
</c:otherwise>
</c:choose>

<c:import url="/Front/include/footer.jsp"/>