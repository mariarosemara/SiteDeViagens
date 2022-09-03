package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmpresaDAO {

		private Connection connection;
		
		public EmpresaDAO() {
			this.connection = new ConnectionFactory().getConnection();
		}
		
		public void save (empresa empresa) {

			String sql = "INSERT INTO empresa VALUES (?,?,?,?,?,?)";
			try {
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setInt(1, empresa.getId());
				stmt.setString(2, empresa.getCnpj());
				stmt.setString(3, empresa.getLocalidade());
				stmt.setString(4, empresa.getProprietario());
				stmt.setString(5, empresa.getLogin());
				stmt.setString(6, empresa.getSenha());
				stmt.execute();
				stmt.close();	
				//connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		
		public void removeById(int id) {
			String sql = "DELETE FROM empresa WHERE id= ?";
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
		
		public void update(empresa empresa) {
			String sql = "UPDATE empresa SET login = ? , senha = ? WHERE id = ?";
			
			try {
				PreparedStatement stmt = connection.prepareStatement(sql);
			
				stmt.setString(1, empresa.getLogin());
				stmt.setString(2, empresa.getSenha());
				stmt.setInt(3, empresa.getId());
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}

		public ResultSet getEmpresa() throws SQLException {
			String sql = "SELECT * FROM empresa";
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
