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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CEstado extends JPanel {
	private JTextField txtEstado;
	private JTextField txtUf;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public CEstado(JFrame frame) {
		setLayout(null);
		
		Estado estado = new Estado();
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				estado.setEstado(txtEstado.getText());
				estado.setUf(txtUf.getText());
				estado.salvar();
				carregarGrid();
				limparFormulario();
			}
		});
		btnSalvar.setIcon(new ImageIcon(CEstado.class.getResource("/img/2683_32x32.png")));
		btnSalvar.setBounds(10, 80, 120, 41);
		add(btnSalvar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() >= 0) {  
					frame.getContentPane().removeAll();
					EditarEstado atualizar = new EditarEstado(frame, (int)table.getValueAt(table.getSelectedRow(), 0));
					frame.getContentPane().add(atualizar, BorderLayout.CENTER);
					frame.getContentPane().revalidate();
				} else {   
					JOptionPane.showMessageDialog(frame,    
							"Selecione um Estado!",   
							"Mensagem", JOptionPane.PLAIN_MESSAGE); 
				}
			}
		});
		btnEditar.setIcon(new ImageIcon(CEstado.class.getResource("/img/edit.png")));
		btnEditar.setBounds(168, 80, 120, 41);
		add(btnEditar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparFormulario();
			}
		});
		btnLimpar.setIcon(new ImageIcon(CEstado.class.getResource("/img/cancelar.png")));
		btnLimpar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnLimpar.setBounds(317, 80, 120, 41);
		add(btnLimpar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() >= 0) {  
					frame.getContentPane().removeAll();
					RemoverEstado removerEstado = new RemoverEstado(frame,(int)table.getValueAt(table.getSelectedRow(), 0));
					frame.getContentPane().add(removerEstado, BorderLayout.CENTER);
					frame.getContentPane().revalidate();					
				} else {   
					JOptionPane.showMessageDialog(frame,    
							"Selecione um Estado!",   
							"Mensagem", JOptionPane.PLAIN_MESSAGE); 
				}
			}
		});
		btnExcluir.setIcon(new ImageIcon(CEstado.class.getResource("/img/Botao-Excluir.png")));
		btnExcluir.setBounds(476, 80, 120, 41);
		add(btnExcluir);
		
		JLabel label_1 = new JLabel("Estado :");
		label_1.setFont(new Font("Arial", Font.PLAIN, 12));
		label_1.setBounds(10, 38, 45, 15);
		add(label_1);
		
		txtEstado = new JTextField();
		txtEstado.setFont(new Font("Arial", Font.PLAIN, 12));
		txtEstado.setColumns(10);
		txtEstado.setBounds(66, 35, 358, 21);
		add(txtEstado);
		
		JLabel label_2 = new JLabel("UF:");
		label_2.setFont(new Font("Arial", Font.PLAIN, 12));
		label_2.setBounds(472, 38, 19, 15);
		add(label_2);
		
		txtUf = new JTextField();
		txtUf.setFont(new Font("Arial", Font.PLAIN, 12));
		txtUf.setColumns(10);
		txtUf.setBounds(501, 32, 60, 21);
		add(txtUf);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 132, 596, 125);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Estado", "UF"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblCadastroDeEstados = new JLabel("Cadastro de Estados");
		lblCadastroDeEstados.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCadastroDeEstados.setBounds(192, 11, 151, 14);
		add(lblCadastroDeEstados);
		
		carregarGrid();

	}
	
	private void carregarGrid(){
		DefaultTableModel dtm = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Codigo", "Estado", "Uf"
				}
			);
			Estado estado = new Estado();
		    Estado[] estados = estado.consultar();
		    if (estados != null) {
		    	for (int i=0; i<estados.length; i++) {
		    		dtm.addRow(new Object[] {
		    				estados[i].getIdEstado(),
		    				estados[i].getEstado(),
		    				estados[i].getUf()
		    		});
		    	}
		    }
		    
		    table.setModel(dtm);
	}
	
	private void limparFormulario(){
		txtEstado.setText("");
		txtUf.setText("");
	}
}
