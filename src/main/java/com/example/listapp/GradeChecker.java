package com.example.listapp;

public class GradeChecker {
    String course;
    String teacher;
    Float grade;
    Float gradegoal;

    public GradeChecker(String course, String teacher, Float grade, Float gradegoal) {
        this.course = course;
        this.teacher = teacher;
        this.grade = grade;
        this.gradegoal = gradegoal;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public Float getGrade() {
        return grade;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }

    public Float getGradegoal() {
        return gradegoal;
    }

    public void setGradegoal(Float gradegoal) {
        this.gradegoal = gradegoal;
    }

}
