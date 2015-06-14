<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<style type="text/css">
body {
	padding-top: 20px;
	padding-bottom: 20px;
}

.table {
	margin-bottom: 20px;
}
</style>

<jsp:include page="../modulos/headerAdmin.jsp" />
<title>Insert title here</title>
</head>
<body>
	<div class="container" style="width: 1000px;">

		<table class="table table-hoverl">
			<tr>
				<th>#</th>
				<th>Nome</th>
				<th>Cpf</th>
				<th>Data Nascimento</th>
				<th>Data Vencimento</th>
				
			</tr>
			<c:forEach items="${clientes}" var="cliente">
				<tr id="cliente_${cliente.id}">
					<td>${cliente.id}</td>
					<td>${cliente.nome }</td>
					<td>${cliente.cpf }</td>
					<td>${cliente.dataNascimento }</td>
					<td>${cliente.dataVencimento }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>