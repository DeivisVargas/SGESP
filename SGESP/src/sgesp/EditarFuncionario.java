package sgesp;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditarFuncionario extends JPanel {
	private JTextField txtcarteira;
	private JTextField txtdt_admissao;
	private JTextField txtdt_demissao;
	private JTextField txtlogin;
	private JPasswordField txtantigasenha;
	private JPasswordField txtnovasenha;
	private JCheckBox cmbadm;

	/**
	 * Create the panel.
	 */
	public EditarFuncionario(JFrame frame, int id) {
		setLayout(null);
		
		JLabel lblatualizar = new JLabel("Atualizar ID: 0");
		lblatualizar.setFont(new Font("Arial", Font.PLAIN, 14));
		lblatualizar.setBounds(10, 22, 272, 14);
		add(lblatualizar);
		
		JLabel label_1 = new JLabel("N\u00B0 Cateira :");
		label_1.setFont(new Font("Arial", Font.PLAIN, 12));
		label_1.setBounds(13, 83, 70, 14);
		add(label_1);
		
		txtcarteira = new JTextField();
		txtcarteira.setFont(new Font("Arial", Font.PLAIN, 12));
		txtcarteira.setColumns(10);
		txtcarteira.setBounds(119, 80, 211, 20);
		add(txtcarteira);
		
		JLabel label_2 = new JLabel("Data  adimiss\u00E3o :");
		label_2.setFont(new Font("Arial", Font.PLAIN, 12));
		label_2.setBounds(13, 108, 102, 14);
		add(label_2);
		
		txtdt_admissao = new JTextField();
		txtdt_admissao.setFont(new Font("Arial", Font.PLAIN, 12));
		txtdt_admissao.setColumns(10);
		txtdt_admissao.setBounds(119, 111, 211, 20);
		add(txtdt_admissao);
		
		JLabel label_3 = new JLabel("Data demiss\u00E3o : ");
		label_3.setFont(new Font("Arial", Font.PLAIN, 12));
		label_3.setBounds(13, 145, 94, 14);
		add(label_3);
		
		txtdt_demissao = new JTextField();
		txtdt_demissao.setFont(new Font("Arial", Font.PLAIN, 12));
		txtdt_demissao.setColumns(10);
		txtdt_demissao.setBounds(119, 145, 211, 20);
		add(txtdt_demissao);
		
		JLabel label_4 = new JLabel("Login :");
		label_4.setFont(new Font("Arial", Font.PLAIN, 12));
		label_4.setBounds(378, 84, 70, 14);
		add(label_4);
		
		JLabel lblAntigaSenha = new JLabel("Antiga Senha :");
		lblAntigaSenha.setFont(new Font("Arial", Font.PLAIN, 12));
		lblAntigaSenha.setBounds(340, 109, 88, 14);
		add(lblAntigaSenha);
		
		txtlogin = new JTextField();
		txtlogin.setFont(new Font("Arial", Font.PLAIN, 12));
		txtlogin.setColumns(10);
		txtlogin.setBounds(438, 81, 211, 20);
		add(txtlogin);
		
		txtantigasenha = new JPasswordField();
		txtantigasenha.setBounds(438, 106, 211, 20);
		add(txtantigasenha);
		
		JLabel lblPessoaId = new JLabel("Pessoa ID : 0");
		lblPessoaId.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPessoaId.setBounds(10, 47, 272, 14);
		add(lblPessoaId);
		
		 cmbadm = new JCheckBox("Administrador ");
		cmbadm.setBounds(438, 189, 133, 23);
		add(cmbadm);
		
		JButton button = new JButton("Salvar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funcionario funcionario = new Funcionario(id);
				
				
				String vet =  lblPessoaId.getText();  
				String[] pessoa = vet.split(":");
				int idPessoa = Integer.parseInt(pessoa[1]);	
				funcionario.setIdPessoaFisica(idPessoa);
				
				String administrador ;
				
				if (cmbadm.isSelected()){
					administrador = "S" ;
                 	funcionario.setAdm(administrador);			
					
				}
				else {
					administrador = "N" ;
					funcionario.setAdm(administrador);	
				}
				
				funcionario.setnCarteira(txtcarteira.getText());
				funcionario.setDataAdimissao(txtdt_admissao.getText());
				funcionario.setDataDemissao(txtdt_demissao.getText());
				funcionario.setUsuario(txtlogin.getText());
				
				if (funcionario.verificar(txtlogin.getText(),txtantigasenha.getText())){
					
					funcionario.salvar(txtlogin.getText(),txtnovasenha.getText());
					
					JOptionPane.showMessageDialog(frame,
							"Usuario atualizado com sucesso!",
							"Mensagem", JOptionPane.PLAIN_MESSAGE);
					
					frame.getContentPane().removeAll();
					CFuncionario painel = new CFuncionario	(frame, 0);
					frame.getContentPane().add(painel, BorderLayout.CENTER);
					frame.getContentPane().revalidate();
					
				}
				else {
					
					JOptionPane.showMessageDialog(frame,
							"Senha atual incorreta ,o funcionario não foi atualizado!",
							"Mensagem", JOptionPane.PLAIN_MESSAGE);
					
					frame.getContentPane().removeAll();
					CFuncionario painel = new CFuncionario	(frame, 0);
					frame.getContentPane().add(painel, BorderLayout.CENTER);
					frame.getContentPane().revalidate();
				}
				
			}
		});
		button.setIcon(new ImageIcon(EditarFuncionario.class.getResource("/img/2683_32x32.png")));
		button.setBounds(43, 251, 120, 41);
		add(button);
		
	
		
		JLabel lblNovaSenha = new JLabel("Nova Senha :");
		lblNovaSenha.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNovaSenha.setBounds(340, 145, 88, 14);
		add(lblNovaSenha);
		
		txtnovasenha = new JPasswordField();
		txtnovasenha.setBounds(438, 139, 211, 20);
		add(txtnovasenha);
		
		Funcionario funcionario = new Funcionario(id);
		lblatualizar.setText("Atualizar ID: " + Integer.toString(funcionario.getIdFuncionario()));
		lblPessoaId.setText("Pessoa F\u00EDsica ID:" + Integer.toString(funcionario.getIdPessoaFisica()) );
		txtcarteira.setText(funcionario.getnCarteira());
		txtdt_admissao.setText(funcionario.getDataAdimissao());
		txtdt_demissao.setText(funcionario.getDataDemissao());
		txtlogin.setText(funcionario.getUsuario());
	
		
		
	}

	}

