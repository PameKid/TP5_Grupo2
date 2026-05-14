package datosImpl;

import datos.IClienteDao;
import datos.Conexion;
import entidad.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClienteDaoImpl implements IClienteDao {

    @Override
    public void insertar(Cliente cliente) throws Exception {
        Connection con = Conexion.getInstancia().getConnection();
        String sql = "INSERT INTO clientes (dni, cuil, nombre, apellido, sexo, fecha_nacimiento, direccion, nacionalidad, localidad, provincia, correo_electronico, telefono) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, cliente.getDni());
            ps.setString(2, cliente.getCuil());
            ps.setString(3, cliente.getNombre());
            ps.setString(4, cliente.getApellido());
            ps.setString(5, cliente.getSexo());
            ps.setString(6, cliente.getFechaNacimiento() != null ? cliente.getFechaNacimiento().toString() : null);
            ps.setString(7, cliente.getDireccion());
            ps.setString(8, cliente.getNacionalidad());
            ps.setString(9, cliente.getLocalidad());
            ps.setString(10, cliente.getProvincia());
            ps.setString(11, cliente.getCorreoElectronico());
            ps.setString(12, cliente.getTelefono());

            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    cliente.setIdCliente(rs.getInt(1));
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Cliente> listar() throws Exception {
        List<Cliente> lista = new ArrayList<>();
        Connection con = Conexion.getInstancia().getConnection();
        String sql = "SELECT * FROM clientes";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setIdCliente(rs.getInt("id_cliente"));
                c.setDni(rs.getString("dni"));
                c.setCuil(rs.getString("cuil"));
                c.setNombre(rs.getString("nombre"));
                c.setApellido(rs.getString("apellido"));
                c.setSexo(rs.getString("sexo"));
                String fecha = rs.getString("fecha_nacimiento");
                if (fecha != null && !fecha.trim().isEmpty()) {
                    c.setFechaNacimiento(LocalDate.parse(fecha));
                }
                c.setDireccion(rs.getString("direccion"));
                c.setNacionalidad(rs.getString("nacionalidad"));
                c.setLocalidad(rs.getString("localidad"));
                c.setProvincia(rs.getString("provincia"));
                c.setCorreoElectronico(rs.getString("correo_electronico"));
                c.setTelefono(rs.getString("telefono"));
                lista.add(c);
            }
            rs.close();
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

}
