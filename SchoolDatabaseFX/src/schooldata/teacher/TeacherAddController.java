package schooldata.teacher;

import java.util.ArrayList;

import com.joyiontimmons.schooldata.SqlDatabase;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import schooldata.department.Department;

public class TeacherAddController {
	
	@FXML
	TextField tid;
	
	@FXML 
	TextField fname;
	
	@FXML
	TextField lname;
	
	@FXML 
	TextField email;
	
	@FXML 
	TextField phone;
	
	@FXML
	ComboBox dptid;
	
	SqlDatabase data = SqlDatabase.getInstance();
	
	public void initialize() {
		Department base = new Department("Other", 0, 0);
		ArrayList<Department> dptlist = new ArrayList<Department>();
		dptlist.add(base);
		ObservableList<Department> departmentsbase = FXCollections.observableArrayList(dptlist);
		dptid.getItems().addAll(departmentsbase);
	}

	@FXML
	public void add() {
		try {
		
			data.addTeacher(tid.getText(), "1", fname.getText(), lname.getText(), email.getText(), phone.getText());
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
}
