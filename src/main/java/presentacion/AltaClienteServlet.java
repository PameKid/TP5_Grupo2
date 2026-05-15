package presentacion;

import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import negocio.IClienteNegocio;
import negocioImpl.ClienteNegocioImpl;
import entidad.Cliente;

/**
 * Servlet implementation class AltaClienteServlet
 */
@WebServlet("/AltaClienteServlet")
public class AltaClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// instanciar la capa de negocio
	IClienteNegocio negocioCliente = new ClienteNegocioImpl();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. Validar que el usuario tenga una sesión activa
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("usuarioLogueado") == null) {
			request.setAttribute("error", "Debe iniciar sesión para acceder.");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
			return;
		}
		
		// 2. Capturar parámetros y verificar que no sean nulos/vacíos
		String dni = request.getParameter("dni");
		String cuil = request.getParameter("cuil");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String sexo = request.getParameter("sexo");
		String fechaNacimiento = request.getParameter("fechaNacimiento");
		String direccion = request.getParameter("direccion");
		String nacionalidad = request.getParameter("nacionalidad");
		String localidad = request.getParameter("localidad");
		String provincia = request.getParameter("provincia");
		String correoElectronico = request.getParameter("correoElectronico");
		String telefono = request.getParameter("telefono");
		
		// Validar que ningún campo esté vacío o nulo
		if (dni == null || dni.trim().isEmpty() ||
			cuil == null || cuil.trim().isEmpty() ||
			nombre == null || nombre.trim().isEmpty() ||
			apellido == null || apellido.trim().isEmpty() ||
			sexo == null || sexo.trim().isEmpty() ||
			fechaNacimiento == null || fechaNacimiento.trim().isEmpty() ||
			direccion == null || direccion.trim().isEmpty() ||
			nacionalidad == null || nacionalidad.trim().isEmpty() ||
			localidad == null || localidad.trim().isEmpty() ||
			provincia == null || provincia.trim().isEmpty() ||
			correoElectronico == null || correoElectronico.trim().isEmpty() ||
			telefono == null || telefono.trim().isEmpty()) {
			
			request.setAttribute("error", "Debe ingresar todos los campos para poder continuar.");
			request.getRequestDispatcher("AltaCliente.jsp").forward(request, response);
			return;
		}
		
		try {
			// 3. Armar el objeto Cliente
			Cliente cliente = new Cliente();
			cliente.setDni(dni.trim());
			cliente.setCuil(cuil.trim());
			cliente.setNombre(nombre.trim());
			cliente.setApellido(apellido.trim());
			cliente.setSexo(sexo.trim());
			cliente.setFechaNacimiento(LocalDate.parse(fechaNacimiento));
			cliente.setDireccion(direccion.trim());
			cliente.setNacionalidad(nacionalidad.trim());
			cliente.setLocalidad(localidad.trim());
			cliente.setProvincia(provincia.trim());
			cliente.setCorreoElectronico(correoElectronico.trim());
			cliente.setTelefono(telefono.trim());
			
			// Llamar a la capa de negocio para guardar
			negocioCliente.insertar(cliente);
			
			// Redirigir a la lista de clientes
			response.sendRedirect("ListadoClientes.jsp");
			
		} catch (IllegalArgumentException e) {
			// Error de validación en la entidad (campos inválidos)
			request.setAttribute("error", "Error de validación: " + e.getMessage());
			request.getRequestDispatcher("AltaCliente.jsp").forward(request, response);
		} catch (Exception e) {
			// Error general (ej: duplicado de correo, BD, etc.)
			request.setAttribute("error", e.getMessage());
			request.getRequestDispatcher("AltaCliente.jsp").forward(request, response);
		}
	}
}
