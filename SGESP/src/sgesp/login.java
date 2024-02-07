package sgesp;

import java.awt.BorderLayout;
import java.awt.Event;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.security.spec.PSSParameterSpec;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class login extends JFrame {
	
	
	

	//protected static final String jframe = null;
	private JPanel contentPane;
	private JTextField txtusuario;
	private JPasswordField txtsenha;
	private String adm ;
	public String getAdm() {
		return adm;
	}


	public void setAdm(String adm) {
		this.adm = adm;
	}
	private int Id ;

	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public login(String adm) throws HeadlessException {
		super();
		this.adm = adm;
	}


	public String getLog() {
		return adm;
	}


	public void setLog(String log) {
		this.adm = log;
	}


	/**
	 * Launch the application.
	 */
	 public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
					
					
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the frame.
	 */
	public login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(login.class.getResource("/img/pokebola.png")));
		setResizable(false);
		setTitle("LOGIN  SGESP");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 150, 496, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		ValidarUsuario validar = new ValidarUsuario();
	
		
		JPanel panel = new JPanel();
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(login.class.getResource("/img/chave1.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(205, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1)
					.addGap(175))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(26)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(75, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
					.addGap(21)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
					.addGap(36))
		);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(80, 11, 47, 28);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(80, 84, 52, 17);
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtusuario = new JTextField();
		txtusuario.setBounds(80, 47, 252, 28);
		txtusuario.setColumns(10);
		
		txtsenha = new JPasswordField();
		
		//acionando a tecla enter 
		txtsenha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				
				if (evt.getKeyCode()== KeyEvent.VK_ENTER ){
					
					   if (txtusuario.getText().equals("") || txtsenha.getText().equals("")){
							
							JOptionPane.showMessageDialog(null, "digite um usuario e uma senha v�lida ");
							txtusuario.requestFocus();
							
						}
		            
						
						
						if (validar.verificar(txtusuario.getText(), txtsenha.getText())) {
							
							adm = validar.getAdm() ;
							
							Permissao.admin = adm ;
					
						
							
							
							sistema window = new sistema();
							window.frmSgesp.setVisible(true);
							fechar();
							
							
						}else {
							JOptionPane.showMessageDialog(null, "Login ou Senha incorretos  ");
							txtsenha.setText("");
							txtusuario.setText("");
							txtusuario.requestFocus();
							
						}
						 
					
					
					
				}
			}
		});
		
		
		//ate aqui � pra fazer a tecla enter funcionar  com o botao 
		
		txtsenha.setBounds(80, 107, 252, 27);
		
		JButton btEntrar = new JButton("Entrar");
		btEntrar.setBounds(80, 162, 111, 28);
		btEntrar.setFont(new Font("Arial", Font.PLAIN, 12));
		btEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
            if (txtusuario.getText().equals("") || txtsenha.getText().equals("")){
					
					JOptionPane.showMessageDialog(null, "digite um usuario e uma senha v�lida ");
					txtusuario.requestFocus();
					
				}
            
				
				ValidarUsuario validar =  new ValidarUsuario() ;
				if (validar.verificar(txtusuario.getText(), txtsenha.getText())) {
					
					adm = validar.getAdm() ;
					Permissao.admin = adm ;
					

					sistema window = new sistema();
					window.frmSgesp.setVisible(true);
					fechar();
					
					
				}else {
					JOptionPane.showMessageDialog(null, "Login ou Senha incorretos  ");
					txtsenha.setText("");
					txtusuario.setText("");
					txtusuario.requestFocus();
					
				}
				 
				
				 
						
			}

			
			
		
		});
		
		
		btEntrar.setIcon(new ImageIcon(login.class.getResource("/img/2683_32x32.png")));
		
		
		JButton btcancelar = new JButton("   Sair");
		btcancelar.setBounds(221, 162, 111, 28);
		btcancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			 System.exit(0);
				
				
			}
		});
		btcancelar.setFont(new Font("Arial", Font.PLAIN, 12));
		btcancelar.setIcon(new ImageIcon(login.class.getResource("/img/cancelar.png")));
		panel.setLayout(null);
		panel.add(lblSenha);
		panel.add(lblNewLabel);
		panel.add(txtusuario);
		panel.add(txtsenha);
		panel.add(btEntrar);
		panel.add(btcancelar);
		contentPane.setLayout(gl_contentPane);
		
		
		
		
	}
	public void fechar (){
		this.setVisible(false);
		
	}
}
