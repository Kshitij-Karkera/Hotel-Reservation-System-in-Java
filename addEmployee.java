import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class addEmployee extends JFrame implements ActionListener {
    JLabel imageLabel1;
    ImageIcon image1;
    Container container = getContentPane();
      
    JLabel empIDLabel = new JLabel("EMPLOYEE ID");
    JLabel empNameLabel = new JLabel("EMPLOYEE FULL NAME");
    JLabel phoneNoLabel = new JLabel("PHONE NUMBER");

    JTextField empIDTextField = new JTextField("EMPID");
    JTextField empNameTextField = new JTextField("EMPNAME");
    JTextField phoneNoTextField = new JTextField("PHONENO");

    JLabel empDesigLabel = new JLabel("EMPLOYEE DESIGNATION");
    String empDesig[] = {"Receptionist", "Bellboy", "Housekeeping", "Kitchen Staff", "Room Service", "Waiter", "Waitress", "Manager", "Accountant", "Chef"};
    JComboBox<String> empDesigComboBox = new JComboBox<String>(empDesig);

    JLabel genderLabel = new JLabel("GENDER");
    JRadioButton maleRButton = new JRadioButton("Male");
    JRadioButton femaleRButton = new JRadioButton("Female");
    ButtonGroup group = new ButtonGroup();

    JPanel panel = new JPanel();

    JButton addEmployeeButton = new JButton("ADD EMPLOYEE");
    JButton cancelButton = new JButton("CANCEL");

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public static void main(String[] args){
      addEmployee r = new addEmployee();
    }

  addEmployee() {
    image1 = new ImageIcon("Hotel logo3.png");
    imageLabel1 = new JLabel(image1);
    imageLabel1.setSize(100, 89);
    imageLabel1.setLocation(10, 7);
    add(imageLabel1);

    setLayoutManager();
    setLocationAndSize();
    addComponentsToContainer();
    addActionEvent();

    setTitle("Taj Hotel - ADD EMPLOYEE");
    setLayout(null);
    setVisible(true);
    setIconImage(image1.getImage());
    setSize(900, 600);
    setResizable(false);
    setLocation(490, 150);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  }

  public void setLayoutManager() {
    container.setLayout(null);
    panel.setLayout(null);
}

public void setLocationAndSize() {
    panel.setBounds(105, 100, 670, 1000);
    panel.setBackground(new Color(252, 203, 69));

    empIDLabel.setBounds(100, 40, 100, 30);
    empNameLabel.setBounds(400, 40, 130, 30);
    phoneNoLabel.setBounds(400, 150, 100, 30);
    empDesigLabel.setBounds(100, 150, 150, 30);
    genderLabel.setBounds(280, 230, 120, 30);
    
    empIDTextField.setBounds(100, 65, 150, 30);
    empDesigComboBox.setBounds(100, 175, 130, 30);
    empNameTextField.setBounds(400, 65, 150, 30);
    phoneNoTextField.setBounds(400, 175, 150, 30);

    maleRButton.setBounds(280, 255, 80, 30);
    femaleRButton.setBounds(280, 280, 80, 30);

    addEmployeeButton.setBounds(190, 350, 130, 40);
    cancelButton.setBounds(340, 350, 100, 40);
}

public void addComponentsToContainer() {
    container.add(panel);
    panel.add(empIDLabel);
    panel.add(empNameLabel);
    panel.add(phoneNoLabel);
    panel.add(genderLabel);
    panel.add(empDesigLabel);

    panel.add(empIDTextField);
    panel.add(empDesigComboBox);
    panel.add(empNameTextField);
    panel.add(phoneNoTextField);

    panel.add(maleRButton);
    panel.add(femaleRButton);
    group.add(maleRButton);
    group.add(femaleRButton);

    panel.add(addEmployeeButton);
    panel.add(cancelButton);
}

public void addActionEvent() {
    empDesigComboBox.addActionListener(this);
    addEmployeeButton.addActionListener(this);
    cancelButton.addActionListener(this);
}

@Override
  public void actionPerformed(ActionEvent e) { 
    String str = e.getActionCommand();
    
    if (str.equals("ADD EMPLOYEE")) {
      try {
        String genderDB = null;
        String empIDDB = null;
        
        if (maleRButton.isSelected()) {
          genderDB = "Male";
        } else if (femaleRButton.isSelected()) {
          genderDB = "Female";
        }
        con = DriverManager.getConnection("jdbc:ucanaccess://Hotel_Reservation.accdb");
        con.setReadOnly(false);
        ps = con.prepareStatement("insert into Employee (Emp_ID, Emp_fullname, Emp_designation, Emp_phoneno, Gender) values ('"+empIDTextField.getText()+"','"+empNameTextField.getText()+"', '"+empDesigComboBox.getSelectedItem()+"', '"+phoneNoTextField.getText()+"', '"+genderDB+"')");
        ps.executeUpdate();

        JOptionPane.showMessageDialog(this, "New employee has been added");
        setVisible(false);
                
      } catch (Exception ex) {
        ex.printStackTrace();
      }

    } else if (str.equals("CANCEL")) {
      setVisible(false);
    }
  }
}