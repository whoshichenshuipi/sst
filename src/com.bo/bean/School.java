package com.bo.bean;

public class School {
    private String name;

    private String lander;
    private String address;

    private String createTime;
    private String phone;
    private String phone2;
    private String jianjie;

    public School() {
    }

    public School(String name, String lander, String address, String createTime, String phone, String phone2, String jianjie) {
        this.name = name;
        this.lander = lander;
        this.address = address;
        this.createTime = createTime;
        this.phone = phone;
        this.phone2 = phone2;
        this.jianjie = jianjie;
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
     * @return lander
     */
    public String getLander() {
        return lander;
    }

    /**
     * 设置
     * @param lander
     */
    public void setLander(String lander) {
        this.lander = lander;
    }

    /**
     * 获取
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取
     * @return createTime
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * 设置
     * @param createTime
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取
     * @return phone2
     */
    public String getPhone2() {
        return phone2;
    }

    /**
     * 设置
     * @param phone2
     */
    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    /**
     * 获取
     * @return jianjie
     */
    public String getJianjie() {
        return jianjie;
    }

    /**
     * 设置
     * @param jianjie
     */
    public void setJianjie(String jianjie) {
        this.jianjie = jianjie;
    }

    public String toString() {
        return "School{name = " + name + ", lander = " + lander + ", address = " + address + ", createTime = " + createTime + ", phone = " + phone + ", phone2 = " + phone2 + ", jianjie = " + jianjie + "}";
    }
}
