package sgesp;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Fornecedor {
	private int IdFornecedor ;
	private int IdPessoaJuridica ;
	public int getIdFornecedor() {
		return IdFornecedor;
	}




	public void setIdFornecedor(int idFornecedor) {
		IdFornecedor = idFornecedor;
	}




	public int getIdPessoaJuridica() {
		return IdPessoaJuridica;
	}




	public void setIdPessoaJuridica(int idPessoaJuridica) {
		IdPessoaJuridica = idPessoaJuridica;
	}




	public String getTipomaterial() {
		return tipomaterial;
	}




	public void setTipomaterial(String tipomaterial) {
		this.tipomaterial = tipomaterial;
	}




	private String tipomaterial ;
	private String nome ;
	private String telefone  ;
	
	
	public String getNome() {
		return nome;
	}




	public void setNome(String nome) {
		this.nome = nome;
	}




	public String getTelefone() {
		return telefone;
	}




	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}




	
	
	
	
	
	public Fornecedor (){
		setIdFornecedor(0);
		setIdPessoaJuridica(0);
		setTipomaterial("");
		
		
	}
	
	public void salvar() {
		Banco banco = new Banco();
		if (getIdFornecedor() > 0) {
			banco.sqlAtualizacao("UPDATE Fornecedor SET Materiais = '" + getTipomaterial()+ "' WHERE IdFornecedor = " + getIdFornecedor() + ";");
		} else {
			banco.sqlAtualizacao("INSERT INTO Fornecedor (IdPessoaJuridica, Materiais) VALUES (" + getIdPessoaJuridica() + ",'" + getTipomaterial() + "');");
		}
	}
	
	public void remover() {
		Banco b = new Banco();
		if (getIdFornecedor() > 0) {
			b.sqlAtualizacao("DELETE FROM Fornecedor WHERE IdFornecedor = "+ getIdFornecedor() + ";");
		}
	}
	
	public Fornecedor[] consultar() {

		int x = 0;
		ResultSet rs = null;
		Banco b = new Banco();

		rs = b.sqlConsulta("SELECT COUNT(*) AS total FROM Fornecedor f ,PessoaJuridica p   WHERE p.IdPessoaJuridica  = f.IdPessoaJuridica  ;");
		try {
			rs.next();
			x = Integer.parseInt(rs.getString("total"));
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

		if (x == 0) return null;

		Fornecedor[] p = new Fornecedor[x];
		rs = b.sqlConsulta("SELECT * FROM Fornecedor AS f ,PessoaJuridica AS p   WHERE p.IdPessoaJuridica  = f.IdPessoaJuridica ;");
		try {
			int count = 0;
			while (rs.next()) {
				Fornecedor temp = new Fornecedor();
				temp.setIdFornecedor(Integer.parseInt(rs.getString("IdFornecedor")));
				temp.setIdPessoaJuridica(Integer.parseInt(rs.getString("IdPessoaJuridica")));
				temp.setTipomaterial(rs.getString("Materiais"));
				temp.setNome(rs.getString("Fantasia"));
				temp.setTelefone(rs.getString("Telefone"));
				
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
	
	
	

	public Fornecedor(int id) {
		setIdFornecedor(id);
		setIdPessoaJuridica(0);
		setTipomaterial("");
		ResultSet rs = null;
		Banco b = new Banco();
		rs = b.sqlConsulta("SELECT * FROM Fornecedor WHERE IdFornecedor = " + getIdFornecedor() + ";");
		try {
			rs.next();
			setIdPessoaJuridica(Integer.parseInt(rs.getString("IdPessoaJuridica")));
			setTipomaterial(rs.getString("Materiais"));
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}


}
