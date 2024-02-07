package sgesp;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PessoaJuridica {
	
	private int idPessoaJuridica;
	private String RzSocial ;
	private  String Fantasia ;
	private  String Cnpj ;
	private  String Ir ;
	private  String Endereco ;
	private  String Cep ;
	private  String Email ;
	private  String Telefone ;
	private  String Celular ;
	public String getTelefone() {
		return Telefone;
	}
	public void setTelefone(String telefone) {
		this.Telefone = telefone;
	}
	public String getCelular() {
		return Celular;
	}
	public void setCelular(String celular) {
		this.Celular = celular;
	}
	
	
	private int IdCidade ;
	
    public PessoaJuridica(){
	setIdPessoaJuridica(0);
	setRzSocial("");
	setFantasia("");
	setCnpj("");
	setIr("");
	setEndereco("");
	setCep("");
	setEmail("");
	setTelefone("");
	setCelular("");	
	setIdCidade(0);	
	
	
}
    public int getIdCidade() {
		return IdCidade;
	}
	public void setIdCidade(int idCidade) {
		IdCidade = idCidade;
	}
	public void salvar() {
		Banco banco = new Banco();
		if (getIdPessoaJuridica() > 0) {
			banco.sqlAtualizacao("UPDATE PessoaJuridica SET  RazaoSocial = '" + getRzSocial() + "', Fantasia = '" + getFantasia() + "', Cnpj = '" + getCnpj() + "', Ir = '" + getIr() + "', Endereco = '" + getEndereco() + "', IdCidade = '" + getIdCidade() + "', Cep = '" + getCep() + "', Email = '"+ getEmail() + "' , Telefone = '"+getTelefone()+"' , Celular = '"+getCelular() +"'  WHERE IdPessoaJuridica = " + getIdPessoaJuridica() + ";");
		} else {
			banco.sqlAtualizacao("INSERT INTO PessoaJuridica (RazaoSocial, Fantasia,Cnpj , Ir, Endereco, IdCidade, Cep,Email,Telefone,Celular) VALUES ('" + getRzSocial() + "', '" + getFantasia() + "', '" + getCnpj() + "', '" + getIr() + "','" + getEndereco() + "', '" + getIdCidade() + "', '" + getCep() +"', '" + getEmail() + "' , '"+getTelefone() +"' , '"+getCelular()+"');");
		}
	}
	public void remover() {
		Banco b = new Banco();
		if (getIdPessoaJuridica() > 0) {
			b.sqlAtualizacao("DELETE FROM PessoaJuridica WHERE IdPessoaJuridica = " + getIdPessoaJuridica() + ";");
		  }
		}
	
	public PessoaJuridica[] consultar() {

		int x = 0;
		ResultSet rs = null;
		Banco b = new Banco();

		rs = b.sqlConsulta("SELECT COUNT(*) AS total FROM PessoaJuridica;");
		try {
			rs.next();
			x = Integer.parseInt(rs.getString("total"));
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

		if (x == 0) return null;

		PessoaJuridica[] p = new PessoaJuridica[x];
		rs = b.sqlConsulta("SELECT * FROM PessoaJuridica ORDER BY IdPessoaJuridica;");
		try {
			int count = 0;
			while (rs.next()) {
				PessoaJuridica temp = new PessoaJuridica();
				temp.setIdPessoaJuridica(Integer.parseInt(rs.getString("IdPessoaJuridica")));
				temp.setRzSocial(rs.getString("RazaoSocial"));
				temp.setFantasia(rs.getString("Fantasia"));
				temp.setCnpj(rs.getString("Cnpj"));
				temp.setIr(rs.getString("Ir"));
				temp.setEndereco(rs.getString("Endereco"));
				temp.setIdCidade(Integer.parseInt(rs.getString("IdCidade")));
				temp.setCep(rs.getString("Cep"));
				temp.setEmail(rs.getString("Email"));
			    temp.setTelefone(rs.getString("Telefone"));
			    temp.setCelular(rs.getString("Celular"));
				p[count] = temp;
				count++;
			}
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

		return p;

	}
	
	public PessoaJuridica(int id) {
		setIdPessoaJuridica(id);
		setRzSocial("");
		setFantasia("");
		setCnpj("");
		setIr("");
		setIdCidade(0);
		setCep("");
		setEmail("");
		setTelefone("");
		setCelular("");
		
		ResultSet rs = null;
		Banco b = new Banco();
		rs = b.sqlConsulta("SELECT * FROM PessoaJuridica WHERE IdPessoaJuridica = " + getIdPessoaJuridica() + ";");
		try {
			rs.next();
			setRzSocial(rs.getString("RazaoSocial"));
			setFantasia(rs.getString("Fantasia"));
			setCnpj(rs.getString("Cnpj"));
			setEndereco(rs.getString("Endereco"));
			setIr(rs.getString("Ir"));
			setIdCidade(Integer.parseInt(rs.getString("IdCidade")));
			setCep(rs.getString("Cep"));
			setEmail(rs.getString("Email"));
			setTelefone(rs.getString("Telefone"));
			setCelular(rs.getString("Celular"));
			
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	
	
	
	
	/*public PessoaJuridica(int idPessoaJuridica, String rzSocial,
			String fantasia, String cnpj, String ir, String endereco,
			String cep, String email , String telefone , String celular ) {
		super();
		this.idPessoaJuridica = idPessoaJuridica;
		RzSocial = rzSocial;
		Fantasia = fantasia;
		Cnpj = cnpj;
		Ir = ir;
		Endereco = endereco;
		Cep = cep;
		Email = email;
		Telefone = telefone ;
		Celular = celular ;
	
		
	}
	
	*/
	public int getIdPessoaJuridica() {
		return idPessoaJuridica;
	}
	public void setIdPessoaJuridica(int idPessoaJuridica) {
		this.idPessoaJuridica = idPessoaJuridica;
	}
	public String getRzSocial() {
		return RzSocial;
	}
	public void setRzSocial(String rzSocial) {
		RzSocial = rzSocial;
	}
	public String getFantasia() {
		return Fantasia;
	}
	public void setFantasia(String fantasia) {
		Fantasia = fantasia;
	}
	public String getCnpj() {
		return Cnpj;
	}
	public void setCnpj(String cnpj) {
		Cnpj = cnpj;
	}
	public String getIr() {
		return Ir;
	}
	public void setIr(String ir) {
		Ir = ir;
	}
	public String getEndereco() {
		return Endereco;
	}
	public void setEndereco(String endereco) {
		Endereco = endereco;
	}
	public String getCep() {
		return Cep;
	}
	public void setCep(String cep) {
		Cep = cep;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}

	
	

	
	
	


	

	


	
	
	
	

}
