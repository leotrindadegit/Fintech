<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
						<h2 class="form-title">Edição de investimento</h2>
						<form method="post" action="investimento" class="register-form"
							id="register-form">
							<input type="hidden" value="editar" name="acao">
							<input type="hidden" value="${investimento.codigo}" name="codigo">
							<div class="form-group">
								<label for="nome"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="nome" id="nome" placeholder="Nome investimento" value="${investimento.nome}" />
							</div>
							<div class="form-group">
								<label for="nome"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="dataInvestimento" id="nome" placeholder="Data investimento" value='<fmt:formatDate value="${investimento.dataInvestimento.time }" pattern="dd/MM/yyyy"/>'>
							</div>
							<div class="form-group">
								<label for="nome"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="valorInvestimento" id="nome" placeholder="Valor investimento" value="${investimento.valorInvestimento}" />
							</div>
							<div class="form-group">
								<label for="nome"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="valorPercentual" id="nome" placeholder="Valor percentual" value="${investimento.valorPercentual}" />
							</div>
							<div class="form-group">
								<label for="nome"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="retorno" id="nome" placeholder="Retorno estimado" value="${investimento.retorno}" />
							</div>

							<div class="form-group form-button">
								<input type="submit" name="Salvar" class="form-submit"/>
								<a href="investimento?acao=listar" class="btn btn-danger">Cancelar</a>
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