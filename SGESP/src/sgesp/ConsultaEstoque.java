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
import javax.swing.JLabel;

public class ConsultaEstoque extends JPanel {
	private JTable table;
	private JTable table_1;
	private JTable tblcompraaver;

	/**
	 * Create the panel.
	 */
	public ConsultaEstoque(JFrame frame) {
		setLayout(null);
		
		CompraCab compras = new  CompraCab () ;
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 43, 616, 269);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Descricao", "Valor de Compra", "Estoque", "Estoque Minimo"
			}
		));
		scrollPane.setViewportView(table);
		
		carregarGrid();
		
		JButton btnGerarOrdemDe = new JButton("Gerar ordem de compra ");
		btnGerarOrdemDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				if (table.getSelectedRow() >= 0) {  
					
					frame.getContentPane().removeAll();
					Compra atualizar = new Compra(frame, (int)table.getValueAt(table.getSelectedRow(), 0));
					frame.getContentPane().add(atualizar, BorderLayout.CENTER);
					frame.getContentPane().revalidate();
				} else {   
					JOptionPane.showMessageDialog(frame,    
							"Selecione um componente !",   
							"Mensagem", JOptionPane.PLAIN_MESSAGE); 
				}	
				
				
			}
		});
		btnGerarOrdemDe.setFont(new Font("Arial", Font.PLAIN, 12));
		btnGerarOrdemDe.setBounds(10, 323, 210, 38);
		add(btnGerarOrdemDe);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 436, 616, 154);
		add(scrollPane_1);
		
		tblcompraaver = new JTable();
		tblcompraaver.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo ", "Descri\u00E7\u00E3o","Data", "valor da ultima compra  ", "Quantidade"
			}
		));
		scrollPane_1.setViewportView(tblcompraaver);
		
		 carregarcompras();
		
		JLabel lblOrdensDeCompra = new JLabel("Ordens de compra ");
		lblOrdensDeCompra.setFont(new Font("Arial", Font.PLAIN, 14));
		lblOrdensDeCompra.setBounds(234, 397, 165, 28);
		add(lblOrdensDeCompra);
		
		JLabel lblComponentesComEstoque = new JLabel("Componentes com estoque  baixo ");
		lblComponentesComEstoque.setFont(new Font("Arial", Font.PLAIN, 14));
		lblComponentesComEstoque.setBounds(198, 0, 252, 28);
		add(lblComponentesComEstoque);
		
		
		
		 

	}
	
	private void carregarGrid(){
		DefaultTableModel dtm = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Codigo", "Descricao",  "Valor de Compra", "Estoque", "Estoque Minimo"
				}
			);
			
			Componentes componente = new Componentes();
			Componentes[] comp = componente.consultarEstoque();
		    if (comp != null) {
		    	for (int i=0; i<comp.length; i++) {
		    		dtm.addRow(new Object[] {
		    				comp[i].getIdComponente(),
		    				comp[i].getDescricao(),
		    				comp[i].getVlrCompra(),
		    				comp[i].getEstoque(),
		    				comp[i].getEstoqueMin()
		    		});
		    	}
		    }
		    
		    table.setModel(dtm);
		    
		    
		
		    
	}
	private void carregarcompras(){
		DefaultTableModel dtm = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Codigo", "Descricao", "Data",  "Valor da ultima compra", "Quantidade"
				}
			);
	
    CompraCab comprasss = new  CompraCab () ;
    CompraCab[] com = comprasss.consultar() ;
    
    if (com != null) {
    	for (int i=0; i<com.length; i++) {
    		dtm.addRow(new Object[] {
    				com[i].getIdComponente2(),
    				com[i].getDescricao2(),
    				com[i].getData2() ,
    				com[i].getVlrultima2() ,
    				com[i].getQtd2()
    		});
    	}
    }
    
    tblcompraaver.setModel(dtm);
   
   
	}
}
