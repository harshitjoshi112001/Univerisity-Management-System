
package university.management.system1;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class Viewteacher extends JFrame implements ActionListener{
    Choice semp;
    JTable table;
    JButton search,print,add,update,cancel,reset;
    Viewteacher()
    {
        super("View Teacher");
        setLayout(null);
        
        JLabel heading=new JLabel("Search by Employee Id:");
        heading.setBounds(20,20,200,20);
        heading.setFont(new Font("serif",Font.BOLD,18));
        add(heading);
        semp=new Choice();
        semp.setBounds(220,20,180,20);
        add(semp);
        
        try{
            Connectionclass con=new Connectionclass();
            ResultSet rs=con.stm.executeQuery("select Emp_Id from teacher");
            while(rs.next())
            {
                semp.add(rs.getString("Emp_Id"));
            }
        }catch(Exception e)
        { e.printStackTrace();}
        
        search=new JButton("Search");
        search.setBounds(20,60,100,20);
        search.addActionListener(this);
        add(search);
        
        print=new JButton("Print");
        print.setBounds(140,60,100,20);
        print.addActionListener(this);
        add(print);
        
        add=new JButton("Add");
        add.setBounds(260,60,100,20);
        add.addActionListener(this);
        add(add);
        
        update=new JButton("Update");
        update.setBounds(380,60,100,20);
        update.addActionListener(this);
        add(update);
        
        reset=new JButton("Reset");
        reset.setBounds(500,60,100,20);
        reset.addActionListener(this);
        add(reset);
        
        cancel=new JButton("Cancel");
        cancel.setBounds(620,60,100,20);
        cancel.addActionListener(this);
        add(cancel);
        
        //table format
        table=new JTable();
        table.setFont(new Font("serif",Font.PLAIN,17));
        try{
            Connectionclass con=new Connectionclass();
            ResultSet rs=con.stm.executeQuery("select * from teacher");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e)
        { e.printStackTrace();}
        
        JScrollPane scroll=new JScrollPane(table);
        scroll.setBounds(0,100,1200,500);
        add(scroll);
        
        
        getContentPane().setBackground(Color.orange);
        setSize(1210,600);
        setLocation(100,100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        String s=ae.getActionCommand();
        if(s.equals("Search"))
        {
            String ss="select * from teacher where Emp_Id ='"+semp.getSelectedItem()+"'";
            try{
                Connectionclass con=new Connectionclass();
                ResultSet rs=con.stm.executeQuery(ss);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(s.equals("Print"))
        {
            JOptionPane.showMessageDialog(null,"Your wanna print table...");
            try{
                table.print();         //print in pdf form
            }catch(Exception e)
            {e.printStackTrace();}
        }
        else if(s.equals("Add"))
        {
            JOptionPane.showMessageDialog(null,"Add Another Faculty details....");
            this.setVisible(false);
            new Addteacher();
        }
        else if(s.equals("Update"))
        {
//            new Updatestudent();
        }
        else if(s.equals("Reset"))
        {
            this.setVisible(false);
            new Viewteacher();
        }
        else if(s.equals("Cancel"))
        {
            this.setVisible(false);
        }
    }
    public static void main(String[] args)
    {
        new Viewteacher();
    }
}
