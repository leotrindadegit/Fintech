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
						<h2 class="form-title">Edição de conta</h2>
						<form method="post" action="conta" class="register-form"
							id="register-form">
							<input type="hidden" value="editar" name="acao">
							<input type="hidden" value="${conta.codigo}" name="codigo">
							<div class="form-group">
								<label for="nome"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="nome" id="nome" placeholder="Agencia" value="${conta.agencia}" />
							</div>
							<div class="form-group">
								<label for="nome"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="nome" id="nome" placeholder="Tipo" value="${conta.tipo}" />
							</div>

							<div class="form-group form-button">
								<input type="submit" name="Salvar" class="form-submit"/>
								<a href="conta?acao=listar" class="btn btn-danger">Cancelar</a>
							</div>
						</form>
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