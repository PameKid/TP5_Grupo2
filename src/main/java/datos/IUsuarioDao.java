package datos;

import entidad.Usuario;

public interface IUsuarioDao {
	
	Usuario buscarUsuario(String nombreUsuario, String contrasena) throws Exception;

}
