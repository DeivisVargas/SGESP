package sgesp;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ComponentesProduto {
	


	private int idComponenetesProduto;
	private int idComponente;
	private int idProduto = 0 ;
	private int qtd;
	private int idproconsulta ;
	
	Produto produto = new Produto();
	
	
	
	public ComponentesProduto(){
		setIdComponenetesProduto(0);
		setIdComponente(0);
		setIdProduto(0);
		setQtd(1);
	}
	
	
	
	
   
	
	public void salvar() {
		Banco banco = new Banco();
		if (getIdComponenetesProduto() > 0) {
			banco.sqlAtualizacao("UPDATE ComponentesProduto SET  IdComponente = " + getIdComponente() + ", IdProduto = " + getIdProduto() + ", Quantidade = " + getQtd() + "  WHERE IdComponentesProduto = " + getIdProduto() + ";");
		} else {
			banco.sqlAtualizacao("INSERT INTO ComponentesProduto (IdComponente, IdProduto, Quantidade) VALUES (" + getIdComponente() + "," + getIdProduto() + "," + getQtd() + ");");
		}
	}
	
	
	public void remover() {
		Banco b = new Banco();
		if (getIdProduto() > 0) {
			b.sqlAtualizacao("DELETE FROM ComponentesProduto WHERE IdComponentesProduto = " + getIdComponenetesProduto() + ";");
		}
	}
	
	
	
	
	public ComponentesProduto[] consultar() {

		int x = 0;
		ResultSet rs = null;
		Banco b = new Banco();

		rs = b.sqlConsulta("SELECT COUNT(*) AS total FROM ComponentesProduto c  WHERE c.IdProduto = " + Comprod.pro +" ;");
		try {
			rs.next();
			x = Integer.parseInt(rs.getString("total"));
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

		if (x == 0) return null;

		ComponentesProduto[] p = new ComponentesProduto[x];
		
		rs = b.sqlConsulta("SELECT * FROM ComponentesProduto c WHERE c.IdProduto = " + Comprod.pro + ";" );
		
		//rs = b.sqlConsulta("SELECT * FROM ComponentesProduto WHERE IdProduto = " + produto.getIdPro() + ";" );
		try {
			int count = 0;
			while (rs.next()) {
				ComponentesProduto temp = new ComponentesProduto();
				temp.setIdComponenetesProduto(Integer.parseInt(rs.getString("IdComponentesProduto")));
				temp.setIdComponente(Integer.parseInt(rs.getString("IdComponente")));
				temp.setIdProduto(Integer.parseInt(rs.getString("IdProduto")));
				temp.setQtd(Integer.parseInt(rs.getString("Quantidade")));
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
	
	public ComponentesProduto(int id) {
		setIdComponenetesProduto(id);
		setIdComponente(0);
		setIdProduto(0);
		setQtd(0);
		ResultSet rs = null;
		Banco b = new Banco();
		rs = b.sqlConsulta("SELECT * FROM ComponentesProduto WHERE IdComponentesProduto = " + getIdComponenetesProduto() + ";");
		try {
			rs.next();
			setIdComponente(Integer.parseInt(rs.getString("IdComponente")));
			setIdProduto(Integer.parseInt(rs.getString("IdProduto")));
			setQtd(Integer.parseInt(rs.getString("Quantidade")));
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public int getIdComponenetesProduto() {
		return idComponenetesProduto;
	}
	public void setIdComponenetesProduto(int idComponenetesProduto) {
		this.idComponenetesProduto = idComponenetesProduto;
	}
	public int getIdComponente() {
		return idComponente;
	}
	public void setIdComponente(int idComponente) {
		this.idComponente = idComponente;
	}
	public int getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	public int getQtd() {
		return qtd;
	}
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	
	
	

}
