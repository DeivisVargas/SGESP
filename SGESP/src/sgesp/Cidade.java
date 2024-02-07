package sgesp;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Cidade {
	
	private int IdCidade;
	private String Cidade;
	private int IdUf;
	
	public Cidade(){
		setIdCidade(0);
		setCidade("");
		setIdUf(0);
	}
	
	public void salvar() {
		Banco banco = new Banco();
		if (getIdCidade() > 0) {
			banco.sqlAtualizacao("UPDATE Cidade SET Cidade = '" + getCidade() + "', IdUf = " + getIdUf() + " WHERE IdCidade = " + getIdCidade() + ";");
		} else {
			banco.sqlAtualizacao("INSERT INTO Cidade (Cidade, IdUf) VALUES ('" + getCidade() + "'," + getIdUf() + ");");
		}
	}

	public void remover() {
		Banco b = new Banco();
		if (getIdCidade() > 0) {
			b.sqlAtualizacao("DELETE FROM Cidade WHERE IdCidade = " + getIdCidade() + ";");
		}
	}
	
	public Cidade[] consultar() {

		int x = 0;
		ResultSet rs = null;
		Banco b = new Banco();

		rs = b.sqlConsulta("SELECT COUNT(*) AS total FROM Cidade;");
		try {
			rs.next();
			x = Integer.parseInt(rs.getString("total"));
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

		if (x == 0) return null;

		Cidade[] p = new Cidade[x];
		rs = b.sqlConsulta("SELECT * FROM Cidade ORDER BY IdCidade;");
		try {
			int count = 0;
			while (rs.next()) {
				Cidade temp = new Cidade();
				temp.setIdCidade(Integer.parseInt(rs.getString("IdCidade")));
				temp.setCidade(rs.getString("Cidade"));
				temp.setIdUf(Integer.parseInt(rs.getString("IdUf")));
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

	
	public Cidade(int id) {
		setIdCidade(id);
		setCidade("");
		setIdUf(0);
		ResultSet rs = null;
		Banco b = new Banco();
		rs = b.sqlConsulta("SELECT * FROM Cidade WHERE IdCidade = " + getIdCidade() + ";");
		try {
			rs.next();
			setCidade(rs.getString("Cidade"));
			setIdUf(Integer.parseInt(rs.getString("IdUf")));
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public int getIdCidade() {
		return IdCidade;
	}
	public void setIdCidade(int idCidade) {
		IdCidade = idCidade;
	}
	public String getCidade() {
		return Cidade;
	}
	public void setCidade(String cidade) {
		Cidade = cidade;
	}
	public int getIdUf() {
		return IdUf;
	}
	public void setIdUf(int idUf) {
		IdUf = idUf;
	}
	

}