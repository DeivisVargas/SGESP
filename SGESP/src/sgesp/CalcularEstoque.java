package sgesp;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CalcularEstoque {
	private int idProduto;
	private int estoque;
	private int qtd;
	private int qtdProd;
	private int novoEstoque;
	private int qtdCerta;
	
	public CalcularEstoque(){
		setIdProduto(0);
		setEstoque(0);
		setQtd(0);
		setQtdProd(0);
		setNovoEstoque(0);
		setQtdCerta(0);
	}
	
	public void calculaQtd(){
		setQtdCerta(getQtd() * getQtdProd()); 
	}
	
	public void calculaEstoque(){
		Banco b = new Banco();
		setNovoEstoque(getEstoque() - getQtdCerta());
		if(getIdProduto() > 0){
			b.sqlAtualizacao("UPDATE Componente SET Estoque = "+ getNovoEstoque()+"WHERE IdComponente = "+getIdProduto() +"; ");
		}
	}
	
	public  boolean verificar() {

		try {
			
		  if (getEstoque() >= getQtdCerta()) {
				return true;
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	
			return false;
			
	}
	
	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public int getEstoque() {
		return estoque;
	}
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	public int getQtd() {
		return qtd;
	}
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	public int getNovoEstoque() {
		return novoEstoque;
	}
	public void setNovoEstoque(int novoEstoque) {
		this.novoEstoque = novoEstoque;
	}

	public int getQtdProd() {
		return qtdProd;
	}

	public void setQtdProd(int qtdProd) {
		this.qtdProd = qtdProd;
	}

	public int getQtdCerta() {
		return qtdCerta;
	}

	public void setQtdCerta(int qtdCerta) {
		this.qtdCerta = qtdCerta;
	}
	
	

}
