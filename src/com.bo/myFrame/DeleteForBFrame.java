package com.bo.myFrame;

import com.bo.Function.Function;
import com.bo.bean.StudentInfo;
import com.bo.bean.Users;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DeleteForBFrame {
    JFrame jf = new JFrame("按照班级删除学生信息");

    JPanel jpQuery = new JPanel();
    JLabel jlbQueryNum = new JLabel("班级");
    JTextField jtfQueryNum = new JTextField(11);
    JButton jbtQuery = new JButton("查询");
    JPanel JPd = new JPanel();
    JButton jbD = new JButton("删除");

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
    JLabel jlbMajor = new JLabel("专业");
    JTextField jtfMajor = new JTextField(11);
    JPanel jpClass = new JPanel();
    JLabel jlbClass = new JLabel("班级");
    JTextField jtfClass = new JTextField(11);

    Users users = null;
    public DeleteForBFrame(){
    }

    public void init() {
        jpQuery.add(jlbQueryNum);
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
        JPd.add(jbD);

        Box vbox = Box.createVerticalBox();
        vbox.add(jpQuery);
        vbox.add(jpNum);
        vbox.add(jpName);
        vbox.add(jpgender);
        vbox.add(jpAge);
        vbox.add(jpMajor);
        vbox.add(jpClass);
        vbox.add(jpClass);
        vbox.add(JPd);

        jf.add(vbox);
        jf.setSize(600, 400);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
    }
    StudentInfo studentInfo = null;

    public void jbtLister(){
        jbtQuery.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String textNUm = jtfQueryNum.getText();
                    studentInfo = Function.queryBANJIFunction(textNUm);
                    System.out.println("ss"+studentInfo);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                finally {
                    if (studentInfo != null){
                        JOptionPane.showMessageDialog(jf,"查询成功","消息对话框",JOptionPane.INFORMATION_MESSAGE);
                        queryFlash();
                        //jtfQueryNum.setText("");
                    }else {
                        JOptionPane.showMessageDialog(jf,"查询失败","消息对话框",JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });


        jf.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                jf.setVisible(false);
            }
        });
        jbD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String banji = jtfQueryNum.getText();
                try {
                    if(!banji.equals("")){
                        Function.deleteForStudentInfoFunction(banji);
                        JOptionPane.showMessageDialog(jf,"删除成功","消息对话框",JOptionPane.INFORMATION_MESSAGE);
                        cleans();
                    }else{
                        JOptionPane.showMessageDialog(jf,"查询失败","消息对话框",JOptionPane.INFORMATION_MESSAGE);

                    }


                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }


        });


    }
    private void cleans() {
        jtfQueryNum.setText("");
        jtfNum.setText("");
        jtfName.setText("");
        jtfGender.setText("");
        jtfAge.setText("");
        jtfMajor.setText("");
        jtfClass.setText("");
    }
    public void queryFlash(){
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
