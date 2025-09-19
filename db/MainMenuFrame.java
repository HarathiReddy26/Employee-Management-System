package ui;

import javax.swing.*;
import java.awt.*;

public class MainMenuFrame extends JFrame {
    public MainMenuFrame() {
        setTitle("Employee Management System");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton viewBtn = new JButton("View Employees");
        JButton addBtn = new JButton("Add Employee");
        JButton editBtn = new JButton("Edit Employee");
        JButton deleteBtn = new JButton("Delete Employee");
        JButton exitBtn = new JButton("Exit");

        JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));
        panel.add(viewBtn);
        panel.add(addBtn);
        panel.add(editBtn);
        panel.add(deleteBtn);
        panel.add(exitBtn);

        add(panel);

        viewBtn.addActionListener(e -> new ViewEmployeesFrame().setVisible(true));
        addBtn.addActionListener(e -> new AddEmployeeFrame().setVisible(true));
        editBtn.addActionListener(e -> new EditEmployeeFrame().setVisible(true));
        deleteBtn.addActionListener(e -> new DeleteEmployeeFrame().setVisible(true));
        exitBtn.addActionListener(e -> System.exit(0));
    }
}
