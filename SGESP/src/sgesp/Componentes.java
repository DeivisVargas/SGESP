package sgesp;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Componentes {
	
	private int IdComponente;
	private String Descricao;
	private float vlrCompra;
	private int Estoque;
	private int EstoqueMin;
	
	private String busca;
	
	public Componentes(){
		setIdComponente(0);
		setDescricao("");
		setVlrCompra(0);
		setEstoque(0);
		setEstoqueMin(0);
		setBusca("");
	}
	
	public void salvar() {
		Banco banco = new Banco();
		if (getIdComponente() > 0) {
			banco.sqlAtualizacao("UPDATE Componente SET  Descricao = '" + getDescricao() + "', VlrCompra = " + getVlrCompra() + ", Estoque = " + getEstoque() + ", EstoqueMinimo = " + getEstoqueMin()+ "  WHERE IdComponente = " + getIdComponente() + ";");
		} else {
			banco.sqlAtualizacao("INSERT INTO Componente (Descricao, VlrCompra, Estoque, EstoqueMinimo) VALUES ('" + getDescricao() + "'," + getVlrCompra() + "," + getEstoque() + "," + getEstoqueMin() + ");");
		}
	}
	
	public void remover() {
		Banco b = new Banco();
		if (getIdComponente() > 0) {
			b.sqlAtualizacao("DELETE FROM Componente WHERE IdComponente = " + getIdComponente() + ";");
		}
	}
	
	public void consultarEstoque(int id){
		setIdComponente(id);
		setEstoque(0);
		ResultSet rs = null;
		Banco b = new Banco();
		rs = b.sqlConsulta("SELECT Estoque FROM Componente WHERE IdComponente = " + getIdComponente() + ";");
		try {
			rs.next();
			setEstoque(Integer.parseInt(rs.getString("Estoque")));
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public Componentes[] busca(String busca ) {

		int x = 0;
		ResultSet rs = null;
		Banco b = new Banco();
		
		rs = b.sqlConsulta("SELECT COUNT(*) AS total FROM Componente where Descricao like '%"+ busca +"%' ;");
		try {
			rs.next();
			x = Integer.parseInt(rs.getString("total"));
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

		if (x == 0) return null;

		Componentes[] p = new Componentes[x];
		rs = b.sqlConsulta("SELECT * FROM Componente where Descricao like '%"+ busca +"%' ORDER BY IdComponente;");
		try {
			int count = 0;
			while (rs.next()) {
				Componentes temp = new Componentes();
				temp.setIdComponente(Integer.parseInt(rs.getString("IdComponente")));
				temp.setDescricao(rs.getString("Descricao"));
				temp.setVlrCompra(Float.parseFloat(rs.getString("VlrCompra")));
				temp.setEstoque(Integer.parseInt(rs.getString("Estoque")));
				temp.setEstoqueMin(Integer.parseInt(rs.getString("EstoqueMinimo")));
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
	
	public Componentes[] consultar() {

		int x = 0;
		ResultSet rs = null;
		Banco b = new Banco();
		
		rs = b.sqlConsulta("SELECT COUNT(*) AS total FROM Componente;");
		try {
			rs.next();
			x = Integer.parseInt(rs.getString("total"));
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

		if (x == 0) return null;

		Componentes[] p = new Componentes[x];
		rs = b.sqlConsulta("SELECT * FROM Componente ORDER BY IdComponente;");
		try {
			int count = 0;
			while (rs.next()) {
				Componentes temp = new Componentes();
				temp.setIdComponente(Integer.parseInt(rs.getString("IdComponente")));
				temp.setDescricao(rs.getString("Descricao"));
				temp.setVlrCompra(Float.parseFloat(rs.getString("VlrCompra")));
				temp.setEstoque(Integer.parseInt(rs.getString("Estoque")));
				temp.setEstoqueMin(Integer.parseInt(rs.getString("EstoqueMinimo")));
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
	
	public Componentes[] consultarEstoque() {

		int x = 0;
		ResultSet rs = null;
		Banco b = new Banco();
		
		rs = b.sqlConsulta("SELECT COUNT(*) AS total FROM Componente  WHERE Estoque < EstoqueMinimo  ;");
		try {
			rs.next();
			x = Integer.parseInt(rs.getString("total"));
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

		if (x == 0) return null;

		Componentes[] p = new Componentes[x];
		
		
		
		rs = b.sqlConsulta("SELECT * FROM Componente  WHERE Estoque < EstoqueMinimo  ORDER BY  IdComponente;");
		try {
			int count = 0;
			while (rs.next()) {
				Componentes temp = new Componentes();
				temp.setIdComponente(Integer.parseInt(rs.getString("IdComponente")));
				temp.setDescricao(rs.getString("Descricao"));
				temp.setVlrCompra(Float.parseFloat(rs.getString("VlrCompra")));
				temp.setEstoque(Integer.parseInt(rs.getString("Estoque")));
				temp.setEstoqueMin(Integer.parseInt(rs.getString("EstoqueMinimo")));
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
	public Componentes[] consultarDesc(){
		int x = 0;
		ResultSet rs = null;
		Banco b = new Banco();
		
		rs = b.sqlConsulta("SELECT COUNT(*) AS total FROM Componente;");
		try {
			rs.next();
			x = Integer.parseInt(rs.getString("total"));
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

		if (x == 0) return null;

		Componentes[] p = new Componentes[x];
		rs = b.sqlConsulta("SELECT * FROM Componente WHERE Descricao = " + getBusca() + " ORDER BY IdComponente;");
		try {
			int count = 0;
			while (rs.next()) {
				Componentes temp = new Componentes();
				temp.setIdComponente(Integer.parseInt(rs.getString("IdComponente")));
				temp.setDescricao(rs.getString("Descricao"));
				temp.setVlrCompra(Float.parseFloat(rs.getString("VlrCompra")));
				temp.setEstoque(Integer.parseInt(rs.getString("Estoque")));
				temp.setEstoqueMin(Integer.parseInt(rs.getString("EstoqueMinimo")));
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
	
	
	public Componentes(int id) {
		setIdComponente(id);
		setDescricao("");
		setVlrCompra(0);
		setEstoque(0);
		setEstoqueMin(0);
		ResultSet rs = null;
		Banco b = new Banco();
		rs = b.sqlConsulta("SELECT * FROM Componente WHERE IdComponente = " + getIdComponente() + ";");
		try {
			rs.next();
			setDescricao(rs.getString("Descricao"));
			setEstoque(Integer.parseInt(rs.getString("Estoque")));
			setEstoqueMin(Integer.parseInt(rs.getString("EstoqueMinimo")));
			setVlrCompra(Float.parseFloat(rs.getString("VlrCompra")));
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	
	public int getIdComponente() {
		return IdComponente;
	}
	public void setIdComponente(int idComponente) {
		IdComponente = idComponente;
	}
	public String getDescricao() {
		return Descricao;
	}
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	public float getVlrCompra() {
		return vlrCompra;
	}
	public void setVlrCompra(float vlrCompra) {
		this.vlrCompra = vlrCompra;
	}
	public int getEstoque() {
		return Estoque;
	}
	public void setEstoque(int estoque) {
		Estoque = estoque;
	}
	public int getEstoqueMin() {
		return EstoqueMin;
	}
	public void setEstoqueMin(int estoqueMin) {
		EstoqueMin = estoqueMin;
	}	
	public String getBusca() {
		return busca;
	}

	public void setBusca(String busca) {
		this.busca = busca;
	}

}
