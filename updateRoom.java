import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class updateRoom extends JFrame implements ActionListener {
    JLabel imageLabel1;
    ImageIcon image1;
    Container container = getContentPane();
      
    JLabel roomNoLabel = new JLabel("ENTER A ROOM NUMBER TO BE UPDATED");
    JLabel roomNoUpdateLabel = new JLabel("NEW ROOM NUMBER");
    JLabel roomTypeLabel = new JLabel("ROOM TYPE");
    JLabel roomChargeLabel = new JLabel("NEW ROOM PRICE");
    JLabel roomAvailabilityLabel = new JLabel("ROOM AVAILABILITY");
    JLabel swimmingPoolLabel = new JLabel("SWIMMING POOL");
    JLabel spaLabel = new JLabel("SPA");
    JLabel butlerLabel = new JLabel("BUTLER");
    JLabel bedTypeLabel = new JLabel("NEW BED TYPE");

    JTextField roomNoTextField = new JTextField("");
    JTextField roomNoUpdateTextField = new JTextField("");
    JTextField roomChargeTextField = new JTextField("");
    JTextField bedTypeTextField = new JTextField();

    String roomTypes[] = {"Single Room", "Double Room", "Triple Room", "Quad Room", "Twin Room", "Double Twin Room","Studio Room","Executive Suite","Presidential Suite"};
    String bedTypes[] = {"Single", "Twin XL", "Double", "Sofa Bed", "Sofa Bed + Twin XL", "Queen", "King"};
    JComboBox<String> roomTypeComboBox = new JComboBox<String>(roomTypes);
    JComboBox<String> bedTypeComboBox = new JComboBox<String>(bedTypes);

    JRadioButton availableRButton = new JRadioButton("Available");
    JRadioButton occupiedRButton = new JRadioButton("Occupied");
    ButtonGroup group = new ButtonGroup();

    JRadioButton swimPoolRButtonYes = new JRadioButton("Yes");
    JRadioButton swimPoolRButtonNo = new JRadioButton("No");
    ButtonGroup group2 = new ButtonGroup();

    JRadioButton spaRButtonYes = new JRadioButton("Yes");
    JRadioButton spaRButtonNo = new JRadioButton("No");
    ButtonGroup group3 = new ButtonGroup();

    JRadioButton butlerRButtonYes = new JRadioButton("Yes");
    JRadioButton butlerRButtonNo = new JRadioButton("No");
    ButtonGroup group4 = new ButtonGroup();

    JPanel panel = new JPanel();

    JButton updateRoomButton = new JButton("UPDATE ROOM");
    JButton cancelButton = new JButton("CANCEL");
    JButton getButton = new JButton("GET");

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public static void main(String[] args){
      updateRoom r = new updateRoom();
    }

  updateRoom() {
    image1 = new ImageIcon("Hotel logo3.png");
    imageLabel1 = new JLabel(image1);
    imageLabel1.setSize(100, 89);
    imageLabel1.setLocation(10, 7);
    add(imageLabel1);

    setLayoutManager();
    setLocationAndSize();
    addComponentsToContainer();
    addActionEvent();

    setTitle("Taj Hotel - UPDATE ROOM");
    setLayout(null);
    setVisible(true);
    setIconImage(image1.getImage());
    setSize(900, 600);
    setLocation(490, 150);
    setResizable(false);
    availableRButton.setSelected(true);
    swimPoolRButtonNo.setSelected(true);
    spaRButtonNo.setSelected(true);
    butlerRButtonNo.setSelected(true);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  }

  public void setLayoutManager() {
    container.setLayout(null);
    panel.setLayout(null);
}

public void setLocationAndSize() {
    panel.setBounds(105, 100, 670, 1000);
    panel.setBackground(new Color(252, 203, 69));

    roomNoLabel.setBounds(250, 20, 240, 30);
    roomNoUpdateLabel.setBounds(80, 40, 150, 30);
    roomTypeLabel.setBounds(250, 105, 100, 30);
    roomChargeLabel.setBounds(440, 40, 150, 30);
    roomAvailabilityLabel.setBounds(80, 120, 120, 30);
    swimmingPoolLabel.setBounds(80, 240, 120, 30);
    spaLabel.setBounds(490, 240, 120, 30);
    butlerLabel.setBounds(490, 120, 120, 30);
    bedTypeLabel.setBounds(250, 200, 100, 30);
    
    roomNoTextField.setBounds(250, 45, 150, 30);
    roomNoUpdateTextField.setBounds(80, 65, 150, 30);
    roomTypeComboBox.setBounds(250, 130, 170, 30);
    roomChargeTextField.setBounds(440, 65, 150, 30);
    bedTypeComboBox.setBounds(250, 225, 170, 30);

    availableRButton.setBounds(80, 150, 100, 30);
    occupiedRButton.setBounds(80, 175, 100, 30);

    swimPoolRButtonYes.setBounds(80, 270, 100, 30);
    swimPoolRButtonNo.setBounds(80, 295, 100, 30);

    spaRButtonYes.setBounds(490, 270, 100, 30);
    spaRButtonNo.setBounds(490, 295, 100, 30);

    butlerRButtonYes.setBounds(490, 150, 100, 30);
    butlerRButtonNo.setBounds(490, 175, 100, 30);

    updateRoomButton.setBounds(200, 350, 120, 40);
    cancelButton.setBounds(340, 350, 100, 40);
    getButton.setBounds(500, 45, 100, 30);
}

public void addComponentsToContainer() {
    container.add(panel);
    container.add(roomNoLabel);
    container.add(getButton);

    panel.add(roomNoUpdateLabel);
    panel.add(roomTypeLabel);
    panel.add(roomChargeLabel);
    panel.add(roomAvailabilityLabel);
    panel.add(swimmingPoolLabel);
    panel.add(spaLabel);
    panel.add(butlerLabel);
    panel.add(bedTypeLabel);

    container.add(roomNoTextField);
    panel.add(roomNoUpdateTextField);
    panel.add(roomTypeComboBox);
    panel.add(roomChargeTextField);
    panel.add(bedTypeComboBox);

    panel.add(availableRButton);
    panel.add(occupiedRButton);
    group.add(availableRButton);
    group.add(occupiedRButton);

    panel.add(swimPoolRButtonYes);
    panel.add(swimPoolRButtonNo);
    group2.add(swimPoolRButtonYes);
    group2.add(swimPoolRButtonNo);

    panel.add(spaRButtonYes);
    panel.add(spaRButtonNo);
    group3.add(spaRButtonYes);
    group3.add(spaRButtonNo);

    panel.add(butlerRButtonYes);
    panel.add(butlerRButtonNo);
    group4.add(butlerRButtonYes);
    group4.add(butlerRButtonNo);

    panel.add(updateRoomButton);
    panel.add(cancelButton);
}

public void addActionEvent() {
    roomTypeComboBox.addActionListener(this);
    bedTypeComboBox.addActionListener(this);
    getButton.addActionListener(this);
    updateRoomButton.addActionListener(this);
    cancelButton.addActionListener(this);
}

@Override
  public void actionPerformed(ActionEvent e) { 
    String str = e.getActionCommand();
    
    if(str.equals("GET")) {
      try {
        String roomTypeDB = roomTypeComboBox.getSelectedItem().toString();
        String bedTypeDB = bedTypeComboBox.getSelectedItem().toString();

        con = DriverManager.getConnection("jdbc:ucanaccess://Hotel_Reservation.accdb");
        ps = con.prepareStatement("select * from Rooms where Roomno = '"+roomNoTextField.getText()+"'");
        rs = ps.executeQuery();

        while (rs.next()) {
          roomNoUpdateTextField.setText(rs.getString("Roomno"));
          roomChargeTextField.setText(rs.getString("Room_charge"));
          roomTypeComboBox.removeAllItems();
          roomTypeComboBox.addItem(rs.getString("Room_type"));

          bedTypeComboBox.removeAllItems();
          bedTypeComboBox.addItem(rs.getString("Bed_type"));
          bedTypeComboBox.addItem("Single");
          bedTypeComboBox.addItem("Twin XL");
          bedTypeComboBox.addItem("Double");
          bedTypeComboBox.addItem("Sofa Bed");
          bedTypeComboBox.addItem("Sofa Bed + Twin XL");
          bedTypeComboBox.addItem("Queen");
          bedTypeComboBox.addItem("King");

          String roomAvailabilityDB = rs.getString("Room_availability");
          if (roomAvailabilityDB.equals("Available")) {
            availableRButton.setSelected(true);
            occupiedRButton.setSelected(false);
          } else if (roomAvailabilityDB.equals("Occupied")) {
            availableRButton.setSelected(false);
            occupiedRButton.setSelected(true);
          }

          String swimmingPoolDB = rs.getString("Swimming_Pool");
          if (swimmingPoolDB.equals("Yes")) {
            swimPoolRButtonYes.setSelected(true);
            swimPoolRButtonNo.setSelected(false);
          } else if (swimmingPoolDB.equals("No")) {
            swimPoolRButtonYes.setSelected(false);
            swimPoolRButtonNo.setSelected(true);
          }

          String spaDB = rs.getString("Spa");
          if (spaDB.equals("Yes")) {
            spaRButtonYes.setSelected(true);
            spaRButtonNo.setSelected(false);
          } else if (roomAvailabilityDB.equals("No")) {
            spaRButtonYes.setSelected(false);
            spaRButtonNo.setSelected(true);
          }

          String butlerDB = rs.getString("Butler");
          if (butlerDB.equals("Yes")) {
            butlerRButtonYes.setSelected(true);
            butlerRButtonNo.setSelected(false);
          } else if (roomAvailabilityDB.equals("No")) {
            butlerRButtonYes.setSelected(false);
            butlerRButtonNo.setSelected(true);
          }
        }

      } catch (Exception ex) {
        ex.printStackTrace();
      }

    } else if (str.equals("UPDATE ROOM")) {
      try {
        String swimmingPool = null;
        String spa = null;
        String butler = null;
        String bedTypeDB = bedTypeComboBox.getSelectedItem().toString();
        String roomChargeDB = roomChargeTextField.getText();
        String roomNoDB = roomNoTextField.getText();
        String roomAvailabilityDB = null;
        
        if (availableRButton.isSelected()) {
          roomAvailabilityDB = "Available";
        } else if (occupiedRButton.isSelected()) {
          roomAvailabilityDB = "Occupied";
        }
        
        if (swimPoolRButtonYes.isSelected()) {
          swimmingPool = "Yes";
        } else if (swimPoolRButtonNo.isSelected()) {
          swimmingPool = "No";
        }

        if (spaRButtonYes.isSelected()) {
          spa = "Yes";
        } else if (spaRButtonNo.isSelected()) {
          spa = "No";
        }

        if (butlerRButtonYes.isSelected()) {
          butler = "Yes";
        } else if (butlerRButtonNo.isSelected()) {
          butler = "No";
        }

        con = DriverManager.getConnection("jdbc:ucanaccess://Hotel_Reservation.accdb");
        ps = con.prepareStatement("update Rooms set Room_charge = '"+roomChargeDB+"', Room_availability = '"+roomAvailabilityDB+"', Bed_Type = '"+bedTypeDB+"', Swimming_Pool = '"+swimmingPool+"', Spa = '"+spa+"', Butler = '"+butler+"' where Roomno = '"+roomNoDB+"'");
        ps.executeUpdate();

        JOptionPane.showMessageDialog(null, "The room has been updated");
        setVisible(false);
              
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    } else if (str.equals("CANCEL")) {
      setVisible(false);
    }
  }
}