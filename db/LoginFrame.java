package ui;
import db.DBConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginFrame() {
        setTitle("Admin Login");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel userLabel = new JLabel("Username:");
        JLabel passLabel = new JLabel("Password:");
        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        JButton loginButton = new JButton("Login");

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.add(userLabel); panel.add(usernameField);
        panel.add(passLabel); panel.add(passwordField);
        panel.add(new JLabel()); panel.add(loginButton);

        add(panel);

        loginButton.addActionListener(e -> authenticate());
    }

    private void authenticate() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement pst = con.prepareStatement(
                    "SELECT * FROM admin WHERE username=? AND password=?");
            pst.setString(1, username);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Login Successful!");
                new MainMenuFrame().setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Credentials!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
