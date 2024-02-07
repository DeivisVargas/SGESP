package sgesp;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelecProduto extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public SelecProduto(JFrame frame ,int idcliente) {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(10, 35, 687, 378);
		add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 655, 261);
		panel.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Descricao", "Valor de Venda"
			}
		));
		scrollPane.setViewportView(table);
		carregarGrid();
		
		JButton button = new JButton("Selecionar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (table.getSelectedRow() >= 0) {  
					frame.getContentPane().removeAll();
					OrdemProducao selecionar = new OrdemProducao(frame,idcliente, (int)table.getValueAt(table.getSelectedRow(), 0));
					frame.getContentPane().add(selecionar, BorderLayout.CENTER);
					frame.getContentPane().revalidate();					
				} else {   
					JOptionPane.showMessageDialog(frame,    
							"Selecione um Produto!",   
							"Mensagem", JOptionPane.PLAIN_MESSAGE); 
				}
				
				
				
				
			}
		});
		button.setFont(new Font("Arial", Font.PLAIN, 12));
		button.setBounds(403, 293, 120, 41);
		panel.add(button);
		
		JButton button_1 = new JButton("Cancelar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.getContentPane().removeAll();
				OrdemProducao op = new OrdemProducao(frame, 0, 0);
				frame.getContentPane().add(op, BorderLayout.CENTER);
				frame.getContentPane().revalidate();
				
			}
		});
		button_1.setFont(new Font("Arial", Font.PLAIN, 12));
		button_1.setBounds(545, 293, 120, 41);
		panel.add(button_1);

	}
	
	private void carregarGrid(){
		DefaultTableModel dtm = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Codigo", "Produto", "Valor de Venda"
				}
			);
		
		
		
		Produto produto = new Produto();
		Produto[] produtos = produto.consultar();
		if(produtos != null){
			for(int i=0; i<produtos.length; i++){
				dtm.addRow(new Object[]{
						produtos[i].getIdProduto(),
						produtos[i].getDescricao(),
						produtos[i].getVlrVenda()
				});
			}
		}
		
		table.setModel(dtm);
	}
}


