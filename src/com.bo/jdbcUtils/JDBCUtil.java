package com.bo.jdbcUtils;


import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.bo.bean.StudentInfo;
import com.bo.bean.Users;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

//工具类。其中包含：连接数据库、关闭资源、对数据库增删该查操作的一些通用基础的操作方法，没有限制条件。可由传入的sql语句包装该工具类，实现特定的功能。
public class JDBCUtil {
    //封装获取连接的方法
    public static Connection getConnection() throws Exception {
//        Class.forName("com.mysql.jdbc.Driver");
//        String url = "jdbc:mysql://localhost:3306/student";
//        String user = "root";
//        String password = "root";
//        Connection connection = DriverManager.getConnection(url, user, password);
//        return connection;
          Properties prop = new Properties();
            prop.load(new FileInputStream("system/src/com.bo/druid.properties"));
            DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
            Connection conn = dataSource.getConnection();
            return conn;
    }
    //封装资源关闭的方法
    public static void closeResource(Connection connection, PreparedStatement ps){
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    //封装资源关闭的方法（重载）
    public static void closeResource(Connection connection, PreparedStatement ps, ResultSet rs){
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //封装查询studentinfo

    //id查询
    public static StudentInfo IdSelect(int num) throws Exception {

        Connection conn = getConnection();
        String sql = "select * from studentinfo where num = ?";
        //预编译sql，返回preparedstatement的实例
            PreparedStatement pstt = conn.prepareStatement(sql,num);

            //填充占位符
            pstt.setInt(1,num);

            //设值禅数
            //执行
            ResultSet rs = pstt.executeQuery();


            while(rs.next()){
                //获取数据

                int num1 = rs.getInt("num");
                String name = rs.getString("NAME");
                String gender = rs.getString("gender");
                int age = rs.getInt("age");
                String major = rs.getString("major");
                String classes = rs.getString("classes");
                int phone = rs.getInt("phone");


                //封装对象
                StudentInfo studentInfo = new StudentInfo(num1, name, gender, age, major, classes, phone);
                return studentInfo;
            }
            //释放资源

            closeResource(conn,pstt, rs);
            return null;
        }
    //封装查询xibu
//    public static StudentInfo queryForXIBUInfo(String major, String xibu) throws Exception {
////        Properties prop = new Properties();
////        prop.load(new FileInputStream("system/src/com.bo/druid.properties"));
////        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
////        Connection conn = dataSource.getConnection();
//        Connection conn = getConnection();
//
//        String sql = "select * from studentinfo where major = ?";
//
//        PreparedStatement pstt = conn.prepareStatement(sql);
//        pstt.setObject(1, major);
//
////        String sql = "select * from studentinfo where major = ?";
////        PreparedStatement pstt = conn.prepareStatement(sql, Integer.parseInt(major));
//
//        //pstt.setString(1,major);
//
//        //设值禅数
//        //执行
//        ResultSet rs = pstt.executeQuery();
//
//        while(rs.next()){
//            //获取数据
//
//            int num1 = rs.getInt("num");
//            String name = rs.getString("NAME");
//            String gender = rs.getString("gender");
//            int age = rs.getInt("age");
////            String major1 = rs.getString("major");
//            String classes = rs.getString("classes");
//            int phone = rs.getInt("phone");
//
//
//            //封装对象
//            StudentInfo studentInfo = new StudentInfo(num1, name, gender, age, major, classes, phone);
//            System.out.println(studentInfo);
//            return studentInfo;
//        }
//        //释放资源
//
//        closeResource(conn,pstt, rs);
//        return null;
//    }
    public static List<StudentInfo> AllSelect(String sql,Object...args) throws Exception{
        List<StudentInfo> studentInfos = new ArrayList<StudentInfo>();
        Connection con = JDBCUtil.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        for (int i=0;i<args.length;i++){
            ps.setObject(i+1,args[i]);
        }

        ResultSet rs = ps.executeQuery();
        //获取元数据
        ResultSetMetaData rsmd = rs.getMetaData();
        //获取列数
        int columnCount = rsmd.getColumnCount();
        if(rs.next()){
            StudentInfo studentInfo = new StudentInfo();
            for(int i=0;i<columnCount;i++){
                Object value = rs.getObject(i + 1);
                String columnName = rsmd.getColumnName(i + 1);
                Field field = StudentInfo.class.getDeclaredField(columnName);
                field.setAccessible(true);
                field.set(studentInfo,value);
            }
            studentInfos.add(studentInfo);

            return studentInfos;
        }
        JDBCUtil.closeResource(con,ps,rs);
        return null;

    }

    //基本查询单个
    public static StudentInfo queryForSSS(String sql,Object...args) throws Exception {

        Connection con = JDBCUtil.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        for (int i=0;i<args.length;i++){
            ps.setObject(i+1,args[i]);
        }

        ResultSet rs = ps.executeQuery();
        //获取元数据
        ResultSetMetaData rsmd = rs.getMetaData();
        //获取列数
        int columnCount = rsmd.getColumnCount();
        if(rs.next()){
            StudentInfo studentInfo = new StudentInfo();
            for(int i=0;i<columnCount;i++){
                Object value = rs.getObject(i + 1);
                String columnName = rsmd.getColumnName(i + 1);
                Field field = StudentInfo.class.getDeclaredField(columnName);
                field.setAccessible(true);
                field.set(studentInfo,value);
            }

            return studentInfo;
        }
        JDBCUtil.closeResource(con,ps,rs);
        return null;
    }

    //查数量
    public static int queryForRSSS(String sql,Object...args) throws Exception {
        int num =0;
        Connection con = JDBCUtil.getConnection();
        PreparedStatement ps =  con.prepareStatement(sql);
        for (int i=0;i<args.length;i++){
            ps.setObject(i+1,args[i]);
        }
        ResultSet rs = ps.executeQuery();
        //获取元数据
        ResultSetMetaData rsmd = rs.getMetaData();
        //获取列数
        int columnCount = rsmd.getColumnCount();
        if(rs.next()){
               num = rs.getInt(1);

//            for(int i=0;i<columnCount;i++){
//                Object value = rs.getObject(i + 1);
//                String columnName = rsmd.getColumnName(i + 1);
//                Field field = StudentInfo.class.getDeclaredField(columnName);
//                field.setAccessible(true);
//
//                field.set(num,value);
//            }
            return num;
        }
        JDBCUtil.closeResource(con,ps,rs);
        return num;

    }



    //查用户
    public static Users queryForUSSS(String sql, Object...args) throws Exception {
        Connection con = JDBCUtil.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        for (int i=0;i<args.length;i++){
            ps.setObject(i+1,args[i]);
        }
        ResultSet rs = ps.executeQuery();
        //获取元数据
        ResultSetMetaData rsmd = rs.getMetaData();
        //获取列数
        int columnCount = rsmd.getColumnCount();
        if(rs.next()){
            Users users = new Users();
            for(int i=0;i<columnCount;i++){
                Object value = rs.getObject(i + 1);
                String columnName = rsmd.getColumnName(i + 1);
                //反射
                Field field = Users.class.getDeclaredField(columnName);

                field.setAccessible(true);
                field.set(users,value);
            }
            return users;
        }
        JDBCUtil.closeResource(con,ps,rs);
        return null;
    }



    //封装增删改操作的方法
    public static void update(String sql,Object...args) {
        Connection connection = null;
        PreparedStatement ps =null;
        try {
            connection = getConnection();
            ps = connection.prepareStatement(sql);
            if (args != null) {
                for (int i = 0; i < args.length; i++) {
                    ps.setObject(i + 1, args[i]);
                }
            }
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeResource(connection,ps);
        }


    }

}
