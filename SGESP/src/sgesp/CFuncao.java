package sgesp;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Panel;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CFuncao extends JPanel {
	private JTextField txtfuncao;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public CFuncao(JFrame frame) {
		setLayout(null);
		
		Funcao funcao = new Funcao();
		
		JButton button_1 = new JButton("Salvar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				funcao.setFuncao(txtfuncao.getText());
				funcao.salvar();
				limparFormulario();
				carregarGrid();			
			}
		});
				
		button_1.setIcon(new ImageIcon(CFuncao.class.getResource("/img/2683_32x32.png")));
		button_1.setBounds(10, 115, 120, 41);
		add(button_1);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparFormulario();
			}
		});
		btnLimpar.setIcon(new ImageIcon(CFuncao.class.getResource("/img/cancelar.png")));
		btnLimpar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnLimpar.setBounds(251, 115, 120, 41);
		add(btnLimpar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() >= 0) {  
					frame.getContentPane().removeAll();
					EditarFuncao atualizar = new EditarFuncao(frame, (int)table.getValueAt(table.getSelectedRow(), 0));
					frame.getContentPane().add(atualizar, BorderLayout.CENTER);
					frame.getContentPane().revalidate();
				} else {   
					JOptionPane.showMessageDialog(frame,    
							"Selecione uma Funçao!",   
							"Mensagem", JOptionPane.PLAIN_MESSAGE); 
				}
			}
		});
		btnEditar.setIcon(new ImageIcon(CFuncao.class.getResource("/img/edit.png")));
		btnEditar.setBounds(131, 115, 120, 41);
		add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (table.getSelectedRow() >= 0) {  
					frame.getContentPane().removeAll();
					RemoverFuncao remover = new RemoverFuncao(frame,(int)table.getValueAt(table.getSelectedRow(), 0));
					frame.getContentPane().add(remover, BorderLayout.CENTER);
					frame.getContentPane().revalidate();					
				} else {   
					JOptionPane.showMessageDialog(frame,    
							"Selecione uma Função!",   
							"Mensagem", JOptionPane.PLAIN_MESSAGE); 
				}
			}
		});
		btnExcluir.setIcon(new ImageIcon(CFuncao.class.getResource("/img/Botao-Excluir.png")));
		btnExcluir.setBounds(374, 115, 120, 41);
		add(btnExcluir);
		
		JLabel label_1 = new JLabel("Fun\u00E7\u00E3o :");
		label_1.setFont(new Font("Arial", Font.PLAIN, 12));
		label_1.setBounds(30, 53, 58, 14);
		add(label_1);
		
		txtfuncao = new JTextField();
		txtfuncao.setFont(new Font("Arial", Font.PLAIN, 12));
		txtfuncao.setColumns(10);
		txtfuncao.setBounds(85, 50, 409, 20);
		add(txtfuncao);
		
		JLabel lblCadastroDeFuno = new JLabel("Cadastro de Fun\u00E7\u00E3o");
		lblCadastroDeFuno.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCadastroDeFuno.setBounds(170, 11, 138, 14);
		add(lblCadastroDeFuno);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 175, 484, 114);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Fun\u00E7\u00E3o"
			}
		));
		
		carregarGrid();
		scrollPane.setViewportView(table);
	}

	private void carregarGrid(){
		DefaultTableModel dtm = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Codigo", "Funcao"
				}
			);
			
			Funcao funcao = new Funcao();
			Funcao[] funcoes = funcao.consultar();
		    if (funcoes != null) {
		    	for (int i=0; i<funcoes.length; i++) {
		    		dtm.addRow(new Object[] {
		    				funcoes[i].getIdFuncao(),
		    				funcoes[i].getFuncao()
		    		});
		    	}
		    }
		    
		    table.setModel(dtm);
	}
	
	private void limparFormulario(){
		txtfuncao.setText("");
	}
}
