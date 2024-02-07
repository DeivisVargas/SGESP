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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class FinalizarVender extends JPanel {

	private JLabel lblData;

	/**
	 * Create the panel.
	 */
	public FinalizarVender(JFrame frame, int id) {
		setLayout(null);
		
		OProducao op = new OProducao(id);		
		
		JLabel lblNewLabel = new JLabel("Finalizar Ordem Produ\u00E7\u00E3o");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 27, 209, 14);
		add(lblNewLabel);
		
		JLabel lblCdigoOrdem = new JLabel("C\u00F3digo: " + op.getIdOrdemProducao());
		lblCdigoOrdem.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCdigoOrdem.setBounds(10, 72, 353, 14);
		add(lblCdigoOrdem);
		
		JLabel lblCliente = new JLabel("Cliente: " + op.getIdCliente());
		lblCliente.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCliente.setBounds(10, 110, 353, 14);
		add(lblCliente);
		
		JLabel lblProduto = new JLabel("Produto: " + op.getIdProduto());
		lblProduto.setFont(new Font("Arial", Font.PLAIN, 12));
		lblProduto.setBounds(10, 154, 353, 14);
		add(lblProduto);
		
		JLabel lblQuantidade = new JLabel("Quantidade: " + op.getQtd());
		lblQuantidade.setFont(new Font("Arial", Font.PLAIN, 12));
		lblQuantidade.setBounds(10, 192, 209, 14);
		add(lblQuantidade);
		
		JLabel lblDataSolicitao = new JLabel("Data Solicita\u00E7\u00E3o: " + op.getDataSolicitacao());
		lblDataSolicitao.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDataSolicitao.setBounds(10, 229, 288, 14);
		add(lblDataSolicitao);
		
		JButton btnNewButton = new JButton("Finalizar" );
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				op.setDataFinalizacao(lblData.getText());
				op.setConcluido("S");
				op.salvar();
				JOptionPane.showMessageDialog(frame,
						"Ordem de produção finalizada com sucesso!",
						"Mensagem", JOptionPane.PLAIN_MESSAGE);
				frame.getContentPane().removeAll();
				OPPendente panel = new OPPendente(frame, 0);
				frame.getContentPane().add(panel, BorderLayout.CENTER); // chama novamente a tela de estados 
				frame.getContentPane().revalidate();
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton.setBounds(103, 341, 107, 33);
		add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.getContentPane().removeAll();
				FinalizarVender finalizar = new FinalizarVender(frame, id);
				frame.getContentPane().add(finalizar, BorderLayout.CENTER);
				frame.getContentPane().revalidate(); 
			}
		});
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCancelar.setBounds(318, 341, 107, 33);
		add(btnCancelar);
		
		lblData = new JLabel("");
		lblData.setFont(new Font("Arial", Font.PLAIN, 12));
		lblData.setBounds(111, 268, 70, 14);
		add(lblData);
		
		lblData.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));  
		
		JLabel lblDataFinalizao = new JLabel("Data Finaliza\u00E7\u00E3o");
		lblDataFinalizao.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDataFinalizao.setBounds(10, 269, 107, 14);
		add(lblDataFinalizao);
		

	}
}
