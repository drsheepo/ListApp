package com.example.listapp;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class HelloController {
    @FXML
    public TextArea Explanation;
    public Label Course;
    public Label Teacher;
    public Label Grade;
    public Label Goal;
    public TextField CourseInput;
    public TextField TeacherInput;
    public TextField GradeInput;
    public TextField GoalInput;
    public Button ListUpdate;
    public Label Notes;
    public Label Introduction;
    public ListView<GradeChecker> listView;
    public TextField NotesBox;
    public Button NewCourse;
    @FXML


    public void initialize() {

        listView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    // oldValue can be null if nothing WAS selected
                    // newValue can be null if nothing IS NOW selected
                    if (newValue != null) {
                        CourseInput.setText(String.valueOf(newValue.getCourse()));
                        TeacherInput.setText(String.valueOf(newValue.getTeacher()));
                        GradeInput.setText(String.valueOf(newValue.getGrade()));
                        GoalInput.setText(String.valueOf(newValue.getGradegoal()));
                    } else {
                        CourseInput.setText("");
                        TeacherInput.setText("");
                        GradeInput.setText("");
                        GoalInput.setText("");
                    }
                });
        if (GradeChecker.getAllData().isEmpty()) {
            try {
// only restore saved Objects ONCE
                GradeChecker.restoreData();
            } catch (Exception ex) {
                System.out.println("NO SAVED OBJECTS WERE RESTORED: " + ex);
            }

            if (GradeChecker.getAllData().isEmpty()) {
                try {
                    // only import films' data if there are NO saved Objects
                    GradeChecker.restoreData();
                    System.out.println("DATA IMPORTED");
                } catch (Exception ex) {
                    System.out.println("DATA NOT IMPORTED: " + ex);
                }
            } else {
                System.out.println("SAVED OBJECTS RESTORED");
            }
        }

        for (GradeChecker eachOne: GradeChecker.getAllData()) {

            listView.getItems().add(eachOne);
        }
    }


    public void ChangeCourse() throws Exception {
        GradeChecker selectedChecker = listView.getSelectionModel().getSelectedItem();
        if (selectedChecker != null) {
            selectedChecker.setCourse(CourseInput.getText());
            listView.refresh();

        }
    }

    public void ChangeTeacher() throws Exception {
        GradeChecker selectedChecker = listView.getSelectionModel().getSelectedItem();
        if (selectedChecker != null) {
            selectedChecker.setTeacher(TeacherInput.getText());
            listView.refresh();

        }

    }

    public void ChangeGrade() throws Exception {
        GradeChecker selectedChecker = listView.getSelectionModel().getSelectedItem();
        if (selectedChecker != null) {
            selectedChecker.setGrade(Float.valueOf(GradeInput.getText()));
            listView.refresh();

        }
    }

    public void ChangeGoal() throws Exception {
        GradeChecker selectedChecker = listView.getSelectionModel().getSelectedItem();
        if (selectedChecker != null) {
            selectedChecker.setGradegoal(Float.valueOf(GoalInput.getText()));
            listView.refresh();

        }

    }


    public void AddNewCourse() throws Exception {
    GradeChecker newOne = new GradeChecker(CourseInput.getText(), TeacherInput.getText(), Float.parseFloat(GradeInput.getText()), Float.parseFloat(GoalInput.getText()));
        listView.getItems().add(newOne);
}

    public void AdjustList() throws Exception {
        GradeChecker selectedChecker = listView.getSelectionModel().getSelectedItem();
        if (selectedChecker != null) {
            System.out.println("1: " + GradeInput.getText());
            System.out.println("2: " + GoalInput.getText());

            if (GradeInput.getText().equalsIgnoreCase(GoalInput.getText())) {
                selectedChecker.setCompleted(true);
            } else {
                selectedChecker.setCompleted(false);

            }
        }

    }

}

