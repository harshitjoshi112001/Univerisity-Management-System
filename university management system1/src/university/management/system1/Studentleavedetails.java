
package university.management.system1;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class Studentleavedetails extends JFrame implements ActionListener{
    Choice sroll;
    JTable table;
    JButton search,print,cancel,reset;
    Studentleavedetails()
    {
        super("Leave Details");
        setLayout(null);
        
        JLabel heading=new JLabel("Search by Roll number: ");
        heading.setBounds(20,20,200,20);
        heading.setFont(new Font("serif",Font.BOLD,18));
        add(heading);
        sroll=new Choice();
        sroll.setBounds(220,20,180,20);
        add(sroll);
        
        try{
            Connectionclass con=new Connectionclass();
            ResultSet rs=con.stm.executeQuery("select Roll_No from student");
            while(rs.next())
            {
                sroll.add(rs.getString("Roll_No"));
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
        
        
        reset=new JButton("Reset");
        reset.setBounds(260,60,100,20);
        reset.addActionListener(this);
        add(reset);
        
        cancel=new JButton("Cancel");
        cancel.setBounds(380,60,100,20);
        cancel.addActionListener(this);
        add(cancel);
        
        //table format
        table=new JTable();
        table.setFont(new Font("serif",Font.PLAIN,17));
        try{
            Connectionclass con=new Connectionclass();
            ResultSet rs=con.stm.executeQuery("select * from studentleave");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e)
        { e.printStackTrace();}
        
        JScrollPane scroll=new JScrollPane(table);
        scroll.setBounds(0,100,890,600);
        add(scroll);
        
        
        getContentPane().setBackground(Color.cyan);
        setSize(900,650);
        setLocation(290,80);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        String s=ae.getActionCommand();
        if(s.equals("Search"))
        {
            String ss="select * from studentleave where Roll_No ='"+sroll.getSelectedItem()+"'";
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
        else if(s.equals("Reset"))
        {
            this.setVisible(false);
            new Studentleavedetails();
        }
        else if(s.equals("Cancel"))
        {
            this.setVisible(false);
        }
    }
    public static void main(String[] args)
    {
        new Studentleavedetails();
    }
}
