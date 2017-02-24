<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/Front/include/header.jsp"/>

<div class="pagedacceuil">
<p id="Description">SupTrip est une application de réservation de voyages entre les campus supinfo, elle permet de rechercher les voyages par campus, 
					d'obtenir la listes des voyages trier par campus, d'ajouter des voyages dans votre panier et de passer votre reservation.</p>
<div class="Stats">nombre de Trip: ${statTrip}</div>
<div class="Stats">nombre d'utilisateurs: ${statStud}</div>
<a class ="lienRest" href="${pageContext.request.contextPath}/resources/trip/all">telecharger la liste des voyages en json</a>

</div>

<c:import url="/Front/include/footer.jsp"/>