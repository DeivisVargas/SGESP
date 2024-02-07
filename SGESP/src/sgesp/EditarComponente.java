package sgesp;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditarComponente extends JPanel {
	private JTextField txtEstoqyeMin;
	private JTextField txtEstoque;
	private JTextField txtVlrCompra;
	private JTextField txtDescricao;

	/**
	 * Create the panel.
	 */
	public EditarComponente(JFrame frame, int id) {
		setLayout(null);
		
		JLabel lblAtualizarId = new JLabel("Atualizar ID: ");
		lblAtualizarId.setFont(new Font("Arial", Font.PLAIN, 14));
		lblAtualizarId.setBounds(10, 27, 272, 14);
		add(lblAtualizarId);
		
		JLabel lblEstoqueMnimo = new JLabel("Estoque M\u00EDnimo:");
		lblEstoqueMnimo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblEstoqueMnimo.setBounds(417, 114, 94, 14);
		add(lblEstoqueMnimo);
		
		txtEstoqyeMin = new JTextField();
		txtEstoqyeMin.setFont(new Font("Arial", Font.PLAIN, 12));
		txtEstoqyeMin.setColumns(10);
		
		txtEstoqyeMin.setBounds(517, 112, 107, 20);
		add(txtEstoqyeMin);
		
		txtEstoque = new JTextField();
		txtEstoque.setFont(new Font("Arial", Font.PLAIN, 12));
		txtEstoque.setColumns(10);
		txtEstoque.setBounds(300, 109, 107, 20);
		add(txtEstoque);
		
		JLabel label_2 = new JLabel("Estoque:");
		label_2.setFont(new Font("Arial", Font.PLAIN, 12));
		label_2.setBounds(249, 112, 49, 14);
		add(label_2);
		
		txtVlrCompra = new JTextField();
		txtVlrCompra.setFont(new Font("Arial", Font.PLAIN, 12));
		txtVlrCompra.setColumns(10);
		txtVlrCompra.setBounds(113, 112, 126, 20);
		add(txtVlrCompra);
		
		JLabel label_3 = new JLabel("Valor da compra:");
		label_3.setFont(new Font("Arial", Font.PLAIN, 12));
		label_3.setBounds(10, 115, 93, 14);
		add(label_3);
		
		JLabel label_4 = new JLabel("Descri\u00E7\u00E3o:");
		label_4.setFont(new Font("Arial", Font.PLAIN, 12));
		label_4.setBounds(10, 75, 59, 14);
		add(label_4);
		
		txtDescricao = new JTextField();
		txtDescricao.setFont(new Font("Arial", Font.PLAIN, 12));
		txtDescricao.setColumns(10);
		txtDescricao.setBounds(85, 72, 539, 20);
		add(txtDescricao);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Componentes componente = new Componentes(id);
				componente.setDescricao(txtDescricao.getText());
				componente.setVlrCompra(Float.parseFloat(txtVlrCompra.getText()));
				componente.setEstoque(Integer.parseInt(txtEstoque.getText()));
				componente.setEstoqueMin(Integer.parseInt(txtEstoqyeMin.getText()));
				componente.salvar();
				
				
				JOptionPane.showMessageDialog(frame,
						"Componente atualizado com sucesso!",
						"Mensagem", JOptionPane.PLAIN_MESSAGE);
				
								
				frame.getContentPane().removeAll();
				CComponentes panel = new CComponentes(frame);
				frame.getContentPane().add(panel, BorderLayout.CENTER); 
				frame.getContentPane().revalidate();
			}
		});
		btnSalvar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnSalvar.setIcon(new ImageIcon(EditarComponente.class.getResource("/img/2683_32x32.png")));
		btnSalvar.setBounds(504, 173, 120, 41);
		add(btnSalvar);
		
		Componentes componente = new Componentes(id);
		lblAtualizarId.setText("Atualizar ID: " + Integer.toString(componente.getIdComponente()));
		txtDescricao.setText(componente.getDescricao());
		txtEstoque.setText(Integer.toString(componente.getEstoque()));
		txtEstoqyeMin.setText(Integer.toString(componente.getEstoqueMin()));
		txtVlrCompra.setText(Float.toString(componente.getVlrCompra()));
	}

}
