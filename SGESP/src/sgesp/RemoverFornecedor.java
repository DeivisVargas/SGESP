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

public class RemoverFornecedor extends JPanel {

	/**
	 * Create the panel.
	 */
	public RemoverFornecedor(JFrame frame, int id) {
		setLayout(null);
		
		Fornecedor forn = new Fornecedor (id) ;
		
		JLabel lblDesejaRemoverEsse = new JLabel("Deseja remover esse Fornecedor?");
		lblDesejaRemoverEsse.setFont(new Font("Arial", Font.PLAIN, 14));
		lblDesejaRemoverEsse.setBounds(126, 11, 277, 15);
		add(lblDesejaRemoverEsse);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo :" + forn.getIdFornecedor());
		lblCdigo.setBounds(10, 58, 185, 14);
		add(lblCdigo);
		
		JLabel lblCdigoDaPessoa = new JLabel("C\u00F3digo da Pessoa :" + forn.getIdPessoaJuridica());
		lblCdigoDaPessoa.setBounds(10, 93, 185, 14);
		add(lblCdigoDaPessoa);
		
		JLabel lblMateriaisFornecidos = new JLabel("Materiais fornecidos :" + forn.getTipomaterial());
		lblMateriaisFornecidos.setBounds(10, 133, 423, 14);
		add(lblMateriaisFornecidos);
		
		JButton button = new JButton("Sim");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				forn.remover();
				
				JOptionPane.showMessageDialog(frame, 
						   "Fornecedor  removido com sucesso!", 
						   "Mensagem", 
						   JOptionPane.PLAIN_MESSAGE);
				
				frame.getContentPane().removeAll();
				CFornecedor panel = new CFornecedor(frame, id);
				frame.getContentPane().add(panel, BorderLayout.CENTER); 
				frame.getContentPane().revalidate();
				
				
			}
		});
		button.setFont(new Font("Arial", Font.PLAIN, 12));
		button.setBounds(10, 189, 89, 23);
		add(button);
		
		JButton button_1 = new JButton("N\u00E3o");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.getContentPane().removeAll();
				CFornecedor panel = new CFornecedor(frame, id);
				frame.getContentPane().add(panel, BorderLayout.CENTER); 
				frame.getContentPane().revalidate();
				
			}
		});
		button_1.setFont(new Font("Arial", Font.PLAIN, 12));
		button_1.setBounds(114, 189, 89, 23);
		add(button_1);
		
		
		

	}

}
