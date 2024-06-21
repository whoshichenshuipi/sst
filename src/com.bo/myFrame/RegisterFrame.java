package com.bo.myFrame;

import com.bo.Function.Function;
import com.bo.bean.Users;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterFrame extends JFrame {

		Users users = new Users();

	    //创建组件
	    JFrame jFrame = new JFrame("登录系统");
	    JPanel jpUser = new JPanel();
	    JLabel jlbUser = new JLabel("账号");
	    JTextField jtfUser = new JTextField(33);

	    JPanel jpPassword = new JPanel();
	    JLabel jlbPassWord = new JLabel("密码");
	    JTextField jtfPassWord = new JTextField(33);

		JPanel jpPhone = new JPanel();
		JLabel jlbPone = new JLabel("电话");
		JTextField jtfPhone = new JTextField(33);

	    JButton jbt = new JButton("登录");
		JButton jbtz = new JButton("注册");

	    public void init() {
	        jpUser.add(jlbUser);
	        jpUser.add(jtfUser);

			jpPhone.add(jtfPhone);
			jpPhone.add(jlbPone);

	        jpPassword.add(jlbPassWord);
	        jpPassword.add(jtfPassWord);
			JPanel ff = new JPanel();

			ff.add(jbt, BorderLayout.WEST);
			ff.add(jbtz,BorderLayout.EAST);

	        Box vbox = Box.createVerticalBox();
	        vbox.add(jpUser);
	        vbox.add(jpPassword);
	        vbox.add(jpPhone);
	        //vbox.add(ff);
	        jFrame.add(vbox);
	        jFrame.add(ff, BorderLayout.SOUTH);


	        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        jFrame.setSize(600, 400);
	        jFrame.setVisible(true);
	        jFrame.setLocationRelativeTo(null);
	    }

		public void buttonListenerForzhuce() {
			jbtz.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String user = jtfUser.getText();
					String password = jtfPassWord.getText();
					int phone = Integer.parseInt(jtfPhone.getText());
					Boolean flag = false;
					try {
						//将账号和密码与数据库进行匹配
						flag = Function.registerFunction(user, password);
					} catch (Exception ex) {
						throw new RuntimeException(ex);
					} finally {

						Boolean b  = Function.createForUserFunction(user, password,phone);

						if (b) {

							//切换新的页面--操作页面---并将该用户信息传入下一个界面
							JOptionPane.showMessageDialog(jFrame, "注册成功" + "\n"+ "你好！"+ users.getPrivilege() + "!", "消息对话框", JOptionPane.INFORMATION_MESSAGE);

							//createForCLFrame.addWindowListener(new );
							emptyTextField();
						} else {
							JOptionPane.showMessageDialog(jFrame, "注册失败", "消息对话框", JOptionPane.INFORMATION_MESSAGE);
						}
//						//若账号密码匹配正确：
//						if (flag) {
//							//增加当前用户信息（账号、密码和权限）
//							Boolean b  = Function.createForUserFunction(user, password,phone);
//							//切换新的页面--操作页面---并将该用户信息传入下一个界面
//							JOptionPane.showMessageDialog(jFrame, "注册成功" + "\n"+ "你好！"+ users.getPrivilege() + "!", "消息对话框", JOptionPane.INFORMATION_MESSAGE);
//							//转入下一个界面
//							FramePackaging.getHandleFrame(users);
//							//转入到下一个界面后，关闭该界面
//							jFrame.setVisible(false);
//						}else{
//							JOptionPane.showMessageDialog(jFrame, "账号或密码错误", "消息对话框", JOptionPane.INFORMATION_MESSAGE);
//						}
					}

				}
			});
		}


	    public void buttonListenerForRegister() {
	        jbt.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                String user = jtfUser.getText();
	                String password = jtfPassWord.getText();
	                Boolean flag = false;
	                Boolean ss = false;
	                try {
	                    //将账号和密码与数据库进行匹配
	                    flag = Function.registerFunction(user, password);

	                } catch (Exception ex) {
	                    throw new RuntimeException(ex);
	                }
					try {
						ss = Function.registerFunctions(user, password);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					if(ss){
						user = Function.queryForUserFunctions(user, password);
					}
					//若账号密码匹配正确：
	                if (flag) {
	                    //返回当前用户信息（账号、密码和权限）
	                    users = Function.queryForUserFunction(user, password);
	                    //切换新的页面--操作页面---并将该用户信息传入下一个界面
	                    JOptionPane.showMessageDialog(jFrame, "登录成功" + "\n"+ "你好！"+ users.getPrivilege() + "!", "消息对话框", JOptionPane.INFORMATION_MESSAGE);
	                    //转入下一个界面
	                    FramePackaging.getHandleFrame(users);
	                    //转入到下一个界面后，关闭该界面
	                    jFrame.setVisible(false);
	                }else{
	                    JOptionPane.showMessageDialog(jFrame, "账号或密码错误", "消息对话框", JOptionPane.INFORMATION_MESSAGE);
	                }
	            }
	        });
	    }
	public void emptyTextField() {
		jtfUser.setText("");
		jtfPassWord.setText("");
		jtfPhone.setText("");

	}

    

}


