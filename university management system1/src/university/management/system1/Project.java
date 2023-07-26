
package university.management.system1;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
        
public class Project extends JFrame implements ActionListener {
    Font f,f1;
    Project()
    {
        super("Information");
        
        f=new Font("Serif",Font.BOLD,18);
        f1=new Font("arial",Font.BOLD,15);
        
        JMenuBar mb=new JMenuBar();
        setJMenuBar(mb);
        
        //enter info
        JMenu info=new JMenu("New Information");
        info.setFont(f);
        mb.add(info);
        
        JMenuItem faculty=new JMenuItem("Add New Faculty");
        faculty.setFont(f1);
        faculty.addActionListener(this);
        info.add(faculty);
        JMenuItem student=new JMenuItem("Add New Student");
        student.setFont(f1);
        student.addActionListener(this);
        info.add(student);
        
        // view info
        JMenu details=new JMenu("View Details");
        details.setForeground(Color.red);
        details.setFont(f);
        mb.add(details);
        
        JMenuItem viewfaculty=new JMenuItem("View Faculty");
        viewfaculty.setFont(f1);
        viewfaculty.addActionListener(this);
        details.add(viewfaculty);
        JMenuItem viewstudent=new JMenuItem("View Student");
        viewstudent.setFont(f1);
        viewstudent.addActionListener(this);
        details.add(viewstudent);
        
        //apply leave
        JMenu leave=new JMenu("Apply Leave");
        leave.setForeground(Color.BLACK);
        leave.setFont(f);
        mb.add(leave);
        
        JMenuItem facultyleave=new JMenuItem("Faculty Leave");
        facultyleave.setFont(f1);
        facultyleave.addActionListener(this);
        leave.add(facultyleave);
        JMenuItem stuleave=new JMenuItem("Student Leave");
        stuleave.setFont(f1);
        stuleave.addActionListener(this);
        leave.add(stuleave);
        
        //leave details
        JMenu leavedetails=new JMenu("Leave Details");
        leavedetails.setForeground(Color.RED);
        leavedetails.setFont(f);
        mb.add(leavedetails);
        
        JMenuItem facultyleavedetails=new JMenuItem("Faculty Leave Details");
        facultyleavedetails.setFont(f1);
        facultyleavedetails.addActionListener(this);
        leavedetails.add(facultyleavedetails);
        JMenuItem stuleavedetails=new JMenuItem("Student Leave Details");
        stuleavedetails.setFont(f1);
        stuleavedetails.addActionListener(this);
        leavedetails.add(stuleavedetails);
        
        //exam details
        JMenu exam=new JMenu("Examination");
        exam.setForeground(Color.BLACK);
        exam.setFont(f);
        mb.add(exam);
        
        JMenuItem enter=new JMenuItem("Enter Marks");
        enter.setFont(f1);
        enter.addActionListener(this);
        exam.add(enter);
        JMenuItem result=new JMenuItem("Examination Results");
        result.setFont(f1);
        result.addActionListener(this);
        exam.add(result);
        
        //update details
        JMenu update=new JMenu("Update Information");
        update.setForeground(Color.RED);
        update.setFont(f);
        mb.add(update);
        
        JMenuItem updatefaculty=new JMenuItem("Update Faculty Details");
        updatefaculty.setFont(f1);
        updatefaculty.addActionListener(this);
        update.add(updatefaculty);
        JMenuItem updatestudent=new JMenuItem("Update Student Details");
        updatestudent.setFont(f1);
        updatestudent.addActionListener(this);
        update.add(updatestudent);
        
        //fee details
        JMenu fee=new JMenu("Fee Details");
        fee.setForeground(Color.BLACK);
        fee.setFont(f);
        mb.add(fee);
        
        JMenuItem feestructure=new JMenuItem("Fee Structure");
        feestructure.setFont(f1);
        feestructure.addActionListener(this);
        fee.add(feestructure);
        JMenuItem feeform=new JMenuItem("Fee Submit Form");
        feeform.setFont(f1);
        feeform.addActionListener(this);
        fee.add(feeform);
        
        //utility details
        JMenu utility=new JMenu("Utility");
        utility.setForeground(Color.RED);
        utility.setFont(f);
        mb.add(utility);
        
        JMenuItem notepad=new JMenuItem("Notepad");
        notepad.setFont(f1);
        notepad.addActionListener(this);
        utility.add(notepad);
        JMenuItem calculator=new JMenuItem("Calculator");
        calculator.setFont(f1);
        calculator.addActionListener(this);
        utility.add(calculator);
        
        //about
        JMenu about=new JMenu("About");
        about.setForeground(Color.BLACK);
        about.setFont(f);
        mb.add(about);
        
        JMenuItem ab=new JMenuItem("About");
        ab.setFont(f1);
        ab.addActionListener(this);
        about.add(ab);
        
        //exit
        JMenu exit=new JMenu("Exit");
        exit.setForeground(Color.RED);
        exit.setFont(f);
        mb.add(exit);
        
        JMenuItem logout=new JMenuItem("Logout");
        logout.setFont(f1);
        logout.addActionListener(this);
        exit.add(logout);
        
        ImageIcon img_logo=new ImageIcon(ClassLoader.getSystemResource("icons/gehudoon.jpg"));
        Image img_logo2=img_logo.getImage().getScaledInstance(1360, 670, Image.SCALE_DEFAULT);
        ImageIcon img_logo3=new ImageIcon(img_logo2);
        JLabel img_l=new JLabel(img_logo3);
//        img_l.setBounds(1200,720,0,0);               //it will add only when we set layout null
        add(img_l);
        
        setSize(1380,750);
        setLocation(-5,-5);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        String msg=ae.getActionCommand();
        if(msg.equals("Add New Student"))
        {
            new Addstudent();
        }
        else if(msg.equals("Add New Faculty"))
        {
            new Addteacher();
        }
        else if(msg.equals("View Student"))
        {
            new Viewstudent();
        }
        else if(msg.equals("View Faculty"))
        {
            new Viewteacher();
        }
        else if(msg.equals("Faculty Leave"))
        {
            new Teacherleave();
        }
        else if(msg.equals("Student Leave"))
        {
            new Studentleave();
        }
        else if(msg.equals("Fee Structure"))
        {
            new Feestructure();
        }
        else if(msg.equals("Fee Submit Form"))
        {
            new Studentfeeform();
        }
        else if(msg.equals("Student Leave Details"))
        {
            new Studentleavedetails();
        }
        else if(msg.equals("Faculty Leave Details"))
        {
            new Teacherleavedetails();
        }
        else if(msg.equals("Update Student Details"))
        {
            new Updatestudent();
        }
        else if(msg.equals("Update Faculty Details"))
        {
            new Updateteacher();
        }
        else if(msg.equals("Enter Marks"))
        {
            new Entermarks();
        }
        else if(msg.equals("Examination Results"))
        {
            new Examinationdetails();
        }
        else if(msg.equals("Logout"))
        {
            this.setVisible(false);
            new Login1();
        }
        else if(msg.equals("Calculator"))
        {
            try{
                Runtime.getRuntime().exec("calc.exe");      //use calculator from our system
            }catch(Exception e){ }
        }
        else if(msg.equals("About"))
        {
            new About();
        }
        else if(msg.equals("Notepad"))
        {
            try{
                Runtime.getRuntime().exec("notepad.exe");    //use notepad from our system
            }catch(Exception e){ }  
        }
    }
    public static void main(String[] xy)
    {
        new Project();
    }
}
