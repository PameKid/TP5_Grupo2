<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Iniciar sesión</title>
<%@ include file="Encabezado.jsp" %>
</head>
<body class="bg-light d-flex justify-content-center align-items-center vh-100">

    <div class="card p-4 shadow-sm" style="width: 100%; max-width: 400px;">
        <h4 class="mb-4">Iniciar sesión</h4>
        
        <% 
            String error = (String) request.getAttribute("error");
            if (error != null) { 
        %>
            <div class="alert alert-danger" role="alert">
                <%= error %>
            </div>
        <% } %>

        <form action="LoginServlet" method="post">
            <div class="mb-3">
                <label for="usuario" class="form-label">Usuario</label>
                <input type="text" class="form-control" id="usuario" name="usuario" required>
            </div>
            <div class="mb-3">
                <label for="contrasena" class="form-label">Contraseña</label>
                <input type="password" class="form-control" id="contrasena" name="contrasena" required>
            </div>
            <button type="submit" class="btn btn-primary w-100 mt-2">Ingresar</button>
        </form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
</body>
</html>