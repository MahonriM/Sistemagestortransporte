import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import Clases.Empleado;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
public class frmEmpleado extends JFrame {
    private Empleado emp;
	private JPanel contentPane;
	private JTextField txtidemp;
	private JTextField txtnombre;
	private JTextField txtapp;
	private JTextField txtapm;
	private JTextField txtcol;
	private JTextField txtcalle;
	private JTextField txtnocasa;
	private JTextField txttel;
	private JTextField txtfecha;
	private JTextField txtsueldo;
	private JTextField txtmun;
	private JTextField txtidpuesto;
	private JTextField txttur;
	private Connection con;
	private ResultSet rst;
	private JComboBox cmbemp;
	private JComboBox cmbcivil;
	private JComboBox cmbsexo;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmEmpleado frame = new frmEmpleado();
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

	public void Fillcombo() {
		try {
			con= Conexion.getconexion();
			String sql ="select distinct(idEmpresa) from empleado";
			PreparedStatement stm=con.prepareStatement(sql);
			rst=stm.executeQuery();
			while(rst.next()) {
			cmbemp.addItem(rst.getString("idEmpresa"));
			}		
		}
		catch(Exception ex) {
		}}
	public void fillcmbemp() {
		try {
			con= Conexion.getconexion();
			String sql ="select idEmpresa from empleado where idempleado=?";
			PreparedStatement stm=con.prepareStatement(sql);
			stm.setInt(1,Integer.parseInt(txtidemp.getText()));
			rst=stm.executeQuery();
			while(rst.next()) {
			cmbemp.addItem(rst.getString("idEmpresa"));
		}}
		catch(Exception ex) {
			
		}
	}
	public void Fillcombse() {
		try {
			con= Conexion.getconexion();
			String sql ="select sexo from empleado where idempleado=?";
			PreparedStatement stm=con.prepareStatement(sql);
			stm.setInt(1,Integer.parseInt(txtidemp.getText()));
			rst=stm.executeQuery();
			while(rst.next()) {
				cmbsexo.addItem(rst.getString("sexo"));
			}		
		}
		catch(Exception ex) {
		}}
	public void Fillcomcivil() {
		try {
			con= Conexion.getconexion();
			String sql ="select EstadoCivil from empleado where idempleado=?";
			PreparedStatement stm=con.prepareStatement(sql);
			stm.setInt(1,Integer.parseInt(txtidemp.getText()));
			rst=stm.executeQuery();
			while(rst.next()) {
			cmbcivil.addItem(rst.getString("EstadoCivil"));
			}		
		}
		catch(Exception ex) {
		}
	}

	public frmEmpleado() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 0));
		panel.setBounds(10, 11, 306, 422);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(10, 34, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Apellido Materno");
		lblNewLabel_1.setBounds(10, 70, 93, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Colonia");
		lblNewLabel_1_1.setBounds(10, 98, 46, 14);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Calle");
		lblNewLabel_1_2.setBounds(10, 123, 46, 14);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("NoCasa");
		lblNewLabel_1_3.setBounds(10, 152, 46, 14);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Telefono");
		lblNewLabel_1_4.setBounds(10, 178, 46, 14);
		panel.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Sexo");
		lblNewLabel_1_5.setBounds(10, 203, 46, 14);
		panel.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Fecha Nacimiento");
		lblNewLabel_1_6.setBounds(16, 258, 87, 14);
		panel.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("Turno");
		lblNewLabel_1_7.setBounds(10, 308, 46, 14);
		panel.add(lblNewLabel_1_7);
		
		JLabel lblNewLabel_1_7_1 = new JLabel("EstadoCivil");
		lblNewLabel_1_7_1.setBounds(20, 228, 70, 14);
		panel.add(lblNewLabel_1_7_1);
		
		JLabel lblNewLabel_1_7_2 = new JLabel("Sueldo");
		lblNewLabel_1_7_2.setBounds(10, 283, 46, 14);
		panel.add(lblNewLabel_1_7_2);
		
		JLabel lblNewLabel_1_7_2_1 = new JLabel("idPuesto");
		lblNewLabel_1_7_2_1.setBounds(10, 333, 46, 14);
		panel.add(lblNewLabel_1_7_2_1);
		
		JLabel lblNewLabel_1_7_2_1_1 = new JLabel("Municipio");
		lblNewLabel_1_7_2_1_1.setBounds(10, 358, 46, 14);
		panel.add(lblNewLabel_1_7_2_1_1);
		
		JLabel lblNewLabel_1_7_2_1_1_1 = new JLabel("idEmpresa");
		lblNewLabel_1_7_2_1_1_1.setBounds(10, 383, 87, 14);
		panel.add(lblNewLabel_1_7_2_1_1_1);
		
		JLabel IdEmpleado = new JLabel("idEmpleado");
		IdEmpleado.setBounds(10, 11, 70, 14);
		panel.add(IdEmpleado);
		
		JLabel lblNewLabel_1_7_2_1_1_3 = new JLabel("ApellidoPaterno");
		lblNewLabel_1_7_2_1_1_3.setBounds(100, 48, 87, 14);
		panel.add(lblNewLabel_1_7_2_1_1_3);
		
		txtidemp = new JTextField();
		txtidemp.setBounds(90, 8, 86, 20);
		panel.add(txtidemp);
		txtidemp.setColumns(10);
		
		txtnombre = new JTextField();
		txtnombre.setColumns(10);
		txtnombre.setBounds(90, 31, 86, 20);
		panel.add(txtnombre);
		
		txtapp = new JTextField();
		txtapp.setColumns(10);
		txtapp.setBounds(186, 45, 86, 20);
		panel.add(txtapp);
		
		txtapm = new JTextField();
		txtapm.setColumns(10);
		txtapm.setBounds(110, 67, 86, 20);
		panel.add(txtapm);
		
		txtcol = new JTextField();
		txtcol.setColumns(10);
		txtcol.setBounds(66, 95, 86, 20);
		panel.add(txtcol);
		
		txtcalle = new JTextField();
		txtcalle.setColumns(10);
		txtcalle.setBounds(49, 123, 86, 20);
		panel.add(txtcalle);
		
		txtnocasa = new JTextField();
		txtnocasa.setColumns(10);
		txtnocasa.setBounds(49, 148, 86, 20);
		panel.add(txtnocasa);
		
		txttel = new JTextField();
		txttel.setColumns(10);
		txttel.setBounds(66, 175, 86, 20);
		panel.add(txttel);
		
		JComboBox cmbsexo = new JComboBox();
		cmbsexo.setModel(new DefaultComboBoxModel(new String[] {"M", "F"}));
		cmbsexo.setBounds(37, 203, 98, 14);
		panel.add(cmbsexo);

		JComboBox cmbcivil = new JComboBox();
		cmbcivil.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		cmbcivil.setBounds(82, 227, 55, 20);
		panel.add(cmbcivil);
		
		txtfecha = new JTextField();
		txtfecha.setColumns(10);
		txtfecha.setBounds(113, 255, 86, 20);
		panel.add(txtfecha);
		
		txtsueldo = new JTextField();
		txtsueldo.setColumns(10);
		txtsueldo.setBounds(49, 277, 86, 20);
		panel.add(txtsueldo);
		
		txtmun = new JTextField();
		txtmun.setColumns(10);
		txtmun.setBounds(82, 355, 86, 20);
		panel.add(txtmun);
		cmbemp= new JComboBox();
		cmbemp.addContainerListener(new ContainerAdapter() {
			@Override
			public void componentAdded(ContainerEvent e) {
		
			}
			//Aqui va en el combo

		});
		cmbemp.setBounds(107, 380, 55, 20);
		panel.add(cmbemp);
		Fillcombo();
		txtidpuesto = new JTextField();
		txtidpuesto.setColumns(10);
		txtidpuesto.setBounds(66, 330, 86, 20);
		panel.add(txtidpuesto);
		
		txttur = new JTextField();
		txttur.setColumns(10);
		txttur.setBounds(49, 305, 86, 20);
		panel.add(txttur);
		
		JButton btneliminar = new JButton("Eliminar");
		btneliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			emp= new Empleado();
			emp.idEmpleado=Integer.parseInt(txtidemp.getText());
			
			try {
			Connection con = Conexion.getconexion();
			CallableStatement st = con.prepareCall("{call sp_empleado_delete(?)}");
			st.setInt(1, emp.idEmpleado);
			st.execute();
			JOptionPane.showMessageDialog(null, "Registro eliminado");
			txtidemp.setText("");
			}
			catch(Exception es) {JOptionPane.showMessageDialog(null,"Ha ocurrido un error");}
			}
		});
		
		btneliminar.setBounds(186, 279, 89, 23);
		panel.add(btneliminar);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {  
				try {
					  Empleado emp1=new Empleado();
					  emp1.idEmpleado=Integer.parseInt(txtidemp.getText());
					  emp1.nombre=txtnombre.getText();
					  emp1.apellidoP=txtapp.getText();
					  emp1.apellidoM=txtapm.getText();
					  emp1.colonia=txtcol.getText();
					  emp1.calle=txtcalle.getText();
					  emp1.noCasa=txtnocasa.getText();
					  emp1.telefono=txttel.getText();
					  emp1.sexo=cmbsexo.getSelectedItem().toString();
					  emp1.estadoCivil=cmbcivil.getSelectedItem().toString();
					  emp1.fecNacimiento=txtfecha.getText();
					  emp1.sueldo=txtsueldo.getText();
					  emp1.turno=Integer.parseInt(txttur.getText());
					  emp1.puesto=Integer.parseInt(txtidpuesto.getText());
					  emp1.nommun=txtmun.getText();
					  emp1.Empresa=Integer.parseInt(cmbemp.getSelectedItem().toString());
				Connection con = Conexion.getconexion();
				CallableStatement st = con.prepareCall("{call sp_empleado_insertar(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				st.setInt(1, emp1.idEmpleado);
				st.setString(2, emp1.nombre);
				st.setString(3,emp1.apellidoP);
				st.setString(4,emp1.apellidoM );
				st.setString(5, emp1.colonia);
				st.setString(6, emp1.calle);
				st.setString(7,emp1.noCasa);
				st.setString(8,emp1.telefono );
				st.setString(9, emp1.sexo);
				st.setString(10, emp1.estadoCivil);
				st.setString(11,emp1.fecNacimiento);
				st.setString(12,emp1.sueldo);
				st.setInt(13, emp1.turno);
				st.setInt(14, emp1.puesto);
				st.setString(15,emp1.nommun);
				st.setInt(16,emp1.Empresa);
				st.execute();
				JOptionPane.showMessageDialog(null, "Registro insertado con exito");
				
			}
			catch(Exception es) {
				JOptionPane.showMessageDialog(null, "No se pudo realizar la operacion"+es);
			}
			}
		});
		btnAgregar.setBounds(186, 304, 89, 23);
		panel.add(btnAgregar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					  Empleado emp1=new Empleado();
					  emp1.idEmpleado=Integer.parseInt(txtidemp.getText());
					  emp1.nombre=txtnombre.getText();
					  emp1.apellidoP=txtapp.getText();
					  emp1.apellidoM=txtapm.getText();
					  emp1.colonia=txtcol.getText();
					  emp1.calle=txtcalle.getText();
					  emp1.noCasa=txtnocasa.getText();
					  emp1.telefono=txttel.getText();
					  emp1.sexo=cmbsexo.getSelectedItem().toString();
					  emp1.estadoCivil=cmbcivil.getSelectedItem().toString();
					  emp1.fecNacimiento=txtfecha.getText();
					  emp1.sueldo=txtsueldo.getText();
					  emp1.turno=Integer.parseInt(txttur.getText());
					  emp1.puesto=Integer.parseInt(txtidpuesto.getText());
					  emp1.nommun=txtmun.getText();
					  emp1.Empresa=Integer.parseInt(cmbemp.getSelectedItem().toString());
				Connection con = Conexion.getconexion();
				CallableStatement st = con.prepareCall("{call sp_empleado_actualizar(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				st.setInt(1, emp1.idEmpleado);
				st.setString(2, emp1.nombre);
				st.setString(3,emp1.apellidoP);
				st.setString(4,emp1.apellidoM );
				st.setString(5, emp1.colonia);
				st.setString(6, emp1.calle);
				st.setString(7,emp1.noCasa);
				st.setString(8,emp1.telefono );
				st.setString(9, emp1.sexo);
				st.setString(10, emp1.estadoCivil);
				st.setString(11,emp1.fecNacimiento);
				st.setString(12,emp1.sueldo);
				st.setInt(13, emp1.turno);
				st.setInt(14, emp1.puesto);
				st.setString(15,emp1.nommun);
				st.setInt(16,emp1.Empresa);
				st.execute();
				JOptionPane.showMessageDialog(null, "Registro actualizado con exito");
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "No se pudo realizar la operacion");
				}
			}
		});
		btnActualizar.setBounds(186, 329, 89, 23);
		panel.add(btnActualizar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				txtnombre.setText("");
				txtapp.setText("");
				txtapm.setText("");
				txtcalle.setText("");
				txtcol.setText("");
				Empleado emp2=new Empleado();
				emp2.idEmpleado=Integer.parseInt(txtidemp.getText());
				Connection con= Conexion.getconexion();
//				CallableStatement cstm=con.prepareCall("{sp_empleado_mostrarporid(?)}");
				PreparedStatement cstm=null;
				cstm=con.prepareStatement(""
						+ "select e.Nombre,e.ApellidoP,ApellidoM,e.Calle,e.Colonia,e.telefono,e.NoCasa,e.FecNacimiento,e.sueldo,e.nombrmun,e.Turno,e.idPuesto\r\n" + 
						"from Empleado e WHERE e.idEmpleado=?");
				cstm.setInt(1, Integer.parseInt(txtidemp.getText()));
				ResultSet rst=null;
				rst=cstm.executeQuery();
				if(rst.next()) {
					txtnombre.setText(rst.getString("Nombre"));
					txtapp.setText(rst.getString("ApellidoP"));
					txtapm.setText(rst.getString("ApellidoM"));
					txtcalle.setText(rst.getString("Calle"));
					txtcol.setText(rst.getString("Colonia"));
					txtnocasa.setText(rst.getString("NoCasa"));
					txttel.setText(rst.getString("telefono"));
					Fillcombse();
					txtfecha.setText(rst.getString("FecNacimiento"));
					txtsueldo.setText(rst.getString("sueldo"));
					txttur.setText(rst.getString("turno"));
                    txtidpuesto.setText(rst.getString("idpuesto"));
			        txtmun.setText(rst.getString("nombrmun"));
			        Fillcomcivil();
			        fillcmbemp();
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
		btnBuscar.setBounds(186, 7, 89, 23);
		panel.add(btnBuscar);
		
	}
	
}
