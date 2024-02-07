package sgesp;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Panel;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

public class CFuncionario extends JPanel {
	private JTextField txtCarteira;
	private JTextField txtDataAdimissao;
	private JTextField txtDataDemissao;
	private JTable table;
	private JLabel lblCdigoPessoa;
	private JTextField txtusuario;
	private JPasswordField txtsenha;
	private JCheckBox cmbadmin;

	/**
	 * Create the panel.
	 * @param id 
	 */
	public CFuncionario(JFrame frame, int id ) {
		setLayout(null);
		
		
		// aqui esta o erro
		PessoaFisica pessoa = new PessoaFisica(id);
		 
		
		Funcionario funcionario = new Funcionario();
		
		lblCdigoPessoa = new JLabel("C\u00F3digo da pessoa:" + pessoa.getIdPessoaFisica());
		lblCdigoPessoa.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCdigoPessoa.setBounds(322, 61, 275, 14);
		add(lblCdigoPessoa);
		
		
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String vet =  lblCdigoPessoa.getText();  
				String[] pessoa = vet.split(":");
				int idPessoa = Integer.parseInt(pessoa[1]);	
				funcionario.setIdPessoaFisica(idPessoa);
				
				String administrador ;
				if (cmbadmin.isSelected()){
					administrador = "S" ;
					funcionario.setAdm(administrador);				
					
				}
				else {
					administrador = "N" ;
					funcionario.setAdm(administrador);
				}
				
				funcionario.setIdPessoaFisica(idPessoa);
				funcionario.setDataAdimissao(txtDataAdimissao.getText());
				funcionario.setDataDemissao(txtDataDemissao.getText());
				funcionario.setnCarteira(txtCarteira.getText());
				
				funcionario.salvar(txtusuario.getText(),txtsenha.getText());
				
				limparFormulario();
				carregarGrid();
			}
		});
		btnSalvar.setBounds(40, 270, 120, 41);
		btnSalvar.setIcon(new ImageIcon(CFuncionario.class.getResource("/img/2683_32x32.png")));
		add(btnSalvar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (table.getSelectedRow() >= 0) {  
					frame.getContentPane().removeAll();
					EditarFuncionario atualizar = new EditarFuncionario(frame, (int)table.getValueAt(table.getSelectedRow(), 0));
					frame.getContentPane().add(atualizar, BorderLayout.CENTER);
					frame.getContentPane().revalidate();
				} else {   
					JOptionPane.showMessageDialog(frame,    
							"Selecione um Funcionario!",   
							"Mensagem", JOptionPane.PLAIN_MESSAGE); 
				}
				
				
			}
		});
		btnEditar.setBounds(195, 270, 120, 41);
		btnEditar.setIcon(new ImageIcon(CFuncionario.class.getResource("/img/edit.png")));
		add(btnEditar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparFormulario();
			}
		});
		btnLimpar.setBounds(355, 269, 120, 41);
		btnLimpar.setIcon(new ImageIcon(CFuncionario.class.getResource("/img/cancelar.png")));
		btnLimpar.setFont(new Font("Arial", Font.PLAIN, 12));
		add(btnLimpar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (table.getSelectedRow() >= 0) {  
					frame.getContentPane().removeAll();
					RemoverFuncionario removerEstado = new RemoverFuncionario(frame,(int)table.getValueAt(table.getSelectedRow(), 0));
					frame.getContentPane().add(removerEstado, BorderLayout.CENTER);
					frame.getContentPane().revalidate();					
				} else {   
					JOptionPane.showMessageDialog(frame,    
							"Selecione um Funcionario!",   
							"Mensagem", JOptionPane.PLAIN_MESSAGE); 
				}
				
				
			}
		});
		btnExcluir.setBounds(510, 270, 120, 41);
		btnExcluir.setIcon(new ImageIcon(CFuncionario.class.getResource("/img/Botao-Excluir.png")));
		add(btnExcluir);
		
		JLabel label_5 = new JLabel("N\u00B0 Cateira :");
		label_5.setBounds(10, 102, 70, 14);
		label_5.setFont(new Font("Arial", Font.PLAIN, 12));
		add(label_5);
		
		txtCarteira = new JTextField();
		txtCarteira.setBounds(116, 99, 211, 20);
		txtCarteira.setFont(new Font("Arial", Font.PLAIN, 12));
		txtCarteira.setColumns(10);
		add(txtCarteira);
		
		JLabel label_11 = new JLabel("Data  adimiss\u00E3o :");
		label_11.setBounds(10, 127, 102, 14);
		label_11.setFont(new Font("Arial", Font.PLAIN, 12));
		add(label_11);
		
		JLabel label_12 = new JLabel("Data demiss\u00E3o : ");
		label_12.setBounds(10, 164, 94, 14);
		label_12.setFont(new Font("Arial", Font.PLAIN, 12));
		add(label_12);
		
		txtDataAdimissao = new JTextField();
		txtDataAdimissao.setBounds(116, 130, 211, 20);
		txtDataAdimissao.setFont(new Font("Arial", Font.PLAIN, 12));
		txtDataAdimissao.setColumns(10);
		add(txtDataAdimissao);
		
		txtDataDemissao = new JTextField();
		txtDataDemissao.setBounds(116, 164, 211, 20);
		txtDataDemissao.setFont(new Font("Arial", Font.PLAIN, 12));
		txtDataDemissao.setColumns(10);
		add(txtDataDemissao);
		
		JLabel lblLogin = new JLabel("Login :");
		lblLogin.setFont(new Font("Arial", Font.PLAIN, 12));
		lblLogin.setBounds(375, 103, 70, 14);
		add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha :");
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSenha.setBounds(375, 128, 50, 14);
		add(lblSenha);
		
		txtusuario = new JTextField();
		txtusuario.setFont(new Font("Arial", Font.PLAIN, 12));
		txtusuario.setColumns(10);
		txtusuario.setBounds(435, 100, 211, 20);
		add(txtusuario);
		
		txtsenha = new JPasswordField();
		txtsenha.setBounds(435, 125, 211, 20);
		add(txtsenha);
		
		 cmbadmin = new JCheckBox("Administrador ");
		cmbadmin.setBounds(436, 161, 133, 23);
		add(cmbadmin);
		
		JLabel lblCadastroDeFuncionrios = new JLabel("Cadastro de Funcion\u00E1rios");
		lblCadastroDeFuncionrios.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCadastroDeFuncionrios.setBounds(269, 22, 181, 14);
		add(lblCadastroDeFuncionrios);
		
		JButton btnSelecionarPessoa = new JButton("Selecionar Pessoa");
		btnSelecionarPessoa.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				frame.getContentPane().removeAll();
				SelecionarPessoaFisica pessoa = new SelecionarPessoaFisica(frame);
				frame.getContentPane().add(pessoa, BorderLayout.CENTER);
				frame.getContentPane().revalidate();
			}
		});
		btnSelecionarPessoa.setFont(new Font("Arial", Font.PLAIN, 12));
		btnSelecionarPessoa.setBounds(144, 47, 161, 41);
		add(btnSelecionarPessoa);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 333, 609, 147);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "C\u00F3digo Pessoa", "N\u00BA Carteira", "Data Demiss\u00E3o", "Data Adimiss\u00E3o", "Usuario","Administrador"
			}
		));
		//table.getColumnModel().getColumn(1).setPreferredWidth(89);
		scrollPane.setViewportView(table);
         carregarGrid();
		
	
		
		
	}
	
	// tambem tem erros aqui 

	private void carregarGrid(){
		DefaultTableModel dtm = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Codigo", "Codigo Pessoa", "N Carteira", "Data Admissao", "Data Demissao", "Usuario","Administrador"
				}
			);
			
			Funcionario funcionario = new Funcionario();
			Funcionario[] funcs = funcionario.consultar();
		    if (funcs != null) {
		    	for (int i=0; i<funcs.length; i++) {
		    		dtm.addRow(new Object[] {
		    				funcs[i].getIdFuncionario(),
		    				funcs[i].getIdPessoaFisica(),
		    				funcs[i].getnCarteira(),
		    				funcs[i].getDataAdimissao(),
		    				funcs[i].getDataDemissao(),
		    				funcs[i].getUsuario(),
		    				funcs[i].getAdm() 
		    		});
		    	}
		    }
		    
		    table.setModel(dtm);
	}
	
	private void limparFormulario(){
		lblCdigoPessoa.setText("C\u00F3digo Pessoa:");
		txtCarteira.setText("");
		txtDataAdimissao.setText("");
		txtDataDemissao.setText("");
		txtusuario.setText("");
		txtsenha.setText("");
		cmbadmin.setSelected(false);
	}
	/*
	public void carregarCmb(){			
		Funcao funcao = new Funcao();
		Funcao[] funcoes = funcao.consultar();
	    if (funcoes != null) {  
	    	for (int i=0; i<funcoes.length; i++) {
	    		cmbFuncao.addItem(funcoes[i].getIdFuncao() + " " + funcoes[i].getFuncao());
	    	}
	    }
	}
	
	*/
}
