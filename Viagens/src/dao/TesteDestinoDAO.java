package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TesteDestinoDAO {

	public static void main(String[] args) {
		// Testando execução do Destino DAO
				 destino destino = new destino();
						
				 destino.setId(2);
				 destino.setNome("Madeira Hospedagens");
				 destino.setValor(3000);
				 destino.setLocalidade("Madeira - Portugual");
				 destino.setProprietario("Mathias");

				DestinoDAO dao = new DestinoDAO();
						
						dao.save(destino);
						System.out.println("Destino salvo!");
						
				 ///DestinoDAO dao2 = new DestinoDAO();
					//	dao2.removeById(2);
					//	System.out.println("Destino removido!");
						
					//	destino.setNome("Aveiro Viagens");
				      //  destino.setValor(1500);
					   // destino.setId(1);
						//dao.update(destino);
						//System.out.println("Destino alterado!");
				       

						try {
							ResultSet resultado= dao.getDestino();
							while (resultado.next()) {
						    	System.out.println(resultado.getInt(1)+" "+resultado.getString(2)+" "+resultado.getInt(3)+" "+resultado.getString(4)+" "+resultado.getString(5));
						    
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();

						}
			

	}

}
