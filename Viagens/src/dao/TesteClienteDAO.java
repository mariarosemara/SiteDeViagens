package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TesteClienteDAO {

	public static void main(String[] args) {
		// Testando a execução do Cliente DAO
         cliente cliente = new cliente();
		
		cliente.setId(8);
		cliente.setNome("José");
		cliente.setCpf(1234567899);
		cliente.setLogin("juze4");
		cliente.setSenha(543);
		
		ClienteDAO dao = new ClienteDAO();
		
		dao.save(cliente);
		System.out.println("Cliente salvo!");
		
		//ClienteDAO dao2 = new ClienteDAO();
		//dao2.removeById(3);
		//System.out.println("Cliente removido!");
		
        //cliente.setLogin("pedro2");
		//cliente.setSenha(231);
		//cliente.setId(1);
		//dao.update(cliente);
		//System.out.println("Cliente alterado");
       

		try {
			ResultSet resultado= dao.getCliente();
			while (resultado.next()) {
		    	System.out.println(resultado.getInt(1)+" "+resultado.getString(2)+" "+resultado.getInt(3)+" "+resultado.getString(4)+" "+resultado.getInt(5));
		    
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
}