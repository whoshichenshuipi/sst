package com.bo.myFrame;

import com.bo.Function.Function;
import com.bo.bean.Users;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class UpdateForStuPWFrame {
    Users users = null;

    JFrame UpdateForStuPWFrame = new JFrame("修改用户密码");
    JPanel jpQuery = new JPanel();
    JLabel jlbQueryNum = new JLabel("user");
    JTextField jtfQueryNum = new JTextField();
    JButton jbtQuery = new JButton("查询");

    JPanel jp = new JPanel();
    JLabel jlbEmpty = new JLabel("");
    JLabel jlbStu = new JLabel("用户信息");
    JLabel jlbUd = new JLabel("修改为");
    JLabel jlbIsUd = new JLabel("是否修改");


    JLabel jlbNum = new JLabel("用户");
    JTextField jtfNum = new JTextField(11);
    JTextField jtfUpToNum = new JTextField(11);



    JLabel jlbIsNameUd = new JLabel();
    JLabel jlbGender = new JLabel("密码");
    JTextField jtfGender = new JTextField(11);
    JTextField jtfUpToGender = new JTextField(11);
    JButton jbtMajor = new JButton("修改");

    JLabel jlbq = new JLabel();
    JLabel jlbMajor = new JLabel("权限");
    JTextField jtfMajor = new JTextField(11);
    JTextField jtfUpToMajor = new JTextField(11);



    String textNum = null;
    public UpdateForStuPWFrame(Users users){
        this.users = users;
    }


    public void init(){

        jpQuery.add(jlbQueryNum);
        jpQuery.add(jtfQueryNum);
        jpQuery.add(jbtQuery);

        jp.setLayout(new GridLayout(4,4));
        jp.add(jlbEmpty);
        jp.add(jlbStu);
        jp.add(jlbUd);
        jp.add(jlbIsUd);

        jp.add(jlbNum);
        jp.add(jtfNum);
        jp.add(jtfUpToNum);

        jp.add(jlbIsNameUd);

        jp.add(jlbGender);
        jp.add(jtfGender);
        jp.add(jtfUpToGender);
        //修改


        jp.add(jlbq);

        jp.add(jlbMajor);
        jp.add(jtfMajor);
        jp.add(jtfUpToMajor);
        jp.add(jbtMajor);



        Box vbox = Box.createVerticalBox();
        vbox.add(jpQuery);
        vbox.add(jp);

        UpdateForStuPWFrame.add(vbox);

        jtfQueryNum.setPreferredSize(new Dimension(100, 20));
        UpdateForStuPWFrame.setSize(600, 400);
        UpdateForStuPWFrame.setVisible(true);
        UpdateForStuPWFrame.setLocationRelativeTo(null);
    }
    //监听查询和修改按钮
    public void jbtListener(){
        //监听查询按钮
        jbtQuery.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    textNum = jtfQueryNum.getText();

                    users = Function.queryForusersFunction(textNum);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                finally {
                    if (users != null){
                        JOptionPane.showMessageDialog(UpdateForStuPWFrame,"查询成功","消息对话框",JOptionPane.INFORMATION_MESSAGE);
                        setTextField();
                        jtfQueryNum.setText("");
                    }else {
                        JOptionPane.showMessageDialog(UpdateForStuPWFrame,"查询失败","消息对话框",JOptionPane.INFORMATION_MESSAGE);
                    }
                }

            }
        });

        //监听修改按钮
        jbtMajor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ("管理员".equals(users.getPrivilege()) || users.getUser().equals(textNum)){
                    String mima = jtfUpToGender.getText();

                    Boolean flag = false;
                    try {
                        if (!mima.equals(""))
                            flag = Function.updateForUserFunctionOfPW(mima, users.getUser());
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    finally {
                        if (flag && !mima.equals("")){
                            JOptionPane.showMessageDialog(UpdateForStuPWFrame,"修改成功","消息对话框",JOptionPane.INFORMATION_MESSAGE);
                            jtfGender.setText(mima);
                            jtfUpToGender.setText("");
                        }else{
                            JOptionPane.showMessageDialog(UpdateForStuPWFrame,"修改失败","消息对话框",JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }else {
                    JOptionPane.showMessageDialog(UpdateForStuPWFrame,"非管理员或非本人操作，修改失败","消息对话框",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        //监听修改班级按钮


        UpdateForStuPWFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                UpdateForStuPWFrame.setVisible(false);
            }
        });

    }

    //封装填充查询后的信息
    public void setTextField(){
        String user = users.getUser();
        String password = users.getPassword();
        String privilege = users.getPrivilege();
        jtfNum.setText(user);
        jtfGender.setText(password);
        jtfMajor.setText(privilege);

    }
}
