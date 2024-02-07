package sgesp;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class EditarPessoaFisica extends JPanel {
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtRg;
	private JTextField txtEndereco;
	private JTextField txtCep;
	private JTextField txtEmail;
	private JComboBox cmbCidade;
	private JTextField txttelefone;
	private JTextField txtcelular;

	/**
	 * Create the panel.
	 */
	public EditarPessoaFisica(JFrame frame, int id) {
		setLayout(null);
		
		JLabel label = new JLabel("Nome :");
		label.setFont(new Font("Arial", Font.PLAIN, 12));
		label.setBounds(10, 50, 46, 14);
		add(label);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(79, 48, 245, 20);
		add(txtNome);
		
		JLabel label_1 = new JLabel("CPF :");
		label_1.setFont(new Font("Arial", Font.PLAIN, 12));
		label_1.setBounds(10, 75, 46, 14);
		add(label_1);
		
		txtCpf = new JTextField();
		txtCpf.setColumns(10);
		txtCpf.setBounds(79, 73, 245, 20);
		add(txtCpf);
		
		JLabel label_2 = new JLabel("RG :");
		label_2.setFont(new Font("Arial", Font.PLAIN, 12));
		label_2.setBounds(355, 77, 46, 14);
		add(label_2);
		
		txtRg = new JTextField();
		txtRg.setColumns(10);
		txtRg.setBounds(415, 73, 245, 20);
		add(txtRg);
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(79, 100, 245, 20);
		add(txtEndereco);
		
		JLabel label_3 = new JLabel("Endere\u00E7o :");
		label_3.setFont(new Font("Arial", Font.PLAIN, 12));
		label_3.setBounds(10, 102, 63, 14);
		add(label_3);
		
		JLabel label_4 = new JLabel("Cep :");
		label_4.setFont(new Font("Arial", Font.PLAIN, 12));
		label_4.setBounds(10, 129, 46, 14);
		add(label_4);
		
		txtCep = new JTextField();
		txtCep.setColumns(10);
		txtCep.setBounds(79, 127, 245, 20);
		add(txtCep);
		
		JLabel label_5 = new JLabel("Email :");
		label_5.setFont(new Font("Arial", Font.PLAIN, 12));
		label_5.setBounds(355, 50, 46, 14);
		add(label_5);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(415, 48, 245, 20);
		add(txtEmail);
		
		JLabel label_6 = new JLabel("Cidade: ");
		label_6.setFont(new Font("Arial", Font.PLAIN, 12));
		label_6.setBounds(10, 179, 46, 14);
		add(label_6);
		
		JLabel label_7 = new JLabel("Telefone :");
		label_7.setFont(new Font("Arial", Font.PLAIN, 12));
		label_7.setBounds(355, 102, 63, 14);
		add(label_7);
		
		txttelefone = new JTextField();
		txttelefone.setColumns(10);
		txttelefone.setBounds(415, 100, 245, 20);
		add(txttelefone);
		
		JLabel lblCelular = new JLabel("Celular :");
		lblCelular.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCelular.setBounds(355, 130, 63, 14);
		add(lblCelular);
		
		txtcelular = new JTextField();
		txtcelular.setColumns(10);
		txtcelular.setBounds(415, 127, 245, 20);
		add(txtcelular);
		
		cmbCidade = new JComboBox();
		cmbCidade.setBounds(79, 177, 245, 20);
		add(cmbCidade);
		
		carregarCmb();
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setIcon(new ImageIcon(EditarPessoaFisica.class.getResource("/img/2683_32x32.png")));
		btnSalvar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PessoaFisica pessoa = new PessoaFisica(id);
				String vet =  (String) cmbCidade.getSelectedItem();  
				String[] cidade = vet.split(" ");
				int idCidade = Integer.parseInt(cidade[0]);	
				
				pessoa.setNome(txtNome.getText());
				pessoa.setCpf(txtCpf.getText());
				pessoa.setRg(txtRg.getText());
				pessoa.setIdCidade(idCidade);
				pessoa.setCep(txtCep.getText());
				pessoa.setEndereco(txtEndereco.getText());
				pessoa.setEmail(txtEmail.getText());
				pessoa.setTelefone(txttelefone.getText());
				pessoa.setCelular(txtcelular.getText());
				pessoa.salvar();
				
				JOptionPane.showMessageDialog(frame,
						"Pessoa atualizada com sucesso!",
						"Mensagem", JOptionPane.PLAIN_MESSAGE);
				
								
				frame.getContentPane().removeAll();
				CPessoaFisica panel = new CPessoaFisica(frame);
				frame.getContentPane().add(panel, BorderLayout.CENTER); 
				frame.getContentPane().revalidate();
				
			}
		});
		btnSalvar.setBounds(79, 231, 120, 41);
		add(btnSalvar);
		
		JLabel lblAtualizarId = new JLabel("Atualizar ID: 0");
		lblAtualizarId.setFont(new Font("Arial", Font.PLAIN, 14));
		lblAtualizarId.setBounds(10, 22, 272, 14);
		add(lblAtualizarId);
		
		PessoaFisica pessoa = new PessoaFisica(id);
		lblAtualizarId.setText("Atualizar ID: " + Integer.toString(pessoa.getIdPessoaFisica()));
		txtCep.setText(pessoa.getCep());
		txtCpf.setText(pessoa.getCpf());
		txtEmail.setText(pessoa.getEmail());
		txtEndereco.setText(pessoa.getEndereco());
		txtNome.setText(pessoa.getNome());
		txtRg.setText(pessoa.getRg());
		txttelefone.setText(pessoa.getTelefone());
		txtcelular.setText(pessoa.getCelular());
		cmbCidade.setSelectedItem(Integer.toString(pessoa.getIdCidade()));
		
		
	}
	
	public void carregarCmb(){			
		Cidade cidade = new Cidade();
		Cidade[] cidades = cidade.consultar();
	    if (cidades != null) {  
	    	for (int i=0; i<cidades.length; i++) {
	    		cmbCidade.addItem(cidades[i].getIdCidade() + " " + cidades[i].getCidade());
	    	}
	    }
	}
}
