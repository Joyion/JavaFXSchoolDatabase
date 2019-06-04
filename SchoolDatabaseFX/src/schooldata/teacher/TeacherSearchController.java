package schooldata.teacher;

import com.joyiontimmons.schooldata.SqlDatabase;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class TeacherSearchController {
	
	@FXML
	ComboBox tid;
	
	@FXML 
	TextField fname;
	
	@FXML
	TextField lname;
	
	@FXML
	ListView searchList;
	
	@FXML
	BorderPane outTeacherSearchPnl;
	
	Pane editpane;
	
	FXMLLoader load;
	
	SqlDatabase data = SqlDatabase.getInstance();
	
	
	
	@FXML
	public void search() {
		
	}

}
