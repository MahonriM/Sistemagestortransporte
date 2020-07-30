import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class TipoEmpleado extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	Connection conexion = null;
	PreparedStatement preparedSatatement=null;
	ResultSet resultSet = null;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TipoEmpleado frame = new TipoEmpleado();
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
	public TipoEmpleado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("INGRESA ID TIPO EMPLEADO");
		lblNewLabel.setBounds(27, 31, 156, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(193, 28, 109, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("DESCRIPCION");
		lblNewLabel_1.setBounds(55, 67, 76, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setText("");
		textField_1.setBounds(156, 64, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("BUSCAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexion = Conexion.getconexion();
				try {
					preparedSatatement= conexion.prepareStatement("select Descripcion from Tipo_Empleado where idTipoEmpleado=?");
					preparedSatatement.setString(1, textField.getText());
					resultSet=preparedSatatement.executeQuery();
					if(resultSet.next()) {
						textField_1.setText(resultSet.getString("Descripcion"));
					}else {
						JOptionPane.showConfirmDialog(null, "Codigo articulo no encontrado");
					}
					conexion.close();
				}catch(SQLException ex){
					JOptionPane.showConfirmDialog(null, "Ocurrio un error con acceso a base de datos");
					
				}
			}
		});
		btnNewButton.setBounds(335, 31, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("AGREGAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexion= Conexion.getconexion();
				try {
					CallableStatement comando=conexion.prepareCall("{call sptipoempleadoinsertar(?,?)}");
					comando.setInt(1,Integer.parseInt(textField.getText()));
					comando.setString(2, textField_1.getText());
					comando.execute();
				    conexion.close();
					JOptionPane.showConfirmDialog(null, "Registro Agregado");
					textField_1.setText("");
				} catch(SQLException ex) {
					setTitle(ex.toString());
				}
			}
		});
		btnNewButton_1.setBounds(27, 153, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("MODIFICAR");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexion = Conexion.getconexion();
				try {
					CallableStatement comando=conexion.prepareCall("{call sptipoempleadoactualizar(?,?)}");
					comando.setInt(1,Integer.parseInt(textField.getText()));
					comando.setString(2, textField_1.getText());
					comando.execute();
						JOptionPane.showConfirmDialog(null, "REGISTRO MODIFICADO CORRECTAMENTE");
						conexion.close();
				}catch(SQLException ex) {
					JOptionPane.showConfirmDialog(null, "OCURRIO UN ERRRR CON ACCESO A BASE DE DATOS");
				}
			}
		});
		btnNewButton_2.setBounds(153, 153, 101, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("ELIMINAR");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexion = Conexion.getconexion();
				try {
					preparedSatatement= conexion.prepareStatement("DELETE FROM Tipo_Empleado WHERE idTipoEmpleado=?");
					preparedSatatement.setString(1, textField.getText());
					int resultado= preparedSatatement.executeUpdate();
					if(resultado>0) {
						JOptionPane.showConfirmDialog(null, "REGISTRO ELIMINADO CORRECTAMENTE");
						conexion.close();
					}else{
						JOptionPane.showConfirmDialog(null, "NO SE PUEDE ELIMINAR EL REGISTRO");
					}
				}catch(SQLException ex) {
				JOptionPane.showConfirmDialog(null, "OCURRIO UN ERROR CON EL ACCESO A LA BASE DE DATOS");
				}
			}
		}); 
		btnNewButton_3.setBounds(295, 153, 89, 23);
		contentPane.add(btnNewButton_3);
	}

}
