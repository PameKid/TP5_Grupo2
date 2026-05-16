<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alta cliente</title>
<%@ include file="Encabezado.jsp"%>
</head>
<body>

	<div class="container-fluid">
		<div class="row">
			<nav class="col-md-3 col-lg-2 bg-primary text-black min-vh-100 p-3">
				<h4 class="mb-4">Menú</h4>
				<div class="d-grid gap-2 mb-2">
					<a href="AltaCliente.jsp" class="btn btn-light text-start shadow-sm"> Alta de
						Cliente </a>
				</div>
				<div class="d-grid gap-2 mb-2">
					<a href="ListadoClientes.jsp" class="btn btn-light text-start shadow-sm"> Listado
						de Clientes </a>
				</div>
			</nav>
			<main class="col-md-9 col-lg-10 ms-sm-auto px-md-4 py-4">

				<header class="mb-4">
					<h1 class="h2">Listado de Clientes</h1>
					<p class="text-muted">
						Usuario:
						<%=session.getAttribute("usuarioLogueado")%></p>
				</header>

				<section class="border rounded p-4 bg-white shadow-sm">

                 *****************************
                 
                 ACA VA LA TABLA
                 
                 
                ******************************

					<%
					String error = (String) request.getAttribute("error");
					if (error != null) {
					%>
					<div class="alert alert-danger mt-4 mb-4" role="alert">
						<%=error%>
					</div>
					<%
					}
					%>

				</section>

			</main>

		</div>
	</div>
</body>
</html>