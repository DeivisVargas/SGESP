package sgesp;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class CComponentesProduto extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public CComponentesProduto() {
		setLayout(null);
		
		JLabel label = new JLabel("Componentes do Produto");
		label.setFont(new Font("Arial", Font.PLAIN, 14));
		label.setBounds(564, 11, 183, 14);
		add(label);
		
		JLabel label_1 = new JLabel("Buscar");
		label_1.setFont(new Font("Arial", Font.PLAIN, 12));
		label_1.setBounds(480, 39, 50, 14);
		add(label_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 12));
		textField.setColumns(10);
		textField.setBounds(535, 36, 232, 20);
		add(textField);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(480, 79, 377, 129);
		add(scrollPane);
		
		JLabel label_2 = new JLabel("Quantidade");
		label_2.setFont(new Font("Arial", Font.PLAIN, 12));
		label_2.setBounds(480, 219, 75, 14);
		add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.PLAIN, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(560, 216, 78, 20);
		add(textField_1);
		
		JButton button = new JButton("");
		button.setFont(new Font("Arial", Font.PLAIN, 12));
		button.setBounds(672, 219, 89, 23);
		add(button);
		
		JLabel lblProduto = new JLabel("Produto");
		lblProduto.setFont(new Font("Arial", Font.PLAIN, 14));
		lblProduto.setBounds(168, 11, 74, 14);
		add(lblProduto);
		
		JLabel label_3 = new JLabel("Buscar");
		label_3.setFont(new Font("Arial", Font.PLAIN, 12));
		label_3.setBounds(26, 39, 50, 14);
		add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Arial", Font.PLAIN, 12));
		textField_2.setColumns(10);
		textField_2.setBounds(81, 36, 232, 20);
		add(textField_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(26, 64, 377, 129);
		add(scrollPane_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(47, 298, 639, 129);
		add(scrollPane_2);

	}
}
