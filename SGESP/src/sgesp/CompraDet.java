package sgesp;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CompraDet {
	
	private int idCompraDet;
	private int idCompraCab;
	private int idComponente;
	private float vlrCompra;
	private int quantidade;
	
	public void salvar() {
		Banco banco = new Banco();
		if (getIdCompraDet() > 0) {
			banco.sqlAtualizacao("UPDATE CompraDet SET IdCompraCab = " + getIdCompraDet() + ", IdComponente = " + getIdComponente() + ", ValorCompra = " + getVlrCompra() + ", QTD = "+ getQuantidade() + "WHERE IdCompraCab = " + getIdCompraCab() + ";");
		} else {
			banco.sqlAtualizacao("INSERT INTO CompraDet (IdCompraCab, IdComponente, ValorCompra, QTD) VALUES (" + getIdCompraCab() + ", " + getIdComponente() +", " + getVlrCompra() + ", "+getQuantidade() + ");");
		}
	}
	
	public void remover() {
		Banco b = new Banco();
		if (getIdCompraDet() > 0) {
			b.sqlAtualizacao("DELETE FROM CompraDet WHERE IdCompraDet = " + getIdCompraDet() + ";");
		}
	}
	
	public CompraDet[] consultar() {

		int x = 0;
		ResultSet rs = null;
		Banco b = new Banco();

		rs = b.sqlConsulta("SELECT COUNT(*) AS total FROM CompraDet;");
		try {
			rs.next();
			x = Integer.parseInt(rs.getString("total"));
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

		if (x == 0) return null;

		CompraDet[] p = new CompraDet[x];
		rs = b.sqlConsulta("SELECT * FROM CompraDet ORDER BY IdCompraDet;");
		try {
			int count = 0;
			while (rs.next()) {
				CompraDet temp = new CompraDet();
				temp.setIdCompraDet(Integer.parseInt(rs.getString("IdCompraDet")));
				temp.setIdCompraCab(Integer.parseInt(rs.getString("IdCompraCab")));
				temp.setIdComponente(Integer.parseInt(rs.getString("IdComponente")));
				temp.setQuantidade(Integer.parseInt(rs.getString("QTD")));
				temp.setVlrCompra(Float.parseFloat(rs.getString("ValorCompra")));
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
	
	public int getIdCompraDet() {
		return idCompraDet;
	}
	public void setIdCompraDet(int idCompraDet) {
		this.idCompraDet = idCompraDet;
	}
	public int getIdCompraCab() {
		return idCompraCab;
	}
	public void setIdCompraCab(int idCompraCab) {
		this.idCompraCab = idCompraCab;
	}
	public int getIdComponente() {
		return idComponente;
	}
	public void setIdComponente(int idComponente) {
		this.idComponente = idComponente;
	}
	public float getVlrCompra() {
		return vlrCompra;
	}
	public void setVlrCompra(float vlrCompra) {
		this.vlrCompra = vlrCompra;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
