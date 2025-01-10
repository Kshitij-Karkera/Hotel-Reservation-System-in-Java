import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class homeAdmin extends JFrame implements ActionListener {
    ImageIcon image1;
    ImageIcon image3 = new ImageIcon("Taj_hotel.jpeg");
    JLabel imageLabel1;
    JLabel imageLabel3 = new JLabel(image3);
    Container container = getContentPane();
    
    ImageIcon image2 = new ImageIcon("logout.png");
    JButton logoutButton = new JButton("LOGOUT", image2);
    JButton addRoomButton = new JButton("ADD ROOM");
    JButton updateRoomButton = new JButton("UPDATE ROOM");
    JButton deleteRoomButton = new JButton("DELETE ROOM");
    JButton showFeedbackButton = new JButton("SHOW FEEDBACK");
    JButton updateProfileButton = new JButton("UPDATE PROFILE");
    JButton viewCustDetailsButton = new JButton("VIEW CUSTOMER DETAILS");
    JButton addEmployeeButton = new JButton("ADD EMPLOYEE");
    JButton viewEmpDetailsButton = new JButton("VIEW EMPLOYEE DETAILS");

    String accountStatusLogout = "Logout";
    String accountStatusLogin = "Login";

    Connection con;
    PreparedStatement ps;

    JLabel logoutLabel = new JLabel("LOGOUT");

    JPanel panel = new JPanel();

    public static void main(String[] args){
      homeAdmin r = new homeAdmin();
    }

  homeAdmin() {
    image1 = new ImageIcon("Hotel logo2.png");
    imageLabel1 = new JLabel(image1);
    imageLabel1.setSize(200, 179);
    imageLabel1.setLocation(30, 7);
    add(imageLabel1);

    imageLabel3.setSize(1200, 675);
    imageLabel3.setLocation(360, 80);

    setLayoutManager();
    setLocationAndSize();
    addComponentsToContainer();
    addActionEvent();

    setTitle("Taj Hotel - Home(ADMIN)");
    setLayout(null);
    setVisible(true);
    setIconImage(image1.getImage());
    setSize(800, 500);
    setResizable(false);
    setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public void setLayoutManager() {
    container.setLayout(null);
    panel.setLayout(null);
}

public void setLocationAndSize() {
    logoutButton.setBounds(1860, 20, 30, 37);
    logoutLabel.setBounds(1850, 55, 100, 35);
    panel.setBounds(150, 200, 1620, 1000);
    panel.setBackground(new Color(252, 203, 69));
    addRoomButton.setBounds(100, 70, 190, 50);
    updateRoomButton.setBounds(100, 160, 190, 50);
    deleteRoomButton.setBounds(100, 250, 190, 50);
    showFeedbackButton.setBounds(100, 340, 190, 50);
    updateProfileButton.setBounds(100, 430, 190, 50);
    viewCustDetailsButton.setBounds(100, 520, 190, 50);
    addEmployeeButton.setBounds(100, 610, 190, 50);
    viewEmpDetailsButton.setBounds(100, 700, 190, 50);
}

public void addComponentsToContainer() {
    container.add(logoutButton);
    container.add(logoutLabel);
    container.add(panel);
    panel.add(addRoomButton);
    panel.add(updateRoomButton);
    panel.add(deleteRoomButton);
    panel.add(showFeedbackButton);
    panel.add(updateProfileButton);
    panel.add(showFeedbackButton);
    panel.add(updateProfileButton);
    panel.add(viewCustDetailsButton);
    panel.add(addEmployeeButton);
    panel.add(viewEmpDetailsButton);
    panel.add(imageLabel3);
}

public void addActionEvent() {
    logoutButton.addActionListener(this);
    addRoomButton.addActionListener(this);
    updateRoomButton.addActionListener(this);
    deleteRoomButton.addActionListener(this);
    showFeedbackButton.addActionListener(this);
    updateProfileButton.addActionListener(this);
    viewCustDetailsButton.addActionListener(this);
    addEmployeeButton.addActionListener(this);
    viewEmpDetailsButton.addActionListener(this);
}

@Override
  public void actionPerformed(ActionEvent e) { 
    String str = e.getActionCommand();
    
    if(str.equals("ADD ROOM")) {
      new addRoom().setVisible(true);  

    } else if(str.equals("UPDATE ROOM")) {
      new updateRoom().setVisible(true);   
        
    } else if(str.equals("DELETE ROOM")) {
      new deleteRoom().setVisible(true);   
        
    } else if(str.equals("SHOW FEEDBACK")) {
      new showFeedback().setVisible(true);   
        
    } else if(str.equals("UPDATE PROFILE")) {
      new updateProfile().setVisible(true);   
        
    } else if(str.equals("VIEW CUSTOMER DETAILS")) {
      new viewCustDetails().setVisible(true);   
        
    } else if(str.equals("ADD EMPLOYEE")) {
      new addEmployee().setVisible(true);   
        
    } else if(str.equals("VIEW EMPLOYEE DETAILS")) {
      new viewEmpDetails().setVisible(true);   
        
    } else if(str.equals("LOGOUT")) {
      try {
        con = DriverManager.getConnection("jdbc:ucanaccess://Hotel_Reservation.accdb");
        ps = con.prepareStatement("update Admin set Account_Status = '"+accountStatusLogout+"' where Account_Status = '"+accountStatusLogin+"'");
        ps.executeUpdate();
        setVisible(false);
        new login().setVisible(true);
    } catch (Exception ex) {

    }
    }
  }
}