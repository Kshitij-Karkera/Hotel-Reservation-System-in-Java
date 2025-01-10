import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class javaproject extends JFrame implements ActionListener {

  JLabel imageLabel1, imageLabel2;
  ImageIcon image1, image2;
  JButton btn1, btn2;

  javaproject() {
    image1 = new ImageIcon("Hotel.png");
    imageLabel1 = new JLabel(image1);
    imageLabel1.setSize(200, 179);
    imageLabel1.setLocation(155, 110);
    
    image2 = new ImageIcon("Welcome.png");
    imageLabel2 = new JLabel(image2);
    imageLabel2.setSize(200, 75);
    imageLabel2.setLocation(460, 150);
    
    btn1 = new JButton("Login");
    btn1.setSize(90,40);
    btn1.setLocation(455, 250);
    btn2 = new JButton("Register");
    btn2.setSize(90,40);
    btn2.setLocation(555, 250);

    add(imageLabel1);
    add(imageLabel2);
    add(btn1);
    add(btn2);

    btn1.addActionListener(this);
    btn2.addActionListener(this);

    setTitle("Taj Hotel - Welcome");
    setLayout(null);
    setVisible(true);
    setResizable(false);
    setLocation(50, 100);
    setIconImage(image1.getImage());
    setSize(800, 500);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public void actionPerformed(ActionEvent ae) {
    String str = ae.getActionCommand();

    if(str.equals("Login")) {
      new login();
      
    } else if (str.equals("Register")) {
      new register();
    }
  }

  public static void main(String[] args) {
    new javaproject();

    String databaseURL = "jdbc:ucanaccess://Hotel_Reservation.accdb";

    try {
      Connection conn = DriverManager.getConnection(databaseURL);

      System.out.println("Connected to the Database");

      conn.close();
    } catch (SQLException e) {
      
    } 
  }
}
