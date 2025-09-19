package ui;
import db.DBConnection;
import model.Employee;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

public class ViewEmployeesFrame extends JFrame {
    public ViewEmployeesFrame() {
        setTitle("View Employees");
        setSize(600, 400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(0, 1, 10, 10));
        JScrollPane scrollPane = new JScrollPane(panel);

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM employee")) {

            while (rs.next()) {
                Employee emp = new Employee(
                        rs.getInt("id"), rs.getString("name"),
                        rs.getString("gender"), rs.getString("phoneNum"),
                        rs.getString("email"), rs.getString("designation"),
                        rs.getDouble("salary")
                );
                JPanel card = new JPanel(new GridLayout(1, 6));
                card.add(new JLabel("ID: " + emp.getId()));
                card.add(new JLabel("Name: " + emp.getName()));
                card.add(new JLabel("Gender: " + emp.getGender()));
                card.add(new JLabel("Email: " + emp.getEmail()));
                card.add(new JLabel("Designation: " + emp.getDesignation()));
                card.add(new JLabel("Salary: " + emp.getSalary()));
                panel.add(card);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        add(scrollPane);
    }
}
