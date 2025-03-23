package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JTextField tfusername, tfpassword;
    Login(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel username = new JLabel("Username");
        username.setBounds(40, 20, 100, 30);
        add(username);
        
        tfusername = new JTextField();
        tfusername.setBounds(140, 20, 140, 30);
        add(tfusername);
        
        JLabel password = new JLabel("Password");
        password.setBounds(40, 70, 100, 30);
        add(password);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(140, 70, 140, 30);
        add(tfpassword);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);
        
        JButton login = new JButton("Login");
        login.setBounds(150, 140, 150, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        setSize(600, 300);
        setLocation(450, 200);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        try {
            String username = tfusername.getText();
            String password = tfpassword.getText();
            
            Conn c = new  Conn();
            String query = "select * from login where username = '"+username+"' and password = '"+password+"' ";
            
            ResultSet rs = c.s.executeQuery(query);
            if(rs.next()) {
                setVisible(false);
                //next class
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password");
                setVisible(false);
            } 
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }
   public static void main(String args[]){
        new Login();
    }
    
}
