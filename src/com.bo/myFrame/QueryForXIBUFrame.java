package com.bo.myFrame;

import com.bo.Function.Function;
import com.bo.bean.StudentInfo;
import com.bo.bean.Users;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//查询西部信息界面
public class QueryForXIBUFrame {
    StudentInfo courseInfo = null;
    JFrame queryForCouFrame = new JFrame("查询西部信息");

    JPanel jpQuery = new JPanel();
    JLabel jlbQurtyNum = new JLabel("XIBU");
    JTextField jtfQueryNum = new JTextField(11);
    JButton jbtQuery = new JButton("查询");

    JPanel jpNum = new JPanel();
    JLabel jlbNum = new JLabel("学号");
    JTextField jtfNum = new JTextField(11);

    JPanel jpName = new JPanel();
    JLabel jlbName = new JLabel("姓名");
    JTextField jtfName = new JTextField(11);
    JPanel jpgender = new JPanel();
    JLabel jlbGender = new JLabel("性别");
    JTextField jtfGender = new JTextField(11);
    JPanel jpAge = new JPanel();
    JLabel jlbAge = new JLabel("年龄");
    JTextField jtfAge = new JTextField(11);
    JPanel jpMajor = new JPanel();
    JLabel jlbMajor = new JLabel("西部");
    JTextField jtfMajor = new JTextField(11);
    JPanel jpClass = new JPanel();
    JLabel jlbClass = new JLabel("班级");
    JTextField jtfClass = new JTextField(11);

    StudentInfo studentInfo = null;
    Users users = null;


    public QueryForXIBUFrame(Users users) {
        this.users = users;
    }

    public void init(){
        jpQuery.add(jlbQurtyNum);
        jpQuery.add(jtfQueryNum);
        jpQuery.add(jbtQuery);
        jpNum.add(jlbNum);
        jpNum.add(jtfNum);

        jpName.add(jlbName);
        jpName.add(jtfName);

        jpgender.add(jlbGender);
        jpgender.add(jtfGender);

        jpAge.add(jlbAge);
        jpAge.add(jtfAge);

        jpMajor.add(jlbMajor);
        jpMajor.add(jtfMajor);

        jpClass.add(jlbClass);
        jpClass.add(jtfClass);

        Box vbox = Box.createVerticalBox();
        vbox.add(jpQuery);
        vbox.add(jpNum);
        vbox.add(jpName);
        vbox.add(jpgender);
        vbox.add(jpAge);
        vbox.add(jpMajor);
        vbox.add(jpClass);

        queryForCouFrame.add(vbox);
        queryForCouFrame.setVisible(true);
        queryForCouFrame.setSize(600, 400);
        queryForCouFrame.setLocationRelativeTo(null);
    }

    //XIBU查监听按钮
    public void jbtListener(){
        jbtQuery.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String textNum = jtfQueryNum.getText();

                    studentInfo = Function.queryForXIBUFunction(textNum);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                finally {
                    if (studentInfo != null){
                        JOptionPane.showMessageDialog(queryForCouFrame,"查询成功","消息对话框",JOptionPane.INFORMATION_MESSAGE);
                        setTextField();
                    }else {
                        JOptionPane.showMessageDialog(queryForCouFrame,"查询失败","消息对话框",JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });

        queryForCouFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                queryForCouFrame.setVisible(false);
            }
        });

    }

    //封装填充查询后的信息
    public void setTextField(){
        int infoNum = studentInfo.getNum();
        String num1 = ""+infoNum;
        String infoName = studentInfo.getName();
        String infoGender = studentInfo.getGender();
        int infoAge = studentInfo.getAge();
        String age = "" + infoAge;
        String infoMajor = studentInfo.getMajor();
        String infoClasses = studentInfo.getClasses();
        jtfNum.setText(num1);
        jtfName.setText(infoName);
        jtfGender.setText(infoGender);
        jtfAge.setText(age);
        jtfMajor.setText(infoMajor);
        jtfClass.setText(infoClasses);
    }
}

