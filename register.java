import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class register extends JFrame implements ActionListener {
    JLabel imageLabel1;
    ImageIcon image1;
    Container container = getContentPane();
    
    JLabel firstNameLabel = new JLabel("FIRST NAME");
    JLabel lastNameLabel = new JLabel("LAST NAME");
    JLabel emailLabel = new JLabel("EMAIL-ID");
    JLabel phoneLabel = new JLabel("PHONE NO.");
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");

    JTextField firstNameTextField = new JTextField();
    JTextField lastNameTextField = new JTextField();
    JTextField emailTextField = new JTextField();
    JTextField phoneTextField = new JTextField();
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String pass = "";
    char [] tempPass;
    String accountStatusLogout = "Logout";

    JButton submitButton = new JButton("SUBMIT");

    public static void main(String[] args){
      register r = new register();
    }

  register() {
    image1 = new ImageIcon("Hotel logo2.png");
    imageLabel1 = new JLabel(image1);
    imageLabel1.setSize(200, 179);
    imageLabel1.setLocation(70, 110);
    add(imageLabel1);

    setLayoutManager();
    setLocationAndSize();
    addComponentsToContainer();
    addActionEvent();

    setTitle("Taj Hotel - Registration Form");
    setLayout(null);
    setVisible(true);
    setResizable(false);
    setLocation(50, 100);
    setIconImage(image1.getImage());
    setSize(800, 500);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  }


  public void setLayoutManager() {
    container.setLayout(null);
}

public void setLocationAndSize() {
    userLabel.setBounds(350, 245, 100, 30);
    passwordLabel.setBounds(510, 245, 100, 30);
    firstNameLabel.setBounds(350, 65, 100, 30);
    lastNameLabel.setBounds(510, 65, 100, 30);
    emailLabel.setBounds(350, 125, 100, 30);
    phoneLabel.setBounds(350, 185, 100, 30);

    userTextField.setBounds(350, 270, 150, 30);
    passwordField.setBounds(510, 270, 150, 30);
    firstNameTextField.setBounds(350, 90, 150, 30);
    lastNameTextField.setBounds(510, 90, 150, 30);
    emailTextField.setBounds(350, 150, 310, 30);
    phoneTextField.setBounds(350, 210, 310, 30);
    submitButton.setBounds(350, 330, 310, 30);
}

public void addComponentsToContainer() {
    container.add(userLabel);
    container.add(passwordLabel);
    container.add(firstNameLabel);
    container.add(lastNameLabel);
    container.add(emailLabel);
    container.add(phoneLabel);

    container.add(userTextField);
    container.add(passwordField);
    container.add(firstNameTextField);
    container.add(lastNameTextField);
    container.add(emailTextField);
    container.add(phoneTextField);
    container.add(submitButton);
}

public void addActionEvent() {
    submitButton.addActionListener(this);
}

@Override
    public void actionPerformed(ActionEvent e) { 
        
        String str = e.getActionCommand();
    
        if(str.equals("SUBMIT")) {
            try {
                tempPass = passwordField.getPassword();
                pass = new String(tempPass);
                con = DriverManager.getConnection("jdbc:ucanaccess://Hotel_Reservation.accdb");
                ps = con.prepareStatement("insert into User (Username, Password, Firstname, Lastname, EmailID, Phoneno, Account_Status) values ('"+userTextField.getText()+"', '"+pass+"', '"+firstNameTextField.getText()+"', '"+lastNameTextField.getText()+"', '"+emailTextField.getText()+"', '"+phoneTextField.getText()+"', '"+accountStatusLogout+"')");
                ps.executeUpdate();

                JOptionPane.showMessageDialog(this, "Your account has been registered");
                userTextField.setText("");
                passwordField.setText("");
                setVisible(false);
                
            } catch (Exception ex) {
                ex.printStackTrace();
            }    
            
        }

    }
}