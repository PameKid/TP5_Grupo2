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
    public Usuario buscarUsuario(String nombreUsuario, String pass) {
        
        Usuario usuario = null;
        Connection con = Conexion.getInstancia().getConnection();
        
        String sql = "SELECT * FROM usuarios WHERE nombre_usuario = ? AND pass = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombreUsuario);
            ps.setString(2, pass);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setNombreUsuario(rs.getString("nombre_usuario"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return usuario;
    }
	
	

}
