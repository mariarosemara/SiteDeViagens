package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClienteDAO {

	private Connection connection;
	
	public ClienteDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void save (cliente cliente) {

		String sql = "INSERT INTO cliente VALUES (?,?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, cliente.getId());
			stmt.setString(2, cliente.getNome());
			stmt.setInt(3, cliente.getCpf());
			stmt.setString(4, cliente.getLogin());
			stmt.setInt(5, cliente.getSenha());
			stmt.execute();
			stmt.close();	
			//connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	public void removeById(int id) {
		String sql = "DELETE FROM cliente WHERE id= ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void update(cliente cliente) {
		String sql = "UPDATE cliente SET login = ? , senha = ? WHERE id = ?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
		
			stmt.setString(1, cliente.getLogin());
			stmt.setInt(2, cliente.getSenha());
			stmt.setInt(3, cliente.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public ResultSet getCliente() throws SQLException {
		String sql = "SELECT * FROM cliente";
		Statement stmt = null;
		ResultSet resultado = null;
		try {
			stmt = connection.createStatement();
			resultado =  stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
		
	}
}
	