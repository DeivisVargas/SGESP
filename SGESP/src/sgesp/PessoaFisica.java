package sgesp;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PessoaFisica {
	
	private int idPessoaFisica;
	private String nome;
	private String cpf;
	private String rg;
	private String endereco;
	private String cep;
	private String email;
	private String telefone;
	private String celular;
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
	private int idCidade;
	
	public PessoaFisica(){
		setIdPessoaFisica(0);
		setNome("");
		setCpf("");
		setRg("");
		setEndereco("");
		setCep("");
		setEmail("");
		setTelefone("");
		setCelular("");
		setIdCidade(0);
	}
	
	public void salvar() {
		Banco banco = new Banco();
		if (getIdPessoaFisica() > 0) {
			banco.sqlAtualizacao("UPDATE PessoaFisica SET  Nome = '" + getNome() + "', CPF = '" + getCpf() + "', RG = '" + getRg() + "', Endereco = '" + getEndereco() + "', IdCidade = " + getIdCidade() + ", Cep = '" + getCep() + "', Email = '" + getEmail() + "', Telefone = '"+ getTelefone() +"', Celular =  '"+ getCelular() +"'  WHERE IdPessoaFisica = " + getIdPessoaFisica() + ";");
		} else {
			banco.sqlAtualizacao("INSERT INTO PessoaFisica (Nome, CPF, RG, Endereco, IdCidade, Cep, Email,Telefone,Celular) VALUES ('" + getNome() + "', '" + getCpf() + "', '" + getRg() + "', '" + getEndereco() + "'," + getIdCidade() + ", '" + getCep() + "', '" + getEmail() + "' , '"+ getTelefone() +"', '"+ getCelular() +"');");
		}
	}
	
	public void remover() {
		Banco b = new Banco();
		if (getIdPessoaFisica() > 0) {
			b.sqlAtualizacao("DELETE FROM PessoaFisica WHERE IdPessoaFisica = " + getIdPessoaFisica() + ";");
		}
	}
	
	public PessoaFisica[] consultar() {

		int x = 0;
		ResultSet rs = null;
		Banco b = new Banco();

		rs = b.sqlConsulta("SELECT COUNT(*) AS total FROM PessoaFisica;");
		try {
			rs.next();
			x = Integer.parseInt(rs.getString("total"));
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

		if (x == 0) return null;

		PessoaFisica[] p = new PessoaFisica[x];
		rs = b.sqlConsulta("SELECT * FROM PessoaFisica ORDER BY IdPessoaFisica;");
		try {
			int count = 0;
			while (rs.next()) {
				PessoaFisica temp = new PessoaFisica();
				temp.setIdPessoaFisica(Integer.parseInt(rs.getString("IdPessoaFisica")));
				temp.setNome(rs.getString("Nome"));
				temp.setCpf(rs.getString("CPF"));
				temp.setRg(rs.getString("RG"));
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
	
	public PessoaFisica(int id) {
		setIdPessoaFisica(id);
		setNome("");
		setCpf("");
		setRg("");
		setEndereco("");
		setIdCidade(0);
		setCep("");
		setEmail("");
		setTelefone("");
		setCelular("");
		ResultSet rs = null;
		Banco b = new Banco();
		rs = b.sqlConsulta("SELECT * FROM PessoaFisica WHERE IdPessoaFisica = " + getIdPessoaFisica() + ";");
		try {
			rs.next();
			setNome(rs.getString("Nome"));
			setCpf(rs.getString("CPF"));
			setRg(rs.getString("RG"));
			setEndereco(rs.getString("Endereco"));
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
	
	
	public int getIdPessoaFisica() {
		return idPessoaFisica;
	}
	public void setIdPessoaFisica(int idPessoaFisica) {
		this.idPessoaFisica = idPessoaFisica;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getIdCidade() {
		return idCidade;
	}
	public void setIdCidade(int idCidade) {
		this.idCidade = idCidade;
	}

	
}
