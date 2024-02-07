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

public class EditarFuncao extends JPanel {
	private JTextField txtFuncao;

	/**
	 * Create the panel.
	 */
	public EditarFuncao(JFrame frame, int id) {
		setLayout(null);
		
		Funcao funcao = new Funcao(id);
		JLabel lblAtualizarId = new JLabel("Atualizar ID: " + funcao.getIdFuncao());
		lblAtualizarId.setFont(new Font("Arial", Font.PLAIN, 14));
		lblAtualizarId.setBounds(10, 24, 272, 14);
		add(lblAtualizarId);
		
		JLabel lblFuno = new JLabel("Fun\u00E7\u00E3o: ");
		lblFuno.setFont(new Font("Arial", Font.PLAIN, 12));
		lblFuno.setBounds(10, 72, 57, 15);
		add(lblFuno);
		
		txtFuncao = new JTextField();
		txtFuncao.setFont(new Font("Arial", Font.PLAIN, 12));
		txtFuncao.setColumns(10);
		txtFuncao.setText(funcao.getFuncao());
		txtFuncao.setBounds(66, 69, 358, 21);
		add(txtFuncao);
		
		JButton button = new JButton("Salvar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funcao funcao = new Funcao(id);
				funcao.setFuncao(txtFuncao.getText());
				funcao.salvar();
				JOptionPane.showMessageDialog(frame,
						"Função atualizada com sucesso!",
						"Mensagem", JOptionPane.PLAIN_MESSAGE);
				frame.getContentPane().removeAll();
				CFuncao panel = new CFuncao(frame);
				frame.getContentPane().add(panel, BorderLayout.CENTER);  
				frame.getContentPane().revalidate();
			}
		});
		button.setFont(new Font("Arial", Font.PLAIN, 12));
		button.setIcon(new ImageIcon(EditarFuncao.class.getResource("/img/2683_32x32.png")));
		button.setBounds(441, 124, 120, 41);
		add(button);

	}
}
