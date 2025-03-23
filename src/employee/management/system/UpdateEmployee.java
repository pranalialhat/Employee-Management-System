package employee.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;


public class UpdateEmployee extends JFrame implements ActionListener {
    
    JTextField tfname, tf_fname, tf_salary, tf_address, tf_phone, tf_email, tf_designation, tf_education, tf_aadhar;
    JLabel  label_emp_ID, lbl_emp_ID;
    JButton add, back;
    String emp_ID;
    
    UpdateEmployee(String emp_ID){
        this.emp_ID = emp_ID;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Update Employee Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN SERIF", Font.BOLD, 25));
        add(heading);
        
        JLabel label_name = new JLabel("Name:");
        label_name.setBounds(50, 150, 150, 30);
        label_name.setFont(new Font("serif", Font.PLAIN, 20));
        add(label_name);
        
        JLabel lbl_name = new JLabel();
        lbl_name.setBounds(200, 150, 150, 30);
        add(lbl_name);
        
       
        JLabel fname = new JLabel("Father's Name:");
        fname.setBounds(400, 150, 150, 30);
        fname.setFont(new Font("serif", Font.PLAIN, 20));
        add(fname);
        
        tf_fname = new JTextField();
        tf_fname.setBounds(600, 150, 150, 30);
        add(tf_fname);
        
        JLabel dob = new JLabel("Date of Birth:");
        dob.setBounds(50, 200, 150, 30);
        dob.setFont(new Font("serif", Font.PLAIN, 20));
        add(dob);
        
        JLabel lbl_dob = new JLabel();
        lbl_dob.setBounds(200, 200, 150, 30);
        add(lbl_dob);
        
        JLabel salary = new JLabel("Salary:");
        salary.setBounds(400, 200, 150, 30);
        salary.setFont(new Font("serif", Font.PLAIN, 20));
        add(salary);
        
        tf_salary = new JTextField();
        tf_salary.setBounds(600, 200, 150, 30);
        add(tf_salary);
        
        JLabel address = new JLabel("Address:");
        address.setBounds(50, 250, 150, 30);
        address.setFont(new Font("serif", Font.PLAIN, 20));
        add(address);
        
        tf_address = new JTextField();
        tf_address.setBounds(200, 250, 150, 30);
        add(tf_address);
        
        JLabel label_phone = new JLabel("Phone :");
        label_phone.setBounds(400, 250, 150, 30);
        label_phone.setFont(new Font("serif", Font.PLAIN, 20));
        add(label_phone);
        
        tf_phone = new JTextField();
        tf_phone.setBounds(600, 250, 150, 30);
        add(tf_phone);
        
        JLabel label_email = new JLabel("Email:");
        label_email.setBounds(50, 300, 150, 30);
        label_email.setFont(new Font("serif", Font.PLAIN, 20));
        add(label_email);
        
        tf_email = new JTextField();
        tf_email.setBounds(200, 300, 150, 30);
        add(tf_email);
        
        JLabel education = new JLabel("Highest Education:");
        education.setBounds(400, 300, 150, 30);
        education.setFont(new Font("serif", Font.PLAIN, 20));
        add(education);
        
        String courses[] = {" ", "BBA", "BCA", "BCS", "B.Com", "B.Tech", "MBA", "MCA", "MCS", "M.Com", "M.Tech"};
        
        tf_education = new JTextField();
        tf_education.setBounds(600, 300, 150, 30);
        add(tf_education);
        
        JLabel designation = new JLabel("Designation:");
        designation.setBounds(50, 350, 150, 30);
        designation.setFont(new Font("serif", Font.PLAIN, 20));
        add(designation);
        
        tf_designation = new JTextField();
        tf_designation.setBounds(200, 350, 150, 30);
        add(tf_designation);
        
        JLabel aadhar = new JLabel("Aadhar Number:");
        aadhar.setBounds(400, 350, 150, 30);
        aadhar.setFont(new Font("serif", Font.PLAIN, 20));
        add(aadhar);
        
        JLabel lbl_aadhar = new JLabel();
        lbl_aadhar.setBounds(600, 350, 150, 30);
        add(lbl_aadhar);
        
        label_emp_ID = new JLabel("Employee ID:");
        label_emp_ID.setBounds(50, 400,150, 30);
        label_emp_ID.setFont(new Font("serif", Font.PLAIN, 20));
        add(label_emp_ID);
        
        lbl_emp_ID = new JLabel();
        lbl_emp_ID.setBounds(200, 400, 150, 30);
        lbl_emp_ID.setFont(new Font("serif", Font.PLAIN, 20));
        add(lbl_emp_ID);
        
        try {
            Conn c = new Conn();
            String query = "select * from employee where empID = '"+emp_ID+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                lbl_name.setText(rs.getString("name"));
                tf_fname.setText(rs.getString("fname"));
                lbl_dob.setText(rs.getString("dob"));
                tf_salary.setText(rs.getString("salary"));
                tf_address.setText(rs.getString("address"));
                tf_phone.setText(rs.getString("phone"));
                tf_email.setText(rs.getString("email"));
                tf_education.setText(rs.getString("education"));
                tf_designation.setText(rs.getString("designation"));
                lbl_aadhar.setText(rs.getString("aadhar"));
                lbl_emp_ID.setText(rs.getString("empID"));
               
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        
        add = new JButton("Update Details");
        add.setBounds(250, 550, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(450, 550, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == add){
           
            String fname = tf_fname.getText();
            String salary = tf_salary.getText();
            String address = tf_address.getText();
            String phone = tf_phone.getText();
            String email = tf_email.getText();
            String education = tf_education.getText();
            String designation = tf_designation.getText();
            
            try{
                Conn conn = new Conn();
                String query = "update employee set fname = '"+fname+"',  salary = '"+salary+"', address = '"+address+"', phone = '"+phone+"', email = '"+email+"', education = '"+education+"', designation = '"+designation+"' where empID = '"+emp_ID+"' ";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
                setVisible(false);
                new Home();
                
            } catch (Exception e){
                e.printStackTrace();
            }
            
;        } else {
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String args[]){
        
         new UpdateEmployee("");
        
    }
    
}

