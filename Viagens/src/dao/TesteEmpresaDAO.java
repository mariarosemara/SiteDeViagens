package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TesteEmpresaDAO {

	public static void main(String[] args) {
		// Testando a execução da Empresa DAO
		 empresa empresa = new empresa();
				
				empresa.setId(2);
				empresa.setCnpj("12345678901235");
	        	empresa.setLocalidade("Madeira - Portugal");
	        	empresa.setProprietario("Mathias");
				empresa.setLogin("MathiasM");
				empresa.setSenha("1430");
				
		 EmpresaDAO dao = new EmpresaDAO();
				
				dao.save(empresa);
				System.out.println("Empresa salva!");
				
		 //EmpresaDAO dao2 = new EmpresaDAO();
				//dao2.removeById(2);
				//System.out.println("Empresa removida!");
				
		        //empresa.setLogin("pedro2");
				//empresa.setSenha("231");
				//empresa.setId(2);
				//dao.update(empresa);
				//System.out.println("Empresa alterada");
		       

				try {
					ResultSet resultado= dao.getEmpresa();
					while (resultado.next()) {
				    	System.out.println(resultado.getInt(1)+" "+resultado.getString(2)+" "+resultado.getString(3)+" "+resultado.getString(4)+" "+resultado.getString(5)+" "+resultado.getString(6));
				    
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

				}
			}
}
