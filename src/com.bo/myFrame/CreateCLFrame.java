package com.bo.myFrame;

import com.bo.Function.Function;
import com.bo.bean.School;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CreateCLFrame {

    JFrame createForCLFrame = new JFrame("设置学校信息");
    JButton jbt = new JButton("确认设置");

    JPanel jpQuery = new JPanel();

    JLabel jlbQueryn = new JLabel("输入添加的学校");
    JTextField jtfQueryNum = new JTextField(6);
    JButton jbtQuery = new JButton("查询");

    JLabel Jxxn = new JLabel("学校名称");
    JLabel Jxzn = new JLabel("校长名称");
    JLabel Jxpho = new JLabel("联系电话");
    JLabel Jxtime = new JLabel("建校时间");
    JLabel Jxpho2 = new JLabel("联系电话2");
    JLabel Jxadr = new JLabel("通讯地址");
    JLabel Jxjj = new JLabel("学校简介");

    JPanel jpxn = new JPanel();
    JPanel jpzn = new JPanel();
    JPanel jppho = new JPanel();
    JPanel jptime = new JPanel();
    JPanel jppho2 = new JPanel();
    JPanel jpaddr = new JPanel();
    JPanel jpjj = new JPanel();

    JTextField Jtxn    = new JTextField(11);
    JTextField Jtzn    = new JTextField(11);
    JTextField Jtpho   = new JTextField(11);
    JTextField Jttime  = new JTextField(11);
    JTextField Jtpho2  = new JTextField(11);
    JTextField Jtadr   = new JTextField(11);
    JTextField Jtjj    = new JTextField(11);

    School school = null;

    public CreateCLFrame(School school) {
        this.school = school;
    }


    public void init() {
        jpQuery.add(jlbQueryn);
        jpQuery.add(jtfQueryNum);
        jpQuery.add(jbtQuery);

        jpxn.add(Jxxn);
        jpxn.add(Jtxn);

        jpzn.add(Jtzn);
        jpzn.add(Jxzn);

        jppho.add(Jtpho);
        jppho.add(Jxpho);

        jptime.add(Jxtime);
        jptime.add(Jttime);

        jppho2.add(Jtpho2);
        jppho2.add(Jxpho2);

        jpaddr.add(Jxadr);
        jpaddr.add(Jtadr);

        jpjj.add(Jtjj);
        jpjj.add(Jxjj);

        Box vbox = Box.createVerticalBox();
        vbox.add(jppho);
        vbox.add(jpQuery);
        vbox.add(jpzn);
        vbox.add(jptime);
        vbox.add(jppho2);
        vbox.add(jpaddr);
        vbox.add(jpjj);
        createForCLFrame.add(vbox);
        createForCLFrame.add(jbt, BorderLayout.SOUTH);

        createForCLFrame.setVisible(true);
        createForCLFrame.setSize(600, 400);
        createForCLFrame.setLocationRelativeTo(null);


    }

    public void jbtListener() {
        jbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String jtxn = Jtxn.getText();
                String jtznText = Jtzn.getText();
                String jtphoText = Jtpho.getText();
                String jttimeText = Jttime.getText();
                String jtpho2Text = Jtpho2.getText();
                String jtadrText = Jtadr.getText();
                String jtjjText = Jtjj.getText();

                boolean flag = false;
                try {
                    flag = Function.createForSchoolFunction(jtxn, jtznText, jtphoText, jttimeText, jtpho2Text, jtadrText, jtjjText);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                } finally {
                    if (flag) {
                        JOptionPane.showMessageDialog(createForCLFrame, "添加成功", "消息对话框", JOptionPane.INFORMATION_MESSAGE);

                        //createForCLFrame.addWindowListener(new );
                        emptyTextField();
                    } else {
                        JOptionPane.showMessageDialog(createForCLFrame, "添加失败", "消息对话框", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
        createForCLFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //关闭该界面，系统未关闭
                createForCLFrame.setVisible(false);
            }
        });
    }

    public void emptyTextField() {
        Jtxn.setText("");
        Jtzn.setText("");
        Jtpho.setText("");
        Jttime.setText("");
        Jtpho2.setText("");
        Jtadr.setText("");
        Jtjj.setText("");
    }
}
