package schooldata.student;

import java.util.ArrayList;

import com.joyiontimmons.schooldata.SqlDatabase;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.collections.*;

public class StudentSearchController  {
	
	@FXML 
	TextField fname;
	
	@FXML 
	TextField lname;
	
	@FXML 
	TextField stid;
	
	@FXML
	Button edit;
	
	@FXML
	ListView searchList;
	
	@FXML
	GridPane studentSearchPnl;
	
	@FXML
	BorderPane outStudentSearchPnl;
	
	Pane editpane;
	
	FXMLLoader load;
	
	SqlDatabase data = SqlDatabase.getInstance();
	
	// you need to put this panel in a Border Panel so you can call Edit Panel from here
	/// and replace it
	
	@FXML
	public void search() throws Exception {
		
		try {;
		ArrayList<Student> studs = data.searchStudents(fname.getText().trim(), lname.getText().trim(), stid.getText().trim());
		ObservableList<Student> students = FXCollections.observableArrayList(studs);
		searchList.setItems(students);
		}
		
		catch (NumberFormatException n)
		{
			System.out.println(n.getMessage());
		}
		
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	
		
	}
	
	@FXML
	public void clickList()
	{
		try {
		Student s = (Student) searchList.getSelectionModel().getSelectedItem();
		data.setStudent(new Student(s.getName(), s.getLastName(), s.getAddress(), s.getCity(), s.getState(), s.getID()));
		System.out.println(s.toString());
		load = new FXMLLoader(getClass().getResource("studentEdit.fxml"));
		editpane = load.load();
		outStudentSearchPnl.setCenter(editpane);
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	

}
