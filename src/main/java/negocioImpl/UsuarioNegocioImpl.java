package negocioImpl;

import negocio.IUsuarioNegocio;
import entidad.Usuario;
import datos.IUsuarioDao;
import datosImpl.UsuarioDaoImpl;

public class UsuarioNegocioImpl implements IUsuarioNegocio{
	
	// instancia la capa de datos
	IUsuarioDao datosUsuario = new UsuarioDaoImpl();
	
	public Usuario validarUsuario(String nombreUsuario, String pass) throws Exception {
		
		// se valida que el usuario o pass sean null
		if(nombreUsuario != null && pass != null) {
			// se remueven espacios del string
			nombreUsuario = nombreUsuario.trim();
			pass = pass.trim(); 	
		} else {
			throw new IllegalArgumentException("Faltan parámetros requeridos.");
		}
		
	    // se valida longitud máxima de caracteres
	    if (nombreUsuario.length() > 50 || pass.length() > 255) {
	    	throw new IllegalArgumentException("Se excedieron los caracteres máximos.");
	    }
	    
	    try {
		    // se invoca a la capa de datos para obtener usuario de la base de datos 
		    Usuario login = datosUsuario.buscarUsuario(nombreUsuario, pass);
		    // si el usuario o contraseña son invalidos, se retorna un objeto usuario null
		    return login;
		    } 
	    catch(Exception e) 
		    {
		    	throw new Exception("No se pudo acceder a la base de datos.");
		    }
	}
}
