
package university.management.system1;

import javax.swing.*;
import java.util.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import net.proteanit.sql.DbUtils;

public class Examinationdetails extends JFrame implements ActionListener {
    JTextField searchroll;
    JButton result,cancel,reset;
    JTable table;
    Examinationdetails()
    {
        super("Examination Details");
        setLayout(null);
        
        JLabel heading=new JLabel("Check Result");
        heading.setBounds(400,15,200,25);
        heading.setForeground(Color.blue);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);
        
        JLabel addroll=new JLabel("Enter Roll no");
        addroll.setBounds(60,55,200,20);
        addroll.setFont(new Font("serif",Font.BOLD,23));
        add(addroll);
        
        searchroll=new JTextField();
        searchroll.setBounds(60,85,200,25);
        searchroll.setFont(new Font("serif",Font.BOLD,23));
        add(searchroll);
        
        table=new JTable();
        table.setFont(new Font("Tahoma",Font.PLAIN,17));
        try{
            Connectionclass con=new Connectionclass();
            ResultSet rs=con.stm.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e)
        { e.printStackTrace();}
        
        table.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me)
            {
                int row=table.getSelectedRow();
                String s=table.getModel().getValueAt(row,2).toString();       //it select index then it select 3rd row from table i.e roll no column
                searchroll.setText(s);
            }
        });
        
        JScrollPane scroll=new JScrollPane(table);
        scroll.setBounds(0,130,1100,500);
        add(scroll);
        
        result=new JButton("Result");
        result.setBounds(300,85,100,25);
        result.setFont(new Font("serif",Font.BOLD,20));
        result.addActionListener(this);
        add(result);
        
        reset=new JButton("Reset");
        reset.setBounds(420,85,100,25);
        reset.setFont(new Font("serif",Font.BOLD,20));
        reset.addActionListener(this);
        add(reset);
        
        cancel=new JButton("Cancel");
        cancel.setBounds(540,85,100,25);
        cancel.setFont(new Font("serif",Font.BOLD,20));
        cancel.addActionListener(this);
        add(cancel);
        
        
        setSize(1110,520);
        setLocation(200,100);
        getContentPane().setBackground(Color.ORANGE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == result)
        {
            if(searchroll.getText().equals("") ==false)
            {
                new Marks(searchroll.getText());
                setVisible(false);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Please !! Fill Rollno first");
            }
        }
        else if(ae.getSource() == reset)
        {
            this.setVisible(false);
            new Examinationdetails();
        }
        else
        {
            this.setVisible(false);
        }
    }
    public static void main(String[] args)
    {
        new Examinationdetails();
    }
}
