package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class RemoveEmployee extends JFrame implements ActionListener{
    
     Choice empID;
     JButton delete, back;
    
    RemoveEmployee(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel label_emp_ID = new JLabel("Employee ID");
        label_emp_ID.setBounds(50, 50, 100, 30);
        add(label_emp_ID);
        
        empID = new Choice();
        empID.setBounds(200, 50, 150, 30);
        add(empID);
        
        try{
            Conn c = new Conn();
            String query = "select * from employee";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                empID.add(rs.getString("empID"));
            }
            
        } catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel label_name = new JLabel("Name:");
        label_name.setBounds(50, 100, 100, 30);
        label_name.setFont(new Font("serif", Font.PLAIN, 20));
        add(label_name);
        
        JLabel lbl_name = new JLabel();
        lbl_name.setBounds(200, 100, 100, 30);
        add(lbl_name);
        
        JLabel label_phone = new JLabel("Phone:");
        label_phone.setBounds(50, 150, 100, 30);
        label_phone.setFont(new Font("serif", Font.PLAIN, 20));
        add(label_phone);
        
        JLabel lbl_phone = new JLabel();
        lbl_phone.setBounds(200, 150, 100, 30);
        add(lbl_phone);
        
        JLabel label_email = new JLabel("Email:");
        label_email.setBounds(50, 200, 100, 30);
        label_email.setFont(new Font("serif", Font.PLAIN, 20));
        add(label_email);
        
        JLabel lbl_email = new JLabel();
        lbl_email.setBounds(200, 200, 100, 30);
        add(lbl_email);
        
        try{
            Conn c = new Conn();
            String query = "select * from employee where empID = '"+empID.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                lbl_name.setText(rs.getString("name"));
                lbl_phone.setText(rs.getString("phone"));
                lbl_email.setText(rs.getString("email"));
            }
            
        } catch(Exception e){
            e.printStackTrace();
        }
        
        empID.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                 try{
            Conn c = new Conn();
            String query = "select * from employee where empID = '"+empID.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                lbl_name.setText(rs.getString("name"));
                lbl_phone.setText(rs.getString("phone"));
                lbl_email.setText(rs.getString("email"));
            }
            
        } catch(Exception e){
            e.printStackTrace();
        }
            }
        });
        
        delete = new JButton("Delete");
        delete.setBounds(80, 300, 100, 30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);
        
        back = new JButton("Back");
        back.setBounds(200, 300, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 600, 400);
        add(image);
        
        setSize(1000, 400);
        setLocation(300, 150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == delete){
            
            try {
                Conn c = new Conn();
                String query = "delete from employee where empID = '"+empID.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee information deleted successfully");
                setVisible(false);
                new Home();
                
            } catch(Exception e){
                e.printStackTrace();
            }
            
        }else{
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String args[]){
        new RemoveEmployee();
    }
    
}
