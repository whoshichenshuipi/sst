package com.bo.bean;

//创建课程信息表

public class CourseInfo {
    private int num;
    private String name;
    private String course;
    private String credit;

    public CourseInfo() {
    }

    public CourseInfo(int num, String name, String course, String credit) {
        this.num = num;
        this.name = name;
        this.course = course;
        this.credit = credit;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseInfo that = (CourseInfo) o;

        if (num != that.num) return false;
        if (!name.equals(that.name)) return false;
        if (!course.equals(that.course)) return false;
        return credit.equals(that.credit);
    }

    @Override
    public String toString() {
        return "CourseInfo{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", course='" + course + '\'' +
                ", credit='" + credit + '\'' +
                '}';
    }
}
