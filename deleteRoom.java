import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class deleteRoom extends JFrame implements ActionListener {
    JLabel imageLabel1;
    ImageIcon image1;
    Container container = getContentPane();
      
    JLabel roomNoDeleteLabel = new JLabel("ENTER A ROOM NUMBER TO DELETE");

    JTextField roomNoDeleteTextField = new JTextField("");

    JPanel panel = new JPanel();

    JButton deleteRoomButton = new JButton("DELETE ROOM");
    JButton cancelButton = new JButton("CANCEL");

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public static void main(String[] args){
      deleteRoom r = new deleteRoom();
    }

  deleteRoom() {
    image1 = new ImageIcon("Hotel logo3.png");
    imageLabel1 = new JLabel(image1);
    imageLabel1.setSize(100, 89);
    imageLabel1.setLocation(10, 7);
    add(imageLabel1);

    setLayoutManager();
    setLocationAndSize();
    addComponentsToContainer();
    addActionEvent();

    setTitle("Taj Hotel - DELETE ROOM");
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

    roomNoDeleteLabel.setBounds(230, 100, 240, 30);
    roomNoDeleteTextField.setBounds(250, 125, 150, 30);

    deleteRoomButton.setBounds(200, 250, 120, 40);
    cancelButton.setBounds(340, 250, 100, 40);
}

public void addComponentsToContainer() {
    container.add(panel);

    panel.add(roomNoDeleteLabel);
    panel.add(roomNoDeleteTextField);

    panel.add(deleteRoomButton);
    panel.add(cancelButton);
}

public void addActionEvent() {
    deleteRoomButton.addActionListener(this);
    cancelButton.addActionListener(this);
}

@Override
  public void actionPerformed(ActionEvent e) { 
    String str = e.getActionCommand();
    
    if (str.equals("DELETE ROOM")) {
      try {
        String roomNoDeleteDB = roomNoDeleteTextField.getText();

        con = DriverManager.getConnection("jdbc:ucanaccess://Hotel_Reservation.accdb");
        ps = con.prepareStatement("delete from Rooms where Roomno = '"+roomNoDeleteDB+"'");
        ps.executeUpdate();

        JOptionPane.showMessageDialog(this, "The room has been deleted");
        setVisible(false);

      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
  }
}