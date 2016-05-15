package br.com.restful.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 * 
 * Classe responsavel por conter os metodos criar e fechar o banco de dados.
 *
 * @author Douglas Costa <douglas.cst90@gmail.com>
 * @since 17/02/2013 01:54:02
 * @version 1.0
 */
public class ConnectionFactory {
/*
 * 	
 */
/*
	//conexão local
 	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/cliente";
	private static final String USUARIO = "root";
	private static final String SENHA = "451192";
*/
	//conexao openshift
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.6.238.2:3306/cliente";
	private static final String USUARIO = "adminsHDS63j";
	private static final String SENHA = "AbL_b2eyBwsm";


	/**
	 * 
	 * Metodo responsavel por criar uma conexao com o banco 
	 *
	 * @return
	 * @author Douglas Costa <douglas.cst90@gmail.com.br>
	 * @since 17/02/2013 01:51:54
	 * @version 1.0
	 */
	public static Connection criarConexao(){
		
		Connection conexao = null;
		
		try {
			
			Class.forName(DRIVER);
			conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
			System.out.println("Conexao criada");
			
		} catch (Exception e) {
			System.out.println("Erro ao criar conexao com o banco: " + URL);
			e.printStackTrace();
		}
		return conexao;
	}
	
	
	public static void fecharConexao(Connection conexao, PreparedStatement pstmt, ResultSet rs){
		
		try {
			
			if(conexao != null){
				conexao.close();
			}
			if(pstmt != null){
				pstmt.close();
			}
			if(rs != null){
				rs.close();
			}
			System.out.println("Conexao fechada");		
		} catch (Exception e) {
			System.out.println("Erro ao fechar conexao com o banco: " + URL);
		}
	}
}

