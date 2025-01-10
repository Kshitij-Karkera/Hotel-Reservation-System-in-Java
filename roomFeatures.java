import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel; 
import javax.swing.table.TableColumnModel;

public class roomFeatures extends JFrame implements ActionListener {
  JLabel imageLabel1;
  ImageIcon image1;
  Container container = getContentPane();
  JButton viewTableButton = new JButton("VIEW");
  JPanel panel = new JPanel();
  String tbcol[] = {"Room no", "Room type", "Room charge", "Room availability", "Bed type", "Swimmng pool", "Spa", "Butler"};
  DefaultTableModel model;
  JTable table;
  TableColumnModel columnModel;
  JScrollPane scroll;

  Connection con;
  PreparedStatement ps;
  ResultSet rs;

    public static void main(String[] args){
      new roomFeatures();
    }

  roomFeatures() {
    image1 = new ImageIcon("Hotel logo3.png");
    imageLabel1 = new JLabel(image1);
    imageLabel1.setSize(100, 89);
    imageLabel1.setLocation(10, 7);
    add(imageLabel1);

    setLayoutManager();
    setLocationAndSize();
    addComponentsToContainer();
    addActionEvent();

    setTitle("Taj Hotel - ROOMS");
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
		columnModel.getColumn(1).setPreferredWidth(120);
	  columnModel.getColumn(2).setPreferredWidth(100);
    columnModel.getColumn(3).setPreferredWidth(150);
    columnModel.getColumn(4).setPreferredWidth(130); 
		columnModel.getColumn(5).setPreferredWidth(110);
	  columnModel.getColumn(6).setPreferredWidth(60);
	  columnModel.getColumn(7).setPreferredWidth(80);
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
        String a = "Available";
        con = DriverManager.getConnection("jdbc:ucanaccess://Hotel_Reservation.accdb");
        ps = con.prepareStatement("select * from Rooms where Room_availability = '"+a+"'");
        rs = ps.executeQuery();

        table.setModel(DbUtils.resultSetToTableModel(rs));
        columnModel = table.getColumnModel();
		    columnModel.getColumn(0).setPreferredWidth(100); 
		    columnModel.getColumn(1).setPreferredWidth(120);
        columnModel.getColumn(2).setPreferredWidth(100);
        columnModel.getColumn(3).setPreferredWidth(150); 
		    columnModel.getColumn(4).setPreferredWidth(130);
	      columnModel.getColumn(5).setPreferredWidth(110);
	      columnModel.getColumn(6).setPreferredWidth(60);
	      columnModel.getColumn(7).setPreferredWidth(80);
        
      } catch(Exception e) {
        e.printStackTrace();
      }
    } 
  }
}