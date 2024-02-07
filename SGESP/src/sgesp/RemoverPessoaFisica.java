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

public class RemoverPessoaFisica extends JPanel {

	/**
	 * Create the panel.
	 */
	public RemoverPessoaFisica(JFrame frame, int id) {
		setLayout(null);
		
		PessoaFisica pessoa = new PessoaFisica(id);
		
		JLabel lblDesejaRemoverEssa = new JLabel("Deseja remover essa pessoa?");
		lblDesejaRemoverEssa.setFont(new Font("Arial", Font.PLAIN, 14));
		lblDesejaRemoverEssa.setBounds(55, 11, 267, 15);
		add(lblDesejaRemoverEssa);
		
		JLabel label_1 = new JLabel("Codigo: "  + pessoa.getIdPessoaFisica()) ;
		label_1.setFont(new Font("Arial", Font.PLAIN, 12));
		label_1.setBounds(10, 53, 179, 15);
		add(label_1);
		
		JLabel lblNome = new JLabel("Nome: " + pessoa.getNome());
		lblNome.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNome.setBounds(10, 79, 341, 15);
		add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF: " + pessoa.getCpf());
		lblCpf.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCpf.setBounds(10, 105, 179, 15);
		add(lblCpf);
		
		JLabel lblRg = new JLabel("RG: " + pessoa.getRg());
		lblRg.setFont(new Font("Arial", Font.PLAIN, 12));
		lblRg.setBounds(10, 133, 179, 15);
		add(lblRg);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o: " + pessoa.getEndereco());
		lblEndereo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblEndereo.setBounds(10, 162, 179, 15);
		add(lblEndereo);
		
		JButton button = new JButton("Sim");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pessoa.remover();
				
				JOptionPane.showMessageDialog(frame, 
						   "Pessoa removida com sucesso!", 
						   "Mensagem", 
						   JOptionPane.PLAIN_MESSAGE);
				
				
				frame.getContentPane().removeAll();
				CPessoaFisica pessoa = new CPessoaFisica(frame);
				frame.getContentPane().add(pessoa, BorderLayout.CENTER);
				frame.getContentPane().revalidate(); 
			}
		});
		button.setFont(new Font("Arial", Font.PLAIN, 12));
		button.setBounds(136, 384, 89, 23);
		add(button);
		
		JButton button_1 = new JButton("N\u00E3o");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.getContentPane().removeAll();
				CPessoaFisica pessoa = new CPessoaFisica(frame);
				frame.getContentPane().add(pessoa, BorderLayout.CENTER);
				frame.getContentPane().revalidate(); 
			}
		});
		button_1.setFont(new Font("Arial", Font.PLAIN, 12));
		button_1.setBounds(245, 384, 89, 23);
		add(button_1);
		
		JLabel lblCep = new JLabel("CEP: " + pessoa.getCep());
		lblCep.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCep.setBounds(10, 188, 179, 15);
		add(lblCep);
		
		JLabel lblEmail = new JLabel("Email: " + pessoa.getEmail());
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 12));
		lblEmail.setBounds(10, 224, 179, 15);
		add(lblEmail);
		
		JLabel lblCidade = new JLabel("Cidade: " + pessoa.getIdCidade());
		lblCidade.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCidade.setBounds(10, 343, 179, 15);
		add(lblCidade);
		
		JLabel lblTelefone = new JLabel("Telefone :" + pessoa.getTelefone());
		lblTelefone.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTelefone.setBounds(10, 250, 179, 15);
		add(lblTelefone);
		
		JLabel lblCelular = new JLabel("Celular :" + pessoa.getCelular());
		lblCelular.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCelular.setBounds(10, 276, 179, 15);
		add(lblCelular);

	}
}
