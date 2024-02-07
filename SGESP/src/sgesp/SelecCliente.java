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

public class SelecCliente extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public SelecCliente(JFrame frame) {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 751, 319);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Raz\u00E3o Social", "Fantasia", "CNPJ", "IR", "Endereco", "Cidade"
			}
		));
		scrollPane.setViewportView(table);
		carregarGrid();
		
		JButton btnNewButton = new JButton("Selecionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (table.getSelectedRow() >= 0) {  
					frame.getContentPane().removeAll();
					OrdemProducao selecionar = new OrdemProducao(frame,(int)table.getValueAt(table.getSelectedRow(), 0 ), 0);
					frame.getContentPane().add(selecionar, BorderLayout.CENTER);
					frame.getContentPane().revalidate();					
				} else {   
					JOptionPane.showMessageDialog(frame,    
							"Selecione uma Pessoa!",   
							"Mensagem", JOptionPane.PLAIN_MESSAGE); 
				}
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton.setBounds(364, 341, 123, 40);
		add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.getContentPane().removeAll();
				OrdemProducao op = new OrdemProducao(frame, 0 , 0);
				frame.getContentPane().add(op, BorderLayout.CENTER);
				frame.getContentPane().revalidate();
			}
		});
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCancelar.setBounds(546, 341, 123, 40);
		add(btnCancelar);

	}
	
	private void carregarGrid(){
		DefaultTableModel dtm = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Codigo", "Razao Social", "Fantasia", "CNPJ", "IR", "Endereco", "Cidade"
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
		    				pessoas[i].getIdCidade()
		    		});
		    	}
		    }
		    
		    table.setModel(dtm);
	}
}
