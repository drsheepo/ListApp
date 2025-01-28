package com.example.listapp;

import java.io.*;
import java.util.ArrayList;

public class GradeChecker implements Serializable {
    String course;
    String teacher;
    Float grade;
    Float gradegoal;

    public static ArrayList<GradeChecker> getAllData() {
        return allData;
    }

    public static void setAllData(ArrayList<GradeChecker> allData) {
        GradeChecker.allData = allData;
    }

    static ArrayList<GradeChecker> allData = new ArrayList<GradeChecker>();

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    boolean completed;

    public GradeChecker(String course, String teacher, Float grade, Float gradegoal) {
        this.course = course;
        this.teacher = teacher;
        this.grade = grade;
        this.gradegoal = gradegoal;
        allData.add(this);
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

    @Override
    public String toString() {
        if (completed) {
            return " Congrats!! You have acheived your grade goal for " + getCourse() + " . " ;

        } else {
            return " This class is " + getCourse() + " and your teacher is " + getTeacher() + ". Your current grade is " + getGrade() + " and your goal is to get a " + getGradegoal() + " . ";
        }

    }
    static void saveData() throws Exception {
        FileOutputStream fileOut = new FileOutputStream("PcSave");
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        objectOut.writeObject(GradeChecker.allData);
        objectOut.close();
        fileOut.close();

    }
    static void restoreData() throws Exception {
        FileInputStream fileIn = new FileInputStream("PcSave");
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        GradeChecker.allData = (ArrayList<GradeChecker>) objectIn.readObject();
        objectIn.close();
        fileIn.close();
    }

}
