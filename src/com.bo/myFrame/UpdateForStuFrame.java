package com.bo.myFrame;

import com.bo.Function.Function;
import com.bo.bean.StudentInfo;
import com.bo.bean.Users;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//修改学生信息界面
public class UpdateForStuFrame {
    StudentInfo studentInfo = null;
    JFrame updateForStuFrame = new JFrame("修改学生信息");
    JPanel jpQuery = new JPanel();
    JLabel jlbQueryNum = new JLabel("学号");
    JTextField jtfQueryNum = new JTextField();
    JButton jbtQuery = new JButton("查询");

    JPanel jp = new JPanel();
    JLabel jlbEmpty = new JLabel("");
    JLabel jlbStu = new JLabel("学生信息");
    JLabel jlbUd = new JLabel("修改为");
    JLabel jlbIsUd = new JLabel("是否修改");

    JLabel jlbNum = new JLabel("学号");
    JTextField jtfNum = new JTextField(11);
    JTextField jtfUpToNum = new JTextField(11);
    JLabel jlbIsNumUd = new JLabel();
    JLabel jlbName = new JLabel("姓名");
    JTextField jtfName = new JTextField(11);
    JTextField jtfUpToName = new JTextField(11);
    JLabel jlbIsNameUd = new JLabel();

    JLabel jlbGender = new JLabel("性别");
    JTextField jtfGender = new JTextField(11);
    JTextField jtfUpToGender = new JTextField(11);
    JLabel jlbIsGenderUd = new JLabel();
    JLabel jlbAge = new JLabel("年龄");
    JTextField jtfAge = new JTextField(11);
    JTextField jtfUpToAge = new JTextField(11);
    JLabel jlbIsAgeUd = new JLabel();
    JLabel jlbMajor = new JLabel("专业");
    JTextField jtfMajor = new JTextField(11);
    JTextField jtfUpToMajor = new JTextField(11);
    JButton jbtMajor = new JButton("修改");
    JLabel jlbClass = new JLabel("班级");
    JTextField jtfClass = new JTextField(11);
    JTextField jtfUpToClass = new JTextField(11);
    JButton jbtClass = new JButton("修改");

    Users users = null;
    String textNum = null;
    public UpdateForStuFrame(Users users){
        this.users = users;
    }


    public void init(){
        
        jpQuery.add(jlbQueryNum);
        jpQuery.add(jtfQueryNum);
        jpQuery.add(jbtQuery);

        jp.setLayout(new GridLayout(7,4));
        jp.add(jlbEmpty);
        jp.add(jlbStu);
        jp.add(jlbUd);
        jp.add(jlbIsUd);

        jp.add(jlbNum);
        jp.add(jtfNum);
        jp.add(jtfUpToNum);
        jp.add(jlbIsNumUd);

        jp.add(jlbName);
        jp.add(jtfName);
        jp.add(jtfUpToName);
        jp.add(jlbIsNameUd);

        jp.add(jlbGender);
        jp.add(jtfGender);
        jp.add(jtfUpToGender);
        jp.add(jlbIsGenderUd);

        jp.add(jlbAge);
        jp.add(jtfAge);
        jp.add(jtfUpToAge);
        jp.add(jlbIsAgeUd);

        jp.add(jlbMajor);
        jp.add(jtfMajor);
        jp.add(jtfUpToMajor);
        jp.add(jbtMajor);

        jp.add(jlbClass);
        jp.add(jtfClass);
        jp.add(jtfUpToClass);
        jp.add(jbtClass);

        Box vbox = Box.createVerticalBox();
        vbox.add(jpQuery);
        vbox.add(jp);

        updateForStuFrame.add(vbox);
        
        jtfQueryNum.setPreferredSize(new Dimension(100, 20));
        updateForStuFrame.setSize(600, 400);
        updateForStuFrame.setVisible(true);
        updateForStuFrame.setLocationRelativeTo(null);
    }

    //监听查询和修改按钮
    public void jbtListener(){
        //监听查询按钮
        jbtQuery.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    textNum = jtfQueryNum.getText();
                    int num = Integer.parseInt(textNum);
                    studentInfo = Function.queryForStudenInfoFunction(num);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                finally {
                    if (studentInfo != null){
                        JOptionPane.showMessageDialog(updateForStuFrame,"查询成功","消息对话框",JOptionPane.INFORMATION_MESSAGE);
                        setTextField();
                        jtfQueryNum.setText("");
                    }else {
                        JOptionPane.showMessageDialog(updateForStuFrame,"查询失败","消息对话框",JOptionPane.INFORMATION_MESSAGE);
                    }
                }

            }
        });

        //监听修改按钮
        jbtMajor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ("管理员".equals(users.getPrivilege()) || users.getUser().equals(textNum)){
                    String major = jtfUpToMajor.getText();

                    Boolean flag = false;
                    try {
                        if (!major.equals(""))
                            flag = Function.updateForStudentInfoFunctionOfMajor(major, studentInfo.getNum());
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    finally {
                        if (flag && !major.equals("")){
                            JOptionPane.showMessageDialog(updateForStuFrame,"修改成功","消息对话框",JOptionPane.INFORMATION_MESSAGE);
                            jtfMajor.setText(major);
                            jtfUpToMajor.setText("");
                        }else{
                            JOptionPane.showMessageDialog(updateForStuFrame,"修改失败","消息对话框",JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }else {
                    JOptionPane.showMessageDialog(updateForStuFrame,"非管理员或非本人操作，修改失败","消息对话框",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        //监听修改班级按钮
        jbtClass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    String classes = jtfUpToClass.getText();

                    boolean flag = false;
                    try {
                        if (!classes.equals(""))
                            flag = Function.updateForStudentInfoFunctionOfClasses(classes,studentInfo.getNum());
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    finally {
                        if (flag && !classes.equals("")){
                            JOptionPane.showMessageDialog(updateForStuFrame,"修改成功","消息对话框",JOptionPane.INFORMATION_MESSAGE);
                            jtfClass.setText(classes);
                            jtfUpToClass.setText("");
                        }else {
                            JOptionPane.showMessageDialog(updateForStuFrame,"修改失败","消息对话框",JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }

        });

        updateForStuFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                updateForStuFrame.setVisible(false);
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


