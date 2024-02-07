package sgesp;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Panel;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CComponentes extends JPanel {
	private JTextField txtDescricao;
	private JTextField txtEstoque;
	private JTextField txtVlrCompra;
	private JTable table;
	private JTextField txtEstoqueMin;

	/**
	 * Create the panel.
	 */
	public CComponentes(JFrame frame) {
		setLayout(null);
		
		Componentes componente = new Componentes();
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				componente.setDescricao(txtDescricao.getText());
				componente.setEstoque(Integer.parseInt(txtEstoque.getText()));
				componente.setEstoqueMin(Integer.parseInt(txtEstoqueMin.getText()));
				componente.setVlrCompra(Float.parseFloat(txtVlrCompra.getText()));
				componente.salvar();
				carregarGrid();
				limparFormulario();
			}
		});
		btnSalvar.setIcon(new ImageIcon(CComponentes.class.getResource("/img/2683_32x32.png")));
		btnSalvar.setBounds(41, 133, 120, 41);
		add(btnSalvar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (table.getSelectedRow() >= 0) {  
					
					frame.getContentPane().removeAll();
					EditarComponente atualizar = new EditarComponente(frame, (int)table.getValueAt(table.getSelectedRow(), 0));
					frame.getContentPane().add(atualizar, BorderLayout.CENTER);
					frame.getContentPane().revalidate();
				} else {   
					JOptionPane.showMessageDialog(frame,    
							"Selecione um Estado!",   
							"Mensagem", JOptionPane.PLAIN_MESSAGE); 
				}	
			}
		});
		btnEditar.setIcon(new ImageIcon(CComponentes.class.getResource("/img/edit.png")));
		btnEditar.setBounds(189, 133, 120, 41);
		add(btnEditar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparFormulario();
			}
		});
		btnLimpar.setIcon(new ImageIcon(CComponentes.class.getResource("/img/cancelar.png")));
		btnLimpar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnLimpar.setBounds(336, 133, 120, 41);
		add(btnLimpar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() >= 0) {  
					frame.getContentPane().removeAll();
					RemoverComponente remover = new RemoverComponente(frame,(int)table.getValueAt(table.getSelectedRow(), 0));
					frame.getContentPane().add(remover, BorderLayout.CENTER);
					frame.getContentPane().revalidate();					
				} else {   
					JOptionPane.showMessageDialog(frame,    
							"Selecione um Componente!",   
							"Mensagem", JOptionPane.PLAIN_MESSAGE); 
				}
			}
		});
		btnExcluir.setIcon(new ImageIcon(CComponentes.class.getResource("/img/Botao-Excluir.png")));
		btnExcluir.setBounds(476, 133, 120, 41);
		add(btnExcluir);
		
		JLabel label_1 = new JLabel("Descri\u00E7\u00E3o:");
		label_1.setFont(new Font("Arial", Font.PLAIN, 12));
		label_1.setBounds(10, 54, 59, 14);
		add(label_1);
		
		txtDescricao = new JTextField();
		txtDescricao.setFont(new Font("Arial", Font.PLAIN, 12));
		txtDescricao.setColumns(10);
		txtDescricao.setBounds(85, 51, 539, 20);
		add(txtDescricao);
		
		JLabel label_3 = new JLabel("Estoque:");
		label_3.setFont(new Font("Arial", Font.PLAIN, 12));
		label_3.setBounds(249, 91, 49, 14);
		add(label_3);
		
		txtEstoque = new JTextField();
		txtEstoque.setFont(new Font("Arial", Font.PLAIN, 12));
		txtEstoque.setColumns(10);
		txtEstoque.setBounds(300, 88, 107, 20);
		add(txtEstoque);
		
		JLabel lblValorUnitrio = new JLabel("Valor Unit\u00E1rio: ");
		lblValorUnitrio.setFont(new Font("Arial", Font.PLAIN, 12));
		lblValorUnitrio.setBounds(10, 94, 93, 14);
		add(lblValorUnitrio);
		
		JLabel label_5 = new JLabel("Estoque m\u00EDnimo:");
		label_5.setFont(new Font("Arial", Font.PLAIN, 12));
		label_5.setBounds(417, 93, 94, 14);
		add(label_5);
		
		txtVlrCompra = new JTextField();
		txtVlrCompra.setFont(new Font("Arial", Font.PLAIN, 12));
		txtVlrCompra.setColumns(10);
		txtVlrCompra.setBounds(95, 88, 126, 20);
		add(txtVlrCompra);
		
		JLabel lblCadastroDeComponentes = new JLabel("Cadastro de Componentes");
		lblCadastroDeComponentes.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCadastroDeComponentes.setBounds(216, 11, 191, 14);
		add(lblCadastroDeComponentes);
		
		// mostra a tabela de consulta
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 195, 764, 272);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Descri\u00E7\u00E3o", "Valor de Compra", "Estoque", "Estoque M\u00EDnimo"
			}
		));
		scrollPane.setViewportView(table);
		
		carregarGrid();
		
		txtEstoqueMin = new JTextField();
		txtEstoqueMin.setFont(new Font("Arial", Font.PLAIN, 12));
		txtEstoqueMin.setColumns(10);
		txtEstoqueMin.setBounds(517, 91, 107, 20);
		add(txtEstoqueMin);

	}
	
	//atualiza a tabela no ato do cadastro 
	
	private void carregarGrid(){
		DefaultTableModel dtm = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Codigo", "Descricao", "Valor de Compra", "Estoque", "Estoque Minimo"
				}
			);
			
			Componentes componente = new Componentes();
			Componentes[] componentes = componente.consultar();
		    if (componentes != null) {
		    	for (int i=0; i<componentes.length; i++) {
		    		dtm.addRow(new Object[] {
		    				componentes[i].getIdComponente(),
		    				componentes[i].getDescricao(),
		    				componentes[i].getVlrCompra(),
		    				componentes[i].getEstoque(),
		    				componentes[i].getEstoqueMin()
		    		});
		    	}
		    }
		    
		    table.setModel(dtm);
	}
	
	private void limparFormulario(){
		txtDescricao.setText("");
		txtEstoque.setText("");
		txtEstoqueMin.setText("");
		txtVlrCompra.setText("");
	}
}
