package negocio;

import entidad.Usuario;

public interface IUsuarioNegocio {
	
	public Usuario validarUsuario(String nombreUsuario, String contrasena) throws Exception;
	
}
