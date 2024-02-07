package sgesp;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ValidarUsuario {
	
	
	
	public ValidarUsuario(){
		setUsuario("");
		setAdm("");
		setId(0) ;
	}
	
	
	private String Usuario ;
	private String Adm ;
	private int Id ;
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public ValidarUsuario(String usuario, String adm) {
		super();
		Usuario = usuario;
		Adm = adm;
	}

	public String getAdm() {
		return Adm;
	}
	public void setAdm(String adm) {
		Adm = adm;
	}
	public String getUsuario() {
		return Usuario;
	}
	public void setUsuario(String usuario) {
		this.Usuario = usuario;
	}
	
	
	// seta as variaveis locais com os valores do banco 
	// se a condição do select for atingida 
	
	public  boolean verificar(String usuario, String senha) {

		ResultSet rs = null;
		Banco b = new Banco();

		rs = b.sqlConsulta("SELECT * FROM Funcinario  WHERE Usuario = '"+ usuario +"' AND Senha = HASHBYTES('MD5', '"+senha+"') ;");
		try {
			
		  if (rs.next()) {
			  
			  //atribui os valores da variaveis do banco ,para as variaveis locais 
				
				this.setAdm(rs.getString("Administrador"));
				this.setId(Integer.parseInt(rs.getString("IdFuncionario")));
				return true;
			
			}
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	
			return false;
			
	}

	
	

}
