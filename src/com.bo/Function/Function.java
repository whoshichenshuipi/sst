package com.bo.Function;


import com.bo.bean.StudentInfo;
import com.bo.bean.User;
import com.bo.bean.Users;
import com.bo.jdbcUtils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/*
    该功能类作用：以封装好相关的sql语句（起到限制作用），只允许通过学号进行增删改查操作。通过该功能类对工具类进行一定的包装，可通过以下的方法具体实现某些特定的功能
 */
public class Function {
    //通过学号实现查询功能
    public static StudentInfo queryForStudenInfoFunction(int num) throws Exception {
        //根据num搜索查询studentInfo功能的测试

        //StudentInfo studentInfo = JDBCUtil.queryForStudentinfo(sql, num);
        //System.out.println("studentInfo"+studentInfo);
        //return studentInfo;
        String sql = "select num,name,gender,age,major,classes,phone from studentinfo where num = ?";
        StudentInfo studentInfo = JDBCUtil.queryForSSS(sql,num);
        return studentInfo;
    }

    public static StudentInfo queryFornameFunction(String name) throws Exception {
        //根据学号num，搜索查询courseInfo功能的测试
        String sql = "select * from studentinfo where name=?";
        StudentInfo StudentInfo = JDBCUtil.queryForSSS(sql, name);;
        return StudentInfo;
    }

    public static Users queryForusersFunction(String user) throws Exception {
        //根据学号num，搜索查询courseInfo功能的测试
        String sql = "select * from users where user=?";
        Users users = JDBCUtil.queryForUSSS(sql, user);;
        return users;
    }


    public static StudentInfo queryForXIBUFunction(String xibu) throws Exception {
        //根
        String sql = "select * from studentinfo where major=?";
        StudentInfo StudentInfo = JDBCUtil.queryForSSS(sql, xibu);;
        return StudentInfo;
    }

    public static int queryCONoXFunction(String xiebie) throws Exception {
        //根据性别查renshu
        String sql = "select count(1) from studentinfo where gender=?";
         int studentInfo = JDBCUtil.queryForRSSS(sql, xiebie);;
        return studentInfo;
    }

    public static int queryCONoBFunction(String banji) throws Exception {
        String sql = "select count(1) from studentinfo where classes=?";
        int studentInfo = JDBCUtil.queryForRSSS(sql, banji);;
        return studentInfo;

    }

    public static int queryCONoBoXFunction(String banji) throws Exception {
        String sql = "select count(1) from studentinfo where major=?";
        int studentInfo = JDBCUtil.queryForRSSS(sql, banji);;
        return studentInfo;

    }


    public static String queryForALLFunction() throws Exception {
        //查所有
        String sql = "select * from studentinfo";
        String f = null;
        List<StudentInfo> StudentInfo = JDBCUtil.AllSelect(sql);
        for(int i=0;i<StudentInfo.size();i++){
            f += StudentInfo.get(i).toString();
        }


        System.out.println(f);

        return f;
    }

    public static StudentInfo queryBANJIFunction(String banji) throws Exception {
        //根据学号num，
        String sql = "select * from studentinfo where classes=?";
        StudentInfo StudentInfo = JDBCUtil.queryForSSS(sql, banji);;
        return StudentInfo;
    }
    //根据学号num，增删改
    //对studentInfo实现增加的功能
    public static Boolean createForStudentInfoFunction(int num,String name,String gender,int age,String major,String classes,int phone) throws Exception {
        String sql = "insert into studentinfo value(?,?,?,?,?,?,?)";
        JDBCUtil.update(sql,num,name,gender,age,major,classes,phone);
        return true;
    }

    //对School实现增加
    public static Boolean createForSchoolFunction(String sname,String slander,String phone,String createtiem,String phone2,String saddress,String sjianjie) throws Exception {
        String sql = "insert into school value(?,?,?,?,?,?,?)";
        JDBCUtil.update(sql,sname,slander,phone,createtiem,phone2,saddress,sjianjie);
        return true;
    }

    //对studentInfo实现删除的功能
    public static Boolean deleteForStudentInfoFunction(int num) throws Exception {
        String sql = "delete from studentinfo where num=?";
        JDBCUtil.update(sql,num);
        return true;
    }

    public static Boolean deleteForStudentInfoFunction(String banji) throws Exception {
        String sql = "delete from studentinfo where classes=?";
        JDBCUtil.update(sql,banji);
        return true;
    }

    public static Boolean deleteForStudentInfoXIBUFunction(String xibu) throws Exception {
        String sql = "delete from studentinfo where major=?";
        JDBCUtil.update(sql,xibu);
        return true;
    }
    //对studentInfo实现改的功能 --可利用重载进行单个的修改
    public static void updateForStudentInfoFunction(String major,String classes,int num) throws Exception {
        String sql = "update studentinfo set major=?,classes=? where num=?";  //只能该专业和班级
        JDBCUtil.update(sql,major,classes,num);
    }
    public static Boolean updateForStudentInfoFunctionOfMajor(String major,int num) throws Exception {
        String sql = "update studentinfo set major=? where num=?";  //只能该专业和班级
        JDBCUtil.update(sql,major,num);
        return true;
    }
    public static Boolean updateForUserFunctionOfPW(String pw,String user) throws Exception {
        String sql = "update users set password=? where user=?";  //只能该mima
        JDBCUtil.update(sql,pw,user);
        return true;
    }
    public static boolean updateForStudentInfoFunctionOfClasses(String classes,int num) throws Exception {
        String sql = "update studentinfo set classes=? where num=?";  //只能该专业和班级
        JDBCUtil.update(sql,classes,num);
        return true;
    }

    //对courseinfo实现增加的功能
    public static boolean createForCourseInfoFunction(int num,String name,String course,String credit) throws Exception {
        String sql = "insert into courseinfo value(?,?,?,?)";
        JDBCUtil.update(sql,num,name,course,credit);
        return true;
    }
    //对courseinfo实现删除的功能
    public static boolean deleteForCourseInfoFunction(int num) throws Exception {
        String sql = "update courseinfo set course='',credit='' where num=?";
        JDBCUtil.update(sql,num);
        return true;
    }
    //对courseinfo实现修改的功能
    public static void updateForCourseInfoFunction(String course,String credit,int num) throws Exception {
        String sql = "update courseinfo set course=?,credit=? where num=?";  //改课程和学分
        JDBCUtil.update(sql,course,credit,num);
    }
    public static boolean updateForCourseInfoFunctionOfCourse(String course,int num) throws Exception {
        String sql = "update courseinfo set course=? where num=?";  //改课程和学分
        JDBCUtil.update(sql,course,num);
        return true;
    }
    public static boolean updateForCourseInfoFunctionOfCredit(String credit,int num) throws Exception {
        String sql = "update courseinfo set credit=? where num=?";  //改课程和学分
        JDBCUtil.update(sql,credit,num);
        return true;
    }

    //验证是否已经存在该学生---验证学号即可  --true 表示已经存在该学号的学生
    public static boolean queryIsExitForStuFunction(int num) throws Exception {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from studentinfo";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            int numValue = rs.getInt(1);
            if (num == numValue){
                JDBCUtil.closeResource(connection,ps,rs);
                return true;
            }
        }
        JDBCUtil.closeResource(connection,ps,rs);
        return false;
    }

    //实现登入的功能,将从界面获得的账号和密码与数据库中的数据进行验证
    public static Boolean registerFunction(String user,String password) throws Exception {
        //测试登入功能
        String sql = "select * from users";
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            String userValue = rs.getString(1);
            String passwordValue = rs.getString(2);
            if (user.equals(userValue) && password.equals(passwordValue)){
                JDBCUtil.closeResource(connection,ps,rs);
                return true;
            }
        }
        JDBCUtil.closeResource(connection,ps,rs);
        return false;
    }
    public static Boolean registerFunctions(String user,String password) throws Exception {
        //测试登入功能
        String sql = "select * from user";
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            String userValue = rs.getString(1);
            String passwordValue = rs.getString(2);
            if (user.equals(userValue) && password.equals(passwordValue)){
                JDBCUtil.closeResource(connection,ps,rs);
                return true;
            }
        }
        JDBCUtil.closeResource(connection,ps,rs);
        return false;
    }
    public static String queryForUserFunctions(String user, String password) {
        //从前端得到用户名和密码，传入后端
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * from user";
            connection = JDBCUtil.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            User users = new User();
            while (rs.next()){
                String userValue = rs.getString(1);
                String passwordValue = rs.getString(2);
                int phone = rs.getInt(3);
                if (user.equals(userValue) && password.equals(passwordValue)){
                    users.setUser(userValue);
                    users.setPassword(passwordValue);
                    users.setPhone(phone);
                    JDBCUtil.closeResource(connection,ps,rs);
                    return user;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        JDBCUtil.closeResource(connection,ps,rs);
        return null;
    }

    //查询用户信息
    public static Users queryForUserFunction(String user, String password) {
        //从前端得到用户名和密码，传入后端
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * from users";
            connection = JDBCUtil.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            Users users = new Users();
            while (rs.next()){
                String userValue = rs.getString(1);
                String passwordValue = rs.getString(2);
                String privilegeValue = rs.getString(3);
                if (user.equals(userValue) && password.equals(passwordValue)){
                    users.setUser(userValue);
                    users.setPassword(passwordValue);
                    users.setPrivilege(privilegeValue);
                    JDBCUtil.closeResource(connection,ps,rs);
                    return users;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        JDBCUtil.closeResource(connection,ps,rs);
        return null;
    }

    //增加用户信息
    public static Boolean createForUsersFunction(String user,String password,String privilege) {
        String sql = "insert into users value(?,?,?)";
        try {
            JDBCUtil.update(sql,user,password,privilege);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return true;
    }
    public static Boolean createForUserFunction(String user,String password,int phone) {
        String sql = "insert into user value(?,?,?)";
        try {
            JDBCUtil.update(sql,user,password,phone);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return true;
    }
    //删除用户信息
    public static Boolean deleteForUsersFunction(String user) {
        String sql = "delete from users where user=?";

        try {
            JDBCUtil.update(sql, user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    //修改用户密码
    public static Boolean updateForUsersFunction(String user,String prePassword,String curPassword) {
        Boolean flag = null;
        try {
            flag = registerFunction(user, prePassword);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (flag){
            String sql = "update users set password=? where user=?";
            try {
                JDBCUtil.update(sql,curPassword,user);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return true;
        }
        return false;
    }

    public static boolean createSettinglFunction(String sjtna, String sjtau, int sjtvs, int sjtph, String sjtad, String sjtem) {
        String sql = "insert into status value(?,?,?,?,?,?)";
        try {
            JDBCUtil.update(sql,sjtna,sjtau,sjtvs,sjtph,sjtad,sjtem);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return true;
    }


}

