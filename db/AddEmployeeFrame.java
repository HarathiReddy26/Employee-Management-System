package ui;
import db.DBConnection;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddEmployeeFrame extends JFrame {
    private JTextField idField, nameField, genderField, phoneField, emailField, designationField, salaryField;

    public AddEmployeeFrame() {
        setTitle("Add Employee");
        setSize(400, 400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(8, 2, 10, 10));
        panel.add(new JLabel("ID:")); idField = new JTextField(); panel.add(idField);
        panel.add(new JLabel("Name:")); nameField = new JTextField(); panel.add(nameField);
        panel.add(new JLabel("Gender:")); genderField = new JTextField(); panel.add(genderField);
        panel.add(new JLabel("Phone:")); phoneField = new JTextField(); panel.add(phoneField);
        panel.add(new JLabel("Email:")); emailField = new JTextField(); panel.add(emailField);
        panel.add(new JLabel("Designation:")); designationField = new JTextField(); panel.add(designationField);
        panel.add(new JLabel("Salary:")); salaryField = new JTextField(); panel.add(salaryField);

        JButton saveBtn = new JButton("Save");
        JButton cancelBtn = new JButton("Cancel");
        panel.add(saveBtn); panel.add(cancelBtn);

        add(panel);

        saveBtn.addActionListener(e -> saveEmployee());
        cancelBtn.addActionListener(e -> dispose());
    }

    private void saveEmployee() {
        try {
            int id = Integer.parseInt(idField.getText());
            double salary = Double.parseDouble(salaryField.getText());

            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(
                    "INSERT INTO employee (id, name, gender, phoneNum, email, designation, salary) VALUES (?,?,?,?,?,?,?)"
            );
            pst.setInt(1, id);
            pst.setString(2, nameField.getText());
            pst.setString(3, genderField.getText());
            pst.setString(4, phoneField.getText());
            pst.setString(5, emailField.getText());
            pst.setString(6, designationField.getText());
            pst.setDouble(7, salary);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Employee Added Successfully!");
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
}
