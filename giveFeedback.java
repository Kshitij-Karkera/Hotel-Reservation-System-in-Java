import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class giveFeedback extends JFrame implements ActionListener {
    JLabel imageLabel1;
    ImageIcon image1;
    Container container = getContentPane();
    JLabel feedbackLabel = new JLabel("ENTER YOUR FEEDBACK : ");
    JTextArea feedbackTextArea = new JTextArea();
    JPanel panel = new JPanel();
    JButton submitButton = new JButton("SUBMIT");
    String accountStatusLogin = "Login";
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public static void main(String[] args){
      giveFeedback r = new giveFeedback();
    }

  giveFeedback() {
    image1 = new ImageIcon("Hotel logo3.png");
    imageLabel1 = new JLabel(image1);
    imageLabel1.setSize(100, 89);
    imageLabel1.setLocation(10, 7);
    add(imageLabel1);
    
    setLayoutManager();
    setLocationAndSize();
    addComponentsToContainer();
    addActionEvent();

    setTitle("Taj Hotel - FEEDBACK FORM");
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
    feedbackLabel.setBounds(10, 0, 200, 30);
    feedbackTextArea.setBounds(10, 26, 650, 340);
    submitButton.setBounds(280, 380, 100, 40);
}

public void addComponentsToContainer() {
    container.add(panel);
    panel.add(feedbackLabel);
    panel.add(feedbackTextArea);
    panel.add(submitButton);
}

public void addActionEvent() {
    submitButton.addActionListener(this);
}

@Override
  public void actionPerformed(ActionEvent e) { 
    String str = e.getActionCommand();
    
    if(str.equals("SUBMIT")) {
      try {
        con = DriverManager.getConnection("jdbc:ucanaccess://Hotel_Reservation.accdb");
        ps = con.prepareStatement("update User set Feedback = '"+feedbackTextArea.getText()+"' where Account_Status = '"+accountStatusLogin+"'");
        ps.executeUpdate();

        JOptionPane.showMessageDialog(this, "Feedback has been submitted");
        setVisible(false);
                
      } catch (Exception ex) {
        ex.printStackTrace();
      }

    } 
  }
}