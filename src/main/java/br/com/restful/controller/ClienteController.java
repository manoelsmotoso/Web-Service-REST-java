package br.com.restful.controller;



import java.util.ArrayList;

import br.com.restful.dao.ClienteDAO;
import br.com.restful.model.Cliente;

/**
 * 
 * Classe responsavel por ser o controlador entre o resource e a camada DAO
 *
 * @author Douglas Costa <douglas.cst90@gmail.com>
 * @since 17/02/2013 02:04:21
 * @version 1.0
 */
public class ClienteController {
	/**
	 * 
	 * @return Retorna todos os clientes gravados no banco de dados.
	 */
	public ArrayList<Cliente> listarTodos(){
		System.out.println("Enviando para o GET");
		return ClienteDAO.getInstance().listarTodos();
		
	}
	/**
	 * 
	* @param id
	* @return cliente
	* @author Manoel Silva Motoso <manoelmotoso@hotmail.com>
	* @since 11/05/2016 11:52:48
	* @version 1.0
	 */
	public Cliente buscarPorId(long id){
		System.out.println("Enviando para o GET");
		ClienteDAO dao=new ClienteDAO();
		Cliente cliente = dao.getById(id);
		return cliente ;
	}
	
	/**
	 * 
	* @param cliente
	* @return booolean
	* @author Manoel Silva Motoso <manoelmotoso@hotmail.com>
	* @since 11/05/2016 11:53:15
	* @version 1.0
	 */
	public boolean gravarCliente(Cliente cliente) {
		System.out.println("Enviando para o PUT");
		return new ClienteDAO().insert(cliente);
		
	}
	
}
