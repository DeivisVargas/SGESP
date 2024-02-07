package sgesp;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class OrdemProducao extends JPanel {
	private JTable table;
	private JLabel lblCliente;
	private JLabel lblProduto;
	private JTextField txtQtd;
	private JLabel lblData;

	/**
	 * Create the panel.
	 */
	public OrdemProducao(JFrame frame, int idcliente , int idproduto) {
		setLayout(null);
		
		PessoaJuridica pessoa = new PessoaJuridica(idcliente);
		Produto produto = new Produto(idproduto);
		OProducao ordemproducao = new OProducao();
		
		JLabel lblGerarOrdemDe = new JLabel("Gerar Ordem de Produ\u00E7\u00E3o");
		lblGerarOrdemDe.setFont(new Font("Arial", Font.PLAIN, 14));
		lblGerarOrdemDe.setBounds(119, 11, 211, 14);
		add(lblGerarOrdemDe);
		
		JLabel lblNum = new JLabel("N\u00BA Ordem: ");
		lblNum.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNum.setBounds(10, 36, 147, 14);
		add(lblNum);
		
		JLabel label2 = new JLabel("Cliente");
		label2.setFont(new Font("Arial", Font.PLAIN, 12));
		label2.setBounds(10, 61, 68, 14);
		add(label2);
		
		JLabel lblData1 = new JLabel("Data");
		lblData1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblData1.setBounds(10, 131, 68, 14);
		add(lblData1);
		
		lblCliente = new JLabel(""+ pessoa.getIdPessoaJuridica() +":" + pessoa.getFantasia());
		lblCliente.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCliente.setBounds(105, 61, 277, 14);
		add(lblCliente);
		
		lblProduto = new JLabel("" + produto.getIdProduto() + ":" + produto.getDescricao());
		lblProduto.setFont(new Font("Arial", Font.PLAIN, 12));
		lblProduto.setBounds(107, 107, 260, 14);
		add(lblProduto);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 223, 465, 96);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel label1 = new JLabel("Produto");
		label1.setFont(new Font("Arial", Font.PLAIN, 12));
		label1.setBounds(10, 103, 50, 14);
		add(label1);
		
		JLabel lblComponentes = new JLabel("Componentes");
		lblComponentes.setFont(new Font("Arial", Font.PLAIN, 12));
		lblComponentes.setBounds(10, 206, 147, 14);
		add(lblComponentes);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Codigo", "Componente", "Quantidade"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnSalvar = new JButton("Iniciar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			
				ordemproducao.setIdCliente(idcliente);
				ordemproducao.setDataSolicitacao(lblData.getText());
				ordemproducao.setIdProduto(idproduto);
				ordemproducao.setQtd(Integer.parseInt(txtQtd.getText()));
				ordemproducao.setConcluido("N");
				ordemproducao.salvar();
				
				frame.getContentPane().removeAll();
				OrdemProducao op = new OrdemProducao(frame, 0 ,0);
				frame.getContentPane().add(op, BorderLayout.CENTER);
				frame.getContentPane().revalidate();
			}
		});
		btnSalvar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnSalvar.setBounds(10, 330, 89, 23);
		add(btnSalvar);
		
	
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Fundo tela = new Fundo();
				frame.getContentPane().removeAll();
				
				frame.getContentPane().add(tela);
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
				frame.getContentPane().revalidate();
			}
		});
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCancelar.setBounds(355, 330, 89, 23);
		add(btnCancelar);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(OrdemProducao.class.getResource("/img/lupa.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				SelecCliente cliente = new SelecCliente(frame);
				frame.getContentPane().add(cliente, BorderLayout.CENTER);
				frame.getContentPane().revalidate(); 
			}
		});
		button.setFont(new Font("Arial", Font.PLAIN, 12));
		button.setBounds(55, 50, 42, 31);
		add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(OrdemProducao.class.getResource("/img/lupa.png")));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				SelecProduto cliente = new SelecProduto(frame,pessoa.getIdPessoaJuridica());
				frame.getContentPane().add(cliente, BorderLayout.CENTER);
				frame.getContentPane().revalidate(); 
			
			}
		});
		button_1.setFont(new Font("Arial", Font.PLAIN, 12));
		button_1.setBounds(55, 86, 42, 31);
		add(button_1);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setFont(new Font("Arial", Font.PLAIN, 12));
		lblQuantidade.setBounds(10, 160, 68, 14);
		add(lblQuantidade);
		
		txtQtd = new JTextField();
		txtQtd.addKeyListener(new KeyAdapter() {
		});
		txtQtd.setFont(new Font("Arial", Font.PLAIN, 12));
		txtQtd.setColumns(10);
		txtQtd.setBounds(84, 158, 201, 20);
		add(txtQtd);
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ComponentesProduto compProd = new ComponentesProduto();
				
				Comprod.pro = produto.getIdPro();
				
				produto.consultarId();
				lblProduto.setText(Integer.toString(produto.getIdPro()));
				Comprod.pro = produto.getIdPro() ;
				carregarGrid();
				
				Componentes comp = new Componentes();
				CalcularEstoque est = new CalcularEstoque();
				est.setIdProduto(produto.getIdProduto());		
				est.setQtdProd(Integer.parseInt(txtQtd.getText()));	
				ComponentesProduto[] compProds = compProd.consultar();
				for(int i=0; i<compProds.length; i++){
					est.setIdProduto((int)table.getValueAt(i, 1));
					comp.consultarEstoque(est.getIdProduto());
					est.setEstoque(comp.getEstoque());
					est.setQtd((int)table.getValueAt(i, 2));
					est.calculaQtd();
					est.verificar();
					if(est.verificar() == true)
						est.calculaEstoque();
					else{
						JOptionPane.showMessageDialog(frame,    
								"Não possui componentes suficientes para produzir!",   
								"Mensagem", JOptionPane.PLAIN_MESSAGE); 
						break;
					}
						
				}			
			}
		});
		button_2.setFont(new Font("Arial", Font.PLAIN, 12));
		button_2.setBounds(139, 189, 42, 23);
		add(button_2);
		
		lblData = new JLabel("");
		lblData.setFont(new Font("Arial", Font.PLAIN, 12));
		lblData.setBounds(55, 132, 70, 14);
		add(lblData);
		
		lblData.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
	}
    
	private void carregarGrid(){
		DefaultTableModel dtm = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Codigo", "Componente", "Quantidade"
				}
			);
		
		ComponentesProduto compProd = new ComponentesProduto();
		ComponentesProduto[] compProds = compProd.consultar();
		if(compProds != null){
			for(int i=0; i<compProds.length; i++){
				dtm.addRow(new Object[]{
						compProds[i].getIdComponenetesProduto(),
						compProds[i].getIdComponente(),
						compProds[i].getQtd()
				});
			}
		}
		
		table.setModel(dtm);
	}
	
	private void limparFormulario(){
		txtQtd.setText("");
		lblCliente.setText("");
		lblProduto.setText("");
	}
}
