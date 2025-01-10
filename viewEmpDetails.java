import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel; 
import javax.swing.table.TableColumnModel;

public class viewEmpDetails extends JFrame implements ActionListener {
  JLabel imageLabel1;
  ImageIcon image1;
  Container container = getContentPane();
  JButton viewTableButton = new JButton("VIEW");
  JPanel panel = new JPanel();
  String tbcol[] = {"Emp_ID", "Emp_Fullname", "Emp_designation", "Emp_phoneno", "Gender"};
  DefaultTableModel model;
  JTable table;
  TableColumnModel columnModel;
  JScrollPane scroll;

  Connection con;
  PreparedStatement ps;
  ResultSet rs;

    public static void main(String[] args){
      new viewEmpDetails();
    }

  viewEmpDetails() {
    image1 = new ImageIcon("Hotel logo3.png");
    imageLabel1 = new JLabel(image1);
    imageLabel1.setSize(100, 89);
    imageLabel1.setLocation(10, 7);
    add(imageLabel1);

    setLayoutManager();
    setLocationAndSize();
    addComponentsToContainer();
    addActionEvent();

    setTitle("Taj Hotel - EMPLOYEE DETAILS");
    setLayout(null);
    setVisible(true);
    setIconImage(image1.getImage());
    setSize(1000, 700);
    setLocation(490, 150);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  }

  public void setLayoutManager() {
    container.setLayout(null);
    panel.setLayout(null);
    
  }

  public void setLocationAndSize() {
    panel.setBounds(105, 100, 770, 1000);
    panel.setBackground(new Color(252, 203, 69));
    viewTableButton.setBounds(350, 480, 70, 30);
    
  }

  public void addComponentsToContainer() {
    container.add(panel);
    panel.add(viewTableButton);
    
    model = new DefaultTableModel(tbcol, 0);
    table = new JTable(model);
    table.setBounds(10, 10, 900, 450);
    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(100); 
		columnModel.getColumn(1).setPreferredWidth(150);
	  columnModel.getColumn(2).setPreferredWidth(200);
    columnModel.getColumn(3).setPreferredWidth(150);
    columnModel.getColumn(4).setPreferredWidth(127); 

    scroll = new JScrollPane(table);
    scroll.setSize(730, 420);
    scroll.setLocation(20, 20);
    panel.add(scroll);

  }

  public void addActionEvent() {
    viewTableButton.addActionListener(this);
  }

  public void actionPerformed(ActionEvent ae) { 
    String str = ae.getActionCommand();
    
    if(str.equals("VIEW")) {
      try
      {
        con = DriverManager.getConnection("jdbc:ucanaccess://Hotel_Reservation.accdb");
        ps = con.prepareStatement("select Emp_ID, Emp_Fullname, Emp_designation, Emp_phoneno, Gender from Employee");
        rs = ps.executeQuery();

        table.setModel(DbUtils.resultSetToTableModel(rs));
        columnModel = table.getColumnModel();
		    columnModel.getColumn(0).setPreferredWidth(100); 
		    columnModel.getColumn(1).setPreferredWidth(150);
        columnModel.getColumn(2).setPreferredWidth(200);
        columnModel.getColumn(3).setPreferredWidth(150); 
		    columnModel.getColumn(4).setPreferredWidth(127);
	    
      } catch(Exception e) {
        e.printStackTrace();
      }
    } 
  }
}