package com.bo.myFrame;

import com.bo.bean.StudentInfo;
import com.bo.bean.Users;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//shanchu信息界面
public class DeleteForStuFrame extends JFrame{
    StudentInfo studentInfo = null;
    JFrame jf = new JFrame("删除学生信息");
    JPanel jp1 = new JPanel();

    JMenu jm = new JMenu("删除");
    JMenuBar jMenuBar = new JMenuBar();

    JMenuItem jbtDxStu = new JMenuItem("学号删除学生信息");
    JMenuItem jbtDbStu = new JMenuItem("班级删除学生信息");
    JMenuItem jbtDxiStu = new JMenuItem("西部删除学生信息");




    Users users = null;
    String textNum = null;
    public DeleteForStuFrame(Users users){
        this.users = users;
    }

    //组装组件
    public void init(){
        jm.add(jbtDxStu);
        jm.add(jbtDbStu);
        jm.add(jbtDxiStu);

        jMenuBar.add(jm);
        jf.add(jMenuBar, BorderLayout.NORTH);
        jf.add(jp1);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.setSize(600, 400);
        jf.setLocationRelativeTo(null);

    }


    public void jbtListener(){
        jbtDxStu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FramePackaging.getDeXFrame(studentInfo);
            }
        });
        jbtDbStu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FramePackaging.getDeBFrame(studentInfo);
            }
        });
        jbtDxiStu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FramePackaging.getDeXBFrame(studentInfo);
            }
        });

    }

    //监听按钮分别进行查询和删除
//    public void jbtListener(){
//        //监听查询按钮
//        jbtQuery.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    textNum = jtfQueryNum.getText();
//                    int num = Integer.parseInt(textNum);
//                    studentInfo = Function.queryForStudenInfoFunction(num);
//                } catch (Exception ex) {
//                    throw new RuntimeException(ex);
//                }
//                finally {
//                    if (studentInfo != null){
//                        JOptionPane.showMessageDialog(deleteForStuFrame,"查询成功","消息对话框",JOptionPane.INFORMATION_MESSAGE);
//                        //将获取的数据填充文本框
//                        setTextField();
//                        //查询成功的同时，清空刚才手动输入的文本框
//                        jtfQueryNum.setText("");
//                    }else {
//                        JOptionPane.showMessageDialog(deleteForStuFrame,"查询失败","消息对话框",JOptionPane.INFORMATION_MESSAGE);
//                    }
//                }
//            }
//        });
//
//        //监听Id删除按钮
//        jbtDelete.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                    String user = null;
//                    Boolean flag = false;
//                    try {
//                            flag = 	 Function.deleteForStudentInfoFunction(studentInfo.getNum());
//                    } catch (Exception ex) {
//                        throw new RuntimeException(ex);
//                    }
//                    finally {
//                        if (flag && studentInfo != null){
//                            JOptionPane.showMessageDialog(deleteForStuFrame,"删除成功","消息对话框",JOptionPane.INFORMATION_MESSAGE);
//                            emptyTextField();
//                            //学生信息被删除的同时，该学生的课程信息和用户信息也被删除
//                            try {
//                              Function.deleteForCourseInfoFunction(studentInfo.getNum());
//                                Function.deleteForUsersFunction(user);
//                            } catch (Exception ex) {
//                                throw new RuntimeException(ex);
//                            }
//
//                        }else{
//                            JOptionPane.showMessageDialog(deleteForStuFrame,"删除失败","消息对话框",JOptionPane.INFORMATION_MESSAGE);
//                        }
//                    }
//                }
//        });
//
//        deleteForStuFrame.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                deleteForStuFrame.setVisible(false);
//            }
//        });
//
//    }
//
//    //封装填充文本框
//    public void setTextField(){
//        int infoNum = studentInfo.getNum();
//        String num1 = ""+infoNum;
//        String infoName = studentInfo.getName();
//        String infoGender = studentInfo.getGender();
//        int infoAge = studentInfo.getAge();
//        String age = "" + infoAge;
//        String infoMajor = studentInfo.getMajor();
//        String infoClasses = studentInfo.getClasses();
//        jtfNum.setText(num1);
//        jtfName.setText(infoName);
//        jtfGender.setText(infoGender);
//        jtfAge.setText(age);
//        jtfMajor.setText(infoMajor);
//        jtfClass.setText(infoClasses);
//    }
//
//    //封装清空所有文本框
//    public void emptyTextField(){
//        jtfNum.setText("");
//        jtfName.setText("");
//        jtfGender.setText("");
//        jtfAge.setText("");
//        jtfMajor.setText("");
//        jtfClass.setText("");
//    }
}

