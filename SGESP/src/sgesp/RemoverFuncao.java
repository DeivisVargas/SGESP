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

public class RemoverFuncao extends JPanel {

	/**
	 * Create the panel.
	 */
	public RemoverFuncao(JFrame frame, int id) {
		setLayout(null);
		
		Funcao funcao = new Funcao(id);
		
		JLabel lblDesejaRemoverEssa = new JLabel("Deseja remover essa fun\u00E7\u00E3o?");
		lblDesejaRemoverEssa.setFont(new Font("Arial", Font.PLAIN, 14));
		lblDesejaRemoverEssa.setBounds(74, 11, 211, 15);
		add(lblDesejaRemoverEssa);
		
		JLabel lblCodigo = new JLabel("Codigo: " + funcao.getIdFuncao());
		lblCodigo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCodigo.setBounds(29, 53, 179, 15);
		add(lblCodigo);
		
		JLabel lblFuno = new JLabel("Fun\u00E7\u00E3o: " + funcao.getFuncao());
		lblFuno.setFont(new Font("Arial", Font.PLAIN, 12));
		lblFuno.setBounds(29, 79, 179, 15);
		add(lblFuno);
		
		JButton button = new JButton("Sim");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				funcao.remover();
				
				JOptionPane.showMessageDialog(frame, 
						   "Função removida com sucesso!", 
						   "Mensagem", 
						   JOptionPane.PLAIN_MESSAGE);
				
				
				frame.getContentPane().removeAll();
				CFuncao funcao = new CFuncao(frame);
				frame.getContentPane().add(funcao, BorderLayout.CENTER);
				frame.getContentPane().revalidate();
			}
		});
		button.setFont(new Font("Arial", Font.PLAIN, 12));
		button.setBounds(92, 118, 89, 23);
		add(button);
		
		JButton button_1 = new JButton("N\u00E3o");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.getContentPane().removeAll();
				CFuncao funcao = new CFuncao(frame);
				frame.getContentPane().add(funcao, BorderLayout.CENTER);
				frame.getContentPane().revalidate(); 
			}
		});
		button_1.setFont(new Font("Arial", Font.PLAIN, 12));
		button_1.setBounds(196, 118, 89, 23);
		add(button_1);

	}
}
