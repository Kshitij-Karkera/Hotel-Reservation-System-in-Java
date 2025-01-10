import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class login extends JFrame implements ActionListener {
    JLabel imageLabel1;
    ImageIcon image1;
    Container container = getContentPane();
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JRadioButton adminRButton = new JRadioButton("ADMIN");
    JRadioButton userRButton = new JRadioButton("USER");
    ButtonGroup group = new ButtonGroup();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String pass;
    char [] tempPass;
    String accountStatusLogin = "Login";

    public static void main(String[] args){
      new login();
    }

  login() {
    image1 = new ImageIcon("Hotel logo1.png");
    imageLabel1 = new JLabel(image1);
    imageLabel1.setSize(150, 134);
    imageLabel1.setLocation(320, 30);
    add(imageLabel1);

    setLayoutManager();
    setLocationAndSize();
    addComponentsToContainer();
    addActionEvent();

    setTitle("Taj Hotel - Login Form");
    setLayout(null);
    setVisible(true);
    setResizable(false);
    setLocation(50, 100);
    setIconImage(image1.getImage());
    setSize(800, 500);
    userRButton.setSelected(true);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  }


  public void setLayoutManager() {
    container.setLayout(null);
}

public void setLocationAndSize() {
    userLabel.setBounds(250, 190, 100, 30);
    passwordLabel.setBounds(250, 240, 100, 30);
    userTextField.setBounds(350, 190, 150, 30);
    passwordField.setBounds(350, 240, 150, 30);
    adminRButton.setBounds(540, 180, 150, 30);
    userRButton.setBounds(540, 205, 150, 30);
    loginButton.setBounds(370, 320, 100, 30);
}

public void addComponentsToContainer() {
    container.add(userLabel);
    container.add(passwordLabel);
    container.add(userTextField);
    container.add(passwordField);
    container.add(adminRButton);
    container.add(userRButton);
    group.add(adminRButton);
    group.add(userRButton);
    container.add(loginButton);
}

public void addActionEvent() {
    loginButton.addActionListener(this);
    adminRButton.addActionListener(this);
    userRButton.addActionListener(this);
}

@Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
    
        if (str.equals("LOGIN")) {
            
                if (adminRButton.isSelected()) {

                    try {
                        tempPass = passwordField.getPassword();
                        pass = new String(tempPass);
                        con = DriverManager.getConnection("jdbc:ucanaccess://Hotel_Reservation.accdb");
                        ps = con.prepareStatement("select * from Admin where Username = '"+userTextField.getText()+"'and Password = '"+pass+"'");
                        rs = ps.executeQuery();
                        
                    if (rs.next()) {
                        ps = con.prepareStatement("update Admin set Account_Status = '"+accountStatusLogin+"' where Username = '"+userTextField.getText()+"' and Password = '"+pass+"'");
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(this, "Login Successful");
                        setVisible(false);
                        new homeAdmin().setVisible(true);                
                        
                    } else {
                        JOptionPane.showMessageDialog(this, "Username/Password is incorrect");
                        userTextField.setText("");
                        passwordField.setText("");
                    }

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }   
                } else if (userRButton.isSelected()) {
                    try {
                        tempPass = passwordField.getPassword();
                        pass = new String(tempPass);
                        con = DriverManager.getConnection("jdbc:ucanaccess://Hotel_Reservation.accdb");
                        ps = con.prepareStatement("select * from User where Username = '"+userTextField.getText()+"'and Password = '"+pass+"'");
                        rs = ps.executeQuery();

                    if (rs.next()) {
                        ps = con.prepareStatement("update User set Account_Status = '"+accountStatusLogin+"' where Username = '"+userTextField.getText()+"' and Password = '"+pass+"'");
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(this, "Login Successful");
                        setVisible(false);
                        new home().setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(this, "Username/Password is incorrect");
                        userTextField.setText("");
                        passwordField.setText("");
                    }

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }   
                }
            
        }
     
    }
}