
package university.management.system1;

import javax.swing.*;
import java.util.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;

public class Teacherleave extends JFrame implements ActionListener{
    
    Choice empid,teachertime;
    JDateChooser date;
    JButton submit,cancel;
    Teacherleave()
    {
        super("Student leave");
        setLayout(null);
        
        JLabel heading=new JLabel("Apply Teacher Leave");
        heading.setBounds(110,20,200,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        add(heading);
        
        JLabel roll=new JLabel("Search by Employee Id: ");
        roll.setBounds(40,80,220,20);
        roll.setFont(new Font("Tahoma",Font.BOLD,15));
        add(roll);
        empid=new Choice();
        empid.setBounds(40,100,180,25);
        add(empid);
        
        try{
            Connectionclass con=new Connectionclass();
            ResultSet rs=con.stm.executeQuery("select Emp_Id from teacher");
            empid.add("Select Emp_Id");
            while(rs.next())
            {
                empid.add(rs.getString("Emp_Id"));
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
        
        teachertime=new Choice();
        teachertime.setBounds(40,240,200,25);
        teachertime.add("Select duration");
        teachertime.add("Full Day");
        teachertime.add("Half Day");
        add(teachertime);
        
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
            String sr=empid.getSelectedItem();
            String sdate=((JTextField)date.getDateEditor().getUiComponent()).getText();
            String dura=teachertime.getSelectedItem();
            if(sdate.equals("") || dura.equals("Select duration") || sr.equals("Select Emp_Id"))
            {
                f=0;
                JOptionPane.showMessageDialog(null, "Please fill all details carefully");
            }
            else if(f==1)
            {
                String s="insert into teacherleave values('"+sr+"','"+sdate+"','"+dura+"')";
                try{
                    Connectionclass conn=new Connectionclass();
                    int a=conn.stm.executeUpdate(s);
                    if(a==1)
                    {
                        JOptionPane.showMessageDialog(null,"Successfully applied for leave...");
                        setVisible(false);
                        new Teacherleave();
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
        new Teacherleave();
    }
}
