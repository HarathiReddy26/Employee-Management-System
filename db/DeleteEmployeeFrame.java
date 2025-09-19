package ui;
import db.DBConnection;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteEmployeeFrame extends JFrame {
    private JTextField idField;

    public DeleteEmployeeFrame() {
        setTitle("Delete Employee");
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.add(new JLabel("Employee ID:")); idField = new JTextField(); panel.add(idField);

        JButton deleteBtn = new JButton("Delete");
        JButton cancelBtn = new JButton("Cancel");
        panel.add(deleteBtn); panel.add(cancelBtn);

        add(panel);

        deleteBtn.addActionListener(e -> deleteEmployee());
        cancelBtn.addActionListener(e -> dispose());
    }

    private void deleteEmployee() {
        try {
            int id = Integer.parseInt(idField.getText());
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("DELETE FROM employee WHERE id=?");
            pst.setInt(1, id);

            int rows = pst.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "Employee Deleted Successfully!");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Employee Not Found!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
}
