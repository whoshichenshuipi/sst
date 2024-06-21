package com.bo.myFrame;

import javax.swing.*;
import java.awt.*;

public class xianshiBZXFrame {
    public void createAndShowGUI() {
        // 创建一个JFrame实例
        JFrame frame = new JFrame("帮助中心");

        // 设置默认的关闭操作（这里设置为退出程序）
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // 创建一个JTextArea用于显示帮助文本
        JTextArea helpTextArea = new JTextArea();
        helpTextArea.setEditable(false); // 设置为不可编辑
        helpTextArea.setLineWrap(true); // 启用自动换行
        helpTextArea.setWrapStyleWord(true); // 换行时考虑单词完整性

        // 示例帮助文本
        String helpText = "欢迎来到帮助中心!\n\n"
                + "这里是你的帮助信息...\n\n"
                + "- 如何开始: ...\n"
                + "- 常见问题解答: ...\n"
                + "- 联系我们: ...\n";
        helpTextArea.setText(helpText);

        // 创建一个滚动窗格以便在内容过多时可以滚动查看
        JScrollPane scrollPane = new JScrollPane(helpTextArea);

        // 将滚动窗格添加到JFrame中
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        // 设置窗口大小
        frame.setSize(400, 300);

        // 使窗口居中显示
        frame.setLocationRelativeTo(null);

        // 显示窗口
        frame.setVisible(true);
    }
}
