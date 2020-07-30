import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

public class tipousuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtiduser;
	private JTextField txtdescrip;
	private JTable table;
	public int Idusuario;
	public String Descrip;
	private Connection con;
	private ResultSet rst=null;
	private void Cargar() {
	    DefaultTableModel modeloTabla=(DefaultTableModel) table.getModel();
	    modeloTabla.setRowCount(0);
	    CallableStatement st;
	    ResultSet rs;
	    ResultSetMetaData rsmd;
	    int columnas;
	    try{
	    con=Conexion.getconexion();
	    st=con.prepareCall("{call sptipousuariomostrar()}");
	    rs=st.executeQuery();
	    rsmd=rs.getMetaData();
	    columnas=rsmd.getColumnCount();
	    while(rs.next()){
	    Object[] fila= new Object[columnas];
	    for(int i=0;i<columnas;i++){
	        fila[i]=rs.getObject(i+1);
	    }
	    modeloTabla.addRow(fila);
	    }
	    }
	    catch(SQLException ex){
	        JOptionPane.showMessageDialog(this,"Ha ocurrido un error");
	    }
		
			}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tipousuario frame = new tipousuario();
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
	public tipousuario() {
		setTitle("Tipo de Usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(24, 66, 106, 110);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel IdTipoUsuario = new JLabel("IdTipoUsuario");
		IdTipoUsuario.setBounds(10, 11, 77, 14);
		panel.add(IdTipoUsuario);
		
		JLabel lblNewLabel_1 = new JLabel("Descripcion");
		lblNewLabel_1.setBounds(10, 58, 77, 14);
		panel.add(lblNewLabel_1);
		
		txtiduser = new JTextField();
		txtiduser.setBounds(10, 27, 86, 20);
		panel.add(txtiduser);
		txtiduser.setColumns(10);
		
		txtdescrip = new JTextField();
		txtdescrip.setBounds(10, 83, 86, 20);
		panel.add(txtdescrip);
		txtdescrip.setColumns(10);
		JButton btneliminar = new JButton("Eliminar");
		btneliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				con= Conexion.getconexion();
				CallableStatement stm= con.prepareCall("{call sptipousuarioborrar(?)}");
				stm.setInt(1, Integer.parseInt(txtiduser.getText()));
				stm.execute();
					JOptionPane.showMessageDialog(null,"Registro eliminado con exito");
					Cargar();
			}
			catch(Exception es) {
				JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
				System.out.print(es);
			}
			}
		});
		btneliminar.setBounds(10, 11, 89, 23);
		contentPane.add(btneliminar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				Idusuario=Integer.parseInt(txtiduser.getText());
				Descrip=txtdescrip.getText();
				con=Conexion.getconexion();
				CallableStatement stm= con.prepareCall("{call sptipousuarioactualizar(?,?)}");
				stm.setInt(1,Idusuario);
				stm.setString(2, Descrip);
				stm.execute();
				JOptionPane.showMessageDialog(null, "Registro Actualizado");
				Cargar();
			}
			catch(Exception es) {
				JOptionPane.showMessageDialog(null,"Ha ocurrido un error");
			}
			}
		});
		btnActualizar.setBounds(105, 11, 89, 23);
		contentPane.add(btnActualizar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				Idusuario=Integer.parseInt(txtiduser.getText());
				con=Conexion.getconexion();
				CallableStatement stm= con.prepareCall("{call sptipousuariomostrarporid(?)}");
				stm.setInt(1,Idusuario );
				rst=stm.executeQuery();
				if(rst.next()) {
					txtiduser.setText(rst.getString("idTipoUsuario"));
					txtdescrip.setText(rst.getString("DescripUsuario"));
				}
				else {
					JOptionPane.showMessageDialog(null,"Ha ocurrido un error");
					}
			}
			catch(Exception es) {
				
			}
			}
		});
		btnBuscar.setBounds(204, 11, 89, 23);
		contentPane.add(btnBuscar);
		
		JButton btnagregar = new JButton("Agregar");
		btnagregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				Idusuario=Integer.parseInt(txtiduser.getText());
				Descrip=txtdescrip.getText();
				Connection con = Conexion.getconexion();
				CallableStatement stm= con.prepareCall("{call sptipousuarioinsertar(?,?)}");
				stm.setInt(1,Idusuario);
				stm.setString(2, Descrip);
				stm.execute();
				JOptionPane.showMessageDialog(null,"Registro Insertado");
				Cargar();
			}
			catch(Exception es) {
				JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
			}
			}
		});
		btnagregar.setBounds(140, 47, 89, 23);
		contentPane.add(btnagregar);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"IdTipoUsuario", "Descripcion"
			}
			
		));
		table.setBounds(181, 100, 329, 139);
		contentPane.add(table);
		Cargar();
	}
}
