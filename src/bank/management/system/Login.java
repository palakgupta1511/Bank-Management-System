package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JLabel l1,l2,l3;
    JTextField t1;
    JPasswordField p1;
    JButton b1,b2,b3;
    Login(){
        super("Bank Management System");

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,10,100,100);
        add(image);

        ImageIcon i4= new ImageIcon(ClassLoader.getSystemResource("icons/card.png"));
        Image i5 = i4.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image1 = new JLabel(i6);
        image1.setBounds(630,350,100,100);
        add(image1);

        l1= new JLabel("WELCOME TO ATM");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("AvantGarde",Font.BOLD,38));
        l1.setBounds(230,125,450,40);
        add(l1);

        l2=new JLabel("Card No:");
        l2.setFont(new Font("Ralway",Font.BOLD,28));
        l2.setForeground(Color.white);
        l2.setBounds(150,190,375,30);
        add(l2);
        t1= new JTextField(15);
        t1.setBounds(325,190,230,30);
        t1.setFont(new Font("Arial",Font.BOLD,14));
        add(t1);

        l3=new JLabel("PIN: ");
        l3.setFont(new Font("Ralway",Font.BOLD,28));
        l3.setForeground(Color.white);
        l3.setBounds(150,250,375,30);
        add(l3);
        p1= new JPasswordField(15);
        p1.setBounds(325,250,230,30);
        p1.setFont(new Font("Arial",Font.BOLD,14));
        add(p1);

       b1= new JButton("SIGN IN");
       b1.setFont(new Font("Arial",Font.BOLD,14));
       b1.setForeground(Color.WHITE);
       b1.setBackground(Color.black);
       b1.setBounds(325,300,100,30);
       b1.addActionListener(this);
       add(b1);

        b2= new JButton("CLEAR");
        b2.setFont(new Font("Arial",Font.BOLD,14));
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.black);
        b2.setBounds(455,300,100,30);
        b2.addActionListener(this);
        add(b2);

        b3= new JButton("SIGN UP");
        b3.setFont(new Font("Arial",Font.BOLD,14));
        b3.setForeground(Color.WHITE);
        b3.setBackground(Color.black);
        b3.setBounds(325,350,230,30);
        b3.addActionListener(this);
        add(b3);

        ImageIcon ii1= new ImageIcon(ClassLoader.getSystemResource("icons/backbg.png"));
        Image ii2 = ii1.getImage().getScaledInstance(850,480,Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel iimage = new JLabel(ii3);
        iimage.setBounds(0,0,850,480);
        add(iimage);

        setLayout(null);
        setSize(850,480);
      setLocation(450,200);
      setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource() == b1){
                Conn c = new Conn();
                String cardno = t1.getText();
                String pin = p1.getText();
                String q = "select * from login where card_number = '"+cardno+"' and  pin = '"+pin+"'";
                ResultSet resultSet = c.statement.executeQuery(q);
                if (resultSet.next()){
                    setVisible(false);
                    new main_Class(pin,cardno);
                }else {
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or PIN");
                }
            }else if(e.getSource()==b2){
                  t1.setText("");
                  p1.setText("");
            }else if(e.getSource()==b3){
                     new Signup();
                     setVisible(false);
            }
        }
        catch(Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
       new Login();
    }
}
