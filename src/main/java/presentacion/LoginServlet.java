package presentacion;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import negocio.IUsuarioNegocio;
import negocioImpl.UsuarioNegocioImpl;
import entidad.Usuario;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//instanciar la capa negocioUsuario
	
	IUsuarioNegocio negocioUsuario = new UsuarioNegocioImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//capturo el usuario y contrasenia que se va a escribie en el Login.jsp
		String nombreUsuario = request.getParameter("usuario");
		String contrasena = request.getParameter("contrasena");
		
		try {
		    Usuario usuario = negocioUsuario.validarUsuario(nombreUsuario, contrasena);
		    
		    if (usuario != null) {
		        HttpSession session = request.getSession();
		        session.setAttribute("usuarioLogueado", usuario.getNombreUsuario());
		        response.sendRedirect("AltaCliente.jsp");
		    } else {
		        request.setAttribute("error", "Usuario o contraseña incorrectos.");
		        request.getRequestDispatcher("Login.jsp").forward(request, response);
		    }
		    
		} catch (Exception e) {
		    request.setAttribute("error", "Error al conectar con la base de datos.");
		    request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
	}

}
