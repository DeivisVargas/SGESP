package sgesp;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;

public class Compra extends JPanel {
	private JTextField txtquantidade;
	private JTextField txtdata;
	private JTextField txtcodigo;
	private JTextField txtdescricao;
	private JTextField txtvalorultima;

	/**
	 * Create the panel.
	 * @param i 
	 * @param frame 
	 */
	public Compra(JFrame frame, int id) {
		setLayout(null);
		
		JLabel lblcodigo = new JLabel("Codigo do componente :");
		lblcodigo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblcodigo.setBounds(10, 100, 162, 29);
		add(lblcodigo);
		
		JLabel lblDescrisso = new JLabel("Descri\u00E7\u00E3o :");
		lblDescrisso.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDescrisso.setBounds(10, 146, 82, 29);
		add(lblDescrisso);
		
		JLabel lblValorDaUltima = new JLabel("Valor da ultima compra :");
		lblValorDaUltima.setFont(new Font("Arial", Font.PLAIN, 12));
		lblValorDaUltima.setBounds(10, 186, 151, 29);
		add(lblValorDaUltima);
		
		JLabel lblQuantidade = new JLabel("Quantidade de itens  :");
		lblQuantidade.setFont(new Font("Arial", Font.PLAIN, 12));
		lblQuantidade.setBounds(10, 270, 138, 29);
		add(lblQuantidade);
		
		txtquantidade = new JTextField();
		txtquantidade.setBounds(182, 274, 75, 23);
		add(txtquantidade);
		txtquantidade.setColumns(10);
		
		
		JButton btnGerarSolicitaoDe = new JButton("Gerar solicita\u00E7\u00E3o de compra ");
		btnGerarSolicitaoDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CompraCab compra = new 	CompraCab();
				
				compra.setIdComponente(Integer.parseInt(txtcodigo.getText()));
				compra.setDescricao(txtdescricao.getText());
				compra.setVlrultima(Float.parseFloat(txtvalorultima.getText()));
				compra.setData(txtdata.getText());
				compra.setQtd(Integer.parseInt(txtquantidade.getText()));
				
				compra.salvar();
				limpar();
				JOptionPane.showMessageDialog(frame,
						"Compra gerada  com sucesso!",
						"Mensagem", JOptionPane.PLAIN_MESSAGE);
				
				frame.getContentPane().removeAll();
				ConsultaEstoque estoque = new ConsultaEstoque(frame);
				frame.getContentPane().add(estoque, BorderLayout.CENTER);
				frame.getContentPane().revalidate();
			
				
				
			}
		});
		btnGerarSolicitaoDe.setBounds(0, 327, 227, 23);
		add(btnGerarSolicitaoDe);
		
		JButton btnCancelar = new JButton("Cancelar ");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame.getContentPane().removeAll();
				ConsultaEstoque estoque = new ConsultaEstoque(frame);
				frame.getContentPane().add(estoque, BorderLayout.CENTER);
				frame.getContentPane().revalidate();
				
			}
		});
		btnCancelar.setBounds(258, 327, 126, 23);
		add(btnCancelar);
		
		JLabel lblSolicitaoDeCompra = new JLabel("Solicita\u00E7\u00E3o de compra ");
		lblSolicitaoDeCompra.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSolicitaoDeCompra.setBounds(222, 11, 162, 29);
		add(lblSolicitaoDeCompra);
		

		txtdata = new JTextField();
		txtdata.setColumns(10);
		txtdata.setBounds(182, 230, 165, 23);
		add(txtdata);
		txtdata.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
		
		txtcodigo = new JTextField();
		txtcodigo.setColumns(10);
		txtcodigo.setBounds(182, 104, 165, 23);
		add(txtcodigo);
		
		txtdescricao = new JTextField();
		txtdescricao.setColumns(10);
		txtdescricao.setBounds(182, 146, 164, 23);
		add(txtdescricao);
		
		txtvalorultima = new JTextField();
		txtvalorultima.setColumns(10);
		txtvalorultima.setBounds(182, 190, 164, 23);
		add(txtvalorultima);
		
		Componentes componente = new Componentes(id);
		
		txtcodigo.setText( Integer.toString(componente.getIdComponente()));
		txtdescricao.setText(componente.getDescricao());
		txtvalorultima.setText(Float.toString(componente.getVlrCompra()));
		
		//lblcodigo.setText(" Codigo do componente : " + Integer.toString(componente.getIdComponente()));
		//lblDescrisso.setText("Descri\u00E7\u00E3o :" +componente.getDescricao());
		
		//lblValorDaUltima.setText("Valor da ultima compra :" +Float.toString(componente.getVlrCompra()));
		
		JLabel lblData = new JLabel("Data :");
		lblData.setFont(new Font("Arial", Font.PLAIN, 12));
		lblData.setBounds(10, 226, 49, 29);
		add(lblData);
		
		
		
	}
	public void limpar (){
		txtcodigo.setText("");
		txtdata.setText("");
		txtdescricao.setText("");
		txtquantidade.setText("");
		txtvalorultima.setText("");
		
	}
	}

