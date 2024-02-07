package sgesp;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RemoverPessoaJuridica extends JPanel {

	/**
	 * Create the panel.
	 */
	public RemoverPessoaJuridica(JFrame frame , int id) {
		setLayout(null);
		
		PessoaJuridica pessoa = new PessoaJuridica(id) ;
		
		JLabel label = new JLabel("Deseja remover essa pessoa?");
		label.setFont(new Font("Arial", Font.PLAIN, 14));
		label.setBounds(147, 11, 267, 15);
		add(label);
		
		JLabel label_1 = new JLabel("Codigo: " + pessoa.getIdPessoaJuridica());
		label_1.setFont(new Font("Arial", Font.PLAIN, 12));
		label_1.setBounds(10, 50, 179, 15);
		add(label_1);
		
		JLabel lblRazaoSocial = new JLabel("Razao social :" + pessoa.getRzSocial() );
		lblRazaoSocial.setFont(new Font("Arial", Font.PLAIN, 12));
		lblRazaoSocial.setBounds(10, 76, 341, 15);
		add(lblRazaoSocial);
		
		JLabel lblFantasia = new JLabel("Fantasia : " + pessoa.getFantasia());
		lblFantasia.setFont(new Font("Arial", Font.PLAIN, 12));
		lblFantasia.setBounds(10, 102, 179, 15);
		add(lblFantasia);
		
		JLabel lblCnpj = new JLabel("CNPJ :" + pessoa.getCnpj());
		lblCnpj.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCnpj.setBounds(10, 130, 179, 15);
		add(lblCnpj);
		
		JLabel lblIr = new JLabel("Ir :" + pessoa.getIr());
		lblIr.setFont(new Font("Arial", Font.PLAIN, 12));
		lblIr.setBounds(10, 159, 179, 15);
		add(lblIr);
		
		JLabel label_6 = new JLabel("CEP: " + pessoa.getCep());
		label_6.setFont(new Font("Arial", Font.PLAIN, 12));
		label_6.setBounds(10, 236, 179, 15);
		add(label_6);
		
		JLabel lblEmail = new JLabel("Email : " + pessoa.getEmail());
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 12));
		lblEmail.setBounds(10, 262, 179, 15);
		add(lblEmail);
		
		JLabel lblCidade = new JLabel("Cidade : " + pessoa.getIdCidade());
		lblCidade.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCidade.setBounds(10, 210, 179, 15);
		add(lblCidade);
		
		JLabel lblTelefone = new JLabel("Telefone :" + pessoa.getTelefone());
		lblTelefone.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTelefone.setBounds(10, 288, 179, 15);
		add(lblTelefone);
		
		JLabel lblCelular = new JLabel("Celular :" + pessoa.getCelular());
		lblCelular.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCelular.setBounds(10, 314, 179, 15);
		add(lblCelular);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o :" + pessoa.getEndereco());
		lblEndereo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblEndereo.setBounds(10, 185, 106, 14);
		add(lblEndereo);
		
		JButton button = new JButton("Sim");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				pessoa.remover();
				
				JOptionPane.showMessageDialog(frame, 
						   "Pessoa removida com sucesso!", 
						   "Mensagem", 
						   JOptionPane.PLAIN_MESSAGE);
				
				
				frame.getContentPane().removeAll();
				CPessoaJuridica pessoa = new CPessoaJuridica(frame);
				frame.getContentPane().add(pessoa, BorderLayout.CENTER);
				frame.getContentPane().revalidate();
				
			}
		});
		button.setFont(new Font("Arial", Font.PLAIN, 12));
		button.setBounds(86, 371, 89, 23);
		add(button);
		
		JButton button_1 = new JButton("N\u00E3o");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.getContentPane().removeAll();
				CPessoaJuridica pessoa = new CPessoaJuridica(frame);
				frame.getContentPane().add(pessoa, BorderLayout.CENTER);
				frame.getContentPane().revalidate(); 
			}
		});
		button_1.setFont(new Font("Arial", Font.PLAIN, 12));
		button_1.setBounds(195, 371, 89, 23);
		add(button_1);
		
		
		
		
		
		
		

	}
}
