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

public class RemoverEstado extends JPanel {

	/**
	 * Create the panel.
	 */
	public RemoverEstado(JFrame frame, int id) {
		setLayout(null);
		
		Estado estado = new Estado(id);
		
		JLabel lblDesejaRemoverEsse = new JLabel("Deseja remover esse estado?");
		lblDesejaRemoverEsse.setFont(new Font("Arial", Font.PLAIN, 14));
		lblDesejaRemoverEsse.setBounds(85, 11, 211, 15);
		add(lblDesejaRemoverEsse);
		
		JLabel lblCodigo = new JLabel("Codigo: " + estado.getIdEstado());
		lblCodigo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCodigo.setBounds(40, 53, 179, 15);
		add(lblCodigo);
		
		JLabel lblEstado = new JLabel("Estado: " + estado.getEstado());
		lblEstado.setFont(new Font("Arial", Font.PLAIN, 12));
		lblEstado.setBounds(40, 79, 179, 15);
		add(lblEstado);
		
		JLabel lblUf = new JLabel("Uf: " + estado.getUf());
		lblUf.setFont(new Font("Arial", Font.PLAIN, 12));
		lblUf.setBounds(40, 105, 179, 15);
		add(lblUf);
		
		JButton button = new JButton("Sim");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estado.remover();
				
				JOptionPane.showMessageDialog(frame, 
						   "Estado removido com sucesso!", 
						   "Mensagem", 
						   JOptionPane.PLAIN_MESSAGE);
				
				
				frame.getContentPane().removeAll();
				CEstado estado = new CEstado(frame);
				frame.getContentPane().add(estado, BorderLayout.CENTER);
				frame.getContentPane().revalidate(); 
			}
		});
		button.setFont(new Font("Arial", Font.PLAIN, 12));
		button.setBounds(103, 162, 89, 23);
		add(button);
		
		JButton button_1 = new JButton("N\u00E3o");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				CEstado estado = new CEstado(frame);
				frame.getContentPane().add(estado, BorderLayout.CENTER);
				frame.getContentPane().revalidate(); 
			}
		});
		button_1.setFont(new Font("Arial", Font.PLAIN, 12));
		button_1.setBounds(207, 162, 89, 23);
		add(button_1);

	}
}
