package sgesp;

import javax.swing.JPanel;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Panel;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;

public class CCidade extends JPanel {
	private JTable table;
	private JTextField txtCidade;
	private JComboBox cmbEstado;

	/**
	 * Create the panel.
	 */
	public CCidade(JFrame frame) {		
		setLayout(null);
		
		Cidade cidade = new Cidade();
		
		cmbEstado = new JComboBox();
		cmbEstado.setBounds(66, 68, 336, 20);
		add(cmbEstado);
		
		carregarCmb(); //carrega cidades no combo
				
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//quebrar combo para armazenar o id do estado no banco
				String vet =  (String) cmbEstado.getSelectedItem();  
				String[] estado = vet.split(" ");
				int idEstado = Integer.parseInt(estado[0]);	
				
				cidade.setCidade(txtCidade.getText());
		     	cidade.setIdUf(idEstado); 
				cidade.salvar();
				carregarGrid(); //carregar tabela
				limparFormulario();
			}
		});
		btnSalvar.setIcon(new ImageIcon(CCidade.class.getResource("/img/2683_32x32.png")));
		btnSalvar.setBounds(10, 123, 120, 41);
		add(btnSalvar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (table.getSelectedRow() >= 0) {  
					frame.getContentPane().removeAll();
					EditarCidade atualizar = new EditarCidade(frame, (int)table.getValueAt(table.getSelectedRow(), 0));
					frame.getContentPane().add(atualizar, BorderLayout.CENTER);
					frame.getContentPane().revalidate();
				} else {   
					JOptionPane.showMessageDialog(frame,  
							"Selecione uma Cidade!",   
							"Mensagem", JOptionPane.PLAIN_MESSAGE); 
				}
			}
		});
		btnEditar.setIcon(new ImageIcon(CCidade.class.getResource("/img/edit.png")));
		btnEditar.setBounds(162, 123, 120, 41);
		add(btnEditar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparFormulario();
			}
		});
		btnLimpar.setIcon(new ImageIcon(CCidade.class.getResource("/img/cancelar.png")));
		btnLimpar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnLimpar.setBounds(317, 123, 120, 41);
		add(btnLimpar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() >= 0) {  
					frame.getContentPane().removeAll();
					Remover remover = new Remover(frame,(int)table.getValueAt(table.getSelectedRow(), 0));
					frame.getContentPane().add(remover, BorderLayout.CENTER);
					frame.getContentPane().revalidate();					
				} else {   
					JOptionPane.showMessageDialog(frame,    
							"Selecione uma Cidade!",   
							"Mensagem", JOptionPane.PLAIN_MESSAGE); 
				}
			}
		}

		);
		btnExcluir.setIcon(new ImageIcon(CCidade.class.getResource("/img/Botao-Excluir.png")));
		btnExcluir.setBounds(468, 123, 120, 41);
		add(btnExcluir);
		
		JLabel lblNewLabel = new JLabel("Cadastro de Cidades");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel.setBounds(225, 6, 145, 14);
		add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 181, 588, 119);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Cidade", "Estado"
			}
		));
		
		carregarGrid();//carregar tabela
		
		scrollPane.setViewportView(table);
		
		JLabel label_1 = new JLabel("Estado :");
		label_1.setFont(new Font("Arial", Font.PLAIN, 12));
		label_1.setBounds(10, 70, 46, 14);
		add(label_1);
		
		
		JLabel label_2 = new JLabel("Cidade :");
		label_2.setFont(new Font("Arial", Font.PLAIN, 12));
		label_2.setBounds(10, 34, 46, 14);
		add(label_2);
		
		txtCidade = new JTextField();
		txtCidade.setFont(new Font("Arial", Font.PLAIN, 12));
		txtCidade.setColumns(10);
		txtCidade.setBounds(66, 31, 514, 20);
		add(txtCidade);

	}

	//busca os campos da tabela no banco e mostra
	private void carregarGrid(){
		DefaultTableModel dtm = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Codigo", "Cidade", "Estado"
				}
			);
			
			Cidade cidade = new Cidade();
		    Cidade[] cidades = cidade.consultar();
		    if (cidades != null) {
		    	for (int i=0; i<cidades.length; i++) {
		    		dtm.addRow(new Object[] {
		    				cidades[i].getIdCidade(),
		    				cidades[i].getCidade(),
		    				cidades[i].getIdUf()
		    		});
		    	}
		    }
		    
		    table.setModel(dtm);
	}
	
	private void limparFormulario(){
		txtCidade.setText("");
		cmbEstado.setSelectedItem(1);
	}
	
	//carregar estados cadastrados no banco no combo selecionar estado
	public void carregarCmb(){			
			Estado estado = new Estado();
			Estado[] estados = estado.consultar();
		    if (estados != null) {  
		    	for (int i=0; i<estados.length; i++) { // enquanto i for menor que a qtd de estados
		    		cmbEstado.addItem(estados[i].getIdEstado() + " " + estados[i].getEstado());
		    	}
		    }
	}
}
