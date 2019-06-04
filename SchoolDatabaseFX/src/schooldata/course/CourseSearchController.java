package schooldata.course;

import com.joyiontimmons.schooldata.SqlDatabase;

import javafx.fxml.*;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class CourseSearchController {

	@FXML 
	TextField cname;
	
	@FXML 
	TextField cid;
	
	@FXML
	ListView searchList;
	
	@FXML 
	BorderPane outCourseSearchPnl;
	
	Pane editpane;
	
	FXMLLoader load;
	
	SqlDatabase data = SqlDatabase.getInstance();
	
	@FXML public void search()
	{
		
	}
}
