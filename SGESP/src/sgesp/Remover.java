package sgesp;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Remover extends JPanel {

	/**
	 * Create the panel.
	 */
	public Remover(JFrame frame, int id) {
		
		Cidade cidade = new Cidade(id);
		
		setLayout(null);
		
		JLabel label = new JLabel("Deseja remover essa pessoa?");
		label.setFont(new Font("Arial", Font.PLAIN, 12));
		label.setBounds(135, 11, 179, 15);
		add(label);
		
		JLabel lblCodigo = new JLabel("Codigo: " + cidade.getIdCidade());
		lblCodigo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCodigo.setBounds(90, 53, 179, 15);
		add(lblCodigo);
		
		JLabel lblCidade = new JLabel("Cidade: " + cidade.getCidade());
		lblCidade.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCidade.setBounds(90, 79, 179, 15);
		add(lblCidade);
		
		JLabel lblEstado = new JLabel("Estado: " + cidade.getIdUf());
		lblEstado.setFont(new Font("Arial", Font.PLAIN, 12));
		lblEstado.setBounds(90, 119, 179, 15);
		add(lblEstado);
		
		JButton button = new JButton("Sim");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cidade.remover();
				
				JOptionPane.showMessageDialog(frame, 
						   "Cidade removida com sucesso!", 
						   "Mensagem", 
						   JOptionPane.PLAIN_MESSAGE);
				
				
				frame.getContentPane().removeAll();
				CCidade cidade = new CCidade(frame);
				frame.getContentPane().add(cidade, BorderLayout.CENTER);
				frame.getContentPane().revalidate(); 
								
			}
		});
		button.setFont(new Font("Arial", Font.PLAIN, 12));
		button.setBounds(153, 162, 89, 23);
		add(button);
		
		JButton button_1 = new JButton("N\u00E3o");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				CCidade cidade = new CCidade(frame);
				frame.getContentPane().add(cidade, BorderLayout.CENTER);
				frame.getContentPane().revalidate(); 
			}
		});
		button_1.setFont(new Font("Arial", Font.PLAIN, 12));
		button_1.setBounds(257, 162, 89, 23);
		add(button_1);

	}
}
