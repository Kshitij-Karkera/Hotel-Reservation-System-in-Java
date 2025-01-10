import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class addRoom extends JFrame implements ActionListener {
    JLabel imageLabel1;
    ImageIcon image1;
      
    JLabel roomNoLabel = new JLabel("ROOM NUMBER");
    JLabel roomTypeLabel = new JLabel("ROOM TYPE");
    JLabel roomChargeLabel = new JLabel("ROOM PRICE");
    JLabel roomAvailabilityLabel = new JLabel("ROOM AVAILABILITY");
    JLabel swimmingPoolLabel = new JLabel("SWIMMING POOL");
    JLabel spaLabel = new JLabel("SPA");
    JLabel butlerLabel = new JLabel("BUTLER");
    JLabel bedTypeLabel = new JLabel("BED TYPE");

    JTextField roomNoTextField = new JTextField("Example - 1001");
    JTextField roomChargeTextField = new JTextField("Example - 2000");
    JTextField bedTypeTextField = new JTextField();

    JComboBox<String> roomTypeComboBox = new JComboBox<String>(new String[]  {"Single Room", "Double Room", "Triple Room", "Quad Room", "Twin Room", "Double Twin Room","Studio Room","Executive Suite","Presidential Suite"});
    JComboBox<String> bedTypeComboBox = new JComboBox<String>(new String[] {"Single", "Twin XL", "Double", "Sofa Bed", "Sofa Bed + Twin XL", "Queen", "King"});

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

    JButton addRoomButton = new JButton("ADD ROOM");
    JButton cancelButton = new JButton("CANCEL");

    Connection con;
    PreparedStatement ps;

    public static void main(String[] args){
      addRoom r = new addRoom();
    }

  addRoom() {
    image1 = new ImageIcon("Hotel logo3.png");
    imageLabel1 = new JLabel(image1);
    imageLabel1.setSize(100, 89);
    imageLabel1.setLocation(10, 7);
    add(imageLabel1);

    setLayoutManager();
    setLocationAndSize();
    addComponentsToContainer();
    addActionEvent();

    setTitle("Taj Hotel - ADD ROOM");
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
    panel.setLayout(null);
}

public void setLocationAndSize() {
    panel.setBounds(105, 100, 670, 460);
    panel.setBackground(new Color(252, 203, 69));

    roomNoLabel.setBounds(80, 40, 100, 30);
    roomTypeLabel.setBounds(250, 105, 100, 30);
    roomChargeLabel.setBounds(440, 40, 100, 30);
    roomAvailabilityLabel.setBounds(80, 120, 120, 30);
    swimmingPoolLabel.setBounds(80, 240, 120, 30);
    spaLabel.setBounds(490, 240, 120, 30);
    butlerLabel.setBounds(490, 120, 120, 30);
    bedTypeLabel.setBounds(250, 200, 100, 30);
    
    roomNoTextField.setBounds(80, 65, 150, 30);
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

    addRoomButton.setBounds(230, 350, 100, 40);
    cancelButton.setBounds(350, 350, 100, 40);
  
}

public void addComponentsToContainer() {
    add(panel);
    panel.add(roomNoLabel);
    panel.add(roomTypeLabel);
    panel.add(roomChargeLabel);
    panel.add(roomAvailabilityLabel);
    panel.add(swimmingPoolLabel);
    panel.add(spaLabel);
    panel.add(butlerLabel);
    panel.add(bedTypeLabel);

    panel.add(roomNoTextField);
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

    panel.add(addRoomButton);
    panel.add(cancelButton);
}

public void addActionEvent() {
    roomTypeComboBox.addActionListener(this);
    bedTypeComboBox.addActionListener(this);
    addRoomButton.addActionListener(this);
    cancelButton.addActionListener(this);
}

  public void actionPerformed(ActionEvent ae) { 
    String str = ae.getActionCommand();
    
    if (str.equals("ADD ROOM")) {
      try {
        String roomAvailability = null;
        String swimmingPool = null;
        String spa = null;
        String butler = null;
        
        if (availableRButton.isSelected()) {
          roomAvailability = "Available";
        } else if (occupiedRButton.isSelected()) {
          roomAvailability = "Occupied";
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
        ps = con.prepareStatement("insert into Rooms (Roomno, Room_type, Room_charge, Room_availability, Bed_Type, Swimming_Pool, Spa, Butler) values ('"+roomNoTextField.getText()+"', '"+roomTypeComboBox.getSelectedItem()+"', '"+roomChargeTextField.getText()+"', '"+roomAvailability+"', '"+bedTypeComboBox.getSelectedItem()+"', '"+swimmingPool+"', '"+spa+"', '"+butler+"')");
        ps.executeUpdate();

        JOptionPane.showMessageDialog(null, "New room has been created");
        setVisible(false);
              
      } catch (Exception ex) {
        ex.printStackTrace();
      }

    } else if (str.equals("CANCEL")) {
      setVisible(false);
    }
  }
}