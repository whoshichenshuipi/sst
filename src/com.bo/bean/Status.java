package com.bo.bean;

public class Status {
    private String name;
    private String author;
    private int version;
    private int phone;
    private String address;
    private String email;

    public Status() {
    }

    public Status(String name, String author, int version, int phone, String address, String email) {
        this.name = name;
        this.author = author;
        this.version = version;
        this.phone = phone;
        this.address = address;
        this.email = email;
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
     * @return author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 设置
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 获取
     * @return version
     */
    public int getVersion() {
        return version;
    }

    /**
     * 设置
     * @param version
     */
    public void setVersion(int version) {
        this.version = version;
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
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return "Status{name = " + name + ", author = " + author + ", version = " + version + ", phone = " + phone + ", address = " + address + ", email = " + email + "}";
    }
}
