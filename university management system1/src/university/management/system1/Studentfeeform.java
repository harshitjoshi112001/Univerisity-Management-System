
package university.management.system1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Studentfeeform extends JFrame implements ActionListener{
    Choice sroll;
    JLabel namefield,fnamefield,totalfee;
    Font f1,f;
    JComboBox courselist,coursebranch,semester;
    JButton back,pay,update;
    
    Studentfeeform()
    {
        super("Student fee form");
        setLayout(null);
        f1=new Font("serif",Font.BOLD,20);
        f=new Font("Tahoma",Font.PLAIN,18);
        
        ImageIcon img_logo=new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpg"));
        Image img_logo2=img_logo.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
        ImageIcon img_logo3=new ImageIcon(img_logo2);
        JLabel img_l=new JLabel(img_logo3);
        img_l.setBounds(500,10,300,250);               //it will add only when we set layout null
        add(img_l);
        
        JLabel select=new JLabel("Select Roll Number:");
        select.setBounds(30,20,200,20);
        select.setFont(f1);
        add(select);
        
        sroll=new Choice();
        sroll.setBounds(240,20,200,25);
        sroll.add("Select Roll no");
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
        
        
        
        JLabel name=new JLabel("Student Name");
        name.setBounds(30,60,160,20);
        name.setFont(new Font("serif",Font.BOLD,20));
        add(name);
        
        namefield=new JLabel();
        namefield.setBounds(240,60,150,25);
        namefield.setFont(f);
        add(namefield);
        
        JLabel fname=new JLabel("Father's Name");
        fname.setBounds(30,100,200,20);
        fname.setFont(new Font("serif",Font.BOLD,20));
        add(fname);
        
        fnamefield=new JLabel();
        fnamefield.setBounds(240,100,150,25);
        fnamefield.setFont(f);
        add(fnamefield);
        
        try{
                    Connectionclass conn=new Connectionclass();
                    ResultSet rs=conn.stm.executeQuery("select * from student where Roll_No='"+sroll.getSelectedItem()+"'");
                    while(rs.next())
                    {
                        namefield.setText(rs.getString("Name"));
                        fnamefield.setText(rs.getString("Father_Name"));
                    }
                }catch(Exception e)
                {e.printStackTrace();}
        
        sroll.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie)
            {
                if(sroll.getSelectedItem().toString().equals("Select Roll no"))
                {
                    namefield.setText("");
                    fnamefield.setText("");
                }
                else
                {
                    try{
                        Connectionclass con=new Connectionclass();
                        String query="select * from student where Roll_no='"+sroll.getSelectedItem()+"'";
                        ResultSet rs=con.stm.executeQuery(query);
                        while(rs.next())
                        {
                            namefield.setText(rs.getString("Name"));
                            fnamefield.setText(rs.getString("Father_Name"));
                        }
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, e.getMessage());}
                }
            }
        });
        
        JLabel course=new JLabel("Course Name");
        course.setBounds(30,140,120,20);
        course.setFont(new Font("serif",Font.BOLD,20));
        add(course);
        
        String cname[]={"Select course","B.Tech","BBA","BCA","B.Com","B.Sc","BA","B.Jmc","MCA","MBA","M.Tech"};
        courselist=new JComboBox(cname);
//        courselist.setSelectedIndex(-1);          //by using this it set the combo box set null
        courselist.setBackground(Color.WHITE);
        courselist.setBounds(240,140,200,25);
        add(courselist);
        
        JLabel branch=new JLabel("Branch");
        branch.setBounds(30,180,200,20);
        branch.setFont(new Font("serif",Font.BOLD,20));
        add(branch);
        
        String cbranch[]={"Select Branch","Computer Science","Electrical","Mechanical","I.T","Civil"};
        coursebranch=new JComboBox(cbranch);
        coursebranch.setBackground(Color.WHITE);
        coursebranch.setBounds(240,180,200,25);
        add(coursebranch);
        
        JLabel sem=new JLabel("Select Semester");
        sem.setBounds(30,220,200,20);
        sem.setFont(f1);
        add(sem);
        
        String s[]={"Select semester","Semester_1","Semester_2","Semester_3","Semester_4","Semester_5","Semester_6","Semester_7","Semester_8"};
        semester=new JComboBox(s);
        semester.setBackground(Color.WHITE);
        semester.setBounds(240,220,200,25);
        add(semester);
        
        JLabel total=new JLabel("Total Fees");
        total.setBounds(30,260,200,20);
        total.setFont(f1);
        add(total);
        totalfee=new JLabel();
        totalfee.setBounds(240,260,150,25);
        totalfee.setFont(f);
        add(totalfee);
        
        update=new JButton("Update");
        update.setBounds(70,350,150,30);
        update.addActionListener(this);
        update.setForeground(Color.WHITE);
        update.setBackground(Color.BLACK);
        update.setFont(new Font("Tahoma",Font.BOLD,18));
        add(update);
        
        pay=new JButton("Pay Fee");
        pay.setBounds(250,350,150,30);
        pay.addActionListener(this);
        pay.setForeground(Color.WHITE);
        pay.setBackground(Color.BLACK);
        pay.setFont(new Font("Tahoma",Font.BOLD,18));
        add(pay);
        
        back=new JButton("BACK");
        back.setBounds(430,350,150,30);
        back.addActionListener(this);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setFont(new Font("Tahoma",Font.BOLD,18));
        add(back);
        
        getContentPane().setBackground(Color.PINK);
        setSize(820,500);
        setLocation(300,150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == update)
        {
            String course=this.courselist.getSelectedItem().toString();
            String seme=(String)this.semester.getSelectedItem();
            if(course.equals("Select course") || seme.equals("Select semester"))
            {
                JOptionPane.showMessageDialog(this, "Please select course and semester both!!!!");
            }
            else
            {
                try{
                    Connectionclass con=new Connectionclass();
                        String query="select * from fee where Course='"+course+"'";
                        ResultSet rs=con.stm.executeQuery(query);
                        while(rs.next())
                        {
                            totalfee.setText(rs.getString(seme));
                        }
                }catch(Exception e)
                {e.printStackTrace();}                
            }
        }
        else if(ae.getSource() == pay)
        {
            String roll=this.sroll.getSelectedItem();
            String course=this.courselist.getSelectedItem().toString();
            String seme=(String)this.semester.getSelectedItem();
            String branch=(String) this.coursebranch.getSelectedItem();
            String totalf=totalfee.getText();
            
            if(totalfee.getText().equals(""))
            {
                JOptionPane.showMessageDialog(this, "Oops!! Please first update fees...");
            }
            else if(roll.equals("Select Roll no") || branch.equals("Select Branch"))
            {
                JOptionPane.showMessageDialog(this, "Select Student Info first...");
            }
            else
            {
                try{
                    Connectionclass con=new Connectionclass();
                    String query="insert into collegefee values('"+roll+"','"+course+"','"+branch+"','"+seme+"','"+totalf+"')";
                    int a=con.stm.executeUpdate(query);
                    JOptionPane.showMessageDialog(this, "Successfully submitted fees yeee......");
                    setVisible(false);
                }catch(Exception e)
                {e.printStackTrace();}   
            }
        }
        else
        {
            this.setVisible(false);
        }
    }
    public static void main(String[] args)
    {
        new Studentfeeform();
    }
}
