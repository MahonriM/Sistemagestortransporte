import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.Empleado;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Usuario extends JFrame {
	private JPanel contentPane;
	private JTextField txtid;
	private JTextField txtnom;
	private JTextField txtpass;
	private Connection con;
	private JComboBox cmbid;
	private ResultSet rst;
	private JTextField txtusr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usuario frame = new Usuario();
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
	public Usuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("Idusuario");
		lblNewLabel.setBounds(28, 45, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(28, 76, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setBounds(28, 113, 46, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("TipoUsuario");
		lblNewLabel_1_1_1.setBounds(28, 138, 80, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		txtid = new JTextField();
		txtid.setBounds(84, 42, 86, 20);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		txtnom = new JTextField();
		txtnom.setColumns(10);
		txtnom.setBounds(94, 73, 86, 20);
		contentPane.add(txtnom);
		
		txtpass = new JTextField();
		txtpass.setColumns(10);
		txtpass.setBounds(84, 110, 86, 20);
		contentPane.add(txtpass);
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=0;
				String nm="";
				String pas="";
				String user="";
				try {
					id=Integer.parseInt(txtid.getText());
					nm=txtnom.getText();
					pas=txtpass.getText();
					user=txtusr.getText();
				 Connection con = Conexion.getconexion();
				 CallableStatement stm=con.prepareCall("{call spusuarioinsertar(?,?,?,?)}");
			     stm.setInt(1,id);
			     stm.setString(2,nm);
			     stm.setString(3, pas);
			     stm.setString(4, user);
			     stm.execute();
			     JOptionPane.showMessageDialog(null, "Registo insetado con exito!");
			}
			catch(Exception es) {
				JOptionPane.showMessageDialog(null,"Favor de comprobar la informacion correspondiente");
				System.out.print(es);
			}
			}
		});
		btnNewButton.setBounds(10, 192, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int id=Integer.parseInt(txtid.getText());
					String nm=txtnom.getText();
					String pas=txtpass.getText();
					String user=txtusr.getText();
				 Connection con = Conexion.getconexion();
				 CallableStatement stm=con.prepareCall("{call spusuarioactualizar(?,?,?,?)}");
			     stm.setInt(1,id);
			     stm.setString(2,nm);
			     stm.setString(3, pas);
			     stm.setString(4, user);
			     stm.execute();
			     JOptionPane.showMessageDialog(null, "Registo actualizado con exito!");
			}
			catch(Exception es) {
				JOptionPane.showMessageDialog(null,"Favor de comprobar la informacion correspondiente");
				System.out.print(es);
			}
			}
		});
		btnActualizar.setBounds(120, 192, 89, 23);
		contentPane.add(btnActualizar);
		
		JButton btnNewButton_1_1 = new JButton("Eliminar");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				con =Conexion.getconexion();
				CallableStatement stm=con.prepareCall("{call spusuarioborrar(?)}");
				stm.setInt(1, Integer.parseInt(txtid.getText()));
				stm.execute();
				JOptionPane.showMessageDialog(null,"Registro eliminado");
			}
			catch(Exception es) {
				JOptionPane.showMessageDialog(null,"Favor de comprobar la informacion correspondiente");
			}
			}
		});
		btnNewButton_1_1.setBounds(222, 192, 89, 23);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Buscar");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con= Conexion.getconexion();
					PreparedStatement cstm=null;
					cstm=con.prepareStatement("select u.NombreUs,u.Password,u.TipoUsuario  from usuario u where u.idUsuario=?");
					cstm.setInt(1, Integer.parseInt(txtid.getText()));
					ResultSet rst=null;
					rst=cstm.executeQuery();
					if(rst.next()) {
						txtnom.setText(rst.getString("NombreUs"));
						txtpass.setText(rst.getString("Password"));
						txtusr.setText(rst.getString("TipoUsuario"));
						}
					else {
						JOptionPane.showMessageDialog(null,"No se eencontro el empleado");
					}
					con.close();
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Ha ocurrido un error"+ex);
					System.out.print("Ha ocurrido un error"+ex);
				}

			}
		});
		btnNewButton_1_1_1.setBounds(180, 41, 89, 23);
		contentPane.add(btnNewButton_1_1_1);
		
		txtusr = new JTextField();
		txtusr.setColumns(10);
		txtusr.setBounds(118, 135, 86, 20);
		contentPane.add(txtusr);
		
	}
}
