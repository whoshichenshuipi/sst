package com.bo.myFrame;


import com.bo.bean.School;
import com.bo.bean.Status;
import com.bo.bean.StudentInfo;
import com.bo.bean.Users;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//菜单界面---该界面主要起这个系统的主界面使用，负责连接其余的所有界面，关闭该界面则系统退出。
public class HandleFrame extends JFrame {
    JFrame jf = new JFrame("菜单");
    JPanel jp = new JPanel();
    JPanel jp1 = new JPanel();
    
    JMenuBar jMenuBar = new JMenuBar();
    JMenu jmnStu = new JMenu("学生信息");
    JMenu jmnsetting = new JMenu("设置信息");
    JMenu jmnCou = new JMenu("查询学生");
    JMenu jmncnn = new JMenu("人数统计");
    JMenu jmnbz = new JMenu("帮助模块");


    JMenuItem jbtinsertScho = new JMenuItem("设置学校信息");
    JMenuItem jbtinsertStau = new JMenuItem("设置状态栏信息");
    JMenuItem jbtupdatepw = new JMenuItem("修改密码");

    JMenuItem jbtCreateStu = new JMenuItem("增加学生信息");
    JMenuItem jbtDeleteStu = new JMenuItem("删除学生信息");

    JMenuItem jbtUpdateStu = new JMenuItem("修改学生信息");
    JMenuItem jbtQueryStu = new JMenuItem("浏览学生信息");

    //查询
    JMenuItem jbtIDCou = new JMenuItem("按照学号查询");
    JMenuItem jbtXBUCou = new JMenuItem("按照系部查询");
    JMenuItem jbtNAMECou = new JMenuItem("按照姓名查询");
    JMenuItem jbtBANJICou = new JMenuItem("按照班级查询");

    JMenuItem jbtCONoX = new JMenuItem("按照性别统计");
    JMenuItem jbtCONoB = new JMenuItem("按照班机统计");
    JMenuItem jbtCONoXB = new JMenuItem("按照西部统计");

    JMenuItem jbtGY = new JMenuItem("关于");
    JMenuItem jbtBZ = new JMenuItem("帮助");

    JButton jbtUser = new JButton();
    JButton jbtPrivilege = new JButton();

    Users users = null;
    School school = null;
    Status status = null;
    StudentInfo studentInfo = null;

    public HandleFrame(School school) {
        this.school = school;
    }

    public HandleFrame(Users users){
        this.users = this.users;
    }

    public void init() {
    	jmnStu.add(jbtCreateStu);
    	jmnStu.add(jbtDeleteStu);
    	jmnStu.add(jbtUpdateStu);
    	jmnStu.add(jbtQueryStu);

        jmnsetting.add(jbtinsertScho);
        jmnsetting.add(jbtinsertStau);
        jmnsetting.add(jbtupdatepw);

    	jmnCou.add(jbtIDCou);
    	jmnCou.add(jbtXBUCou);
    	jmnCou.add(jbtNAMECou);
    	jmnCou.add(jbtBANJICou);

        jmncnn.add(jbtCONoX);
        jmncnn.add(jbtCONoB);
        jmncnn.add(jbtCONoXB);

        jmnbz.add(jbtGY);
        jmnbz.add(jbtBZ);
        //jmnbz.add();

    	jMenuBar.add(jmnStu);
    	jMenuBar.add(jmnCou);
        jMenuBar.add(jmnsetting);
        jMenuBar.add(jmncnn);
        jMenuBar.add(jmnbz);

    	
        jf.add(jMenuBar, BorderLayout.NORTH);
        jf.add(jp1);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.setSize(600, 400);
        jf.setLocationRelativeTo(null);
    }

    //监听按钮
    public void jbtListener(){
        //设置状态栏信息
        jbtinsertStau.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FramePackaging.getStauFrame(status);
            }
        });

        jbtupdatepw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FramePackaging.getUPPSFrame(users);
            }
        });
        //增加学校信息
        jbtinsertScho.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FramePackaging.getCLFrame(school);
            }
        });

        jbtCreateStu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //弹出增加学生信息界面
                FramePackaging.getCSFrame(users);

            }
        });
        jbtIDCou.addActionListener(new ActionListener() {
            @Override//根据增加ID查询信息界面
            public void actionPerformed(ActionEvent e) {


                FramePackaging.getIDFrame(users);
            }
        });
        jbtDeleteStu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //弹出删除学生信息界面
                FramePackaging.getDSFrame(users);
            }
        });
        jbtXBUCou.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //XIBU
                FramePackaging.getXIBUFrame(users);
            }
        });
        jbtUpdateStu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //弹出修改学生信息界面
                FramePackaging.getUSFrame(users);
            }
        });
        //根据na'me查
        jbtNAMECou.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //name
                FramePackaging.getnameFrame(users);
            }
        });

        jbtQueryStu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //弹出学生信息界面
                try {
                    FramePackaging.getALLFrame();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        //根据班级查
        jbtBANJICou.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                FramePackaging.getBANJIFrame(users);
            }
        });
        jbtCONoX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FramePackaging.getCONoXFrame(studentInfo);
            }
        });
        jbtCONoB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FramePackaging.getCONoBFrame(studentInfo);
            }
        });
        jbtCONoXB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FramePackaging.getCONoBoXFrame(studentInfo);
            }
        });
        jbtGY.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FramePackaging.getBZFrame();
            }
        });
        jbtBZ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FramePackaging.getGYFrame();
            }
        });
    }

}


