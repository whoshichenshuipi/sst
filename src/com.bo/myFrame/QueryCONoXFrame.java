package com.bo.myFrame;

import com.bo.Function.Function;
import com.bo.bean.StudentInfo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class QueryCONoXFrame {
    StudentInfo studentInfo = null;
    JFrame queryCONoXFrame = new JFrame("根据性别查询人数");

    JPanel jpQuery = new JPanel();
    JLabel jlbQurtyNum = new JLabel("XIBie");
    JTextField jtfQueryNum = new JTextField(11);
    JButton jbtQuery = new JButton("查询");

    JPanel jpNum = new JPanel();
    JLabel jlbNum = new JLabel("人数");
    JTextField jtfNum = new JTextField(11);

    public QueryCONoXFrame(StudentInfo studentInfo) {
        this.studentInfo = studentInfo;
    }

    public void init(){
        jpQuery.add(jlbQurtyNum);
        jpQuery.add(jtfQueryNum);
        jpQuery.add(jbtQuery);
        jpNum.add(jlbNum);
        jpNum.add(jtfNum);


        Box vbox = Box.createVerticalBox();
        vbox.add(jpQuery);
        vbox.add(jpNum);


        queryCONoXFrame.add(vbox);
        queryCONoXFrame.setVisible(true);
        queryCONoXFrame.setSize(600, 400);
        queryCONoXFrame.setLocationRelativeTo(null);
    }
    public void jbtListener(){
        jbtQuery.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num = 0;
                try {
                    String textNum = jtfQueryNum.getText();

                    num = Function.queryCONoXFunction(textNum);
                    jtfNum.setText(String.valueOf(num));
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                finally {
                    if (num != 0){
                        JOptionPane.showMessageDialog(queryCONoXFrame,"查询成功","消息对话框",JOptionPane.INFORMATION_MESSAGE);
                        setTextField();
                    }else {
                        JOptionPane.showMessageDialog(queryCONoXFrame,"查询失败","消息对话框",JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }


        });

        queryCONoXFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                queryCONoXFrame.setVisible(false);
            }
        });

    }
    public void setTextField() {
        jtfQueryNum.setText("");
    }
}
