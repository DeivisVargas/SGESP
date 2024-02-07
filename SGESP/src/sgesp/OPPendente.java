package sgesp;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OPPendente extends JPanel {
	private JTable table;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public OPPendente(JFrame frame, int id) {
		setLayout(null);
		
		OProducao op = new OProducao(id);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 66, 592, 338);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Cliente", "Produto", "Data Solicita\u00E7\u00E3o"
			}
		));
		scrollPane.setViewportView(table);
		
		carregarGrid();
		
		JLabel lblNewLabel = new JLabel("Ordem Produ\u00E7\u00E3o:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel.setBounds(53, 36, 102, 14);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 12));
		textField.setBounds(162, 33, 293, 20);
		add(textField);
		textField.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnBuscar.setBounds(465, 32, 89, 23);
		add(btnBuscar);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() >= 0) {  
					frame.getContentPane().removeAll();
					FinalizarVender removerEstado = new FinalizarVender(frame,(int)table.getValueAt(table.getSelectedRow(), 0));
					frame.getContentPane().add(removerEstado, BorderLayout.CENTER);
					frame.getContentPane().revalidate();					
				} else {   
					JOptionPane.showMessageDialog(frame,    
							"Selecione uma Ordem de Produção!",   
							"Mensagem", JOptionPane.PLAIN_MESSAGE); 
				}
			}
		});
		btnFinalizar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnFinalizar.setBounds(20, 415, 89, 23);
		add(btnFinalizar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCancelar.setBounds(415, 415, 89, 23);
		add(btnCancelar);

	}
	
	private void carregarGrid(){
		DefaultTableModel dtm = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Codigo", "Cliente", "Produto", "Data Solicitacao", "Quantidade"
				}
			);
			
			OProducao op = new OProducao();
			OProducao[] ops = op.consultar();
		    if (ops != null) {
		    	for (int i=0; i<ops.length; i++) {
		    		dtm.addRow(new Object[] {
		    				ops[i].getIdOrdemProducao(),
		    				ops[i].getIdCliente(),
		    				ops[i].getIdProduto(),
		    				ops[i].getDataSolicitacao(),
		    				ops[i].getQtd()
		    		});
		    	}
		    }
		    
		    table.setModel(dtm);
	}
	
}
