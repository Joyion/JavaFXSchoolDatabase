package schooldata.enrollment;

import com.joyiontimmons.schooldata.SqlDatabase;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class EnrollmentSearchController {
	
	@FXML 
	TextField stid;
	
	@FXML 
	TextField cid;
	
	@FXML
	ComboBox year;
	
	@FXML 
	ComboBox semester;
	
	@FXML 
	ListView searchList;
	
	@FXML
	BorderPane outEnrollmentSearchPnl;
	
	Pane editpane;
	
	FXMLLoader load;
	
	SqlDatabase data = SqlDatabase.getInstance();
	
	public void search() {
		
	}

}
