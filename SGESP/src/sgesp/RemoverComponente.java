package sgesp;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RemoverComponente extends JPanel {

	/**
	 * Create the panel.
	 */
	public RemoverComponente(JFrame frame, int id) {
		setLayout(null);
		
		Componentes componente = new Componentes(id);
		
		 
		
		JLabel lblDesejaRemoverEsse = new JLabel("Deseja remover esse componente?");
		lblDesejaRemoverEsse.setFont(new Font("Arial", Font.PLAIN, 14));
		lblDesejaRemoverEsse.setBounds(78, 11, 267, 15);
		add(lblDesejaRemoverEsse);
		
		JLabel label_1 = new JLabel("Codigo: " + componente.getIdComponente());
		label_1.setFont(new Font("Arial", Font.PLAIN, 12));
		label_1.setBounds(33, 53, 179, 15);
		add(label_1);
		
		JLabel lblComponente = new JLabel("Descri\u00E7\u00E3o: " + componente.getDescricao());
		lblComponente.setFont(new Font("Arial", Font.PLAIN, 12));
		lblComponente.setBounds(33, 79, 341, 15);
		add(lblComponente);
		
		JLabel lblValorDeCompra = new JLabel("Valor de Compra: " + componente.getVlrCompra());
		lblValorDeCompra.setFont(new Font("Arial", Font.PLAIN, 12));
		lblValorDeCompra.setBounds(33, 105, 179, 15);
		add(lblValorDeCompra);
		
		JLabel lblEstoque = new JLabel("Estoque: "  + componente.getEstoque());
		lblEstoque.setFont(new Font("Arial", Font.PLAIN, 12));
		lblEstoque.setBounds(33, 133, 179, 15);
		add(lblEstoque);
		
		JLabel lblEstoqueMinmo = new JLabel("Estoque Min\u00EDmo: " + componente.getEstoqueMin());
		lblEstoqueMinmo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblEstoqueMinmo.setBounds(33, 162, 179, 15);
		add(lblEstoqueMinmo);
		
		JButton button = new JButton("Sim");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				componente.remover();
				
				JOptionPane.showMessageDialog(frame, 
						   "Componente removido com sucesso!", 
						   "Mensagem", 
						   JOptionPane.PLAIN_MESSAGE);
				
				
				frame.getContentPane().removeAll();
				CComponentes componente = new CComponentes(frame);
				frame.getContentPane().add(componente, BorderLayout.CENTER);
				frame.getContentPane().revalidate(); 
			}
		});
		button.setFont(new Font("Arial", Font.PLAIN, 12));
		button.setBounds(166, 236, 89, 23);
		add(button);
		
		JButton button_1 = new JButton("N\u00E3o");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				CComponentes componente = new CComponentes(frame);
				frame.getContentPane().add(componente, BorderLayout.CENTER);
				frame.getContentPane().revalidate(); 
			}
		});
		button_1.setFont(new Font("Arial", Font.PLAIN, 12));
		button_1.setBounds(270, 236, 89, 23);
		add(button_1);
		
		

	}
}
