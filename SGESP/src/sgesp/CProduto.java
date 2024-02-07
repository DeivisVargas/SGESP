package sgesp;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;

import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CProduto extends JPanel {
	private JTextField txtVlrVenda;
	private JTextField txtQtd;
	private JTable tblCompProd;
	private JTable tblComp;
	private JTextField txtDescricao;
	private JLabel lblCodigo;
	private JTextField txtBusca;
	private JLabel lblComp;
	private JLabel lblComponente_1;

	/**
	 * Create the panel.
	 */
	public CProduto(JFrame frame, int id) {
		setLayout(null);
		//frame.setBounds(500,500,0,0);

		Produto produto = new Produto();
		ComponentesProduto compProd = new ComponentesProduto();
		Componentes componente = new Componentes();

		JLabel lblValorDeVenda = new JLabel("Valor de Venda:");
		lblValorDeVenda.setFont(new Font("Arial", Font.PLAIN, 12));
		lblValorDeVenda.setBounds(204, 530, 92, 15);
		add(lblValorDeVenda);

		txtVlrVenda = new JTextField();
		txtVlrVenda.setFont(new Font("Arial", Font.PLAIN, 12));
		txtVlrVenda.setColumns(10);
		txtVlrVenda.setBounds(299, 527, 120, 21);
		add(txtVlrVenda);

		JLabel lblComponente = new JLabel("Componente: ");
		lblComponente.setFont(new Font("Arial", Font.PLAIN, 12));
		lblComponente.setBounds(27, 229, 120, 15);
		add(lblComponente);

		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setFont(new Font("Arial", Font.PLAIN, 12));
		lblQuantidade.setBounds(404, 229, 92, 15);
		add(lblQuantidade);

		txtQtd = new JTextField();
		txtQtd.setFont(new Font("Arial", Font.PLAIN, 12));
		txtQtd.setColumns(10);
		txtQtd.setBounds(517, 226, 61, 21);
		add(txtQtd);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tblCompProd.getSelectedRow() >= 0) {  
					
										
				} else {   
					JOptionPane.showMessageDialog(frame,    
							"Selecione um Componente!",   
							"Mensagem", JOptionPane.PLAIN_MESSAGE); 
				}
			}
			
		});
		btnExcluir.setFont(new Font("Arial", Font.PLAIN, 12));
		btnExcluir.setIcon(new ImageIcon(CProduto.class.getResource("/img/Botao-Excluir.png")));
		btnExcluir.setBounds(455, 267, 120, 41);
		add(btnExcluir);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 319, 548, 136);
		add(scrollPane);

		tblCompProd = new JTable();
		tblCompProd.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Produto", "Componente", "Quantidade"
			}
		));
		scrollPane.setViewportView(tblCompProd);

		JButton btnConcluir = new JButton("Concluir");
		btnConcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produto.setIdProduto(produto.getIdPro());
				produto.setDescricao(txtDescricao.getText());
				produto.setVlrVenda(Float.parseFloat(txtVlrVenda.getText()));
				produto.salvar();
				
				txtDescricao.setText("");
				txtQtd.setText("");
				txtVlrVenda.setText("");
				lblCodigo.setText("Codigo: ");
				lblComponente_1.setText("Componente ");
				lblComp.setText("");
			}
		});
		btnConcluir.setFont(new Font("Arial", Font.PLAIN, 12));
		btnConcluir.setBounds(460, 518, 120, 41);
		add(btnConcluir);

		lblComp = new JLabel(componente.getDescricao());
		lblComp.setFont(new Font("Arial", Font.PLAIN, 12));
		lblComp.setBounds(157, 229, 237, 15);
		add(lblComp);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(639, 81, 543, 410);
		add(scrollPane_1);
		
		tblComp = new JTable();
		tblComp.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Descricao", "Valor de Compra", "Estoque", "Estoque Minimo"
			}
		));
		scrollPane_1.setViewportView(tblComp);
		
		carregarGridComp();
		
		JLabel lblSelecionarComponentesDo = new JLabel("Selecionar Componentes do Produto");
		lblSelecionarComponentesDo.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSelecionarComponentesDo.setBounds(802, 11, 253, 14);
		add(lblSelecionarComponentesDo);
		
		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tblComp.getSelectedRow() >= 0) {  
					lblComponente.setText("Componente: " + Integer.toString((int) (tblComp.getValueAt(tblComp.getSelectedRow(), 0))));
					lblComp.setText((String) tblComp.getValueAt(tblComp.getSelectedRow(), 1));
					
				} else {   
					JOptionPane.showMessageDialog(frame,  
							"Selecione um Componente" ,   
							"Mensagem", JOptionPane.PLAIN_MESSAGE); 
				}
			}
		});
		btnSelecionar.setBounds(1035, 518, 120, 41);
		add(btnSelecionar);
		
		 lblCodigo = new JLabel("C\u00F3digo: ");
		lblCodigo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCodigo.setBounds(354, 51, 115, 15);
		add(lblCodigo);

		
		JLabel label = new JLabel("Descri\u00E7\u00E3o:");
		label.setFont(new Font("Arial", Font.PLAIN, 12));
		label.setBounds(30, 51, 73, 15);
		add(label);
		
		JLabel label_1 = new JLabel("Cadastro de Produtos");
		label_1.setFont(new Font("Arial", Font.PLAIN, 14));
		label_1.setBounds(240, 24, 151, 14);
		add(label_1);
		
		txtDescricao = new JTextField();
		txtDescricao.setFont(new Font("Arial", Font.PLAIN, 12));
		txtDescricao.setColumns(10);
		txtDescricao.setBounds(114, 48, 216, 21);
		add(txtDescricao);
		
		JButton button = new JButton("Salvar");
		button.setFont(new Font("Arial", Font.PLAIN, 12));
		button.setIcon(new ImageIcon(CProduto.class.getResource("/img/2683_32x32.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				produto.setDescricao(txtDescricao.getText());
				
				produto.setVlrVenda(0);
				produto.salvar();
				
				produto.consultarId();
				lblCodigo.setText(lblCodigo.getText() + produto.getIdPro());
				Comprod.pro = produto.getIdPro() ;
			}
		});
		button.setBounds(32, 77, 120, 41);
		add(button);
		
		JButton button_1 = new JButton("Cancelar");
		button_1.setFont(new Font("Arial", Font.PLAIN, 12));
		button_1.setIcon(new ImageIcon(CProduto.class.getResource("/img/cancelar.png")));
		button_1.setBounds(237, 77, 120, 41);
		add(button_1);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String vet =  (String) lblComponente.getText();  
				String[] id = vet.split(" ");
				int idComponente = Integer.parseInt(id[1]);	
				
				compProd.setIdComponente(idComponente);
				compProd.setIdProduto(produto.getIdPro());
				compProd.setQtd(Integer.parseInt(txtQtd.getText()));
				compProd.salvar();
				
				lblComponente.setText("Componente: ");
				lblComp.setText("");
				txtQtd.setText("");
				carregarGridCompProd();
			}
		});
		btnAdicionar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAdicionar.setIcon(new ImageIcon(CProduto.class.getResource("/img/2683_32x32.png")));
		
		btnAdicionar.setBounds(27, 267, 135, 41);
		add(btnAdicionar);
		
		JButton btnCancelar_1 = new JButton("Cancelar");
		btnCancelar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblComponente.setText("Componente: ");
				lblComp.setText("");
				txtQtd.setText("");
			}
		});
		btnCancelar_1.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCancelar_1.setIcon(new ImageIcon(CProduto.class.getResource("/img/cancelar.png")));
		btnCancelar_1.setBounds(237, 267, 120, 41);
		add(btnCancelar_1);		
		
		lblComponente_1 = new JLabel("Componente:");
		lblComponente_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblComponente_1.setBounds(658, 52, 85, 15);
		add(lblComponente_1);
		
		txtBusca = new JTextField();
		txtBusca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
			carregarGridbusca();	
				
			}
		});
		txtBusca.setFont(new Font("Arial", Font.PLAIN, 12));
		txtBusca.setColumns(10);
		txtBusca.setBounds(754, 49, 266, 21);
		add(txtBusca);
		/*
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				componente.setBusca(txtBusca.getText());
				componente.consultarDesc();
				

			}
		});
		btnBuscar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnBuscar.setBounds(1062, 47, 85, 23);
		add(btnBuscar);
		*/
	}
	
	private void carregarGridComp(){
		DefaultTableModel dtm = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Codigo", "Descricao", "Valor de Compra", "Estoque", "Estoque Minimo"
				}
			);
			
			Componentes componente = new Componentes();
			Componentes[] componentes = componente.consultar();
		    if (componentes != null) {
		    	for (int i=0; i<componentes.length; i++) {
		    		dtm.addRow(new Object[] {
		    				componentes[i].getIdComponente(),
		    				componentes[i].getDescricao(),
		    				componentes[i].getVlrCompra(),
		    				componentes[i].getEstoque(),
		    				componentes[i].getEstoqueMin()
		    		});
		    	}
		    }
		    
		    tblComp.setModel(dtm);
	}
	
	private void carregarGridCompProd(){
		DefaultTableModel dtm = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Codigo","Produto", "Componente", "Quantidade"
				}
			);
		
		ComponentesProduto compProd = new ComponentesProduto();
		ComponentesProduto[] compProds = compProd.consultar();
		if(compProds != null){
			for(int i=0; i<compProds.length; i++){
				dtm.addRow(new Object[]{
						compProds[i].getIdComponenetesProduto(),
						compProds[i].getIdProduto(),
						compProds[i].getIdComponente(),
						compProds[i].getQtd()
				});
			}
		}
		
		tblCompProd.setModel(dtm);
	}
	
	private void carregarGridbusca(){
		DefaultTableModel dtm = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Codigo", "Descricao", "Valor de Compra", "Estoque", "Estoque Minimo"
				}
			);
			
			Componentes componente = new Componentes();
			Componentes[] componentes = componente.busca(txtBusca.getText());
		    if (componentes != null) {
		    	for (int i=0; i<componentes.length; i++) {
		    		dtm.addRow(new Object[] {
		    				componentes[i].getIdComponente(),
		    				componentes[i].getDescricao(),
		    				componentes[i].getVlrCompra(),
		    				componentes[i].getEstoque(),
		    				componentes[i].getEstoqueMin()
		    		});
		    	}
		    }
		    
		    tblComp.setModel(dtm);
	}
	
}
