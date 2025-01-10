import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.lang.Long.*;
import javax.swing.text.Document;

public class bookARoom extends JFrame implements ActionListener {
  JLabel imageLabel1;
  ImageIcon image1;
  Container container = getContentPane();
  
  JLabel roomIDLabel = new JLabel("ROOM ID");
  JLabel checkInLabel = new JLabel("CHECK-IN");
  JLabel checkOutLabel = new JLabel("CHECK-OUT");
  JLabel numOfMembersLabel = new JLabel("NO. OF MEMBERS");
  JLabel custDetails = new JLabel("");
  JLabel firstName = new JLabel("");
  JLabel lastName = new JLabel("");
  JLabel emailID = new JLabel("");
  JLabel phoneNo = new JLabel("");
  JLabel dash1 = new JLabel("");
  JLabel dash2 = new JLabel("");
  JLabel nameLabel = new JLabel("");
  JLabel emailIDLabel = new JLabel("");
  JLabel phoneNoLabel = new JLabel("");
  JLabel numOfDays = new JLabel("");
  JLabel numOfMembersLabel2 = new JLabel("");
  JLabel roomCharge = new JLabel("");
  JLabel totalBillLabel = new JLabel("");

  JTextField roomIDTextField = new JTextField();
  JTextField checkInTextField = new JTextField();
  JTextField checkOutTextField = new JTextField();
  JTextField numOfMembersTextField = new JTextField(); 

  JButton bookButton = new JButton("BOOK");
  JButton cancelButton = new JButton("CANCEL");
  JButton proceedToPayButton = new JButton("PROCEED TO PAY");

  JPanel panel = new JPanel();
  Connection con;
  PreparedStatement ps;
  ResultSet rs;

    public static void main(String[] args){
      new bookARoom();
    }

  bookARoom() {
    image1 = new ImageIcon("Hotel logo3.png");
    imageLabel1 = new JLabel(image1);
    imageLabel1.setSize(100, 89);
    imageLabel1.setLocation(10, 7);
    add(imageLabel1);
    
    checkInTextField.setToolTipText("dd-mm-yyyy");
    checkOutTextField.setToolTipText("dd-mm-yyyy");
    
    setLayoutManager();
    setLocationAndSize();
    addComponentsToContainer();
    addActionEvent();

    setTitle("Taj Hotel - BOOK A ROOM");
    setLayout(null);
    setVisible(true);
    setIconImage(image1.getImage());
    setSize(1000, 700);
    setLocation(490, 150);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  }

  public void setLayoutManager() {
    container.setLayout(null);
    panel.setLayout(null);
    
  }

  public void setLocationAndSize() {
    panel.setBounds(105, 100, 770, 1000);
    panel.setBackground(new Color(252, 203, 69));
    roomIDLabel.setBounds(70, 50, 100, 30);
    checkInLabel.setBounds(70, 100, 100, 30);
    checkOutLabel.setBounds(70, 150, 100, 30);
    numOfMembersLabel.setBounds(70, 200, 100, 30);
    custDetails.setBounds(510, 50, 400, 30);
    firstName.setBounds(560, 80, 400, 30);
    lastName.setBounds(600, 80, 400, 30);
    emailID.setBounds(560, 110, 400, 30);
    phoneNo.setBounds(560, 140, 400, 30);
    dash1.setBounds(420, 60, 400, 30);
    dash2.setBounds(420, 155, 400, 30);
    nameLabel.setBounds(460, 80, 400, 30);
    emailIDLabel.setBounds(460, 110, 400, 30);
    phoneNoLabel.setBounds(460, 140, 400, 30);
    numOfMembersLabel2.setBounds(460, 175, 400, 30);
    numOfDays.setBounds(460, 205, 400, 30);
    roomCharge.setBounds(460, 235, 400, 30);
    totalBillLabel.setBounds(460, 265, 400, 30);

    roomIDTextField.setBounds(180, 50, 100, 30);
    checkInTextField.setBounds(180, 100, 100, 30);
    checkOutTextField.setBounds(180, 150, 100, 30);
    numOfMembersTextField.setBounds(180, 200, 100, 30);

    bookButton.setBounds(170, 450, 100, 30);
    cancelButton.setBounds(300, 450, 100, 30);
    proceedToPayButton.setBounds(500, 450, 140, 30);
  }

  public void addComponentsToContainer() {
    container.add(panel);
    panel.add(roomIDLabel);
    panel.add(checkInLabel);
    panel.add(checkOutLabel);
    panel.add(numOfMembersLabel);
    panel.add(custDetails);
    panel.add(dash1);
    panel.add(nameLabel);
    panel.add(firstName);
    panel.add(lastName);
    panel.add(emailIDLabel);
    panel.add(emailID);
    panel.add(phoneNoLabel);
    panel.add(phoneNo);
    panel.add(dash2);
    panel.add(numOfDays);
    panel.add(numOfMembersLabel2);
    panel.add(roomCharge);
    panel.add(totalBillLabel);
    panel.add(roomIDTextField);
    panel.add(checkInTextField);
    panel.add(checkOutTextField);
    panel.add(numOfMembersTextField);
    panel.add(bookButton);
    panel.add(cancelButton);
  }

  public void addActionEvent() {
    bookButton.addActionListener(this);
    cancelButton.addActionListener(this);
    proceedToPayButton.addActionListener(this);
  }

  public void actionPerformed(ActionEvent ae) { 
    String str = ae.getActionCommand();
    
    if(str.equals("BOOK")) {
      String accountStatus = "Login";
      try
      {
        String checkIn = checkInTextField.getText();
        String checkOut = checkOutTextField.getText();
      
        SimpleDateFormat sdfCheckIn = new SimpleDateFormat("dd-mm-yyyy");
        SimpleDateFormat sdfCheckOut = new SimpleDateFormat("dd-mm-yyyy");
      
        Date checkInDate = sdfCheckIn.parse(checkIn);
        Date checkOutDate = sdfCheckOut.parse(checkOut);

        String date1 = sdfCheckIn.format(checkInDate);
        String date2 = sdfCheckOut.format(checkOutDate);
        con = DriverManager.getConnection("jdbc:ucanaccess://Hotel_Reservation.accdb");
        ps = con.prepareStatement("update User set Check_in = '"+date1+"', Check_out = '"+date2+"', Room_ID = '"+roomIDTextField.getText()+"', Members = '"+numOfMembersTextField.getText()+"' where Account_Status = '"+accountStatus+"'");
        ps.executeUpdate();

        Date d1 = sdfCheckIn.parse(checkIn);
        Date d2 = sdfCheckOut.parse(checkOut);
        long diff = d2.getTime() - d1.getTime();
        long diffDays = diff / (24 * 60 * 60 * 1000);
        String diffDaysString = String.valueOf(diffDays);
        numOfDays.setText("NO. OF DAYS :    " + diffDaysString);
        numOfMembersLabel2.setText("NO. OF MEMBERS :    " + numOfMembersTextField.getText());

        ps = con.prepareStatement("select Room_charge from Rooms where Roomno = '"+roomIDTextField.getText()+"'");
        rs = ps.executeQuery();

        while (rs.next()) {
          String billAmountString = rs.getString("Room_charge");
          String numOfMembersString = numOfMembersTextField.getText();
          long numOfMembersLong = Long.parseLong(numOfMembersString);
          long billAmount = Long.parseLong(billAmountString);
          long totalBillAmount = diffDays * numOfMembersLong * billAmount;
          roomCharge.setText("ROOM CHARGE :   " + billAmount);
          totalBillLabel.setText("YOUR TOTAL BILL :   " + totalBillAmount);

        }

        ps = con.prepareStatement("select Firstname, Lastname, EmailID, Phoneno from User");
        rs = ps.executeQuery();

        while (rs.next()) {
          custDetails.setText("CUSTOMER DETAILS");
          dash1.setText("------------------------------------------------------------------------");
          nameLabel.setText("FULL NAME : ");
          emailIDLabel.setText("EMAIL-ID : ");
          phoneNoLabel.setText("PHONE NO. : ");
          firstName.setText(rs.getString("Firstname"));
          lastName.setText(rs.getString("Lastname"));
          emailID.setText(rs.getString("EmailID"));
          phoneNo.setText(rs.getString("Phoneno"));
          dash2.setText("------------------------------------------------------------------------");
          panel.add(proceedToPayButton);
          proceedToPayButton.paintImmediately(0, 0, 200, 30);
        }

        String a = "Available";
        ps = con.prepareStatement("update Rooms set Room_Availability = '"+a+"' where Roomno = '"+roomIDTextField.getText()+"'");
        ps.executeUpdate();

      } catch(Exception e) {
        e.printStackTrace();
      }
    } else if (str.equals("CANCEL")) {
      setVisible(false);
    } else if (str.equals("PROCEED TO PAY")) {
      setVisible(false);
      new proceedToPay().setVisible(true);
    }
  }
}