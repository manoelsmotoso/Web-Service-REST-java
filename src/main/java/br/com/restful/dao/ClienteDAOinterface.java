package br.com.restful.dao;

import java.util.List;

import br.com.restful.model.Cliente;

public interface ClienteDAOinterface {

	public Cliente save(Cliente cliente);

	public boolean delete(Cliente cliente);

	public boolean update(Cliente cliente);

	public Cliente findById(Cliente cliente);

	public List<Cliente> findByName(Cliente cliente);

	public List<Cliente> findAll();
}
