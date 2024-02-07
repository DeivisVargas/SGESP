package sgesp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.SystemColor;

import javax.swing.SwingConstants;
import javax.swing.JDesktopPane;

import java.awt.Label;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.tree.FixedHeightLayoutCache;

import org.omg.CORBA.FixedHolder;

import java.awt.Toolkit;
import java.awt.Font;
import java.sql.Date;
import java.util.concurrent.BrokenBarrierException;

import javax.swing.JButton;

public class sistema {

	
	JFrame frmSgesp;
    String administrador ;
	
	
	
	

	/**
	 * Launch the application.
	 *
	 */
	
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sistema window = new sistema();
					for( LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()){
						if("windows".equals(info.getName())){
							javax.swing.UIManager.setLookAndFeel(info.getClassName());
							break ;
						}
						
					}
					login log = new login() ;
					 log.setVisible(true);
					
					window.frmSgesp.setVisible(false);
					
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	*/

	

	/**
	 * Create the application.
	 * @param adm 
	 * @param adm 
	 * @param adm 
	 * @param adm 
	 * @param adm 
	 * @param adm 
	 * @param log 
	 */
	public  sistema() {
		initialize();
		
		
			
	}

	





	/**
	 * Initialize the contents of the frame.
	 * @param administrador2 
	 */
	
	private void initialize() {
	
		
		
		frmSgesp = new JFrame();
		frmSgesp.setResizable(true);
		
		frmSgesp.setIconImage(Toolkit.getDefaultToolkit().getImage(sistema.class.getResource("/img/pokebola.png")));
		frmSgesp.setForeground(SystemColor.textHighlight);
		frmSgesp.setBackground(SystemColor.textHighlight);
		frmSgesp.setTitle("S.G.E.S.P");
		
		frmSgesp.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmSgesp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSgesp.getContentPane().setLayout(new BorderLayout(0, 0));
		
		
		login log = new login() ;
		log.setVisible(false);		
		
		administrador = Permissao.admin ;
		
		
		Fundo tela = new Fundo();
		frmSgesp.getContentPane().add(tela);
		tela.setLayout(null);
		
		
		JMenuBar menuBar = new JMenuBar();
		
		frmSgesp.setJMenuBar(menuBar);
		
		JButton bthome = new JButton("");
		bthome.setIcon(new ImageIcon(sistema.class.getResource("/img/home1.png")));
		bthome.setToolTipText("Voltar a tela inicial ");
		bthome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Fundo tela = new Fundo();
				frmSgesp.getContentPane().removeAll();
				
				frmSgesp.getContentPane().add(tela);
				GroupLayout gl_tela = new GroupLayout(tela);
				gl_tela.setHorizontalGroup(
					gl_tela.createParallelGroup(Alignment.LEADING)
						.addGap(0, 784, Short.MAX_VALUE)
				);
				gl_tela.setVerticalGroup(
					gl_tela.createParallelGroup(Alignment.LEADING)
						.addGap(0, 524, Short.MAX_VALUE)
				);
				tela.setLayout(gl_tela); 
				frmSgesp.getContentPane().revalidate();
				
				
			}
		});
		menuBar.add(bthome);
		
		JButton btn_logoof = new JButton("");
		
		
		// faz mostrar uma mensagem em cima do botao 
		btn_logoof.setToolTipText("Deseja trocar de usuáro ?");
		
		btn_logoof.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				login logg = new login();
				
				logg.setVisible(true);
				frmSgesp.dispose();
				
				
				
				//fazer log off
			}
		});
		btn_logoof.setIcon(new ImageIcon(sistema.class.getResource("/img/log_off.png")));
		menuBar.add(btn_logoof);
		
		JMenu mnCadrastro = new JMenu("Cadastro");
		mnCadrastro.setFont(new Font("Arial", Font.PLAIN, 14));
		mnCadrastro.setIcon(new ImageIcon(sistema.class.getResource("/img/cadastro.png")));
		menuBar.add(mnCadrastro);
		
		
		JMenuItem mntmFuncionrio = new JMenuItem("Funcion\u00E1rio");
		mntmFuncionrio.setFont(new Font("Arial", Font.PLAIN, 12));
		
        
		
	
		
		mntmFuncionrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmSgesp.getContentPane().removeAll();
				CFuncionario funcionario = new CFuncionario	(frmSgesp, 0);
				frmSgesp.getContentPane().add(funcionario, BorderLayout.CENTER);
				frmSgesp.getContentPane().revalidate(); 
			}
		});
		
		JMenuItem mntmPessoaFisica = new JMenuItem("Pessoa F\u00EDsica");
		mntmPessoaFisica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				frmSgesp.getContentPane().removeAll();
				CPessoaFisica pessoa = new CPessoaFisica(frmSgesp);
				frmSgesp.getContentPane().add(pessoa, BorderLayout.CENTER);
				frmSgesp.getContentPane().revalidate(); 
				
			}
		});
		mntmPessoaFisica.setFont(new Font("Arial", Font.PLAIN, 12));
		mnCadrastro.add(mntmPessoaFisica);
		
		JMenuItem mntmPessoaJuridica = new JMenuItem("Pessoa Juridica");
		mntmPessoaJuridica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frmSgesp.getContentPane().removeAll();
				CPessoaJuridica pessoajuridica = new CPessoaJuridica(frmSgesp);
				frmSgesp.getContentPane().add(pessoajuridica, BorderLayout.CENTER);
				frmSgesp.getContentPane().revalidate(); 
				
			}
		});

		mntmPessoaJuridica.setFont(new Font("Arial", Font.PLAIN, 12));
		mnCadrastro.add(mntmPessoaJuridica);
		
		
		mnCadrastro.add(mntmFuncionrio);
		
		JMenuItem mntmComponente = new JMenuItem("Componente");
		mntmComponente.setFont(new Font("Arial", Font.PLAIN, 12));
		mntmComponente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmSgesp.getContentPane().removeAll();
				CComponentes componente = new CComponentes(frmSgesp);
				frmSgesp.getContentPane().add(componente, BorderLayout.CENTER);
				frmSgesp.getContentPane().revalidate(); 
			}
		});
		
		JMenuItem mntmFornecedor = new JMenuItem("Fornecedor");
		mntmFornecedor.setFont(new Font("Arial", Font.PLAIN, 12));
		mntmFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmSgesp.getContentPane().removeAll();
				CFornecedor fornecedor = new CFornecedor(frmSgesp, 0);
				frmSgesp.getContentPane().add(fornecedor, BorderLayout.CENTER);
				frmSgesp.getContentPane().revalidate(); 		
			}
		});
		mnCadrastro.add(mntmFornecedor);
		mnCadrastro.add(mntmComponente);
		
		JMenuItem mntmProdutos_1 = new JMenuItem("Produtos");
		mntmProdutos_1.setFont(new Font("Arial", Font.PLAIN, 12));
		mntmProdutos_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				frmSgesp.getContentPane().removeAll();
				CProduto produto = new CProduto(frmSgesp,0);
				frmSgesp.getContentPane().add(produto, BorderLayout.CENTER);
				frmSgesp.getContentPane().revalidate(); 
			}
		});
		mnCadrastro.add(mntmProdutos_1);
		
		
		JMenuItem mntmCidades = new JMenuItem("Cidades");
		mntmCidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmSgesp.getContentPane().removeAll();
				CCidade cidade = new CCidade(frmSgesp);
				frmSgesp.getContentPane().add(cidade, BorderLayout.CENTER);
				frmSgesp.getContentPane().revalidate(); 
			}
		});
		mntmCidades.setFont(new Font("Arial", Font.PLAIN, 12));
		mnCadrastro.add(mntmCidades);
		
		JMenuItem mntmEstados = new JMenuItem("Estados");
		mntmEstados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmSgesp.getContentPane().removeAll();
				CEstado estado = new CEstado(frmSgesp);
				frmSgesp.getContentPane().add(estado, BorderLayout.CENTER);
				frmSgesp.getContentPane().revalidate(); 
			}
		});
		mntmEstados.setFont(new Font("Arial", Font.PLAIN, 12));
		mnCadrastro.add(mntmEstados);
		
		JMenu mnOrdemDeProduo = new JMenu("Ordem de produ\u00E7\u00E3o");
		mnOrdemDeProduo.setFont(new Font("Arial", Font.PLAIN, 14));
		mnOrdemDeProduo.setIcon(new ImageIcon(sistema.class.getResource("/img/nota2.png")));
		menuBar.add(mnOrdemDeProduo);
		
		JMenuItem mntmConcluirOp = new JMenuItem("Gerar");
		mntmConcluirOp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSgesp.getContentPane().removeAll();
				OrdemProducao op = new OrdemProducao(frmSgesp, 0 ,0);
				frmSgesp.getContentPane().add(op, BorderLayout.CENTER);
				frmSgesp.getContentPane().revalidate();
			}
		});
		mntmConcluirOp.setFont(new Font("Arial", Font.PLAIN, 12));
		mnOrdemDeProduo.add(mntmConcluirOp);
		
		JMenuItem mntmCancelarOp = new JMenuItem("Consultar");
		mntmCancelarOp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSgesp.getContentPane().removeAll();
				OPPendente op = new OPPendente (frmSgesp, 0);
				frmSgesp.getContentPane().add(op, BorderLayout.CENTER);
				frmSgesp.getContentPane().revalidate();
			}
		});
		mntmCancelarOp.setFont(new Font("Arial", Font.PLAIN, 12));
		mnOrdemDeProduo.add(mntmCancelarOp);
		
		JMenu mnMovimentaes = new JMenu("Movimenta\u00E7\u00F5es");
		mnMovimentaes.setIcon(new ImageIcon(sistema.class.getResource("/img/financeiro.png")));
		mnMovimentaes.setFont(new Font("Arial", Font.PLAIN, 14));
		menuBar.add(mnMovimentaes);
		
		  if (administrador.equals("N")) {
			  
			  mntmFuncionrio.setVisible(false);
			  mnMovimentaes.setVisible(false);
		  }
		
		
		JMenuItem mntmCompras = new JMenuItem("Compras");
		mntmCompras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				
				frmSgesp.getContentPane().removeAll();
				ConsultaEstoque estoque = new ConsultaEstoque(frmSgesp);
				frmSgesp.getContentPane().add(estoque, BorderLayout.CENTER);
				frmSgesp.getContentPane().revalidate();
			}
		});
		mntmCompras.setFont(new Font("Arial", Font.PLAIN, 12));
		mnMovimentaes.add(mntmCompras);
		
		
		
		
		
		
	}
}
