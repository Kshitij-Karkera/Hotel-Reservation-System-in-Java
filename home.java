import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class home extends JFrame implements ActionListener {
    ImageIcon image1;
    ImageIcon image3 = new ImageIcon("Taj_hotel.jpeg");
    JLabel imageLabel1;
    JLabel imageLabel3 = new JLabel(image3);
    Container container = getContentPane();
    
    ImageIcon image2 = new ImageIcon("logout.png");
    JButton logoutButton = new JButton("LOGOUT", image2);
    JButton roomsButton = new JButton("ROOMS");
    JButton roomFeaturesButton = new JButton("ROOM FEATURES");
    JButton bookARoomButton = new JButton("BOOK A ROOM");
    JButton servicesButton = new JButton("SERVICES");
    JButton submitFeedbackButton = new JButton("SUBMIT FEEDBACK");
    JButton updateProfileButton = new JButton("UPDATE PROFILE");

    String accountStatusLogout = "Logout";
    String accountStatusLogin = "Login";

    Connection con;
    PreparedStatement ps;

    JLabel logoutLabel = new JLabel("LOGOUT");

    JPanel panel = new JPanel();

    public static void main(String[] args){
      home r = new home();
    }

  home() {
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

    setTitle("Taj Hotel - Home");
    setLayout(null);
    setVisible(true);
    setIconImage(image1.getImage());
    setSize(800, 500);
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
    roomsButton.setBounds(120, 150, 180, 50);
    roomFeaturesButton.setBounds(120, 250, 180, 50);
    bookARoomButton.setBounds(120, 350, 180, 50);
    servicesButton.setBounds(120, 450, 180, 50);
    submitFeedbackButton.setBounds(120, 550, 180, 50);
    updateProfileButton.setBounds(120, 650, 180 , 50);
}

public void addComponentsToContainer() {
    container.add(logoutButton);
    container.add(logoutLabel);
    container.add(panel);
    panel.add(roomsButton);
    panel.add(roomFeaturesButton);
    panel.add(bookARoomButton);
    panel.add(servicesButton);
    panel.add(submitFeedbackButton);
    panel.add(updateProfileButton);
    panel.add(imageLabel3);
}

public void addActionEvent() {
    logoutButton.addActionListener(this);
    roomsButton.addActionListener(this);
    roomFeaturesButton.addActionListener(this);
    bookARoomButton.addActionListener(this);
    servicesButton.addActionListener(this);
    submitFeedbackButton.addActionListener(this);
    updateProfileButton.addActionListener(this);
}

@Override
    public void actionPerformed(ActionEvent e) { 
        String str = e.getActionCommand();
    
        if (str.equals("ROOMS")) {
            new rooms().setVisible(true);  

        } else if (str.equals("ROOM FEATURES")) {
            new roomFeatures().setVisible(true);   
        
        } else if (str.equals("BOOK A ROOM")) {
            new bookARoom().setVisible(true);   
        
        } else if (str.equals("SERVICES")) {
            new services().setVisible(true);   

        } else if (str.equals("SUBMIT FEEDBACK")) {
            new giveFeedback().setVisible(true);   
        
        } else if (str.equals("UPDATE PROFILE")) {
            new updateProfileUser().setVisible(true);  
        
        } else if (str.equals("LOGOUT")) {
            try {
                con = DriverManager.getConnection("jdbc:ucanaccess://Hotel_Reservation.accdb");
                ps = con.prepareStatement("update User set Account_Status = '"+accountStatusLogout+"' where Account_Status = '"+accountStatusLogin+"'");
                ps.executeUpdate();
                setVisible(false);
                new login().setVisible(true);
            } catch (Exception ex) {

            }
        }
    }
}