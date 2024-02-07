package sgesp;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.color.CMMException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

public class CPessoaFisica extends JPanel {
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtRg;
	private JTextField txtEndereco;
	private JTextField txtCep;
	private JTextField txtEmail;
	private JComboBox cmbCidade;
	private JTable table;
	private JTextField txttelefone;
	private JTextField txtcelular;

	/**
	 * Create the panel.
	 */
	public CPessoaFisica(JFrame frame) {
		setLayout(null);
		
		PessoaFisica pessoa = new PessoaFisica();
		
		JLabel label = new JLabel("Cadastro de Pessoa F\u00EDsica");
		label.setFont(new Font("Arial", Font.PLAIN, 14));
		label.setBounds(187, 11, 181, 14);
		add(label);
		
		JLabel label_1 = new JLabel("Nome :");
		label_1.setFont(new Font("Arial", Font.PLAIN, 12));
		label_1.setBounds(10, 47, 46, 14);
		add(label_1);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(79, 45, 245, 20);
		add(txtNome);
		
		JLabel label_2 = new JLabel("CPF :");
		label_2.setFont(new Font("Arial", Font.PLAIN, 12));
		label_2.setBounds(10, 72, 46, 14);
		add(label_2);
		
		txtCpf = new JTextField();
		txtCpf.setColumns(10);
		txtCpf.setBounds(79, 70, 245, 20);
		add(txtCpf);
		
		JLabel label_3 = new JLabel("RG :");
		label_3.setFont(new Font("Arial", Font.PLAIN, 12));
		label_3.setBounds(370, 72, 46, 14);
		add(label_3);
		
		txtRg = new JTextField();
		txtRg.setColumns(10);
		txtRg.setBounds(435, 70, 245, 20);
		add(txtRg);
		
		JLabel label_4 = new JLabel("Endere\u00E7o :");
		label_4.setFont(new Font("Arial", Font.PLAIN, 12));
		label_4.setBounds(10, 99, 63, 14);
		add(label_4);
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(79, 97, 245, 20);
		add(txtEndereco);
		
		JLabel label_5 = new JLabel("Cep :");
		label_5.setFont(new Font("Arial", Font.PLAIN, 12));
		label_5.setBounds(10, 126, 46, 14);
		add(label_5);
		
		txtCep = new JTextField();
		txtCep.setColumns(10);
		txtCep.setBounds(79, 124, 245, 20);
		add(txtCep);
		
		JLabel label_6 = new JLabel("Email :");
		label_6.setFont(new Font("Arial", Font.PLAIN, 12));
		label_6.setBounds(370, 47, 46, 14);
		add(label_6);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(435, 45, 245, 20);
		add(txtEmail);
		
		JLabel lblCidade = new JLabel("Cidade: ");
		lblCidade.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCidade.setBounds(10, 257, 46, 14);
		add(lblCidade);
		
		cmbCidade = new JComboBox();
		cmbCidade.setBounds(79, 255, 245, 20);
		add(cmbCidade);
		JLabel lblTelefone = new JLabel("Telefone :");
		lblTelefone.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTelefone.setBounds(370, 99, 54, 14);
		add(lblTelefone);
		
		JLabel lblCelular = new JLabel("Celular :");
		lblCelular.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCelular.setBounds(370, 126, 46, 14);
		add(lblCelular);
		
		txttelefone = new JTextField();
		txttelefone.setColumns(10);
		txttelefone.setBounds(435, 97, 245, 20);
		add(txttelefone);
		
		txtcelular = new JTextField();
		txtcelular.setColumns(10);
		txtcelular.setBounds(435, 124, 245, 20);
		add(txtcelular);
		
		
		carregarCmb();
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setIcon(new ImageIcon(CPessoaFisica.class.getResource("/img/2683_32x32.png")));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String vet =  (String) cmbCidade.getSelectedItem();  
				String[] cidade = vet.split(" ");
				int idCidade = Integer.parseInt(cidade[0]);	
				
				pessoa.setNome(txtNome.getText());
				pessoa.setCpf(txtCpf.getText());
				pessoa.setRg(txtRg.getText());
				pessoa.setIdCidade(idCidade);
				pessoa.setCep(txtCep.getText());
				pessoa.setEndereco(txtEndereco.getText());
				pessoa.setEmail(txtEmail.getText());
				pessoa.setTelefone(txttelefone.getText());
				pessoa.setCelular(txtcelular.getText());
				pessoa.salvar();
				carregarGrid();
				limparFormulario();
			}
		});
		btnSalvar.setBounds(31, 332, 120, 41);
		add(btnSalvar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setIcon(new ImageIcon(CPessoaFisica.class.getResource("/img/edit.png")));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (table.getSelectedRow() >= 0) {  
					frame.getContentPane().removeAll();
					EditarPessoaFisica atualizar = new EditarPessoaFisica(frame, (int)table.getValueAt(table.getSelectedRow(), 0));
					frame.getContentPane().add(atualizar, BorderLayout.CENTER);
					frame.getContentPane().revalidate();
				} else {   
					JOptionPane.showMessageDialog(frame,    
							"Selecione uma Pessoa!",   
							"Mensagem", JOptionPane.PLAIN_MESSAGE); 
				}
			}
		});
		btnEditar.setBounds(179, 332, 120, 41);
		add(btnEditar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setIcon(new ImageIcon(CPessoaFisica.class.getResource("/img/cancelar.png")));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparFormulario();
			}
		});
		btnLimpar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnLimpar.setBounds(326, 332, 120, 41);
		add(btnLimpar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setIcon(new ImageIcon(CPessoaFisica.class.getResource("/img/Botao-Excluir.png")));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (table.getSelectedRow() >= 0) {  
					frame.getContentPane().removeAll();
					RemoverPessoaFisica remover = new RemoverPessoaFisica(frame,(int)table.getValueAt(table.getSelectedRow(), 0));
					frame.getContentPane().add(remover, BorderLayout.CENTER);
					frame.getContentPane().revalidate();					
				} else {   
					JOptionPane.showMessageDialog(frame,    
							"Selecione uma Pessoa!",   
							"Mensagem", JOptionPane.PLAIN_MESSAGE); 
				}
			}
		});
		btnExcluir.setBounds(466, 332, 120, 41);
		add(btnExcluir);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 382, 694, 129);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Nome", "CPF", "RG", "Endere\u00E7o", "Cep", "Cidade", "Email","Telefone","Celular",
			}
		));
		scrollPane.setViewportView(table);
		
		
		
		carregarGrid();

	}
	
	private void carregarGrid(){
		DefaultTableModel dtm = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Codigo", "Nome", "CPF", "RG", "Endereco", "CEP", "Cidade", "Email" ,"Telefone","Celular",
				}
			);
			
			PessoaFisica pessoa = new PessoaFisica();
			PessoaFisica[] pessoas = pessoa.consultar();
		    if (pessoas != null) {
		    	for (int i=0; i<pessoas.length; i++) {
		    		dtm.addRow(new Object[] {
		    				pessoas[i].getIdPessoaFisica(),
		    				pessoas[i].getNome(),
		    				pessoas[i].getCpf(),
		    				pessoas[i].getRg(),
		    				pessoas[i].getEndereco(),
		    				pessoas[i].getCep(),
		    				pessoas[i].getIdCidade(),
		    				pessoas[i].getEmail(),
		    				pessoas[i].getTelefone(),
		    				pessoas[i].getCelular(),
		    		});
		    	}
		    }
		    
		    table.setModel(dtm);
	}
	
	private void limparFormulario(){
		txtCep.setText("");
		txtCpf.setText("");
		txtEmail.setText("");
		txtEndereco.setText("");
		txtNome.setText("");
		txtRg.setText("");
		txttelefone.setText("");
		txtcelular.setText("");
		cmbCidade.setSelectedItem(0);
	}
	
	public void carregarCmb(){			
		Cidade cidade = new Cidade();
		Cidade[] cidades = cidade.consultar();
	    if (cidades != null) {  
	    	for (int i=0; i<cidades.length; i++) {
	    		cmbCidade.addItem(cidades[i].getIdCidade() + " " + cidades[i].getCidade());
	    	}
	    }
	}
}
