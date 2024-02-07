package sgesp;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CompraCab {
	
	public int getIdComponente() {
		return idComponente;
	}

	public void setIdComponente(int idComponente) {
		this.idComponente = idComponente;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getVlrultima() {
		return vlrultima;
	}

	public void setVlrultima(float vlrultima) {
		this.vlrultima = vlrultima;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	private int idComponente ;
	private String descricao ;
	private float vlrultima ;
	private String data;
	private int qtd ;
	
	private int idComponente2 ;
	public String getData2() {
		return data2;
	}

	public void setData2(String data2) {
		this.data2 = data2;
	}

	private String descricao2 ;
	private float vlrultima2 ;
	private String data2;
	
	
	public int getIdComponente2() {
		return idComponente2;
	}

	public void setIdComponente2(int idComponente2) {
		this.idComponente2 = idComponente2;
	}

	public String getDescricao2() {
		return descricao2;
	}

	public void setDescricao2(String descricao2) {
		this.descricao2 = descricao2;
	}

	public float getVlrultima2() {
		return vlrultima2;
	}

	public void setVlrultima2(float vlrultima2) {
		this.vlrultima2 = vlrultima2;
	}

	public int getQtd2() {
		return qtd2;
	}

	public void setQtd2(int qtd2) {
		this.qtd2 = qtd2;
	}

	private int qtd2 ;
	
	public void salvar() {
		Banco banco = new Banco();
		
		banco.sqlAtualizacao("INSERT INTO CompraCab (IdComponente, Descricao, vlrUltima , Data , Quantidade) VALUES (" + getIdComponente() + ", '" + getDescricao() +"', " + getVlrultima() + " , '"+getData()+"',"+getQtd()+" );");
		
	}
	
	public CompraCab[] consultar() {

		int x = 0;
		ResultSet rs = null;
		Banco b = new Banco();
		
		rs = b.sqlConsulta("SELECT COUNT(*) AS total FROM CompraCab;");
		try {
			rs.next();
			x = Integer.parseInt(rs.getString("total"));
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

		if (x == 0) return null;

		CompraCab[] p = new CompraCab[x];
		rs = b.sqlConsulta("SELECT * FROM CompraCab ORDER BY IdCompraCab;");
		try {
			int count = 0;
			while (rs.next()) {
				CompraCab temp = new CompraCab();
				temp.setIdComponente2(Integer.parseInt(rs.getString("IdCompraCab")));
				temp.setDescricao2(rs.getString("Descricao"));
				temp.setVlrultima2(Float.parseFloat(rs.getString("vlrUltima")));
				temp.setData2(rs.getString("Data"));
				temp.setQtd2(Integer.parseInt(rs.getString("Quantidade")));
			
				p[count] = temp;
				count++;
				
			}
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

		return p;
	
	
	/*
	public void remover() {
		Banco b = new Banco();
		if (getIdCompraCab() > 0) {
			b.sqlAtualizacao("DELETE FROM CompraCab WHERE IdCompraCab = " + getIdCompraCab() + ";");
		}
	}
	
	public CompraCab[] consultar() {

		int x = 0;
		ResultSet rs = null;
		Banco b = new Banco();

		rs = b.sqlConsulta("SELECT COUNT(*) AS total FROM CompraCab;");
		try {
			rs.next();
			x = Integer.parseInt(rs.getString("total"));
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

		if (x == 0) return null;

		CompraCab[] p = new CompraCab[x];
		rs = b.sqlConsulta("SELECT * FROM CompraCab ORDER BY IdCompraCab;");
		try {
			int count = 0;
			while (rs.next()) {
				CompraCab temp = new CompraCab();
				temp.setIdCompraCab(Integer.parseInt(rs.getString("IdCompraCab")));
				temp.setIdFornecedor(Integer.parseInt(rs.getString("IdFornecedor")));
				temp.setData(rs.getString("Data"));
				temp.setTotal(Float.parseFloat(rs.getString("Total")));
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
	*/
		
	
	
	}
}
