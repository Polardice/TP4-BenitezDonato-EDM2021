package ar.unju.edu.edm.service;

import java.util.List;

import ar.unju.edu.edm.model.Cliente;

public interface IClienteService {
	public void guardarCliente(Cliente unCliente);
	public Cliente crearCliente();
	public List<Cliente> obtenerTodosClientes();
	public Cliente encontrarUnCliente(int dni) throws Exception;
	public Cliente encontrarUnClienteId(int id) throws Exception;
	//public Optional<Cliente> encontrarUnCliente(int dni);
	public void modificarCliente(Cliente unCliente) throws Exception;
	public void eliminarCliente(int dni) throws Exception;

}
