package datosImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import datos.Conexion;
import datos.IUsuarioDao;
import entidad.Usuario;

public class UsuarioDaoImpl implements IUsuarioDao

{
	@Override
    public Usuario buscarUsuario(String nombreUsuario, String pass) throws Exception {
        
        Usuario usuario = null;
        Connection con = Conexion.getInstancia().getConnection();
        
        String sql = "SELECT * FROM usuarios WHERE usuario = ? AND contrasena = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombreUsuario);
            ps.setString(2, pass);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setNombreUsuario(rs.getString("usuario"));
                usuario.setContrasena(rs.getString("contrasena"));
                usuario.setIdUsuario(rs.getInt("id_usuario"));
            }
            
        } catch (Exception e) {
            throw e;
        }
        
        return usuario;
    }
	
	

}
