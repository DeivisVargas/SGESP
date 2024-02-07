package sgesp;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CPessoaJuridica extends JPanel {
	private JTextField txtrz;
	private JTextField txtfantasia;
	private JTextField txtcnpj;
	private JTextField txtir;
	private JTextField txtendereco;
	private JTextField txtemail;
	private JTextField txtcep;
	private JComboBox cmbcidade;
	private JTable table;
	private JTextField txttelefone;
	private JTextField txtcelular;

	/**
	 * Create the panel.
	 * @param frmSgesp 
	 */
	public CPessoaJuridica(JFrame frame) {
		setLayout(null);
		
		PessoaJuridica pessoa2 = new PessoaJuridica() ;
		
		
		
		JLabel lblCadastroDePessoa = new JLabel("Cadastro de Pessoa Juridica");
		lblCadastroDePessoa.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCadastroDePessoa.setBounds(240, 11, 216, 14);
		add(lblCadastroDePessoa);
		
		JLabel label = new JLabel("Cidade: ");
		label.setFont(new Font("Arial", Font.PLAIN, 12));
		label.setBounds(10, 155, 46, 14);
		add(label);
		
		 cmbcidade = new JComboBox();
		cmbcidade.setBounds(101, 152, 245, 20);
		add(cmbcidade);
		carregarCmb();
		
		JButton button = new JButton("Salvar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String vet =  (String) cmbcidade.getSelectedItem();  
				String[] cidade = vet.split(" ");
				int idCidade = Integer.parseInt(cidade[0]);	
				
				pessoa2.setRzSocial(txtrz.getText());
				pessoa2.setFantasia(txtfantasia.getText());
				pessoa2.setCnpj(txtcnpj.getText());
				pessoa2.setIr(txtir.getText());
				pessoa2.setIdCidade(idCidade);
				pessoa2.setEndereco(txtendereco.getText());
				pessoa2.setEmail(txtemail.getText());
				pessoa2.setCep(txtcep.getText());
				pessoa2.setTelefone(txttelefone.getText());
				pessoa2.setCelular(txtcelular.getText());
				pessoa2.salvar();
				
				carregarGrid();
				limparFormulario();
				
				
				
				
				
				
				
			}
		});
		button.setIcon(new ImageIcon(CPessoaJuridica.class.getResource("/img/2683_32x32.png")));
		button.setFont(new Font("Arial", Font.PLAIN, 12));
		button.setBounds(83, 221, 120, 41);
		add(button);
		
		JButton button_1 = new JButton("Editar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (table.getSelectedRow() >= 0) {  
					frame.getContentPane().removeAll();
					EditarPessoaJuridica atualizar = new EditarPessoaJuridica(frame, (int)table.getValueAt(table.getSelectedRow(), 0));
					frame.getContentPane().add(atualizar, BorderLayout.CENTER);
					frame.getContentPane().revalidate();
				} else {   
					JOptionPane.showMessageDialog(frame,   
							
							"Selecione uma Pessoa!",   
							"Mensagem", JOptionPane.PLAIN_MESSAGE); 
				}
			}
		});
		button_1.setIcon(new ImageIcon(CPessoaJuridica.class.getResource("/img/edit.png")));
		button_1.setFont(new Font("Arial", Font.PLAIN, 12));
		button_1.setBounds(231, 221, 120, 41);
		add(button_1);
		
		JButton button_2 = new JButton("Limpar");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				limparFormulario();
			}
		});
		button_2.setIcon(new ImageIcon(CPessoaJuridica.class.getResource("/img/cancelar.png")));
		button_2.setFont(new Font("Arial", Font.PLAIN, 12));
		button_2.setBounds(378, 221, 120, 41);
		add(button_2);
		
		JButton button_3 = new JButton("Excluir");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (table.getSelectedRow() >= 0) {  
					frame.getContentPane().removeAll();
					RemoverPessoaJuridica remover = new RemoverPessoaJuridica(frame,(int)table.getValueAt(table.getSelectedRow(), 0));
					frame.getContentPane().add(remover, BorderLayout.CENTER);
					frame.getContentPane().revalidate();					
				} else {   
					JOptionPane.showMessageDialog(frame,    
							"Selecione uma Pessoa!",   
							"Mensagem", JOptionPane.PLAIN_MESSAGE); 
				}
				
				
			}
		});
		button_3.setIcon(new ImageIcon(CPessoaJuridica.class.getResource("/img/Botao-Excluir.png")));
		button_3.setFont(new Font("Arial", Font.PLAIN, 12));
		button_3.setBounds(518, 221, 120, 41);
		add(button_3);
		
		JLabel lblRazoSocial = new JLabel("Raz\u00E3o Social :");
		lblRazoSocial.setFont(new Font("Arial", Font.PLAIN, 12));
		lblRazoSocial.setBounds(10, 43, 81, 14);
		add(lblRazoSocial);
		
		JLabel lblFantasia = new JLabel("Fantasia :");
		lblFantasia.setFont(new Font("Arial", Font.PLAIN, 12));
		lblFantasia.setBounds(380, 43, 59, 14);
		add(lblFantasia);
		
		JLabel lblCnpj = new JLabel("CNPJ :");
		lblCnpj.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCnpj.setBounds(10, 68, 46, 14);
		add(lblCnpj);
		
		JLabel lblIr = new JLabel("IR");
		lblIr.setFont(new Font("Arial", Font.PLAIN, 12));
		lblIr.setBounds(398, 68, 27, 14);
		add(lblIr);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o :");
		lblEndereo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblEndereo.setBounds(10, 93, 68, 14);
		add(lblEndereo);
		
		JLabel lblCep = new JLabel("CEP :");
		lblCep.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCep.setBounds(10, 122, 38, 14);
		add(lblCep);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 12));
		lblEmail.setBounds(379, 93, 46, 14);
		add(lblEmail);
		
		JLabel lblTelefone = new JLabel("Telefone :");
		lblTelefone.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTelefone.setBounds(378, 122, 59, 14);
		add(lblTelefone);
		
		txtrz = new JTextField();
		txtrz.setBounds(101, 41, 245, 20);
		add(txtrz);
		txtrz.setColumns(10);
		
		txtfantasia = new JTextField();
		txtfantasia.setColumns(10);
		txtfantasia.setBounds(449, 41, 245, 20);
		add(txtfantasia);
		
		txtcnpj = new JTextField();
		txtcnpj.setColumns(10);
		txtcnpj.setBounds(101, 68, 245, 20);
		add(txtcnpj);
		
		txtir = new JTextField();
		txtir.setColumns(10);
		txtir.setBounds(449, 68, 245, 20);
		add(txtir);
		
		txtendereco = new JTextField();
		txtendereco.setColumns(10);
		txtendereco.setBounds(101, 93, 245, 20);
		add(txtendereco);
		
		txtemail = new JTextField();
		txtemail.setColumns(10);
		txtemail.setBounds(449, 93, 245, 20);
		add(txtemail);
		
		txtcep = new JTextField();
		txtcep.setColumns(10);
		txtcep.setBounds(101, 122, 245, 20);
		add(txtcep);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 273, 684, 129);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Raz\u00E3oSocial", "Fantasia", "CNPJ", "IR", "Endere\u00E7o", "IdCidade", "CEP", "Email","Telefone","Celular",
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblCelular = new JLabel("Celular :");
		lblCelular.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCelular.setBounds(378, 155, 59, 14);
		add(lblCelular);
		
		txttelefone = new JTextField();
		txttelefone.setColumns(10);
		txttelefone.setBounds(449, 122, 245, 20);
		add(txttelefone);
		
		txtcelular = new JTextField();
		txtcelular.setColumns(10);
		txtcelular.setBounds(449, 152, 245, 20);
		add(txtcelular);
		carregarGrid();

	}
	
	
 
     

    private void carregarGrid(){
	DefaultTableModel dtm = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "RazaoSocial", "CFantasia", "CNPJ", "IR", "Endereco", "Cidade","CEP", "Email", "Telefone","Celular",
			}
		);
	
	
	
	
	PessoaJuridica pessoa = new PessoaJuridica();
	PessoaJuridica[] pessoas = pessoa.consultar();
    if (pessoas != null) {
    	for (int i=0; i<pessoas.length; i++) {
    		dtm.addRow(new Object[] {
    				pessoas[i].getIdPessoaJuridica(),
    				pessoas[i].getRzSocial(),
    				pessoas[i].getFantasia(),
    				pessoas[i].getCnpj(),
    				pessoas[i].getIr(),
    				pessoas[i].getEndereco(),
    				pessoas[i].getIdCidade(),
    				pessoas[i].getCep(),
    				pessoas[i].getEmail(),
    				pessoas[i].getTelefone(),
    				pessoas[i].getCelular() ,
    				
    		});
    	}
      }
         table.setModel(dtm);
    }
    

	private void limparFormulario(){
		txtrz.setText("");
		txtfantasia.setText("");
		txtcnpj.setText("");
		txtir.setText("");
		txtendereco.setText("");
		txtemail.setText("");
		cmbcidade.setSelectedItem(0);
		txtcep.setText("");
		txttelefone.setText("");
		txtcelular.setText("");
		
	}
    
    
	
	public void carregarCmb(){			
		Cidade cidade = new Cidade();
		Cidade[] cidades = cidade.consultar();
	    if (cidades != null) {  
	    	for (int i=0; i<cidades.length; i++) {
	    		cmbcidade.addItem(cidades[i].getIdCidade() + " " + cidades[i].getCidade());
	    	}
	    }
	}
}
