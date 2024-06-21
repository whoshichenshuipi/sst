package com.bo.bean;

public class User {

        //创建用户信息表
        private String user;
        private String password;
        private int phone;


    public User() {
    }

    public User(String user, String password, int phone) {
        this.user = user;
        this.password = password;
        this.phone = phone;
    }

    /**
     * 获取
     * @return user
     */
    public String getUser() {
        return user;
    }

    /**
     * 设置
     * @param user
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取
     * @return phone
     */
    public int getPhone() {
        return phone;
    }

    /**
     * 设置
     * @param phone
     */
    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String toString() {
        return "user{user = " + user + ", password = " + password + ", phone = " + phone + "}";
    }
}
