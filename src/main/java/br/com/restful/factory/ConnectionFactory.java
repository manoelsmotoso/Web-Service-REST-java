package br.com.restful.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 * 
 * Classe responsavel por conter os metodos criar e fechar o banco de dados.
 *
 * @author Manoel Silva Motoso
 * @since 26/06/2016 01:51:54
 */
public class ConnectionFactory {
	private String SENHA_MYSQL;
	private String HOST_MYSQL;
	private String URL_MYSQL;
	private String PORTA_MYSQL;
	private String USUARIO_MYSQL;
	private String DRIVER;
	/**
	 * 
	 * Metodo responsavel por criar uma conexao com o banco
	 *
	 * @author Manoel Silva Motoso
	 * @since 26/06/2016 01:51:54
	 */
	public Connection criarConexao() {
		if (System.getenv("OPENSHIFT_MYSQL_DB_HOST") != null) {
			SENHA_MYSQL = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
			HOST_MYSQL = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
			PORTA_MYSQL = System.getenv("OPENSHIFT_MYSQL_DB_PORT");
			USUARIO_MYSQL = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
		} else {
			// conexão local
			HOST_MYSQL = "localhost";
			PORTA_MYSQL = "3306";
			USUARIO_MYSQL = "root";
			SENHA_MYSQL = "";
		}
		// Montando url
		URL_MYSQL = "jdbc:mysql://" + HOST_MYSQL + ":" + PORTA_MYSQL + "/cliente";
		DRIVER = "com.mysql.jdbc.Driver";
		Connection conexao = null;

		try {

			Class.forName(DRIVER);
			conexao = DriverManager.getConnection(URL_MYSQL, USUARIO_MYSQL, SENHA_MYSQL);
			System.out.println("Conexao criada");

		} catch (Exception e) {
			System.out.println("Erro ao criar conexao com o banco: " + URL_MYSQL);
			e.printStackTrace();
		}
		return conexao;
	}

	public void fecharConexao(Connection conexao, PreparedStatement pstmt, ResultSet rs) {

		try {

			if (conexao != null) {
				conexao.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (rs != null) {
				rs.close();
			}
			System.out.println("Conexao fechada");
		} catch (Exception e) {
			System.out.println("Erro ao fechar conexao com o banco: " + URL_MYSQL);
		}
	}
}
