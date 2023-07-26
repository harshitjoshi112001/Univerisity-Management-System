
package university.management.system1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class About extends JFrame{
    
    About()
    {
        super("About");
        setLayout(null);
        
        ImageIcon img_logo=new ImageIcon(ClassLoader.getSystemResource("icons/about1.png"));
        Image img_logo2=img_logo.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon img_logo3=new ImageIcon(img_logo2);
        JLabel img_l=new JLabel(img_logo3);
        img_l.setBounds(380,10,250,250);               //it will add only when we set layout null
        add(img_l);
        
        JLabel heading=new JLabel("<html>University <br>Management System</html>");
        heading.setBounds(50,15,350,130);
        heading.setFont(new Font("serif",Font.BOLD,35));
        add(heading);
        
        JLabel by=new JLabel("Developed By:  Harshit Joshi");
        by.setBounds(50,270,550,30);
        by.setForeground(Color.BLUE);
        by.setFont(new Font("serif",Font.BOLD,30));
        add(by);
        
        JLabel roll=new JLabel("Roll No          :  2298005");
        roll.setBounds(50,350,550,30);
        roll.setForeground(Color.BLUE);
        roll.setFont(new Font("serif",Font.BOLD,30));
        add(roll);
        
        JLabel con=new JLabel("Contact : harshitjoshioct@gmail.com");
        con.setBounds(50,400,550,30);
        con.setForeground(Color.BLUE);
        con.setFont(new Font("serif",Font.BOLD,20));
        add(con);
        
        
        setSize(700,500);
        setLocation(400,150);
        setVisible(true);
    }
    public static void main(String[] ar)
    {
        new About();
    }    
}
