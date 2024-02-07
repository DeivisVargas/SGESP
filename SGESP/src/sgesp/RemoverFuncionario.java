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

public class RemoverFuncionario extends JPanel {

	/**
	 * Create the panel.
	 */
	public RemoverFuncionario(JFrame frame, int id) {
		setLayout(null);
		
		Funcionario funcionario = new Funcionario(id);
		
		JLabel label = new JLabel("Código :" + funcionario.getIdFuncionario());
		label.setFont(new Font("Arial", Font.PLAIN, 14));
		label.setBounds(10, 49, 272, 14);
		add(label);
		
		JLabel label_1 = new JLabel("Pessoa F\u00EDsica "+ funcionario.getIdPessoaFisica());
		label_1.setFont(new Font("Arial", Font.PLAIN, 14));
		label_1.setBounds(10, 74, 272, 14);
		add(label_1);
		
		JLabel lblDesejaRemoverEsse = new JLabel("Deseja remover esse funcion\u00E1rio?");
		lblDesejaRemoverEsse.setFont(new Font("Arial", Font.PLAIN, 14));
		lblDesejaRemoverEsse.setBounds(165, 11, 267, 15);
		add(lblDesejaRemoverEsse);
		
		JLabel label_2 = new JLabel("N\u00B0 Cateira :" + funcionario.getnCarteira());
		label_2.setFont(new Font("Arial", Font.PLAIN, 12));
		label_2.setBounds(20, 99, 262, 14);
		add(label_2);
		
		JLabel label_3 = new JLabel("Data  adimiss\u00E3o :" + funcionario.getDataAdimissao());
		label_3.setFont(new Font("Arial", Font.PLAIN, 12));
		label_3.setBounds(10, 124, 272, 14);
		add(label_3);
		
		JLabel label_4 = new JLabel("Data demiss\u00E3o : "+ funcionario.getDataDemissao());
		label_4.setFont(new Font("Arial", Font.PLAIN, 12));
		label_4.setBounds(10, 161, 267, 14);
		add(label_4);
		
		JLabel label_5 = new JLabel("Login :"+ funcionario.getUsuario());
		label_5.setFont(new Font("Arial", Font.PLAIN, 12));
		label_5.setBounds(10, 199, 272, 14);
		add(label_5);
		
		JButton button = new JButton("Sim");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				funcionario.remover();
				
				JOptionPane.showMessageDialog(frame, 
						   "Pessoa removida com sucesso!", 
						   "Mensagem", 
						   JOptionPane.PLAIN_MESSAGE);
				
				
				frame.getContentPane().removeAll();
				CFuncionario painel = new CFuncionario(frame, id);
				frame.getContentPane().add(painel, BorderLayout.CENTER);
				frame.getContentPane().revalidate();
			}
		});
		button.setFont(new Font("Arial", Font.PLAIN, 12));
		button.setBounds(147, 369, 89, 23);
		add(button);
		
		JButton button_1 = new JButton("N\u00E3o");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				frame.getContentPane().removeAll();
				CFuncionario painel = new CFuncionario	(frame, 0);
				frame.getContentPane().add(painel, BorderLayout.CENTER);
				frame.getContentPane().revalidate();
			}
		});
		button_1.setFont(new Font("Arial", Font.PLAIN, 12));
		button_1.setBounds(256, 369, 89, 23);
		add(button_1);
		
		

	}

}
