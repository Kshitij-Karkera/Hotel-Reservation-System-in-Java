import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class updateProfile extends JFrame implements ActionListener {
    JLabel imageLabel1;
    ImageIcon image1;
    Container container = getContentPane();
    
    JLabel roomIDLabel = new JLabel("ENTER THE ROOM ID ASSIGNED TO THE CUSTOMER");
    JLabel firstNameLabel = new JLabel("FIRST NAME");
    JLabel lastNameLabel = new JLabel("LAST NAME");
    JLabel checkInLabel = new JLabel("CHECK IN");
    JLabel checkOutLabel = new JLabel("CHECK OUT");
    JLabel phoneNoLabel = new JLabel("PHONE NO");
    JLabel emailIDLabel = new JLabel("EMAIL ID");

    JTextField roomIDTextField = new JTextField("");
    JTextField firstNameTextField = new JTextField("");
    JTextField lastNameTextField = new JTextField("");
    JTextField checkInTextField = new JTextField("dd-mm-yyyy");
    JTextField checkOutTextField = new JTextField("dd-mm-yyyy");
    JTextField phoneNoTextField = new JTextField("");
    JTextField emailIDTextField = new JTextField("");

    JPanel panel = new JPanel();

    JButton updateProfileButton = new JButton("UPDATE PROFILE");
    JButton cancelButton = new JButton("CANCEL");
    JButton getButton = new JButton("GET");

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String pass = "";
    char [] tempPass;

    public static void main(String[] args){
      updateProfile r = new updateProfile();
    }

  updateProfile() {
    image1 = new ImageIcon("Hotel logo3.png");
    imageLabel1 = new JLabel(image1);
    imageLabel1.setSize(100, 89);
    imageLabel1.setLocation(10, 7);
    add(imageLabel1);

    setLayoutManager();
    setLocationAndSize();
    addComponentsToContainer();
    addActionEvent();

    setTitle("Taj Hotel - UPDATE PROFILE");
    setLayout(null);
    setVisible(true);
    setIconImage(image1.getImage());
    setSize(900, 600);
    setLocation(490, 150);
    setResizable(false);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  }

  public void setLayoutManager() {
    container.setLayout(null);
    panel.setLayout(null);
}

public void setLocationAndSize() {
    panel.setBounds(105, 100, 670, 1000);
    panel.setBackground(new Color(252, 203, 69));

    roomIDLabel.setBounds(250, 20, 290, 30);
    firstNameLabel.setBounds(100, 80, 100, 30);
    lastNameLabel.setBounds(400, 80, 100, 30);
    checkInLabel.setBounds(100, 150, 100, 30);
    checkOutLabel.setBounds(400, 150, 100, 30);
    phoneNoLabel.setBounds(100, 220, 100, 30);
    emailIDLabel.setBounds(400, 220, 100, 30);
    
    roomIDTextField.setBounds(250, 45, 150, 30);
    firstNameTextField.setBounds(100, 105, 150, 30);
    lastNameTextField.setBounds(400, 105, 150, 30);
    checkInTextField.setBounds(100, 175, 150, 30);
    checkOutTextField.setBounds(400, 175, 150, 30);
    phoneNoTextField.setBounds(100, 245, 150, 30);
    emailIDTextField.setBounds(400, 245, 150, 30);

    updateProfileButton.setBounds(190, 340, 140, 40);
    cancelButton.setBounds(350, 340, 100, 40);
    getButton.setBounds(500, 45, 100, 30);
}

public void addComponentsToContainer() {
    container.add(panel);
    container.add(roomIDLabel);
    container.add(getButton);
    container.add(roomIDTextField);

    panel.add(firstNameLabel);
    panel.add(lastNameLabel);
    panel.add(checkInLabel);
    panel.add(checkOutLabel);
    panel.add(phoneNoLabel);
    panel.add(emailIDLabel);

    panel.add(firstNameTextField);
    panel.add(lastNameTextField);
    panel.add(checkInTextField);
    panel.add(checkOutTextField);
    panel.add(phoneNoTextField);
    panel.add(emailIDTextField);

    panel.add(updateProfileButton);
    panel.add(cancelButton);
}

public void addActionEvent() {
    updateProfileButton.addActionListener(this);
    getButton.addActionListener(this);
    cancelButton.addActionListener(this);
}

@Override
  public void actionPerformed(ActionEvent e) { 
    String str = e.getActionCommand();
    
    if(str.equals("GET")) {
      try {
        con = DriverManager.getConnection("jdbc:ucanaccess://Hotel_Reservation.accdb");
        ps = con.prepareStatement("select * from User where Room_ID = '"+roomIDTextField.getText()+"'");
        rs = ps.executeQuery();

        while (rs.next()) {
    
          firstNameTextField.setText(rs.getString("Firstname"));
          lastNameTextField.setText(rs.getString("Lastname"));
          checkInTextField.setText(rs.getString("Check_in"));
          checkOutTextField.setText(rs.getString("Check_out"));
          phoneNoTextField.setText(rs.getString("Phoneno"));
          emailIDTextField.setText(rs.getString("EmailID"));

        }

      } catch (Exception ex) {
        ex.printStackTrace();
      }

    } else if (str.equals("UPDATE PROFILE")) {
      try {
        String firstNameDB = firstNameTextField.getText();
        String lastNameDB = lastNameTextField.getText();
        String roomIDDB = roomIDTextField.getText();
        String checkInDB = checkInTextField.getText();
        String checkOutDB = checkOutTextField.getText();
        String phoneNoDB = phoneNoTextField.getText();
        String emailIDDB = emailIDTextField.getText();

        con = DriverManager.getConnection("jdbc:ucanaccess://Hotel_Reservation.accdb");
        ps = con.prepareStatement("update User set Firstname = '"+firstNameDB+"', Lastname = '"+lastNameDB+"', EmailID = '"+emailIDDB+"', Phoneno = '"+phoneNoDB+"', Check_in = '"+checkInDB+"', Check_out = '"+checkOutDB+"' where Room_ID = '"+roomIDDB+"'");
        ps.executeUpdate();

        JOptionPane.showMessageDialog(this, "The profile has been updated");
        setVisible(false);

      } catch (Exception ex) {
        ex.printStackTrace();
      }

    } else if (str.equals("CANCEL")) {
      setVisible(false);
    }
  }
}