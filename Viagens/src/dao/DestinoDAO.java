package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DestinoDAO {

			private Connection connection;
			
			public DestinoDAO() {
				this.connection = new ConnectionFactory().getConnection();
			}
			
			public void save (destino destino) {

				String sql = "INSERT INTO destino VALUES (?,?,?,?,?)";
				try {
					PreparedStatement stmt = connection.prepareStatement(sql);
					stmt.setInt(1, destino.getId());
					stmt.setString(2, destino.getNome());
					stmt.setInt(3, destino.getValor());
					stmt.setString(4, destino.getLocalidade());
					stmt.setString(5, destino.getProprietario());
					stmt.execute();
					stmt.close();	
					//connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			
			public void removeById(int id) {
				String sql = "DELETE FROM destino WHERE id= ?";
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
			
			public void update(destino destino) {
				String sql = "UPDATE destino SET nome = ? , valor = ? WHERE id = ?";
				
				try {
					PreparedStatement stmt = connection.prepareStatement(sql);
				
					stmt.setString(1, destino.getNome());
					stmt.setInt(2, destino.getValor());
					stmt.setInt(3, destino.getId());
					stmt.execute();
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}

			public ResultSet getDestino() throws SQLException {
				String sql = "SELECT * FROM destino";
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
