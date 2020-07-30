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

public class Empresa extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

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
					Empresa frame = new Empresa();
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
	public Empresa() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID EMPRESA");
		lblNewLabel.setBounds(10, 23, 70, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(90, 20, 117, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("NOMBRE");
		lblNewLabel_1.setBounds(10, 54, 50, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(90, 51, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexion= Conexion.getconexion();
				try {

					CallableStatement comando= conexion.prepareCall("{call sp_empresainsertar(?,?,?,?,?,?)}");
					comando.setInt(1,Integer.parseInt(textField.getText()));
					comando.setString(2, textField_1.getText());
					comando.setString(3, textField_2.getText());
					comando.setString(4, textField_3.getText());
					comando.setString(5,textField_4.getText());
					comando.setString(6,textField_5.getText());
				    comando.execute();
					JOptionPane.showConfirmDialog(null, "Registro Agregado");
					textField.setText("");
					textField_1.setText("");
				} catch(SQLException ex) {
					setTitle(ex.toString());
				}
			}
		});
		btnNewButton.setBounds(28, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Borrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexion = Conexion.getconexion();
				try {
					CallableStatement stm = conexion.prepareCall("{call spempresaborrar(?)}");
					stm.setInt(1, Integer.parseInt(textField.getText()));
					int resultado= stm.executeUpdate();
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
		btnNewButton_1.setBounds(160, 227, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Modificar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexion = Conexion.getconexion();
				try {
					CallableStatement comando= conexion.prepareCall("{call spempresaactualizar(?,?,?,?,?,?)}");
					comando.setInt(1,Integer.parseInt(textField.getText()));
					comando.setString(2, textField_1.getText());
					comando.setString(3, textField_2.getText());
					comando.setString(4, textField_3.getText());
					comando.setString(5,textField_4.getText());
					comando.setString(6,textField_5.getText());
				    comando.execute();
					JOptionPane.showConfirmDialog(null, "Registro modificado con exito!");				}
				catch(SQLException ex) {
					JOptionPane.showConfirmDialog(null, "OCURRIO UN ERRRR CON ACCESO A BASE DE DATOS");
				}
			}
		});
		btnNewButton_2.setBounds(307, 227, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Buscar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexion = Conexion.getconexion();
				try {
					preparedSatatement= conexion.prepareStatement("select e.Nombre,e.Colonia,e.Calle,e.NoExterior,e.Telefono from Empresa e where e.idEmpresa=?");
					preparedSatatement.setInt(1, Integer.parseInt(textField.getText()));
					resultSet=preparedSatatement.executeQuery();
					if(resultSet.next()) {
						textField_1.setText(resultSet.getString("Nombre"));;
						textField_2.setText(resultSet.getString("Colonia"));
						textField_3.setText(resultSet.getString("Calle"));;
						textField_4.setText(resultSet.getString("NoExterior"));
						textField_5.setText(resultSet.getString("Telefono"));
					}else {
						JOptionPane.showConfirmDialog(null, "id empresa articulo no encontrado");
					}
					conexion.close();
				}catch(SQLException ex){
					JOptionPane.showConfirmDialog(null, "Ocurrio un error con acceso a base de datos");
					
				}
			}
		});
		btnNewButton_3.setBounds(240, 19, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_2 = new JLabel("COLONIA");
		lblNewLabel_2.setBounds(10, 89, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(90, 86, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("CALLE");
		lblNewLabel_3.setBounds(10, 130, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(90, 127, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("No EXTERIOR");
		lblNewLabel_4.setBounds(10, 162, 70, 14);
		contentPane.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setText("");
		textField_4.setBounds(90, 158, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("TELEFONO");
		lblNewLabel_5.setBounds(14, 202, 66, 14);
		contentPane.add(lblNewLabel_5);
		
		textField_5 = new JTextField();
		textField_5.setText("");
		textField_5.setBounds(90, 196, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
	}
}
