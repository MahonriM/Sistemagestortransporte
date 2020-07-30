import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InformacionEquipo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InformacionEquipo frame = new InformacionEquipo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InformacionEquipo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Martinez Dimas Mahonri 1796763");
		lblNewLabel.setBounds(126, 49, 239, 52);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Ir al Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			principal pl = new principal();
			pl.show();			
			}
		});
		btnNewButton.setBounds(172, 206, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Salazar Longoria Wendy Yadira 1830411");
		lblNewLabel_1.setBounds(106, 87, 273, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mendoza Rios Luis Fernando 1730611");
		lblNewLabel_2.setBounds(116, 112, 191, 14);
		contentPane.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		panel.setBounds(76, 11, 281, 37);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl = new JLabel("Integrantes del equipo");
		lbl.setBounds(64, 11, 140, 22);
		panel.add(lbl);
		lbl.setForeground(new Color(128, 0, 0));
	}
}
