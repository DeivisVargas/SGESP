package sgesp;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelecionarPessoaJuridica extends JPanel {

	private JTable table;

	/**
	 * Create the panel.
	 */
	public SelecionarPessoaJuridica(JFrame frame) {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 676, 212);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Fantasia",  "Razao social", "CNPJ", "IR", "Endereco",  "Cidade" ,"Cep" ,"Email" 
			}
		));
		scrollPane.setViewportView(table);
		carregarGrid();
		
		JButton button = new JButton("Selecionar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (table.getSelectedRow() >= 0) {  
					frame.getContentPane().removeAll();
					CFornecedor selecionar = new CFornecedor(frame,(int)table.getValueAt(table.getSelectedRow(), 0));
					frame.getContentPane().add(selecionar, BorderLayout.CENTER);
					frame.getContentPane().revalidate();					
				} else {   
					JOptionPane.showMessageDialog(frame,    
							"Selecione uma Pessoa!",   
							"Mensagem", JOptionPane.PLAIN_MESSAGE); 
				}
			}
		});
		button.setFont(new Font("Arial", Font.PLAIN, 12));
		button.setBounds(10, 259, 120, 41);
		add(button);
		
		JButton button_1 = new JButton("Cancelar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.getContentPane().removeAll();
				CFornecedor fonecedor = new CFornecedor	(frame, 0);
				frame.getContentPane().add(fonecedor, BorderLayout.CENTER);
				frame.getContentPane().revalidate();
			}
		});
		button_1.setFont(new Font("Arial", Font.PLAIN, 12));
		button_1.setBounds(152, 259, 120, 41);
		add(button_1);

		
	}
	private void carregarGrid(){
		DefaultTableModel dtm = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Codigo",  "Fantasia", "Razao social" , "CNPJ", "IR", "Endereco",  "Cidade" ,"Cep" ,"Email" , 
				}
			);
			
			PessoaJuridica pessoa = new PessoaJuridica();
			PessoaJuridica[] pessoas = pessoa.consultar();
		    if (pessoas != null) {
		    	for (int i=0; i<pessoas.length; i++) {
		    		dtm.addRow(new Object[] {
		    				pessoas[i].getIdPessoaJuridica(),
		    				pessoas[i].getFantasia(),
		    				pessoas[i].getRzSocial(),
		    				pessoas[i].getCnpj(),
		    				pessoas[i].getIr(),
		    				pessoas[i].getEndereco(),
		    				pessoas[i].getIdCidade(),
		    				pessoas[i].getCep(),		    				
		    				pessoas[i].getEmail()
		    				
		    		});
		    	}
		    }
		    
		    table.setModel(dtm);
	}

}
