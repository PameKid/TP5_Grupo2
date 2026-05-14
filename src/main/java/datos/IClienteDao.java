package datos;

import entidad.Cliente;
import java.util.List;

public interface IClienteDao {

    void insertar(Cliente cliente) throws Exception;

    List<Cliente> listar() throws Exception;

}
