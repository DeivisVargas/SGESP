package sgesp;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Produto {

	private int idProduto;
	private String descricao;
	private float vlrVenda;
	private int idPro;
	

	public Produto() {
		setIdProduto(0);
		setDescricao("");
		setVlrVenda(0);
		setIdPro(0);
	}

	public void salvar() {
		Banco banco = new Banco();
		if (getIdProduto() > 0) {
			banco.sqlAtualizacao("UPDATE Produto SET Descricao = '"
					+ getDescricao() + "', VlrVenda = " + getVlrVenda()
					+ " WHERE IdProduto = " + getIdProduto() + ";");
		} else {
			banco.sqlAtualizacao("INSERT INTO Produto (Descricao, VlrVenda) VALUES ('"
					+ getDescricao() + "'," + getVlrVenda() + ");");

		}

	}

	public void remover() {
		Banco b = new Banco();
		if (getIdProduto() > 0) {
			b.sqlAtualizacao("DELETE FROM Produto WHERE IdProduto = "
					+ getIdProduto() + ";");
		}
	}

	public void consultarId() {
		ResultSet rs = null;
		Banco b = new Banco();

		rs = b.sqlConsulta("SELECT * FROM Produto  WHERE Descricao = '"+ getDescricao() +"' ;");
	
		try {
			
			  if (rs.next()) {
				  
				  //atribui os valores da variaveis do banco ,para as variaveis locais 
				  
					
					this.idPro = (Integer.parseInt(rs.getString("IdProduto")));
					
					
				
				}
			} catch(SQLException e) {
				System.out.println(e.getMessage());
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
	}

	public Produto[] consultar() {

		int x = 0;
		ResultSet rs = null;
		Banco b = new Banco();

		rs = b.sqlConsulta("SELECT COUNT(*) AS total FROM Produto;");
		try {
			rs.next();
			x = Integer.parseInt(rs.getString("total"));
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

		if (x == 0) return null;

		Produto[] p = new Produto[x];
		rs = b.sqlConsulta("SELECT * FROM Produto ORDER BY IdProduto;");
		try {
			int count = 0;
			while (rs.next()) {
				Produto temp = new Produto();
				temp.setIdProduto(Integer.parseInt(rs.getString("IdProduto")));
				temp.setDescricao(rs.getString("Descricao"));
				temp.setVlrVenda(Float.parseFloat(rs.getString("VlrVenda")));
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

	public Produto(int id) {
		setIdProduto(id);
		setDescricao("");
		setVlrVenda(0);
		ResultSet rs = null;
		Banco b = new Banco();
		rs = b.sqlConsulta("SELECT * FROM Produto WHERE IdProduto = "
				+ getIdProduto() + ";");
		try {
			rs.next();
			setDescricao(rs.getString("Descricao"));
			setVlrVenda(Float.parseFloat(rs.getString("VlrVenda")));
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getVlrVenda() {
		return vlrVenda;
	}

	public void setVlrVenda(float vlrVenda) {
		this.vlrVenda = vlrVenda;
	}

	public int getIdPro() {
		return idPro;
	}

	public void setIdPro(int idPro) {
		this.idPro = idPro;
	}

}
