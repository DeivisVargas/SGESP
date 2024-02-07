package sgesp;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditarPessoaJuridica extends JPanel {
	private JTextField txtcep;
	private JTextField txtendereco;
	private JTextField txtcnpj;
	private JTextField txtrazaosocial;
	private JTextField txtfantasia;
	private JTextField txtir;
	private JTextField txtemail;
	private JTextField txttelefone;
	private JComboBox cmbcidade;
	private JTextField txtcelular;

	/**
	 * Create the panel.
	 */
	public EditarPessoaJuridica(JFrame frame , int id) {
		setLayout(null);
		
		
		
		
		
		JLabel lbatualizar = new JLabel("Atualizar ID: 0" );
		lbatualizar.setFont(new Font("Arial", Font.PLAIN, 14));
		lbatualizar.setBounds(10, 11, 272, 14);
		add(lbatualizar);
		
		
		
		
		
		JLabel label_1 = new JLabel("Raz\u00E3o Social :");
		label_1.setFont(new Font("Arial", Font.PLAIN, 12));
		label_1.setBounds(10, 49, 81, 14);
		add(label_1);
		
		JLabel label_2 = new JLabel("CNPJ :");
		label_2.setFont(new Font("Arial", Font.PLAIN, 12));
		label_2.setBounds(10, 74, 46, 14);
		add(label_2);
		
		JLabel label_3 = new JLabel("Endere\u00E7o :");
		label_3.setFont(new Font("Arial", Font.PLAIN, 12));
		label_3.setBounds(10, 99, 68, 14);
		add(label_3);
		
		JLabel label_4 = new JLabel("CEP :");
		label_4.setFont(new Font("Arial", Font.PLAIN, 12));
		label_4.setBounds(10, 128, 38, 14);
		add(label_4);
		
		JLabel label_5 = new JLabel("Cidade: ");
		label_5.setFont(new Font("Arial", Font.PLAIN, 12));
		label_5.setBounds(10, 160, 46, 14);
		add(label_5);
		
		 cmbcidade = new JComboBox();
		cmbcidade.setBounds(101, 158, 245, 20);
		add(cmbcidade);
		
		carregarCmb();
		
		txtcep = new JTextField();
		txtcep.setColumns(10);
		txtcep.setBounds(101, 128, 245, 20);
		add(txtcep);
		
		txtendereco = new JTextField();
		txtendereco.setColumns(10);
		txtendereco.setBounds(101, 99, 245, 20);
		add(txtendereco);
		
		txtcnpj = new JTextField();
		txtcnpj.setColumns(10);
		txtcnpj.setBounds(101, 74, 245, 20);
		add(txtcnpj);
		
		txtrazaosocial = new JTextField();
		txtrazaosocial.setColumns(10);
		txtrazaosocial.setBounds(101, 47, 245, 20);
		add(txtrazaosocial);
		
		JLabel label_6 = new JLabel("Fantasia :");
		label_6.setFont(new Font("Arial", Font.PLAIN, 12));
		label_6.setBounds(380, 49, 59, 14);
		add(label_6);
		
		JLabel lblIr = new JLabel("IR :");
		lblIr.setFont(new Font("Arial", Font.PLAIN, 12));
		lblIr.setBounds(380, 74, 27, 14);
		add(lblIr);
		
		JLabel label_8 = new JLabel("Email :");
		label_8.setFont(new Font("Arial", Font.PLAIN, 12));
		label_8.setBounds(379, 99, 46, 14);
		add(label_8);
		
		JLabel label_9 = new JLabel("Telefone :");
		label_9.setFont(new Font("Arial", Font.PLAIN, 12));
		label_9.setBounds(380, 128, 59, 14);
		add(label_9);
		
		txtfantasia = new JTextField();
		txtfantasia.setColumns(10);
		txtfantasia.setBounds(449, 47, 245, 20);
		add(txtfantasia);
		
		txtir = new JTextField();
		txtir.setColumns(10);
		txtir.setBounds(449, 74, 245, 20);
		add(txtir);
		
		txtemail = new JTextField();
		txtemail.setColumns(10);
		txtemail.setBounds(449, 99, 245, 20);
		add(txtemail);
		
		txttelefone = new JTextField();
		txttelefone.setColumns(10);
		txttelefone.setBounds(449, 128, 245, 20);
		add(txttelefone);
		
		txtcelular = new JTextField();
		txtcelular.setColumns(10);
		txtcelular.setBounds(449, 158, 245, 20);
		add(txtcelular);
		
		JButton button = new JButton("Salvar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PessoaJuridica pessoa = new PessoaJuridica(id);
				String vet =  (String) cmbcidade.getSelectedItem();  
				String[] cidade = vet.split(" ");
				int idCidade = Integer.parseInt(cidade[0]);	
				
				pessoa.setRzSocial(txtrazaosocial.getText());
				pessoa.setFantasia(txtfantasia.getText());
				pessoa.setCnpj(txtcnpj.getText());
				pessoa.setIr(txtir.getText());
				pessoa.setEndereco(txtendereco.getText());
				pessoa.setEmail(txtemail.getText());
				pessoa.setCep(txtcep.getText());
				pessoa.setTelefone(txttelefone.getText());
				pessoa.setCelular(txtcelular.getText());
				pessoa.setIdCidade(idCidade);
				
				pessoa.salvar();
				
				JOptionPane.showMessageDialog(frame,
						"Pessoa atualizada com sucesso!",
						"Mensagem", JOptionPane.PLAIN_MESSAGE);
				
				frame.getContentPane().removeAll();
				CPessoaJuridica panel = new CPessoaJuridica(frame);
				frame.getContentPane().add(panel, BorderLayout.CENTER); 
				frame.getContentPane().revalidate();
				
				
				
				
				
			}
		});
		button.setIcon(new ImageIcon(EditarPessoaJuridica.class.getResource("/img/2683_32x32.png")));
		button.setFont(new Font("Arial", Font.PLAIN, 12));
		button.setBounds(101, 238, 120, 41);
		add(button);
		
		PessoaJuridica pessoa = new PessoaJuridica(id) ;
		lbatualizar.setText("Atualizar ID: " + Integer.toString(pessoa.getIdPessoaJuridica()));
		
		txtrazaosocial.setText(pessoa.getRzSocial());
		txtfantasia.setText(pessoa.getFantasia());
		txtcnpj.setText(pessoa.getCnpj());
		txtir.setText(pessoa.getIr());
		txtendereco.setText(pessoa.getEndereco());
		txtemail.setText(pessoa.getEmail());
		txtcep.setText(pessoa.getCep());
		txttelefone.setText(pessoa.getTelefone());
		txtcelular.setText(pessoa.getCelular());
		cmbcidade.setSelectedItem(Integer.toString(pessoa.getIdCidade()));
		
		JLabel lblCelular = new JLabel("Celular :");
		lblCelular.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCelular.setBounds(380, 160, 59, 14);
		add(lblCelular);
		
		
		
		

	}
	
	public void carregarCmb(){			
		Cidade cidade = new Cidade();
		Cidade[] cidades = cidade.consultar();
	    if (cidades != null) {  
	    	for (int i=0; i<cidades.length; i++) {
	    		cmbcidade.addItem(cidades[i].getIdCidade() + " " + cidades[i].getCidade());
	    	}
	    }
	}
}
