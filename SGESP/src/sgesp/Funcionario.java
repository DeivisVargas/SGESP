package sgesp;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Funcionario {
	
	private int idFuncionario;
	private int idPessoaFisica;
	private String nCarteira;
	private String dataAdimissao;
	private String dataDemissao;
	private String usuario ;
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	private String adm ;
	
	public String getAdm() {
		return adm;
	}

	public void setAdm(String adm) {
		this.adm = adm;
	}

	public Funcionario(){
		setIdFuncionario(0);
		setIdPessoaFisica(0);
		setnCarteira("");
		setDataAdimissao("");
		setDataDemissao("");
		setUsuario("");
		setAdm("");
		
	}
	
	public void salvar(String usuario ,String senha ) {
		Banco banco = new Banco();
		if (getIdFuncionario() > 0) {
			banco.sqlAtualizacao("UPDATE Funcinario SET  IdPessoaFisica = " + getIdPessoaFisica() + ",Administrador = '"+ getAdm() +"', Carteira = '" + getnCarteira() + "', Data_Admissao = '" + getDataAdimissao() + "', Data_Demissao = '" + getDataDemissao() + "', Usuario = '"+ usuario +"' , Senha = HASHBYTES('MD5','" + senha + "') WHERE IdFuncionario = " + getIdFuncionario() + ";");
		} else {
			banco.sqlAtualizacao("INSERT INTO Funcinario (IdPessoaFisica, Carteira, Data_Admissao, Data_Demissao,Usuario,Senha,Administrador) VALUES (" + getIdPessoaFisica() + ", '" + getnCarteira() + "', '" + getDataAdimissao() + "', '" + getDataDemissao() + "','" + usuario + "', HASHBYTES('MD5', '" + senha + "'),'"+getAdm() +"');");
		}
	}
	
	public  boolean verificar(String usuario, String senha) {

		ResultSet rs = null;
		Banco b = new Banco();

		rs = b.sqlConsulta("SELECT * FROM Funcinario  WHERE Usuario = '"+ usuario +"' AND Senha = HASHBYTES('MD5', '"+senha+"') ;");
		try {
			
		  if (rs.next()) {
			  
			  //atribui os valores da variaveis do banco ,para as variaveis locais 
				
				//this.Adm = (rs.getString("Administrador"));
				return true;
			
			}
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	
			return false;
			
	}
	
	public void remover() {
		Banco b = new Banco();
		if (getIdPessoaFisica() > 0) {
			b.sqlAtualizacao("DELETE FROM Funcinario WHERE IdFuncionario = " + getIdFuncionario() + ";");
		}
	}
	
	public Funcionario[] consultar() {

		int x = 0;
		ResultSet rs = null;
		Banco b = new Banco();

		rs = b.sqlConsulta("SELECT COUNT(*) AS total FROM Funcinario;");
		try {
			rs.next();
			x = Integer.parseInt(rs.getString("total"));
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

		if (x == 0) return null;

		Funcionario[] p = new Funcionario[x];
		rs = b.sqlConsulta("SELECT * FROM Funcinario ORDER BY IdFuncionario;");
		try {
			int count = 0;
			while (rs.next()) {
				Funcionario temp = new Funcionario();
				temp.setIdFuncionario(Integer.parseInt(rs.getString("IdFuncionario")));
				temp.setIdPessoaFisica(Integer.parseInt(rs.getString("IdPessoaFisica")));
				temp.setnCarteira(rs.getString("Carteira"));
				temp.setDataAdimissao(rs.getString("Data_Admissao"));
				temp.setDataDemissao(rs.getString("Data_Demissao"));
				temp.setUsuario(rs.getString("Usuario"));
				temp.setAdm(rs.getString("Administrador"));
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
	
	public Funcionario(int id) {
		setIdFuncionario(id);
		setIdPessoaFisica(0);
		setDataAdimissao("");
		setDataDemissao("");
		setnCarteira("");
		setUsuario("");
		setAdm("");
		ResultSet rs = null;
		Banco b = new Banco();
		rs = b.sqlConsulta("SELECT * FROM Funcinario WHERE IdFuncionario = " + getIdFuncionario() + ";");
		try {
			rs.next();
			setIdFuncionario(Integer.parseInt(rs.getString("IdFuncionario")));
			setIdPessoaFisica(Integer.parseInt(rs.getString("IdPessoaFisica")));
			setDataAdimissao(rs.getString("Data_Admissao"));
			setDataDemissao(rs.getString("Data_Demissao"));
			setnCarteira(rs.getString("Carteira"));
			setUsuario(rs.getString("Usuario"));
			setAdm(rs.getString("Administrador"));
			
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public int getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public int getIdPessoaFisica() {
		return idPessoaFisica;
	}

	public void setIdPessoaFisica(int idPessoaFisica) {
		this.idPessoaFisica = idPessoaFisica;
	}

	public String getnCarteira() {
		return nCarteira;
	}

	public void setnCarteira(String nCarteira) {
		this.nCarteira = nCarteira;
	}

	

	

	public String getDataAdimissao() {
		return dataAdimissao;
	}

	public void setDataAdimissao(String dataAdimissao) {
		this.dataAdimissao = dataAdimissao;
	}

	public String getDataDemissao() {
		return dataDemissao;
	}

	public void setDataDemissao(String dataDemissao) {
		this.dataDemissao = dataDemissao;
	}



	

	
}
