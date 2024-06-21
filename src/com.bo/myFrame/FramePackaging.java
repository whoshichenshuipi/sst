package com.bo.myFrame;

import com.bo.bean.School;
import com.bo.bean.Status;
import com.bo.bean.StudentInfo;
import com.bo.bean.Users;

//界面管理类。负责包装所有的界面。只要调用该类中的方法，即可创建出相应的界面并且监听该界面。
public class FramePackaging {
    //设值学校界面
    public static void getCLFrame(School school){
        CreateCLFrame createCLFrame = new CreateCLFrame(school);
        createCLFrame.init();
        createCLFrame.jbtListener();
    }
    public static void getHandleFrame(Users users){
       HandleFrame handleFrame = new HandleFrame(users);
        handleFrame.init();
        handleFrame.jbtListener();
    }
    public static void getCSFrame(Users users){
        CreateForStuFrame createForStuFrame = new CreateForStuFrame(users);
        createForStuFrame.init();
        createForStuFrame.jbtListener();
    }


    public static void getDSFrame(Users users){
        DeleteForStuFrame deleteForStuFrame = new DeleteForStuFrame(users);
        deleteForStuFrame.init();
        deleteForStuFrame.jbtListener();
    }



    public static void getQSFrame(Users users){
        QueryForStuFrame queryForStuFrame = new QueryForStuFrame(users);
        queryForStuFrame.init();
        queryForStuFrame.jbtLister();
    }


    //根据班级查
    public static void getBANJIFrame(Users users){
        QueryBANJIFrame queryBANJIFrame = new QueryBANJIFrame(users);
        queryBANJIFrame.init();
        queryBANJIFrame.jbtLister();
    }
    public static void getUSFrame(Users users){
        UpdateForStuFrame updateForStuFrame = new UpdateForStuFrame(users);
        updateForStuFrame.init();
        updateForStuFrame.jbtListener();
    }
    //根据名字查
    public static void getnameFrame(Users users){
        QueryFornameFrame queryFornameFrame = new QueryFornameFrame(users);
        queryFornameFrame.init();
        queryFornameFrame.jbtLister();
    }

    //设置状态
    public static void getStauFrame(Status status) {
       UpdateForStaFrame updateForStaFrame = new UpdateForStaFrame(status);
        updateForStaFrame.init();
        updateForStaFrame.jbtListener();
    }

    public static void getIDFrame(Users users) {
        QueryForStuFrame queryForidFrame = new QueryForStuFrame(users);
        queryForidFrame.init();
        queryForidFrame.jbtLister();
    }
    //根据西部查 未
    public static void getXIBUFrame(Users users) {
        QueryForXIBUFrame queryForidFrame = new QueryForXIBUFrame(users);
        queryForidFrame.init();
        queryForidFrame.jbtListener();
    }

    //修改密码
    public static void getUPPSFrame(Users users) {
        UpdateForStuPWFrame updateForStuPWFrame = new UpdateForStuPWFrame(users);
        updateForStuPWFrame.init();
        updateForStuPWFrame.jbtListener();
    }

    public static void getCONoXFrame(StudentInfo studentInfo) {
        QueryCONoXFrame queryCONoXFrame = new QueryCONoXFrame(studentInfo);
        queryCONoXFrame.init();
        queryCONoXFrame.jbtListener();
    }


    //查全部
    public static void getALLFrame() throws Exception {
        QueryALLFrame queryALLFrame = new QueryALLFrame();
        queryALLFrame.createAndShowGUI();
    }

    public static void getCONoBFrame(StudentInfo studentInfo) {
        QueryCONoBFrame queryCONoBFrame = new QueryCONoBFrame(studentInfo);
        queryCONoBFrame.init();
        queryCONoBFrame.jbtListener();
    }
    public static void getCONoBoXFrame(StudentInfo studentInfo) {
        QueryCONoBoXFrame queryCONoBoXFrame = new QueryCONoBoXFrame(studentInfo);
        queryCONoBoXFrame.init();
        queryCONoBoXFrame.jbtListener();
    }

    //根据学号删除学生
    public static void getDeXFrame(StudentInfo studentInfo) {
        DeleteForXFrame deleteForXFrame = new DeleteForXFrame();
        deleteForXFrame.init();
        deleteForXFrame.jbtLister();
    }
//根据班级
    public static void getDeBFrame(StudentInfo studentInfo) {
        DeleteForBFrame deleteForBFrame = new DeleteForBFrame();
        deleteForBFrame.init();
        deleteForBFrame.jbtLister();
    }

    public static void getDeXBFrame(StudentInfo studentInfo) {
        DeleteForBXFrame deleteForXBFrame = new DeleteForBXFrame();
        deleteForXBFrame.init();
        deleteForXBFrame.jbtLister();
    }
    public static void getBZFrame() {
        xianshiBZXFrame xianshibzFrame = new xianshiBZXFrame();
        xianshibzFrame.createAndShowGUI();
        //xianshibzFrame.jbtLister();
    }
    public static void getGYFrame() {
        xianshiGYFrame xianshigyFrame = new xianshiGYFrame();
        xianshigyFrame.createAndShowGUI();
    }

}


