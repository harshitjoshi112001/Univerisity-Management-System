
package university.management.system1;

import javax.swing.*;
import java.util.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
public class Studentleave extends JFrame implements ActionListener{
    
    Choice sroll,stime;
    JDateChooser date;
    JButton submit,cancel;
    Studentleave()
    {
        super("Student leave");
        setLayout(null);
        
        JLabel heading=new JLabel("Apply Student Leave");
        heading.setBounds(110,20,200,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        add(heading);
        
        JLabel roll=new JLabel("Search by Roll number: ");
        roll.setBounds(40,80,200,20);
        roll.setFont(new Font("Tahoma",Font.BOLD,15));
        add(roll);
        sroll=new Choice();
        sroll.setBounds(40,100,180,25);
        add(sroll);
        
        try{
            Connectionclass con=new Connectionclass();
            ResultSet rs=con.stm.executeQuery("select Roll_No from student");
            sroll.add("Select Roll_No");
            while(rs.next())
            {
                sroll.add(rs.getString("Roll_No"));
            }
        }catch(Exception e)
        { e.printStackTrace();}
        
        JLabel sdate=new JLabel("Date of Leave:");
        sdate.setBounds(40,150,160,20);
        sdate.setFont(new Font("Tahoma",Font.BOLD,15));
        add(sdate);
        
        date=new JDateChooser();
        date.setBounds(40,170,180,25);
        add(date);
        
        JLabel duration=new JLabel("Time Duration:");
        duration.setBounds(40,220,200,20);
        duration.setFont(new Font("Tahoma",Font.BOLD,15));
        add(duration);
        
        stime=new Choice();
        stime.setBounds(40,240,200,25);
        stime.add("Select duration");
        stime.add("Full Day");
        stime.add("Half Day");
        add(stime);
        
        submit=new JButton("Submit");
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);
        submit.setFont(new Font("Tahoma",Font.BOLD,18));
        submit.setBounds(40,300,150,30);
        add(submit);
        submit.addActionListener(this);
        
        cancel=new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setFont(new Font("Tahoma",Font.BOLD,18));
        cancel.setBounds(230,300,140,30);
        add(cancel);
        cancel.addActionListener(this);
        
        setSize(400,430);
        setLocation(500,150);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        int f=1;
        if(ae.getSource()==submit)
        {
            String sr=sroll.getSelectedItem();
            String sdate=((JTextField)date.getDateEditor().getUiComponent()).getText();
            String dura=stime.getSelectedItem();
            if(sdate.equals("") || dura.equals("Select duration")||sr.equals("Select Roll_No"))
            {
                f=0;
                JOptionPane.showMessageDialog(null, "Please fill all details carefully");
            }
            else if(f==1)
            {
                String s="insert into studentleave values('"+sr+"','"+sdate+"','"+dura+"')";
                try{
                    Connectionclass conn=new Connectionclass();
                    int a=conn.stm.executeUpdate(s);
                    if(a==1)
                    {
                        JOptionPane.showMessageDialog(null,"Successfully applied for leave...");
                        setVisible(false);
                        new Studentleave();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Not applied...");
                    }
                }catch(Exception e)
                {e.printStackTrace();}  
            }
        }
        else
        {
            setVisible(false);
        }
    }
    
    public static void main(String[] arse)
    {
        new Studentleave();
    }
}
