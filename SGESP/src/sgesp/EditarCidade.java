package sgesp;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditarCidade extends JPanel {
	private JTextField txtCidade;
	private JComboBox cmbEstado;
	
	/**
	 * Create the panel.
	 * @param i 
	 * @param frame 
	 */
	public EditarCidade(JFrame frame, int id) {
		setLayout(null);
		
		cmbEstado = new JComboBox();
		cmbEstado.setBounds(66, 99, 336, 20);
		add(cmbEstado);
	
		carregarCmb();
		
		JLabel label = new JLabel("Cidade :");
		label.setFont(new Font("Arial", Font.PLAIN, 12));
		label.setBounds(10, 65, 46, 14);
		add(label);
		
		txtCidade = new JTextField();
		txtCidade.setFont(new Font("Arial", Font.PLAIN, 12));
		txtCidade.setColumns(10);
		txtCidade.setBounds(66, 62, 514, 20);
		add(txtCidade);
		
		JLabel label_1 = new JLabel("Estado :");
		label_1.setFont(new Font("Arial", Font.PLAIN, 12));
		label_1.setBounds(10, 101, 46, 14);
		add(label_1);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cidade cidade = new Cidade(id);
				String vet =  (String) cmbEstado.getSelectedItem();  
				String[] estado = vet.split(" ");
				int idEstado = Integer.parseInt(estado[0]);	
				
				cidade.setCidade(txtCidade.getText());
		     	cidade.setIdUf(idEstado);
				cidade.salvar();
				JOptionPane.showMessageDialog(frame,
						"Cidade atualizada com sucesso!",
						"Mensagem", JOptionPane.PLAIN_MESSAGE);
				frame.getContentPane().removeAll();
				CCidade panel = new CCidade(frame);
				frame.getContentPane().add(panel, BorderLayout.CENTER);
				frame.getContentPane().revalidate();
			}
		});
		btnSalvar.setIcon(new ImageIcon(EditarCidade.class.getResource("/img/2683_32x32.png")));
		btnSalvar.setBounds(398, 155, 120, 41);
		add(btnSalvar);
		
		JLabel lblAtualizarId = new JLabel("Atualizar ID: ");
		lblAtualizarId.setFont(new Font("Arial", Font.PLAIN, 14));
		lblAtualizarId.setBounds(10, 23, 272, 14);
		add(lblAtualizarId);
		
		Cidade cidade = new Cidade(id);
		lblAtualizarId.setText("Atualizar ID: " + Integer.toString(cidade.getIdCidade()));
		txtCidade.setText(cidade.getCidade());
		cmbEstado.setSelectedItem(cidade.getIdUf());


	}
	
	public void carregarCmb(){			
		Estado estado = new Estado();
		Estado[] estados = estado.consultar();
	    if (estados != null) {  
	    	for (int i=0; i<estados.length; i++) {
	    		cmbEstado.addItem(estados[i].getIdEstado() + " " + estados[i].getEstado());
	    	}
	    }
}
}
