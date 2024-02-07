package sgesp;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Panel;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CFornecedor extends JPanel {
	private JTextField txtcomp;
	private JLabel lblcodigo;
	private JLabel lbldescricao;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public CFornecedor(JFrame frame, int id ) {
		setLayout(null);
		
		PessoaJuridica pessoa = new  PessoaJuridica(id) ;
		Fornecedor fornecedor = new Fornecedor();
		
	    lblcodigo = new JLabel("Pessoa :" + pessoa.getIdPessoaJuridica());
		lblcodigo.setBounds(227, 57, 130, 14);
		add(lblcodigo);
		
	    lbldescricao = new JLabel("Descri\u00E7\u00E3o :" + pessoa.getFantasia());
		lbldescricao.setBounds(367, 57, 255, 14);
		add(lbldescricao);
		
		JButton button_1 = new JButton("Salvar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String vet =  lblcodigo.getText();  
				String[] pess = vet.split(":");
				int idPessoa = Integer.parseInt(pess[1]);
				fornecedor.setIdPessoaJuridica(idPessoa);
				fornecedor.setTipomaterial(txtcomp.getText());
				fornecedor.salvar();
				carregarGrid();
				limpar();
		
				
	
				
				
			}
		});
		button_1.setIcon(new ImageIcon(CFornecedor.class.getResource("/img/2683_32x32.png")));
		button_1.setBounds(10, 259, 120, 41);
		add(button_1);
		
		JButton button_2 = new JButton("Editar");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
                    if (table.getSelectedRow() >= 0) {  
					
					frame.getContentPane().removeAll();
					EditarFornecedor atualizar = new EditarFornecedor(frame, (int)table.getValueAt(table.getSelectedRow(), 0));
					frame.getContentPane().add(atualizar, BorderLayout.CENTER);
					frame.getContentPane().revalidate();
				} else {   
					JOptionPane.showMessageDialog(frame,    
							"Selecione um Fornecedor!",   
							"Mensagem", JOptionPane.PLAIN_MESSAGE); 
				}	
				
				
				
				
				
			}
		});
		button_2.setIcon(new ImageIcon(CFornecedor.class.getResource("/img/edit.png")));
		button_2.setBounds(151, 259, 120, 41);
		add(button_2);
		
		JButton button_3 = new JButton("Cancelar");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				limpar();
			}
		});
		button_3.setIcon(new ImageIcon(CFornecedor.class.getResource("/img/cancelar.png")));
		button_3.setFont(new Font("Arial", Font.PLAIN, 12));
		button_3.setBounds(287, 259, 120, 41);
		add(button_3);
		
		JButton button_4 = new JButton("Excluir");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (table.getSelectedRow() >= 0) {  
					frame.getContentPane().removeAll();
					RemoverFornecedor remover = new RemoverFornecedor(frame,(int)table.getValueAt(table.getSelectedRow(), 0));
					frame.getContentPane().add(remover, BorderLayout.CENTER);
					frame.getContentPane().revalidate();					
				} else {   
					JOptionPane.showMessageDialog(frame,    
							"Selecione um Fornecedor!",   
							"Mensagem", JOptionPane.PLAIN_MESSAGE); 
				}
				
				
				
			}
		});
		button_4.setIcon(new ImageIcon(CFornecedor.class.getResource("/img/Botao-Excluir.png")));
		button_4.setBounds(417, 259, 120, 41);
		add(button_4);
		
		JLabel lblCadastroDeFonecedores = new JLabel("Cadastro de Fonecedores ");
		lblCadastroDeFonecedores.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCadastroDeFonecedores.setBounds(265, 11, 270, 27);
		add(lblCadastroDeFonecedores);
		
		JButton btnSelecioneAPessoa = new JButton("Selecione a pessoa juridica ");
		btnSelecioneAPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame.getContentPane().removeAll();
				SelecionarPessoaJuridica pessoa = new SelecionarPessoaJuridica(frame);
				frame.getContentPane().add(pessoa, BorderLayout.CENTER);
				frame.getContentPane().revalidate();
			}
		});
		btnSelecioneAPessoa.setBounds(10, 53, 194, 23);
		add(btnSelecioneAPessoa);
		
		
		
		JLabel lblComponentesFornecidos = new JLabel("Componentes fornecidos :");
		lblComponentesFornecidos.setBounds(10, 109, 156, 14);
		add(lblComponentesFornecidos);
		
		txtcomp = new JTextField();
		txtcomp.setBounds(176, 106, 270, 20);
		add(txtcomp);
		txtcomp.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 339, 748, 147);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "C\u00F3digo Pessoa", "Componentes fornecidos ", "Nome" , "Telefone"
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
					"Codigo", "Codigo Pessoa", "Componentes fornecido", "Nome", "Telefone"
				}
			);
	
	Fornecedor fornecedor = new Fornecedor();
	Fornecedor[] funcs = fornecedor.consultar() ;
    if (funcs != null) {
    	for (int i=0; i<funcs.length; i++) {
    		dtm.addRow(new Object[] {
    				funcs[i].getIdFornecedor(),
    				funcs[i].getIdPessoaJuridica(),
    				funcs[i].getTipomaterial(),
    				funcs[i].getNome(),
    				funcs[i].getTelefone(),
    				 
    		});
    	}
    }
	

    table.setModel(dtm);
	}
	
	public void limpar (){
		txtcomp.setText("");
		lblcodigo.setText("Pessoa :");
		lbldescricao.setText("Descri\u00E7\u00E3o :");
		
	
	}
  
}

