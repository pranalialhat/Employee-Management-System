package employee.management.system;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;


public class AddEmployee extends JFrame implements ActionListener {
    
    Random r = new Random();
    int number = r.nextInt(999999);
    
    JTextField tfname, tf_fname, tf_salary, tf_address, tf_phone, tf_email, tf_designation, tf_aadhar;
    JDateChooser dc_dob;
    JComboBox cb_education;
    JLabel label_emp_ID, lbl_emp_ID;
    JButton add, back;
    
    AddEmployee(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN SERIF", Font.BOLD, 25));
        add(heading);
        
        JLabel label_name = new JLabel("Name:");
        label_name.setBounds(50, 150, 150, 30);
        label_name.setFont(new Font("serif", Font.PLAIN, 20));
        add(label_name);
        
        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);
        
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
        
        dc_dob = new JDateChooser();
        dc_dob.setBounds(200, 200, 150, 30);
        add(dc_dob);
        
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
        
        cb_education = new JComboBox(courses);
        cb_education.setBounds(600, 300, 150, 30);
        cb_education.setBackground(Color.WHITE);
        add(cb_education);
        
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
        
        tf_aadhar = new JTextField();
        tf_aadhar.setBounds(600, 350, 150, 30);
        add(tf_aadhar);
        
        label_emp_ID = new JLabel("Employee ID:");
        label_emp_ID.setBounds(50, 400,150, 30);
        label_emp_ID.setFont(new Font("serif", Font.PLAIN, 20));
        add(label_emp_ID);
        
        lbl_emp_ID = new JLabel("" +number);
        lbl_emp_ID.setBounds(200, 400, 150, 30);
        lbl_emp_ID.setFont(new Font("serif", Font.PLAIN, 20));
        add(lbl_emp_ID);
        
        add = new JButton("Add Details");
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
            String name = tfname.getText();
            String fname = tf_fname.getText();
            String dob = ((JTextField) dc_dob.getDateEditor().getUiComponent()).getText();
            String salary = tf_salary.getText();
            String address = tf_address.getText();
            String phone = tf_phone.getText();
            String email = tf_email.getText();
            String education = (String)cb_education.getSelectedItem();
            String designation = tf_designation.getText();
            String aadhar = tf_aadhar.getText();
            String empID = lbl_emp_ID.getText();
            
            try{
                Conn conn = new Conn();
                String query = "insert into employee values('"+name+"', '"+fname+"', '"+dob+"', '"+salary+"', '"+address+"', '"+phone+"', '"+email+"', '"+education+"', '"+designation+"', '"+aadhar+"', '"+empID+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
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
        
         new AddEmployee();
        
    }
    
}
