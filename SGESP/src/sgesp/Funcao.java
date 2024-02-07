package sgesp;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Funcao {
	
	
	private int IdFuncao;
	private String Funcao;
		
	public Funcao(){
		setIdFuncao(0);
		setFuncao("");
	}
	
	public void salvar() {
		Banco banco = new Banco();
		if (getIdFuncao() > 0) {
			banco.sqlAtualizacao("UPDATE Funcao SET Funcao = '" + getFuncao() + "' WHERE IdFuncao = " + getIdFuncao() + ";");
		} else {
			banco.sqlAtualizacao("INSERT INTO Funcao (Funcao) VALUES ('" + getFuncao() + "');");
		}
	}
	
	public void remover() {
		Banco b = new Banco();
		if (getIdFuncao() > 0) {
			b.sqlAtualizacao("DELETE FROM Funcao WHERE IdFuncao = " + getIdFuncao() + ";");
		}
	}
	
	public Funcao[] consultar() {

		int x = 0;
		ResultSet rs = null;
		Banco b = new Banco();

		rs = b.sqlConsulta("SELECT COUNT(*) AS total FROM Funcao;");
		try {
			rs.next();
			x = Integer.parseInt(rs.getString("total"));
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

		if (x == 0) return null;

		Funcao[] p = new Funcao[x];
		rs = b.sqlConsulta("SELECT * FROM Funcao ORDER BY IdFuncao;");
		try {
			int count = 0;
			while (rs.next()) {
				Funcao temp = new Funcao();
				temp.setIdFuncao(Integer.parseInt(rs.getString("IdFuncao")));
				temp.setFuncao(rs.getString("Funcao"));
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
	
	public Funcao(int id) {
		setIdFuncao(id);
		setFuncao("");
		ResultSet rs = null;
		Banco b = new Banco();
		rs = b.sqlConsulta("SELECT * FROM Funcao WHERE IdFuncao = " + getIdFuncao() + ";");
		try {
			rs.next();
			setFuncao(rs.getString("Funcao"));
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public int getIdFuncao() {
		return IdFuncao;
	}
	public void setIdFuncao(int idFuncao) {
		IdFuncao = idFuncao;
	}
	public String getFuncao() {
		return Funcao;
	}
	public void setFuncao(String funcao) {
		Funcao = funcao;
	}

}
