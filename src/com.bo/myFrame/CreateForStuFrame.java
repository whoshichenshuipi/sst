package com.bo.myFrame;

import com.bo.Function.Function;
import com.bo.bean.Users;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

    //添加学生信息界面
public class CreateForStuFrame {
    JFrame createForStuFrame = new JFrame("增加学生信息");
    JButton jbt = new JButton("确认添加");

    JLabel jlbNum = new JLabel("学号:");
    JLabel jlbName = new JLabel("姓名:");
    JLabel jlbGender = new JLabel("性别:");
    JLabel jlbAge = new JLabel("年龄:");
    JLabel jlbMajor = new JLabel("专业:");
    JLabel jlbClass = new JLabel("班级:");
    JLabel jlbPhone = new JLabel("电话:");
    JTextField jtfNum = new JTextField(20);
    JTextField jtfName = new JTextField(11);
    JTextField jtfGender = new JTextField(11);
    JTextField jtfAge = new JTextField(11);
    JTextField jtfMajor = new JTextField(11);
    JTextField jtfClass = new JTextField(11);
    JTextField jtfPhone = new JTextField(11);
    JPanel jpNum = new JPanel();
    JPanel jpName = new JPanel();
    JPanel jpGender = new JPanel();
    JPanel jpAge = new JPanel();
    JPanel jpMajor = new JPanel();
    JPanel jpClass = new JPanel();
    JPanel jpPhone = new JPanel();

    Users users = null;
    public CreateForStuFrame(Users users){
        this.users = users;
    }

    //组装界面
    public void init(){
        jpNum.add(jlbNum);
        jpNum.add(jtfNum);
        jpName.add(jlbName);
        jpName.add(jtfName);
        jpGender.add(jlbGender);
        jpGender.add(jtfGender);
        jpAge.add(jlbAge);
        jpAge.add(jtfAge);
        jpMajor.add(jlbMajor);
        jpMajor.add(jtfMajor);
        jpClass.add(jlbClass);
        jpClass.add(jtfClass);
        jpPhone.add(jtfPhone);
        jpPhone.add(jlbPhone);

        Box vbox = Box.createVerticalBox();
        vbox.add(jpNum);
        vbox.add(jpName);
        vbox.add(jpAge);
        vbox.add(jpGender);
        vbox.add(jpMajor);
        vbox.add(jpClass);
        vbox.add(jpPhone);

        createForStuFrame.add(vbox);
        jbt.setBackground(Color.GREEN);
        createForStuFrame.add(jbt,BorderLayout.SOUTH);


        createForStuFrame.setVisible(true);
        createForStuFrame.setSize(600, 400);
        createForStuFrame.setLocationRelativeTo(null);
    }
    //对按钮进行监听----在主线程中调用了该方法，该按钮被点击时自动调用该方法内的设置好的监听器
    public void jbtListener(){
        jbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    String  user = null;

                    boolean flag = false;
                    try {
                        String textNum = jtfNum.getText();
                        int num = Integer.parseInt(textNum);
                        String name = jtfName.getText();
                        String gender = jtfGender.getText();
                        String textAge = jtfAge.getText();
                        int age = Integer.parseInt(textAge);
                        String major = jtfMajor.getText();
                        String classes = jtfClass.getText();
                        int phone = Integer.parseInt(jtfPhone.getText());
                        user = textNum;

                        //从界面获得信息，传入后端操作，进而导入数据库内
                        //查询是否有该学生，有则添加失败
                        //StudentInfo info = Function.queryForStudenInfoFunction(num);

                        flag = Function.createForStudentInfoFunction(num, name, gender, age, major, classes, phone);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    finally {
                        if (flag){
                            JOptionPane.showMessageDialog(createForStuFrame,"添加成功","消息对话框",JOptionPane.INFORMATION_MESSAGE);
                            //添加学生信息的同时，添加用户账号和密码
                            //Function.createForUsersFunction(user,"123",privilege);
                            emptyTextField();
                        }else {
                            JOptionPane.showMessageDialog(createForStuFrame,"添加失败","消息对话框",JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }

        });

        createForStuFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //关闭该界面，系统未关闭
                createForStuFrame.setVisible(false);
            }
        });
    }

    //封装清空所有文本框
    public void emptyTextField(){
        jtfNum.setText("");
        jtfName.setText("");
        jtfGender.setText("");
        jtfAge.setText("");
        jtfMajor.setText("");
        jtfClass.setText("");
        jtfPhone.setText("");
    }

}

