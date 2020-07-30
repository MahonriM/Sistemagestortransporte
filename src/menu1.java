import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;

public class menu1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu1 frame = new menu1();
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
	public menu1() {
		setBackground(new Color(255, 102, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton TiposUsuario = new JButton("Tipos de usuario");
		TiposUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			tipousuario tp= new tipousuario();
			tp.show();
			
			}
		});
		TiposUsuario.setBounds(124, 94, 152, 23);
		contentPane.add(TiposUsuario);
		
		JButton btnUsuario = new JButton("Usuario");
		btnUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario usr= new Usuario();
				usr.show();
			}
		});
		btnUsuario.setBounds(150, 60, 89, 23);
		contentPane.add(btnUsuario);
		
		JButton btnEmpleado = new JButton("Empleado");
		btnEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmEmpleado emp = new frmEmpleado();
				emp.show();
			}
		});
		btnEmpleado.setBounds(97, 136, 201, 23);
		contentPane.add(btnEmpleado);
		
		JLabel lblNewLabel = new JLabel("Bienvenido Administrador");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel.setBounds(124, 11, 184, 28);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_3 = new JButton("TipoEmpleado");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			TipoEmpleado te= new TipoEmpleado();
			te.show();
			}
		});
		btnNewButton_3.setBounds(150, 170, 152, 23);
		contentPane.add(btnNewButton_3);
	}

}
