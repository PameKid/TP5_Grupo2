package negocioImpl;

import java.util.List;

import negocio.IClienteNegocio;
import entidad.Cliente;
import datos.IClienteDao;
import datosImpl.ClienteDaoImpl;

public class ClienteNegocioImpl implements IClienteNegocio {

    // instancia la capa de datos
    IClienteDao datosCliente = new ClienteDaoImpl();

    @Override
    public void insertar(Cliente cliente) throws Exception {

        // valida correo duplicado
        for (Cliente c : datosCliente.listar()) {
            if (c.getCorreoElectronico().equalsIgnoreCase(cliente.getCorreoElectronico())) {
                throw new Exception("El correo electrónico ya existe.");
            }
        }

        // si no existe, invoca a la capa de datos para guardar
        datosCliente.insertar(cliente);
    }
}