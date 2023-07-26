
package university.management.system1;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
public class Entermarks extends JFrame implements ActionListener{
    Font f;
    Choice sroll;
    JComboBox semester;
    JTextField sub1,sub2,sub3,sub4,sub5,sub6,sub7,mark1,mark2,mark3,mark4,mark5,mark6,mark7;
    JButton submit,back;
    Entermarks()
    {
        super("Enter marks");
        setLayout(null);
        f=new Font("serif",Font.PLAIN,21);
        
        JLabel heading=new JLabel("Enter Marks of Student");
        heading.setBounds(300,15,300,25);
        heading.setFont(new Font("serif",Font.BOLD,25));
        add(heading);
        
        JLabel roll=new JLabel("Select Roll Number");
        roll.setBounds(50,70,200,20);
        roll.setFont(f);
        add(roll);
        
        sroll=new Choice();
        sroll.setBounds(250,70,200,25);
        sroll.add("Select roll no");
        add(sroll);
        try{
            Connectionclass conn=new Connectionclass();
            String s="select Roll_No from student";
            ResultSet rs=conn.stm.executeQuery(s);
            while(rs.next())
            {
                sroll.add(rs.getString("Roll_No"));
            }
        }catch(Exception e)
        {e.printStackTrace();}
        
        JLabel sem=new JLabel("Select Semester");
        sem.setBounds(50,120,200,20);
        sem.setFont(f);
        add(sem);
        
        String s[]={"Select semester","1st sem","2nd sem","3rd sem","4th sem","5th sem","6th sem","7th sem","8th sem"};
        semester=new JComboBox(s);
        semester.setBounds(250,120,200,25);
        add(semester);
        
        ImageIcon img_logo = new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));
        Image img_logo2 = img_logo.getImage().getScaledInstance(350, 230, Image.SCALE_DEFAULT);
        ImageIcon img_logo3 = new ImageIcon(img_logo2);
        JLabel img_l = new JLabel(img_logo3);
        img_l.setBounds(440,30,500,400);
        add(img_l);
        
        JLabel entersub=new JLabel("Enter Subject ");
        entersub.setBounds(100,180,200,25);
        entersub.setFont(f);
        add(entersub);
        
        JLabel entermark=new JLabel("Enter Marks ");
        entermark.setBounds(310,180,200,25);
        entermark.setFont(f);
        add(entermark);
        
        sub1=new JTextField();
        sub1.setBounds(50,220,220,25);
        add(sub1);
        sub2=new JTextField();
        sub2.setBounds(50,255,220,25);
        add(sub2);
        sub3=new JTextField();
        sub3.setBounds(50,290,220,25);
        add(sub3);
        sub4=new JTextField();
        sub4.setBounds(50,325,220,25);
        add(sub4);
        sub5=new JTextField();
        sub5.setBounds(50,360,220,25);
        add(sub5);
        sub6=new JTextField();
        sub6.setBounds(50,395,220,25);
        add(sub6);
        sub7=new JTextField();
        sub7.setBounds(50,430,220,25);
        add(sub7);
        
        mark1=new JTextField();
        mark1.setBounds(270,220,220,25);
        add(mark1);
        mark2=new JTextField();
        mark2.setBounds(270,255,220,25);
        add(mark2);
        mark3=new JTextField();
        mark3.setBounds(270,290,220,25);
        add(mark3);
        mark4=new JTextField();
        mark4.setBounds(270,325,220,25);
        add(mark4);
        mark5=new JTextField();
        mark5.setBounds(270,360,220,25);
        add(mark5);
        mark6=new JTextField();
        mark6.setBounds(270,395,220,25);
        add(mark6);
        mark7=new JTextField();
        mark7.setBounds(270,430,220,25);
        add(mark7);
        
        submit=new JButton("SUBMIT");
        submit.setBounds(70,470,150,30);
        submit.addActionListener(this);
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);
        submit.setFont(new Font("Tahoma",Font.BOLD,18));
        add(submit);
        
        back=new JButton("BACK");
        back.setBounds(295,470,150,30);
        back.addActionListener(this);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setFont(new Font("Tahoma",Font.BOLD,18));
        add(back);
        
        setSize(900,580);
        setLocation(250,90);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == submit)
        {
            String rollno=sroll.getSelectedItem();
            String sem=semester.getSelectedItem().toString();
            if(rollno.equals("Select roll no") || sem.equals("Select semester"))
                JOptionPane.showMessageDialog(null, "Please!!! Fill above detail First....");
            else if(rollno.equals("Select roll no") == false && sem.equals("Select semester") ==false && sub1.getText().toString().equals("")==false)
            {
                try{
                    Connectionclass conn=new Connectionclass();
                    String query1="insert into subject(Roll_No,semester) values('"+rollno+"','"+sem+"')";
                    String query2="insert into marks(Roll_No,semester) values('"+rollno+"','"+sem+"')";
                    int a=conn.stm.executeUpdate(query1);
                    int b=conn.stm.executeUpdate(query2);
                    if(sub1.getText().equals("")==false)
                    {
                        String add="update subject set subject1='"+sub1.getText().toString()+"' where roll_no='"+rollno+"'";
                        String add2="update marks set mark1='"+mark1.getText().toString()+"' where roll_no='"+rollno+"'";
                        int c=conn.stm.executeUpdate(add);
                        int d=conn.stm.executeUpdate(add2);
                    }
                    if(sub2.getText().equals("")==false)
                    {
                        String add="update subject set subject2='"+sub2.getText().toString()+"' where roll_no='"+rollno+"'";
                        String add2="update marks set mark2='"+mark2.getText().toString()+"' where roll_no='"+rollno+"'";
                        int c=conn.stm.executeUpdate(add);
                        int d=conn.stm.executeUpdate(add2);
                    }
                    if(sub3.getText().equals("")==false)
                    {
                        String add="update subject set subject3='"+sub3.getText().toString()+"' where roll_no='"+rollno+"'";
                        String add2="update marks set mark3='"+mark3.getText().toString()+"' where roll_no='"+rollno+"'";
                        int c=conn.stm.executeUpdate(add);
                        int d=conn.stm.executeUpdate(add2);
                    }
                    if(sub4.getText().equals("")==false)
                    {
                        String add="update subject set subject4='"+sub4.getText().toString()+"' where roll_no='"+rollno+"'";
                        String add2="update marks set mark4='"+mark4.getText().toString()+"' where roll_no='"+rollno+"'";
                        int c=conn.stm.executeUpdate(add);
                        int d=conn.stm.executeUpdate(add2);
                    }if(sub5.getText().equals("")==false)
                    {
                        String add="update subject set subject5='"+sub5.getText().toString()+"' where roll_no='"+rollno+"'";
                        String add2="update marks set mark5='"+mark5.getText().toString()+"' where roll_no='"+rollno+"'";
                        int c=conn.stm.executeUpdate(add);
                        int d=conn.stm.executeUpdate(add2);
                    }
                    if(sub6.getText().equals("")==false)
                    {
                        String add="update subject set subject6='"+sub6.getText().toString()+"' where roll_no='"+rollno+"'";
                        String add2="update marks set mark6='"+mark6.getText().toString()+"' where roll_no='"+rollno+"'";
                        int c=conn.stm.executeUpdate(add);
                        int d=conn.stm.executeUpdate(add2);
                    }
                    if(sub7.getText().equals("")==false)
                    {
                        String add="update subject set subject7='"+sub7.getText().toString()+"' where roll_no='"+rollno+"'";
                        String add2="update marks set mark7='"+mark7.getText().toString()+"' where roll_no='"+rollno+"'";
                        int c=conn.stm.executeUpdate(add);
                        int d=conn.stm.executeUpdate(add2);
                    }
                    JOptionPane.showMessageDialog(null, "You updated marks successfully...");

                }catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null, "This roll no marks already inserted..!!!!");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Enter subject and marks first!!!!!!!!");
            }
        }
        else
        {
            setVisible(false);
        }
    }
    public static void main(String[] ar)
    {
        new Entermarks();
    }
}
