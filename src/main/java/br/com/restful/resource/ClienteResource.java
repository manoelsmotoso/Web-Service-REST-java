package br.com.restful.resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.restful.controller.ClienteController;
import br.com.restful.model.Cliente;

/**
 * Classe responsavel por conter os metodos REST de acesso ao webservice
 */
@Path("/")
public class ClienteResource {
	String osName = System.getProperty("os.name").toLowerCase();
	String osArch = System.getProperty("os.arch");
	String osVersion = System.getProperty("os.version");
	String Cors = String.valueOf(Runtime.getRuntime().availableProcessors());
	String fullMemoryJVM = String.valueOf((Runtime.getRuntime().totalMemory()/8/8)/1024);
	String fullMemory = String.valueOf((Runtime.getRuntime().maxMemory()/8/8)/1024);
	String freeMemory = String.valueOf((Runtime.getRuntime().freeMemory()/8)/1024);
	//System.getProperties().list(System.out);
 
	@GET
	@Path("/")
	@Produces({MediaType.TEXT_HTML})
	public String viewHome()
	{
	   return "</html><!DOCTYPE html>"
	   		+ "<html><head><meta charset='UTF-8'><title>Cliente</title>"
	   		+ "<style>"
	   		+ "h1,fieldset{"
		   		+ "test-align:center;"
		   		+ "max-width:450px;"
		   		+ "margin-left:auto;"
		   		+ "margin-right:auto;"
		   		+ "}"
		   	+ "span{color:green;}"
	   		+ "</style>"
	   		+ "</head>"
	   		+ "<body>"
		   		+ "<fieldset>"
		   		 + "<h1>Webservice Funcionando</h1>"
		   		 + "<legend>Dados da VM </legend>"
			   		+ "<br>Nome OS:<span> "+osName+"</span>"
			   		+ "<br>Versão OS:<span> "+osVersion+"</span>"
			   		+ "<br>Arquitetura do OS:<span> "+osArch+"</span>"
			   		+ "<br>Nucleos da maquina:<span> "+Cors+"</span>"
			   		+ "<br>Memoria RAM total:<span> "+fullMemory+"MB</span>"
			   		+ "<br>Memoria JVM total:<span> "+fullMemoryJVM+"MB</span>"
			   		+ "<br>Memoria RAM disponivel:<span> "+freeMemory+"</span>"
		   		 + "</fieldset>"
	   		+ "</body>"
	   		+ "</html>";
	}
	
	@GET
	@Path("/listarTodos")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Cliente> listarTodos() {
		System.out.println("Clientes encontrados no banco");
		return new ClienteController().listarTodos();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/id/{id}")
	public Response getById(@PathParam("id") Long id) {
		Cliente cliente = new ClienteController().buscarPorId(id);
		if (cliente != null) {
			return Response.ok().type(MediaType.APPLICATION_JSON)
					.entity(cliente).build();
		} else {
			return Response.status(404).entity("Cliente nao encontrado")
					.build();
		}
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/salvar")
	public Response salvarClienteJson(Cliente cliente) {
		boolean isClienteGravado = new ClienteController()
				.gravarCliente(cliente);
		if (isClienteGravado == true) {
			return Response.ok().entity(cliente).build();
		} else {
			return Response.status(500)
					.entity("Erro no servidor  ao gravar cliente").build();
		}

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/atualizar")
	public Response altualizarCliente(Cliente cliente) {
		boolean isClienteAtualizado = new ClienteController()
				.atualizarCliente(cliente);

		if (isClienteAtualizado == true) {
			return Response.ok().entity(cliente).build();
		} else {
			return Response.status(500)
					.entity("Erro no servidor  ao atualizar cliente").build();
		}

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/deletar")
	public Response deletarCliente(Cliente cliente) {

		boolean isClienteDeletado = new ClienteController().deletarCliente(cliente);
		if (isClienteDeletado == true) {
			System.out.println("Cliente " + cliente.getNome() + " deletado");
			return Response.ok().entity(cliente).build();
		} else {
			System.out.println("Erro no servidor  ao deletar cliente: "
					+ cliente.getNome());
			return Response
					.status(500)
					.entity("Erro no servidor  ao deletar cliente: "
							+ cliente.getNome()).build();
		}

	}

}
