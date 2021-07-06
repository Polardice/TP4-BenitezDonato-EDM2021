package ar.unju.edu.edm.service.imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ar.unju.edu.edm.model.Cliente;
import ar.unju.edu.edm.service.IClienteService;
import ar.unju.edu.edm.util.ListadoClientes;

@Service
@Qualifier("unImp")
public class ClienteServiceImp implements IClienteService {

	private List<Cliente> listadoClientes = ListadoClientes.clientes;

	@Autowired
	Cliente unCliente;

	@Override
	public void guardarCliente(Cliente unCliente) {
		// TODO Auto-generated method stub
		listadoClientes.add(unCliente);
	}

	@Override
	public Cliente crearCliente() {
		// TODO Auto-generated method stub
		return unCliente;
	}

	@Override
	public Cliente encontrarUnCliente(int dni) throws Exception {
		// TODO Auto-generated method stub
		for (int i = 0; i < listadoClientes.size(); i++) {
			if (listadoClientes.get(i).getNroDocumento() == dni) {
				unCliente = listadoClientes.get(i);
			}
		}
		return unCliente;
	}

	@Override
	public void modificarCliente(Cliente clienteModificado) throws Exception {
		// TODO Auto-generated method stub
		for (int i = 0; i < listadoClientes.size(); i++) {
			if (listadoClientes.get(i).getNroDocumento() == clienteModificado.getNroDocumento()) {
				listadoClientes.set(i, clienteModificado);
			}
		}
	}

	@Override
	public void eliminarCliente(int dni) throws Exception {
		// TODO Auto-generated method stub
		for (int i = 0; i < listadoClientes.size(); i++) {
			if (listadoClientes.get(i).getNroDocumento() == dni) {
				listadoClientes.remove(i);
			}
		}
	}

	@Override
	public List<Cliente> obtenerTodosClientes() {
		// TODO Auto-generated method stub
		return listadoClientes;
	}

	@Override
	public Cliente encontrarUnClienteId(int id) throws Exception {
		// TODO Auto-generated method stub
		for (int i = 0; i < listadoClientes.size(); i++) {
			if (listadoClientes.get(i).getIdCliente() == id) {
				unCliente = listadoClientes.get(i);
			}
		}
		return unCliente;
	}
}
