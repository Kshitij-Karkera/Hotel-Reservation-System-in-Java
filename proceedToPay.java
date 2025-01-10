import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class proceedToPay extends JFrame implements ActionListener {
  JLabel imageLabel1;
  ImageIcon image1;
  Container container = getContentPane();

  JProgressBar pb;
  JLabel paymentMethodLabel = new JLabel("PLEASE ENTER YOUR CARD DETAILS");
  JLabel nameOnCardLabel = new JLabel("NAME ON CARD");
  JLabel cardNumberLabel = new JLabel("CARD NO.");
  JLabel validityLabel = new JLabel("VALID THRU");
  JLabel cvvLabel = new JLabel("CVV");

  JTextField nameOnCardTextField = new JTextField();
  JTextField cardNumberTextField = new JTextField();
  JTextField validityTextField = new JTextField();
  JPasswordField cvvPasswordField = new JPasswordField();
  JButton submitButton = new JButton("SUBMIT");

    public static void main(String[] args){
      proceedToPay r = new proceedToPay();
     
      r.setVisible(true);
    }

  proceedToPay() {
    super("LOGIN FORM");
    image1 = new ImageIcon("Hotel logo3.png");
    imageLabel1 = new JLabel(image1);
    imageLabel1.setSize(100, 89);
    imageLabel1.setLocation(10, 7);
    add(imageLabel1);
    setSize(500, 500);
    setLayoutManager();
    setLocationAndSize();
    addComponentsToContainer();

    pb = new JProgressBar(1,100);
    pb.setValue(0);
    pb.setStringPainted(true);
    pb.setBounds(140, 370, 200, 25);
    pb.setVisible(false);
    container.add(pb);
    submitButton.addActionListener(this);

    setTitle("Taj Hotel - PROCEED TO PAY");
    setLayout(null);
    setIconImage(image1.getImage());
    setLocation(490, 150);
    setResizable(false);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  }

  public void setLayoutManager() {
    container.setLayout(null);
  }

  public void setLocationAndSize() {
    paymentMethodLabel.setBounds(130, 80, 300, 30);
    nameOnCardLabel.setBounds(90, 140, 100, 30);
    cardNumberLabel.setBounds(90, 180, 100, 30);
    validityLabel.setBounds(90, 220, 100, 30);
    cvvLabel.setBounds(90, 260, 100, 30);

    nameOnCardTextField.setBounds(190, 140, 200, 30);
    cardNumberTextField.setBounds(190, 180, 200, 30);
    validityTextField.setBounds(190, 220, 200, 30);
    cvvPasswordField.setBounds(190, 260, 200, 30);

    submitButton.setBounds(190, 310, 100, 30);
  }

  public void addComponentsToContainer() {
    container.add(paymentMethodLabel);
    container.add(nameOnCardLabel);
    container.add(cardNumberLabel);
    container.add(validityLabel);
    container.add(cvvLabel);

    container.add(nameOnCardTextField);
    container.add(cardNumberTextField);
    container.add(validityTextField);
    container.add(cvvPasswordField);

    container.add(submitButton);
  }

  public void actionPerformed(ActionEvent e) { 
    String str = e.getActionCommand();
    String s1 = nameOnCardTextField.getText();
    String s2 = cardNumberTextField.getText();
    String s3 = validityTextField.getText();
    char s4[] = cvvPasswordField.getPassword();
    int t1 = s1.length();
    int t2 = s2.length();
    int t3 = s3.length();
    int t4 = s4.length;
    if (str.equals("SUBMIT")) {
      if (nameOnCardTextField.getText().equals("") || cardNumberTextField.getText().equals("") || validityTextField.getText().equals("") || cvvPasswordField.getPassword().equals("")) {
        JOptionPane.showMessageDialog(this, "Please fill all the credentials");
      } else {

        int i=0;
        if(e.getSource()==submitButton)
        {
          paymentMethodLabel.setVisible(false);
          nameOnCardLabel.setVisible(false);
          cardNumberLabel.setVisible(false);
          validityLabel.setVisible(false);
          cvvLabel.setVisible(false);
          nameOnCardTextField.setVisible(false);
          cardNumberTextField.setVisible(false);
          validityTextField.setVisible(false);
          cvvPasswordField.setVisible(false);
          submitButton.setVisible(false);
          imageLabel1.setVisible(false);
          pb.setVisible(true);
         try
         {
           while(i<=100)
           {
             if (i < 100) {
              pb.setString("Transaction in process...");
             } else {
               pb.setString("Done!");
               pb.setVisible(false);
               JOptionPane.showMessageDialog(this, "Transaction Complete");
               setVisible(false);
             }
            Thread.sleep(50);
            pb.paintImmediately(0, 0, 200, 25);
            pb.setValue(i);
            i++;
            }
          }
          catch(Exception e1)
          {
            System.out.print(e1);
          }
        }
      }
    }
  } 
}