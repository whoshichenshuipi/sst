package com.bo.myFrame;

import com.bo.Function.Function;
import com.bo.bean.Status;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateForStaFrame {
    Status status =null;
    JFrame settingF = new JFrame("设置状态信息");
    JButton jbt = new JButton("设置");
    //JPanel jpQuery = new JPanel();

    JLabel jlna = new JLabel("校名");
    JLabel jlau = new JLabel("作者");
    JLabel jlvs = new JLabel("版本");
    JLabel jlph = new JLabel("电话");
    JLabel jlad = new JLabel("地址");
    JLabel jlem = new JLabel("邮件");

    JTextField jtna = new JTextField(11);
    JTextField jtau = new JTextField(11);
    JTextField jtvs = new JTextField(11);
    JTextField jtph = new JTextField(11);
    JTextField jtad = new JTextField(11);
    JTextField jtem = new JTextField(11);

    JPanel jpna = new JPanel();
    JPanel jpau = new JPanel();
    JPanel jpvs = new JPanel();
    JPanel jpph = new JPanel();
    JPanel jpad = new JPanel();
    JPanel jpem = new JPanel();



    public UpdateForStaFrame(Status status) {
        this.status = status;
    }
    public void init(){
        jpna.add(jlna);
        jpna.add(jtna);

        jpad.add(jtad);
        jpad.add(jlad);

        jpau.add(jtau);
        jpau.add(jlau);

        jpem.add(jtem);
        jpem.add(jlem);

        jpph.add(jtph);
        jpph.add(jlph);

        jpvs.add(jtvs);
        jpvs.add(jlvs);
        Box vbox = Box.createVerticalBox();
        vbox.add(jpad);
        vbox.add(jpna);
        vbox.add(jpau);
        vbox.add(jpem);
        vbox.add(jpph);
        vbox.add(jpvs);
        settingF.add(vbox);
        settingF.add(jbt, BorderLayout.SOUTH);

        settingF.setVisible(true);
        settingF.setSize(600, 400);
        settingF.setLocationRelativeTo(null);
    }
    public void jbtListener() {
        jbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sjtna = jtna.getText();
                String sjtad = jtad.getText();
                String sjtau = jtau.getText();
                String sjtem = jtem.getText();
                int sjtph = Integer.parseInt(jtph.getText());
                int sjtvs = Integer.parseInt(jtvs.getText());


                boolean flag = false;
                try {
                    flag = Function.createSettinglFunction(sjtna, sjtau, sjtvs, sjtph, sjtad, sjtem);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                } finally {

                    if (flag) {
                        JOptionPane.showMessageDialog(settingF, "添加成功", "消息对话框", JOptionPane.INFORMATION_MESSAGE);

                        emptyTextField();
                    } else {
                        JOptionPane.showMessageDialog(settingF, "添加失败", "消息对话框", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }


        });
    }
        private void emptyTextField() {
            jtna.setText("");
            jtad.setText("");
            jtau.setText("");
            jtem.setText("");
            jtph.setText("");
            jtvs.setText("");
        }
}
