package com.bo.myFrame;

import com.bo.bean.StudentInfo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class QueryALLFrame {
    StudentInfo studentInfo = null;
    public  void createAndShowGUI() throws Exception {
        // 数据库连接设置
        String url = "jdbc:mysql://localhost:3306/student";
        String user = "root";
        String password = "root";

        // 建立数据库连接
        Connection conn = DriverManager.getConnection(url, user, password);

        // 查询学生信息
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM studentinfo"); // 假设students是学生表名

        // 获取列名
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();
        String[] columnNames = new String[columnCount];
        for (int i = 1; i <= columnCount; i++) {
            columnNames[i - 1] = metaData.getColumnName(i);
        }

        // 获取数据
        Object[][] data = new Object[100][columnCount]; // 假设学生数量不超过100，实际应根据查询结果动态调整
        int rowIndex = 0;
        while (rs.next()) {
            for (int i = 1; i <= columnCount; i++) {
                data[rowIndex][i - 1] = rs.getObject(i);
            }
            rowIndex++;
        }

        // 关闭资源
        rs.close();
        stmt.close();
        conn.close();

        // 创建表格模型并设置数据
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);

        // 添加滚动面板以便查看长列表
        JScrollPane scrollPane = new JScrollPane(table);

        // 创建主窗口
        JFrame frame = new JFrame("学生信息浏览");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 700);

        // 将滚动面板添加到窗口中
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        // 设置窗口居中显示并显示窗口
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
