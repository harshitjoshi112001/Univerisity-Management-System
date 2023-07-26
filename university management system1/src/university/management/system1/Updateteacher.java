
package university.management.system1;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class Updateteacher extends JFrame implements ActionListener{
    Font f1,f;
    Choice sroll;
    JButton update,submit,cancel;
    JLabel namefield,fnamefield,rollno,date,class10x,class12x,addhar;
    JTextField addressfield,emailfield,phone,coursebranch,courselist;
    Updateteacher()
    {
        super("Update Faculty");
        setLayout(null);
        f1=new Font("serif",Font.BOLD,20);
        f=new Font("serif",Font.PLAIN,18);
        
        JLabel heading=new JLabel("Update Faculty Details");
        heading.setBounds(250,20,300,30);
        heading.setFont(new Font("Tahoma",Font.ITALIC,25));
        heading.setForeground(Color.BLUE);
        add(heading);
        
        JLabel select=new JLabel("Select Employee ID:");
        select.setBounds(30,70,200,20);
        select.setFont(f1);
        add(select);
        
        sroll=new Choice();
        sroll.setBounds(240,70,200,25);
        sroll.add("Select Employee Id");
        add(sroll);
        try{
            Connectionclass conn=new Connectionclass();
            String s="select Emp_Id from teacher";
            ResultSet rs=conn.stm.executeQuery(s);
            while(rs.next())
            {
                sroll.add(rs.getString("Emp_Id"));
            }
        }catch(Exception e)
        {e.printStackTrace();}
        
        update =new JButton("Search");
        update.setBounds(460,70,100,25);
        update.setFont(f1);
        update.addActionListener(this);
        add(update);
        
        JLabel name=new JLabel("Faculty Name");
        name.setBounds(30,120,160,20);
        name.setFont(new Font("serif",Font.BOLD,20));
        add(name);
        
        namefield=new JLabel();
        namefield.setBounds(200,120,150,25);
        namefield.setFont(f);
        add(namefield);
        
        JLabel fname=new JLabel("Father's Name");
        fname.setBounds(400,120,200,20);
        fname.setFont(new Font("serif",Font.BOLD,20));
        add(fname);
        
        fnamefield=new JLabel();
        fnamefield.setBounds(550,120,150,25);
        fnamefield.setFont(f);
        add(fnamefield);
        
        //roll no
        JLabel roll=new JLabel("Emp_Id");
        roll.setBounds(30,170,100,20);
        roll.setFont(new Font("serif",Font.BOLD,20));
        add(roll);
        
        rollno=new JLabel();
        rollno.setBounds(200,170,120,25);
        rollno.setFont(new Font("serif",Font.PLAIN,18));
        add(rollno);
        
        //dob
        JLabel dob=new JLabel("Date of Birth");
        dob.setBounds(400,170,160,20);
        dob.setFont(new Font("serif",Font.BOLD,20));
        add(dob);
        
        date=new JLabel();
        date.setBounds(550,170,150,25);
        date.setFont(f);
        add(date);
        
        //address
        JLabel address=new JLabel("Address");
        address.setBounds(30,220,100,30);
        address.setFont(new Font("serif",Font.BOLD,20));
        add(address);
        
        addressfield=new JTextField();
        addressfield.setBounds(200,220,150,25);
        addressfield.setFont(f);
        add(addressfield);
        
        //email
        JLabel email=new JLabel("E-mail");
        email.setBounds(400,220,100,20);
        email.setFont(new Font("serif",Font.BOLD,20));
        add(email);
        
        emailfield=new JTextField();
        emailfield.setBounds(550,220,150,25);
        emailfield.setFont(f);
        add(emailfield);
        
        //class 10
        JLabel class10=new JLabel("Class X (%)");
        class10.setBounds(30,270,120,20);
        class10.setFont(new Font("serif",Font.BOLD,20));
        add(class10);
        
        class10x=new JLabel();
        class10x.setBounds(200,270,150,25);
        class10x.setFont(f);
        add(class10x);
        
        //class 12
        JLabel class12=new JLabel("Class XII (%)");
        class12.setBounds(400,270,120,20);
        class12.setFont(new Font("serif",Font.BOLD,20));
        add(class12);
        
        class12x=new JLabel();
        class12x.setBounds(550,270,150,25);
        class12x.setFont(f);
        add(class12x);
        
        //class phone
        JLabel phonee=new JLabel("Phone no");
        phonee.setBounds(30,320,120,20);
        phonee.setFont(new Font("serif",Font.BOLD,20));
        add(phonee);
        
        phone=new JTextField();
        phone.setBounds(200,320,150,25);
        phone.setFont(f);
        add(phone);
        
        //class adhar
        JLabel adhaar=new JLabel("Adhaar no");
        adhaar.setBounds(400,320,120,20);
        adhaar.setFont(new Font("serif",Font.BOLD,20));
        add(adhaar);
        
        addhar=new JLabel();
        addhar.setBounds(550,320,150,25);
        addhar.setFont(f);
        add(addhar);
        
        JLabel course=new JLabel("Education");
        course.setBounds(30,370,120,20);
        course.setFont(new Font("serif",Font.BOLD,20));
        add(course);
        
        courselist=new JTextField();
//        courselist.setSelectedIndex(-1);          //by using this it set the combo box set null
        courselist.setBackground(Color.WHITE);
        courselist.setBounds(200,370,150,25);
        add(courselist);
        
        //class branch
//        JLabel s=new JLabel("(only btech)");  //this add only btech
//        s.setBounds(465,372,70,20);
//        s.setFont(new Font("serif",Font.PLAIN,15));
//        add(s);
        JLabel branch=new JLabel("Department");
        branch.setBounds(400,370,200,20);
        branch.setFont(new Font("serif",Font.BOLD,20));
        add(branch);
        
        coursebranch=new JTextField();
        coursebranch.setBackground(Color.WHITE);
        coursebranch.setBounds(550,370,150,25);
        add(coursebranch);
        
        submit=new JButton("Update");
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);
        submit.setFont(new Font("Tahoma",Font.BOLD,20));
        submit.setBounds(150,450,150,30);
        add(submit);
        submit.addActionListener(this);
        
        cancel=new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setFont(new Font("Tahoma",Font.BOLD,20));
        cancel.setBounds(450,450,150,30);
        add(cancel);
        cancel.addActionListener(this);
        
        setSize(780,550);
        setLocation(300,100);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        int flag=1;
        
        if(ae.getSource() == update)
        {
            if(sroll.getSelectedItem()=="Select Employee Id")
            {
                flag=0;
                JOptionPane.showMessageDialog(null, "Please Search Employee Id First");
            }
            else
            {
                try{
                    Connectionclass conn=new Connectionclass();
                    ResultSet rs=conn.stm.executeQuery("select * from teacher where Emp_Id='"+sroll.getSelectedItem()+"'");
                    while(rs.next())
                    {
                        namefield.setText(rs.getString("Name"));
                        fnamefield.setText(rs.getString("Father_Name"));
                        rollno.setText(rs.getString("Emp_Id"));
                        date.setText(rs.getString("DOB"));
                        class10x.setText(rs.getString("Class_X"));
                        class12x.setText(rs.getString("Class_XII"));
                        addhar.setText(rs.getString("Adhaar_No"));
                        addressfield.setText(rs.getString("Address"));
                        emailfield.setText(rs.getString("EMail"));
                        phone.setText(rs.getString("Phone_No"));
                        coursebranch.setText(rs.getString("Department"));
                        courselist.setText(rs.getString("Education"));
                    }
                }catch(Exception e)
                {e.printStackTrace();}
            }
        }
        
        if(flag==1 && ae.getSource() == submit)
        {
            if(namefield.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please Search Employee Id First");
            }
            else if(addressfield.getText().equals("") || emailfield.getText().equals("") || phone.getText().equals("") || courselist.getText().equals("") ||coursebranch.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please Fill Details !!!");
            }
            else
            {

                String roll=rollno.getText();
                String addr = this.addressfield.getText();
                String ema=this.emailfield.getText();
                String pho= this.phone.getText();
                String coursename= this.courselist.getText();
                String courseb= this.coursebranch.getText();
                
                try{
                    Connectionclass conn=new Connectionclass();
                    int rs=conn.stm.executeUpdate("update teacher set Address='"+addr+"' , EMail='"+ema+"',Phone_No='"+pho+"',Education='"+coursename+"',Department='"+courseb+"' where Emp_Id = '"+roll+"'");
                    if(rs==1)
                    {
                        JOptionPane.showMessageDialog(null, "One data updated..Yeee");
                        setVisible(false);
                        new Updatestudent();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "OOops..not updated");
                    }
                    
                }catch(Exception e)
                {e.printStackTrace();}
            }
        }
        else if(ae.getSource() == cancel)
        {
            setVisible(false);
        }
    }
    
    public static void main(String[] ars)
    {
        new Updateteacher();
    }
}
