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

public class EditarEstado extends JPanel {
	private JTextField txtEstado;
	private JTextField txtUf;

	/**
	 * Create the panel.
	 */
	public EditarEstado(JFrame frame, int id) {
		setLayout(null);
		
		Estado estado = new Estado(id);
		JLabel label_2 = new JLabel("Atualizar ID: 0" + Integer.toString(estado.getIdEstado()));
		label_2.setFont(new Font("Arial", Font.PLAIN, 14));
		label_2.setBounds(10, 31, 272, 14);
		add(label_2);
		
		JLabel label = new JLabel("Estado :");
		label.setFont(new Font("Arial", Font.PLAIN, 12));
		label.setBounds(10, 79, 45, 15);
		add(label);
		
		txtEstado = new JTextField();
		txtEstado.setFont(new Font("Arial", Font.PLAIN, 12));
		txtEstado.setColumns(10);
		txtEstado.setText(estado.getEstado());
		txtEstado.setBounds(66, 76, 358, 21);
		add(txtEstado);
		
		JLabel label_1 = new JLabel("UF:");
		label_1.setFont(new Font("Arial", Font.PLAIN, 12));
		label_1.setBounds(472, 79, 19, 15);
		add(label_1);
		
		txtUf = new JTextField();
		txtUf.setFont(new Font("Arial", Font.PLAIN, 12));
		txtUf.setColumns(10);
		txtUf.setText(estado.getUf());
		txtUf.setBounds(501, 73, 60, 21);
		add(txtUf);
		
		JButton button = new JButton("Salvar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Estado estado = new Estado(id);
				estado.setEstado(txtEstado.getText());
				estado.setUf(txtUf.getText());
				estado.salvar();
				JOptionPane.showMessageDialog(frame,
						"Estado atualizado com sucesso!",
						"Mensagem", JOptionPane.PLAIN_MESSAGE);
				frame.getContentPane().removeAll();
				CEstado panel = new CEstado(frame);
				frame.getContentPane().add(panel, BorderLayout.CENTER); // chama novamente a tela de estados 
				frame.getContentPane().revalidate();
			}
		});
		button.setIcon(new ImageIcon(EditarEstado.class.getResource("/img/2683_32x32.png")));
		button.setBounds(441, 131, 120, 41);
		add(button);
		
		

	}
}
