<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Fintech</title>

<!-- Font Icon -->
<link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="main">
		<!-- Sign up form -->
		<section class="signup">
			<div class="container">

				<div class="signup-content">
					<div class="signup-form">
						<h2 class="form-title">Cadastrar usuário</h2>
						<c:if test="${not empty msg }">
							<div class="alert alert-success">${msg}</div>
						</c:if>
						<c:if test="${not empty erro }">
							<div class="alert alert-danger">${erro}</div>
						</c:if>
						<form method="post" action="usuario" class="register-form"
							id="register-form">
							<input type="hidden" value="cadastrar" name="acao">
							<div class="form-group">
								<label for="nome"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="nome" id="nome" placeholder="Seu nome" />
							</div>
							<div class="form-group">
								<label for="telefone"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="text" name="telefone" id="telefone"
									placeholder="Telefone" />
							</div>
							<div class="form-group">
								<label for="email"><i class="zmdi zmdi-email"></i></label> <input
									type="email" name="email" id="email" placeholder="Seu email" />
							</div>
							<div class="form-group">
								<label for="senha"><i class="zmdi zmdi-lock"></i></label> <input
									type="password" name="senha" id="senha" placeholder="Senha" />
							</div>
							<div class="form-group form-button">
								<input type="submit" name="cadastrar" id="cadastrar"
									class="form-submit" value="Cadastrar" />
							</div>
						</form>
					</div>
					<div class="signup-image">
						<figure>
							<img src="images/signup-image.jpg" alt="sing up image">
						</figure>
						<li class="nav-item"><a class="nav-link"
							href="menu.jsp">Retornar ao menu</a></li>
					</div>
				</div>
			</div>
		</section>
	</div>
	<!-- JS -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>



</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>