
package university.management.system1;
import javax.swing.*;
import java.util.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;

public class Marks extends JFrame implements ActionListener{
    String roll=null;
    JButton back;
    Marks(String rollno)
    {
        this.roll = rollno;
        setLayout(null);
        
        JLabel heading=new JLabel("Graphic Era Hill University");
        heading.setBounds(100,10,300,25);
        heading.setForeground(Color.blue);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);
        
        JLabel subheading=new JLabel("Result of Examination 2023");
        subheading.setBounds(110,40,300,25);
        subheading.setForeground(Color.BLACK);
        subheading.setFont(new Font("Tahoma",Font.BOLD,18));
        add(subheading);
        
        JLabel rolln=new JLabel("Roll No. "+roll);
        rolln.setBounds(60,80,300,20);
        rolln.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(rolln);
        
        JLabel name=new JLabel("");
        name.setBounds(280,80,300,20);
        name.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(name);
        
        JLabel semester=new JLabel("");
        semester.setBounds(60,110,300,20);
        semester.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(semester);
        
        JLabel sub1=new JLabel("");
        sub1.setBounds(100,200,300,20);
        sub1.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(sub1);
        
        JLabel sub2=new JLabel("");
        sub2.setBounds(100,230,300,20);
        sub2.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(sub2);
        
        JLabel sub3=new JLabel("");
        sub3.setBounds(100,260,300,20);
        sub3.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(sub3);
        
        JLabel sub4=new JLabel("");
        sub4.setBounds(100,290,300,20);
        sub4.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(sub4);
        
        JLabel sub5=new JLabel("");
        sub5.setBounds(100,320,300,20);
        sub5.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(sub5);
        
        JLabel sub6=new JLabel("");
        sub6.setBounds(100,350,300,20);
        sub6.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(sub6);
        
        JLabel sub7=new JLabel("");
        sub7.setBounds(100,380,300,20);
        sub7.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(sub7);
        
        try{
            Connectionclass conn=new Connectionclass();
            ResultSet rs1=conn.stm.executeQuery("select * from subject where roll_no = '"+roll+"'");
            
            while(rs1.next())
            {
                semester.setText("Semester: "+rs1.getString("semester"));
                try{
                    if(rs1.getString("subject1").equals("") == false)
                        sub1.setText(rs1.getString("subject1"));
                    if(rs1.getString("subject2").equals("") == false)
                        sub2.setText(rs1.getString("subject2"));
                    if(rs1.getString("subject3").equals("") == false)
                        sub3.setText(rs1.getString("subject3"));
                    if(rs1.getString("subject4").equals("") == false)
                        sub4.setText(rs1.getString("subject4"));
                    if(rs1.getString("subject5").equals("") == false)
                        sub5.setText(rs1.getString("subject5"));
                    else if(rs1.getString("subject5").equals("null") == true)
                        sub5.setText("");
                    if(rs1.getString("subject6").equals("") == false)
                        sub6.setText(rs1.getString("subject6"));
                    else if(rs1.getString("subject6").equals("null") == true)
                        sub6.setText("");
                    if(rs1.getString("subject7").equals("") == false)
                        sub7.setText(rs1.getString("subject7"));
                    else if(rs1.getString("subject7").equals("null") == true)
                        sub7.setText("");
                }catch(Exception e){}
            }
            ResultSet rs2=conn.stm.executeQuery("select * from student where roll_no = '"+roll+"'");
            while(rs2.next())
            {
                name.setText(rs2.getString("Name"));
            }
            
            ResultSet rs3=conn.stm.executeQuery("select * from marks where roll_no = '"+roll+"'");
            
            while(rs3.next())
            {
                
                try{
                    if(rs3.getString("mark1").equals("") == false)
                        sub1.setText(sub1.getText()+"-------------"+rs3.getString("mark1"));
                    if(rs3.getString("mark2").equals("") == false)
                        sub2.setText(sub2.getText()+"-------------"+rs3.getString("mark2"));
                    if(rs3.getString("mark3").equals("") == false)
                        sub3.setText(sub3.getText()+"-------------"+rs3.getString("mark3"));
                    if(rs3.getString("mark4").equals("") == false)
                        sub4.setText(sub4.getText()+"-------------"+rs3.getString("mark4"));
                    if(rs3.getString("mark5").equals("") == false)
                        sub5.setText(sub5.getText()+"-------------"+rs3.getString("mark5"));
                    else if(rs3.getString("mark5").equals("null") == true)
                        sub5.setText("");
                    if(rs3.getString("mark6").equals("") == false)
                        sub6.setText(sub6.getText()+"-------------"+rs3.getString("mark6"));
                    else if(rs3.getString("mark6").equals("null") == true)
                        sub6.setText("");
                    if(rs3.getString("mark7").equals("") == false)
                        sub7.setText(sub7.getText()+"-------------"+rs3.getString("mark7"));
                    else if(rs3.getString("mark7").equals("null") == true)
                        sub7.setText("");
                }catch(Exception e){}
            }
        }catch(Exception e)
        {
            
        }
        back=new JButton("BACK");
        back.setBounds(200,440,100,25);
        back.setFont(new Font("serif",Font.BOLD,20));
        back.addActionListener(this);
        add(back);
        
        setSize(500,600);
        setLocation(450,100);
        getContentPane().setBackground(Color.lightGray);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==back)
        {
            this.setVisible(false);
            new Examinationdetails();
        }
    }
    
    public static void main(String[] args)
    {
        new Marks("");
    }
}
