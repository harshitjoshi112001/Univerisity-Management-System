
package university.management.system1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;             //import subpackages in awt
import java.sql.*;

public class Login1 extends JFrame implements ActionListener {

    JButton login,cancel;
    JTextField inusername,inpassword;
    Login1()
    {
        super("Login Page");
        getContentPane().setBackground(Color.GRAY);           //Color is a class in awt
        setLayout(null);                                       
        
        JLabel username=new JLabel("USERNAME:");
        username.setBounds(40,40,100,20);      // set position 
        username.setFont(new Font("serif",Font.BOLD,17));
        add(username);
        inusername=new JTextField();    // placeholder
        inusername.setBounds(150,40,150,20);
        inusername.setFont(new Font("arial",Font.PLAIN,17));
        add(inusername);

        JLabel password=new JLabel("PASSWORD:");
        password.setBounds(40,80,100,20);
        password.setFont(new Font("serif",Font.BOLD,17));
        add(password);
        inpassword=new JPasswordField();
        inpassword.setBounds(150,80,150,20);
        inpassword.setFont(new Font("arial",Font.PLAIN,17));
        add(inpassword);

        login=new JButton("Login");
        login.setBounds(35,140,130,30);
        login.setBackground(Color.black);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        login.setFont(new Font("serif",Font.BOLD,18));
        add(login);
        
        cancel=new JButton("Cancel");
        cancel.setBounds(185,140,130,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("serif",Font.BOLD,18));
        add(cancel);

        ImageIcon img_logo=new ImageIcon(ClassLoader.getSystemResource("icons/user_gehu.jpg"));
        Image img_logo2=img_logo.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon img_logo3=new ImageIcon(img_logo2);
        JLabel img_l=new JLabel(img_logo3);
        img_l.setBounds(325,30,190,160);
        add(img_l);  
        
        setSize(550,250);
        setLocation(430,250);
        setVisible(true);

}

public void actionPerformed(ActionEvent ae) {
    if(ae.getSource() == login){
        String user=this.inusername.getText();
        String pass=this.inpassword.getText();
        
        try{
            Connectionclass con=new Connectionclass();
            String s="select * from login where username='"+user+"' and password ='"+pass+"'";
            ResultSet rs=con.stm.executeQuery(s);
            if(rs.next())       //it return true or false value
              {
//                  System.out.println("Admin section");
                  this.setVisible(false);
                  new Project();
              }
              else
              {
                  //this is use to show incorrection;
                  JOptionPane.showMessageDialog(null,"Your username and password is incorrect"); 
                  this.inusername.setText("");
                  this.inpassword.setText("");
                  this.setVisible(true);
              }
            con.stm.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
    else if(ae.getSource() == cancel){
        setVisible(false);
        System.exit(0);
    }
}
    public static void main(String[] args) {
        new Login1();
    }
}
 