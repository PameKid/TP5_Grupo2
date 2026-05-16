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
					<h1 class="h2">Formulario de Cliente</h1>
					<p class="text-muted">
						Usuario:
						<%=session.getAttribute("usuarioLogueado")%></p>
				</header>

				<section class="border rounded p-4 bg-white shadow-sm">

					<form method="post" action="AltaClienteServlet"
						class="needs-validation">
						<fieldset>
							<legend class="float-none w-auto px-2 fw-bold">Datos del
								Cliente</legend>

							<div class="row g-3">
								<div class="col-md-6">
									<label for="dni" class="form-label">DNI</label> <input
										type="text" class="form-control" id="dni" name="dni"
										pattern="\d{6,8}" title="Debe tener entre 6 y 8 números"
										required>
								</div>

								<div class="col-md-6">
									<label for="cuil" class="form-label">CUIL</label> <input
										type="text" class="form-control" id="cuil" name="cuil"
										pattern="\d{11}" title="Debe tener 11 dígitos sin guiones"
										required>
								</div>

								<div class="col-md-6">
									<label for="nombre" class="form-label">Nombre</label> <input
										type="text" class="form-control" id="nombre" name="nombre"
										pattern="[a-zA-ZáéíóúÁÉÍÓÚñÑ\s]+" title="Solo letras y espacios" required>
								</div>

								<div class="col-md-6">
									<label for="apellido" class="form-label">Apellido</label> <input
										type="text" class="form-control" id="apellido" name="apellido"
										pattern="[a-zA-ZáéíóúÁÉÍÓÚñÑ\s]+" title="Solo letras y espacios" required>
								</div>

								<div class="col-md-6">
									<label for="sexo" class="form-label">Sexo</label> <select
										class="form-select" id="sexo" name="sexo" required>
										<option value="" selected disabled>Seleccione...</option>
										<option value="M">Masculino</option>
										<option value="F">Femenino</option>
										<option value="Otro">Otro</option>
									</select>
								</div>

								<div class="col-md-6">
									<label for="fechaNacimiento" class="form-label">Fecha
										de Nacimiento</label> <input type="date" class="form-control"
										id="fechaNacimiento" name="fechaNacimiento" 
										max="<%= java.time.LocalDate.now() %>" required>
								</div>

								<div class="col-md-6">
									<label for="nacionalidad" class="form-label">Nacionalidad</label>
									<input type="text" class="form-control" id="nacionalidad"
										name="nacionalidad" required>
								</div>

								<div class="col-md-6">
									<label for="direccion" class="form-label">Dirección</label> <input
										type="text" class="form-control" id="direccion"
										name="direccion" required>
								</div>

								<div class="col-md-6">
									<label for="localidad" class="form-label">Localidad</label> <input
										type="text" class="form-control" id="localidad"
										name="localidad" required>
								</div>

								<div class="col-md-6">
									<label for="provincia" class="form-label">Provincia</label> <input
										type="text" class="form-control" id="provincia"
										name="provincia" required>
								</div>

								<div class="col-md-6">
									<label for="correoElectronico" class="form-label">Correo
										Electrónico *</label> <input type="email" class="form-control"
										id="correoElectronico" name="correoElectronico"
										placeholder="ejemplo@correo.com" required>
								</div>

								<div class="col-md-6">
									<label for="telefono" class="form-label">Teléfono</label> <input
										type="tel" class="form-control" id="telefono" name="telefono"
										pattern="\d{10}" title="Ingrese exactamente 10 dígitos" required>
								</div>

								<div class="col-12 mt-4 text-end">
									<button type="submit" class="btn btn-success px-5"
										name="btnGuardar">Guardar cliente</button>
								</div>
							</div>
						</fieldset>
					</form>
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