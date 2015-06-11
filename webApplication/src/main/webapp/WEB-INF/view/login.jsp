<html>
<head>
<link href="resources/css/bootstrap.min.css" rel="stylesheet" />
<script src="resources/js/bootstrap.min.js" type="text/javascript"></script>
<title>Login</title>
</head>
<body>
	<div class="container" style="width:300px;">
		<form class="form-signin" action="efetuaLogin" method="post">
			<h2 class="form-signin-heading">Entre com seus dados</h2>
			<label for="inputEmail" class="sr-only">Email</label> <input name="email"
				type="email" id="inputEmail" class="form-control"
				placeholder="Email address" required="required" autofocus="autofocus"><br/> <label
				for="inputPassword" class="sr-only">Senha</label> <input name="senha"
				type="password" id="inputPassword" class="form-control"
				placeholder="Password" required="required"><br/>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
		</form>
	</div>
</body>
</html>