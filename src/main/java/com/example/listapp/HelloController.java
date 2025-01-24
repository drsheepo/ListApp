package com.example.listapp;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
    public Hyperlink EmailLink;
    public Label Introduction;
    public ListView<GradeChecker> listView;
    public TextField CongratsMessage;

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

    public void DoCongrats() throws Exception {


    }

    public void AdjustList() throws Exception {
        GradeChecker selectedChecker = listView.getSelectionModel().getSelectedItem();
        if (selectedChecker != null) {

            if (GradeInput.getText().equalsIgnoreCase(GoalInput.getText())) {
                selectedChecker.setCompleted(true);
            } else {
                selectedChecker.setCompleted(false);

            }
        }
            GradeChecker newOne = new GradeChecker(CourseInput.getText(), TeacherInput.getText(), Float.parseFloat(GradeInput.getText()), Float.parseFloat(GoalInput.getText()));

        listView.getItems().add(newOne);

    }

}