package com.bo.JutilsDemo;


import com.bo.myFrame.RegisterFrame;

import java.io.IOException;

//学生信息管理系统的测试类
public class TestDemo {



    public static void main(String[] args) throws IOException {

    	//创建登录界面对象
        RegisterFrame registerFrame = new RegisterFrame();
        //登录界面初试化
        registerFrame.init();
        //登录界面相关监听器
        registerFrame.buttonListenerForRegister();
        //注册界面
        registerFrame.buttonListenerForzhuce();

       System.out.println(System.getProperty("user.dir"));

    }
}

