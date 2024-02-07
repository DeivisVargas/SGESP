package sgesp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Estado {
	private int IdEstado;
	private String Estado;
	private String Uf;
	
	public Estado(){
		setIdEstado(0);
		setEstado("");
		setUf("");
	}
	
	public void salvar() {
		Banco banco = new Banco();
		if (getIdEstado()> 0) {
			banco.sqlAtualizacao("UPDATE Estado SET Estado = '" + getEstado() + "', Uf = '" + getUf() + "' WHERE IdEstado = " + getIdEstado() + ";");
		} else {
			banco.sqlAtualizacao("INSERT INTO Estado (Estado, Uf) VALUES ('" + getEstado() + "','" + getUf() + "');");
		}
	}
	
	public void remover() {
		Banco b = new Banco();
		if (getIdEstado() > 0) {
			b.sqlAtualizacao("DELETE FROM Estado WHERE IdEstado = " + getIdEstado() + ";");
		}
	}
	
	public Estado[] consultar() {

		int x = 0;
		ResultSet rs = null;
		Banco b = new Banco();

		rs = b.sqlConsulta("SELECT COUNT(*) AS total FROM Estado;");
		try {
			rs.next();
			x = Integer.parseInt(rs.getString("total"));
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

		if (x == 0) return null;

		Estado[] p = new Estado[x];
		rs = b.sqlConsulta("SELECT * FROM Estado ORDER BY IdEstado;");
		try {
			int count = 0;
			while (rs.next()) {
				Estado temp = new Estado();
				temp.setIdEstado(Integer.parseInt(rs.getString("IdEstado")));
				temp.setEstado(rs.getString("Estado"));
				temp.setUf(rs.getString("Uf"));
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
	
	public Estado(int id) {
		setIdEstado(id);
		setEstado("");
		setUf("");
		ResultSet rs = null;
		Banco b = new Banco();
		rs = b.sqlConsulta("SELECT * FROM Estado WHERE IdEstado = " + getIdEstado() + ";");
		try {
			rs.next();
			setEstado(rs.getString("Estado"));
			setUf(rs.getString("Uf"));
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public int getIdEstado() {
		return IdEstado;
	}
	public void setIdEstado(int idEstado) {
		IdEstado = idEstado;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	public String getUf() {
		return Uf;
	}
	public void setUf(String uf) {
		Uf = uf;
	}
	
	
}
