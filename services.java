import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class services extends JFrame {
    JLabel imageLabel1;
    ImageIcon image1;
    Container container = getContentPane();
    JPanel panel = new JPanel();
    JLabel lineOneLabel = new JLabel("SERVICES");
    JLabel dashLabel = new JLabel("-----------------------------------------------------");
    JLabel lineTwoLabel = new JLabel("1. CONFERENCE ROOM");
    JLabel lineThreeLabel = new JLabel("2. LIVE ORCHESTRA");
    JLabel lineFourLabel = new JLabel("3. AUDITORIUM");
    JLabel lineFiveLabel = new JLabel("4. SWIMMING POOL");
    JLabel lineSixLabel = new JLabel("5. JACUZI AND SPA");
    JLabel lineSevenLabel = new JLabel("6. INDOOR GAMES");
    JLabel lineEightLabel = new JLabel("7. BADMINTON COURT");
    JLabel lineNineLabel = new JLabel("8. BASKETBALL  COURT");
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public static void main(String[] args){
     services r = new services();
    }

 services() {
    image1 = new ImageIcon("Hotel logo3.png");
    imageLabel1 = new JLabel(image1);
    imageLabel1.setSize(100, 89);
    imageLabel1.setLocation(10, 7);
    add(imageLabel1);

    setLayoutManager();
    setLocationAndSize();
    addComponentsToContainer();

    setTitle("Taj Hotel - SERVICES");
    setLayout(null);
    setVisible(true);
    setIconImage(image1.getImage());
    setSize(900, 600);
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
    lineOneLabel.setBounds(140, 40, 200, 30);
    dashLabel.setBounds(70, 60, 600, 30);
    lineTwoLabel.setBounds(100, 90, 200, 30);
    lineThreeLabel.setBounds(100, 130, 200, 30);
    lineFourLabel.setBounds(100, 170, 200, 30);
    lineFiveLabel.setBounds(100, 210, 200, 30);
    lineSixLabel.setBounds(100, 250, 200, 30);
    lineSevenLabel.setBounds(100, 290, 200, 30);
    lineEightLabel.setBounds(100, 330, 200, 30);
    lineNineLabel.setBounds(100, 370, 200, 30);
    
}

public void addComponentsToContainer() {
    container.add(panel);
    panel.add(lineOneLabel);
    panel.add(dashLabel);
    panel.add(lineTwoLabel);
    panel.add(lineThreeLabel);
    panel.add(lineFourLabel);
    panel.add(lineFiveLabel);
    panel.add(lineSixLabel);
    panel.add(lineSevenLabel);
    panel.add(lineEightLabel);
    panel.add(lineNineLabel);
    
}
}