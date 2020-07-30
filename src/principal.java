import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.SystemColor;

public class principal extends JFrame {

	private JPanel contentPane;
	private JTextField txtuser;
	private JPasswordField txtpass;
	private String usuario="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					principal frame = new principal();
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
	public principal() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);		
		JButton btnlogin = new JButton("Entrar");
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 Connection con=Conexion.getconexion();
			 usuario=txtuser.getText();
			 try {
     		 ResultSet bol;
			 CallableStatement st = con.prepareCall("{call spusuariologin(?,?)}");
			 st.setInt(1,Integer.parseInt(usuario));
			 st.setString(2, txtpass.getText());
			 bol=st.executeQuery();
			 if(bol!=null) {
				 if(Integer.parseInt(usuario)==106) {
					principal frm = new principal();
					 frm.dispose(); 
				menu1 frae = new menu1();
				frae.show();}
				 else if(Integer.parseInt(usuario)==104) {
					 //Empresa
					 frmEmpresa fm = new frmEmpresa();
					 fm.show();
				 }
				 else if(Integer.parseInt(usuario)==105) {
					 //Empleado
					 frmEmp2 emp2= new frmEmp2();
					 emp2.show();
				 }
			}
			 else {
				 JOptionPane.showMessageDialog(null, "Uusario o password incorrectos intenta de nuevo");
			 }
			 }
			 catch(Exception ex) {
				 JOptionPane.showMessageDialog(null, "Valida tu informacion ");
				
			}

			}
		});
		btnlogin.setBounds(335, 29, 89, 23);
		contentPane.add(btnlogin);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setForeground(SystemColor.textHighlight);
		panel.setBounds(18, 20, 278, 144);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setBounds(44, 14, 46, 14);
		panel.add(lblNewLabel);
		
		txtuser = new JTextField();
		txtuser.setBounds(131, 11, 86, 20);
		panel.add(txtuser);
		txtuser.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a");
		lblNewLabel_1.setBounds(28, 64, 62, 14);
		panel.add(lblNewLabel_1);
		
		txtpass = new JPasswordField();
		txtpass.setBounds(123, 61, 94, 20);
		panel.add(txtpass);
		
		JButton btnNewButton = new JButton("Integrantes Equipo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//frame.dispose();
				InformacionEquipo frme = new InformacionEquipo();
				frme.setVisible(true);;
			}
		});
		btnNewButton.setBounds(54, 194, 154, 23);
		contentPane.add(btnNewButton);
	}
}
