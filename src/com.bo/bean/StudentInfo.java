package com.bo.bean;

public class StudentInfo {
    //创建学生类


    private int num;
    private String name;
    private String gender;
    private int age;
    private String major;
    private String classes;
    private int phone;


    public StudentInfo() {
    }

    public StudentInfo(int num, String name, String gender, int age, String major, String classes, int phone) {
        this.num = num;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.major = major;
        this.classes = classes;
        this.phone = phone;
    }

    /**
     * 获取
     * @return num
     */
    public int getNum() {
        return num;
    }

    /**
     * 设置
     * @param num
     */
    public void setNum(int num) {
        this.num = num;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 获取
     * @return major
     */
    public String getMajor() {
        return major;
    }

    /**
     * 设置
     * @param major
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * 获取
     * @return classes
     */
    public String getClasses() {
        return classes;
    }

    /**
     * 设置
     * @param classes
     */
    public void setClasses(String classes) {
        this.classes = classes;
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
        return "StudentInfo{num = " + num + ", name = " + name + ", gender = " + gender + ", age = " + age + ", major = " + major + ", classes = " + classes + ", phone = " + phone + "}";
    }
}
