
package university.management.system1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class Feestructure extends JFrame implements ActionListener{
    JTable table;
    Feestructure()
    {
        super("Fee structure");
        setLayout(null);
        
        JLabel heading =new JLabel("Fee Structure (2023)");
        heading.setBounds(30,15,300,25);
        heading.setFont(new Font("serif",Font.BOLD,24));
        add(heading);
        
        table=new JTable();
        table.setFont(new Font("serif",Font.PLAIN,17));
        try{
            Connectionclass con=new Connectionclass();
            ResultSet rs=con.stm.executeQuery("select * from fee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e)
        { e.printStackTrace();}
        
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,70,1000,500);
        add(jsp);
        
        getContentPane().setBackground(Color.ORANGE);
        setSize(1000,500);
        setLocation(200,150);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        
    }
    public static void main(String[] args)
    {
        new Feestructure();
    }
}
