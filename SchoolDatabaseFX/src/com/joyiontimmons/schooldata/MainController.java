package com.joyiontimmons.schooldata;
import schooldata.course.*;
import schooldata.department.*;
import schooldata.student.*;

 
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class MainController {
	
	@FXML
	private BorderPane mainPnl;
	
	FXMLLoader loader;
	
	Pane infoPnl,
		optionPnl,
		dptAddPnl,
		dptSearchPnl,
		courseAddPnl,
		courseSearchPnl,
		teacherAddPnl,
		teacherSearchPnl,
		studentAddPnl,
		studentSearchPnl,
		enrollmentAddPnl,
		enrollmentSearchPnl,
		gradeAddPnl,
		gradeSearchPnl,
		reportPnl;
		 
		 
		 
	
	
	public MainController() throws Exception {
		
	
	}
	
	@FXML 
	public void infoMenuClicked() throws IOException {
		
	}
	
	@FXML 
	public void optionMenuClicked() throws IOException {
		
	}
	
	@FXML 
	public void departmentAddMenuClicked() throws IOException {
		loader = new FXMLLoader(getClass().getResource("/schooldata/department/departmentAdd.fxml"));
		dptAddPnl = loader.load();
		mainPnl.setCenter(dptAddPnl);
	}
	
	@FXML
	public void departmentSearchMenuClicked() throws IOException {
		loader = new FXMLLoader(getClass().getResource("/schooldata/department/departmentSearch.fxml"));
		dptSearchPnl = loader.load();
		mainPnl.setCenter(dptSearchPnl);
		
	}
	
	@FXML 
	public void courseAddMenuClicked() throws IOException {
		loader = new FXMLLoader(getClass().getResource("/schooldata/course/courseAdd.fxml"));
		courseAddPnl = loader.load();
		mainPnl.setCenter(courseAddPnl);
	}
	
	@FXML 
	public void courseSearchMenuClicked() throws IOException {
		loader = new FXMLLoader(getClass().getResource("/schooldata/course/courseSearch.fxml"));
		courseSearchPnl = loader.load();
		mainPnl.setCenter(courseSearchPnl);
		
	}

	@FXML 
	public void teacherAddMenuClicked() throws IOException {
		loader = new FXMLLoader(getClass().getResource("/schooldata/teacher/teacherAdd.fxml"));
		teacherAddPnl = loader.load();
		mainPnl.setCenter(teacherAddPnl);
	}
	
	@FXML 
	public void teacherSearchMenuClicked() throws IOException {
		loader = new FXMLLoader(getClass().getResource("/schooldata/teacher/teacherSearch.fxml"));
		teacherSearchPnl = loader.load();
		mainPnl.setCenter(teacherSearchPnl);
		
	}
	
	
	@FXML
	public void studentAddMenuClicked() throws IOException {
		loader = new FXMLLoader(getClass().getResource("/schooldata/student/studentAdd.fxml"));
		studentAddPnl = loader.load();
		mainPnl.setCenter(studentAddPnl);
	}
	
	@FXML
	public void studentSearchMenuClicked() throws IOException {
		loader = new FXMLLoader(getClass().getResource("/schooldata/student/studentSearch.fxml"));
		studentSearchPnl = loader.load();
		mainPnl.setCenter(studentSearchPnl);
		
	}
	
	@FXML 
	public void enrollmentAddMenuClicked() throws IOException {
		loader = new FXMLLoader(getClass().getResource("/schooldata/enrollment/enrollmentAdd.fxml"));
		enrollmentAddPnl = loader.load();
		mainPnl.setCenter(enrollmentAddPnl);
	}
	
	@FXML 
	public void enrollmentSearchMenuClicked() throws IOException {
		loader = new FXMLLoader(getClass().getResource("/schooldata/enrollment/enrollmentSearch.fxml"));
		enrollmentSearchPnl = loader.load();
		mainPnl.setCenter(enrollmentSearchPnl);
		
	}
	
	@FXML 
	public void gradeAddMenuClicked() throws IOException {
		loader = new FXMLLoader(getClass().getResource("/schooldata/grade/gradeAdd.fxml"));
		gradeAddPnl = loader.load();
		mainPnl.setCenter(gradeAddPnl);
	}
	
	@FXML 
	public void gradeSearchMenuClicked() throws IOException {
		loader = new FXMLLoader(getClass().getResource("/schooldata/grade/gradeSearch.fxml"));
		gradeSearchPnl = loader.load();
		mainPnl.setCenter(gradeSearchPnl);
		
	}
	
	@FXML 
	public void reportMenuClicked() throws IOException {
		loader = new FXMLLoader(getClass().getResource("/schooldata/report/report.fxml"));
		reportPnl = loader.load();
		mainPnl.setCenter(reportPnl);
		
	}
	


}
