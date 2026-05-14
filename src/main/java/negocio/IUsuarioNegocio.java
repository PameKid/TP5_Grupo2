package negocio;

import entidad.Usuario;

public interface IUsuarioNegocio {
	
	public Usuario validarUsuario(String nombreUsuario, String pass) throws Exception;
	
}
