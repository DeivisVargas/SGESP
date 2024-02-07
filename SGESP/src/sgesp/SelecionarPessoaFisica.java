package sgesp;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelecionarPessoaFisica extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public SelecionarPessoaFisica(JFrame frame) {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 655, 261);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Nome", "CPF", "RG", "Endereco", "Email", "Cep", "Cidade"
			}
		));
		scrollPane.setViewportView(table);
		
		carregarGrid();
		
		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (table.getSelectedRow() >= 0) {  
					frame.getContentPane().removeAll();
					CFuncionario selecionar = new CFuncionario(frame,(int)table.getValueAt(table.getSelectedRow(), 0));
					frame.getContentPane().add(selecionar, BorderLayout.CENTER);
					frame.getContentPane().revalidate();					
				} else {   
					JOptionPane.showMessageDialog(frame,    
							"Selecione uma Pessoa!",   
							"Mensagem", JOptionPane.PLAIN_MESSAGE); 
				}
			}
		});
		btnSelecionar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnSelecionar.setBounds(403, 283, 120, 41);
		add(btnSelecionar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				
				
				frame.getContentPane().removeAll();
				CFuncionario funcionario = new CFuncionario	(frame, 0);
				frame.getContentPane().add(funcionario, BorderLayout.CENTER);
				frame.getContentPane().revalidate(); 
			}
		});
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCancelar.setBounds(545, 283, 120, 41);
		add(btnCancelar);

	}
	
	private void carregarGrid(){
		DefaultTableModel dtm = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Codigo", "Nome", "CPF", "RG", "Endereco", "Email", "Cep", "Cidade"
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
		    				pessoas[i].getEmail()
		    		});
		    	}
		    }
		    
		    table.setModel(dtm);
	}
}
	
