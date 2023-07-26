
package university.management.system1;

import javax.swing.*;
import java.util.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;

public class Addteacher extends JFrame implements ActionListener{
    Font f;
    JTextField namefield,fnamefield,addressfield,emailfield,class10x,class12x,phone,addhar;
    JLabel empid;
    JDateChooser date;
    JComboBox courselist,coursebranch;
    JButton submit,cancel;
    
    Random ran=new Random();
    long rol =Math.abs((ran.nextLong() % 90000L) + 10000L);              //it auto generate 5digit number
    Addteacher()
    {
        super("Add Student");
        setLayout(null);
        
        f =new Font("arial",Font.PLAIN,16);
                
        JLabel heading=new JLabel("New Teacher Details");
        heading.setForeground(Color.BLUE);
        heading.setBounds(260,20,300,40);           //   (x axis , y axis, width, height)
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);
        
        //studet name
        JLabel name=new JLabel("Faculty Name");
        name.setBounds(50,90,160,20);
        name.setFont(new Font("serif",Font.BOLD,20));
        add(name);
        
        namefield=new JTextField();
        namefield.setBounds(200,90,150,25);
        namefield.setFont(f);
        add(namefield);
        
        //father's name
        JLabel fname=new JLabel("Father's Name");
        fname.setBounds(400,90,200,20);
        fname.setFont(new Font("serif",Font.BOLD,20));
        add(fname);
        
        fnamefield=new JTextField();
        fnamefield.setBounds(550,90,150,25);
        fnamefield.setFont(f);
        add(fnamefield);

        //emp id
        JLabel roll=new JLabel("Emp.ID");
        roll.setBounds(50,140,100,20);
        roll.setFont(new Font("serif",Font.BOLD,20));
        add(roll);
        
        empid=new JLabel("101"+rol);
        empid.setBounds(200,140,120,25);
        empid.setFont(new Font("serif",Font.BOLD,20));
        add(empid);
        
        //dob
        JLabel dob=new JLabel("Date of Birth");
        dob.setBounds(400,140,160,20);
        dob.setFont(new Font("serif",Font.BOLD,20));
        add(dob);
        
        date=new JDateChooser();
        date.setBounds(550,140,150,25);
        add(date);
        
        //address
        JLabel address=new JLabel("Address");
        address.setBounds(50,180,100,30);
        address.setFont(new Font("serif",Font.BOLD,20));
        add(address);
        
        addressfield=new JTextField();
        addressfield.setBounds(200,190,150,25);
        addressfield.setFont(f);
        add(addressfield);
        
        //email
        JLabel email=new JLabel("E-mail");
        email.setBounds(400,190,100,20);
        email.setFont(new Font("serif",Font.BOLD,20));
        add(email);
        
        emailfield=new JTextField();
        emailfield.setBounds(550,190,150,25);
        emailfield.setFont(f);
        add(emailfield);
        
        //class 10
        JLabel class10=new JLabel("Class X (%)");
        class10.setBounds(50,240,120,20);
        class10.setFont(new Font("serif",Font.BOLD,20));
        add(class10);
        
        class10x=new JTextField();
        class10x.setBounds(200,240,150,25);
        class10x.setFont(f);
        add(class10x);
        
        //class 12
        JLabel class12=new JLabel("Class XII (%)");
        class12.setBounds(400,240,120,20);
        class12.setFont(new Font("serif",Font.BOLD,20));
        add(class12);
        
        class12x=new JTextField();
        class12x.setBounds(550,240,150,25);
        class12x.setFont(f);
        add(class12x);
        
        //class phone
        JLabel phonee=new JLabel("Phone no");
        phonee.setBounds(50,290,120,20);
        phonee.setFont(new Font("serif",Font.BOLD,20));
        add(phonee);
        
        phone=new JTextField();
        phone.setBounds(200,290,150,25);
        phone.setFont(f);
        add(phone);
        
        //class adhar
        JLabel adhaar=new JLabel("Adhaar no");
        adhaar.setBounds(400,290,120,20);
        adhaar.setFont(new Font("serif",Font.BOLD,20));
        add(adhaar);
        
        addhar=new JTextField();
        addhar.setBounds(550,290,150,25);
        addhar.setFont(f);
        add(addhar);
        
        //class course
        JLabel course=new JLabel("Education");
        course.setBounds(50,340,120,20);
        course.setFont(new Font("serif",Font.BOLD,20));
        add(course);
        
        String cname[]={"Select education","B.Tech","BBA","BCA","B.Com","B.Sc","BA","MCA","MBA","M.Tech","P.hd"};
        courselist=new JComboBox(cname);
//        courselist.setSelectedIndex(-1);          //by using this it set the combo box set null
        courselist.setBackground(Color.WHITE);
        courselist.setBounds(200,340,150,25);
        add(courselist);
        
        //class branch
//        JLabel s=new JLabel("(only btech)");  //this add only btech
//        s.setBounds(465,342,70,20);
//        s.setFont(new Font("serif",Font.PLAIN,15));
//        add(s);
        JLabel branch=new JLabel("Department");
        branch.setBounds(400,340,200,20);
        branch.setFont(new Font("serif",Font.BOLD,20));
        add(branch);
        
        String cbranch[]={"Select Department","Computer Science","Electrical","Mechanical","I.T","Civil","Management"};
        coursebranch=new JComboBox(cbranch);
        coursebranch.setBackground(Color.WHITE);
        coursebranch.setBounds(550,340,150,25);
        add(coursebranch);
        
        submit=new JButton("Submit");
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);
        submit.setFont(new Font("Tahoma",Font.BOLD,20));
        submit.setBounds(150,420,150,30);
        add(submit);
        submit.addActionListener(this);
        
        cancel=new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setFont(new Font("Tahoma",Font.BOLD,20));
        cancel.setBounds(450,420,150,30);
        add(cancel);
        cancel.addActionListener(this);
        
        setSize(780,550);
        setLocation(300,100);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()== submit)
        {
            int flag=1;
            String name=namefield.getText();
            String fname=fnamefield.getText();
            String roll=empid.getText();
            String dob=((JTextField)date.getDateEditor().getUiComponent()).getText();
            String addr = this.addressfield.getText();
            String ema=this.emailfield.getText();
            String class10= this.class10x.getText();
            String class12= this.class12x.getText();
            String pho= this.phone.getText();
            String adhar= this.addhar.getText();
            String coursename= this.courselist.getSelectedItem().toString();
            String courseb= this.coursebranch.getSelectedItem().toString();
            
            String storebranch=courseb;
            
            if(name.equals("") || fname.equals("") || roll.equals("") || dob.equals("") || addr.equals("") ||ema.equals("") || class10.equals("")
                    || class12.equals("") || pho.equals("") || adhar.equals(""))
            {
                flag=0;
                JOptionPane.showMessageDialog(null,"Please!! Fill All detials..");
            }
            else if(coursename.equals("Select education"))
            {
                flag=0;
                JOptionPane.showMessageDialog(null,"Please!! Select Course..");
            }
            else if(courseb.equals("Select Department"))
            {
                flag=0;
                JOptionPane.showMessageDialog(null,"Please!! Select Department..");
            }
//            else if(coursename.equals("B.Tech") || coursename.equals("M.Tech"))
//            {
//                if(courseb.equals("Select Branch"))
//                {
//                    flag=0;
//                    JOptionPane.showMessageDialog(null,"Please!! Select Branch..");
//                }
//            }
//            else if(coursename.equals("B.Tech") ==false)
//            {
//                storebranch = "";
//            }
            if(flag==1)
            {
                try
                {
                    Connectionclass con=new Connectionclass();
                    String in = "insert into teacher values('"+name+"','"+fname+"','"+roll+"','"+dob+"','"+addr+"','"+ema+"','"+class10+"','"+class12+"','"+pho+"','"+adhar+"','"+coursename+"','"+storebranch+"')";
                    int a=con.stm.executeUpdate(in);
                    if(a==1)
                    {
                        JOptionPane.showMessageDialog(null,"Student data Inserted Successfully....");
                        this.setVisible(false);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Some error");
                    }
                }catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
            
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Byeee!!!!");
            this.setVisible(false);
        }
    }
    public static void main(String[] arse)
    {
        new Addteacher();
    }
}
