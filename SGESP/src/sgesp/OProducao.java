package sgesp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.management.openmbean.OpenDataException;
import javax.xml.crypto.Data;

public class OProducao {
	
	private int idOrdemProducao;
	private int idCliente;
	private int idProduto;
	private int qtd;
	private String dataSolicitacao;
	private String concluido;
	private String dataFinalizacao;
	private int estoqueNovo;
	
	
	public OProducao(){
		setIdOrdemProducao(0);
		setIdCliente(0);
		setIdProduto(0);
		setQtd(0);
		setDataSolicitacao("");
		setConcluido("");
		setDataFinalizacao("");
	}


	public void salvar() {
		Banco banco = new Banco();
		if (getIdOrdemProducao() > 0) {
			banco.sqlAtualizacao("UPDATE OrdemProducao SET  IdPessoaJuridica  = " + getIdCliente() + ", IdProduto = " + getIdProduto() + ", Quantidade = " + getQtd() + ", DataSolicitacao = '" + getDataSolicitacao() + "', Concluido = '" + getConcluido() + "', DataFinalizacao = '" + getDataFinalizacao() + "'  WHERE IdOrdemProducao = " + getIdOrdemProducao() + ";");
		} else {
			banco.sqlAtualizacao("INSERT INTO OrdemProducao (IdPessoaJuridica , IdProduto, Quantidade, DataSolicitacao, Concluido, DataFinalizacao) VALUES (" + getIdCliente() + "," + getIdProduto() + "," + getQtd() + ",'"+ getDataSolicitacao() + "', '" + getConcluido() + "', '" + getDataFinalizacao() +"');");
		}
	}
	
	public OProducao[] consultar() {

		int x = 0;
		ResultSet rs = null;
		Banco b = new Banco();

		rs = b.sqlConsulta("SELECT COUNT(*) AS total FROM OrdemProducao WHERE Concluido = 'N';");
		try {
			rs.next();
			x = Integer.parseInt(rs.getString("total"));
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

		if (x == 0) return null;

		OProducao[] p = new OProducao[x];
		rs = b.sqlConsulta("SELECT * FROM OrdemProducao WHERE Concluido = 'N' ORDER BY IdOrdemProducao;" );
		try {
			int count = 0;
			while (rs.next()) {
				OProducao temp = new OProducao();
				temp.setIdOrdemProducao(Integer.parseInt(rs.getString("IdOrdemProducao")));
				temp.setIdCliente(Integer.parseInt(rs.getString("IdPessoaJuridica")));
				temp.setIdProduto(Integer.parseInt(rs.getString("IdProduto")));
				temp.setQtd(Integer.parseInt(rs.getString("Quantidade")));
				temp.setDataSolicitacao(rs.getString("DataSolicitacao"));
				temp.setConcluido(rs.getString("Concluido"));
				temp.setDataFinalizacao(rs.getString("DataFinalizacao"));
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
	
	public void baixarEstoque(){
		Banco b = new Banco();
		if(getIdOrdemProducao() > 0){
			b.sqlAtualizacao("UPDATE OrdemProducao SET Estoque = "+ getEstoqueNovo()+"WHERE IdOrdemProducao = "+getIdOrdemProducao() +"; ");
		}
	}
	
	public OProducao(int id) {
		setIdOrdemProducao(id);
		setIdCliente(0);
		setIdProduto(0);
		setQtd(0);
		setConcluido("");
		setDataSolicitacao("");
		setDataFinalizacao("");
		ResultSet rs = null;
		Banco b = new Banco();
		rs = b.sqlConsulta("SELECT * FROM OrdemProducao WHERE IdOrdemProducao = " + getIdOrdemProducao() + ";");
		try {
			rs.next();
			setIdCliente(Integer.parseInt(rs.getString("IdPessoaJuridica")));
			setIdProduto(Integer.parseInt(rs.getString("IdProduto")));
			setQtd(Integer.parseInt(rs.getString("Quantidade")));
			setConcluido("Concluido");
			setDataSolicitacao(rs.getString("DataSolicitacao"));
			setDataFinalizacao(rs.getString("DataFinalizacao"));
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public int getIdOrdemProducao() {
		return idOrdemProducao;
	}
	public void setIdOrdemProducao(int idOrdemProducao) {
		this.idOrdemProducao = idOrdemProducao;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
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
	public String getConcluido() {
		return concluido;
	}
	public void setConcluido(String concluido) {
		this.concluido = concluido;
	}
	public String getDataSolicitacao() {
		return dataSolicitacao;
	}
	public void setDataSolicitacao(String dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}
	public String getDataFinalizacao() {
		return dataFinalizacao;
	}
	public void setDataFinalizacao(String dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}
	public int getEstoqueNovo() {
		return estoqueNovo;
	}
	public void setEstoqueNovo(int estoqueNovo) {
		this.estoqueNovo = estoqueNovo;
	}
	


}
