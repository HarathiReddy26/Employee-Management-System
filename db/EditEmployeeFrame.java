package ui;
import db.DBConnection;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EditEmployeeFrame extends JFrame {
    private JTextField idField, nameField, genderField, phoneField, emailField, designationField, salaryField;
    private JButton loadBtn, updateBtn;

    public EditEmployeeFrame() {
        setTitle("Edit Employee");
        setSize(400, 450);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(9, 2, 10, 10));
        panel.add(new JLabel("Employee ID:")); idField = new JTextField(); panel.add(idField);

        loadBtn = new JButton("Load Employee");
        panel.add(new JLabel()); panel.add(loadBtn);

        panel.add(new JLabel("Name:")); nameField = new JTextField(); panel.add(nameField);
        panel.add(new JLabel("Gender:")); genderField = new JTextField(); panel.add(genderField);
        panel.add(new JLabel("Phone:")); phoneField = new JTextField(); panel.add(phoneField);
        panel.add(new JLabel("Email:")); emailField = new JTextField(); panel.add(emailField);
        panel.add(new JLabel("Designation:")); designationField = new JTextField(); panel.add(designationField);
        panel.add(new JLabel("Salary:")); salaryField = new JTextField(); panel.add(salaryField);

        updateBtn = new JButton("Update");
        JButton cancelBtn = new JButton("Cancel");
        panel.add(updateBtn); panel.add(cancelBtn);

        add(panel);

        loadBtn.addActionListener(e -> loadEmployee());
        updateBtn.addActionListener(e -> updateEmployee());
        cancelBtn.addActionListener(e -> dispose());
    }

    private void loadEmployee() {
        try {
            int id = Integer.parseInt(idField.getText());
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM employee WHERE id=?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                nameField.setText(rs.getString("name"));
                genderField.setText(rs.getString("gender"));
                phoneField.setText(rs.getString("phoneNum"));
                emailField.setText(rs.getString("email"));
                designationField.setText(rs.getString("designation"));
                salaryField.setText(String.valueOf(rs.getDouble("salary")));
            } else {
                JOptionPane.showMessageDialog(this, "Employee Not Found!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void updateEmployee() {
        try {
            int id = Integer.parseInt(idField.getText());
            double salary = Double.parseDouble(salaryField.getText());

            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(
                    "UPDATE employee SET name=?, gender=?, phoneNum=?, email=?, designation=?, salary=? WHERE id=?"
            );
            pst.setString(1, nameField.getText());
            pst.setString(2, genderField.getText());
            pst.setString(3, phoneField.getText());
            pst.setString(4, emailField.getText());
            pst.setString(5, designationField.getText());
            pst.setDouble(6, salary);
            pst.setInt(7, id);

            int rows = pst.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "Employee Updated Successfully!");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Employee Not Found!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
}
