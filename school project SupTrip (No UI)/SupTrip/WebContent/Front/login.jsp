<%@ page language="java" contentType="text/html; charset=UTF8" pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/Front/include/header.jsp"/>

<div id="login">
<h2>Login</h2>

<form id="formLogin" action="login" method="POST">
	<label>Idbooster</label>
	<input class="inputText" type="text" name="idbooster" placeholder="idbooster">
	<label>Password</label>
	<input class="inputText" type="password" name="pwd" placeholder="MotdePasse">
	<input type="submit" value="OK">
</form>
</div>
<c:import url="/Front/include/footer.jsp"/>