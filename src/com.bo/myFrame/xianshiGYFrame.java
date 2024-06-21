package com.bo.myFrame;

import javax.swing.*;
import java.awt.*;

public class xianshiGYFrame {
    public void createAndShowGUI() {
        // 创建并配置JFrame
        JFrame frame = new JFrame("个人信息");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 2)); // 使用GridLayout布局，方便对齐标签和文本框

        // 创建个人信息的标签和文本字段
        JLabel nameLabel = new JLabel("姓名:");
        JTextField nameField = new JTextField(20);
        JLabel ageLabel = new JLabel("年龄:");
        JTextField ageField = new JTextField(5);
        JLabel emailLabel = new JLabel("邮箱:");
        JTextField emailField = new JTextField(20);

        // 添加组件到JFrame
        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(ageLabel);
        frame.add(ageField);
        frame.add(emailLabel);
        frame.add(emailField);

        // 为了演示，这里直接填入一些示例数据
        nameField.setText("李晨波");
        ageField.setText("21");
        emailField.setText("lichenbo@qq.com");

        // 设置窗口大小和位置
        frame.pack(); // 根据内容调整窗口大小
        frame.setMinimumSize(new Dimension(300, 150)); // 设置最小尺寸以确保所有内容可见
        frame.setLocationRelativeTo(null); // 居中显示窗口

        // 显示窗口
        frame.setVisible(true);
    }
}
