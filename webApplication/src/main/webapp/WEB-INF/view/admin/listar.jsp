<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Listar Clientes</title>
</head>
<body>
	<table>
		<tr>
			<th>Id</th>
			<th>Nome</th>
		</tr>
		<c:forEach items="${clientes}" var="cliente">
			<tr id="cliente_${cliente.id}">
				<td>${cliente.id}</td> 
				<td>${cliente.nome }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>